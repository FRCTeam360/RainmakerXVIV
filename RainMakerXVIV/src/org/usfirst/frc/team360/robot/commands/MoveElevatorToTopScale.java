package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorToTopScale extends CommandGroup {

    public MoveElevatorToTopScale() {
    		addSequential(new MoveElevator(RobotMap.topScale));
    }
}
