package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeAutoOut extends CommandGroup {
	
    public IntakeAutoOut() {
    	addSequential(new IntakeAutoControl(-.5, true, .5));
		addSequential(new IntakeOpen());
    }
}