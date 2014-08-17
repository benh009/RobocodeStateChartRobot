package com.hofbauer.robocode.simulateur.Listener;

import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;

/**
 * listener permettant de printer les états courant et les transitions
 * @author hofbauer
 *
 */
public class StateListener implements SCXMLListener {

	@Override
	public void onEntry(EnterableState arg0) {
		System.out.println("New state : ");
		System.out.println("\t Id  : "+arg0.getId());
		
	}

	@Override
	public void onExit(EnterableState arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTransition(TransitionTarget arg0, TransitionTarget arg1,
			Transition arg2, String arg3) {
		
		System.out.println("trans : ");
		System.out.println("\t event : "+arg2.getEvent());
		System.out.println("\t cond : "+arg2.getCond());
		


	}

}
