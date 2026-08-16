package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {
    private DcMotor armMotor;

    // PID Variables





    public ArmSubsystem(HardwareMap hardwareMap) {

        armMotor = hardwareMap.get(DcMotor.class, "arm");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




    }

    private double mTarget = 0;

    public void setTarget(double newTarget) {
        mTarget = newTarget;
    }

    public void updatePower() {

        double position = armMotor.getCurrentPosition();

        double error = mTarget - position;

        double power = error * Constants.ArmConstants.ARM_KP;

        armMotor.setPower(power);
    }

    public double square(double number){
        return number * number;
    }



    public double getTarget() {
        return mTarget;
    }

    public int getPosition() {
        return armMotor.getCurrentPosition();
    }

}