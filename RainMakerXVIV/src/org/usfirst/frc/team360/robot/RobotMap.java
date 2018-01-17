/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.usfirst.frc.team360.robot.subsystems.Logger;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;



public class RobotMap {
	
	public static AHRS navX = new AHRS(SPI.Port.kMXP);
	
	public static DoubleSolenoid shifter = new DoubleSolenoid(3, 1);
	 
	public static Compressor compressor = new Compressor();
	
	public static PowerDistributionPanel pdp = new PowerDistributionPanel();

	public static TalonSRX motorL1 = new TalonSRX(0);
	public static TalonSRX motorL2 = new TalonSRX(1);
	public static TalonSRX motorR1 = new TalonSRX(2);
	public static TalonSRX motorR2 = new TalonSRX(3);
	
	public static String RobotState = "Disabled";
	
	public static float accelX;
	public static float accelY;
	
	public static float Yaw;
	public static float Pitch;
	public static float Roll;
	
	public static double TotalYaw;
	public static double YawRate;
	
	public static boolean Moving;
	public static boolean Rotating;
	public static boolean Connected;
	public static boolean Calibrating;
	
	public static float QuaternionW;
	public static float QuaternionX;
	public static float QuaternionY;
	public static float QuaternionZ;
	
}
