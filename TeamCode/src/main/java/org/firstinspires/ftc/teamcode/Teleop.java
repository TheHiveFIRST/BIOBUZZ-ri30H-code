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

        IntakeSubsystem intake = new IntakeSubsystem(hardwareMap);






        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Intake controls

            if (gamepad1.left_trigger_pressed) {
                intake.spin();
            } else if (gamepad1.b){
                intake.outtake();
            } else {
                intake.stop();
            }

            //elastics controls

            if(gamepad1.rightTriggerWasReleased()) {
                arm.setTarget(Constants.ArmConstants.ELASTIC_RELAXED_POSITION);
            }

            if(Math.abs(arm.getPosition()-Constants.ArmConstants.ELASTIC_RELAXED_POSITION) < 20){
                arm.setTarget(Constants.ArmConstants.ELASTIC_TENSE_POSITION);
                claw.Lock();
            }

            //latch controls

            if(gamepad1.right_trigger_pressed){
                claw.Unlock();
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