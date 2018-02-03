package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDcolor extends Command {
	
	RobotMap.Color color;
	
	boolean pulse;
	
	double Hz = 0;
	int cycle = 0;
	double duration = 0;
	double y = duration * Hz;
	
	Timer time;

    public LEDcolor(RobotMap.Color color, double Hz, double duration, boolean pulse) {
    	this.color = color;
    	this.pulse = pulse;
    	this.Hz = Hz;
    	this.duration = duration;
    	requires(Robot.LED);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(pulse == true) {
        	
        	if(time.get() < (.5/Hz)) {
        		Robot.LED.changeColor(color);
    		}else if(time.get() < (1/(Hz))) {
    			RobotMap.LED_Control.disable();
    		}
        	
        	if(time.get() > (1/(Hz))) {
        		time.stop();
        		time.reset();
        		time.start();
        		cycle++;
        	}
    	}
    	Robot.LED.changeColor(color);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return cycle == y && pulse == true;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
