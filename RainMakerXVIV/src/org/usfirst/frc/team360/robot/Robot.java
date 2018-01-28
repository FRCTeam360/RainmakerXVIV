
//FOCUS

package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.internal.HardwareTimer;

import org.usfirst.frc.team360.commands.*;
import org.usfirst.frc.team360.robot.subsystems.*;

public class Robot extends TimedRobot {
	
	public static Shifter shifter;
	public static Pneumatics pneumatics;
	public static DriveTrain driveTrain;
	public static navXsystem navX;
	public static Logger logger;
	public static HardwareTimer RoboRioTimer;
	public static OI oi;

	Command Pressurize;
	Command navXCommandSystem;
	Command talonLogCommand;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();


	@Override
	public void robotInit() {
		shifter = new Shifter();
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		navX = new navXsystem();
		logger = new Logger();
		RoboRioTimer = new HardwareTimer();
		navXCommandSystem = new navXstart();
		oi = new OI();
		
	}

	@Override
	public void disabledInit() {
		logger.closeLogger();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		RobotMap.RobotState = "Autonomous";
		logger.initLogger();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		RobotMap.RobotState = "Tele OP";
		logger.initLogger();
		driveTrain.setControlModeVoltage();
	}

	@Override
	public void teleopPeriodic() {
		navXCommandSystem.start();
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
		RobotMap.RobotState = "Test Mode";
		logger.initLogger();
	}
}
