/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team360.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;

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

	public static DoubleSolenoid elevatorReleasePneumatic = new DoubleSolenoid(1, 0);
	
	public static DoubleSolenoid shifter = new DoubleSolenoid(3, 2);
	
	public static DoubleSolenoid intakePneumaticsOpen = new DoubleSolenoid(4, 5);
	public static DoubleSolenoid intakePneumaticsClose = new DoubleSolenoid(6, 7);

	
	public static enum ShiftState {UP, DOWN, UNKNOWN}
	public static ShiftState shiftState = ShiftState.UNKNOWN;
	
	public static boolean shouldElevatorStop = false;
	
	public static enum IntakeState{IN, OUT, UNKNOWN}
	public static IntakeState intakeState = IntakeState.UNKNOWN;
	
	public static int currentPos;

	public static AHRS navX = new AHRS(SPI.Port.kMXP);
	
	public static enum RobotID {COMP, PRACTICE, UNKNOWN};
	public static RobotID robotID = RobotID.UNKNOWN;
	 
	public static Compressor compressor = new Compressor();
	
	public static TalonSRX motorLeftMaster = new TalonSRX(0);
	public static TalonSRX motorLeftSlave = new TalonSRX(1);
	public static TalonSRX motorRightMaster = new TalonSRX(2);
	public static TalonSRX motorRightSlave = new TalonSRX(3);

	public static TalonSRX motorElevatorMaster = new TalonSRX(4);
	public static TalonSRX motorElevatorSlave = new TalonSRX(5);
	
	public static VictorSP motorClimber1 = new VictorSP(0);
	public static VictorSP motorClimber2 = new VictorSP(1);
	public static VictorSP motorIntake1 = new VictorSP(3);
	public static VictorSP motorIntake2 = new VictorSP(2);
	
	public static Spark LED_Control = new Spark(4);
	
	//Logger Variables 
	public static String robotMode = "Disabled";
	
	public static String FMSSideData = "unknown";
	
	public static boolean driverStationIsAttached = DriverStation.getInstance().isDSAttached();
	
	//Limit Switch Variables
	public static DigitalInput elevatorLimitSwitch = new DigitalInput(0);
	public static boolean wasZeroActive = false;
	public static boolean ZeroActive = true;

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
	
	public static enum Color{RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, PULSING, RAINBOW, OFF};
	public static Color color = Color.OFF;
	

	public enum ScaleSide {LEFT, RIGHT};
	public static ScaleSide scaleSide; 
	public enum SwitchSide {LEFT, RIGHT};
	public static SwitchSide switchSide; 
	
}