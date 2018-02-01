package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftDown extends Command {

    public ShiftDown() {
    	requires(Robot.shifter);
    }

    protected void initialize() {
<<<<<<< HEAD
    	Robot.shifter.close();
    	Robot.logger.logShiftDown();
=======
    	Robot.shifter.shiftDown();
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