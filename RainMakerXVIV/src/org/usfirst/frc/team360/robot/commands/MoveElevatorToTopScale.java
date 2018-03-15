package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Constants;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorToTopScale extends CommandGroup {

    public MoveElevatorToTopScale() {
    		addSequential(new MoveElevator(Constants.realElevatorTopScale));
    }
}
