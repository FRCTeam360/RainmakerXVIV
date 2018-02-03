package org.usfirst.frc.team360.robot.commands;

<<<<<<< HEAD
import org.usfirst.frs.team360.robot.commands.color.LEDIntake;

=======
>>>>>>> dev
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addSequential(new IntakeControl(.5, 25, true));
<<<<<<< HEAD
    	addSequential(new LEDIntake());
=======
>>>>>>> dev
    }
}
