package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakePulseAndFlashLEDs extends CommandGroup {

    public IntakePulseAndFlashLEDs() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
	    	addSequential(new LEDColor(RobotMap.Color.RED, 1.5, 100, true, false));
	    	addSequential(new IntakePulse(1, 5, 2, true));
	    	addSequential(new IntakeClose());
	    	addSequential(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
	    	Robot.logger.logIntakeIn();
    		addParallel(new LEDColor(RobotMap.Color.RED, 1.5, 100, true, false));
	    	addSequential(new IntakePulse(1, 5, 2, true));
	    	addSequential(new IntakeClose());
	    	addSequential(new LEDColor(RobotMap.Color.GREEN, 1/3, 2, true, false));
    }
}
