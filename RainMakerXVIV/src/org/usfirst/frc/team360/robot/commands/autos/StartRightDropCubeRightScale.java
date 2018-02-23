package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartRightDropCubeRightScale extends CommandGroup {
    public StartRightDropCubeRightScale() {
<<<<<<< HEAD
		addSequential(new AutoShift(RobotMap.ShiftState.UP));   
	   	addParallel(new MoveElevatorOffGround());
	   	addSequential(new WaitCommand(.75));
		addParallel(new StartRightDropCubeRightScaleDropTimed());
		addParallel(new StartRightDropCubeRightScaleRaiseTimed());
    	addSequential(new FollowTrajectory("RightToRightScale"));
    	addSequential(new FollowTrajectory("MoveTwoFeetBack"));
=======
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new MoveElevatorToSwitchHeight());
    	addSequential(new FollowTrajectory("RightToRightScale"));
    	addSequential(new IntakeAutoOut());
>>>>>>> 9fad9439ef149ce6b759eafe626a6f51c7005c38
    }
}