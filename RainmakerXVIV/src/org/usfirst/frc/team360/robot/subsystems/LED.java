package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.Color;

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
		RobotMap.color = Color.RED;
	}
	public void setLEDOrange() {
		LEDControl(0.65);
		RobotMap.color = Color.ORANGE;
	}
	public void setLEDYellow() {
		LEDControl(0.69);
		RobotMap.color = Color.YELLOW;
	}
	public void setLEDGreen() {
		LEDControl(0.77);
		RobotMap.color = Color.GREEN;
	}
	public void setLEDBlue() {
		LEDControl(0.87);
		RobotMap.color = Color.BLUE;
	}
	public void setLEDPulse() {
		LEDControl(-0.09);
		RobotMap.color = Color.PULSING;
	}
	public void setLEDOff() {
		LEDControl(0);
		RobotMap.color = Color.OFF;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

