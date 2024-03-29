
package com.team319;

import com.team254.lib.trajectory.WaypointSequence;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.BobPathGenerator;
import com.team319.trajectory.SrxTranslatorConfig;

public class PathGeneration {

	public SrxTranslatorConfig highGearConfig = new SrxTranslatorConfig();
	public SrxTranslatorConfig lowGearConfig = new SrxTranslatorConfig();
	
	public PathGeneration(){
		//Standard configs between all trajectories
		highGearConfig.name = "highGearConfig";
		highGearConfig.dt = .01;
		//highGearConfig.max_acc = 5;
		highGearConfig.max_acc = 3.75;//2.5
		highGearConfig.max_jerk = 60.0;
		//highGearConfig.max_vel = 17;// max is 18
		highGearConfig.max_vel = 7.5;
		highGearConfig.wheelbase_width_feet = 26/12.0;
		highGearConfig.wheel_dia_inches = 6;
		highGearConfig.scale_factor = .3365;
		highGearConfig.encoder_ticks_per_rev = 4096;
		lowGearConfig.name = "lowGearConfig";
		lowGearConfig.dt = .01;
		lowGearConfig.max_acc = 2.5;
		lowGearConfig.max_jerk = 35.0;
		lowGearConfig.max_vel = 4.5;
		lowGearConfig.wheelbase_width_feet = 10/12.0;
		lowGearConfig.wheel_dia_inches = 6;
		lowGearConfig.scale_factor = .349;
		lowGearConfig.encoder_ticks_per_rev = 4096;
	}
	public void generateAll(){
//		generateCrossLine();
//		generateCenterToRightSwitch();
		generateCenterToLeftSwitch();
//		generateLeftToLeftSwitch();
//		generateRightToRightSwitch();
//		generateRightToRightScale();
//		generateRightToRightScalePart1();
//		generateRightToRightScalePart2();
//		generateRightToRightScalePart3();
//		generateRightToRightScalePart4();
//		generateRightToLeftScalePart1();
//		generateRightToLeftScalePart2();
//		generateLeftToRightScalePart1();
//		generateLeftToRightScalePart2();
//		generateLeftToRightScalePart3();
//		generateBackTwoFeet();
		generateCenterToLeftTwoCubePart1();
		generateCenterToLeftTwoCubePart2();
		generateCenterToLeftTwoCubePart3();
		generateCenterToLeftTwoCubePart4();
//		generateCenterToRightTwoCubePart1();
//		generateCenterToRightTwoCubePart2();
//		generateCenterToRightTwoCubePart3();
//		generateCenterToRightTwoCubePart4();
	}
	

	public void generateBackTwoFeet() {
		BobPath wantedPath = new BobPath(highGearConfig, "MoveTwoFeetBack", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateCrossLine(){
		BobPath wantedPath = new BobPath(highGearConfig, "CrossLine", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(140/12, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateCenterToRightTwoCubePart1() {
		highGearConfig.max_acc = 3.25;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToRightTwoCubePart1", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, -5, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
	}
	
	public void generateCenterToRightTwoCubePart2() {
		highGearConfig.max_acc = 4;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToRightTwoCubePart2", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, 0/12, Math.toRadians(10)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	public void generateCenterToRightTwoCubePart3() {
		highGearConfig.max_acc = 4;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToRightTwoCubePart3", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	public void generateCenterToRightTwoCubePart4() {
		highGearConfig.max_acc = 5.5;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToRightTwoCubePart4", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5.5, -4, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	public void generateCenterToLeftTwoCubePart1() {
		highGearConfig.max_acc = 3.25;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToLeftTwoCubePart1", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(78/12, 50/12, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
	}
	
	public void generateCenterToLeftTwoCubePart2() {
		highGearConfig.max_acc = 4;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToLeftTwoCubePart2", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2.5, .25, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	public void generateCenterToLeftTwoCubePart3() {
		highGearConfig.max_acc = 4;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToLeftTwoCubePart3", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	public void generateCenterToLeftTwoCubePart4() {
		highGearConfig.max_acc = 5;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToLeftTwoCubePart4", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.25, 4, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0/12, 0/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
		
	}
	
	
	public void generateCenterToRightSwitch(){
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToRightSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 160.25/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(120.25/12, 120.25/12, Math.toRadians(15)));//	wantedPath.addWaypoint(new WaypointSequence.Waypoint(117.25/12, 115.25/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateCenterToLeftSwitch(){
		highGearConfig.max_acc = 3;
		BobPath wantedPath = new BobPath(highGearConfig, "CenterToLeftSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 160.25/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(121/12, 210/12, Math.toRadians(-10)));//wantedPath.addWaypoint(new WaypointSequence.Waypoint(125.25/12, 210/12, Math.toRadians(-10)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_acc = 2.5;
	}
	
	public void generateLeftToLeftSwitch(){
		BobPath wantedPath = new BobPath(highGearConfig, "LeftToLeftSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 280.5/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(132/12, 284.25/12, Math.toRadians(-22.01)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(148/12, 243/12, Math.toRadians(-91)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateRightToRightSwitch(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 43.75/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(132/12, 38/12, Math.toRadians(22.01)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(151/12, 70.5/12, Math.toRadians(97)));//wantedPath.addWaypoint(new WaypointSequence.Waypoint(153/12, 71.5/12, Math.toRadians(112)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateLeftToLeftScale(){
		highGearConfig.max_vel = 7;
		BobPath wantedPath = new BobPath(highGearConfig, "LeftToLeftScale", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(16.75/12, 50/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(134/12, 50/12, 0));//wantedPath.addWaypoint(new WaypointSequence.Waypoint(133.125/12, 293/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(279/12, 0/12, Math.toRadians(0)));//wantedPath.addWaypoint(new WaypointSequence.Waypoint(260/12, 215/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
		highGearConfig.max_vel = 7.5;
	}
	
	public void generateRightToRightScale(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightScale", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(16/12, 46/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(210/12, 46/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(291/12, 48/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateRightToRightScalePart1(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightScalePart1", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1.5, 2, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1.5, 3, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateRightToRightScalePart2(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightScalePart2", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2, 2, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2, 3.5, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateRightToRightScalePart3(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightScalePart3", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1.5, -2, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1.5, -4, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateRightToRightScalePart4(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToRightScalePart4", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, -3, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateRightToLeftScalePart1(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToLeftScalePart1", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(14, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(18, 3, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(18, 12, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateRightToLeftScalePart2(){
		BobPath wantedPath = new BobPath(highGearConfig, "RightToLeftScalePart2", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, -3, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateLeftToRightScalePart1(){
		BobPath wantedPath = new BobPath(highGearConfig, "LeftToRightScalePart1", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(12, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(15, -3, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(15, -15, Math.toRadians(90)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateLeftToRightScalePart2(){
		BobPath wantedPath = new BobPath(highGearConfig, "LeftToRightScalePart2", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1, 0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3, 4.25, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateLeftToRightScalePart3(){
		BobPath wantedPath = new BobPath(highGearConfig, "LeftToRightScalePart3", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(1, -1, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	public void generateDriveStraight5Feet(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight5Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight10Feet(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight10Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight20Feet(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight20Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(20, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetWith90DegreeTurn(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight5FeetWith90DegreeTurn", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 5, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generate90DegreeTurn(){
		BobPath wantedPath = new BobPath(highGearConfig, "90DegreeTurn", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2, 2, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2.01, 2.01, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight200Feet(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight200Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(200, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetTurn5Feet(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight5Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10, 10, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.001, 10.001, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.002, 10.002, Math.toRadians(179.98)));

		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetReversed(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight5FeetReversed", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight2AndHalfFeetWith90DegreeTurn(){
		BobPath wantedPath = new BobPath(highGearConfig, "DriveStraight2AndHalfFeetWith90DegreeTurn", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2.5, 2.5, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateAroundTheBasketBallKey(){
		BobPath wantedPath = new BobPath(highGearConfig, "AroundBasketballKey", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5.0, 0.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.0, 5.0, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(4.0, 10.0, Math.toRadians(179.98)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0.0, 10.0, Math.toRadians(180)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generate3FtSquare(){
		BobPath wantedPath = new BobPath(highGearConfig, "3FootSquare", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 6.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(9.0, 9.0, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 12.0, Math.toRadians(179.98)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3.0, 9.0, Math.toRadians(269.97)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 6.0, Math.toRadians(359.96)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
}