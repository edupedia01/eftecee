package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

//import static org.firstinspires.ftc.teamcode.pedroPathing.Auto.Tuning.follower;

import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

import java.lang.Math;

public class Turret {
    private final DcMotorEx turret;
    private final Telemetry telemetry;
    double Xrobot, Yrobot, Hrobot; // sus/jos, stanga/dreapta, heading
    private Pose currentPose;

    public Turret(Robot robot){
        turret = robot.hardwareMap.get(DcMotorEx.class, "turret");
        telemetry = robot.telemetry;
//        Pose currentPose = follower.getPose();
    }
    public void getTurretPos(){
        Xrobot = currentPose.getX();
        Yrobot = currentPose.getY();
    }
}