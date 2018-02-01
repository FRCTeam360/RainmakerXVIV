package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftUp extends Command {

    public ShiftUp() {
    	requires(Robot.shifter);
    }

    protected void initialize() {
<<<<<<< HEAD
    	Robot.shifter.open();
    	Robot.logger.logShiftUp();
=======
    	Robot.shifter.shiftUp();
>>>>>>> dev
    }

    protected void execute() {
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}