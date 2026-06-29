package org.firstinspires.ftc.teamcode.pedroPathing;

import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Subsystems.*;
import org.firstinspires.ftc.teamcode.pedroPathing.RobotMath.*;


// so like, aici dai scrii toate piesle.

public class Robot {
    public final HardwareMap hardwareMap;
    public final Telemetry telemetry;

    // init susbysteme
    public final Intake intake;

    public final Drivetrain drivetrain;
//    public final Flywheel flywheel;
//    public final Blocker blocker;
//    public final Turret turret;
//    public final SensorTouch sensorTouch;
//    public final TurretAngle turretAngle;
    public final Outtake outtake;

    public Robot(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = PanelsTelemetry.INSTANCE.getFtcTelemetry();

        drivetrain = new Drivetrain(this);
        intake = new Intake(this);
//        flywheel = new Flywheel(this);
//        blocker = new Blocker(this);
//        turret = new Turret(this);
//        sensorTouch = new SensorTouch(this);
        outtake = new Outtake(this);
        // math telemetry
//        turretAngle = new TurretAngle(this);
    }
}