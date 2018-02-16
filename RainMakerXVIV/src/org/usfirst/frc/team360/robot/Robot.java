/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.RobotMap.IntakeState;
import org.usfirst.frc.team360.robot.commands.StopElevator;
import org.usfirst.frc.team360.robot.subsystems.*;

public class Robot extends TimedRobot {
	
	public static Shifter shifter;
	public static Elevator elevator;
	public static Pneumatics pneumatics;
	public static DriveTrain driveTrain;
	public static Climber climber;
	public static NavX navX;
	public static Intake intake;
	public static Logger logger;
	public static LED led;
	public static IntakePneumatics intakePeumatics;
	
	public static OI oi;
	public static Constants constants;
	public static AutoController autoController;
	
	Command autonomousCommand;
	boolean wasZeroActive = false;
	
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
		RobotMap.currentPos = 0;
		
		shifter = new Shifter();
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
		//motionMagic  = new MotionMagic();

		//elevator.zeroSensor();
		elevator.zeroSensor();
		climber = new Climber();
		navX = new NavX();
		intake = new Intake();
		led = new LED();
		logger = new Logger();
		intakePeumatics = new IntakePneumatics();
		oi = new OI();
		autoController = new AutoController();
	}
	
	@Override 
	public void robotPeriodic() {	
		logger.logDriverStationConnection();
		if (elevator.zeroActive() && !RobotMap.wasZeroActive) {
			elevator.zeroSensor();
			RobotMap.wasZeroActive = true;
		} else if (!elevator.zeroActive() && RobotMap.wasZeroActive) {
			RobotMap.wasZeroActive = false;
		
	}
		
	}

	@Override
	public void disabledInit() {
		RobotMap.robotMode = "Disabled";
		logger.closeLogger();
	}

	@Override
	public void disabledPeriodic() {
		autoController.smartDashboardAutoController();
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		RobotMap.robotMode = "Auto";
		logger.initLogger();	
//		autonomousCommand = new FollowTrajectory("DriveStraight10Feet");
		autonomousCommand = autoController.chooseAutoMode();
		if (autonomousCommand != null){
			autonomousCommand.start();	
		}
		Command stopElevator = new StopElevator();
		stopElevator.start();
	}

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
		
		RobotMap.robotMode = "Teleop";
		logger.initLogger();
		Command stopElevator = new StopElevator();
		stopElevator.start();
}

	@Override
	public void teleopPeriodic() {
		//System.out.println("Amps: " + intake.currentDraw());
		System.out.println("Elevator Output Voltage:" + elevator.getMotorOutputVoltage());
		elevator.Process();
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
