/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hofbauer.robocode.simulateur.action.customaction;

import com.hofbauer.robocode.simulateur.RobotStateMachine;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

/**
 *
 * @author hofbauer
 */
public class SetAheadAction extends Action {

    private String distance;

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public String getDistance() {
        return distance;
    }
    
    public Double getDistanceDouble() {
        return Double.parseDouble(distance);
    }

    public void setDistance(String distance) {
        this.distance = distance ;
    }



    public SetAheadAction() {
        super();
    }

    @Override
    public void execute(EventDispatcher evtDispatcher, ErrorReporter errRep,
            SCInstance scInstance, Log appLog, Collection derivedEvents)
            throws ModelException, SCXMLExpressionException {

    }

}
    
