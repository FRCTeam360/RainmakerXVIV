/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.RobotMap.IntakeState;
import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frc.team360.robot.commands.autos.*;
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
	public static ReleaseElevator releaseElevator;
	public static OI oi;
	public static Constants constants;
	public static AutoController autoController;
	
	Command autonomousCommand;
	boolean wasZeroActive = false;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
		public static void camera(){
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
}
	@Override
	public void robotInit() {
		constants = new Constants();
		shifter = new Shifter();
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
	//	elevator.zeroSensor();
		climber = new Climber();
		navX = new NavX();
		intake = new Intake();
		led = new LED();
		logger = new Logger();
		intakePeumatics = new IntakePneumatics();
		releaseElevator = new ReleaseElevator();
		oi = new OI();
		autoController = new AutoController();
		camera();
	}
	Command manualElevator;
	@Override 
	public void robotPeriodic() {	
		logger.logDriverStationConnection();
		if(! RobotMap.elevatorLimitSwitch.get()) {
			elevator.zeroElevator();
			RobotMap.currentPos = 0;
			
		}
		if(RobotMap.shouldElevatorStop && elevator.getPosition() == 0) {
			manualElevator = new StopElevator();
			manualElevator.start();	
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
		Command stopElevator = new StopElevator();
		stopElevator.start();
		Command elevatorRelease = new ElevatorRelease();
		elevatorRelease.start();
		RobotMap.robotMode = "Auto";
		logger.initLogger();	
//		autonomousCommand = new StartRightDropCubeRightScale();
//		autonomousCommand = new StartCenterDropCubeLeftSwitch2Cube();
		autonomousCommand = autoController.chooseAutoMode();
		// autoController.chooseAutoMode();
//		autonomousCommand = new StartCenterDropCubeRightSwitch();
//		autonomousCommand = new StartLeftDropCubeLeftSwitch();
//		autonomousCommand = new StartCenterDropCubeRightSwitch();
//		autonomousCommand = new FollowTrajectory("DriveStraight10Feet");
		if (autonomousCommand != null){
			autonomousCommand.start();	
		}
		
	}

	@Override
	public void autonomousPeriodic() {
//		System.out.println("right velocity" + driveTrain.motorLMaster.getMotorOutputPercent() + "velocity" + driveTrain.getRightVelocity()
//		 + "velocity" + driveTrain.getRightVelocity() + "Vel error"  + ( driveTrain.getRightVelocity() 
//					- driveTrain.getRightMotionProfileVelocitySetPoint()));
//		System.out.println("left velocity" + driveTrain.motorRMaster.getMotorOutputPercent() + "velocity" + driveTrain.getLeftVelocity()
//		 + "velocity" + driveTrain.getLeftVelocity() + "Vel error" + ( driveTrain.getLeftVelocity() 
//			- driveTrain.getLeftMotionProfileVelocitySetPoint()));
	//	driveTrain.debugMotionProfiling();
//		SmartDashboard.putNumber("Elevator Position", elevator.getPosition());

	//	elevator.Process();
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
		
		Command elevatorRelease = new ElevatorRelease();
		
		elevatorRelease.start();
}

	@Override
	public void teleopPeriodic() {
//		System.out.println("Left Velocity" + driveTrain.getLeftVelocity());
//		System.out.println("Right Velocity" + driveTrain.getRightVelocity());
		//System.out.println("ElevatorInches" + elevator.getPosition() / Constants.realEncoderCountsToInches);
		//System.out.println("Amps: " + intake.currentDraw());
		//System.out.println("Elevator Output Voltage:" + elevator.getMotorOutputVoltage());
//		System.out.println("E " + elevator.getPosition() + " L " + driveTrain.getLeftPosition() + " R " + driveTrain.getRightPosition());
		elevator.Process();
		Scheduler.getInstance().run();
	}
	@Override
	public void testInit() {
		Command elevatorHold = new ElevatorHold();
		elevatorHold.start();
	}
	@Override
	
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}