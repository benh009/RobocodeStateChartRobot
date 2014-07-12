/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.simulateur.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


import org.apache.commons.scxml2.model.ModelException;

import com.hofbauer.robocode.simulateur.RobotStateMachine;

import robocode.AdvancedRobot;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

/**
 * 
 * @author hofbauer
 */
public class RobotSimWithAction extends AdvancedRobot {

	public RobotStateMachine robotModel = null;

	public RobotSimWithAction() {
		super();
		if (robotModel == null) {
			try {
				robotModel = new RobotStateMachine(
						"/com/hofbauer/robocode/resources/simulation/scxml/corner.scxml");
			} catch (ModelException e) {
				System.out.println("Error init robotStateMachine");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {

		// initialise la stateMachine

		robotModel.getEngine().getRootContext().set("Robot", this);
		robotModel.getEngine().getRootContext()
				.set("ActionTools", new ActionTools(this));
		
		robotModel.getEngine().getRootContext().set("RobotInfo", new RobotInfoProxy(this));
		robotModel.getEngine().getRootContext().set("RobotAction", new RobotActionProxy(this));
		
		robotModel.getEngine().getRootContext().set("RobotGunInfo", new RobotGunInfoProxy(this));
		robotModel.getEngine().getRootContext().set("RobotGunAction", new RobotGunActionProxy(this));
		
		robotModel.getEngine().getRootContext().set("GameInfo", new GameInfoProxy(this));
		
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

	}

	public void onHitRobot(HitRobotEvent e) {
		robotModel.fireEvent("onHitRobot", e);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		robotModel.fireEvent("onHitByBullet", e);
	}

	public void onPaint(Graphics2D g) {
		g.setColor(Color.red);
		g.setFont(new Font("Arial Bold", Font.ITALIC, 20));
		g.drawString("mot à écrire", (int) getX(), (int) getY());
	}

}
