package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRightDropCubeRightSwitch extends CommandGroup {
    public StartRightDropCubeRightSwitch() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
	   	addParallel(new MoveElevatorToSwitchHeight());
   	 	addParallel(new StartRightDropCubeRightSwitchDropTimed());
    	addSequential(new FollowTrajectory("RightToRightSwitch"));
    }
}