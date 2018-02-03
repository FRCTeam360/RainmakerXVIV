package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.NavX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX extends Subsystem {
	
    public static int timesTriggered = 0;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void NavXRead() {
		
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
	
	public void NavXCrash() {
		
		RobotMap.curr_world_linear_accel_x = RobotMap.navX.getWorldLinearAccelX();
		RobotMap.curr_world_linear_accel_y = RobotMap.navX.getWorldLinearAccelY();
		
		RobotMap.currentJerkX = RobotMap.curr_world_linear_accel_x - RobotMap.last_world_linear_accel_x;
		RobotMap.currentJerkY = RobotMap.curr_world_linear_accel_y - RobotMap.last_world_linear_accel_y;

		RobotMap.last_world_linear_accel_x = RobotMap.curr_world_linear_accel_x;
		RobotMap.last_world_linear_accel_y = RobotMap.curr_world_linear_accel_y;
		
		SmartDashboard.putNumber( "Jerk X: ", RobotMap.currentJerkX);
    		SmartDashboard.putNumber( "Jerk Y: ", RobotMap.currentJerkY);
		
	    if (( Math.abs(RobotMap.currentJerkX) > RobotMap.kCollisionThreshold_DeltaG ) ||
	         ( Math.abs(RobotMap.currentJerkY) > RobotMap.kCollisionThreshold_DeltaG)) {
	        timesTriggered++;
	        Robot.logger.logNavX();
	        RobotMap.crashed = true;
	        DriverStation.reportError("TRIGGERED!!!, Times Triggered: " + timesTriggered, false);
	        
	    }
	}
}
