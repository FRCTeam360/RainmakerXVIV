/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frc.team360.robot.commands.autos.*;
import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.subsystems.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Shifter shifter;
	public static Pneumatics pneumatics;
	Command Pressurize;
	public static DriveTrain driveTrain;
	public static OI oi;
	public static Winch winch;
	public static NavX navX;
	public static String selectedStartPosition = "Center";
	Command autonomousCommand;
	
	SendableChooser<String> startChooser;
	SendableChooser<String> firstPriority;
	

	public static BufferedReader Buff;
	
	enum ScaleSide {LEFT, RIGHT};
	ScaleSide scaleSide; 
	enum SwitchSide {LEFT, RIGHT};
	SwitchSide switchSide; 
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			Buff = new BufferedReader(new FileReader("RobotID.txt"));
			RobotMap.robotID = Buff.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("comp".equals(RobotMap.robotID)) {
			System.out.println("Comp Bot");
			DriverStation.reportError("Comp Bot", false);
			
			Constants.real_F = Constants.comp_kF;
			Constants.real_P = Constants.comp_kP;
			Constants.real_I = Constants.comp_kI;
			Constants.real_D = Constants.comp_kD;
		}
		else if ("practice".equals(RobotMap.robotID)) {
			System.out.println("Practice Bot");
			DriverStation.reportError("Practice Bot", false);
			
			Constants.real_F = Constants.prac_kF;
			Constants.real_P = Constants.prac_kP;
			Constants.real_I = Constants.prac_kI;
			Constants.real_D = Constants.prac_kD;
		}
		else {
			System.out.println("Invalid Robot ID");
			DriverStation.reportError("Invalid Robot ID", false);
			
			Constants.real_F = Constants.comp_kF;
			Constants.real_P = Constants.comp_kP;
			Constants.real_I = Constants.comp_kI;
			Constants.real_D = Constants.comp_kD;
		}

		shifter = new Shifter();
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		winch = new Winch();
		navX = new NavX();
		oi = new OI();
		startChooser = new SendableChooser<>();
		startChooser.addDefault("Center", "Center");
		startChooser.addObject("Left", "Left");
		startChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Location", startChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		try {
			if("Center".equals(startChooser.getSelected())){
				if(!"Center".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Either Switch", "Either Switch");
					firstPriority.addObject("Right Switch", "Right Switch");
					firstPriority.addObject("Left Switch", "Left Switch");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Center";
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Left".equals(startChooser.getSelected())){
				if(!"Left".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Close Switch", "Close Switch");
					//firstPriority.addObject("Close Scale", "Close Scale");
					//firstPriority.addObject("Far Switch", "Far Switch");
					//firstPriority.addObject("Far Scale", "Far Scale");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Left";
				}
			}	
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Right".equals(startChooser.getSelected())){
				if(!"Left".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Close Switch", "Close Switch");
					//firstPriority.addObject("Close Scale", "Close Scale");
					//firstPriority.addObject("Far Switch", "Far Switch");
					//firstPriority.addObject("Far Scale", "Far Scale");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Right";
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		Scheduler.getInstance().run();
	}
	public void getLightConfiguration(){
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L') {
			DriverStation.reportWarning("L alliance switch", false);
			switchSide = SwitchSide.LEFT;
			//Put left auto code here
		} else {
			DriverStation.reportWarning("R alliance switch", false);
			switchSide = SwitchSide.RIGHT;
		}
		if(gameData.charAt(1) == 'L') {
			DriverStation.reportWarning("L scale", false);
			scaleSide = ScaleSide.LEFT;
			//Put left auto code here
		} else {
			DriverStation.reportWarning("R scale", false);
			scaleSide = ScaleSide.RIGHT;
			//Put right auto code here
		}
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		getLightConfiguration();
//		if("Center".equals(startChooser.getSelected())){
//			if("Cross Line".equals(firstPriority.getSelected())){
//				autonomousCommand = new CrossLineMotionProfiled();
//				SmartDashboard.putString("Selected Auto", "Crossing Line");
//			} else if("Either Switch".equals(firstPriority.getSelected())){
//				if(switchSide.equals(SwitchSide.LEFT)){
//					autonomousCommand = new StartCenterDropCubeLeftSwitch();
//					SmartDashboard.putString("Selected Auto", "Center to Left auton");
//				} else if(switchSide.equals(SwitchSide.RIGHT)){
//					autonomousCommand = new StartCenterDropCubeRightSwitch();
//					SmartDashboard.putString("Selected Auto", "Center to Right auton");
//				}
//			} else if("Left Switch".equals(firstPriority.getSelected())){
//				if(switchSide.equals(SwitchSide.LEFT)){
//					autonomousCommand = new StartCenterDropCubeLeftSwitch();
//					SmartDashboard.putString("Selected Auto", "Center to Left auton");
//				} else if(switchSide.equals(SwitchSide.RIGHT)){
//					autonomousCommand = new DoNothingAuto();
//					SmartDashboard.putString("Selected Auto", "Doing Nothing");
//				}
//			} else if("Right Switch".equals(firstPriority.getSelected())){
//				if(switchSide.equals(SwitchSide.LEFT)){
//					autonomousCommand = new DoNothingAuto();
//					SmartDashboard.putString("Selected Auto", "Doing Nothing");
//				} else if(switchSide.equals(SwitchSide.RIGHT)){
//					autonomousCommand = new StartCenterDropCubeRightSwitch();
//					SmartDashboard.putString("Selected Auto", "Center to Right auton");
//				}
//			}
//		} else if("Left".equals(startChooser.getSelected())){
//			if("Cross Line".equals(firstPriority.getSelected())){
//				autonomousCommand = new CrossLineMotionProfiled();
//				SmartDashboard.putString("Selected Auto", "Crossing Line");
//			} else if("Close Switch".equals(firstPriority.getSelected())){
//				if(switchSide.equals(SwitchSide.LEFT)){
//					autonomousCommand = new StartLeftDropCubeLeftSwitch();
//					SmartDashboard.putString("Selected Auto", "Left to Left auton");
//				} else if(switchSide.equals(SwitchSide.RIGHT)){
//					autonomousCommand = new DoNothingAuto();
//					SmartDashboard.putString("Selected Auto", "Doing Nothing");
//
//				}
//			}
//		} else if("Right".equals(startChooser.getSelected())){
//			if("Cross Line".equals(firstPriority.getSelected())){
//				autonomousCommand = new CrossLineMotionProfiled();
//				SmartDashboard.putString("Selected Auto", "Crossing Line");
//			} else if("Close Switch".equals(firstPriority.getSelected())){
//				if(switchSide.equals(SwitchSide.LEFT)){
//					autonomousCommand = new DoNothingAuto();
//					SmartDashboard.putString("Selected Auto", "Doing Nothing");
//				} else if(switchSide.equals(SwitchSide.RIGHT)){
//					autonomousCommand = new StartRightDropCubeRightSwitch();
//					SmartDashboard.putString("Selected Auto", "Right to Right auton");
//				}
//			}
//		}
		autonomousCommand = new StartCenterDropCubeLeftSwitch();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("right error", driveTrain.getRightVelocity() 
				- driveTrain.getRightMotionProfileVelocitySetPoint());
		SmartDashboard.putNumber("left error", driveTrain.getLeftVelocity() 
				- driveTrain.getLeftMotionProfileVelocitySetPoint());

		SmartDashboard.putNumber("right position error", driveTrain.getRightPosition() 
				- driveTrain.getRightMotionProfilePositionSetPoint());
		SmartDashboard.putNumber("left positionerror", driveTrain.getLeftPosition() 
				- driveTrain.getLeftMotionProfilePositionSetPoint());
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		try {
			System.out.println(driveTrain.getLeftVelocityRPM() + "LEFT");
			System.out.println(driveTrain.getRightVelocityRPM() + "RIGHT");
			Scheduler.getInstance().run();
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
