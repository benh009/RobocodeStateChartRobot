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

        if (robotModel == null) {
            robotModel = new RobotStateMachine(this,getActionArrayList());
        }
      


        while (true) {

            setAhead(100);

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
    
    public  ArrayList<CustomAction> getActionArrayList() {
        

    	ArrayList<CustomAction> customActions = new ArrayList<CustomAction>();
       
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "testAction", TestAction.class));
        
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setAheadAction", SetAheadAction.class));
        
        customActions.add(new CustomAction("http://my.custom-actions.domain/CUSTOM",
                "setBackAction", SetBackAction.class));
        
        return customActions;
    }

}
