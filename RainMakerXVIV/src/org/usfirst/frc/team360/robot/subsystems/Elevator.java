package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.ManualElevator;
import org.usfirst.frc.team360.robot.commands.MoveElevator;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	public TalonSRX elevatorMaster = RobotMap.elevM;
	static TalonSRX elevatorSlave = RobotMap.elevS;

	private int zeroSensor;
	
	public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 10;
	
	public Elevator(){
		
		elevatorSlave.follow(elevatorMaster);
		
		/* first choose the sensor */
		elevatorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
		elevatorMaster.setSensorPhase(false);
		elevatorMaster.setInverted(false);
		
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
		//elevatorMaster.config_kF(0, 0.755539, kTimeoutMs);
		//elevatorMaster.config_kP(0, 0.005963, kTimeoutMs);
		elevatorMaster.config_kF(0, 0.756, kTimeoutMs);
		elevatorMaster.config_kP(0, 4, kTimeoutMs);
		elevatorMaster.config_kI(0, 0, kTimeoutMs);
		elevatorMaster.config_kD(0, 40, kTimeoutMs);
		
	}
	
	public void Process(){
		
		SmartDashboard.putNumber("ElevatorVel", elevatorMaster.getSelectedSensorVelocity(Elevator.kPIDLoopIdx));
    	SmartDashboard.putNumber("ElevatorPos",  elevatorMaster.getSelectedSensorPosition(Elevator.kPIDLoopIdx));
    	SmartDashboard.putNumber("ElevatorOutputPercent", elevatorMaster.getMotorOutputPercent());
    	SmartDashboard.putNumber("ElevatorError", elevatorMaster.getClosedLoopError(Elevator.kPIDLoopIdx));
    	
//    	SmartDashboard.putNumber("ActTrajVelocity", elevatorMaster.getActiveTrajectoryVelocity());
		SmartDashboard.putNumber("ActTrajPosition", elevatorMaster.getActiveTrajectoryPosition());
//		SmartDashboard.putNumber("ActTrajHeading", elevatorMaster.getActiveTrajectoryHeading());
		
	}

	public void motionMagicInit() {
		
		/* set acceleration and vcruise velocity - see documentation */
		elevatorMaster.configMotionCruiseVelocity(1340, kTimeoutMs);
		elevatorMaster.configMotionAcceleration(800, kTimeoutMs);
		/* zero the sensor */
		//_talon.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
	}
	
	public void getCurrentPosition() {
		RobotMap.currentPos = elevatorMaster.getSelectedSensorPosition(Elevator.kPIDLoopIdx);
	}
	
	public boolean zeroActive() {
		return RobotMap.elevatorLimitSwitch.get();
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new ManualElevator());
    }

	public void zeroSensor() {
		int ZeroSensor = 50;
		elevatorMaster.setSelectedSensorPosition(ZeroSensor, 0, 10);
	}

    
}

