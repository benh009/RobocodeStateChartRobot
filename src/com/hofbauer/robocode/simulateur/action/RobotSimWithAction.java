/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.simulateur.action;

import static com.hofbauer.robocode.simulateur.RobotSimBasic.robotModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.scxml.model.CustomAction;
import org.apache.commons.scxml.model.State;

import com.hofbauer.robocode.simulateur.RobotStateMachine;
import com.hofbauer.robocode.simulateur.action.customaction.SetAheadAction;
import com.hofbauer.robocode.simulateur.action.customaction.SetBackAction;
import com.hofbauer.robocode.simulateur.action.customaction.SetFireAction;
import com.hofbauer.robocode.simulateur.action.customaction.SetTurnLeftAction;
import com.hofbauer.robocode.simulateur.action.customaction.SetTurnRightAction;
import com.hofbauer.robocode.simulateur.action.customaction.TestAction;

import robocode.AdvancedRobot;
import robocode.BattleEndedEvent;
import robocode.CustomEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;


/**
 *
 * @author hofbauer
 */
public class RobotSimWithAction extends AdvancedRobot {

    public RobotStateMachine robotModel = null;

    public void run() {

    	//initialise la stateMachine
        if (robotModel == null) {
            robotModel = new RobotStateMachine(this,getActionArrayList());
        }
        //Initialise dans la stateMachine les informations relative au combat
        robotModel.getEngine().getRootContext()
        .set("BattleFieldWidth", this.getBattleFieldWidth());
robotModel.getEngine().getRootContext()
        .set("BattleFieldHeight", this.getBattleFieldHeight());
//taille du robot
robotModel.getEngine().getRootContext().set("Width", this.getWidth());
robotModel.getEngine().getRootContext().set("Height", this.getHeight());
      


        while (true) {
        	//mettre a jour a chaque tour
        	//position du robot
        	robotModel.getEngine().getRootContext().set("X", this.getX());
        	robotModel.getEngine().getRootContext().set("Y", this.getY());
        	robotModel.getEngine().getRootContext().set("Energy", this.getEnergy());
        	robotModel.fireEvent("");

            

            execute();

        }
    }
    
    public void onHitWall(HitWallEvent e) {
        robotModel.fireEvent("onHitWall");
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        robotModel.fireEvent("onScannedRobot");
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
    
    public  ArrayList<CustomAction> getActionArrayList() {
        

    	ArrayList<CustomAction> customActions = new ArrayList<CustomAction>();
       
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "testAction", TestAction.class));
        
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setAheadAction", SetAheadAction.class));
        
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setBackAction", SetBackAction.class));
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setTurnLeftAction", SetTurnLeftAction.class));
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setTurnRightAction", SetTurnRightAction.class));
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setFireAction", SetFireAction.class));
        
        return customActions;
    }

}
