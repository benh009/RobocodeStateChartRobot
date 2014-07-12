package com.hofbauer.robocode.simulateur.action;

import robocode.AdvancedRobot;

public class RobotInfoProxy {
	private double precisionheading=0.1;
	private AdvancedRobot robot;
	public RobotInfoProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	public double X()
	{
		return this.robot.getX();
	}
	public double Y()
	{
		return this.robot.getY();
	}
	public double Energy()
	{
		return this.robot.getEnergy();
	}
	public double Heading()
	{
		return this.robot.getHeading();
	}
	public boolean Heading(double deg)
	{
		return (Math.abs((this.robot.getHeading()+0.00001)%360-deg)<precisionheading);
	}
	
	public double Height()
	{
		return this.robot.getHeight();
	}
	public double Width()
	{
		return this.robot.getWidth();
	}
	
	

}
