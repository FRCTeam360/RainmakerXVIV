package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.ShiftDown;
import org.usfirst.frc.team360.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	 public static Joystick joyR = new Joystick(0);
	 public static Joystick joyL = new Joystick(1);
	 public static Joystick joyOI = new Joystick(2); 
	 
	 public static Button buttonDriveDown = new JoystickButton(joyL, 1);
	 public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	 
	 public OI() {
			buttonDriveUp.whenPressed(new ShiftUp());
			buttonDriveDown.whenPressed(new ShiftDown());
	 }
}
