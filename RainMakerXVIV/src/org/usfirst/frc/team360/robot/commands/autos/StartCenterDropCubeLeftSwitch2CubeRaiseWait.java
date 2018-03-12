package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartCenterDropCubeLeftSwitch2CubeRaiseWait extends CommandGroup {
    public StartCenterDropCubeLeftSwitch2CubeRaiseWait() { 
    	addSequential(new WaitCommand(1));
    	addSequential(new MoveElevatorToIntakePos());
    }
}