package org.usfirst.frc.team360.robot.commands.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class JoystickAxisButton extends Trigger {
	
	public Joystick joy;
	public int axis;
	public double completionCritera;
	
	public JoystickAxisButton(Joystick _joy, int _axis, double _completionCritera){
		joy = _joy;
		axis = Math.abs(_axis);
		completionCritera = _completionCritera;
	}
	
    public boolean get() {
    		return joy.getRawAxis(axis) > completionCritera;
    }
}
