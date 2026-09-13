package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class elasticsSubsystem {
    private DcMotor leftElasticMotor;

    private DcMotor rightElasticMotor;

    // PID Variables





    public elasticsSubsystem(HardwareMap hardwareMap) {

        leftElasticMotor = hardwareMap.get(DcMotor.class, "Lelastic");

        leftElasticMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftElasticMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightElasticMotor = hardwareMap.get(DcMotor.class, "Relastic");

        rightElasticMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightElasticMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




    }

    private double mTarget = 0;

    public void setTarget(double newTarget) {
        mTarget = newTarget;
    }

    public void updatePower() {

        double position = leftElasticMotor.getCurrentPosition();

        double error = mTarget - position;

        double power = error * Constants.ArmConstants.ELASTIC_KP;

        leftElasticMotor.setPower(power);
        rightElasticMotor.setPower(-power);
    }




    public double getTarget() {
        return mTarget;
    }

    public int getPosition() {
        return leftElasticMotor.getCurrentPosition();
    }

}