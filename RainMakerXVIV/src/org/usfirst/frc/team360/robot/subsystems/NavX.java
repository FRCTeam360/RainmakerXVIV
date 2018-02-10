package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.NavX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX extends Subsystem {
	
    private static int timesTriggered = 0;
    private AHRS navX = RobotMap.navX;
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void NavXRead() {
		
	    	RobotMap.accelX = navX.getRawAccelX();
	    	RobotMap.accelY = navX.getRawAccelY();
	    	
	    	RobotMap.Yaw = navX.getYaw();
	    	RobotMap.Pitch = navX.getPitch();
	    	RobotMap.Roll = navX.getRoll();

	    	RobotMap.TotalYaw = navX.getAngle();
	    	RobotMap.YawRate = navX.getRate();
	    	

	    	SmartDashboard.putNumber("accelX: ", RobotMap.accelX);
	    	SmartDashboard.putNumber("accelY: ", RobotMap.accelY);

	    	SmartDashboard.putNumber( "Yaw",RobotMap.Yaw);
	    	SmartDashboard.putNumber( "Pitch", RobotMap.Pitch);
	    	SmartDashboard.putNumber( "Roll", RobotMap.Roll);
	    
	    	SmartDashboard.putNumber( "Total_Yaw: ", RobotMap.TotalYaw);
	    	SmartDashboard.putNumber( "Yaw_Rate: ", RobotMap.YawRate);
	    	
	    	AHRS.BoardYawAxis yaw_axis1 = navX.getBoardYawAxis();
	    	
	    	SmartDashboard.putString( "YawAxisDirection: ", yaw_axis1.up ? "Up" : "Down" );
	    	SmartDashboard.putNumber( "YawAxis: ", yaw_axis1.board_axis.getValue() );
	    	
	}
	
	public void NavXCrash() {
		
		RobotMap.curr_world_linear_accel_x = navX.getWorldLinearAccelX();
		RobotMap.curr_world_linear_accel_y = navX.getWorldLinearAccelY();
		
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
