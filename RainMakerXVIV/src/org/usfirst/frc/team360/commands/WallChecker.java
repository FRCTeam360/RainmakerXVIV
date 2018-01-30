package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WallChecker extends Command {


    public WallChecker() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.navX.navXread();
    	Robot.navX.navXcrash();
    	
		if (RobotMap.crashed == false) {
	    	Robot.navX.navXread();
	    	Robot.navX.navXcrash();
			Robot.driveTrain.DriveR(.7);
			Robot.driveTrain.DriveL(.7);
			
		}
		else {
			
	    	Robot.driveTrain.DriveR(0);
	    	Robot.driveTrain.DriveL(0);
	    	
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
