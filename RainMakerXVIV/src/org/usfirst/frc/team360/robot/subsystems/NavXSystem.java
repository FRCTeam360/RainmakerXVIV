package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.NavXSystem;

import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavXSystem extends Subsystem {
	
    final static double kCollisionThreshold_DeltaG = 1.5f;
	
    public static int timesTriggered = 0;
    
    public static double last_world_linear_accel_x;
    public static double last_world_linear_accel_y;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public static void NavXRead() {
		
	    	RobotMap.accelX = RobotMap.NavX.getRawAccelX();
	    	RobotMap.accelY = RobotMap.NavX.getRawAccelY();
	    	
	    	RobotMap.Yaw = RobotMap.NavX.getYaw();
	    	RobotMap.Pitch = RobotMap.NavX.getPitch();
	    	RobotMap.Roll = RobotMap.NavX.getRoll();

	    	RobotMap.TotalYaw = RobotMap.NavX.getAngle();
	    	RobotMap.YawRate = RobotMap.NavX.getRate();
	    	
	    	RobotMap.Moving = RobotMap.NavX.isMoving();
	    	RobotMap.Rotating = RobotMap.NavX.isRotating();
	    	RobotMap.Connected = RobotMap.NavX.isConnected();
	    	RobotMap.Calibrating = RobotMap.NavX.isCalibrating();

	    	RobotMap.QuaternionW = RobotMap.NavX.getQuaternionW();
	    	RobotMap.QuaternionX = RobotMap.NavX.getQuaternionX();
	    	RobotMap.QuaternionY = RobotMap.NavX.getQuaternionY();
	    	RobotMap.QuaternionZ = RobotMap.NavX.getQuaternionZ();

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
	    	
	    	AHRS.BoardYawAxis yaw_axis1 = RobotMap.NavX.getBoardYawAxis();
	    	
	    	SmartDashboard.putString( "YawAxisDirection: ", yaw_axis1.up ? "Up" : "Down" );
	    	SmartDashboard.putNumber( "YawAxis: ", yaw_axis1.board_axis.getValue() );
	    	
	    	SmartDashboard.putNumber( "QuaternionW: ", RobotMap.QuaternionW);
	    	SmartDashboard.putNumber( "QuaternionX: ", RobotMap.QuaternionX);
	    	SmartDashboard.putNumber( "QuaternionY: ", RobotMap.QuaternionY);
	    	SmartDashboard.putNumber( "QuaternionZ: ", RobotMap.QuaternionZ);
	    	
	    	SmartDashboard.putNumber( "Byte_Count: ", RobotMap.NavX.getByteCount());
	    	SmartDashboard.putNumber( "Update_Count: ", RobotMap.NavX.getUpdateCount());
		
	    	
	}
	
	public static void NavXCrash() {
		
	    double curr_world_linear_accel_x = RobotMap.NavX.getWorldLinearAccelX();
	    double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
	    last_world_linear_accel_x = curr_world_linear_accel_x;
	    double curr_world_linear_accel_y = RobotMap.NavX.getWorldLinearAccelY();
	    double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
	    last_world_linear_accel_y = curr_world_linear_accel_y;
		    
	    if ( ( Math.abs(currentJerkX) > kCollisionThreshold_DeltaG ) ||
	         ( Math.abs(currentJerkY) > kCollisionThreshold_DeltaG) ) {
	        timesTriggered++;
	        System.out.println("NavX Triggered : " + timesTriggered);
	    }
	}
	
}
