package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class CollisionDetection extends Command {


    public CollisionDetection() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.driveR(.7);
	    	Robot.driveTrain.driveL(.7);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		Robot.navX.NavXCrash();
        return RobotMap.crashed;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
