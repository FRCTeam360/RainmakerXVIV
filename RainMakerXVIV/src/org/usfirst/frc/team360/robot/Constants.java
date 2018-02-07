
package org.usfirst.frc.team360.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;

public class Constants {
	
	public static BufferedReader buff;

	public static int compElevatorF = 1;
	public static int compElevatorP = 1;
	public static int compElevatorI = 1;
	public static int compElevatorD = 1;
	
	public static int compLeftDriveTrainF = 1;
	public static int compLeftDriveTrainP = 1;
	public static int compLeftDriveTrainI = 1;
	public static int compleftDriveTrainD = 1;
	
	public static int compRightDriveTrainF = 1;
	public static int compRightDriveTrainP = 1;
	public static int compRightDriveTrainI = 1;
	public static int compRightDriveTrainD = 1;
	
	public static int pracElevatorF = 0;
	public static int pracElevatorP = 0;
	public static int pracElevatorI = 0;
	public static int pracElevatorD = 0;
	
	public static int pracleftDrivetrainF = 0;
	public static int pracLeftDrivetrainP = 0;
	public static int pracleftDrivetrainI = 0;
	public static int pracLeftDrivetrainD = 0;
	
	public static int pracRightDriveTrainF = 0;
	public static int pracRightDriveTrainP = 0;
	public static int pracRightDriveTrainI = 0;
	public static int pracRightDriveTrainD = 0;

	public static int realElevatorF;
	public static int realElevatorP;
	public static int realElevatorI;
	public static int realElevatorD;
  
	public String buffLine;
	
	public static int real_elevatorF;
	public static int real_elevatorP;
	public static int real_elevatorI;
	public static int real_elevatorD;
	
	public static int realLeftDriveTrainF;
	public static int realLeftDriveTrainP;
	public static int realLeftDriveTrainI;
	public static int realLeftDriveTrainD;
	
	public static int realRightDriveTrainF;
	public static int realRightDriveTrainP;
	public static int realRightDriveTrainI;
	public static int realRightDriveTrainD;
	
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
		Constants.realElevatorF = Constants.compElevatorF;
		Constants.realElevatorP = Constants.compElevatorP;
		Constants.realElevatorI = Constants.compElevatorI;
		Constants.realElevatorD = Constants.compElevatorD;
		
		Constants.realLeftDriveTrainF = Constants.compLeftDriveTrainF;
		Constants.realLeftDriveTrainP = Constants.compLeftDriveTrainP;
		Constants.realLeftDriveTrainI = Constants.compLeftDriveTrainI;
		Constants.realLeftDriveTrainD = Constants.compleftDriveTrainD;
		
		Constants.realRightDriveTrainF = Constants.compRightDriveTrainF;
		Constants.realRightDriveTrainP = Constants.compRightDriveTrainP;
		Constants.realRightDriveTrainI = Constants.compRightDriveTrainI;
		Constants.realRightDriveTrainD = Constants.compRightDriveTrainD;
	}
	public void writePracticeBotVariables() {
		Constants.realElevatorF = Constants.pracElevatorF;
		Constants.realElevatorP = Constants.pracElevatorP;
		Constants.realElevatorI = Constants.pracElevatorI;
		Constants.realElevatorD = Constants.pracElevatorD;
		
		Constants.realLeftDriveTrainF = Constants.pracleftDrivetrainF;
		Constants.realLeftDriveTrainP = Constants.pracLeftDrivetrainP;
		Constants.realLeftDriveTrainI = Constants.pracleftDrivetrainI;
		Constants.realLeftDriveTrainD = Constants.pracLeftDrivetrainD;
		
		Constants.realRightDriveTrainF = Constants.pracRightDriveTrainF;
		Constants.realRightDriveTrainP = Constants.pracRightDriveTrainP;
		Constants.realRightDriveTrainI = Constants.pracRightDriveTrainI;
		Constants.realRightDriveTrainD = Constants.pracRightDriveTrainD;
	}
}