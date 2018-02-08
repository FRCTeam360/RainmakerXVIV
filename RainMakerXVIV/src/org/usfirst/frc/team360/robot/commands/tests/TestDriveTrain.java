package org.usfirst.frc.team360.robot.commands.tests;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestDriveTrain extends Command {
	Timer time;
    public TestDriveTrain() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		time = new Timer();
    		time.reset();
    		time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(time.get() < 1) {
    			Robot.driveTrain.driveR(.5);
    			Robot.driveTrain.driveL(.5);
    		} else {
    			Robot.driveTrain.driveR(-.5);
    			Robot.driveTrain.driveL(-.5);
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.get() > 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
