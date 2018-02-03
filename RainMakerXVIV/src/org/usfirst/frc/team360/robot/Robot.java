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

import org.usfirst.frc.team360.robot.commands.FollowTrajectory;
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
	public static DriveTrain driveTrain;
	public static Winch winch;
	public static NavX navX;
	public static Intake intake;
	public static OI oi;
	public static String selectedStartPosition = "Center";
	Command autonomousCommand;
	
	SendableChooser<String> startChooser;
	SendableChooser<String> firstPriority;
	

	public static BufferedReader Buff;
	
	Constants constants;
	
	enum ScaleSide {LEFT, RIGHT};
	ScaleSide scaleSide; 
	enum SwitchSide {LEFT, RIGHT};
	SwitchSide switchSide; 
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	/*	public static void Camera(){
	new Thread(() -> {
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(640, 480);
        
        CvSink cvSink = CameraServer.getInstance().getVideo();
        CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
        
        Mat source = new Mat();
        Mat output = new Mat();
        
        while(!Thread.interrupted()) {
            cvSink.grabFrame(source);
            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
            outputStream.putFrame(output);
        }
    }).start();
}*/
	@Override
	public void robotInit() {
		constants = new Constants();
		try {
			Buff = new BufferedReader(new FileReader("RobotID.txt"));
			RobotMap.robotID = Buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ("comp".equals(RobotMap.robotID)) {
			DriverStation.reportError("Comp Bot", false);
			constants.writeCompBotVariables();
		} else if ("practice".equals(RobotMap.robotID)) {
			DriverStation.reportError("Practice Bot", false);
			constants.writePracticeBotVariables();
		} else {
			DriverStation.reportError("Invalid Robot ID, defaulting to comp bot variables", false);
			constants.writeCompBotVariables();
		}
		shifter = new Shifter();
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		winch = new Winch();
		navX = new NavX();
		intake = new Intake();
		oi = new OI();
		startChooser = new SendableChooser<>();
		startChooser.addDefault("Center", "Center");
		startChooser.addObject("Left", "Left");
		startChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Location", startChooser);
		autonomousCommand = new FollowTrajectory("DriveStraight200Feet");
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
		try {
			if("Center".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
				} else if("Either Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
				} else if("Left Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
				} else if("Right Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
				}
			} else if("Left".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
				} else if("Close Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Left to Left Switch");
				}
			} else if("Right".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
				} else if("Close Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Right to Right auton");
				}
			}
		}catch(Exception e) {
			
		}
		Scheduler.getInstance().run();
	}
	public void getLightConfiguration(){
		try {
			String gameData;
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if("L".equals((String.valueOf(gameData.charAt(0))))) {
				DriverStation.reportWarning("L alliance switch", false);
				switchSide = SwitchSide.LEFT;
				//Put left auto code here
			} else {
				DriverStation.reportWarning("R alliance switch", false);
				switchSide = SwitchSide.RIGHT;
			}
			if("L".equals((String.valueOf(gameData.charAt(1))))) {
				DriverStation.reportWarning("L scale", false);
				scaleSide = ScaleSide.LEFT;
				//Put left auto code here
			} else {
				DriverStation.reportWarning("R scale", false);
				scaleSide = ScaleSide.RIGHT;
				//Put right auto code here
			}
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
	}
	@Override
	public void autonomousInit() {
		getLightConfiguration();
		if("Center".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				autonomousCommand = new CrossLineMotionProfiled();
				SmartDashboard.putString("Selected Auto", "Crossing Line");
			} else if("Either Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					autonomousCommand = new StartCenterDropCubeLeftSwitch();
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					autonomousCommand = new StartCenterDropCubeRightSwitch();
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
				}
			} else if("Left Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					autonomousCommand = new StartCenterDropCubeLeftSwitch();
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					autonomousCommand = new DoNothingAuto();
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
				}
			} else if("Right Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					autonomousCommand = new DoNothingAuto();
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					autonomousCommand = new StartCenterDropCubeRightSwitch();
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
				}
			}
		} else if("Left".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				autonomousCommand = new CrossLineMotionProfiled();
				SmartDashboard.putString("Selected Auto", "Crossing Line");
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					autonomousCommand = new StartLeftDropCubeLeftSwitch();
					SmartDashboard.putString("Selected Auto", "Left to Left auton");
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					autonomousCommand = new DoNothingAuto();
					SmartDashboard.putString("Selected Auto", "Doing Nothing");

				}
			}
		} else if("Right".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				autonomousCommand = new CrossLineMotionProfiled();
				SmartDashboard.putString("Selected Auto", "Crossing Line");
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					autonomousCommand = new DoNothingAuto();
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					autonomousCommand = new StartRightDropCubeRightSwitch();
					SmartDashboard.putString("Selected Auto", "Right to Right auton");
				}
			}
		}
		
		if (autonomousCommand != null){
			autonomousCommand.start();	
	}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("right percent", driveTrain.motorLMaster.getMotorOutputPercent());
		SmartDashboard.putNumber("left percent", driveTrain.motorRMaster.getMotorOutputPercent());
		
		SmartDashboard.putNumber("right velocity", driveTrain.getRightVelocity());
		SmartDashboard.putNumber("left velocity", driveTrain.getLeftVelocity());
		System.out.println("right velocity" + driveTrain.motorLMaster.getMotorOutputPercent() + "velocity" + driveTrain.getRightVelocity()
		 + "velocity" + driveTrain.getRightVelocity() + "Vel error"  + ( driveTrain.getRightVelocity() 
					- driveTrain.getRightMotionProfileVelocitySetPoint()));
		System.out.println("left velocity" + driveTrain.motorRMaster.getMotorOutputPercent() + "velocity" + driveTrain.getLeftVelocity()
		 + "velocity" + driveTrain.getLeftVelocity() + "Vel error" + ( driveTrain.getLeftVelocity() 
			- driveTrain.getLeftMotionProfileVelocitySetPoint()));
		
		
		SmartDashboard.putNumber("right error", driveTrain.getRightVelocity() 
				- driveTrain.getRightMotionProfileVelocitySetPoint());
		SmartDashboard.putNumber("left error", driveTrain.getLeftVelocity() 
				- driveTrain.getLeftMotionProfileVelocitySetPoint());

		SmartDashboard.putNumber("right position error", driveTrain.getRightPosition() 
				- driveTrain.getRightMotionProfilePositionSetPoint());
		SmartDashboard.putNumber("left position error", driveTrain.getLeftPosition() 
				- driveTrain.getLeftMotionProfilePositionSetPoint());
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		try {
			System.out.println(driveTrain.getLeftVelocity() + "LEFT");
			System.out.println(driveTrain.getRightVelocity() + "RIGHT");
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
