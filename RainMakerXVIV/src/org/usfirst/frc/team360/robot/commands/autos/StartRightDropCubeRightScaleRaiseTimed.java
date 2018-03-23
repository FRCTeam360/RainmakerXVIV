package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.MoveElevatorToTopScale;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartRightDropCubeRightScaleRaiseTimed extends CommandGroup {
    public StartRightDropCubeRightScaleRaiseTimed() {
        addSequential(new WaitCommand(3.5));
        addSequential(new MoveElevatorToTopScale());
        }
}
