package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import static com.pedropathing.ivy.Scheduler.schedule;

public abstract class Init extends OpMode {
    protected Robot robot; // robot.java class

    @Override
    public void init() {
        Scheduler.reset();
        robot = new Robot(this);


        // pus aici subsysteme cu periodic command/ periodic telemetry
        schedule(
                robot.drivetrain.periodic(),
//                robot.flywheel.periodic(),
//                robot.turret.periodic(),
                robot.intake.periodic()
//                robot.sensorTouch.periodic(),
//                robot.turretAngle.periodic(),
//                robot.blocker.periodic()
        );
    }

    @Override
    public void init_loop() {
        Scheduler.execute();
    }

    @Override
    public void loop() {
        Scheduler.execute();
        robot.telemetry.update();
    }
}