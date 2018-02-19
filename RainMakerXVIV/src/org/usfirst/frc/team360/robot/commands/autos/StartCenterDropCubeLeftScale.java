package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeLeftScale extends CommandGroup {
    public StartCenterDropCubeLeftScale() {
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
		addParallel(new MoveElevatorToSwitchHeight());
        addSequential(new FollowTrajectory("CenterToLeftScale"));
        addSequential(new IntakeAutoOut());
    }
}