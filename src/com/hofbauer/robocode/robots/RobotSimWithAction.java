/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.robots;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml2.model.ModelException;



import com.hofbauer.robocode.simulateur.RobotStateMachine;

import com.hofbauer.robocode.simulateur.Listener.RobotToGuiListener;
import com.hofbauer.robocode.simulateur.proxy.GameInfoProxy;
import com.hofbauer.robocode.simulateur.proxy.Message;
import com.hofbauer.robocode.simulateur.proxy.RobotActionProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotGunActionProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotGunInfoProxy;
import com.hofbauer.robocode.simulateur.proxy.RobotInfoProxy;
import robocode.BattleEndedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.MessageEvent;
import robocode.RoundEndedEvent;
import robocode.TeamRobot;
import robocode.WinEvent;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * classe abstraire utilisée par RobotModele1 et RobotModele2
 * Cette technique permet d'initaliser dans une meme partie des robots avec des
 * modèle xml différent
 * @author hofbauer
 */
public abstract class RobotSimWithAction extends TeamRobot {
	

	public  RobotStateMachine robotModel;
	public  boolean bolscxmlgui = false;
	public Boolean scan = false;
	public RobotToGuiListener robotToGuiListener;
	public Boolean endRound;
	

	public RobotSimWithAction(int idrobot) {
		super();
		endRound = false;
		 
		if (robotModel == null) {
			try {
				LogFactory.releaseAll();
				String pathRobot = "";

				BufferedReader in = new BufferedReader(new FileReader(
						getClass().getResource("/settings/settings.txt")
								.getFile()));

				
				String stringscxmlgui="";
				if(idrobot==1)
				{
					in.readLine();
					pathRobot = in.readLine();
					in.readLine();in.readLine();
				}
				else if(idrobot==2)
				{
					in.readLine();in.readLine();in.readLine(); //passe robot1
					pathRobot = in.readLine();

				}
				
				in.readLine();
				stringscxmlgui=in.readLine();
				
				System.out.println(stringscxmlgui);
				System.out.println(pathRobot);

				bolscxmlgui = stringscxmlgui.equals("true");

				robotModel = new RobotStateMachine(getClass().getResource(pathRobot));
				
				

				in.close();
			} catch (ModelException | IOException e) {
				System.out.println("Error init robotStateMachine");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(bolscxmlgui);
		try {
			robotModel.getEngine().reset();
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (bolscxmlgui) {

			robotToGuiListener = new RobotToGuiListener(null, 9999);
			robotModel.getEngine().addListener(
					robotModel.getEngine().getStateMachine(),
					robotToGuiListener);
		}

	}
	@Override
	public void run() {

		// initialise la stateMachine

		// robotModel.getEngine().getRootContext().set("Robot", this);
		// robotModel.getEngine().getRootContext().set("T", new
		// ActionTools(this));

		robotModel.getEngine().getRootContext()
				.set("RI", new RobotInfoProxy(this));
		robotModel.getEngine().getRootContext()
				.set("RA", new RobotActionProxy(this));

		robotModel.getEngine().getRootContext()
				.set("RGI", new RobotGunInfoProxy(this));
		robotModel.getEngine().getRootContext()
				.set("RGA", new RobotGunActionProxy(this));

		robotModel.getEngine().getRootContext()
				.set("GI", new GameInfoProxy(this));

		while (true) {
			// mettre a jour a chaque tour
			// position du robot
			System.out.println("run");
			if (!endRound) {
				robotModel.fireEvent("t");
			}
			waitFor(new TurnCompleteCondition(this));

			// execute();

		}
	}
	@Override
	public void onHitWall(HitWallEvent e) {
		
		if (!endRound) {
			robotModel.fireEvent("onHitWall", e);
		}
		
	}
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		if (!endRound) {
			robotModel.fireEvent("onScannedRobot", e);
			mscan();

		}
		

	}
	@Override
	public void onMousePressed(MouseEvent e) {
		if (!endRound) {
			robotModel.fireEvent("MouseEvent", e);
		}
		
	}
	@Override
	public void onKeyPressed(KeyEvent e) {
		if (robotModel != null) {
			robotModel.fireEvent("onKeyPressed", e);
		}
	}
	@Override
	public void onKeyReleased(KeyEvent e) {
		if (!endRound) {
			robotModel.fireEvent("onKeyReleased", e);
		}
	}
	@Override
	public void onHitRobot(HitRobotEvent e) {
		
		if (!endRound) {
			robotModel.fireEvent("onHitRobot", e);
			mscan();
		}
	}
	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		
		if (!endRound) {
			robotModel.fireEvent("onHitByBullet", e);
			mscan();
		}
		
	}
	 @Override
	 public void onMessageReceived(MessageEvent event)
	{
		 System.out.println("Receice");
			if (!endRound) {
				robotModel.fireEvent("onMessageReceived", new Message(event));
			}
	}

	public void onWin(WinEvent e) {
		if (!endRound) {
			robotModel.fireEvent("onWin", e);
			robotToGuiListener.runThread = false;
			//robotModel = null;
		}
		robotModel.setLog(null);

	}

	@Override
	public void onBattleEnded(BattleEndedEvent event) {
		if (!endRound) {
			robotToGuiListener.runThread = false;
			endRound=true;
		}
		robotModel.setLog(null);

	}

	@Override
	public void onRoundEnded(RoundEndedEvent event) {
		if (!endRound) {
			robotToGuiListener.runThread = false;
			
			endRound=true;
		}
		robotModel.setLog(null);
	}
	@Override
	public void onDeath(DeathEvent event) {
		if (!endRound) {
			robotToGuiListener.runThread = false;
			endRound=true;
			
		}
		robotModel.setLog(null);
	}
	@Override
	public void onPaint(Graphics2D g) {
		g.setColor(Color.red);
		g.drawOval((int) (getX() - 50), (int) (getY() - 50), 100, 100);
		g.setColor(new Color(0, 0xFF, 0, 30));
		g.fillOval((int) (getX() - 60), (int) (getY() - 60), 120, 120);
	}

	public void mscan() {
		if (scan) {
			scan = false;
			scan();

		}
	}

}
