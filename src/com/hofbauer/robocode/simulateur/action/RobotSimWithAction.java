/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.simulateur.action;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.scxml2.model.CustomAction;
import org.apache.commons.scxml2.model.ModelException;



import com.hofbauer.robocode.simulateur.ObjectTestNewSCXML;
import com.hofbauer.robocode.simulateur.RobotStateMachine;
import com.hofbauer.robocode.simulateur.action.customaction.RobotAction;
import com.hofbauer.robocode.simulateur.action.customaction.TestAction;

import robocode.AdvancedRobot;
import robocode.BattleEndedEvent;
import robocode.CustomEvent;
import robocode.DeathEvent;
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
	
	public RobotSimWithAction()
	{
		super();
		if (robotModel == null) {
			try {
				robotModel = new RobotStateMachine("/com/hofbauer/robocode/resources/simulation/scxml/walls.scxml");
			} catch (ModelException e) {
				System.out.println("Error init robotStateMachine");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {

		// initialise la stateMachine


robotModel.getEngine().getRootContext().getVars();
robotModel.getEngine().getRootContext().set("Ob", new ObjectTestNewSCXML(this) );

		robotModel.getEngine().getRootContext().set("Robot", this);
		//robotModel.getEngine().getRootContext().setLocal("Robot", this);
		robotModel.getEngine().getRootContext()
				.set("ActionTools", new ActionTools(this));
System.out.println("ici" +robotModel.getEngine().getRootContext().getVars());
		while (true) {
			// mettre a jour a chaque tour
			// position du robot

			robotModel.fireEvent("t");
			//robotModel.fireEvent("t");
			waitFor(new TurnCompleteCondition(this));

			// execute();

		}
	}

	public void onHitWall(HitWallEvent e) {
 
		robotModel.fireEvent("onHitWall", new Payload());
	}

	public void onScannedRobot(ScannedRobotEvent e) {

		System.out.println("onscanned");

		robotModel.fireEvent("onScannedRobot", e);

	}

	public void onHitRobot(HitRobotEvent event) {
		robotModel.fireEvent("onHitRobot");
	}

	public void onHitByBullet(HitByBulletEvent event) {
		robotModel.fireEvent("onHitByBullet");
	}

	public void onPaint(Graphics2D g) {
		g.setColor(Color.red);
		g.setFont(new Font("Arial Bold", Font.ITALIC, 20));
		g.drawString("mot à écrire", (int) getX(), (int) getY());
	}


}
