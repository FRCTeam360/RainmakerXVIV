package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {
	
    public ElevatorUp() {
       requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(OI.joyL.getRawButton(1)) {
    		
    		System.out.println("Working ElevatorUp");
    		
    		double targetPos = 2 * 4096;
    		
    		Robot.elevator._talon.set(ControlMode.MotionMagic, targetPos);
    		
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
