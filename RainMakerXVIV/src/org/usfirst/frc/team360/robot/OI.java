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
	public static Button buttonStopElevator = new JoystickButton(joyR, 2);
	public static Button buttonDriveDown = new JoystickButton(joyL, 1);

	public static Button buttonElevIntake = new JoystickButton(joyOI, 3);
	public static JoystickAxisButton buttonElevOffGround = new JoystickAxisButton(joyOI, 1, .8);
	public static Button buttonElevSwitch = new JoystickButton(joyOI, 1);
	public static Button buttonElevMidSc = new JoystickButton(joyOI, 2);
	public static Button buttonElevTopSc = new JoystickButton(joyOI, 4);

//	public static JoystickAxisButton buttonElevIntake= new JoystickAxisButton(joyOI, 3, 0.8);
//	public static Button buttonElevSwitch = new JoystickButton(joyOI, 6);
//	public static JoystickAxisButton buttonElevMidSc = new JoystickAxisButton(joyOI, 2, 0.8);//old
//	public static Button buttonElevTopSc = new JoystickButton(joyOI, 5);
	public static Button buttonManualElevator = new JoystickButton(joyOI, 7);
	
	public static Button button = new JoystickButton(joyOI,	10);
	public static Button button2 = new JoystickButton(joyOI, 9);
	  	 

//	public static Button buttonOutTake = new JoystickButton(joyOI, 2);
//	public static Button pulsingIntake = new JoystickButton(joyOI, 3);
	public static Button buttonManualIntake = new JoystickButton(joyOI, 8);
	public static Button buttonLockElevator = new JoystickButton(joyR, 10);
	
	public static Button buttonOutTake = new JoystickButton(joyOI, 5);
	public static Button pulsingIntake = new JoystickButton(joyOI, 6);
	 
//	public static Button buttonWinchUp = new JoystickButton(joyOI, 4);
	 
	public OI() {
		buttonDriveUp.whenPressed(new ShiftUp());
		buttonDriveDown.whenPressed(new ShiftDown());
		buttonStopElevator.whenPressed(new StopElevator());
			
//		buttonElevIntake.whenActive(new MoveElevatorToIntakePos());
//		buttonElevMidSc.whenActive(new MoveElevatorToMidScale());
//		buttonElevSwitch.whenPressed(new MoveElevatorToSwitchHeight());
//		buttonElevTopSc.whenPressed(new MoveElevatorToTopScale());// old
		buttonElevIntake.whenPressed(new MoveElevatorToIntakePos());
		//button2.whenPressed(new MoveElevatorOffGround());
		buttonElevSwitch.whenPressed(new MoveElevatorToSwitchHeight());
		buttonElevMidSc.whenPressed(new MoveElevatorToMidScale());
		buttonElevTopSc.whenPressed(new MoveElevatorToTopScale());
		buttonManualElevator.whileHeld(new MoveManualElevator());
			
		buttonOutTake.whileHeld(new IntakeOut());
		pulsingIntake.whenPressed(new IntakePulseAndFlashLEDs());
		buttonManualIntake.whileHeld(new IntakeManual());
		buttonManualElevator.whenPressed(new IntakeStop());

//		buttonWinchUp.whileHeld(new RunClimberUp());
		button.whenPressed(new IntakeOpen());
		button2.whenPressed(new IntakeClose());
		buttonLockElevator.whenPressed(new ElevatorHold());
	 }
	
}
