
package org.usfirst.frc.team360.robot;

public class Constants {
	
	public static int comp_kF = 1;
	public static int comp_kP = 1;
	public static int comp_kI = 1;
	public static int comp_kD = 1;
	
	public static int prac_kF = 0;
	public static int prac_kP = 0;
	public static int prac_kI = 0;
	public static int prac_kD = 0;


	public static int real_F;
	public static int real_P;
	public static int real_I;
	public static int real_D;
	public void writeCompBotVariables() {
		Constants.real_F = Constants.comp_kF;
		Constants.real_P = Constants.comp_kP;
		Constants.real_I = Constants.comp_kI;
		Constants.real_D = Constants.comp_kD;
	}
	public void writePracticeBotVariables() {
		Constants.real_F = Constants.prac_kF;
		Constants.real_P = Constants.prac_kP;
		Constants.real_I = Constants.prac_kI;
		Constants.real_D = Constants.prac_kD;
	}
}