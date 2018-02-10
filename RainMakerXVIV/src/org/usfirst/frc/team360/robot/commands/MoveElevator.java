package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevator extends Command {
	
	public double pos;
	
	public MoveElevator(double realElevatorTopScale) {
		requires(Robot.elevator);
	    this.pos = realElevatorTopScale - RobotMap.currentPos;
	}

	// Called just before this Command runs the first time
    protected void initialize() {
	    	Robot.elevator.motionMagicInit();
	    	Robot.elevator.setMotorPosition(pos);
	    	System.out.println("Elev Position" + Robot.elevator.getPosition());
	    	System.out.println("Future Position" + pos);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    	Robot.elevator.Process();
    		
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
