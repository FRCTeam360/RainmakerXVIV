package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	private VictorSP climber = RobotMap.motorClimber1;
	private VictorSP climber1 = RobotMap.motorClimber2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void setMotorSpeed(double speed) {
		climber.set(speed);
	    climber1.set(speed);
	}
	public void stop() {
		climber.set(0);
	    climber1.set(0);
	}
}

