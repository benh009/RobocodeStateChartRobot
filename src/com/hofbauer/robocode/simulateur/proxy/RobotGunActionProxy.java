package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;
import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;
import static robocode.util.Utils.*;
import robocode.AdvancedRobot;
import robocode.Robot;

public class RobotGunActionProxy {
	private RobotSimWithAction robot;
	public RobotGunActionProxy(RobotSimWithAction robot)
	{
		this.robot=(RobotSimWithAction) robot;
	}
	public void turnGunLeft(double degrees)
	{
		this.robot.setTurnGunLeft(degrees);
	}
	public void turnGunRight(double degrees)
	{
		this.robot.setTurnGunRight(degrees);
	}
	public void smartFire(double robotDistance) {
		if (robotDistance > 200 || robot.getEnergy() < 15) {
			fire(1.);
		} else if (robotDistance > 50) {
			fire(2.);
		} else {
			fire(3.);
		}
	}
	public void fire(Double power)
	{
		if(robot.getEnergy()>power){
			robot.fire(power);
		}
	}
	public void smartFireRam(double robotEnergy)
	{
		if (robotEnergy> 16) {
			fire(3.0);
		} else if (robotEnergy > 10) {
			fire(2.0);
		} else if (robotEnergy > 4) {
			fire(1.0);
		} else if (robotEnergy > 2) {
			fire(.5);
		} else if (robotEnergy > .4) {
			fire(.1);
		}	
	}
	
	public void smartFireGunPosition(Double bearing)
	{

		double absoluteBearing = robot.getHeading() + bearing;
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - robot.getGunHeading());
		robot.setTurnGunRight(bearingFromGun);
		
	}
	public void scan()
	{
		robot.scan=true;
	}
	public void directionGun(double directionVoulue) {
		directionVoulue= directionVoulue%360;
		if(directionVoulue<0)
		{
			directionVoulue=360+directionVoulue;
		}
		robot.setTurnGunRight(ActionTools.directionG(robot.getGunHeading(),directionVoulue));
	}
	public void directionGun(double directionVoulue,double palier) {
		directionVoulue= directionVoulue%360;
		if(directionVoulue<0)
		{
			directionVoulue=360+directionVoulue;
		}
		robot.setTurnGunRight(ActionTools.direction(robot.getGunHeading(),directionVoulue, palier));
		
	}

}
