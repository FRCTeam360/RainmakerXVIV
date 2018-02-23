package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftDropCubeLeftSwitch extends CommandGroup {
    public StartLeftDropCubeLeftSwitch() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new StartCenterDropCubeLeftSwitchDropTimed());
	   	addParallel(new MoveElevatorToIntakePos());
    	addSequential(new FollowTrajectory("LeftToLeftSwitch"));
    }
}