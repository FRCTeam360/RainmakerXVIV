package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.commands.ControlVictor;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VictorArm extends Subsystem {

	VictorSP m_Victor = RobotMap.Arm1;
	public void setMotor(double speed){
		m_Victor.set(speed);
	}
	public void stopMotor(){
		m_Victor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ControlVictor());
    }
}

