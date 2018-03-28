package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeOpen;
import org.usfirst.frc.team360.robot.commands.MoveElevatorToTopScale;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartLeftDropCubeRightScaleLeftTimed extends CommandGroup {
    public StartLeftDropCubeRightScaleLeftTimed() {
        addSequential(new WaitCommand(2.75));
        addSequential(new IntakeOpen());
        }
}
