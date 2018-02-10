package org.usfirst.frc.team360.robot.subsystems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;

public class Logger extends Subsystem {
    
    private FileWriter fw;
    private BufferedWriter bw;
    private File Log;
	
    private double matchTime;
	
	//Current Variables
    private double driveBaseLVelocity;
    private double driveBaseRVelocity;
	
	//Old Variables
    private double driveBaseLVelocityOLD;
    private double driveBaseRVelocityOLD;
    private boolean driverStationIsAttachedOld = true;
	
	public void initLogger(){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date(); 
			String name = dateFormat.format(date) + "_" + RobotMap.robotMode + ".txt";
    		Log = new File("home/lvuser/" + name);
			if (!Log.exists()) {
				Log.createNewFile();
			}
			fw = new FileWriter(Log.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.flush();
		} catch (Exception e) {
			e.toString();
		}
	}

	public void logRobotState(){
		try{
			bw.write("Robot Mode: " + RobotMap.robotMode + '\n');
		} catch (Exception e) {
			
		}
	}
	
	public void logNavX() {
		try {
			bw.write("NavX Information: ");
			bw.write('\t' + "Jerk X and Y: " + RobotMap.currentJerkX + " " + RobotMap.currentJerkY + '\n');
		} catch (Exception e) {
			
		}
	}
	
	public void logCollisionDetection() {
		try {
			bw.write("Command Run: Collision Detection" + '\n');
		}  catch (Exception e) {
			
		}
	}
	
	public void logShiftDown(){
		try{
			bw.write("Command Run: Shift Down" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logShiftUp(){
		try{
			bw.write("Command Run: Shift Up" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logIntakeOut(){
		try{
			bw.write("Command Run: Intake Out" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logIntakeIn(){
		try{
			bw.write("Command Run: Intake In" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logClimbUp(){
		try{
			bw.write("Command Run: Climb Up" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logClimbDown(){
		try{
			bw.write("Command Run: Climb Down" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logElevatorUp(){
		try{
			bw.write("Command Run: Elevator Up" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logElevatorDown(){
		try{
			bw.write("Command Run: Elevator Down" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logPressurize(){
		try{
			bw.write("Command Run: Pressurizing" + '\n');
		}catch (Exception e){
			
		}
	}
	
	public void logFollowTrajectory() {
		try {
			bw.write("Command Run: Follow Trajectory" + '\n');
		}catch (Exception e) {
			
		}
	}
	
	public void logDriveTrainVelocity() {
		
		driveBaseLVelocity = Robot.driveTrain.getLeftVelocity();
		driveBaseRVelocity = Robot.driveTrain.getRightVelocity();
		
		if(driveBaseLVelocityOLD != driveBaseLVelocity && driveBaseRVelocityOLD != driveBaseRVelocity) {
			try {
				bw.write("Drivebase Velocity: L: " + driveBaseLVelocity + " R: " + driveBaseRVelocity + '\n');
			} catch (Exception e){
			}
		}
		
		driveBaseLVelocityOLD = driveBaseLVelocity;
		driveBaseRVelocityOLD = driveBaseRVelocity;
		
	}
	
	public void logFMSSideData() {
		try {
			bw.write("FMS Side Data: " + RobotMap.FMSSideData +  '\n');
		} catch (Exception e) {
			
		}
	}
	
	public void logBadShiftValue() {
		try {
			bw.write("ENMU VALUE FOR SHIFTER INVALED" + '\n');
		} catch (Exception e) {
			
		}
	}
	
	public void logDriverStationConnection() {
		if(!RobotMap.driverStationIsAttached == driverStationIsAttachedOld) {
			try {
				bw.write("Driver Station Connection Status: " + RobotMap.driverStationIsAttached + '\n');
			} catch (Exception e) {
				
			}
			driverStationIsAttachedOld = RobotMap.driverStationIsAttached;
		}
	}
	
	public void logTipping() {
		try {
			bw.write("Robot Tipping, Pitch: " + RobotMap.Pitch + '\n');
		} catch (Exception e) {
			
		}
	}
	
	public void closeLogger() {
		try {
			bw.close();
		} catch (Exception e) {
			
		}
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
}

