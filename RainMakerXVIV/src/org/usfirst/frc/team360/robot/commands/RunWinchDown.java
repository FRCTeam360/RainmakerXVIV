package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunWinchDown extends Command {

    public RunWinchDown() {
    		requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.logger.logWinchDown();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.winch.setMotorSpeed(-0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.winch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
