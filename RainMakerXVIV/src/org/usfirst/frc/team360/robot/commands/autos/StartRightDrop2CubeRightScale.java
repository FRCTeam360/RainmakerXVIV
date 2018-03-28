package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartRightDrop2CubeRightScale extends CommandGroup {
    public StartRightDrop2CubeRightScale() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));   
//	   	addParallel(new MoveElevatorOffGround());
	   	addSequential(new WaitCommand(.75));
		addParallel(new StartRightDropCubeRightScaleDropTimed());
		addParallel(new StartRightDropCubeRightScaleRaiseTimed());
    	addSequential(new FollowTrajectory("RightToRightScale"));
    	addSequential(new FollowTrajectory("RightToRightScalePart1"));
    	addSequential(new FollowTrajectory("RightToRightScalePart2"));
    	addSequential(new FollowTrajectory("RightToRightScalePart3"));
    	addSequential(new FollowTrajectory("RightToRightScalePart4"));
    }
}