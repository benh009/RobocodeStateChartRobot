package com.hofbauer.robocode.simulateur;


import java.io.File;
import java.net.URL;

import org.apache.commons.scxml2.model.ModelException;




public class RobotStateMachine extends MyAbstractStateMachine {




	public RobotStateMachine(URL url) throws ModelException {
    
    	
        super(url);
        
 
        //print des logs
        //SimpleSCXMLListener sListerner = new SimpleSCXMLListener();
        //this.getEngine().addListener(this.getEngine().getStateMachine(), sListerner);

        
        //problème au niveau des threads a quitter 
        //RobotToGuiListener myListerner = new RobotToGuiListener(null, 9999);
        //this.getEngine().addListener(this.getEngine().getStateMachine(), myListerner);

    }



}
