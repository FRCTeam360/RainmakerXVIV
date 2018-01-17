package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.navXsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class navXsystem extends Subsystem {
	
    final static double kCollisionThreshold_DeltaG = 1.5f;
	
    public static int timesTriggered = 0;
    
    public static double last_world_linear_accel_x;
    public static double last_world_linear_accel_y;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public static void navXread() {
		
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
	    
	    	SmartDashboard.putNumber( "Total_Yaw: ", RobotMap.TotalYaw);
	    	SmartDashboard.putNumber( "Yaw_Rate: ", RobotMap.YawRate);

	    	SmartDashboard.putBoolean( "Is_Moving: ", RobotMap.Moving);
	    	SmartDashboard.putBoolean( "Is_Rotating: ", RobotMap.Rotating);
	    	
	    	AHRS.BoardYawAxis yaw_axis1 = RobotMap.navX.getBoardYawAxis();
	    	
	    	SmartDashboard.putString( "YawAxisDirection: ", yaw_axis1.up ? "Up" : "Down" );
	    	SmartDashboard.putNumber( "YawAxis: ", yaw_axis1.board_axis.getValue() );
	    	
	    	SmartDashboard.putNumber( "QuaternionW: ", RobotMap.QuaternionW);
	    	SmartDashboard.putNumber( "QuaternionX: ", RobotMap.QuaternionX);
	    	SmartDashboard.putNumber( "QuaternionY: ", RobotMap.QuaternionY);
	    	SmartDashboard.putNumber( "QuaternionZ: ", RobotMap.QuaternionZ);
	    	
	    	SmartDashboard.putNumber( "Byte_Count: ", RobotMap.navX.getByteCount());
	    	SmartDashboard.putNumber( "Update_Count: ", RobotMap.navX.getUpdateCount());
		
	    	
	}
	
	public static void navXcrash() {
		
	    double curr_world_linear_accel_x = RobotMap.navX.getWorldLinearAccelX();
	    double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
	    last_world_linear_accel_x = curr_world_linear_accel_x;
	    double curr_world_linear_accel_y = RobotMap.navX.getWorldLinearAccelY();
	    double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
	    last_world_linear_accel_y = curr_world_linear_accel_y;
		    
	    if ( ( Math.abs(currentJerkX) > kCollisionThreshold_DeltaG ) ||
	         ( Math.abs(currentJerkY) > kCollisionThreshold_DeltaG) ) {
	        timesTriggered++;
	        Robot.logger.logRobotNavX();
	        DriverStation.reportError("TRIGGERED!!!, Times Triggered: " + timesTriggered, false);
	    }
	}
	
}
