package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.NavXSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollisionDetection extends Command {


    public CollisionDetection() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		if (RobotMap.crashed == false) {
			Robot.navX.NavXCrash();
	    	
	    	Robot.driveTrain.driveR(.7);
	    	Robot.driveTrain.driveL(.7);
			
		}
		else {
			
	    	Robot.driveTrain.driveR(0);
	    	Robot.driveTrain.driveL(0);
	    	
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
