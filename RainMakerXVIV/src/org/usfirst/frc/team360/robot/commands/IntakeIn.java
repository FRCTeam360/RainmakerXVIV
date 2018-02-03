package org.usfirst.frc.team360.robot.commands;

<<<<<<< HEAD
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.Robot;

=======
>>>>>>> parent of a7f1903... Added Led Stuff
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIn extends CommandGroup {
	
    public IntakeIn() {
    	addSequential(new IntakeControl(.5, 25, true));
<<<<<<< HEAD
    	addSequential(new LEDcolor(RobotMap.Color.GREEN, 3, 1.5, true));

    	Robot.logger.logIntakeIn();

=======
>>>>>>> parent of a7f1903... Added Led Stuff
    }
}
