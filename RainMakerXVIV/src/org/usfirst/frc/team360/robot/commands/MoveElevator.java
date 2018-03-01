package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Constants;
import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveElevator extends Command {
	
	public double pos;
	double wantedPos;
	public MoveElevator(double wantedPosition) {
		requires(Robot.elevator);
		wantedPos = wantedPosition;
	}

	// Called just before this Command runs the first time
    protected void initialize() {
    		if(pos == 0) {
    			RobotMap.shouldElevatorStop = true;
    		}

       	 pos = (wantedPos * Constants.realEncoderCountsToInches) - Robot.elevator.getPosition();	
        	SmartDashboard.putNumber("el Position", Robot.elevator.getPosition());
        	SmartDashboard.putNumber("wanted Position", wantedPos * Constants.realEncoderCountsToInches);
        	SmartDashboard.putNumber("Pos", pos);
       	RobotMap.shouldElevatorStop = false;
	    	Robot.elevator.motionMagicInit();
	    	Robot.elevator.setMotorPosition(pos);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    	Robot.elevator.Process();
    	SmartDashboard.putNumber("Elev Position", Robot.elevator.getPosition());
    	SmartDashboard.putNumber("Future Position", pos);
    		
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
