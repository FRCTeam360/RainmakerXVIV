package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevetorToSwitchHeight extends CommandGroup {

    public MoveElevetorToSwitchHeight() {
        	addSequential(new MoveElevator(RobotMap.switchHeight));
    }
}
