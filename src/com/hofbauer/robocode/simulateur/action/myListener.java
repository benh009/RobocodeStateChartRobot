package com.hofbauer.robocode.simulateur.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.Invoke;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

import robocode.AdvancedRobot;

public class myListener implements SCXMLListener {
	private AdvancedRobot robot;
	private HandlerAction handlerAction;
	public myListener(AdvancedRobot robot)
	{
		this.robot=robot;
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
