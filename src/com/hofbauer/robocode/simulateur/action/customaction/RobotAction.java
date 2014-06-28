package com.hofbauer.robocode.simulateur.action.customaction;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

public class RobotAction extends Action {
	
    private String expression;
    public RobotAction() {
        super();
        
    }
    
    public String getExpression() {
        System.out.println("Y");

        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

	@Override
	public void execute(EventDispatcher evtDispatcher, ErrorReporter errRep,
			SCInstance scInstance, Log appLog, Collection derivedEvents)
			throws ModelException, SCXMLExpressionException {
	     Context ctx = scInstance.getContext(getParentTransitionTarget());
	        Evaluator eval = scInstance.getEvaluator();
	        ctx.setLocal(getNamespacesKey(), getNamespaces());
	        
	         eval.eval(ctx, expression);
	        ctx.setLocal(getNamespacesKey(), null);
		

	}

}
