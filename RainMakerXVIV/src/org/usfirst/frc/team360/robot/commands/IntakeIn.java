package org.usfirst.frc.team360.robot.commands;


import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addSequential(new IntakeControl(.5, 25, true));
    	Robot.logger.logIntakeIn();
    	addSequential(new LEDcolor(RobotMap.Color.GREEN, 1/3, 2, true));
    	addSequential(new IntakeControl(.5, 25, true));
	    addSequential(new LEDcolor(RobotMap.Color.GREEN, 1/3, 2, true));
    }
}
