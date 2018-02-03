package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.MoveElevator;
//import org.usfirst.frc.team360.robot.commands.ShiftDown;
//import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frs.team360.robot.commands.color.LEDBlue;
import org.usfirst.frs.team360.robot.commands.color.LEDBluePulse;
import org.usfirst.frs.team360.robot.commands.color.LEDGreen;
import org.usfirst.frs.team360.robot.commands.color.LEDOrange;
import org.usfirst.frs.team360.robot.commands.color.LEDPulse;
import org.usfirst.frs.team360.robot.commands.color.LEDRed;
import org.usfirst.frs.team360.robot.commands.color.LEDYellow;

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
	 
	 public static Button redLED = new JoystickButton(joyR, 5);
	 public static Button blueLED = new JoystickButton(joyR, 6);
	 public static Button yellowLED = new JoystickButton(joyR, 7);
	 public static Button greenLED = new JoystickButton(joyR, 8);
	 public static Button pulseLED = new JoystickButton(joyR, 9);
	 public static Button orangeLED = new JoystickButton(joyR, 10);
	 public static Button pulseBlueLED = new JoystickButton(joyR, 11);
	 
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
			
			redLED.whenPressed(new LEDRed());
			blueLED.whenPressed(new LEDBlue());
			yellowLED.whenPressed(new LEDYellow());
			greenLED.whenPressed(new LEDGreen());
			pulseLED.whenPressed(new LEDPulse());
			orangeLED.whenPressed(new LEDOrange());
			pulseBlueLED.whenPressed(new LEDBluePulse());
	 }
}
