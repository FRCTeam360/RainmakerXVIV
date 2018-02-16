
package org.usfirst.frc.team360.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;

public class Constants {
	
	private BufferedReader buff;
	private String buffLine;
	

	private final double compElevatorF = 0;
	private final double compElevatorP = 0;
	private final double compElevatorI = 0;
	private final double compElevatorD = 0;
	
	private final double compLeftDriveTrainPathPlanningF = 0;
	private final double compLeftDriveTrainPathPlanningP = 0;
	private final double compLeftDriveTrainPathPlanningI = 0;
	private final double compleftDriveTrainPathPlanningD = 0;
	
	private final double compRightDriveTrainPathPlanningF = 0;
	private final double compRightDriveTrainPathPlanningP = 0;
	private final double compRightDriveTrainPathPlanningI = 0;
	private final double compRightDriveTrainPathPlanningD = 0;
	
	public final double compElevatorTopScale = 10000;
	public final double compElevatorMidScale = 8000;
	public final double compElevatorSwitchHeight = 1500;
	public final double compElevatorIntakePos = 0;
	
	private final double pracElevatorF = 0.2407;
	private final double pracElevatorP = 4;
	private final double pracElevatorI = 0;
	private final double pracElevatorD = 60;
	
	private final double pracleftDrivetrainPathPlanningF = 0.5384;
	private final double pracLeftDrivetrainPathPlanningP = 0.035;
	private final double pracleftDrivetrainPathPlanningI = 0.0;
	private final double pracLeftDrivetrainPathPlanningD = 3.5;
	
	private final double pracRightDriveTrainPathPlanningF = 0.6133;
	private final double pracRightDriveTrainPathPlanningP = 0.035;
	private final double pracRightDriveTrainPathPlanningI = 0.0;
	private final double pracRightDriveTrainPathPlanningD = 3.5;

	public final double pracElevatorTopScale = 20000;
	public final double pracElevatorMidScale = 8000;
	public final double pracElevatorSwitchHeight = 1500;
	public final double pracElevatorIntakePos = 0;
	
	public static double realElevatorF;
	public static double realElevatorP;
	public static double realElevatorI;
	public static double realElevatorD;
  
	public static double realLeftDriveTrainPathPlanningF;
	public static double realLeftDriveTrainPathPlanningP;
	public static double realLeftDriveTrainPathPlanningI;
	public static double realLeftDriveTrainPathPlanningD;
	
	public static double realRightDriveTrainPathPlanningF;
	public static double realRightDriveTrainPathPlanningP;
	public static double realRightDriveTrainPathPlanningI;
	public static double realRightDriveTrainPathPlanningD;
	
	public static double realElevatorTopScale;
	public static double realElevatorMidScale;
	public static double realElevatorSwitchHeight;
	public static double realElevatorIntakePos;
	
	public Constants() {
		try {
			buff = new BufferedReader(new FileReader("home/lvuser/RobotID.txt"));
			buffLine = buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ("competition".equals(buffLine)) {
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
		realElevatorF = compElevatorF;
		realElevatorP = compElevatorP;
		realElevatorI = compElevatorI;
		realElevatorD = compElevatorD;
		
		realLeftDriveTrainPathPlanningF = compLeftDriveTrainPathPlanningF;
		realLeftDriveTrainPathPlanningP = compLeftDriveTrainPathPlanningP;
		realLeftDriveTrainPathPlanningI = compLeftDriveTrainPathPlanningI;
		realLeftDriveTrainPathPlanningD = compleftDriveTrainPathPlanningD;
		
		realRightDriveTrainPathPlanningF = compRightDriveTrainPathPlanningF;
		realRightDriveTrainPathPlanningP = compRightDriveTrainPathPlanningP;
		realRightDriveTrainPathPlanningI = compRightDriveTrainPathPlanningI;
		realRightDriveTrainPathPlanningD = compRightDriveTrainPathPlanningD;
		
		realElevatorTopScale = 	compElevatorTopScale;
		realElevatorMidScale = compElevatorMidScale;
		realElevatorSwitchHeight = compElevatorSwitchHeight;
		realElevatorIntakePos = compElevatorIntakePos;
	}
	public void writePracticeBotVariables() {
		realElevatorF = pracElevatorF;
		realElevatorP = pracElevatorP;
		realElevatorI = pracElevatorI;
		realElevatorD = pracElevatorD;
		
		realLeftDriveTrainPathPlanningF = pracleftDrivetrainPathPlanningF;
		realLeftDriveTrainPathPlanningP = pracLeftDrivetrainPathPlanningP;
		realLeftDriveTrainPathPlanningI = pracleftDrivetrainPathPlanningI;
		realLeftDriveTrainPathPlanningD = pracLeftDrivetrainPathPlanningD;
		
		realRightDriveTrainPathPlanningF = pracRightDriveTrainPathPlanningF;
		realRightDriveTrainPathPlanningP = pracRightDriveTrainPathPlanningP;
		realRightDriveTrainPathPlanningI = pracRightDriveTrainPathPlanningI;
		realRightDriveTrainPathPlanningD = pracRightDriveTrainPathPlanningD;

		realElevatorTopScale = 	pracElevatorTopScale;
		realElevatorMidScale = pracElevatorMidScale;
		realElevatorSwitchHeight = pracElevatorSwitchHeight;
		realElevatorIntakePos = pracElevatorIntakePos;
	}
}