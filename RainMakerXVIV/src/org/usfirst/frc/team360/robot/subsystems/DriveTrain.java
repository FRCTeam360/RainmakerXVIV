package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;


import org.usfirst.frc.team360.commands.JoystickTankDrive;
public class DriveTrain extends Subsystem {
	
	static TalonSRX motorRMaster = RobotMap.motorR1;
	static TalonSRX motorRSlave = RobotMap.motorR2;
	static TalonSRX motorLMaster = RobotMap.motorL1;
	static TalonSRX motorLSlave = RobotMap.motorL2;
	
	public DriveTrain() {
		motorRMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorLMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		motorLMaster.setInverted(true);
		motorLSlave.setInverted(true);
	}
	
	public static void NeutralMode() {
		motorRMaster.setNeutralMode(NeutralMode.Brake);
		motorRSlave.setNeutralMode(NeutralMode.Brake);
		motorLMaster.setNeutralMode(NeutralMode.Brake);
		motorLSlave.setNeutralMode(NeutralMode.Brake);
	}
	
	public static void setControlModeVoltage(){
		  motorRMaster.set(ControlMode.PercentOutput, 0);
		  motorRSlave.follow(motorRMaster);
		  motorLMaster.set(ControlMode.PercentOutput, 0);
		  motorLSlave.follow(motorLMaster);
	  }

	public static void resetRHardEnc(){
		motorRMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	public static void resetLHardEnc(){
		motorLMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	public static void resetEncs(){
		motorRMaster.getSensorCollection().setQuadraturePosition(0, 0);
		motorLMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}
	
	public static void drive(double RMotor, double LMotor, double arm) {
		motorRMaster.set(ControlMode.PercentOutput, RMotor);
		motorLMaster.set(ControlMode.PercentOutput, LMotor);
	}
	public static void DriveR(double RMotor) {
		motorRMaster.set(ControlMode.PercentOutput, RMotor);
	}
	
	public static void DriveL(double LMotor){
		motorLMaster.set(ControlMode.PercentOutput, LMotor);
	}
	public void stopR(){
		motorRMaster.set(ControlMode.PercentOutput, 0, 0);
	}
	public void stopL(){
		motorLMaster.set(ControlMode.PercentOutput, 0, 0);
	}
	public void stopAll(){
		  motorLMaster.set(ControlMode.PercentOutput, 0, 0);
		  motorRMaster.set(ControlMode.PercentOutput, 0, 0);
	} 
    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickTankDrive());
    }

    public void checkCurrent() {
    	
    }
}

