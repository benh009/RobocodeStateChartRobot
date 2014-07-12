package com.hofbauer.robocode.simulateur.action;

import robocode.AdvancedRobot;

public class GameInfoProxy {
	private AdvancedRobot robot;
	
	public GameInfoProxy(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	public double BattleFieldHeight()
	{
		return this.robot.getBattleFieldHeight();
	}
	public double BattleFieldWidth()
	{
		return this.robot.getBattleFieldWidth();
	}

}
