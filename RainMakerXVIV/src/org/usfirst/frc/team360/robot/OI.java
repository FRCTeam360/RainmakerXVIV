package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	 public static Joystick joyR = new Joystick(0);
	 public static Joystick joyL = new Joystick(1);
	 public static Joystick joyOI = new Joystick(2); 
	 
	 public static Button buttonDriveDown = new JoystickButton(joyL, 1);
	 public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	 
	 public static Button buttonWinchUp = new JoystickButton(joyOI, 1);
	 public static Button buttonWinchDown = new JoystickButton(joyOI, 3);
	 
	 public OI() {
			buttonDriveUp.whenPressed(new ShiftUp());
			buttonDriveDown.whenPressed(new ShiftDown());
			buttonWinchUp.whileHeld(new RunWinchUp());
			buttonWinchDown.whileHeld(new RunWinchDown());
	 }
}
