package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartRightDropCubeRightScale extends CommandGroup {
    public StartRightDropCubeRightScale() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));   
//	   	addParallel(new MoveElevatorOffGround());
	   	addSequential(new WaitCommand(.75));
		addParallel(new StartRightDropCubeRightScaleDropTimed());
		addParallel(new StartRightDropCubeRightScaleRaiseTimed());
    	addSequential(new FollowTrajectory("RightToRightScale"));
    	addSequential(new FollowTrajectory("MoveTwoFeetBack"));
    }
}