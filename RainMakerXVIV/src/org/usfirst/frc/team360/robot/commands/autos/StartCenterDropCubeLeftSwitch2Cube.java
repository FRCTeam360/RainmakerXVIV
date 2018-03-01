package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeLeftSwitch2Cube extends CommandGroup {
    public StartCenterDropCubeLeftSwitch2Cube() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new StartCenterDropCubeLeftSwitchDropTimed());
        addSequential(new FollowTrajectory("CenterToLeftSwitch"));
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart1"));
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart2"));
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart3"));
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart4"));
    }
}