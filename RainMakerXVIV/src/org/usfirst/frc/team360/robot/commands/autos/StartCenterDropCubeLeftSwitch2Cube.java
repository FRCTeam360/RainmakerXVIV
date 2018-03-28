package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartCenterDropCubeLeftSwitch2Cube extends CommandGroup {
    public StartCenterDropCubeLeftSwitch2Cube() {
    	addSequential(new StartCenterDropCubeLeftSwitch());
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart1"));
        addParallel(new MoveElevatorToIntakePos());
        addParallel(new IntakeControl(.5, false));
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart2"));
        addSequential(new IntakeClose());
        addParallel(new MoveElevatorToSwitchHeight());
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart3"));
		addParallel(new StartCenterDropCubeLeftSwitchDropTimed2());
        addSequential(new FollowTrajectory("CenterToLeftTwoCubePart4"));

    }
}
