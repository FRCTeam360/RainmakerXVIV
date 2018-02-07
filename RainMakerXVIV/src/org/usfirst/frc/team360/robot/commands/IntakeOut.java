package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeOut extends CommandGroup {
	
    public IntakeOut() {
    		addSequential(new IntakeControl(-.75, 25, false));
    }
}