package org.firstinspires.ftc.teamcode.pedroPathing.Subsystems;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.commands.Commands;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.Robot;
import com.qualcomm.robotcore.util.ElapsedTime;
import static com.pedropathing.ivy.commands.Commands.*;
import org.firstinspires.ftc.teamcode.pedroPathing.Subsystems.*;


public class Outtake {
    private final Telemetry telemetry;
    private final DcMotorEx outtake1;
    private final DcMotorEx outtake2;
    private static double maxPower = 1;
    private static double ramp = 0.02;
    ElapsedTime time = new ElapsedTime();


    public Outtake(Robot robot){
        time.reset();
        outtake1 = robot.hardwareMap.get(DcMotorEx.class, "motorLauncher");
        outtake2 = robot.hardwareMap.get(DcMotorEx.class, "motorLauncher2");
        telemetry = robot.telemetry;
    }

    public Command on(){
        return instant(() -> {
            if(time.time() == 0) time.reset();
            if (time.seconds() >= ramp){
                outtake1.setPower(maxPower);
                outtake2.setPower(maxPower); // cod scris de mine trust
                time.reset();
            }
        });
    }
    public Command off(){
        return instant(() -> {
            outtake1.setPower(0);
            outtake2.setPower(0);
        });
    }
}
