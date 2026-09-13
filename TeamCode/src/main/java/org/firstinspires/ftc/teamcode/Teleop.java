package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        elasticsSubsystem arm = new elasticsSubsystem(hardwareMap);


        DriveSubsystem chassis;

        chassis= new DriveSubsystem(hardwareMap);


        LatchSubsystem claw = new LatchSubsystem(hardwareMap);






        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Preset Positions

            if (gamepad1.a)
                arm.setTarget(Constants.ArmConstants.ARM_IN_POSITION);

            if (gamepad1.b)
                arm.setTarget(Constants.ArmConstants.ARM_DOWN_POSITION);

            if (gamepad1.y)
                arm.setTarget(Constants.ArmConstants.ARM_UP_POSITION);






            chassis.updateInputs(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            // Run the PID every loop
            arm.updatePower();

            chassis.update();

            // Telemetry
            telemetry.addData("Target", arm.getTarget());
            telemetry.addData("Position", arm.getPosition());

            telemetry.update();
        }
    }
}