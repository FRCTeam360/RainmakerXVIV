package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartLeftDropCubeLeftScale extends CommandGroup {
    public StartLeftDropCubeLeftScale() {
    	addSequential(new AutoShift(RobotMap.ShiftState.UP));
    	addParallel(new StartLeftDropCubeLeftScaleDropTimed());
    	addParallel(new StartLeftDropCubeLeftScaleRaiseTimed());
    	addSequential(new FollowTrajectory("LeftToLeftScale"));
        addSequential(new FollowTrajectory("MoveTwoFeetBack"));
        addSequential(new MoveElevatorToIntakePos());
    }
}