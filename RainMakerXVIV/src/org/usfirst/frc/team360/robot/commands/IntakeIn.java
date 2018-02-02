package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frs.team360.robot.commands.color.LEDIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addSequential(new IntakeControl(.5, 25, true));
    	addSequential(new LEDIntake());
    }
}
