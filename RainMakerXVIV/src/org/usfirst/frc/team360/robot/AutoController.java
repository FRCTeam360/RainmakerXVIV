package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.autos.CrossLineMotionProfiled;
import org.usfirst.frc.team360.robot.commands.autos.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoController {
	SendableChooser<String> startChooser;
	SendableChooser<String> LeftLeft;
	SendableChooser<String> LeftRight;
	SendableChooser<String> RightLeft;
	SendableChooser<String> RightRight;

	public static String selectedStartPosition = "None";

	Command doNothingAuto;
	Command crossLineMotionProfiled;
	Command startCenterDropCubeLeftSwitch;
	Command startCenterDropCubeRightSwitch;
	Command startLeftDropCubeLeftSwitch;
	Command startRightDropCubeRightSwitch;
	Command startLeftDropCubeLeftScale;
	Command startRightDropCubeRightScale;

	public AutoController() {

		doNothingAuto = new DoNothingAuto();
		crossLineMotionProfiled = new CrossLineMotionProfiled();
		startCenterDropCubeLeftSwitch = new StartCenterDropCubeLeftSwitch();
		startCenterDropCubeRightSwitch = new StartCenterDropCubeRightSwitch();
		startLeftDropCubeLeftSwitch = new StartLeftDropCubeLeftSwitch();
		startRightDropCubeRightSwitch = new StartRightDropCubeRightSwitch();
		startLeftDropCubeLeftScale = new StartLeftDropCubeLeftScale();
		startRightDropCubeRightScale = new StartRightDropCubeRightScale();

		startChooser = new SendableChooser<>();
		startChooser.addDefault("None", "None");
		startChooser.addObject("Center", "Center");
		startChooser.addObject("Left", "Left");
		startChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Location", startChooser);
		
	}

	public void getLightConfiguration() {
		try {
			String gameData = null;
			while (gameData.length() < 2) {
				gameData = DriverStation.getInstance().getGameSpecificMessage();
			}
				if ("L".equals((String.valueOf(gameData.charAt(0))))) {
					// DriverStation.reportWarning("L alliance switch", false);
					RobotMap.switchSide = RobotMap.SwitchSide.LEFT;
				} else {
					// DriverStation.reportWarning("R alliance switch", false);
					RobotMap.switchSide = RobotMap.SwitchSide.RIGHT;
				}
				if ("L".equals((String.valueOf(gameData.charAt(1))))) {
					// DriverStation.reportWarning("L scale", false);
					RobotMap.scaleSide = RobotMap.ScaleSide.LEFT;
				} else {
					// DriverStation.reportWarning("R scale", false);
					RobotMap.scaleSide = RobotMap.ScaleSide.RIGHT;
				}
				SmartDashboard.putString("Switch/ Scale configuration",
						"Switch: " + RobotMap.switchSide.name() + " Scale: " + RobotMap.scaleSide.name());
				RobotMap.FMSSideData = gameData;
			
			Robot.logger.logFMSSideData();

		} catch (Exception e) {
			DriverStation.reportError(e.toString(), true);
			SmartDashboard.putString("Selected Auto", "Error, please select good auto");
			SmartDashboard.putBoolean("Ready for auto", false);
			SmartDashboard.putString("Switch / Scale configuration", "Error, configuration not found");
		}
	}

	public void smartDashboardAutoController() {
		try {
			if("Left".equals(startChooser.getSelected())){
				if(!"Left".equals(selectedStartPosition)){
					/*
					 *  This is an option for the future if we have a cross over scale
					 *  RightRight.addObject("LeftCrossRightScale", "LeftCrossRightScale");
					*/
					//Set LeftLeft Options
					LeftLeft = new SendableChooser<>();
					LeftLeft.addDefault("Cross Line", "Cross Line");
					LeftLeft.addObject("Left Switch", "Left Switch");
					LeftLeft.addObject("Left Scale", "Left Scale");
					//Set LeftRight Options
					LeftRight = new SendableChooser<>();
					LeftRight.addDefault("Cross Line", "Cross Line");
					LeftRight.addObject("Left Switch", "Left Switch");
					//Set RightLeft Options
					RightLeft = new SendableChooser<>();
					RightLeft.addDefault("Cross Line", "Cross Line");
					RightLeft.addObject("Left Scale", "Left Scale");
					//Set RightRight Options
					RightRight = new SendableChooser<>();
					RightRight.addDefault("Cross Line", "Cross Line");

					
					SmartDashboard.putData("Left Left", LeftLeft);
					SmartDashboard.putData("Left Right", LeftRight);
					SmartDashboard.putData("Right Left", RightLeft);
					SmartDashboard.putData("Right Right", RightRight);
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Center".equals(startChooser.getSelected())){
				if(!"Center".equals(selectedStartPosition)){
					
					//Set LeftLeft Options
					LeftLeft = new SendableChooser<>();
					LeftLeft.addDefault("Cross Line", "Cross Line");
					LeftLeft.addObject("Center Left Switch", "Center Left Switch");
					//LeftLeft.addObject("Center Left Two Cube Switch", "Center Left Two Cube Switch");
					//Set LeftRight Options
					LeftRight = new SendableChooser<>();
					LeftRight.addDefault("Cross Line", "Cross Line");
					LeftRight.addObject("Center Left Switch", "Center Left Switch");
					//LeftLeft.addObject("Center Left Two Cube Switch", "Center Left Two Cube Switch");
					//Set RightLeft Options
					RightLeft = new SendableChooser<>();
					RightLeft.addDefault("Cross Line", "Cross Line");
					RightLeft.addObject("Center Right Switch", "Center Right Switch");
					//RightLeft.addObject("Center Right Two Cube Switch", "Center Right Two Cube Switch");
					//Set RightRight Options
					RightRight = new SendableChooser<>();
					RightRight.addDefault("Cross Line", "Cross Line");
					RightRight.addObject("Center Right Switch", "Center Right Switch");
					//RightRight.addObject("Center Right Two Cube Switch", "Center Right Two Cube Switch");

					
					SmartDashboard.putData("Left Left", LeftLeft);
					SmartDashboard.putData("Left Right", LeftRight);
					SmartDashboard.putData("Right Left", RightLeft);
					SmartDashboard.putData("Right Right", RightRight);
				}
			}	
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Right".equals(startChooser.getSelected())){
				if(!"Right".equals(selectedStartPosition)){
					
					/*
					 *  This is an option for the future if we have a cross over scale
					 *  LeftLeft.addObject("LeftCrossRightScale", "LeftCrossRightScale");
					*/
					//Set LeftLeft Options
					LeftLeft = new SendableChooser<>();
					LeftLeft.addDefault("Cross Line", "Cross Line");
					//Set LeftRight Options
					LeftRight = new SendableChooser<>();
					LeftRight.addDefault("Cross Line", "Cross Line");
					LeftRight.addObject("Right Switch", "Right Switch");
					//Set RightLeft Options
					RightLeft = new SendableChooser<>();
					RightLeft.addDefault("Cross Line", "Cross Line");
					RightLeft.addObject("Right Scale", "Right Scale");
					//Set RightRight Options
					RightRight = new SendableChooser<>();
					RightRight.addDefault("Cross Line", "Cross Line");
					RightRight.addObject("Right Switch", "Right Switch");
					RightRight.addObject("Right Scale", "Right Scale");
					
					SmartDashboard.putData("Left Left", LeftLeft);
					SmartDashboard.putData("Left Right", LeftRight);
					SmartDashboard.putData("Right Left", RightLeft);
					SmartDashboard.putData("Right Right", RightRight);
					
					
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		
		try {
			if("Center".equals(startChooser.getSelected())){	
				if("Cross Line".equals(LeftLeft.getSelected()) ||
						"Cross Line".equals(LeftRight.getSelected()) ||
						"Cross Line".equals(RightLeft.getSelected()) || 
						"Cross Line".equals(RightRight.getSelected())){
							SmartDashboard.putString("Selected Auto", "Crossing Line");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else if ("Left Center Switch".equals(LeftLeft.getSelected()) ||
							"Left Center Switch".equals(LeftRight.getSelected())) {
							SmartDashboard.putString("Selected Auto", "Left Center Switch");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else if ("Right Center Switch".equals(RightLeft.getSelected()) ||
							"Right Center Switch".equals(RightRight.getSelected())) {
							SmartDashboard.putString("Selected Auto", "Right Center Scale");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else {
						SmartDashboard.putString("Selected Auto", "ERROR: INVALID AUTO");
						SmartDashboard.putBoolean("Ready for auto", false);
					}
				
			} else if("Left".equals(startChooser.getSelected())){
				if("Cross Line".equals(LeftLeft.getSelected()) ||
					"Cross Line".equals(LeftRight.getSelected()) ||
					"Cross Line".equals(RightLeft.getSelected()) || 
					"Cross Line".equals(RightRight.getSelected())){
						SmartDashboard.putString("Selected Auto", "Crossing Line");
						SmartDashboard.putBoolean("Ready for auto", true);
				} else if ("Left Switch".equals(LeftLeft.getSelected()) ||
						"Left Switch".equals(RightLeft.getSelected())) {
						SmartDashboard.putString("Selected Auto", "Left Switch");
						SmartDashboard.putBoolean("Ready for auto", true);
				} else if ("Left Scale".equals(LeftLeft.getSelected()) ||
						"Left Scale".equals(LeftRight.getSelected())) {
						SmartDashboard.putString("Selected Auto", "Left Scale");
						SmartDashboard.putBoolean("Ready for auto", true);
				} else {
					SmartDashboard.putString("Selected Auto", "ERROR: INVALID AUTO");
					SmartDashboard.putBoolean("Ready for auto", false);
				}
				
			} else if("Right".equals(startChooser.getSelected())) {
				if("Cross Line".equals(LeftLeft.getSelected()) ||
						"Cross Line".equals(LeftRight.getSelected()) ||
						"Cross Line".equals(RightLeft.getSelected()) || 
						"Cross Line".equals(RightRight.getSelected())){
							SmartDashboard.putString("Selected Auto", "Crossing Line");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else if ("Right Switch".equals(RightRight.getSelected()) ||
							"Right Switch".equals(LeftRight.getSelected())) {
							SmartDashboard.putString("Selected Auto", "Right Switch");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else if ("Right Scale".equals(RightRight.getSelected()) ||
							"Right Scale".equals(RightLeft.getSelected())) {
							SmartDashboard.putString("Selected Auto", "Right Scale");
							SmartDashboard.putBoolean("Ready for auto", true);
					} else {
						SmartDashboard.putString("Selected Auto", "ERROR: INVALID AUTO");
						SmartDashboard.putBoolean("Ready for auto", false);
					}
				
			} else {
				SmartDashboard.putString("Selected Auto", "Error, please select good auto");
				SmartDashboard.putBoolean("Ready for auto", false);
			}
			SmartDashboard.putData("Left Left", LeftLeft);
			SmartDashboard.putData("Left Right", LeftRight);
			SmartDashboard.putData("Right Left", RightLeft);
			SmartDashboard.putData("Right Right", RightRight);
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
			SmartDashboard.putString("Selected Auto", "Error, please select good auto");
			SmartDashboard.putBoolean("Ready for auto", false);
		}
	}

	public Command chooseAutoMode() {
		getLightConfiguration();
		if ("Center".equals(startChooser.getSelected())) {
			if ("Cross Line".equals(LeftLeft.getSelected()) || 
					"Cross Line".equals(LeftRight.getSelected()) ||
					"Cross Line".equals(RightLeft.getSelected()) ||
					"Cross Line".equals(RightRight.getSelected())) {
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if ("Left Center Switch".equals(LeftLeft.getSelected()) ||
					"Left Center Switch".equals(LeftRight.getSelected())) {
				if (RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)) {
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
					return startCenterDropCubeLeftSwitch;
				} else if (RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)) {
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			} else if ("Right Center Switch".equals(RightLeft.getSelected()) ||
					"Right Center Switch".equals(RightRight.getSelected())) {
				if (RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)) {
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
					return startCenterDropCubeRightSwitch;
				} else if (RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)) {
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			}
		}
		return null;
	}
}
