package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.pedroPathing.Subsystems.*;

@TeleOp(name = "TeleOp", group = "Competition")
public class ActualTeleOp extends Init {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
//        robot.blocker.block().schedule();
        robot.intake.on().schedule();
    }

    @Override
    public void loop() {
        // aici pui toate toate chestile controale si alte prostii pentru outtake, turret, blocker, etc.

        // ---- INTAKE SI BLOCKER----
        if (gamepad1.rightBumperWasPressed()) robot.intake.on().schedule();
        if (gamepad1.rightBumperWasReleased()) robot.intake.off().schedule();
//        if (gamepad1.leftBumperWasPressed()) robot.blocker.unblock().schedule();
//        if (gamepad1.leftBumperWasReleased()) robot.blocker.block().schedule();
//        if (gamepad1.leftTriggerWasPressed()) robot.blocker.unblock().schedule();
//        if (gamepad1.leftTriggerWasReleased()) robot.blocker.block().schedule();
        if (gamepad1.rightTriggerWasPressed()) robot.outtake.on().schedule();
        if (gamepad1.rightTriggerWasPressed()) robot.intake.on().schedule();
        if (gamepad1.rightTriggerWasReleased()) robot.outtake.off().schedule();
        if (gamepad1.rightTriggerWasReleased()) robot.intake.off().schedule();


        robot.drivetrain.arcadeDrive(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );


        super.loop();
    }
}