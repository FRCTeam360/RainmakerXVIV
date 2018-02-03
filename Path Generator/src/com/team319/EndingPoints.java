package com.team319;

import com.team254.lib.trajectory.WaypointSequence;

public class EndingPoints {
	
	public static WaypointSequence.Waypoint leftSideSwitchBackFace = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
	public static WaypointSequence.Waypoint leftSideSwitchOuterFace = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
	public static WaypointSequence.Waypoint leftSideSwitchFrontFace = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
	public static WaypointSequence.Waypoint rightSideSwitchBackFace = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
	public static WaypointSequence.Waypoint rightSideSwitchOuterFace = 
			new WaypointSequence.Waypoint(12.8, 6.1041, Math.toRadians(89.99));
	
	public static WaypointSequence.Waypoint correctedRightSideSwitchOuterFace = 
			new WaypointSequence.Waypoint(rightSideSwitchOuterFace.x, 
					rightSideSwitchOuterFace.y - 30.5/2/12, rightSideSwitchOuterFace.theta);
	
	public static WaypointSequence.Waypoint rightSideSwitchFrontFace = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
}
