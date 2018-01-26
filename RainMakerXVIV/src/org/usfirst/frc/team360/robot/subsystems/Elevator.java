package org.usfirst.frc.team360.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public TalonSRX _talon = new TalonSRX(1);
	
	public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 10;

	public void motionMagicInit() {
		System.out.println("Working Subsystem");
		
		/* first choose the sensor */
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
		_talon.setSensorPhase(true);
		_talon.setInverted(false);
		
		/* Set relevant frame periods to be at least as fast as periodic rate*/
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);

		/* set the peak and nominal outputs, 12V means full */
		_talon.configNominalOutputForward(0, kTimeoutMs);
		_talon.configNominalOutputReverse(0, kTimeoutMs);
		_talon.configPeakOutputForward(1, kTimeoutMs);
		_talon.configPeakOutputReverse(-1, kTimeoutMs);
		
		/* set closed loop gains in slot0 - see documentation */
		_talon.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
		_talon.config_kF(0, 0.2, kTimeoutMs);
		_talon.config_kP(0, 0.2, kTimeoutMs);
		_talon.config_kI(0, 0, kTimeoutMs);
		_talon.config_kD(0, 0, kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		_talon.configMotionCruiseVelocity(7500, kTimeoutMs);
		_talon.configMotionAcceleration(100, kTimeoutMs);
		/* zero the sensor */
		_talon.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
}

