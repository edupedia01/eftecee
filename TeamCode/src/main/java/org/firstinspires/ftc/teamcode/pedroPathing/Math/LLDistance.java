package org.firstinspires.ftc.teamcode.pedroPathing.Math;

import static com.pedropathing.ivy.commands.Commands.infinite;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

// ll imports
import com.pedropathing.ivy.Command;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

public class LLDistance {
    Limelight3A limelight;
    private LLResult result;
    private final double ty;

    public LLDistance(Robot robot){
        limelight = robot.hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        LLResult result = limelight.getLatestResult();
        ty = result.getTy();
    }
    public double getLLdistance() {
        // trebuie inlocuite !!! <-----
        // ty.getDouble(0.0) ?
        double limelightMountAngleDegrees = 25.0;
        double limelightLensHeightInches = 20.0;

        double goalHeightInches = 60.0;

        double angleToGoalDegrees = limelightMountAngleDegrees + result.getTy();
        double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

        // final result
        return (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
    }
}
