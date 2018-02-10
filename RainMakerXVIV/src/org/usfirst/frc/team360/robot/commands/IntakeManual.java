package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeManual extends Command {

    public IntakeManual() {
    		requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(Math.abs(OI.joyOI.getRawAxis(4)) > .1) {
    			Robot.intake.controlMotor(OI.joyOI.getRawAxis(4));
    		} else {
    			Robot.intake.stop();
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
