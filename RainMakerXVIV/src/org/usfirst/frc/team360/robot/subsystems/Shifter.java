package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team360.robot.*;
import org.usfirst.frc.team360.robot.RobotMap.ShiftState;
import org.usfirst.frc.team360.robot.commands.LEDShiftState;

public class Shifter extends Subsystem {
    
//error here
	public static DoubleSolenoid shifter = RobotMap.shifter;
	public void shiftUp(){ 
		shifter.set(DoubleSolenoid.Value.kForward);
		RobotMap.shiftState = ShiftState.UP;
	}
	public void shiftDown() {
		shifter.set(DoubleSolenoid.Value.kReverse);
		RobotMap.shiftState = ShiftState.DOWN;
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new LEDShiftState());
    }
}