package org.usfirst.frc.team360.robot.commands;


import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addParallel(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
    	addSequential(new IntakeOpen());
    	addSequential(new IntakeControl(.5, 25, false));
    }
}
