package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.Color;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDShiftState extends Command {

    public LEDShiftState() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.led);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.ShiftState.UP == RobotMap.shiftState) {
    		Robot.led.setLEDBlue();
    	}else if(RobotMap.ShiftState.DOWN == RobotMap.shiftState) {
    		Robot.led.setLEDOrange();
    	}else {
    		RobotMap.color = Color.OFF;
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
