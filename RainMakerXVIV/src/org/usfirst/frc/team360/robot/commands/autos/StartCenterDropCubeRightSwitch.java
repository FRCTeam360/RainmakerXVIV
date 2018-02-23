package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeRightSwitch extends CommandGroup {
    public StartCenterDropCubeRightSwitch() {
<<<<<<< HEAD
		addSequential(new AutoShift(RobotMap.ShiftState.UP)); 	
		addParallel(new StartCenterDropCubeRightSwitchDropTimed());
	   	 addParallel(new MoveElevatorToIntakePos());
    		addSequential(new FollowTrajectory("CenterToRightSwitch"));
=======
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new MoveElevatorToSwitchHeight());
    	addSequential(new FollowTrajectory("CenterToRightSwitch"));
    	addSequential(new IntakeAutoOut());
>>>>>>> 9fad9439ef149ce6b759eafe626a6f51c7005c38
    }
}