package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveElevator extends Command {
	
	public int pos1;
	
    public MoveElevator(int pos) {
       requires(Robot.elevator);
       
       pos1 = pos;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.motionMagicInit();
    	Robot.elevator._talon.set(ControlMode.MotionMagic, pos1 * 30);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.elevator.Process();
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
