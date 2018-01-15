package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VictorAmp extends Command {

    public VictorAmp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_Victor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(PowerDistributionPanel pdp, int channel) {
    	channel = 2;
    	double Amp = pdp.getCurrent(channel);
    	if(Amp >= 10) {
    		Robot.m_Victor.stopMotor();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_Victor.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
