package com.hofbauer.robocode.simulateur.proxy;

import robocode.AdvancedRobot;

public class RobotGunActionProxy {
	private AdvancedRobot robot;
	public RobotGunActionProxy(AdvancedRobot robot)
	{
		this.robot=robot;
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

}
