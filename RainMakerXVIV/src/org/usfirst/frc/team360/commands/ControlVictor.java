package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlVictor extends Command {
	
	PowerDistributionPanel pdp;
    double Amp = pdp.getCurrent(2);
	
    public ControlVictor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_Victor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_Victor.VictorAmp();
    	Robot.m_Victor.ControlVictor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if(Amp >= 10) {
    		Robot.m_Victor.stopMotor();
    		return true;
    	} else {
    		return false;
    	}
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
