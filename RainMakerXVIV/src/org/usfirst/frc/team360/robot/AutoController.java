package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.autos.CrossLineMotionProfiled;
import org.usfirst.frc.team360.robot.RobotMap.ScaleSide;
import org.usfirst.frc.team360.robot.commands.autos.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoController {
	SendableChooser<String> startChooser;
	SendableChooser<String> firstPriority;
	
	public static String selectedStartPosition = "";

	Command doNothingAuto;
	Command crossLineMotionProfiled;
	Command startCenterDropCubeLeftScale;
	Command startCenterDropCubeLeftSwitch;
	Command startCenterDropCubeRightScale;
	Command startCenterDropCubeRightSwitch;
	Command startLeftDropCubeLeftScale;
	Command startLeftDropCubeLeftSwitch;
	Command startLeftDropCubeRightScale;
	Command startRightDropCubeLeftScale;
	Command startRightDropCubeRightScale;
	Command startRightDropCubeRightSwitch;
	
	public AutoController() {
		doNothingAuto = new DoNothingAuto();
		crossLineMotionProfiled = new CrossLineMotionProfiled();
		startCenterDropCubeLeftScale = new StartCenterDropCubeLeftScale();
		startCenterDropCubeLeftSwitch = new StartCenterDropCubeLeftSwitch();
		startCenterDropCubeRightScale = new StartCenterDropCubeRightScale();
		startCenterDropCubeRightSwitch = new StartCenterDropCubeRightSwitch();
		startLeftDropCubeLeftScale = new StartLeftDropCubeLeftScale();
		startLeftDropCubeLeftSwitch = new StartLeftDropCubeLeftSwitch();
		startLeftDropCubeRightScale = new StartLeftDropCubeRightScale();
		startRightDropCubeLeftScale = new StartRightDropCubeLeftScale();
		startRightDropCubeRightScale = new StartRightDropCubeRightScale();
		startRightDropCubeRightSwitch = new StartRightDropCubeRightSwitch();
		startChooser = new SendableChooser<>();
		startChooser.addDefault("Center", "Center");
		startChooser.addObject("Left", "Left");
		startChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Location", startChooser);
	}
	public void getLightConfiguration(){
		try {
			String gameData = null  ;
			while(gameData.length() < 2) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if("L".equals((String.valueOf(gameData.charAt(0))))) {
				//DriverStation.reportWarning("L alliance switch", false);
				RobotMap.switchSide = RobotMap.SwitchSide.LEFT;
			} else {
				//DriverStation.reportWarning("R alliance switch", false);
				RobotMap.switchSide = RobotMap.SwitchSide.RIGHT;
			}
			if("L".equals((String.valueOf(gameData.charAt(1))))) {
				//DriverStation.reportWarning("L scale", false);
				RobotMap.scaleSide = RobotMap.ScaleSide.LEFT;
			} else {
				//DriverStation.reportWarning("R scale", false);
				RobotMap.scaleSide = RobotMap.ScaleSide.RIGHT;
			}
			SmartDashboard.putString("Switch/ Scale configuration", "Switch: " + RobotMap.switchSide.name() + " Scale: " + RobotMap.scaleSide.name());
			RobotMap.FMSSideData = gameData;
			}
			Robot.logger.logFMSSideData();
			
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
			SmartDashboard.putString("Selected Auto", "Error, please select good auto");
			SmartDashboard.putBoolean("Ready for auto", false);
			SmartDashboard.putString("Switch/ Scale configuration", "Error, configuration not found");
		}
	}

	public void smartDashboardAutoController() {
		try {
			if("Center".equals(startChooser.getSelected())){
				if(!"Center".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Either Switch", "Either Switch");
					firstPriority.addObject("Right Switch", "Right Switch");
					firstPriority.addObject("Left Switch", "Left Switch");
					firstPriority.addObject("Right Scale", "Right Scale");
					firstPriority.addObject("Left Scale", "Left Scale");
					SmartDashboard.clearPersistent("First Priority");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Center";
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Left".equals(startChooser.getSelected())){
				if(!"Left".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Close Switch", "Close Switch");
					if(RobotMap.scaleSide.name() == "Left") {
						firstPriority.addObject("Close Scale", "Close Scale");
					}
					else if(RobotMap.scaleSide.name() == "Right") {
						firstPriority.addObject("Far Scale", "Far Scale");
					}
					//firstPriority.addObject("Far Switch", "Far Switch");
					SmartDashboard.clearPersistent("First Priority");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Left";
				}
			}	
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Right".equals(startChooser.getSelected())){
				if(!"Right".equals(selectedStartPosition)){
					firstPriority = new SendableChooser<>();
					firstPriority.addDefault("Cross Line", "Cross Line");
					firstPriority.addObject("Close Switch", "Close Switch");
					if(RobotMap.scaleSide.name() == "Right") {
						firstPriority.addObject("Close Scale", "Close Scale");
					}
					else if(RobotMap.scaleSide.name() == "Left") {
						firstPriority.addObject("Far Scale", "Far Scale");
					}
					//firstPriority.addObject("Far Switch", "Far Switch");
					SmartDashboard.clearPersistent("First Priority");
					SmartDashboard.putData("First Priority", firstPriority);
					selectedStartPosition = "Right";
				}
			}
		}catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
		try {
			if("Center".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Either Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Either Switch");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Left Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Left Switch");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Right Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Right Switch");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Left Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Left Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Right Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Right Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else {
					SmartDashboard.putString("Selected Auto", "Error, please select good auto");
					SmartDashboard.putBoolean("Ready for auto", false);
				}
			} else if("Left".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Close Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Left to Left Switch");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Close Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Left to Left Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Far Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Left to Right Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else {
					SmartDashboard.putString("Selected Auto", "Error, please select good auto");
					SmartDashboard.putBoolean("Ready for auto", false);
				}
			} else if("Right".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Close Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Right to Right Switch");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Close Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Right to Right Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Far Scale".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Right to Left Scale");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else {
					SmartDashboard.putString("Selected Auto", "Error, please select good auto");
					SmartDashboard.putBoolean("Ready for auto", false);
				}
			} else {
				SmartDashboard.putString("Selected Auto", "Error, please select good auto");
				SmartDashboard.putBoolean("Ready for auto", false);
			}
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
			SmartDashboard.putString("Selected Auto", "Error, please select good auto");
			SmartDashboard.putBoolean("Ready for auto", false);
		}
		try {
			getLightConfiguration();
		} catch(Exception e) {
			DriverStation.reportError(e.toString(), true);
			SmartDashboard.putString("Selected Auto", "Error, please select good auto");
			SmartDashboard.putBoolean("Ready for auto", false);
		}
	}
	
	public Command chooseAutoMode() {
		getLightConfiguration();
		if("Center".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if("Either Switch".equals(firstPriority.getSelected())){
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Center to Left Switch");
					return startCenterDropCubeLeftSwitch;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Center to Right Switch");
					return startCenterDropCubeRightSwitch;
				}
			} else if("Left Switch".equals(firstPriority.getSelected())){
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Center to Left Switch");
					return startCenterDropCubeLeftSwitch;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			} else if("Right Switch".equals(firstPriority.getSelected())){
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Center to Right Switch");
					return startCenterDropCubeRightSwitch;
				}
			}
		} else if("Left".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Left to Left Switch");
					return startLeftDropCubeLeftSwitch;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			} else if("Close Scale".equals(firstPriority.getSelected())) {
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Left to Left Scale");
					return startLeftDropCubeLeftScale;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			} else if("Far Scale".equals(firstPriority.getSelected())) {
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Left to Right Scale");
					return startLeftDropCubeRightScale;
				}
			}
		} else if("Right".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Right to Right auton");
					return startRightDropCubeRightSwitch;
				}
			} else if("Close Scale".equals(firstPriority.getSelected())) {
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Left to Right Scale");
					return startLeftDropCubeRightScale;
				}
			} else if("Far Scale".equals(firstPriority.getSelected())) {
				if(RobotMap.switchSide.equals(RobotMap.SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Left to Left Scale");
					return startLeftDropCubeLeftScale;
				} else if(RobotMap.switchSide.equals(RobotMap.SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			}
		}
		return null;
	}
}
