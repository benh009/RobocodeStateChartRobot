package com.hofbauer.robocode.simulateur.proxy;

import robocode.AdvancedRobot;

public class GameInfoProxy {
	private AdvancedRobot robot;
	
	public GameInfoProxy(AdvancedRobot robot)
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
