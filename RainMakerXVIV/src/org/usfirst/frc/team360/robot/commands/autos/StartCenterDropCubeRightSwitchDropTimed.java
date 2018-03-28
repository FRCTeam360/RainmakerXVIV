package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartCenterDropCubeRightSwitchDropTimed extends CommandGroup {

    public StartCenterDropCubeRightSwitchDropTimed() {
        addSequential(new WaitCommand(2.9));
        addSequential(new IntakeAutoOut());
    }
}
