package org.firstinspires.ftc.teamcode.pedroPathing.RobotMath;

import static com.pedropathing.ivy.commands.Commands.infinite;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

public class TurretAngle {
    private final DcMotorEx turretMotor;
    private final Telemetry telemetry;

    double CPR = 103.8; // count per revolution, pt 5203 1620 RPM. schimba daca e alt motor
    int position;
    double revolutions;
    double angle;
    double angleN; // angle normalized.

    public TurretAngle(Robot robot){
        turretMotor = robot.hardwareMap.get(DcMotorEx.class, "turret");
        telemetry = robot.telemetry;
    }

    public void GetTurretAngle(){
        // motor pos
        position = turretMotor.getCurrentPosition();
        revolutions = position/CPR;

        angle = revolutions * 360;
        angleN = angle % 360;
    }

    public Command periodic(){
        return infinite(() -> {
            telemetry.addData("Encoder Position", position);
            telemetry.addData("Encoder Revolutions", revolutions);
            telemetry.addData("Encoder Angle (Degrees)", angle);
            telemetry.addData("Encoder Angle - Normalized (Degrees)", angleN);
            telemetry.update();
    });
}
}
