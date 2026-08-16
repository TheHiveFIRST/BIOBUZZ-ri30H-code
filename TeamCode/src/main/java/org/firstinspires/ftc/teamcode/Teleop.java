package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ArmSubsystem arm = new ArmSubsystem(hardwareMap);


        DriveSubsystem chassis;

        chassis= new DriveSubsystem(hardwareMap);


        ClawSubsystem claw = new ClawSubsystem(hardwareMap);






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


            if (gamepad1.x) {
                claw.CloseClaw();
            } else {
                claw.OpenClaw();
            }



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