package org.usfirst.frc.team360.robot.commands;


import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
	    	addParallel(new LEDColor(RobotMap.Color.RED, 1/3, 2, true));
	    	addSequential(new IntakeControl(1, 25, true));
	    	addSequential(new IntakeClose());
	    	addSequential(new LEDColor(RobotMap.Color.GREEN, 2/3, 3, true));
	    	Robot.logger.logIntakeIn();
    }
}
