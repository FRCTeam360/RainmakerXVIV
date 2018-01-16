package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollisionDetect extends Command {
	
	static double last_world_linear_accel_x;
    static double last_world_linear_accel_y;
    
    static boolean collisionDetected = false;
    
    final static double kCollisionThreshold_DeltaG = 1.5f;
	
    static int timesTriggered = 0;

    public CollisionDetect() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.navX);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    	    double curr_world_linear_accel_x = RobotMap.navX.getWorldLinearAccelX();
    	    double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
    	    last_world_linear_accel_x = curr_world_linear_accel_x;
    	    double curr_world_linear_accel_y = RobotMap.navX.getWorldLinearAccelY();
    	    double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
    	    last_world_linear_accel_y = curr_world_linear_accel_y;
    		    
    	    if ( ( Math.abs(currentJerkX) > kCollisionThreshold_DeltaG ) ||
    	         ( Math.abs(currentJerkY) > kCollisionThreshold_DeltaG) ) {
    	        collisionDetected = true;
    	        timesTriggered++;
    	        DriverStation.reportError("TRIGGERED!!!, Times Triggered: " + timesTriggered, false);
    	        
    	    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
