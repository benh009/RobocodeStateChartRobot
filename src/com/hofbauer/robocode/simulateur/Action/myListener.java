package com.hofbauer.robocode.simulateur.Action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.Invoke;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class myListener implements SCXMLListener {

	@Override
	public void onEntry(TransitionTarget state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExit(TransitionTarget state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTransition(TransitionTarget from, TransitionTarget to,
			Transition transition) {
		
		System.out.print("transition\n");
		List<Action> a = transition.getActions();
		for(Action action:a)
		{
			
			System.out.print("action\n");
			System.out.println(action.getClass());

	
			if (action.getClass().toString().equals(TestAction.class.toString()))
			{
				try {
					System.out.println();
					Method m = action.getClass().getMethod("getX");
					Object res =m.invoke(action);
					
					System.out.println((String) res); 
					System.out.println(m.getName());
					//m.invoke(a);
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
