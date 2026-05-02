package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;// note for me: Deci pui cum e pe tapesensor pe gh la code-blodded. adica

import static com.pedropathing.ivy.commands.Commands.infinite;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;


public class SensorTouch {

    TouchSensor touchSensor;

    public final Telemetry telemetry;

    public SensorTouch(Robot robot){
        touchSensor = robot.hardwareMap.get(TouchSensor.class, "touch");
        telemetry = robot.telemetry;
    }

    public boolean getTouched(){
        return touchSensor.isPressed();
    }

    public Command periodic() {
        return infinite(() -> {
            if (touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Is Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Is Not Pressed");
            }
        });
    }
}