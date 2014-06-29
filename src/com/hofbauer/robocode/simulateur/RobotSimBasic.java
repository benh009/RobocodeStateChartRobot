package com.hofbauer.robocode.simulateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Set;


import robocode.AdvancedRobot;
import robocode.BattleEndedEvent;
import robocode.CustomEvent;


public class RobotSimBasic extends AdvancedRobot {



    public void run() {

     
            execute();

        
    }



    public void onCustomEvent(CustomEvent event) {
        if (event.getCondition().getName().equals("lowEnergy")) {

        }
    }



    public void onPaint(Graphics2D g) {
        g.setColor(Color.red);
        g.setFont(new Font("Arial Bold", Font.ITALIC, 20));
        g.drawString("mot à écrire", (int) getX(), (int) getY());
    }

}
