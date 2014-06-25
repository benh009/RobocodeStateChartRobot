/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hofbauer.robocode.simulateur;

import static com.hofbauer.robocode.simulateur.RobotSimBasic.robotModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.util.Set;
import org.apache.commons.scxml.model.State;
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
            robotModel = new RobotStateMachine(this);
        }
        

        while (true) {

            setAhead(100);

            execute();

        }
    }

}
