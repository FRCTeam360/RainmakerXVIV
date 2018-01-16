package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.subsystems.VictorSPs;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VictorDrive extends Command {

	public static Joystick joy = new Joystick(0);

    public VictorDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.victorSP);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD

    		if(joy.getRawButton(1)) {
    			VictorSPs.motor1.set(-0.2);

=======
    		if(joy.getRawButton(1)) {
    			VictorSPs.motor1.set(-0.2);
>>>>>>> 6df9cd78316ad4778b3780155f83056a3d29f950
    		}
    		else {
    			VictorSPs.motor1.set(joy.getY());
    		}
<<<<<<< HEAD

=======
>>>>>>> 6df9cd78316ad4778b3780155f83056a3d29f950
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	VictorSPs.motor1.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
