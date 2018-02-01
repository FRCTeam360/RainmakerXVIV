package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LED extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark controlLED = RobotMap.LED_Control;
	
	public void LEDControl(double color) {
		controlLED.set(color);
	}
	public void setLEDRed() {
		LEDControl(0.61);
	}
	public void setLEDGreen() {
		LEDControl(0.77);
	}
	public void setLEDBlue() {
		LEDControl(0.87);
	}
	public void setLEDPulse() {
		LEDControl(-0.09);
	}
	public void setLEDOrange() {
		LEDControl(0.65);
	}
	public void setLEDYellow() {
		LEDControl(0.69);
	}
	public void setLEDBlack() {
		LEDControl(0.99);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

