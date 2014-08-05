package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;

import robocode.AdvancedRobot;

public class RobotGunActionProxy {
	private RobotSimWithAction robot;
	public RobotGunActionProxy(AdvancedRobot robot)
	{
		this.robot=(RobotSimWithAction) robot;
	}
	public void TurnGunLeft(double degrees)
	{
		this.robot.setTurnGunLeft(degrees);
	}
	public void TurnGunRight(double degrees)
	{
		this.robot.setTurnGunRight(degrees);
	}
	public void smartFire(double robotDistance) {
		System.out.println("tire avec distance : "+robotDistance);
		if (robotDistance > 200 || robot.getEnergy() < 15) {
			robot.fire(1);
		} else if (robotDistance > 50) {
			robot.fire(2);
		} else {
			robot.fire(3);
		}
	}
	public void fire(Double power)
	{
		robot.fire(power);
	}
	public void smartFireRam(double robotEnergy)
	{
		if (robotEnergy> 16) {
			robot.fire(3);
		} else if (robotEnergy > 10) {
			robot.fire(2);
		} else if (robotEnergy > 4) {
			robot.fire(1);
		} else if (robotEnergy > 2) {
			robot.fire(.5);
		} else if (robotEnergy > .4) {
			robot.fire(.1);
		}	
	}
	public void scan()
	{
		robot.scan=true;
	}

}
