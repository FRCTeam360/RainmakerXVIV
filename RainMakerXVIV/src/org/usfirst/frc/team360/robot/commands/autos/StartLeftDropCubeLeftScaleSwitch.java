package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.AutoShift;
import org.usfirst.frc.team360.robot.commands.FollowTrajectory;
import org.usfirst.frc.team360.robot.commands.IntakeClose;
import org.usfirst.frc.team360.robot.commands.MoveElevatorToIntakePos;
import org.usfirst.frc.team360.robot.commands.MoveElevatorToSwitchHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StartLeftDropCubeLeftScaleSwitch extends CommandGroup {
    public StartLeftDropCubeLeftScaleSwitch() {
    	addSequential(new AutoShift(RobotMap.ShiftState.UP));
    	addParallel(new StartLeftDropCubeLeftScaleDropTimed());
    	addParallel(new StartLeftDropCubeLeftScaleRaiseTimed());
    	addSequential(new FollowTrajectory("LeftToLeftScale"));
        addSequential(new FollowTrajectory("MoveTwoFeetBack"));
        addParallel(new MoveElevatorToIntakePos());
        addSequential(new FollowTrajectory(""));
        addSequential(new IntakeClose());
        addParallel(new MoveElevatorToSwitchHeight());
        addSequential(new FollowTrajectory(""));
        }
}
