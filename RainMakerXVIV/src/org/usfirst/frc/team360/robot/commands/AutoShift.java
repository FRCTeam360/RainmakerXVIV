package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoShift extends Command {
	
	Timer timer;
	RobotMap.ShiftState wantedShiftState;
	boolean done;
    public AutoShift(RobotMap.ShiftState shifterState) {
    		requires(Robot.shifter);
    		wantedShiftState = shifterState;
    		done = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	    	timer = new Timer();
	    	timer.reset();
	    	timer.stop();
	    	if(RobotMap.shiftState == wantedShiftState) {
	    		done = true;
	    } else {
		    	if(RobotMap.shiftState == RobotMap.ShiftState.UP) {
		    		Robot.shifter.shiftUp();
		    		Robot.logger.logShiftUp();
		        	timer.start();
		    	} else {
		        	Robot.shifter.shiftDown();
		        	Robot.logger.logShiftDown();
		        	timer.start();
		    	} 
	    }
    }
  
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	    	return timer.get() > 1.5 || done == true;
    }

    // Called once after isFinished returns true
    protected void end() {
    		timer.reset();
    		timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
