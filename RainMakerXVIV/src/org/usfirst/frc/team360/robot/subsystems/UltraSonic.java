package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.commands.UltraSonicRead;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltraSonic extends Subsystem {

	public Ultrasonic ultra = RobotMap.ultra;
	public double range;
	
	public void getUltrasonicInches() {
    	range = ultra.getRangeInches(); // reads the range on the ultrasonic sensor
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new UltraSonicRead());
    }
}

