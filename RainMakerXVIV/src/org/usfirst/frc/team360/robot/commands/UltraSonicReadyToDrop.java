package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.UltraSonic;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltraSonicReadyToDrop extends Command {
	
	public Ultrasonic ultra = RobotMap.ultra;

    public UltraSonicReadyToDrop() {
    	//requires(Robot.ultraSonic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ultra.setAutomaticMode(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ultraSonic.getUltrasonicInches();
    	if(Robot.ultraSonic.range < 40) {
    		System.out.println("Ready to drop");
    	} else {
    		System.out.println("Not ready to drop");
    	}
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
    }
}
