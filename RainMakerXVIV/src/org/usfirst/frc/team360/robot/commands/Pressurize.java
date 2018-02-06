package org.usfirst.frc.team360.robot.commands;


import org.usfirst.frc.team360.robot.*;

import edu.wpi.first.wpilibj.RobotController;
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
	    	Robot.logger.logPressurize();
    }

    protected void execute() {
    		if(shouldRun == true && RobotController.getInputVoltage() > 10) {
    			Robot.pneumatics.pressurize(); 	
    		} else if (shouldRun == true && ! (RobotController.getInputVoltage() > 10)) {
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
