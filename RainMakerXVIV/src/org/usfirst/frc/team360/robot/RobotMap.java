/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.AutoController.ScaleSide;
import org.usfirst.frc.team360.robot.AutoController.SwitchSide;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;
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

	public static PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	public static DoubleSolenoid shifter = new DoubleSolenoid(2, 3);
	
	public static enum ShiftState {UP, DOWN, UNKNOWN}
	public static ShiftState shiftState = ShiftState.UNKNOWN;
	
	public static int currentPos = 10;
	
	public static int topScale = 500;
	public static int midScale = 300;
	public static int switchHeight = 50;
	public static int intakePos = 20;

	public static AHRS navX = new AHRS(SPI.Port.kMXP);
	
	public static String robotID = "comp";
	 
	public static Compressor compressor = new Compressor();
	
	public static TalonSRX motorL1 = new TalonSRX(0);
	public static TalonSRX motorL2 = new TalonSRX(1);
	public static TalonSRX motorR1 = new TalonSRX(2);
	public static TalonSRX motorR2 = new TalonSRX(3);
	
	public static Spark LED_Control = new Spark(4);
	
	public static VictorSP motorWinch1 = new VictorSP(0);
	public static VictorSP motorWinch2 = new VictorSP(1);
	public static VictorSP motorIntake1 = new VictorSP(2);
	public static VictorSP motorIntake2 = new VictorSP(3);
	
	//Logger Variables 
	public static String robotMode = "Disabled";
	
	public static String FMSSideData = "unknown";
	
	//NavX Variables 
	
	public final static double kCollisionThreshold_DeltaG = 0.7f;
	
	public static boolean crashed = false;
	
    public static double last_world_linear_accel_x;
    public static double last_world_linear_accel_y;
	
    public static double curr_world_linear_accel_y = RobotMap.navX.getWorldLinearAccelY();
    public static double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
    public static double curr_world_linear_accel_x = RobotMap.navX.getWorldLinearAccelX();
    public static double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;

	public static float accelX;
	public static float accelY;
	
	public static float Yaw;
	public static float Pitch;
	public static float Roll;
	
	public static double TotalYaw;
	public static double YawRate;
	
	public static enum Color{RED, ORANGE, YELLOW, GREEN, BLUE, PULSING, RAINBOW, OFF};
	public static Color color = Color.OFF;
	

	public enum ScaleSide {LEFT, RIGHT};
	public static ScaleSide scaleSide; 
	public enum SwitchSide {LEFT, RIGHT};
	public static SwitchSide switchSide; 
	
}
