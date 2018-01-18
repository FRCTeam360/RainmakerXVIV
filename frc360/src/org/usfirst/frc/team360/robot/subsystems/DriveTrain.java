package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	

	public static void drive(double LSpeed, double RSpeed) {
		RobotMap.motorL1.set(LSpeed);
		RobotMap.motorL2.set(LSpeed);
		RobotMap.motorR1.set(RSpeed);
		RobotMap.motorR2.set(RSpeed);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }

		// 

		
		// TODO Auto-generated method stub
		
	}


		// TODO Auto-generated method stub
		

	
		// TODO Auto-generated method stub
		


