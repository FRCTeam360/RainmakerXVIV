package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossLineMotionProfiled extends CommandGroup {
    public CrossLineMotionProfiled() {
    		addSequential(new AutoShift(RobotMap.ShiftState.UP));
    		addSequential(new FollowTrajectory("CrossLine"));
    }
}