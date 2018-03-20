package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartLeftDropCubeLeftScaleDropTimed extends CommandGroup {
    public StartLeftDropCubeLeftScaleDropTimed() {
        addSequential(new WaitCommand(6));
        addSequential(new IntakeOpen());
        }
    }
