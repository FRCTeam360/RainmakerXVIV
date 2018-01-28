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
    	System.out.println(shouldRun+ " " + RobotMap.pdp.getVoltage());
//    	System.out.println(RobotMap.pdp.getVoltage());
//    	System.out.println(((double)Math.round(timer.get()*100))/100);
    	if(shouldRun == true && RobotMap.pdp.getVoltage() > 10.5) {
        	Robot.pneumatics.pressurize(); 	
    	} else if (shouldRun == true && ! (RobotMap.pdp.getVoltage() > 11.5)) {
    		shouldRun = false;
    		Robot.pneumatics.stop();
    		timer.reset();
    		timer.start();
    	}
    	
    	if (timer.get() > 0.5) {
    		timer.reset();
    		timer.stop();
    		shouldRun = true;
    	}
    	
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
