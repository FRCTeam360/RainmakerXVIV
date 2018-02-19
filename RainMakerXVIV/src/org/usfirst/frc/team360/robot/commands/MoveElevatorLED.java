package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorLED extends CommandGroup {

    public MoveElevatorLED() {
    		addSequential(new LEDColor(RobotMap.Color.VIOLET, 1/3, 3, true, false));
    }
}
