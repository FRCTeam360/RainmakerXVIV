package org.usfirst.frc.team360.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;

public class TippingDetection extends Command {
	
	  AHRS ahrs;
	  
    public TippingDetection() {
    	
    }
    	  
    	      
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	ahrs = new AHRS(SPI.Port.kMXP); 
    	ahrs.reset();
    	ahrs.zeroYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if (-70 < ahrs.getPitch() || ahrs.getPitch() > 20) {
    			System.out.println("Warning TIPPING");
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