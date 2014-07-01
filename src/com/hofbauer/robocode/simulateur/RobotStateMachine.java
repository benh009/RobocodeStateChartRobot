package com.hofbauer.robocode.simulateur;


import com.hofbauer.robocode.simulateur.action.MyAbstractStateMachine2;
import org.apache.commons.scxml2.model.ModelException;




public class RobotStateMachine extends MyAbstractStateMachine2 {


    public RobotStateMachine(String path) throws ModelException {
    
    	
        super(RobotStateMachine.class.getClass().getResource(path));
        
  
        //print des logs
        //SimpleSCXMLListener sListerner = new SimpleSCXMLListener();
        //this.getEngine().addListener(this.getEngine().getStateMachine(), sListerner);

        
        //problème au niveau des threads a quitter 
        //myListerner = new RobotToGuiListener(null, 9999);
        //this.getEngine().addListener(this.getEngine().getStateMachine(), myListerner);
        //this.getEngine().addListener(this.getEngine().getStateMachine(), myListerner);

    }



}
