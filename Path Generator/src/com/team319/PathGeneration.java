package com.team319;

import com.team254.lib.trajectory.WaypointSequence;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.BobPathGenerator;
import com.team319.trajectory.SrxTranslatorConfig;

public class PathGeneration {

	SrxTranslatorConfig standardConfig = new SrxTranslatorConfig();
	
	public PathGeneration(){
		//Standard configs between all trajectories
		standardConfig.name = "StandardConfig";
		standardConfig.dt = .01;
		standardConfig.max_acc = 5;
		standardConfig.max_jerk = 35.0;
		standardConfig.max_vel = 3.5;
		standardConfig.wheelbase_width_feet = 26/12.0;
		standardConfig.wheel_dia_inches = 6;
		standardConfig.scale_factor = .352;
		standardConfig.encoder_ticks_per_rev = 4096;
	}
	
	public void generateAll(){
		generateCenterToRightSwitch();
		generateCenterToLeftSwitch();
		generateLeftToLeftSwitch();
		generateRightToRightSwitch();
	}
	
	public void generateCenterToRightSwitch(){
		BobPath wantedPath = new BobPath(standardConfig, "CenterToRightSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 160.25/12, 0));
		//wantedPath.addWaypoint(new WaypointSequence.Waypoint(10, 100.25, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(126.25/12, 100.25/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateCenterToLeftSwitch(){
		BobPath wantedPath = new BobPath(standardConfig, "CenterToLeftSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 160.25/12, 0));
		//wantedPath.addWaypoint(new WaypointSequence.Waypoint(10, 100.25, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(126.25/12, 223.75/12, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateLeftToLeftSwitch(){
		BobPath wantedPath = new BobPath(standardConfig, "LeftToLeftSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 280.55/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(140/12, 280.55/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(168/12, 252.5/12, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateRightToRightSwitch(){
		BobPath wantedPath = new BobPath(standardConfig, "RightToRightSwitch", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(13.75/12, 43.75/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(140/12, 43.75/12, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(168/12, 71.5/12, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5Feet(){
		BobPath wantedPath = new BobPath(standardConfig, "DriveStraight5Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetTurn5Feet(){
		BobPath wantedPath = new BobPath(standardConfig, "DriveStraight5Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10, 10, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.001, 10.001, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.002, 10.002, Math.toRadians(179.98)));

		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetReversed(){
		BobPath wantedPath = new BobPath(standardConfig, "DriveStraight5FeetReversed", -1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generate90DegreeTurn(){
		BobPath wantedPath = new BobPath(standardConfig, "90DegreeTurn", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2, 2, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(2.01, 2.01, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight200Feet(){
		BobPath wantedPath = new BobPath(standardConfig, "DriveStraight200Feet", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(200, 0, Math.toRadians(0)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateDriveStraight5FeetWith90DegreeTurn(){
		BobPath wantedPath = new BobPath(standardConfig, "DriveStraight5FeetWith90DegreeTurn", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5, 5, Math.toRadians(89.99)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generateAroundTheBasketBallKey(){
		BobPath wantedPath = new BobPath(standardConfig, "AroundBasketballKey", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(5.0, 0.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(10.0, 5.0, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(4.0, 10.0, Math.toRadians(179.98)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(0.0, 10.0, Math.toRadians(180)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
	public void generate3FtSquare(){
		BobPath wantedPath = new BobPath(standardConfig, "3FootSquare", 1);
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 6.0, Math.toRadians(0)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(9.0, 9.0, Math.toRadians(89.99)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 12.0, Math.toRadians(179.98)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(3.0, 9.0, Math.toRadians(269.97)));
		wantedPath.addWaypoint(new WaypointSequence.Waypoint(6.0, 6.0, Math.toRadians(359.96)));
		BobPathGenerator.exportPath("Paths", wantedPath);
	}
	
}
