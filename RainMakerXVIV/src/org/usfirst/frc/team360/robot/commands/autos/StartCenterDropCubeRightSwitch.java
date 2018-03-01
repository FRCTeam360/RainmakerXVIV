package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeRightSwitch extends CommandGroup {
    public StartCenterDropCubeRightSwitch() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP)); 	
	   	addParallel(new MoveElevatorToSwitchHeight());
		addParallel(new StartCenterDropCubeRightSwitchDropTimed());
	   	addSequential(new FollowTrajectory("CenterToRightSwitch"));
    }
}