package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;

import robocode.AdvancedRobot;
import robocode.TeamRobot;

public class RobotGunInfoProxy {

	private double precisionheading=0.5;
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
		deg= deg%360;
		if(deg<0)
		{
			deg=360+deg;
		}
		double heading= robot.getGunHeading();
		if(deg>360-precisionheading )
		{
			deg=0-precisionheading;
		}
		if(robot.getGunHeading()>359-precisionheading)
		{
			heading= 0-robot.getGunHeading();
		}
		
		return (Math.abs(heading-deg)<precisionheading);
		
	}
}
