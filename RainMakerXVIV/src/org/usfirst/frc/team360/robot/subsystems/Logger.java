package org.usfirst.frc.team360.robot.subsystems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Logger extends Subsystem {
	
	String content;
    FileWriter fw;
    BufferedWriter bw;
	File Log;
	
	public void initLogger(){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date(); 
			String name = dateFormat.format(date);
			Log.createNewFile();
			fw = new FileWriter(Log.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			String startFile = name + '\n';
			bw.write(startFile);
			bw.flush();
		} catch (Exception e) {
			e.toString();
		}
	}
	public void logRobotNavX() {
		try {
			bw.write("navX Triggered" + '\n');
			bw.write('\t' + "Accel X: " + RobotMap.accelX + '\n');
			bw.write('\t' + "Accel Y: " + RobotMap.accelY + '\n');
			bw.flush();
		} catch (Exception e) {
			
		}
	}
	public void closeLogger(){
		try {
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
    public void initDefaultCommand() {
    }
}
