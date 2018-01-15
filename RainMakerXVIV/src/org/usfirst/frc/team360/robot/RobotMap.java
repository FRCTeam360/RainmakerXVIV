/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.VictorSP;

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

	/*public static TalonSRX motorL1 = new TalonSRX(0);
	public static TalonSRX motorL2 = new TalonSRX(1);
	public static TalonSRX motorR1 = new TalonSRX(2);
	public static TalonSRX motorR2 = new TalonSRX(3);*/
	
	public static VictorSP motor1 = new VictorSP(1);
}
