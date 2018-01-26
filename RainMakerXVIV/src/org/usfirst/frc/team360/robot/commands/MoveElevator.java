package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevator extends Command {
	
	public static int pos;
	
    public MoveElevator(int pos) {
       requires(Robot.elevator);
       
       pos = 25;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
<<<<<<< HEAD:RainMakerXVIV/src/org/usfirst/frc/team360/robot/commands/MoveElevator.java
=======
    	if(OI.joyL.getRawButton(1)) {
    		
    		System.out.println("Working ElevatorUp");
    		
    		double targetPos = 10 * 4096;
    		
    		Robot.elevator._talon.set(ControlMode.MotionMagic, targetPos);
    		
    	}
>>>>>>> ce4eb49561b899ef352e694bde85034aebcb3f6d:RainMakerXVIV/src/org/usfirst/frc/team360/robot/commands/ElevatorUp.java
    	
    	System.out.println("ElevMiddle");	
    		
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
