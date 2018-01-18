package org.usfirst.frc.team360.robot.triggers;

import org.usfirst.frc.team360.robot.OI;

import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 *
 */
public class DoubleButton extends Trigger{ 

	public boolean get(){
        return OI.stickL.getRawButton(1) && OI.stickL.getRawButton(2); 
        
    } 
} 

