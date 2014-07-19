package com.hofbauer.robocode.simulateur;


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
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


	@Override
	public void execute(ActionExecutionContext exctx) throws ModelException,
			SCXMLExpressionException {
	
        EnterableState parentState = getParentEnterableState();
        Context ctx = exctx.getContext(parentState);
     
        Evaluator eval = exctx.getEvaluator();
        
	    ctx.setLocal(getNamespacesKey(), getNamespaces());

	         eval.eval(exctx.getGlobalContext(), expression);
	         ctx.setLocal(getNamespacesKey(), null);

		
	}

}
