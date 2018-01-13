package org.usfirst.frc.team360.robot.subsystems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Logger extends Subsystem {
	
	String content;
    FileWriter fw;
    BufferedWriter bw;
	File Log;
	
	public void initLogger(){
		try {

			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date();
			//System.out.println(dateFormat.format(date));
			String name = dateFormat.format(date);
    		Log = new File("u/" + "Test" + name + ".txt");//Log  location
			if (!Log.exists()) {
				Log.createNewFile();
			}
			fw = new FileWriter(Log.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.flush();
		} catch (Exception e) {
			e.toString();
		}
	}

	public void logRobotState(){
		try{
			//RobotState = RobotMap.state.equals(null);
			bw.write('\t' + "Tele OP" + '\n');
		} catch (Exception e) {
			// TODO Auto-generated catch block
			////e.printStackTrace();
		}
	}
	
	public void logRobotNavX() {
		try {
			bw.write('\t' + "navX Triggered" + '\n');
		} catch (Exception e) {
			
		}
	}

	public void closeLogger(){
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
    public void initDefaultCommand() {
    }
}
