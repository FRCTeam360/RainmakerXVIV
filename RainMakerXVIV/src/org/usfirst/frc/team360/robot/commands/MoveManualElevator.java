package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveManualElevator extends Command {

    public MoveManualElevator() {
    		requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shouldElevatorStop = false; 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(Math.abs(OI.joyOI.getRawAxis(5)) > .1) {
    			Robot.elevator.setMotor(-OI.joyOI.getRawAxis(5)*.5);
    		} else {
    			Robot.elevator.stop();
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
