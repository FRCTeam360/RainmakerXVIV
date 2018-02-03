package com.team319;

/**
 * Forked from 254's 2014 Trajectory library just a comment to make a change
 * 
 * @author Jared341
 * @author ttremblay
 */
// FROM FRC319 and FRC254
// ALL GENERATION CODE IS FROM CODE DEVELOPED BY THESE TEAMS
// ALL PATHS ARE WRITTEN BY 360
public class Main {

	public static void main(String[] args) {
		PathGeneration generater = new PathGeneration();
		
		// CANNOT do turns over 90 degrees
		
		generater.generateAll();
		
		
	//	BobPathGenerator.exportPath("Paths", FiveFootTurn90reversed);
		//BobPathGenerator.appendAndExportPaths("Paths", "thereAndBack", false, FiveFootTurn90, FiveFootTurn90reversed);
		//BobPathGenerator.exportPath("Paths", FiveFootTurn90);	
		//BobPathGenerator.appendAndExportPaths("Paths", "appendedPath", false, blueHopperThenShootAutoLeftSidePt2, toAppend);
		//BobPathGenerator.appendAndExportPaths("Paths", "appendedAndFlippedPath", true, blueHopperThenShootAutoLeftSidePt2, toAppend); 
		//redGear.exportPathWithSerializer(new VelocityOnlyFileSerializer(), "Paths");
	}
}
