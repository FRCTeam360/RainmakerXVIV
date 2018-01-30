package org.usfirst.frc.team360.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Intake extends CommandGroup {
	
    public Intake() {
    	addSequential(new IntakeControl(.5, 25, true));
    }
}
