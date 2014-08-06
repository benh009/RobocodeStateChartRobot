package com.hofbauer.robocode.simulateur.proxy;

import robocode.AdvancedRobot;

public class RobotInfoProxy {
	private double precisionheading=0.1;
	private AdvancedRobot robot;
	public RobotInfoProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	public double x()
	{
		return this.robot.getX();
	}
	public double y()
	{
		return this.robot.getY();
	}
	public double energy()
	{
		return this.robot.getEnergy();
	}
	public double heading()
	{
		return this.robot.getHeading();
	}
	public boolean heading(Double deg)
	{
		return (Math.abs((this.robot.getHeading()+0.00001)%360-deg)<precisionheading);
	}
	
	public double height()
	{
		return this.robot.getHeight();
	}
	public double width()
	{
		return this.robot.getWidth();
	}
	
	public Position positionRobotScanned(Double distance,Double bearing)
	{
		Double direction =this.robot.getHeading()+bearing;
		Double x = this.robot.getX()+(distance*Math.cos(direction));
		Double y = this.robot.getY()+(distance*Math.sin(direction));
		return new Position(x,y);
	}
	public double distance(Double x1,Double x2, Double y1, Double y2)
	{
		
		return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
	}
	
	

}
