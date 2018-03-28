package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team360.robot.commands.IntakeOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartRightDropCubeLeftScaleDropTimed extends CommandGroup {
    public StartRightDropCubeLeftScaleDropTimed() {
        addSequential(new WaitCommand(2.75));
        addSequential(new IntakeAutoOut());
        }
}
