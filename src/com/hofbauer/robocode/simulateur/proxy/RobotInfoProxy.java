package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;
import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;

import robocode.AdvancedRobot;
import robocode.TeamRobot;

public class RobotInfoProxy {
	private double precisionheading=0.5;
	private RobotSimWithAction robot;
	public RobotInfoProxy(RobotSimWithAction robot)
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
		deg= deg%360;
		if(deg<0)
		{
			deg=360+deg;
		}
		
		System.out.println(deg +"  "+robot.getHeading());
		double heading= robot.getHeading();
		//attention 359.9 est proche de 0
		if(deg>360-precisionheading )
		{
			deg=0-precisionheading;
		}
		if(robot.getHeading()>359-precisionheading)
		{
			heading= 0-robot.getHeading();
		}
		
		return (Math.abs(heading-deg)<precisionheading);
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
	
	//information pour l'équipe
	
	public boolean isTeammate(String name)
	{
		return robot.isTeammate(name);
	}
	
	public Boolean e(Double val1,Double val2) {
		float precision =1;
		return ActionTools.equalsPrec(val1,val2, precision);
	}
	

}
