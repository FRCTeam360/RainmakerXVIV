package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.autos.CrossLineMotionProfiled;
import org.usfirst.frc.team360.robot.commands.autos.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoController {
	SendableChooser<String> startChooser;
	SendableChooser<String> firstPriority;
	
	enum ScaleSide {LEFT, RIGHT};
	ScaleSide scaleSide; 
	enum SwitchSide {LEFT, RIGHT};
	SwitchSide switchSide; 
	
	public static String selectedStartPosition = "";

	Command doNothingAuto;
	Command crossLineMotionProfiled;
	Command startCenterDropCubeLeftSwitch;
	Command startCenterDropCubeRightSwitch;
	Command startLeftDropCubeLeftSwitch;
	Command startRightDropCubeRightSwitch;
	
	public AutoController() {
		doNothingAuto = new DoNothingAuto();
		crossLineMotionProfiled = new CrossLineMotionProfiled();
		startCenterDropCubeLeftSwitch = new StartCenterDropCubeLeftSwitch();
		startCenterDropCubeRightSwitch = new StartCenterDropCubeRightSwitch();
		startLeftDropCubeLeftSwitch = new StartLeftDropCubeLeftSwitch();
		startRightDropCubeRightSwitch = new StartRightDropCubeRightSwitch();
		startChooser = new SendableChooser<>();
		startChooser.addDefault("Center", "Center");
		startChooser.addObject("Left", "Left");
		startChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Location", startChooser);
	}
	public void getLightConfiguration(){
		try {
			String gameData;
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if("L".equals((String.valueOf(gameData.charAt(0))))) {
				//DriverStation.reportWarning("L alliance switch", false);
				switchSide = SwitchSide.LEFT;
			} else {
				//DriverStation.reportWarning("R alliance switch", false);
				switchSide = SwitchSide.RIGHT;
			}
			if("L".equals((String.valueOf(gameData.charAt(1))))) {
				//DriverStation.reportWarning("L scale", false);
				scaleSide = ScaleSide.LEFT;
			} else {
				//DriverStation.reportWarning("R scale", false);
				scaleSide = ScaleSide.RIGHT;
			}
			SmartDashboard.putString("Switch/ Scale configuration", "Switch: " + switchSide.name() + " Scale: " + scaleSide.name());
			RobotMap.FMSSideData = gameData;
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
					//firstPriority.addObject("Close Scale", "Close Scale");
					//firstPriority.addObject("Far Switch", "Far Switch");
					//firstPriority.addObject("Far Scale", "Far Scale");
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
					//firstPriority.addObject("Close Scale", "Close Scale");
					//firstPriority.addObject("Far Switch", "Far Switch");
					//firstPriority.addObject("Far Scale", "Far Scale");
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
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Right Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
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
				} else {
					SmartDashboard.putString("Selected Auto", "Error, please select good auto");
					SmartDashboard.putBoolean("Ready for auto", false);
				}
			} else if("Right".equals(startChooser.getSelected())){
				if("Cross Line".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Crossing Line");
					SmartDashboard.putBoolean("Ready for auto", true);
				} else if("Close Switch".equals(firstPriority.getSelected())){
					SmartDashboard.putString("Selected Auto", "Right to Right auton");
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
				if(switchSide.equals(SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
					return startCenterDropCubeLeftSwitch;
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
					return startCenterDropCubeRightSwitch;
				}
			} else if("Left Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Center to Left auton");
					return startCenterDropCubeLeftSwitch;
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				}
			} else if("Right Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Center to Right auton");
					return startCenterDropCubeRightSwitch;
				}
			}
		} else if("Left".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Left to Left auton");
					return startLeftDropCubeLeftSwitch;
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;

				}
			}
		} else if("Right".equals(startChooser.getSelected())){
			if("Cross Line".equals(firstPriority.getSelected())){
				SmartDashboard.putString("Selected Auto", "Crossing Line");
				return crossLineMotionProfiled;
			} else if("Close Switch".equals(firstPriority.getSelected())){
				if(switchSide.equals(SwitchSide.LEFT)){
					SmartDashboard.putString("Selected Auto", "Doing Nothing");
					return doNothingAuto;
				} else if(switchSide.equals(SwitchSide.RIGHT)){
					SmartDashboard.putString("Selected Auto", "Right to Right auton");
					return startRightDropCubeRightSwitch;
				}
			}
		}
		return null;
	}
}