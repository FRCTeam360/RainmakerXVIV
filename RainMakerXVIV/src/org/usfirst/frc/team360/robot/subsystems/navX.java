package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.commands.navXDataPool;
import org.usfirst.frc.team360.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class navX extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AHRS m_navX = RobotMap.navX;
	
	public double getNavXAngle(){
		return m_navX.getAngle();
	}

	public void resetNavX(){
		m_navX.reset();
	}
	
	public float getIMURoll(){
		return  m_navX.getRoll();
	}
	public float getIMUYaw(){
		return  m_navX.getYaw();
	}
	public float getIMUPitch(){
		return  m_navX.getPitch();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new navXDataPool());
    }
}

