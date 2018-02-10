package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorToMidScale extends CommandGroup {

    public MoveElevatorToMidScale() {
    		addSequential(new MoveElevator(RobotMap.midScale));
    }
}
