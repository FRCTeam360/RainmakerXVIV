package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addSequential(new IntakeControl(.5, 25, true));
    	addSequential(new LEDcolor(RobotMap.Color.GREEN, 3, 1.5, true));
    }
}
