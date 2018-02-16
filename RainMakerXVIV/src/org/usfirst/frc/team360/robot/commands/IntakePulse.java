package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakePulse extends Command {
	
	PowerDistributionPanel pdp = RobotMap.pdp;
	
	double speed;
	double amps;
	double period;
	boolean currentStop;
	
	double oldCurrent = 0;
	
	Timer time;
	Timer timerStop;
	Timer time3;
	boolean hasStarted = false;

    public IntakePulse(double speed, double amps, double period, boolean currentStop) {
    		requires(Robot.intake);
	    	this.speed = speed;
	    	this.amps = amps;
	    	this.period = period;
	    	this.currentStop = currentStop;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	    	time = new Timer();
	    	time.start();
	    	timerStop = new Timer();
	    	timerStop.start();
	    	time3 = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    	if(time.get() < period/2) {
	    		Robot.intake.controlRightMotor(speed);
	    	}else if(time.get() > period/2 && time.get() < period) {
	    		Robot.intake.controlRightMotor(0);
	    	}else {
	    		time.stop();
	    		time.reset();
	    		time.start();
	    	}
	    	if(Robot.intake.currentDraw() > amps && !hasStarted) {
	    		time3.start();
	    		hasStarted = true;
	    		
	    	}
	    	Robot.intake.controlLeftMotor(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return Robot.intake.currentDraw() > amps; // && currentStop;
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
