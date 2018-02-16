package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.pathfollower.*;
import com.ctre.phoenix.motion.*;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class FollowTrajectory_Test extends Command {

	private String trajectoryToFollow;
	private int kMinPointsInTalon = 5;
	
	private boolean isFinished = false;
	
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

	// Runs the runnable
	// constructor
	public FollowTrajectory_Test(String _trajectoryName) {
		requires(Robot.driveTrain);
		trajectoryToFollow = _trajectoryName;
		traj = importer.importSrxTrajectory(trajectoryToFollow);
	}
	// Called just before this Command runs the first time
	protected void initialize() {
		
		Robot.logger.logFollowTrajectory();
		Robot.driveTrain.setUpLeftTalonForMotionControl();
		Robot.driveTrain.setUpRightTalonForMotionControl();

		setValue = SetValueMotionProfile.Disable;
		
		Robot.driveTrain.driveMotionProfileRight(ControlMode.MotionProfile, setValue);
		Robot.driveTrain.driveMotionProfileLeft(ControlMode.MotionProfile, setValue);
		
		Robot.driveTrain.runThreadedProfileSenders(traj);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		rightStatus = Robot.driveTrain.getRightMotioProfileStatus();
		leftStatus = Robot.driveTrain.getLeftMotioProfileStatus();

		if (rightStatus.isUnderrun || leftStatus.isUnderrun)
		{
			// if either MP has underrun, stop both
			DriverStation.reportError("Motion profile has underrun!", true);
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
		
		Robot.driveTrain.driveMotionProfileRight(ControlMode.MotionProfile, setValue);
		Robot.driveTrain.driveMotionProfileLeft(ControlMode.MotionProfile, setValue);	
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
		Robot.driveTrain.stopThreadedProfileSenders();
		Robot.driveTrain.endMotionProfilingLeft();
		Robot.driveTrain.endMotionProfilingRight();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}	
}