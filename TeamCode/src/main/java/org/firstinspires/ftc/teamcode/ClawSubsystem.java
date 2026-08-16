package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class ClawSubsystem {
    private Servo claw;

    public static boolean clawOpen = false;


    public ClawSubsystem(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw" );
    }

    public void OpenClaw(){
        claw.setPosition(Constants.ClawConstants.CLAW_OPEN_POSITION);
    }

    public void CloseClaw(){
        claw.setPosition(Constants.ClawConstants.CLAW_CLOSED_POSITION);
    }


}
