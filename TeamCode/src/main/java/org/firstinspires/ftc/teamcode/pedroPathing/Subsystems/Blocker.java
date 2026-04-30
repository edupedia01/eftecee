package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

public class Blocker {
    public static double blockPosition = 0.650;
    public static double unblockPosition = 0.475;
    private final Servo blockerServo;

    public Blocker(Robot robot) { blockerServo = robot.hardwareMap.get(Servo.class, "blocker"); }

    public Command block() {
        return instant(() -> blockerServo.setPosition(blockPosition)).requiring(blockerServo); }

    public Command unblock() {
        return instant(() -> blockerServo.setPosition(unblockPosition)).requiring(blockerServo); }

}
