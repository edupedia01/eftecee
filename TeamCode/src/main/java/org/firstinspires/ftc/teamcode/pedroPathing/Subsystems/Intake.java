package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;

import static com.pedropathing.ivy.commands.Commands.*;

public class Intake {
    private Mode mode = Mode.OFF;
    public static double onPower = 1;
    public static double offPower = 0;
    public static double reversePower = -1;
    public static double shortReverseTimeMs = 150;

    private final DcMotorEx intakeMotor;

    private final Telemetry telemetry;

    public Intake(Robot robot) {
        // de verificat numele de import si daca e de adaugat motor de transfer.
        intakeMotor = robot.hardwareMap.get(DcMotorEx.class, "intake");
        telemetry = robot.telemetry;
    }

    public Command on() {
        return instant(() -> mode = Mode.ON).requiring(intakeMotor);
    }

    public Command off() {
        return instant(() -> mode = Mode.OFF).requiring(intakeMotor);
    }

    public Command reverse() {
        return instant(() -> mode = Mode.REVERSE).requiring(intakeMotor);
    }

    public Command periodic() {
        return infinite(() -> {
            switch (mode) {
                case ON:
                    intakeMotor.setPower(onPower);
                    break;
                case OFF:
                    intakeMotor.setPower(offPower);
                    break;
                case REVERSE:
                    intakeMotor.setPower(reversePower);
                    break;
            }

            telemetry.addData("Putere intake", intakeMotor.getCurrent(CurrentUnit.MILLIAMPS));
            telemetry.addData("Velocity intake", intakeMotor.getVelocity());
        });
    }

    enum Mode {
        ON,
        OFF,
        REVERSE
    }
}