
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
	
	public static int comp_kelevatorF = 1;
	public static int comp_kelevatorP = 1;
	public static int comp_kelevatorI = 1;
	public static int comp_kelevatorD = 1;
	
	public static int comp_kleftDriveTrainF = 1;
	public static int comp_kleftDriveTrainP = 1;
	public static int comp_kleftDriveTrainI = 1;
	public static int comp_kleftDriveTrainD = 1;
	
	public static int comp_krightDriveTrainF = 1;
	public static int comp_krightDriveTrainP = 1;
	public static int comp_krightDriveTrainI = 1;
	public static int comp_krightDriveTrainD = 1;
	
	
	public static int prac_kF = 0;
	public static int prac_kP = 0;
	public static int prac_kI = 0;
	public static int prac_kD = 0;
	
	public static int prac_kelevatorF = 0;
	public static int prac_kelevatorP = 0;
	public static int prac_kelevatorI = 0;
	public static int prac_kelevatorD = 0;
	
	public static int prac_kleftDrivetrainF = 0;
	public static int prac_kleftDrivetrainP = 0;
	public static int prac_kleftDrivetrainI = 0;
	public static int prac_kleftDrivetrainD = 0;
	
	public static int prac_krightDriveTrainF = 0;
	public static int prac_krightDriveTrainP = 0;
	public static int prac_krightDriveTrainI = 0;
	public static int prac_krightDriveTrainD = 0;

	public static int real_F;
	public static int real_P;
	public static int real_I;
	public static int real_D;

	public String buffLine;
	
	public static int real_elevatorF;
	public static int real_elevatorP;
	public static int real_elevatorI;
	public static int real_elevatorD;
	
	public static int real_leftDriveTrainF;
	public static int real_leftDriveTrainP;
	public static int real_leftDriveTrainI;
	public static int real_leftDriveTrainD;
	
	public static int real_rightDriveTrainF;
	public static int real_rightDriveTrainP;
	public static int real_rightDriveTrainI;
	public static int real_rightDriveTrainD;
	
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
		
		Constants.real_elevatorF = Constants.comp_kelevatorF;
		Constants.real_elevatorP = Constants.comp_kelevatorP;
		Constants.real_elevatorI = Constants.comp_kelevatorI;
		Constants.real_elevatorD = Constants.comp_kelevatorD;
		
		Constants.real_leftDriveTrainF = Constants.comp_kleftDriveTrainF;
		Constants.real_leftDriveTrainP = Constants.comp_kleftDriveTrainP;
		Constants.real_leftDriveTrainI = Constants.comp_kleftDriveTrainI;
		Constants.real_leftDriveTrainD = Constants.comp_kleftDriveTrainD;
		
		Constants.real_rightDriveTrainF = Constants.comp_krightDriveTrainF;
		Constants.real_rightDriveTrainP = Constants.comp_krightDriveTrainP;
		Constants.real_rightDriveTrainI = Constants.comp_krightDriveTrainI;
		Constants.real_rightDriveTrainD = Constants.comp_krightDriveTrainD;
	}
	public void writePracticeBotVariables() {
		Constants.real_F = Constants.prac_kF;
		Constants.real_P = Constants.prac_kP;
		Constants.real_I = Constants.prac_kI;
		Constants.real_D = Constants.prac_kD;
		
		Constants.real_elevatorF = Constants.prac_kelevatorF;
		Constants.real_elevatorP = Constants.prac_kelevatorP;
		Constants.real_elevatorI = Constants.prac_kelevatorI;
		Constants.real_elevatorD = Constants.prac_kelevatorD;
		
		Constants.real_leftDriveTrainF = Constants.prac_kleftDrivetrainF;
		Constants.real_leftDriveTrainP = Constants.prac_kleftDrivetrainP;
		Constants.real_leftDriveTrainI = Constants.prac_kleftDrivetrainI;
		Constants.real_leftDriveTrainD = Constants.prac_kleftDrivetrainD;
		
		Constants.real_rightDriveTrainF = Constants.prac_krightDriveTrainF;
		Constants.real_rightDriveTrainP = Constants.prac_krightDriveTrainP;
		Constants.real_rightDriveTrainI = Constants.prac_krightDriveTrainI;
		Constants.real_rightDriveTrainD = Constants.prac_krightDriveTrainD;
	}
}