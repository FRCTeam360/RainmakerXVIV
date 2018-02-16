package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeOut extends CommandGroup {
	
    public IntakeOut() {
		addSequential(new IntakeOpen());
    		addSequential(new IntakeControl(-.5, false));
    }
}