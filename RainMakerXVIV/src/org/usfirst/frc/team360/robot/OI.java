package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.MoveElevator;
//import org.usfirst.frc.team360.robot.commands.ShiftDown;
//import org.usfirst.frc.team360.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	 public static Joystick joyR = new Joystick(0);
	 public static Joystick joyL = new Joystick(1);
	 public static Joystick joyOI = new Joystick(2); 
	 
	 //public static Button buttonDriveDown = new JoystickButton(joyL, 1);
	 //public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	 public static Button buttonElev25 = new JoystickButton(joyR, 3);
	 public static Button buttonElev50 = new JoystickButton(joyR, 4);
	 public static Button buttonElev75 = new JoystickButton(joyR, 5);
	 public static Button buttonElev100 = new JoystickButton(joyR, 6);
	 
	 public static Button buttonWinchUp = new JoystickButton(joyOI, 1);
	 public static Button buttonWinchDown = new JoystickButton(joyOI, 2);
	 
	 public static Button buttonIntake = new JoystickButton(joyOI, 3);
	 public static Button buttonOutTake = new JoystickButton(joyOI, 4);
	 public OI() {
			//buttonDriveUp.whenPressed(new ShiftUp());
			//buttonDriveDown.whenPressed(new ShiftDown());
			
			buttonElev25.whenPressed(new MoveElevator(25));
			buttonElev50.whenPressed(new MoveElevator(50));
			buttonElev75.whenPressed(new MoveElevator(75));
			buttonElev100.whenPressed(new MoveElevator(100));
			
			buttonDriveUp.whenPressed(new ShiftUp());
			buttonDriveDown.whenPressed(new ShiftDown());
			
			buttonWinchUp.whileHeld(new RunWinchUp());
			buttonWinchDown.whileHeld(new RunWinchDown());
			
			buttonIntake.whileHeld(new IntakeIn());
			buttonOutTake.whileHeld(new IntakeOut());
	 }
}
