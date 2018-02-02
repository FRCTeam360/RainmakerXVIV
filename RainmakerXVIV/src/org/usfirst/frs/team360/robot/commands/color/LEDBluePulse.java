package org.usfirst.frs.team360.robot.commands.color;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDBluePulse extends Command {
	
	Timer time;
	
    public LEDBluePulse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LED);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(time.get() < .5) {
    		Robot.LED.setLEDBlue();
    	}else if(time.get() < 1) {
    		RobotMap.LED_Control.disable();
    		time.reset();
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
