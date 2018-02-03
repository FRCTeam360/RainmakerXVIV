package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FMSGameData extends Command {

    public FMSGameData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L') {
			
			DriverStation.reportWarning("L alliance switch", false);
			
			//Put left auto code here
		} 
		
		else {
			
			DriverStation.reportWarning("R alliance switch", false);
			
			//Put right auto code here
		}
		
if(gameData.charAt(1) == 'L') {
			
			DriverStation.reportWarning("L scale", false);
			
			//Put left auto code here
		} 
		
		else {
			
			DriverStation.reportWarning("R scale", false);
			
			//Put right auto code here
		}

if(gameData.charAt(2) == 'L') {
	
	DriverStation.reportWarning("L opponent switch", false);
	
	//Put left auto code here
} 

else {
	
	DriverStation.reportWarning("R oppeonent switch", false);
	
	//Put right auto code here
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
