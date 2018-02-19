package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Constants;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.MoveElevator;
import org.usfirst.frc.team360.robot.commands.StopElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	private TalonSRX elevatorMaster = RobotMap.motorElevatorMaster;
	private TalonSRX elevatorSlave = RobotMap.motorElevatorSlave;

	private int zeroSensor;
	
	private final int kSlotIdx = 0;
	private final int kPIDLoopIdx = 0;
	private final int kTimeoutMs = 10;
	
	public Elevator(){
		
		elevatorSlave.follow(elevatorMaster);
		
		elevatorMaster.setInverted(true);
		elevatorSlave.setInverted(true);
		
		elevatorMaster.setNeutralMode(NeutralMode.Brake);
		elevatorSlave.setNeutralMode(NeutralMode.Brake);
		
		/* first choose the sensor */
		elevatorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
		elevatorMaster.setSensorPhase(false);
		
		/* Set relevant frame periods to be at least as fast as periodic rate*/
		elevatorMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
		elevatorMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);

		/* set the peak and nominal outputs, 12V means full */
		elevatorMaster.configNominalOutputForward(0, kTimeoutMs);
		elevatorMaster.configNominalOutputReverse(0, kTimeoutMs);
		elevatorMaster.configPeakOutputForward(1, kTimeoutMs);
		elevatorMaster.configPeakOutputReverse(-1, kTimeoutMs);
		
		/* set closed loop gains in slot0 - see documentation */
		elevatorMaster.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
//		elevatorMaster.config_kF(0, Constants.realElevatorF, kTimeoutMs);
//		elevatorMaster.config_kP(0, Constants.realElevatorP, kTimeoutMs);
//		elevatorMaster.config_kI(0, Constants.realElevatorI, kTimeoutMs);
//		elevatorMaster.config_kD(0, Constants.realElevatorD, kTimeoutMs);
		
		elevatorMaster.config_kF(0, 0.2407, kTimeoutMs);
		elevatorMaster.config_kP(0, 4, kTimeoutMs);
		elevatorMaster.config_kI(0, 0, kTimeoutMs);
		elevatorMaster.config_kD(0, 60, kTimeoutMs);
		
		elevatorMaster.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
		
		zeroSensor = 50;
	}
	
	public void Process(){
		
		SmartDashboard.putNumber("ElevatorVel", elevatorMaster.getSelectedSensorVelocity(kPIDLoopIdx));
	    SmartDashboard.putNumber("ElevatorPos",  elevatorMaster.getSelectedSensorPosition(kPIDLoopIdx));
	    SmartDashboard.putNumber("ElevatorOutputPercent", elevatorMaster.getMotorOutputPercent());
	    SmartDashboard.putNumber("ElevatorError", elevatorMaster.getClosedLoopError(kPIDLoopIdx));
    	
//    	SmartDashboard.putNumber("ActTrajVelocity", elevatorMaster.getActiveTrajectoryVelocity());
		SmartDashboard.putNumber("ActTrajPosition", elevatorMaster.getActiveTrajectoryPosition());
//		SmartDashboard.putNumber("ActTrajHeading", elevatorMaster.getActiveTrajectoryHeading());
		
	}
	public void setMotor(double speed) {
		elevatorMaster.set(ControlMode.PercentOutput, speed);
	}
	public void setMotorPosition(double distance) {
		elevatorMaster.set(ControlMode.MotionMagic, distance);
	}
	public void stop() {
		elevatorMaster.set(ControlMode.PercentOutput, 0);
	}
	public double getPosition() {
		return elevatorMaster.getSelectedSensorPosition(Robot.elevator.kPIDLoopIdx);
	}
	public void motionMagicInit() {
		/* set acceleration and vcruise velocity - see documentation */
		elevatorMaster.configMotionCruiseVelocity(4250, kTimeoutMs);
		elevatorMaster.configMotionAcceleration(1500, kTimeoutMs);
		/* zero the sensor */
		//elevatorMaster.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
	}
	
	public double getMotorOutputVoltage() {
		return elevatorMaster.getMotorOutputVoltage();
	}
	
	public void getCurrentPosition() {
		RobotMap.currentPos = elevatorMaster.getSelectedSensorPosition(kPIDLoopIdx);
	}
	
	public boolean zeroActive() {
		return RobotMap.elevatorLimitSwitch.get();
	}
	
	public int elevatorIsFine() {
		return elevatorMaster.getSensorCollection().getPulseWidthRiseToRiseUs();
	}
	
	public void elevatorOutputIsFine() {
		if(elevatorIsFine() == 0) {
			DriverStation.reportWarning("Elevator encoder is NOT working, automatic control disabled", false);
			Command stopElevator;
			stopElevator = new StopElevator();
			stopElevator.start();
		}
	}
	
//	public double getElevatorOutput() {
//		return elevatorMaster.getMotorOutputPercent();
//	}
//	
//	public double getElevatorVelocity() {
//		return elevatorMaster.getSelectedSensorVelocity(kPIDLoopIdx);
//	}
//	
//	public void elevatorOutputIsFine() {
//		if(getElevatorVelocity() > 600 && getElevatorOutput() > 10) {
//			elevatorMaster.set(ControlMode.PercentOutput, 0);
//			DriverStation.reportWarning("EleVaTOr BRoKeN!!!!", false);
//			Command stopElevator;
//			stopElevator = new StopElevator();
//			stopElevator.start();
//		}
//	}
	
    public void initDefaultCommand() {
    }

	public void zeroSensor() {
		elevatorMaster.setSelectedSensorPosition(zeroSensor, 0, 10);
	}

    
}

