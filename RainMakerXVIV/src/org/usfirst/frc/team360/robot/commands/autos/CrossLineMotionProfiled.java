package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossLineMotionProfiled extends CommandGroup {
    public CrossLineMotionProfiled() {
//    	addSequential(new AutoShift(RobotMap.ShiftState.UP));
//    	addSequential(new FollowTrajectory("CrossLine"));
    	addSequential(new AutoShift(RobotMap.ShiftState.UP));
    	//addParallel(new StartLeftDropCubeLeftScaleDropTimed());
    	//addParallel(new StartLeftDropCubeLeftScaleRaiseTimed());
    	addSequential(new FollowTrajectory("LeftToLeftScale"));
        //addSequential(new FollowTrajectory("MoveTwoFeetBack"));
        //addSequential(new MoveElevatorToIntakePos());
        addSequential(new FollowTrajectory("LeftToLeftScaleTwoCubePart1"));
        addSequential(new FollowTrajectory("LeftToLeftScaleTwoCubePart2"));
        addSequential(new FollowTrajectory("LeftToLeftScaleTwoCubePart3"));
        addSequential(new FollowTrajectory("LeftToLeftScaleTwoCubePart4"));
    }
}