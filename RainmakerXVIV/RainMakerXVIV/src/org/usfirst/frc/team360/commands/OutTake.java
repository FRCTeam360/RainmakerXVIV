package org.usfirst.frc.team360.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OutTake extends CommandGroup {
	
    public OutTake() {
    	addSequential(new IntakeControl(-.75, 25, false));
    }
}
