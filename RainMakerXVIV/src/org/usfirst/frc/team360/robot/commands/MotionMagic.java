/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team360.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example command.  You can replace me with your own command.
 */
public class MotionMagic extends Command {
	
	TalonSRX _talon = new TalonSRX(3);
	Joystick _joy = new Joystick(0);
	StringBuilder _sb = new StringBuilder();
	
	public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 10;
	private static int _loops = 0;
	private static int _timesInMotionMagic = 0;
	
public static void Process(TalonSRX tal, StringBuilder sb) {
		
		SmartDashboard.putNumber("SensorVel", tal.getSelectedSensorVelocity(kPIDLoopIdx));
    	SmartDashboard.putNumber("SensorPos",  tal.getSelectedSensorPosition(kPIDLoopIdx));
    	SmartDashboard.putNumber("MotorOutputPercent", tal.getMotorOutputPercent());
    	SmartDashboard.putNumber("ClosedLoopError", tal.getClosedLoopError(kPIDLoopIdx));
    	
    	if (tal.getControlMode() == ControlMode.MotionMagic) {
    		
    		++_timesInMotionMagic;
    		
    	}
    	
    	else {
    		
    		_timesInMotionMagic = 0;
    		
    	}
    	
    	if (_timesInMotionMagic > 10) {
    		
    		SmartDashboard.putNumber("ActTrajVelocity", tal.getActiveTrajectoryVelocity());
    		SmartDashboard.putNumber("ActTrajPosition", tal.getActiveTrajectoryPosition());
    		SmartDashboard.putNumber("ActTrajHeading", tal.getActiveTrajectoryHeading());
    		
    	}
    	
    	if (++_loops >= 10) {
    		
    		_loops = 0;
    		System.out.println(sb.toString());
    		
    	}
    	
    	sb.setLength(0);
		
	}
	
	public MotionMagic() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() { //CAN I HAS MEMES PLEASE 
		
		System.out.println("hi");
		
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
		_talon.setSensorPhase(true);
		_talon.setInverted(false);
		
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
		
		_talon.configNominalOutputForward(0, kTimeoutMs);
		_talon.configNominalOutputReverse(0, kTimeoutMs);
		_talon.configPeakOutputForward(1, kTimeoutMs);
		_talon.configPeakOutputReverse(-1, kTimeoutMs);
		
		_talon.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
		_talon.config_kF(0, 0, kTimeoutMs);
		_talon.config_kP(0, 0.2, kTimeoutMs);
		_talon.config_kI(0, 0, kTimeoutMs);
		_talon.config_kD(0, 0, kTimeoutMs);
		_talon.configMotionCruiseVelocity(7500, kTimeoutMs);
		_talon.configMotionAcceleration(50, kTimeoutMs);
		_talon.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		System.out.println("hi");
		
		double leftYstick = -1.0 * _joy.getY();
		double motorOutput = _talon.getMotorOutputPercent();
		
		_sb.append("\tOut%:");
		_sb.append(motorOutput);
		_sb.append("\tVel:");
		_sb.append(_talon.getSelectedSensorVelocity(kPIDLoopIdx));
		
		if(_joy.getRawButton(1)) {
				
			
			double targetPos = leftYstick * 4096 * 2.5;
			
			_talon.set(ControlMode.MotionMagic, targetPos);
			
			_sb.append("\terr:");
			_sb.append(_talon.getClosedLoopError(kPIDLoopIdx));
			_sb.append("\ttrg:");
			_sb.append(targetPos);
		}
		
		else {
			
			_talon.set(ControlMode.PercentOutput, motorOutput);
			
		}
		
		Process (_talon, _sb);
		try {
			
			TimeUnit.MILLISECONDS.sleep(10);
		}
		
		catch (Exception e) {}
		
	}
	

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
