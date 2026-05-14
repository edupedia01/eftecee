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
    double GEAR_RATIO = 4; // aceasta valoare trb schimbata si ea cel mai probabil.
    int position;
    double revolutions;
    double angle;
    double angleN; // angle normalized.

    public TurretAngle(Robot robot){
        turretMotor = robot.hardwareMap.get(DcMotorEx.class, "turret");
        telemetry = robot.telemetry;
    }

    public double GetTurretAngle(){
        // motor pos
        double position = turretMotor.getCurrentPosition();
        double totalDegrees = (position / (CPR * GEAR_RATIO)) * 360.0;

        double angleN = totalDegrees % 360;
        if (angleN < 0) {
            angleN += 360;
        }

        return angleN;
    }

    public double GetTicksFromAngle(double turretAngle){
        return (int)((turretAngle / 360.0) * CPR * GEAR_RATIO);
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
