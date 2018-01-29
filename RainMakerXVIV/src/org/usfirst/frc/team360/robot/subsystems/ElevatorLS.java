package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorLS extends Subsystem {

	DigitalInput limitSwitch = new DigitalInput(1);
	Counter counter = new Counter(limitSwitch);
	 
	public boolean isSwitchSet() {
		 
		return counter.get() > 0;
		 
	}
	 
	public void initializeCounter() {
	        
		counter.reset();
	        
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

