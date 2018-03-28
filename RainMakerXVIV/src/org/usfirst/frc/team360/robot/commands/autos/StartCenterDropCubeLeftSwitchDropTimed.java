package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartCenterDropCubeLeftSwitchDropTimed extends CommandGroup {

    public StartCenterDropCubeLeftSwitchDropTimed() {
        addSequential(new WaitCommand(3.2));
        addSequential(new IntakeAutoOut());
       }
}
