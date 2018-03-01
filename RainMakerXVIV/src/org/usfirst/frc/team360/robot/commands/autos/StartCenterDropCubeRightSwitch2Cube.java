package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeRightSwitch2Cube extends CommandGroup {
    public StartCenterDropCubeRightSwitch2Cube() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP)); 	
		addParallel(new StartCenterDropCubeRightSwitchDropTimed());
	   	addSequential(new FollowTrajectory("CenterToRightSwitch"));
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart1"));
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart2"));
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart3"));
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart4"));
    }
}