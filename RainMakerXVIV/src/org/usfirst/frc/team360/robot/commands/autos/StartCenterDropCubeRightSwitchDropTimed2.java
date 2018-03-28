package org.usfirst.frc.team360.robot.commands.autos;

import org.usfirst.frc.team360.robot.commands.IntakeAutoOut;
import org.usfirst.frc.team360.robot.commands.IntakeOpen;
import org.usfirst.frc.team360.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StartCenterDropCubeRightSwitchDropTimed2 extends CommandGroup {

    public StartCenterDropCubeRightSwitchDropTimed2() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        addSequential(new WaitCommand(2));
        addSequential(new IntakeAutoOut());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
