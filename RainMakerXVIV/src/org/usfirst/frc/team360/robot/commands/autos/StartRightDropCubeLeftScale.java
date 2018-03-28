package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRightDropCubeLeftScale extends CommandGroup {
    public StartRightDropCubeLeftScale() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
    	addParallel(new MoveElevatorToSwitchHeight());
    	addSequential(new FollowTrajectory("RightToLeftScalePart1"));
    	addParallel(new MoveElevatorToTopScale());
        addParallel(new StartRightDropCubeLeftScaleDropTimed());
    	addSequential(new FollowTrajectory("RightToLeftScalePart2"));
    	addSequential(new FollowTrajectory("MoveTwoFeetBack"));
    	addSequential(new StopElevator());
    }
}