package com.hofbauer.robocode.simulateur.action;


import org.apache.commons.scxml.SCXMLListener;

import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

import robocode.AdvancedRobot;

public class ListenerAction implements SCXMLListener {
	
	private HandlerAction handlerAction;
	public ListenerAction(AdvancedRobot robot)
	{
		
		this.handlerAction=new HandlerAction(robot);
		
	}

	@Override
	public void onEntry(TransitionTarget state) {
		handlerAction.handlerAction(state.getOnEntry().getActions());
		

	}

	@Override
	public void onExit(TransitionTarget state) {
		handlerAction.handlerAction(state.getOnExit().getActions());

	}

	@Override
	public void onTransition(TransitionTarget from, TransitionTarget to,
			Transition transition) {
		handlerAction.handlerAction(transition.getActions());


	}
	


}
