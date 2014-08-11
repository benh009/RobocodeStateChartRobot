package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;

import robocode.AdvancedRobot;
import robocode.TeamRobot;

public class RobotGunInfoProxy {

	private double precisionheading=0.1;
	private RobotSimWithAction robot;
	public RobotGunInfoProxy(RobotSimWithAction robot)
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
