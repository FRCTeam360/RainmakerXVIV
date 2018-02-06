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
    }
}
