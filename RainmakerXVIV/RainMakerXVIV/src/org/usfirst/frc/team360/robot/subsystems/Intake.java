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

	PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	VictorSP VicArm1 = RobotMap.Arm1;
	VictorSP VicArm2 = RobotMap.Arm2;
	
	public void controlMotor(double speed) {
		VicArm1.set(speed);
		VicArm2.set(-speed);
	}
	public double currentDraw() {
		return pdp.getCurrent(12);
	}
	public void displayCurrent() {
		SmartDashboard.putNumber("Amps: ", pdp.getCurrent(12));
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new VictorControl());
    }
}

