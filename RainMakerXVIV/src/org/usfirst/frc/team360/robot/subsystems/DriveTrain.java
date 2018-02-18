package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;
import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frc.team360.robot.pathfollower.*;

import com.ctre.phoenix.motion.*;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveTrain extends Subsystem {
	
	public TalonSRX motorRMaster = RobotMap.motorRightMaster;
	private TalonSRX motorRSlave = RobotMap.motorRightSlave;
	
	public TalonSRX motorLMaster = RobotMap.motorLeftMaster;
	private TalonSRX motorLSlave = RobotMap.motorLeftSlave;
	
    public static int DEFAULT_TIMEOUT_MS = 10;

	private MotionProfileStatus rightStatus = new MotionProfileStatus();
	private MotionProfileStatus leftStatus = new MotionProfileStatus();
	

	private Notifier leftTalonSender;
	private Notifier rightTalonSender;
	
	public DriveTrain() {
		motorRMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorLMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
		motorRSlave.follow(motorRMaster);
		motorLSlave.follow(motorLMaster);

		motorRMaster.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_25Ms, 10);
		motorLMaster.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_25Ms, 10);
		
		motorLMaster.setInverted(false);
		motorLSlave.setInverted(false);
		
		motorRMaster.setInverted(true);
		motorRSlave.setInverted(true);
		
		motorLMaster.setSensorPhase(false);
		motorRMaster.setSensorPhase(false);
		
		motorLMaster.config_kF(0, Constants.realLeftDriveTrainPathPlanningF, DEFAULT_TIMEOUT_MS);
		motorLMaster.config_kP(0, Constants.realLeftDriveTrainPathPlanningP, DEFAULT_TIMEOUT_MS);		
		motorLMaster.config_kI(0, Constants.realLeftDriveTrainPathPlanningI, DEFAULT_TIMEOUT_MS);
		motorLMaster.config_kD(0, Constants.realLeftDriveTrainPathPlanningD, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kF(0, Constants.realRightDriveTrainPathPlanningF, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kP(0, Constants.realRightDriveTrainPathPlanningP, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kI(0, Constants.realRightDriveTrainPathPlanningI, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kD(0, Constants.realRightDriveTrainPathPlanningD, DEFAULT_TIMEOUT_MS);
		
		motorLMaster.selectProfileSlot(0, 0);
		motorRMaster.selectProfileSlot(0, 0);
		
		resetTalons(motorRMaster);
		resetTalons(motorLMaster);
		
		resetTalons(motorRSlave);
		resetTalons(motorLSlave);
	}
	public void setUpRightTalonForMotionControl() {
		motorRMaster.clearMotionProfileTrajectories();
		motorRMaster.changeMotionControlFramePeriod(5);
		motorRMaster.configNominalOutputForward(0, 10);
		motorRMaster.configNominalOutputReverse(0, 10);
		motorRMaster.configPeakOutputForward(12, 10);
		motorRMaster.configPeakOutputReverse(-12, 10);
		motorRMaster.setSelectedSensorPosition(0, 0, 10);
		motorRMaster.enableCurrentLimit(false);
	}
	public void setUpLeftTalonForMotionControl() {
		motorLMaster.clearMotionProfileTrajectories();
		motorLMaster.changeMotionControlFramePeriod(5);
		motorLMaster.configNominalOutputForward(0, 10);
		motorLMaster.configNominalOutputReverse(0, 10);
		motorLMaster.configPeakOutputForward(12, 10);
		motorLMaster.configPeakOutputReverse(-12, 10);
		motorLMaster.setSelectedSensorPosition(0, 0, 10);
		motorLMaster.enableCurrentLimit(false);
	}
	public void resetTalons(TalonSRX talon){
		talon.configNominalOutputForward(0, 10);
		talon.configNominalOutputReverse(0, 10);
		talon.configPeakOutputForward(12, 10);
		talon.configPeakOutputReverse(-12, 10);
		talon.setSelectedSensorPosition(0, 0, 10);
		talon.enableCurrentLimit(false);
	}
	public void endMotionProfilingRight() {
		motorRMaster.clearMotionProfileTrajectories();
		driveMotionProfileRight(ControlMode.MotionProfile, SetValueMotionProfile.Disable);
		stop();
	}
	public void endMotionProfilingLeft() {
		motorLMaster.clearMotionProfileTrajectories();
		driveMotionProfileLeft(ControlMode.MotionProfile, SetValueMotionProfile.Disable);
		stop();
	}
	public void resetRHardEnc(){
		motorRMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	public void resetLHardEnc(){
		motorLMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	public void resetEncs(){
		motorRMaster.getSensorCollection().setQuadraturePosition(0, 0);
		motorLMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	public MotionProfileStatus getRightMotioProfileStatus(){
		motorRMaster.getMotionProfileStatus(rightStatus);
		return rightStatus;
	}
	public MotionProfileStatus getLeftMotioProfileStatus(){
		motorLMaster.getMotionProfileStatus(leftStatus);
		return leftStatus;
	}
	public double getRightVelocity(){
		return motorRMaster.getSelectedSensorVelocity(0);
	}
	public double getLeftVelocity(){
		return motorLMaster.getSelectedSensorVelocity(0);
	}
	public double getRightVelocityRPM(){
		return motorRMaster.getSelectedSensorVelocity(0) * 600/4096;
	}
	public double getLeftVelocityRPM(){
		return motorLMaster.getSelectedSensorVelocity(0) * 600/4096;
	}
	public double getRightMotionProfileVelocitySetPoint(){
		return motorRMaster.getActiveTrajectoryVelocity();
	}
	public double getLeftMotionProfileVelocitySetPoint(){
		return motorLMaster.getActiveTrajectoryVelocity();
	}
	public double getRightPosition(){
		return motorRMaster.getSelectedSensorPosition(0);
	}
	public double getLeftPosition(){
		return motorLMaster.getSelectedSensorPosition(0);
	}
	public double getRightMotionProfilePositionSetPoint(){
		return motorRMaster.getActiveTrajectoryPosition();
	}
	public double getLeftMotionProfilePositionSetPoint(){
		return motorLMaster.getActiveTrajectoryPosition();
	}
	public void processRightBuffer(){
		motorRMaster.processMotionProfileBuffer();
	}
	public void processLeftBuffer(){
		motorLMaster.processMotionProfileBuffer();
	}
	public void drive(double RMotor, double LMotor) {
		motorRMaster.set(ControlMode.PercentOutput, RMotor);
		motorLMaster.set(ControlMode.PercentOutput, LMotor);	  
	}
	public void driveMotionProfileRight(ControlMode mode, SetValueMotionProfile profileValue) {
		motorRMaster.set(mode, profileValue.value);
	}
	public void driveMotionProfileLeft(ControlMode mode, SetValueMotionProfile profileValue) {
		motorLMaster.set(mode, profileValue.value);
	}
	public void driveR(double RMotor) {
		motorRMaster.set(ControlMode.PercentOutput, RMotor);
	}
	public void driveL(double LMotor){
		motorLMaster.set(ControlMode.PercentOutput, LMotor);
	}
	public void stop(){
		motorLMaster.set(ControlMode.PercentOutput, 0, 0);
		motorRMaster.set(ControlMode.PercentOutput, 0, 0);
	}
	public void runThreadedProfileSenders(SrxTrajectory traj) {
		leftTalonSender = new Notifier(new TalonProfileSender(motorLMaster, traj.leftProfile, 0));
		rightTalonSender = new Notifier(new TalonProfileSender(motorRMaster, traj.rightProfile, 0));
		
		leftTalonSender.startPeriodic(.005);
		rightTalonSender.startPeriodic(.005);
	}
	public void stopThreadedProfileSenders() {
		leftTalonSender.stop();
		rightTalonSender.stop();
	}
	private class TalonProfileSender implements java.lang.Runnable {
		TrajectoryPoint point;
		TalonSRX talon;
		SrxMotionProfile prof;
		int pidfSlot;
		int num = 0;
		public TalonProfileSender(TalonSRX _talon, SrxMotionProfile _prof, int _pidfSlot){
			talon = _talon;
			prof = _prof;
			pidfSlot = _pidfSlot;
		}

		public void run() {
			if((!talon.isMotionProfileTopLevelBufferFull()) && (6 < prof.numPoints) && (num < prof.numPoints)){
				point = new TrajectoryPoint();
				if(num < 15){
					for (num = 0; num <= 15; num++) {
						if(! talon.isMotionProfileTopLevelBufferFull()){
							/* for each point, fill our structure and pass it to API */
							point.position = prof.points[num][0];
							point.velocity = prof.points[num][1];
							point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
							point.profileSlotSelect0 = pidfSlot; 
							point.profileSlotSelect1 = 0;
							point.zeroPos = false;
							if (num == 0){
								point.zeroPos = true; /* set this to true on the first point */
							}
							point.isLastPoint = false;
							if ((num + 1) == prof.numPoints){
								point.isLastPoint = true;	/* set this to true on the last point */
							}
							talon.pushMotionProfileTrajectory(point);
							talon.processMotionProfileBuffer();
						} else {
							num--;
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					point.position = prof.points[num][0];
					point.velocity = prof.points[num][1];
					point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
					point.profileSlotSelect0 = pidfSlot; 
					point.profileSlotSelect1 = 0;
					point.zeroPos = false;
					if (num == 0){
						point.zeroPos = true; /* set this to true on the first point */
					}
					point.isLastPoint = false;
					if ((num + 1) == prof.numPoints){
						point.isLastPoint = true;	/* set this to true on the last point */
					}
					num++;
					talon.pushMotionProfileTrajectory(point);
					talon.processMotionProfileBuffer();
				}
			} else if((! talon.isMotionProfileTopLevelBufferFull()) && num < prof.numPoints){
				for (int i = 0; i < prof.numPoints; ++i) {
					if(! talon.isMotionProfileTopLevelBufferFull()){
						/* for each point, fill our structure and pass it to API */
						point.position = prof.points[i][0];
						point.velocity = prof.points[i][1];
						point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
						point.profileSlotSelect0 = pidfSlot; 
						point.profileSlotSelect1 = 0;
						point.zeroPos = false;
						if (i == 0){
							point.zeroPos = true; /* set this to true on the first point */
						}
						point.isLastPoint = false;
						if ((i + 1) == prof.numPoints){
							point.isLastPoint = true;	/* set this to true on the last point */
						}
						talon.pushMotionProfileTrajectory(point);
						talon.processMotionProfileBuffer();
					} else {
						i--;
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			talon.processMotionProfileBuffer();
		}
	}
    public void initDefaultCommand() {

    		setDefaultCommand(new JoystickTankDrive());

    }
}