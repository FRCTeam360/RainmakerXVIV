package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frc.team360.robot.commands.triggers.JoystickAxisButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick joyR = new Joystick(0);
	public static Joystick joyL = new Joystick(1);
	public static Joystick joyOI = new Joystick(2); 
	 
	public static Button buttonDriveUp = new JoystickButton(joyR, 1);
	public static Button buttonDriveDown = new JoystickButton(joyL, 1);

	public static JoystickAxisButton buttonElevIntake= new JoystickAxisButton(joyOI, 3, 0.8);
	public static JoystickButton buttonElevSwitch = new JoystickButton(joyOI, 6);
	public static JoystickAxisButton buttonElevMidSc = new JoystickAxisButton(joyOI, 2, 0.8);
	public static JoystickButton buttonElevTopSc = new JoystickButton(joyOI, 5);
	public static Button buttonManualElevator = new JoystickButton(joyOI, 7);
	 

	public static Button buttonOutTake = new JoystickButton(joyOI, 2);
	public static Button pulsingIntake = new JoystickButton(joyOI, 3);
	public static Button buttonManualIntake = new JoystickButton(joyOI, 8);
	 
	public static Button buttonWinchUp = new JoystickButton(joyOI, 4);
	 
	public OI() {
		buttonDriveUp.whenPressed(new ShiftUp());
		buttonDriveDown.whenPressed(new ShiftDown());
			
		buttonElevTopSc.whenPressed(new MoveElevatorToIntakePos());
		buttonElevMidSc.whenActive(new MoveElevatorToMidScale());
		buttonElevSwitch.whenPressed(new MoveElevetorToSwitchHeight());
		buttonElevIntake.whenActive(new MoveElevatorToTopScale());
		buttonManualElevator.whileHeld(new MoveManualElevator());
			
		buttonOutTake.whileHeld(new IntakeOut());
		pulsingIntake.whileHeld(new IntakeWithPulsingMotor());
		buttonManualIntake.whileHeld(new IntakeManual());

		buttonWinchUp.whileHeld(new RunClimberUp());
	 }
}
