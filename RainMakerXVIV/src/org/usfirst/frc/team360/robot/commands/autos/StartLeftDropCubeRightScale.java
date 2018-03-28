package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftDropCubeRightScale extends CommandGroup {
    public StartLeftDropCubeRightScale() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new MoveElevatorToSwitchHeight());
    	addSequential(new FollowTrajectory("LeftToRightScalePart1"));
    	addParallel(new MoveElevatorToTopScale());
        addParallel(new StartLeftDropCubeRightScaleDropTimed());
    	addSequential(new FollowTrajectory("LeftToRightScalePart2"));
    	addSequential(new FollowTrajectory("MoveTwoFeetBack"));
    	addSequential(new StopElevator());
    }
}
