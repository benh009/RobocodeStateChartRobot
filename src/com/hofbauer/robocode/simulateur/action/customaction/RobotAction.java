package com.hofbauer.robocode.simulateur.action.customaction;


import org.apache.commons.scxml2.ActionExecutionContext;
import org.apache.commons.scxml2.Context;
import org.apache.commons.scxml2.Evaluator;
import org.apache.commons.scxml2.SCXMLExpressionException;
import org.apache.commons.scxml2.model.Action;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;


public class RobotAction extends Action {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
/**
	@Override
	public void execute(EventDispatcher evtDispatcher, ErrorReporter errRep,
			SCInstance scInstance, Log appLog, Collection derivedEvents)
			throws ModelException, SCXMLExpressionException {
	     Context ctx = scInstance.getContext(getParentTransitionTarget());
	        Evaluator eval = scInstance.getEvaluator();
	        ctx.setLocal(getNamespacesKey(), getNamespaces());
	        
	         eval.eval(ctx, expression);
	        ctx.setLocal(getNamespacesKey(), null);
		

	}**/

	@Override
	public void execute(ActionExecutionContext exctx) throws ModelException,
			SCXMLExpressionException {
	
        EnterableState parentState = getParentEnterableState();
        Context ctx = exctx.getContext(parentState);
     System.out.println("ctx"+ctx.getVars());
     System.out.println("ex "+exctx.getGlobalContext().getVars());
        Evaluator eval = exctx.getEvaluator();
	    ctx.setLocal(getNamespacesKey(), getNamespaces());
	        
	         eval.eval(ctx, expression);
	         ctx.setLocal(getNamespacesKey(), null);

		
	}

}
