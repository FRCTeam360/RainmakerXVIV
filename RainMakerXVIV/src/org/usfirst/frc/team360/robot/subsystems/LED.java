package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.Color;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *
 */
public class LED extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Spark controlLED = RobotMap.LED_Control;
	
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
	public void setLEDViolet() {
		LEDControl(0.91);
		RobotMap.color = Color.VIOLET;
	}
	public void setLEDPulse() {
		LEDControl(-0.09);
		RobotMap.color = Color.PULSING;
	}
	public void setLEDRainbow() {
		LEDControl(-0.99);
		RobotMap.color = Color.RAINBOW;
	}
	public void setLEDOff() {
		LEDControl(0.99);
		RobotMap.LED_Control.disable();
		RobotMap.color = Color.OFF;
	}
	
	public void changeColor(RobotMap.Color color) {
		
		switch (color) {
		case RED:
			setLEDRed();
			break;
		case ORANGE:
			setLEDOrange();
			break;
		case YELLOW:
			setLEDYellow();
			break;
		case GREEN:
			setLEDGreen();
			break;
		case BLUE:
			setLEDBlue();
			break;
		case VIOLET:
			setLEDViolet();
			break;
		case PULSING:
			setLEDPulse();
			break;
		case RAINBOW:
			setLEDRainbow();
			break;
		case OFF:
			setLEDOff();
			break;
		}
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

