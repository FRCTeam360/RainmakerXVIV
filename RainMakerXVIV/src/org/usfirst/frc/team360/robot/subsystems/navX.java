package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.commands.getNavXData;
import org.usfirst.frc.team360.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class navX extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AHRS m_navX = RobotMap.navX;
	static AHRS navX;
	
	static double last_world_linear_accel_x;
    static double last_world_linear_accel_y;
    
    static boolean collisionDetected = false;
    
    final static double kCollisionThreshold_DeltaG = 1.5f;
	
    static int timesTriggered = 0;
	
	public void navXread(){
		RobotMap.accelX = RobotMap.navX.getRawAccelX();
    	RobotMap.accelY = RobotMap.navX.getRawAccelY();
    	
    	RobotMap.Yaw = RobotMap.navX.getYaw();
    	RobotMap.Pitch = RobotMap.navX.getPitch();
    	RobotMap.Roll = RobotMap.navX.getRoll();

    	RobotMap.TotalYaw = RobotMap.navX.getAngle();
    	RobotMap.YawRate = RobotMap.navX.getRate();
    	
    	RobotMap.Moving = RobotMap.navX.isMoving();
    	RobotMap.Rotating = RobotMap.navX.isRotating();
    	RobotMap.Connected = RobotMap.navX.isConnected();
    	RobotMap.Calibrating = RobotMap.navX.isCalibrating();

    	RobotMap.QuaternionW = RobotMap.navX.getQuaternionW();
    	RobotMap.QuaternionX = RobotMap.navX.getQuaternionX();
    	RobotMap.QuaternionY = RobotMap.navX.getQuaternionY();
    	RobotMap.QuaternionZ = RobotMap.navX.getQuaternionZ();

    	SmartDashboard.putNumber("accelX: ", RobotMap.accelX);
    	SmartDashboard.putNumber("accelY: ", RobotMap.accelY);

    	SmartDashboard.putBoolean( "Connected", RobotMap.Connected);
    	SmartDashboard.putBoolean( "Is_Calibrating", RobotMap.Calibrating);
    	SmartDashboard.putNumber( "Yaw",RobotMap.Yaw);
    	SmartDashboard.putNumber( "Pitch", RobotMap.Pitch);
    	SmartDashboard.putNumber( "Roll", RobotMap.Roll);
    	
    	/* Display tilt-corrected, Magnetometer-based heading (requires */
    	/* magnetometer calibration to be useful) */
    	
//    	SmartDashboard.putNumber( "IMU_CompassHeading", ahrs.getCompassHeading());
    	
    	/* Display 9-axis Heading (requires magnetometer calibration to be useful) */
    	
//    	SmartDashboard.putNumber( "IMU_FusedHeading", ahrs.getFusedHeading());

    	/* These functions are compatible w/the WPI Gyro Class, providing a simple */
    	/* path for upgrading from the Kit-of-Parts gyro to the navx-MXP */
    	
    	SmartDashboard.putNumber( "Total_Yaw: ", RobotMap.TotalYaw);
    	SmartDashboard.putNumber( "Yaw_Rate: ", RobotMap.YawRate);

    	/* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */

    	SmartDashboard.putBoolean( "Is_Moving: ", RobotMap.Moving);
    	SmartDashboard.putBoolean( "Is_Rotating: ", RobotMap.Rotating);

    	/* Display estimates of velocity/displacement. Note that these values are
    	not expected to be accurate enough for estimating robot position on a
    	FIRST FRC Robotics Field, due to accelerometer noise and the compounding
    	of these errors due to single (velocity) integration and especially
    	double (displacement) integration. */
//    	SmartDashboard.putNumber( "Velocity_X: ", RobotMap.VelocityX());
//    	SmartDashboard.putNumber( "Velocity_Y: ", RobotMap.VelocityY());
//    	SmartDashboard.putNumber( "Displacement_X: ", RobotMap.DisplacementX());
//    	SmartDashboard.putNumber( "Displacement_Y: ", RobotMap.DisplacementY());
    	
    	/* Display Raw Gyro/Accelerometer/Magnetometer Values
    	NOTE: These values are not normally necessary, but are made available
    	for advanced users. Before using this data, please consider whether
    	the processed data (see above) will suit your needs. */
    	
//    	SmartDashboard.putNumber( "RawGyro_X: ", RobotMap.RawGyroX());
//    	SmartDashboard.putNumber( "RawGyro_Y: ", RobotMap.RawGyroY());
//    	SmartDashboard.putNumber( "RawGyro_Z: ", RobotMap.RawGyroZ());
    	
    	/* Omnimount Yaw Axis Information */
    	/* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount */
    	
    	AHRS.BoardYawAxis yaw_axis1 = navX.getBoardYawAxis();
    	
    	SmartDashboard.putString( "YawAxisDirection: ", yaw_axis1.up ? "Up" : "Down" );
    	SmartDashboard.putNumber( "YawAxis: ", yaw_axis1.board_axis.getValue() );
    	
    	/* Sensor Board Information */
    	
//    	SmartDashboard.putString( "FirmwareVersion", ahrs.getFirmwareVersion());
    	
    	/* Quaternion Data */
    	/* Quaternions are fascinating, and are the most compact representation of */
    	/* orientation data. All of the Yaw, Pitch and Roll Values can be derived */
    	/* from the Quaternions. If interested in motion processing, knowledge of */
    	/* Quaternions is highly recommended. */
    	
    	SmartDashboard.putNumber( "QuaternionW: ", RobotMap.QuaternionW);
    	SmartDashboard.putNumber( "QuaternionX: ", RobotMap.QuaternionX);
    	SmartDashboard.putNumber( "QuaternionY: ", RobotMap.QuaternionY);
    	SmartDashboard.putNumber( "QuaternionZ: ", RobotMap.QuaternionZ);
    	
    	/* Connectivity Debugging Support */
    	
    	SmartDashboard.putNumber( "Byte_Count: ", navX.getByteCount());
    	SmartDashboard.putNumber( "Update_Count: ", navX.getUpdateCount());
	}
	public void navXcrash() {
		double curr_world_linear_accel_x = RobotMap.navX.getWorldLinearAccelX();
	    double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
	    last_world_linear_accel_x = curr_world_linear_accel_x;
	    double curr_world_linear_accel_y = RobotMap.navX.getWorldLinearAccelY();
	    double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
	    last_world_linear_accel_y = curr_world_linear_accel_y;
		    
	    if ( ( Math.abs(currentJerkX) > kCollisionThreshold_DeltaG ) ||
	         ( Math.abs(currentJerkY) > kCollisionThreshold_DeltaG) ) {
	        collisionDetected = true;
	        timesTriggered++;
	        DriverStation.reportError("TRIGGERED!!!, Times Triggered: " + timesTriggered, false);
	        
	    }
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new getNavXData());
    }
}

