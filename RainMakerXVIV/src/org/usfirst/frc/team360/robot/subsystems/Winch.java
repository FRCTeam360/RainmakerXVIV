package org.usfirst.frc.team360.robot.subsystems;

import java.awt.Robot;
import java.util.Set;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	VictorSP Winch = RobotMap.motorWinch1;
	VictorSP Winch1 = RobotMap.motorWinch2;
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void setMotorspeed(double speed) {
		Winch.set(speed);{
	    Winch1.set(speed);
	    }
	}
}

