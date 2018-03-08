package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeAutoControl extends Command {
	
	double speed;
	double time;
	boolean timerActive;
	Timer timer1;

	 public IntakeAutoControl(double speed, boolean timer, double time) {
 		this.speed = speed;
 		this.time = time;
 		timerActive = timer;
		 timer1 = new Timer();
 		requires(Robot.intake);
	 }
 
 // Called just before this Command runs the first time
	 protected void initialize() {
		 if (timerActive == true) {
			 timer1.start();
		 }
	 }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.controlMotor(speed);

		 System.out.println(timer1.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  timer1.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
		timer1.stop();
		timer1.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
