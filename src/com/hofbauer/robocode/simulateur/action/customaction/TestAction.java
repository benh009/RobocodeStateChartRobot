package com.hofbauer.robocode.simulateur.action.customaction;


import org.apache.commons.scxml2.ActionExecutionContext;
import org.apache.commons.scxml2.SCXMLExpressionException;
import org.apache.commons.scxml2.model.Action;
import org.apache.commons.scxml2.model.ModelException;



public class TestAction extends Action{
	
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





	@Override
	public void execute(ActionExecutionContext arg0) throws ModelException,
			SCXMLExpressionException {
		// TODO Auto-generated method stub
		
	}

}
