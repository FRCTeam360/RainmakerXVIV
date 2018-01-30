/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static DoubleSolenoid shifter = new DoubleSolenoid(0, 1);
	 
	public static Compressor compressor = new Compressor();
	
	public static PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	public static AHRS navX = new AHRS(SPI.Port.kMXP);

	public static TalonSRX motorL1 = new TalonSRX(3);
	public static TalonSRX motorL2 = new TalonSRX(4);
	public static TalonSRX motorR1 = new TalonSRX(5);
	public static TalonSRX motorR2 = new TalonSRX(6);
	
	public static VictorSP Arm1 = new VictorSP(1);
	public static VictorSP Arm2 = new VictorSP(2);

	public static float accelX;
	public static float accelY;
	
	public static double[] someDistance;
	public static Timer time;
	
	public static float Yaw;
	public static float Pitch;
	public static float Roll;
	
	public static double TotalYaw;
	public static double YawRate;
	
//	public static float Compass;
//	public static float Fused;
	
	public static boolean Moving;
	public static boolean Rotating;
	public static boolean Connected;
	public static boolean Calibrating;
	
//	public static float VelocityX;
//	public static float VelocityY;
	
//	public static float DisplacementX;
//	public static float DisplacementY;
	
//	public static float RawGyroX;
//	public static float RawGyroY;
//	public static float RawGyroZ;
	
//	public static float RawAccelX;
//	public static float RawAccelY;
//	public static float RawAccelZ;
	
//	public static float RawMagX;
//	public static float RawMagY;
//	public static float RawMagZ;
	
//	public static float Temperature_Celsius;
//	public static double Temperature_Fahrenheit;
	
	public static float QuaternionW;
	public static float QuaternionX;
	public static float QuaternionY;
	public static float QuaternionZ;
	
	
}
