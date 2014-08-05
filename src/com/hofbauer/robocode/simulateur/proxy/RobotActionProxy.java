package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;

import robocode.AdvancedRobot;

public class RobotActionProxy {
	private AdvancedRobot robot;
	public RobotActionProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	
	}
	public void ahead(double distance)
	{
		robot.setAhead(distance);
	}
	public void back(double distance)
	{
		robot.setBack(distance);
		
	}
	public void turnLeft(double degrees)
	{
		robot.setTurnLeft(degrees);
	}
	public void turnRight(double degrees)
	{
		robot.setTurnRight(degrees);
	}
	public void direction(Double directionVoulue)
	{
		directionVoulue= directionVoulue%360;
		if(directionVoulue<0)
		{
			directionVoulue=360-directionVoulue;
		}
		robot.setTurnRight(ActionTools.directionG(robot.getHeading(),directionVoulue));

	}

	

}
