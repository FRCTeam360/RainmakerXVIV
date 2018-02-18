
// from FRC 319
package org.usfirst.frc.team360.robot.commands;


import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team360.robot.Robot;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc.team360.robot.pathfollower.*;

public class FollowTrajectory extends Command {

	private String trajectoryName = "";
	private int kMinPointsInTalon = 5;

	private boolean isFinished = false;

	private SrxTrajectory trajectoryToFollow = null;
	private SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser/AutonomousPaths/");

	private MotionProfileStatus rightStatus = new MotionProfileStatus();
	private MotionProfileStatus leftStatus = new MotionProfileStatus();

	private boolean hasPathStarted;

	/**
	 * this is only either Disable, Enable, or Hold. Since we'd never want one side
	 * to be enabled while the other is disabled, we'll use the same status for both
	 * sides.
	 */
	private SetValueMotionProfile setValue = SetValueMotionProfile.Disable;

	private class BufferLoader implements java.lang.Runnable {
		private int lastPointSent = 0;
		private TalonSRX talon;
		private SrxMotionProfile prof;
		private int pidfSlot;

		public BufferLoader(TalonSRX talon, SrxMotionProfile prof, int pidfSlot) {
			this.talon = talon;
			this.prof = prof;
			this.pidfSlot = pidfSlot;
		}

		public void run() {
			talon.processMotionProfileBuffer();

			if (lastPointSent >= prof.numPoints) {
				return;
			}

			while (!talon.isMotionProfileTopLevelBufferFull() && lastPointSent < prof.numPoints) {
				TrajectoryPoint point = new TrajectoryPoint();
				/* for each point, fill our structure and pass it to API */
				point.position = prof.points[lastPointSent][0];
				point.velocity = prof.points[lastPointSent][1];
				point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
				point.profileSlotSelect0 = pidfSlot;
				point.profileSlotSelect1 = pidfSlot;
				point.zeroPos = false;
				if (lastPointSent == 0) {
					point.zeroPos = true; /* set this to true on the first point */

				}
				point.isLastPoint = false;
				if ((lastPointSent + 1) == prof.numPoints) {
					point.isLastPoint = true; /* set this to true on the last point*/
				}
				talon.pushMotionProfileTrajectory(point);
				lastPointSent++;
				hasPathStarted = true;
			}
		}
	}

	// Runs the runnable
	private Notifier loadLeftBuffer;
	private Notifier loadRightBuffer;

	// constructor
	public FollowTrajectory(String trajectoryName) {
		requires(Robot.driveTrain);
		this.trajectoryName = trajectoryName;
	}

	public FollowTrajectory(SrxTrajectory trajectoryToFollow) {
		requires(Robot.driveTrain);
		this.trajectoryToFollow = trajectoryToFollow;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		setUpTalon(Robot.driveTrain.motorLMaster);
		setUpTalon(Robot.driveTrain.motorRMaster);

		setValue = SetValueMotionProfile.Disable;

		Robot.driveTrain.motorRMaster.set(ControlMode.MotionProfile, setValue.value);
		Robot.driveTrain.motorLMaster.set(ControlMode.MotionProfile, setValue.value);

		if (trajectoryToFollow == null) {

			try {
				this.trajectoryToFollow = importer.importSrxTrajectory(trajectoryName);
			} catch (Exception e) {
				System.out.println("Failed to import trajectory.");
				e.printStackTrace();
				isFinished = true;
				return;
			} 
		}


		loadLeftBuffer = new Notifier(
				new BufferLoader(Robot.driveTrain.motorLMaster, this.trajectoryToFollow.leftProfile, 0));
		loadRightBuffer = new Notifier(
				new BufferLoader(Robot.driveTrain.motorRMaster, this.trajectoryToFollow.rightProfile, 0));

		loadLeftBuffer.startPeriodic(.005);
		loadRightBuffer.startPeriodic(.005);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.driveTrain.motorRMaster.getMotionProfileStatus(rightStatus);
		Robot.driveTrain.motorLMaster.getMotionProfileStatus(leftStatus);

		if (rightStatus.isUnderrun || leftStatus.isUnderrun) {
			// if either MP has underrun, stop both
			System.out.println("Motion profile has underrun!");
			setValue = SetValueMotionProfile.Disable;
		} else if (rightStatus.btmBufferCnt > kMinPointsInTalon && leftStatus.btmBufferCnt > kMinPointsInTalon) {
			// if we have enough points in the talon, go.
			setValue = SetValueMotionProfile.Enable;
		} else if (rightStatus.activePointValid && rightStatus.isLast && leftStatus.activePointValid
				&& leftStatus.isLast) {
			// if both profiles are at their last points, hold the last point
			setValue = SetValueMotionProfile.Hold;
		}

		Robot.driveTrain.motorRMaster.set(ControlMode.MotionProfile, setValue.value);
		Robot.driveTrain.motorLMaster.set(ControlMode.MotionProfile, setValue.value);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!hasPathStarted) {
			return false;
		}
		boolean leftComplete = leftStatus.activePointValid && leftStatus.isLast;
		boolean rightComplete = rightStatus.activePointValid && rightStatus.isLast;
		boolean trajectoryComplete = leftComplete && rightComplete;
		return trajectoryComplete || isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		cleanUp();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		cleanUp();
	}
	
	public void cleanUp() {
		loadLeftBuffer.stop();
		loadRightBuffer.stop();
		resetTalon(Robot.driveTrain.motorRMaster, ControlMode.PercentOutput, 0);
		resetTalon(Robot.driveTrain.motorLMaster, ControlMode.PercentOutput, 0);
	}

	// set up the talon for motion profile control
	public void setUpTalon(TalonSRX talon) {
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
	}

	// set the to the desired controlMode
	// used at the end of the motion profile
	public void resetTalon(TalonSRX talon, ControlMode controlMode, double setValue) {
		talon.clearMotionProfileTrajectories();
		talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
		talon.set(controlMode, setValue);
	}

}