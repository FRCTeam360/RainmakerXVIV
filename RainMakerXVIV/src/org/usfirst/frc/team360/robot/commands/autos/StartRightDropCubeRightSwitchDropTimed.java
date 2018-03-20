package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartRightDropCubeRightSwitchDropTimed extends CommandGroup {
    public StartRightDropCubeRightSwitchDropTimed() {
        addSequential(new WaitCommand(4.25));
        addSequential(new IntakeOpen());
        }
}
