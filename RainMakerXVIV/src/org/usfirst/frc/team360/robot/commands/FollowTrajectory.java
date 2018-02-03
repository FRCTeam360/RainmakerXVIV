package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.pathfollower.*;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;

import com.ctre.phoenix.motion.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class FollowTrajectory extends Command {

	private String trajectoryToFollow;
	private int kMinPointsInTalon = 5;
	
	private boolean isFinished = false;

	TalonSRX leftLead = Robot.driveTrain.motorLMaster;
	TalonSRX rightLead = Robot.driveTrain.motorRMaster;
	
	private SrxTrajectory traj;
	private SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser/AutonomousPaths");

	private MotionProfileStatus rightStatus = new MotionProfileStatus();
	private MotionProfileStatus leftStatus = new MotionProfileStatus();

	/**
	 * this is only either Disable, Enable, or Hold. Since we'd never want one
	 * side to be enabled while the other is disabled, we'll use the same status
	 * for both sides.
	 */
	private SetValueMotionProfile setValue = SetValueMotionProfile.Disable;
	
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
				if(num < 6){
					for (num = 0; num <= 6; num++) {
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


	// Runs the runnable
	private Notifier leftTalonSender;
	private Notifier rightTalonSender;
	// constructor
	public FollowTrajectory(String _trajectoryName) {
		requires(Robot.driveTrain);
		trajectoryToFollow = _trajectoryName;
		traj = importer.importSrxTrajectory(trajectoryToFollow);
	}
	// Called just before this Command runs the first time
	protected void initialize() {
		
		Robot.logger.logFollowTrajectory();
		setUpTalon(leftLead);
		setUpTalon(rightLead);

		setValue = SetValueMotionProfile.Disable;
		
		leftLead.set(ControlMode.MotionProfile, setValue.value);
		rightLead.set(ControlMode.MotionProfile, setValue.value);

		leftTalonSender = new Notifier(new TalonProfileSender(leftLead, traj.leftProfile, 0));
		rightTalonSender = new Notifier(new TalonProfileSender(rightLead, traj.rightProfile, 0));
		
		leftTalonSender.startPeriodic(.005);
		rightTalonSender.startPeriodic(.005);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		rightLead.getMotionProfileStatus(rightStatus);
		leftLead.getMotionProfileStatus(leftStatus);

		if (rightStatus.isUnderrun || leftStatus.isUnderrun)
		{
			// if either MP has underrun, stop both
			System.out.println("Motion profile has underrun!");
			setValue = SetValueMotionProfile.Disable;
		}
		else if (rightStatus.btmBufferCnt > kMinPointsInTalon && leftStatus.btmBufferCnt > kMinPointsInTalon)
		{
			// if we have enough points in the talon, go.
			setValue = SetValueMotionProfile.Enable;
		}	
		else if (rightStatus.activePointValid && rightStatus.isLast && leftStatus.activePointValid
				&& leftStatus.isLast)
		{
			// if both profiles are at their last points, hold the last point
			setValue = SetValueMotionProfile.Hold;
		}
		
		leftLead.set(ControlMode.MotionProfile, setValue.value);
		rightLead.set(ControlMode.MotionProfile, setValue.value);	
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		boolean leftComplete = leftStatus.activePointValid && leftStatus.isLast;
		boolean rightComplete = rightStatus.activePointValid && rightStatus.isLast;
		boolean trajectoryComplete = leftComplete && rightComplete;
	//	System.out.println(trajectoryComplete);
		return trajectoryComplete || isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		leftTalonSender.stop();
		rightTalonSender.stop();
		resetTalon(rightLead, ControlMode.PercentOutput, 0);
		resetTalon(leftLead, ControlMode.PercentOutput, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}	

	// set up the talon for motion profile control
	public void setUpTalon(TalonSRX talon) {
		talon.setSelectedSensorPosition(0, 0, 10);
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
		talon.configNominalOutputForward(0, 10);
		talon.configNominalOutputReverse(0, 10);
		talon.configPeakOutputForward(12, 10);
		talon.configPeakOutputReverse(-12, 10);
		talon.setSelectedSensorPosition(0, 0, 10);
		talon.enableCurrentLimit(false);
	}

	// set the to the desired controlMode
	// used at the end of the motion profile
	public void resetTalon(TalonSRX talon, ControlMode controlMode, double setValue) {
		talon.clearMotionProfileTrajectories();
		talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
		talon.set(controlMode, setValue);
	}
}