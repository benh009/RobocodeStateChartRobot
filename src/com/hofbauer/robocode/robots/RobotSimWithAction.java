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
import com.hofbauer.robocode.simulateur.Listener.ActionListener;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * 
 * @author hofbauer
 */
public class RobotSimWithAction extends AdvancedRobot {
	public Boolean runTread;

	public RobotStateMachine robotModel = null;
	public  boolean bolscxmlgui = false;
	public Boolean scan=false;
	public RobotToGuiListener robotToGuiListener;
	public RobotSimWithAction() {
		super();
		
		
		runTread=true;
		if (robotModel == null) {
			try {
		    	 String path = "";

		        	 BufferedReader in
		      	      = new BufferedReader(new FileReader(getClass().getResource("/settings/settings").getFile()));
		        	 in.readLine();
		        	 path= in.readLine();

		        	 in.readLine();
		        	 String stringscxmlgui = in.readLine();
		        	 System.out.println(stringscxmlgui);
		        	 System.out.println(path);
		        	 
		        	 bolscxmlgui = stringscxmlgui.equals("true");
				
				robotModel = new RobotStateMachine(getClass().getResource(path));
				
				in.close();
			} catch (ModelException | IOException e) {
				System.out.println("Error init robotStateMachine");
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
		System.out.println(bolscxmlgui);
		
		if(bolscxmlgui)
		{
			
			robotToGuiListener=new RobotToGuiListener(null, 9999);
			robotModel.getEngine().addListener(robotModel.getEngine().getStateMachine(),robotToGuiListener );
		}

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
		robotToGuiListener.runThread=false;
		

	}
	@Override
	public void onBattleEnded(BattleEndedEvent event){
		robotModel.resetMachine();
		robotToGuiListener.runThread=false;
		
	}
	@Override
	public void onRoundEnded(RoundEndedEvent event)
	{

		robotToGuiListener.runThread=false;
		
	}
	public void onDeath(DeathEvent event)
	{
		robotToGuiListener.runThread=false;
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
