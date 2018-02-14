package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.RobotMap.IntakeState;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakePneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid intakePneumatics = RobotMap.intakePneumatics;
	
	public void open() {
		intakePneumatics.set(DoubleSolenoid.Value.kForward);
		RobotMap.intakeState = IntakeState.IN;
	}
	public void close() {
		intakePneumatics.set(DoubleSolenoid.Value.kReverse);
		RobotMap.intakeState = IntakeState.OUT;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

