package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.control.PIDFController;
import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Command;
//import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Auto.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

import static com.pedropathing.ivy.commands.Commands.infinite;
//import static com.pedropathing.ivy.pedro.PedroCommands.follow;

public class Drivetrain {
    // modificat pidf. <----
    public static PIDFCoefficients headingCoefficients = new PIDFCoefficients(0, 0, 0, 0);
    public final DcMotorEx frontLeft;
    public final DcMotorEx frontRight;
    public final DcMotorEx backLeft;
    public final DcMotorEx backRight;
    public final Follower follower;
    private final Telemetry telemetry;
    private final PIDFController headingController = new PIDFController(headingCoefficients);
    public Drivetrain(Robot robot) {
        follower = Constants.createFollower(robot.hardwareMap);
        frontLeft = robot.hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = robot.hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = robot.hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = robot.hardwareMap.get(DcMotorEx.class, "backRight");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry = robot.telemetry;
    }

    public void arcadeDrive(double forward, double strafe, double turn) {
        strafe = strafe * 1.1; // Counteract imperfect strafing
        double frontLeftPower = (forward + strafe + turn) ;
        double backLeftPower = (forward - strafe + turn) ;
        double frontRightPower = (forward - strafe - turn);
        double backRightPower = (forward + strafe - turn);

        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    public Command periodic() {
        return infinite(() -> {
            follower.update();

            telemetry.addData("Current X", follower.getPose().getX());
            telemetry.addData("Current Y", follower.getPose().getY());
        });
    }
}