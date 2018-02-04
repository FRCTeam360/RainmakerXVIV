package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterDropCubeLeftSwitch extends CommandGroup {
    public StartCenterDropCubeLeftSwitch() {
        addSequential(new FollowTrajectory("CenterToLeftSwitch"));
		addSequential(new AutoShift(RobotMap.ShiftState.UP));
    }
}