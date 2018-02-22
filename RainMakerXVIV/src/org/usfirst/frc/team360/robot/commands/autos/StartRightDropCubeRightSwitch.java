package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRightDropCubeRightSwitch extends CommandGroup {
    public StartRightDropCubeRightSwitch() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
<<<<<<< HEAD
   	 	addParallel(new StartRightDropCubeRightSwitchDropTimed());
   	 addParallel(new MoveElevatorToIntakePos());
    	addSequential(new FollowTrajectory("RightToRightSwitch"));
=======
		addParallel(new MoveElevatorToSwitchHeight());
    	addSequential(new FollowTrajectory("RightToRightSwitch"));
    	addSequential(new IntakeAutoOut());
>>>>>>> 9fad9439ef149ce6b759eafe626a6f51c7005c38
    }
}