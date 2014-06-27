package com.hofbauer.robocode.simulateur.action.customaction;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

public class SetFireAction extends Action {
	
    private String power;

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public String getPower() {
        return power;
    }
    
    public Double getPowerDouble() {
        return Double.parseDouble(power);
    }

    public void setPower(String power) {
        this.power = power ;
    }

	@Override
	public void execute(EventDispatcher arg0, ErrorReporter arg1,
			SCInstance arg2, Log arg3, Collection arg4) throws ModelException,
			SCXMLExpressionException {
		// TODO Auto-generated method stub

	}

}
