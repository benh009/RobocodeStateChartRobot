package com.hofbauer.robocode.simulateur.Action;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

import robocode.AdvancedRobot;


public class TestAction extends FilsAction{
	
    private String x;
    private String y;
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public String getX() {
        System.out.println("X");

        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        System.out.println("Y");

        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

 
    
    public TestAction() {
        super();
        
    }
    static AdvancedRobot robot;
    public static void addRobot(AdvancedRobot r)
    {
    robot=r;	
    }


    @Override
    public void execute(EventDispatcher evtDispatcher, ErrorReporter errRep,
            SCInstance scInstance, Log appLog, Collection derivedEvents)
            throws ModelException, SCXMLExpressionException {
    	
   
        System.out.println("Mon Action est executée");
        if(robot!=null)
        {
        	robot.back(100);
        }
        System.out.println(x);
        System.out.println(y);

    }

}
