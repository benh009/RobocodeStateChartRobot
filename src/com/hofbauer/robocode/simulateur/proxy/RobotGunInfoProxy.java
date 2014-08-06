package com.hofbauer.robocode.simulateur.proxy;

import robocode.AdvancedRobot;

public class RobotGunInfoProxy {

	private double precisionheading=0.1;
	private AdvancedRobot robot;
	public RobotGunInfoProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	public double heading()
	{
		return this.robot.getGunHeading();
	}
	public boolean heading(double deg)
	{
		return (Math.abs(this.robot.getGunHeading()-deg)<precisionheading);
	}
}
