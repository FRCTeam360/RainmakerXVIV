package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team360.robot.commands.IntakeOpen;
import org.usfirst.frc.team360.robot.commands.IntakeOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartLeftDropCubeRightScaleDropTimed extends CommandGroup {
    public StartLeftDropCubeRightScaleDropTimed() {
        addSequential(new WaitCommand(2.75));
        addSequential(new IntakeOpen());
        addSequential(new IntakeOut());
        }
}
