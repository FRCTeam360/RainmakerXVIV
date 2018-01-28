package org.usfirst.frc.team360.robot.pathfollower;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
////Generic Motion Profile Class
//public class SrxMotionProfile {
//
//	public int numPoints;
//	// Position (rotations) Velocity (RPM) Duration (ms)
//	public double[][] points;
//
//	public SrxMotionProfile() {
//
//	}
//
//
//	public SrxMotionProfile(int numPoints, double[][] points) {
//		this.numPoints = numPoints;
//		this.points = points;
//	}
//
//	public SrxMotionProfile(JSONObject srxJson){
//		numPoints = ((Long) srxJson.get("numPoints")).intValue();
//		JSONArray jsonPoints = (JSONArray) srxJson.get("points");
//
//		points = new double[jsonPoints.size()][3];
//		if (points != null) {
//			int len = jsonPoints.size();
//			for (int i = 0; i < len; i++) {
//				JSONObject singlePoint = (JSONObject) jsonPoints.get(i);
//				points[i][0] = (double) singlePoint.get("pos");
//				points[i][1] = (double) singlePoint.get("vel");
//				points[i][2] = (double) singlePoint.get("dt");
//			}
//		}
//	}
//}
