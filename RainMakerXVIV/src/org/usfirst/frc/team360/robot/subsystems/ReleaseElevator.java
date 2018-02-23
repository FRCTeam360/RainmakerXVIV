package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.ShiftState;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



public class ReleaseElevator extends Subsystem {
	private DoubleSolenoid elevator = RobotMap.elevatorReleasePneumatic;
	
	public void elevatorRelease() {
		elevator.set(DoubleSolenoid.Value.kForward);
	}
	
	public void elevatorHold() {
		elevator.set(DoubleSolenoid.Value.kReverse);
	}


	protected void initDefaultCommand() {
		
		// TODO Auto-generated method stub
		
	}
	
	
}
