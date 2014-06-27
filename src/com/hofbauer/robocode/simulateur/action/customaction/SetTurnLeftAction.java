package com.hofbauer.robocode.simulateur.action.customaction;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

public class SetTurnLeftAction extends Action {
    private String angle;

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public String getAngle() {
        return angle;
    }
    
    public Double getAngleDouble() {
        return Double.parseDouble(angle);
    }

    public void setAngle(String angle) {
        this.angle = angle ;
    }

	@Override
	public void execute(EventDispatcher evtDispatcher, ErrorReporter errRep,
			SCInstance scInstance, Log appLog, Collection derivedEvents)
			throws ModelException, SCXMLExpressionException {
		// TODO Auto-generated method stub

	}

}
