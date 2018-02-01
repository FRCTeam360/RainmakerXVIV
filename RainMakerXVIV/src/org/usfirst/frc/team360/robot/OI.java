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
	 public static Button buttonWinchDown = new JoystickButton(joyOI, 2);
	 
	 public static Button buttonIntake = new JoystickButton(joyOI, 3);
	 public static Button buttonOutTake = new JoystickButton(joyOI, 4);
	 
	 public static Button redLED = new JoystickButton(joyR, 5);
	 public static Button blueLED = new JoystickButton(joyR, 6);
	 public static Button yellowLED = new JoystickButton(joyR, 7);
	 public static Button greenLED = new JoystickButton(joyR, 8);
	 public static Button pulseLED = new JoystickButton(joyR, 9);
	 public static Button orangeLED = new JoystickButton(joyR, 10);
	 public static Button pulseBlueLED = new JoystickButton(joyR, 11);
	 
	 public OI() {
			buttonDriveUp.whenPressed(new ShiftUp());
			buttonDriveDown.whenPressed(new ShiftDown());
			
			buttonWinchUp.whileHeld(new RunWinchUp());
			buttonWinchDown.whileHeld(new RunWinchDown());
			
			buttonIntake.whileHeld(new IntakeIn());
			buttonOutTake.whileHeld(new IntakeOut());
			
			redLED.whenPressed(new LEDRed());
			blueLED.whenPressed(new LEDBlue());
			yellowLED.whenPressed(new LEDYellow());
			greenLED.whenPressed(new LEDGreen());
			pulseLED.whenPressed(new LEDPulse());
			orangeLED.whenPressed(new LEDOrange());
			pulseBlueLED.whenPressed(new LEDBluePulse());
	 }
}
