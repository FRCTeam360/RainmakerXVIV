package com.team319;

import com.team254.lib.trajectory.WaypointSequence;

public class StartingPoints {
	
	public static WaypointSequence.Waypoint startLeft = 
			new WaypointSequence.Waypoint(0, 26, 0);

	public static WaypointSequence.Waypoint correctedStartLeft = 
			new WaypointSequence.Waypoint(startLeft.x + 36.5/2/12, startLeft.y - 30.5/2/12, startLeft.theta);
	
	public static WaypointSequence.Waypoint startCenter = 
			new WaypointSequence.Waypoint(0, 12, 0);
	
	public static WaypointSequence.Waypoint correctedStartCenter = 
			new WaypointSequence.Waypoint(startCenter.x + 36.5/2/12, startCenter.y, startCenter.theta);
	
	public static WaypointSequence.Waypoint startRight = 
			new WaypointSequence.Waypoint(0, 1, 0);
	
	public static WaypointSequence.Waypoint correctedStartRight = 
			new WaypointSequence.Waypoint(startRight.x + 36.5/2/12, startRight.y + 30.5/2/12, startRight.theta);
	
}
