package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeLeftSwitch extends CommandGroup {
    public StartCenterDropCubeLeftSwitch() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
<<<<<<< HEAD
		addParallel(new StartCenterDropCubeLeftSwitchDropTimed());
	   	 addParallel(new MoveElevatorToIntakePos());
=======
		addParallel(new MoveElevatorToSwitchHeight());
>>>>>>> 9fad9439ef149ce6b759eafe626a6f51c7005c38
        addSequential(new FollowTrajectory("CenterToLeftSwitch"));
        addSequential(new IntakeAutoOut());
    }
}