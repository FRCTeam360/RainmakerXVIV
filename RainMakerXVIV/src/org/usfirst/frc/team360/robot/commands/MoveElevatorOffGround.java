package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Constants;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveElevatorOffGround extends CommandGroup {

    public MoveElevatorOffGround() {
    		addSequential(new MoveElevator(Constants.realElevatorOffGround));
    }
}
