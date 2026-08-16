package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {
    private DcMotor BL;
    private DcMotor FL;
    private DcMotor BR;
    private DcMotor FR;

    private double mForward;
    private double mStrafe;
    private double mTurn;
    private boolean mSlowmode = false;

    public DriveSubsystem(HardwareMap hardwareMap){
      BL = hardwareMap.get(DcMotor.class, "BL");
      FL = hardwareMap.get(DcMotor.class, "FL");
      BR = hardwareMap.get(DcMotor.class, "BR");
      FR = hardwareMap.get(DcMotor.class, "FR");

      BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

      BL.setDirection(DcMotor.Direction.REVERSE);
      FL.setDirection(DcMotor.Direction.REVERSE);
    }

    public void updateInputs(double newForward, double newStrafe, double newTurn){
        mForward = newForward;
        mStrafe = newStrafe;
        mTurn = newTurn;
    }
    public void update(){
        double speedCapFactor;
        speedCapFactor = 1 / (Math.abs(mForward) + Math.abs(mStrafe) + Math.abs(mTurn));
        BL.setPower((mForward + mStrafe + mTurn) * speedCapFactor);
        FL.setPower((mForward - mStrafe + mTurn) * speedCapFactor);
        BR.setPower((mForward - mStrafe - mTurn) * speedCapFactor);
        FR.setPower((mForward + mStrafe - mTurn) * speedCapFactor);

    }

}
