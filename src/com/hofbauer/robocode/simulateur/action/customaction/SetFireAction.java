package com.hofbauer.robocode.simulateur.action.customaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

import com.hofbauer.robocode.simulateur.action.Payload;

public class SetFireAction extends Action {
	
    private String power;
    private Double powerd;

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public String getPower() {
        return power;
    }
    
    public double getPowerDouble() {
        return powerd;
    }

    public void setPower(String power) {
    	System.out.println("powe setr : "+ power);
        this.power = power ;
    }

	@Override
	public void execute(EventDispatcher arg0, ErrorReporter arg1,
			SCInstance scInstance , Log  appLog, Collection arg4) throws ModelException,
			SCXMLExpressionException {
		// TODO Auto-generated method stub
		
		
	     Context ctx = scInstance.getContext(getParentTransitionTarget());
	        Evaluator eval = scInstance.getEvaluator();
	        ctx.setLocal(getNamespacesKey(), getNamespaces());
	        
	        powerd=(Double) eval.eval(ctx, power);
	        ctx.setLocal(getNamespacesKey(), null);
		
		
		
		/**Object payload=arg2.getRootContext().getVars().get("_eventdata");
		Method m;
		Object res;

			String actionClass = payload.getClass().toString();

				try {
					m = payload.getClass().getMethod("getDistance");
					Field f = payload.getClass().getField("distance");
					res = m.invoke(payload);
					System.out.println((Double)res);
					System.out.println(f.getDouble(payload));
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		**/

				

			
	}

}
