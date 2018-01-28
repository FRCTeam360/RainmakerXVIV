package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftDropCubeLeftSwitch extends CommandGroup {
    public StartLeftDropCubeLeftSwitch() {
    	addSequential(new FollowTrajectory("LeftToLeftSwitch"));
    }
}