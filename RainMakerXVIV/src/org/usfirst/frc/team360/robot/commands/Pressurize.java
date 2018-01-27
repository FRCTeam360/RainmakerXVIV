package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Pressurize extends Command {

	Timer timer;
	boolean shouldRun;
	
	
    public Pressurize() {
    	requires (Robot.pneumatics);
    }

    protected void initialize() {
    	timer = new Timer();
    	shouldRun = true;
    	timer.reset();
    	timer.stop();
    }

    protected void execute() {
    	System.out.println(RobotMap.pdp.getVoltage());
    	System.out.println(shouldRun);
    	if(shouldRun == true && RobotMap.pdp.getVoltage() > 11.6) {
    		
        	Robot.pneumatics.pressurize(); 
        		
    	}
    	
    	else {
    		
    		shouldRun = false;
    		//Robot.pneumatics.stop();
    		timer.start();
    		
    	}
    	
    	if (timer.get() > 10.0) {
    		
    		timer.reset();
    		timer.stop();
    		shouldRun = true;
    		
    	}
    	System.out.println(timer.get());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	timer.stop();
    	timer.reset();
    	Robot.pneumatics.stop();
    }

    protected void interrupted() {
    	end();
    }
}