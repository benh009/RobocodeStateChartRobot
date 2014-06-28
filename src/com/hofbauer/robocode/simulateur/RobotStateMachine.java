package com.hofbauer.robocode.simulateur;


import com.hofbauer.robocode.simulateur.action.customaction.TestAction;


import java.awt.List;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.env.SimpleSCXMLListener;
import org.apache.commons.scxml.model.CustomAction;
import org.apache.commons.scxml.model.Data;
import org.apache.commons.scxml.model.State;

import robocode.AdvancedRobot;
import robocode.Robot;

public class RobotStateMachine extends MyAbstractStateMachine {

    public String getCurrentState() {
        Set states = getEngine().getCurrentStatus().getStates();
        return ((org.apache.commons.scxml.model.State) states.iterator().
                next()).getId();
    }



    public RobotStateMachine() {

        super(RobotStateMachine.class.getClass().getResource("/com/hofbauer/robocode/resources/simulation/scxml/testTresSimple.scxml"));
         
        //RobotToGuiListener myListerner = new RobotToGuiListener(null, 9999);
        //this.getEngine().addListener(this.getEngine().getStateMachine(), myListerner);
    }
    public  AdvancedRobot r=null;
    RobotToGuiListener myListerner;
    public RobotStateMachine(AdvancedRobot r ) {
        super(RobotStateMachine.class.getClass().getResource("/com/hofbauer/robocode/resources/simulation/scxml/testTresSimple.scxml"));

    }

    public RobotStateMachine(AdvancedRobot robot,ArrayList<CustomAction> customActions ) {
    
        super(RobotStateMachine.class.getClass().getResource("/com/hofbauer/robocode/resources/simulation/scxml/testTresSimple.scxml"), customActions);
        
   
        //super(RobotStateMachine.class.getClass().getResource("/com/hofbauer/robocode/simulation/scxml/testTresSimple.scxml"));

        //a garder car sinon n'accepte pas le robot
        


        //SimpleSCXMLListener sListerner = new SimpleSCXMLListener();
        //testsimu.getEngine().addListener(testsimu.getEngine().getStateMachine(), sListerner);

        
        //problème au niveau des threads a quitter 
        //myListerner = new RobotToGuiListener(null, 9999);
        //this.getEngine().addListener(this.getEngine().getStateMachine(), myListerner);
    }

    static RobotStateMachine testsimu;

    public static void main(String[] args) {

        testsimu = new RobotStateMachine();

        //simple Listener
        SimpleSCXMLListener sListerner = new SimpleSCXMLListener();
        testsimu.getEngine().addListener(testsimu.getEngine().getStateMachine(), sListerner);

        //listener pour scxmlgui
        //RobotToGuiListener myListerner = new RobotToGuiListener(null, 9999);
        //testsimu.getEngine().addListener(testsimu.getEngine().getStateMachine(), myListerner);
        //testsimu.fireEvent("changeSens");
        System.out.println(testsimu.getCurrentState());
        testsimu.fireEvent("onHitWall");
        System.out.println(testsimu.getCurrentState());

    }

}
