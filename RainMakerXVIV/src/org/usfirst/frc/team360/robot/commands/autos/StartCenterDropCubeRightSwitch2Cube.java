package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartCenterDropCubeRightSwitch2Cube extends CommandGroup {
    public StartCenterDropCubeRightSwitch2Cube() {
    	addSequential(new StartCenterDropCubeRightSwitch());
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart1"));
        addParallel(new MoveElevatorToIntakePos());
        addParallel(new IntakeControl(.5, false));
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart2"));
        addSequential(new IntakeClose());
        addSequential(new WaitCommand(.75));
        addParallel(new MoveElevatorToSwitchHeight());
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart3"));
		addParallel(new StartCenterDropCubeRightSwitchDropTimed2());
        addSequential(new FollowTrajectory("CenterToRightTwoCubePart4"));
    }
}
