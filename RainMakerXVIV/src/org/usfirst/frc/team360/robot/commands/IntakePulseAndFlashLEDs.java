package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakePulseAndFlashLEDs extends CommandGroup {

    public IntakePulseAndFlashLEDs() {
//    		addParallel(new LEDColor(RobotMap.Color.RED, 1.5, 100, true, false));
//	    	addSequential(new IntakeClose());
//	    	addSequential(new IntakePulse(.75, 18, .25, true));
//	    	addSequential(new IntakeClose());
//	    	addSequential(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
		addParallel(new LEDColor(RobotMap.Color.RED, 1.5, 100, true, false));
    	addSequential(new IntakeNeutral());
    	addSequential(new IntakePulse(.5, 18, .25, true));
    	addSequential(new IntakeClose());
    	addSequential(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
    	}
}