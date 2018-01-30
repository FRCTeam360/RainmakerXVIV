package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	VictorSP winch = RobotMap.motorWinch1;
	VictorSP winch1 = RobotMap.motorWinch2;
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void setMotorSpeed(double speed) {
		winch.set(speed);
	    winch1.set(speed);
	}
	public void stop() {
		winch.set(0);
	    winch1.set(0);
	}
}

