package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Pressurize extends Command {

	Timer timer;
	
    public Pressurize() {
    	requires (Robot.pneumatics);
    }

    protected void initialize() {
    	timer.reset();
    }

    protected void execute() {
    	
    	timer.start();
    	
    	if(RobotMap.pdp.getVoltage() >= 10.0 && timer.hasPeriodPassed(10.0) == true) {
    		
    		Robot.pneumatics.pressurize(); 
    		
    		timer.reset();
    		
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.stop();
    	timer.stop();
    }

    protected void interrupted() {
    	end();
    }
}