/// de schimbat constantele pentru noul robot.

package org.firstinspires.ftc.teamcode.pedroPathing.Auto;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Configurable
public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants().mass(13)
            .forwardZeroPowerAcceleration(-31.820188325622837)
            .lateralZeroPowerAcceleration( -60.05540690240813)
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1,0,0.015,0.01))
            .secondaryTranslationalPIDFCoefficients(new PIDFCoefficients(0.15,0,0.01,0.01))
            .headingPIDFCoefficients(new PIDFCoefficients(1.2,0,0.03,0.01))
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(0.6,0,0.1,0.01))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.01,0.0,0.001,0.6,0.0))
            .secondaryDrivePIDFCoefficients(new FilteredPIDFCoefficients(0.01,0.0,0.001,0.6,0.0))
            .centripetalScaling(0.0005);
    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 2.2, 1.2);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .pinpointLocalizer(localizerConstants)
                .mecanumDrivetrain(driveConstants)
                .build();
    }
    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("rightFront")
            .rightRearMotorName("rightBack")
            .leftRearMotorName("leftBack")
            .leftFrontMotorName("leftFront")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .useBrakeModeInTeleOp(true)
            .xVelocity(75.9154081569882)
            .yVelocity(64.66782457246555);


    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(-1.96)
            .strafePodX(-6.88)
            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);
}