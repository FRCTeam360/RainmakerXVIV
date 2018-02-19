package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.Color;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDColor extends Command {
	
	RobotMap.Color color; // sets color from RobotMap to color in LEDcolor
	
	boolean pulse; // checks if pulsing is wanted
	boolean infinity;
	
	int cycle;			// the current cycle
	double period;		// how many times per second
	double duration; 	// how many seconds
	double totalCycles;	// limits number of cycles
	
	Timer time; // initialize timer as time

    public LEDColor(RobotMap.Color color, double period, double duration, boolean pulse, boolean infinity) {
    	this.color = color; // finds variable color(ex.RobotMap.Color.GREEN)
    	this.pulse = pulse; // finds if pulse is on or not
    	this.period = period; // finds variable period to find how frequently per time
    	this.duration = duration; // finds variable time of how long the pulse goes for
    	this.infinity = infinity;
    	this.cycle = 0; // initializes cycle to zero 
    	requires(Robot.led); // class requires the LED subsystem
    	
    	totalCycles = 0;
    	if((period > 0 && period < 1) || period >= 1) {
    		totalCycles = duration/period;
    	}
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer(); // initialize timer
    	time.start(); // start timing
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(pulse){ // when the boolean pulse is true, activates this code
        	if(time.get() < ((period)/2)) { // if the time is less than half the period, activates this code
        		Robot.led.changeColor(color); // changes color to set color(ex.green)
    		}else if(time.get() > (period/2) && time.get() < period) { // if the time is between half the period and one period, activate this code
    			RobotMap.color = Color.OFF; // turns off LEDs
    		}else{ // if the time is greater than one period, activates this code
        		time.stop(); // stops timer
        		time.reset(); // reset timer to 0
        		time.start(); // start timer again
        		cycle++; // add 1 to variable cycle
        	}
    	}else if(!pulse) {
    		if(time.get() < duration) {
    			Robot.led.changeColor(color);
    		}else {
    			RobotMap.color = Color.OFF;
    		}
    		
    	}else if(infinity) {
    		if(time.get() < ((period)/2)) { // if the time is less than half the period, activates this code
        		Robot.led.changeColor(color); // changes color to set color(ex.green)
    		}else if(time.get() > (period/2) && time.get() < period) { // if the time is between half the period and one period, activate this code
    			RobotMap.color = Color.OFF; // turns off LEDs
    		}else{ // if the time is greater than one period, activates this code
        		time.stop(); // stops timer
        		time.reset(); // reset timer to 0
        		time.start(); // start timer again
        	}
    	}else{ // if pulse is false, activate this code
    		Robot.led.changeColor(color); // set color(ex.green)
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return cycle >= totalCycles || !pulse; // if the current cycle is equal to or greater than max cycles OR invert the boolean pulse(if true -> false, if false -> true)
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
