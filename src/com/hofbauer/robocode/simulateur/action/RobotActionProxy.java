package com.hofbauer.robocode.simulateur.action;

import robocode.AdvancedRobot;

public class RobotActionProxy {
	private AdvancedRobot robot;
	public RobotActionProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	
	}
	public void Ahead(double distance)
	{
		robot.setAhead(distance);
	}
	public void Back(double distance)
	{
		robot.setBack(distance);
		
	}
	public void TurnLeft(double degrees)
	{
		robot.setTurnLeft(degrees);
	}
	public void TurnRight(double degrees)
	{
		robot.setTurnRight(degrees);
	}
	

}
