package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class IntakeSubsystem {
    private DcMotor leftIntakeMotor;
    private DcMotor rightIntakeMotor;

    public IntakeSubsystem(HardwareMap hardwareMap){
        leftIntakeMotor = hardwareMap.get(DcMotor.class, "Lintake");
        rightIntakeMotor = hardwareMap.get(DcMotor.class, "Rintake");
    }

    public void spin(){
       leftIntakeMotor.setPower(1);
       rightIntakeMotor.setPower(-1);
    }

    public void stop(){
        leftIntakeMotor.setPower(0);
        rightIntakeMotor.setPower(0);
    }

    public void outtake(){
        leftIntakeMotor.setPower(-1);
        rightIntakeMotor.setPower(1);
    }
}
