package org.usfirst.frc.team360.robot;

//import org.usfirst.frc.team360.robot.commands.MoveElevator;
//import org.usfirst.frc.team360.robot.commands.ShiftDown;
//import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	 public static Joystick joyR = new Joystick(0);
	 public static Joystick joyL = new Joystick(1);
	 public static Joystick joyOI = new Joystick(2); 
	 
	 //public static Button buttonDriveDown = new JoystickButton(joyL, 1);
	 //public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	 public static Button buttonElevIntake = new JoystickButton(joyR, 3);
	 public static Button buttonElevSwitch = new JoystickButton(joyR, 4);
	 public static Button buttonElevMidSc = new JoystickButton(joyR, 5);
	 public static Button buttonElevTopSc = new JoystickButton(joyR, 6);
	 public static Button buttonElev25 = new JoystickButton(joyR, 3);
	 public static Button buttonElev50 = new JoystickButton(joyR, 4);
	 public static Button buttonElev75 = new JoystickButton(joyR, 5);
	 public static Button buttonElev100 = new JoystickButton(joyR, 6);
	 
	 public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	 public static Button buttonDriveDown = new JoystickButton(joyL, 1);
	 
	 public static Button buttonIntake = new JoystickButton(joyOI, 3);
	 public static Button buttonOutTake = new JoystickButton(joyOI, 4);
	 public static Button pulsingIntake = new JoystickButton(joyOI, 5);
	 
	 public static Button buttonWinchUp = new JoystickButton(joyOI, 1);
	 public static Button buttonWinchDown = new JoystickButton(joyOI, 2);
	 
	 public OI() {
		 
		 	buttonDriveUp.whenPressed(new ShiftUp());
			buttonDriveDown.whenPressed(new ShiftDown());
			
			buttonElevIntake.whenPressed(new MoveElevator(RobotMap.intakePos));
			buttonElevSwitch.whenPressed(new MoveElevator(RobotMap.switchHeight));
			buttonElevMidSc.whenPressed(new MoveElevator(RobotMap.midScale));
			buttonElevTopSc.whenPressed(new MoveElevator(RobotMap.topScale));
			
			buttonWinchUp.whileHeld(new RunClimberUp());
			buttonWinchDown.whileHeld(new RunClimberDown());
			
			buttonIntake.whileHeld(new IntakeIn());
			buttonOutTake.whileHeld(new IntakeOut());
			pulsingIntake.whileHeld(new IntakeWithPulsingMotor());
			
	 }
}
