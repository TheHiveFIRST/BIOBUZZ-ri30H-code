package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class LatchSubsystem {
    private Servo leftLatch;
    private Servo rightLatch;

    public static boolean clawOpen = false;


    public LatchSubsystem(HardwareMap hardwareMap) {
        leftLatch = hardwareMap.get(Servo.class, "Llatch" );
        rightLatch = hardwareMap.get(Servo.class, "Rlatch" );
    }

    public void Unlock(){
        leftLatch.setPosition(Constants.ClawConstants.LATCH_OPENED_POSITION);
        rightLatch.setPosition(Constants.ClawConstants.LATCH_OPENED_POSITION);
    }

    public void Lock(){
        leftLatch.setPosition(Constants.ClawConstants.LATCH_LOCKED_POSITION);
        rightLatch.setPosition(Constants.ClawConstants.LATCH_LOCKED_POSITION);
    }


}
