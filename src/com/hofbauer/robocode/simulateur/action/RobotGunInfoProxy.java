package com.hofbauer.robocode.simulateur.action;

import robocode.AdvancedRobot;

public class RobotGunInfoProxy {

	private double precisionheading=0.1;
	private AdvancedRobot robot;
	public RobotGunInfoProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	public double Heading()
	{
		return this.robot.getGunHeading();
	}
	public boolean Heading(double deg)
	{
		return (Math.abs(this.robot.getGunHeading()-deg)<precisionheading);
	}
}
