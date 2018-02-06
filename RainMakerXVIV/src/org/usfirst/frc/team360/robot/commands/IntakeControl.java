package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeControl extends Command {
    
    double speed;
	double amps;
	boolean currentStop;
	
	Timer time;
	
    public IntakeControl(double speed, double amps, boolean currentStop) {
	    	this.speed = speed;
	    	this.amps = amps;
	    	this.currentStop = currentStop;
	    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.controlMotor(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return Robot.intake.currentDraw() > amps && currentStop;
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