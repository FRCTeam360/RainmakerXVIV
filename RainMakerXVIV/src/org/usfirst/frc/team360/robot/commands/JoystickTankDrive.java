package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team360.robot.*;

public class JoystickTankDrive extends Command {

    public JoystickTankDrive() {
    	requires(Robot.driveTrain); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	

    	Robot.driveTrain.driveR(OI.joyR.getRawAxis(-1));
    	Robot.driveTrain.driveL(OI.joyL.getRawAxis(1));

    	
    	Robot.driveTrain.driveR(-1 * OI.joyR.getRawAxis(1));
    	Robot.driveTrain.driveL(-1 * OI.joyL.getRawAxis(1));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
