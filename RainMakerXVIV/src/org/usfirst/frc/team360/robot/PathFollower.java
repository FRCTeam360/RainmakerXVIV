package org.usfirst.frc.team360.robot;

import java.util.Timer;
import java.util.TimerTask;

public class PathFollower {
	public PathFollower(){
		Timer increaserTimer = new Timer("MyTimer");
		increaserTimer.scheduleAtFixedRate(new ThreadTimer(), 0, 5);
	}
	class ThreadTimer extends TimerTask 
	{
	    @Override
	    public void run()
	    {
	

	    

	    }
	}
}

