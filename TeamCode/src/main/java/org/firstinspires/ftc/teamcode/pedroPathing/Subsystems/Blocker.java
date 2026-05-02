package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

import static com.pedropathing.ivy.commands.Commands.*;

public class Blocker {
    private Mode mode = Mode.BLOCK;
    public static double blockPosition = 0.650;
    public static double unblockPosition = 0.475;
    private final Servo blockerServo;
    private final Telemetry telemetry;

    public Blocker(Robot robot) { blockerServo = robot.hardwareMap.get(Servo.class, "blocker");
        telemetry = robot.telemetry;
    }

    public Command block() {
        return instant(() -> mode = Mode.BLOCK).requiring(blockerServo);

    }

    public Command unblock() {
        return instant(() -> mode = Mode.UNBLOCK).requiring(blockerServo);
    }

    public Command periodic() {
        return infinite(() -> {
            switch (mode) {
                case BLOCK:
                    blockerServo.setPosition(blockPosition);
                    break;
                case UNBLOCK:
                    blockerServo.setPosition(unblockPosition);
                    break;
            }

            telemetry.addData("BLOCKER: ", mode);
        });
    }

    enum Mode {
        BLOCK,
        UNBLOCK,
    }

}
