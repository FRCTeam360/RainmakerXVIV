package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team360.robot.commands.IntakeOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartLeftDropCubeLeftSwitchDropTimed extends CommandGroup {
    public StartLeftDropCubeLeftSwitchDropTimed() {
        addSequential(new WaitCommand(4.2));
        addSequential(new IntakeOpen());
        }
}
