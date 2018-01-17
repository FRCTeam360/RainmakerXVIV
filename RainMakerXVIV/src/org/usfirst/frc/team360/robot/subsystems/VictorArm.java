package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.commands.ControlVictor;
import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VictorArm extends Subsystem {
	
	PowerDistributionPanel pdp;
	
	VictorSP m_Victor = RobotMap.Arm1;
	
	public void setMotor(double speed){
		m_Victor.set(speed);
	}
	public void stopMotor(){
		m_Victor.set(0);
	}
	
	public void ControlVictor() {
		if(OI.armIN.equals(1)) {
    		Robot.m_Victor.setMotor(.5);
    		
    	} else if(OI.armOUT.equals(1)){
    		Robot.m_Victor.setMotor(-.5);
    	} else {
    		Robot.m_Victor.stopMotor();
    	}
	}
	
	public void VictorAmp(){
		int channel = 2;
    	double Amp = pdp.getCurrent(channel);
    	if(Amp >= 10) {
    		Robot.m_Victor.stopMotor();
    	}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ControlVictor());
    }
}

