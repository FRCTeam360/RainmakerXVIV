package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.MoveElevatorToTopScale;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartLeftDropCubeLeftScaleRaiseTimed extends CommandGroup {
    public StartLeftDropCubeLeftScaleRaiseTimed() {
        addSequential(new WaitCommand(2.75));
        addSequential(new MoveElevatorToTopScale());
       }
}
