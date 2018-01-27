package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.*;
import org.usfirst.frc.team360.robot.subsystems.Logger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetTalonSpeed extends Command {

    public GetTalonSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.logger.logGetFPGATime();
    	if(RobotMap.fpgaTime % 1 == 0) {
    	Robot.logger.logTalonSRX();
    	DriverStation.reportError("current FPGA time: " + RobotMap.fpgaTime, false);
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
