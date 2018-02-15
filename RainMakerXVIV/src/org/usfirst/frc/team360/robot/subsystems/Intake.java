package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {

	private PowerDistributionPanel pdp = RobotMap.pdp;
	
	private VictorSP motorIntake1 = RobotMap.motorIntake1;
	private VictorSP motorIntake2 = RobotMap.motorIntake2;
	
	public void controlMotor(double speed) {
		motorIntake1.set(-speed);
		motorIntake2.set(speed);
	}
	public void controlRightMotor(double speed) {
		motorIntake1.set(-speed);
	}
	public void controlLeftMotor(double speed) {
		motorIntake2.set(speed);
	}
	public void stop() {
		motorIntake1.set(0);
		motorIntake2.set(0);
	}
	public double currentDraw() {
		return pdp.getCurrent(5);
	}
	public void displayCurrent() {
		SmartDashboard.putNumber("Amps: ", pdp.getCurrent(5));
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new VictorControl());
    }
}