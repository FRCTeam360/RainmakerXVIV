
package org.usfirst.frc.team360.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;

public class Constants {
	
	private BufferedReader buff;
	private String buffLine;
	
	private final double compElevatorF = .216;
	private final double compElevatorP = 0.2;
	private final double compElevatorI = 0;
	private final double compElevatorD = 0;
	
	private final double compLeftDriveTrainPathPlanningF = 0.60176;
	private final double compLeftDriveTrainPathPlanningP = 1.25;//.235;//.0225;
	private final double compLeftDriveTrainPathPlanningI = 0;
	private final double compleftDriveTrainPathPlanningD = 100;
	
	private final double compRightDriveTrainPathPlanningF = 0.60176;
	private final double compRightDriveTrainPathPlanningP = 1.25;//.235;//.03;
	private final double compRightDriveTrainPathPlanningI = 0;
	private final double compRightDriveTrainPathPlanningD = 100;
	
	public final double compElevatorTopScale = 86;
	public final double compElevatorMidScale = 75;
	public final double compElevatorSwitchHeight = 36;
	public final double compElevatorIntakePos = 4.25;
	public final double compElevatorOffGround = 10;
	
	public final double compEncoderCountsToInches = 643.05;
	
	private final double pracElevatorF = 0.2407;
	private final double pracElevatorP = 4;
	private final double pracElevatorI = 0;
	private final double pracElevatorD = 40;
	
	private final double pracleftDrivetrainPathPlanningF = 0.5384;
	private final double pracLeftDrivetrainPathPlanningP = 0.035;
	private final double pracleftDrivetrainPathPlanningI = 0.0;
	private final double pracLeftDrivetrainPathPlanningD = 3.5;
	
	private final double pracRightDriveTrainPathPlanningF = 0.6133;
	private final double pracRightDriveTrainPathPlanningP = 0.035;
	private final double pracRightDriveTrainPathPlanningI = 0.0;
	private final double pracRightDriveTrainPathPlanningD = 3.5;

	public final double pracElevatorTopScale = 84;
	public final double pracElevatorMidScale = 74;
	public final double pracElevatorSwitchHeight = 35;
	public final double pracElevatorIntakePos = 0;
	public final double pracElevatorOffGround = 7;
	
	public final double pracEncoderCountsToInches = 607.42;
	
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
	public static double realElevatorOffGround;
	
	public static double realEncoderCountsToInches;
	
	public static double compPIDNavxTurnGainMultiplier = 0;
	public static double compPIDNavxTurnP = 0;
	public static double compPIDNavxTurnI = 0;
	public static double compPIDNavxTurnD = 0;
	
	public static double realPIDNavxTurnGainMultiplier = 0;
	public static double realPIDNavxTurnP = 0;
	public static double realPIDNavxTurnI = 0;
	public static double realPIDNavxTurnD = 0;
	
	public static double pracPIDNavxTurnGainMultiplier = 0;
	public static double pracPIDNavxTurnP = 0;
	public static double pracPIDNavxTurnI = 0;
	public static double pracPIDNavxTurnD = 0;
	
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
		realElevatorOffGround = compElevatorOffGround;
		
		realPIDNavxTurnGainMultiplier = compPIDNavxTurnGainMultiplier;
		realPIDNavxTurnP = compPIDNavxTurnP;
		realPIDNavxTurnI = compPIDNavxTurnI;
		realPIDNavxTurnD = compPIDNavxTurnD;
		
		realEncoderCountsToInches = compEncoderCountsToInches;
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
		realElevatorOffGround = pracElevatorOffGround;
		
		realPIDNavxTurnGainMultiplier = pracPIDNavxTurnGainMultiplier;
		realPIDNavxTurnP = pracPIDNavxTurnP;
		realPIDNavxTurnI = pracPIDNavxTurnI;
		realPIDNavxTurnD = pracPIDNavxTurnD;
		
		realEncoderCountsToInches = pracEncoderCountsToInches;
	}
}
