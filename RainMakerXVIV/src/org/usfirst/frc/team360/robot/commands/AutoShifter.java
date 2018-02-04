package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.ShiftState;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShifter extends Command {
	
	Timer timer;

    public AutoShifter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.reset();
    	timer.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(RobotMap.shiftState == ShiftState.UP) {
    		Robot.logger.logShiftUp();
    	} else if (RobotMap.shiftState == ShiftState.DOWN) {
        	Robot.shifter.shiftUp();
        	Robot.logger.logShiftUp();
        	timer.start();
    	} else {
    		Robot.logger.logBadShiftValue();
    	}
  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get() > .5) {
    		timer.reset();
    		return false;
    	} 
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
