/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.robots;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


import org.apache.commons.scxml2.model.ModelException;

import com.hofbauer.robocode.simulateur.RobotStateMachine;
import com.hofbauer.robocode.simulateur.Listener.RobotToGuiListener;
import com.hofbauer.robocode.simulateur.proxy.GameInfoProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotActionProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotGunActionProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotGunInfoProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotInfoProxy;
import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;

import robocode.AdvancedRobot;

import robocode.BattleEndedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
import robocode.RoundEndedEvent;
import robocode.WinEvent;

import java.awt.event.KeyEvent;

import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * 
 * @author hofbauer
 */
public class RobotSimWithAction extends AdvancedRobot {

	public RobotStateMachine robotModel = null;
	public Boolean scan=false;
	public RobotToGuiListener robotToGuiListener;
	public RobotSimWithAction() {
		super();
		if (robotModel == null) {
			try {
				robotModel = new RobotStateMachine("/com/hofbauer/robocode/resources/simulation/scxml/corner.scxml");
			} catch (ModelException e) {
				System.out.println("Error init robotStateMachine");
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
		
		robotToGuiListener=new RobotToGuiListener(null, 9999);
		robotModel.getEngine().addListener(robotModel.getEngine().getStateMachine(),robotToGuiListener );
		

	}

	public void run() {
		//robotModel.getEngine().addListener(robotModel.getEngine().getStateMachine(), new RobotToGuiListener(null, 9999));
		

		// initialise la stateMachine

		//robotModel.getEngine().getRootContext().set("Robot", this);
		//robotModel.getEngine().getRootContext().set("T", new ActionTools(this));
		
		robotModel.getEngine().getRootContext().set("RI", new RobotInfoProxy(this));
		robotModel.getEngine().getRootContext().set("RA", new RobotActionProxy(this));
		
		robotModel.getEngine().getRootContext().set("RGI", new RobotGunInfoProxy(this));
		robotModel.getEngine().getRootContext().set("RGA", new RobotGunActionProxy(this));
		
		robotModel.getEngine().getRootContext().set("GI", new GameInfoProxy(this));
		
		while (true) {
			// mettre a jour a chaque tour
			// position du robot

			robotModel.fireEvent("t");
			waitFor(new TurnCompleteCondition(this));

			// execute();

		}
	}

	public void onHitWall(HitWallEvent e) {
		robotModel.fireEvent("onHitWall", e);
		
	}

	public void onScannedRobot(ScannedRobotEvent e) {
	
		robotModel.fireEvent("onScannedRobot", e);
		mscan();
		
		


	}
	public void onMousePressed(MouseEvent e) {
		robotModel.fireEvent("MouseEvent", e);
		
	}
	
	public void onKeyPressed(KeyEvent e) {
		robotModel.fireEvent("onKeyPressed", e);
	}
	public void onKeyReleased(KeyEvent e) {
		robotModel.fireEvent("onKeyReleased", e);
	}


	public void onHitRobot(HitRobotEvent e) {
		robotModel.fireEvent("onHitRobot", e);
		mscan();
	}

	public void onHitByBullet(HitByBulletEvent e) {
		robotModel.fireEvent("onHitByBullet", e);
		mscan();
	}
	public void onWin(WinEvent e) 
	{
		robotModel.fireEvent("onWin", e);
		robotModel.resetMachine();
		robotToGuiListener.stop();
		

	}
	@Override
	public void onBattleEnded(BattleEndedEvent event){
		
	}
	@Override
	public void onRoundEnded(RoundEndedEvent event)
	{


		
	}
	public void onDeath(DeathEvent event)
	{
		robotToGuiListener.stop();
		
		robotModel.resetMachine();

	}
	 

	
	public void onPaint(Graphics2D g) {
		g.setColor(Color.red);
		g.drawOval((int) (getX() - 50), (int) (getY() - 50), 100, 100);
		g.setColor(new Color(0, 0xFF, 0, 30));
		g.fillOval((int) (getX() - 60), (int) (getY() - 60), 120, 120);
	}
	public void mscan()
	{
		if(scan)
		{
			scan=false;
			scan();

		}
	}
	
}
