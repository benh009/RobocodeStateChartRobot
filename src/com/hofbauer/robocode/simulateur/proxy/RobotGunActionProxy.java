package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;
import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;

import robocode.AdvancedRobot;

public class RobotGunActionProxy {
	private RobotSimWithAction robot;
	public RobotGunActionProxy(AdvancedRobot robot)
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
	public void scan()
	{
		robot.scan=true;
	}
	public void directionGun(double directionVoulue) {

		robot.setTurnGunRight(ActionTools.directionG(robot.getGunHeading(),directionVoulue));
	}
	public void directionGun(double directionVoulue,double palier) {
		robot.setTurnGunRight(ActionTools.direction(robot.getGunHeading(),directionVoulue, palier));
		
	}

}
