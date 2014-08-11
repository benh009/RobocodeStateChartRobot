package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;

import robocode.AdvancedRobot;

public class GameInfoProxy {
	private RobotSimWithAction  robot;
	
	public GameInfoProxy(RobotSimWithAction robot)
	{
		this.robot=robot;
	}
	public double battleFieldHeight()
	{
		return this.robot.getBattleFieldHeight();
	}
	public double battleFieldWidth()
	{
		return this.robot.getBattleFieldWidth();
	}

}
