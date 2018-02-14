package org.usfirst.frc.team360.robot.commands;


import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addParallel(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
    	addSequential(new IntakeControl(.5, 25, true));
    	addSequential(new IntakeClose());
    	addSequential(new LEDColor(RobotMap.Color.GREEN, 0, 2, false, false));
    	Robot.logger.logIntakeIn();
    }
}
