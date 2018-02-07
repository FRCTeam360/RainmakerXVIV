
package org.usfirst.frc.team360.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;

public class Constants {
	
	public static BufferedReader buff;
	
	public static int comp_kF = 1;
	public static int comp_kP = 1;
	public static int comp_kI = 1;
	public static int comp_kD = 1;
	
	public static int prac_kF = 0;
	public static int prac_kP = 0;
	public static int prac_kI = 0;
	public static int prac_kD = 0;


	public static int real_F;
	public static int real_P;
	public static int real_I;
	public static int real_D;
	public String buffLine;
	public Constants() {
		try {
			buff = new BufferedReader(new FileReader("home/lvuser/RobotID.txt"));
			buffLine = buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ("comp".equals(buffLine)) {
			RobotMap.robotID = RobotMap.RobotID.COMP;
			DriverStation.reportError("Comp Bot", false);
			writeCompBotVariables();
		} else if ("practice".equals(buffLine)) {
			RobotMap.robotID = RobotMap.RobotID.PRACTICE;
			DriverStation.reportError("Practice Bot", false);
			writePracticeBotVariables();
		} else {
			RobotMap.robotID = RobotMap.RobotID.COMP;
			DriverStation.reportError("Invalid Robot ID, defaulting to comp bot variables", false);
			writeCompBotVariables();
		}
		
	}
	public void writeCompBotVariables() {
		Constants.real_F = Constants.comp_kF;
		Constants.real_P = Constants.comp_kP;
		Constants.real_I = Constants.comp_kI;
		Constants.real_D = Constants.comp_kD;
	}
	public void writePracticeBotVariables() {
		Constants.real_F = Constants.prac_kF;
		Constants.real_P = Constants.prac_kP;
		Constants.real_I = Constants.prac_kI;
		Constants.real_D = Constants.prac_kD;
	}
}