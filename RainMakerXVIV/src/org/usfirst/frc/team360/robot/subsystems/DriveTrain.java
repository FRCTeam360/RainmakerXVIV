package org.usfirst.frc.team360.robot.subsystems;

/*import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;
import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveTrain extends Subsystem {
	public static TalonSRX motorRMaster = RobotMap.motorR1;
	static TalonSRX motorRSlave = RobotMap.motorR2;
	public static TalonSRX motorLMaster = RobotMap.motorL1;
	static TalonSRX motorLSlave = RobotMap.motorL2;
    public static int DEFAULT_TIMEOUT_MS = 10;

	private MotionProfileStatus rightStatus = new MotionProfileStatus();
	private MotionProfileStatus leftStatus = new MotionProfileStatus();
	
	public DriveTrain() {
		motorRMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorLMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorRSlave.follow(motorRMaster);
		motorLSlave.follow(motorLMaster);
		motorLMaster.setInverted(false);
		motorLSlave.setInverted(false);
		motorRMaster.setInverted(true);
		motorRSlave.setInverted(true);
		motorLMaster.setSensorPhase(false);
		motorRMaster.setSensorPhase(false);
		motorLMaster.config_kF(0, 2.305, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kF(0, 2.5, DEFAULT_TIMEOUT_MS);
		motorLMaster.config_kP(0, .1, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kP(0, .0725, DEFAULT_TIMEOUT_MS);		
		motorLMaster.config_kI(0, 00, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kI(0, 0, DEFAULT_TIMEOUT_MS);
		motorLMaster.config_kD(0, 10, DEFAULT_TIMEOUT_MS);
		motorRMaster.config_kD(0, 10, DEFAULT_TIMEOUT_MS);
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
	public void driveMotionProfileRight(ControlMode mode, SetValueMotionProfile profile) {
		motorRMaster.set(mode, profile.value);
	}
	public void driveMotionProfileLeft(ControlMode mode, SetValueMotionProfile profile) {
		motorLMaster.set(mode, profile.value);
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
	
//	public void startSenders(SrxTrajectory traj){
//		leftTalonSender = new Notifier(new RightTalonProfileSender(traj.rightProfile, 0));
//		rightTalonSender = new Notifier(new LeftTalonProfileSender(traj.leftProfile, 0));
//		leftTalonSender.startPeriodic(.005);
//		rightTalonSender.startPeriodic(.005);
//	}
//	
//	public void stopSenders(){
//		leftTalonSender.stop();
//		rightTalonSender.stop();
//	}
//	
//	private class LeftTalonProfileSender implements java.lang.Runnable {
//		TrajectoryPoint point;
//		SrxMotionProfile prof;
//		int pidfSlot;
//		int num = 6;
//		public LeftTalonProfileSender(SrxMotionProfile _prof, int _pidfSlot){
//			prof = _prof;
//			pidfSlot = _pidfSlot;
//		}
//		public void run() {
//			if((!motorLMaster.isMotionProfileTopLevelBufferFull()) && (6 < prof.numPoints) && (num < prof.numPoints)){
//				point = new TrajectoryPoint();
//				if(num < 6){
//					for (int i = 0; i < 6; ++i) {
//						if(! motorLMaster.isMotionProfileTopLevelBufferFull()){
//							/* for each point, fill our structure and pass it to API */
//							point.position = prof.points[i][0];
//							point.velocity = prof.points[i][1];
//							point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//							point.profileSlotSelect0 = pidfSlot; 
//							point.profileSlotSelect1 = 0;
//							point.zeroPos = false;
//							if (i == 0){
//								point.zeroPos = true; /* set this to true on the first point */
//							}
//							point.isLastPoint = false;
//							if ((i + 1) == prof.numPoints){
//								point.isLastPoint = true;	/* set this to true on the last point */
//							}
//						} else {
//							i--;
//							try {
//								Thread.sleep(5);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				} else {
//					point.position = prof.points[num][0];
//					point.velocity = prof.points[num][1];
//					point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//					point.profileSlotSelect0 = pidfSlot; 
//					point.profileSlotSelect1 = 0;
//					point.zeroPos = false;
//					if (num == 0){
//						point.zeroPos = true; /* set this to true on the first point */
//					}
//					point.isLastPoint = false;
//					if ((num + 1) == prof.numPoints){
//						point.isLastPoint = true;	/* set this to true on the last point */
//					}
//					num++;
//				}
//				motorLMaster.pushMotionProfileTrajectory(point);
//			} else if((! motorLMaster.isMotionProfileTopLevelBufferFull()) && num < prof.numPoints){
//				for (int i = 0; i < prof.numPoints; ++i) {
//					if(! motorLMaster.isMotionProfileTopLevelBufferFull()){
//						/* for each point, fill our structure and pass it to API */
//						point.position = prof.points[i][0];
//						point.velocity = prof.points[i][1];
//						point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//						point.profileSlotSelect0 = pidfSlot; 
//						point.profileSlotSelect1 = 0;
//						point.zeroPos = false;
//						if (i == 0){
//							point.zeroPos = true; /* set this to true on the first point */
//						}
//						point.isLastPoint = false;
//						if ((i + 1) == prof.numPoints){
//							point.isLastPoint = true;	/* set this to true on the last point */
//						}
//						motorLMaster.pushMotionProfileTrajectory(point);
//					} else {
//						i--;
//						try {
//							Thread.sleep(5);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}
//	}
//
//	private class RightTalonProfileSender implements java.lang.Runnable {
//		TrajectoryPoint point;
//		SrxMotionProfile prof;
//		int pidfSlot;
//		int num = 6;
//		public RightTalonProfileSender(SrxMotionProfile _prof, int _pidfSlot){
//			prof = _prof;
//			pidfSlot = _pidfSlot;
//		}
//		public void run() {
//			if((!motorRMaster.isMotionProfileTopLevelBufferFull()) && (6 < prof.numPoints) && (num < prof.numPoints)){
//				point = new TrajectoryPoint();
//				if(num < 6){
//					for (int i = 0; i < 6; ++i) {
//						if(! motorRMaster.isMotionProfileTopLevelBufferFull()){
//							/* for each point, fill our structure and pass it to API */
//							point.position = prof.points[i][0];
//							point.velocity = prof.points[i][1];
//							point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//							point.profileSlotSelect0 = pidfSlot; 
//							point.profileSlotSelect1 = 0;
//							point.zeroPos = false;
//							if (i == 0){
//								point.zeroPos = true; /* set this to true on the first point */
//							}
//							point.isLastPoint = false;
//							if ((i + 1) == prof.numPoints){
//								point.isLastPoint = true;	/* set this to true on the last point */
//							}
//						} else {
//							i--;
//							try {
//								Thread.sleep(5);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				} else {
//					point.position = prof.points[num][0];
//					point.velocity = prof.points[num][1];
//					point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//					point.profileSlotSelect0 = pidfSlot; 
//					point.profileSlotSelect1 = 0;
//					point.zeroPos = false;
//					if (num == 0){
//						point.zeroPos = true; /* set this to true on the first point */
//					}
//					point.isLastPoint = false;
//					if ((num + 1) == prof.numPoints){
//						point.isLastPoint = true;	/* set this to true on the last point */
//					}
//					num++;
//				}
//				motorRMaster.pushMotionProfileTrajectory(point);
//			} else if((! motorRMaster.isMotionProfileTopLevelBufferFull()) && num < prof.numPoints){
//				for (int i = 0; i < prof.numPoints; ++i) {
//					if(! motorRMaster.isMotionProfileTopLevelBufferFull()){
//						/* for each point, fill our structure and pass it to API */
//						point.position = prof.points[i][0];
//						point.velocity = prof.points[i][1];
//						point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
//						point.profileSlotSelect0 = pidfSlot; 
//						point.profileSlotSelect1 = 0;
//						point.zeroPos = false;
//						if (i == 0){
//							point.zeroPos = true; /* set this to true on the first point */
//						}
//						point.isLastPoint = false;
//						if ((i + 1) == prof.numPoints){
//							point.isLastPoint = true;	/* set this to true on the last point */
//						}
//						motorRMaster.pushMotionProfileTrajectory(point);
//					} else {
//						i--;
//						try {
//							Thread.sleep(5);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}
//	}

	
    /*public void initDefaultCommand() {
    	setDefaultCommand(new JoystickTankDrive());
    }
}*/

