package org.usfirst.frc.team360.commands;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
<<<<<<< HEAD:RainMakerXVIV/src/org/usfirst/frc/team360/commands/IntakeControl.java
public class IntakeControl extends Command {
    
    double speed;
	double amps;
	boolean currentStop;
    public IntakeControl(double speed, double amps, boolean currentStop) {
    	
    	this.speed = speed;
    	this.amps = amps;
    	this.currentStop = currentStop;
    	
    	requires(Robot.cubeIntake);
=======
public class ControlVictor extends Command {
	
	PowerDistributionPanel pdp;
    double Amp = pdp.getCurrent(2);
	
    public ControlVictor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_Victor);
>>>>>>> origin/VictorAmp-dev:RainMakerXVIV/src/org/usfirst/frc/team360/commands/ControlVictor.java
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cubeIntake.controlMotor(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
<<<<<<< HEAD:RainMakerXVIV/src/org/usfirst/frc/team360/commands/IntakeControl.java
    	return Robot.cubeIntake.currentDraw() > amps && currentStop;
=======
    	
    	if(Amp >= 10) {
    		Robot.m_Victor.stopMotor();
    		return true;
    	} else {
    		return false;
    	}
>>>>>>> origin/VictorAmp-dev:RainMakerXVIV/src/org/usfirst/frc/team360/commands/ControlVictor.java
    }
    

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.Arm1.stopMotor();
    	RobotMap.Arm2.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
