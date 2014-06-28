package com.hofbauer.robocode.simulateur.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.scxml.model.Action;

import robocode.AdvancedRobot;

public class HandlerAction {

	private AdvancedRobot robot;

	public HandlerAction(AdvancedRobot robot) {
		this.robot = robot;

	}

	public void handlerAction(List<Action> a) {
		try {
			ssHandlerAction(a);
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

	private void ssHandlerAction(List<Action> a) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method m;
		Object res;
		for (Action action : a) {
			String actionClass = action.getClass().toString();
			switch (actionClass) {
			case "class com.hofbauer.robocode.simulateur.action.customaction.TestAction":
				 m = action.getClass().getMethod("getX");
				res = m.invoke(action);

				System.out.println((String) res);
				System.out.println(m.getName());
				robot.back(100);
				break;
			case "class com.hofbauer.robocode.simulateur.action.customaction.SetBackAction":
				 m = action.getClass().getMethod("getDistanceDouble");
				 res = m.invoke(action);
				 robot.setBack((Double)res);
				 break;
			case "class com.hofbauer.robocode.simulateur.action.customaction.SetAheadAction":
				 m = action.getClass().getMethod("getDistanceDouble");
				 res = m.invoke(action);
				 robot.setAhead((Double)res);
				 break;
			case "class com.hofbauer.robocode.simulateur.action.customaction.SetTurnLeftAction":
				 m = action.getClass().getMethod("getAngleDouble");
				 res = m.invoke(action);
				 robot.setTurnLeft((Double)res);
				 break;
			case "class com.hofbauer.robocode.simulateur.action.customaction.SetTurnRightAction":
				 m = action.getClass().getMethod("getAngleDouble");
				 res = m.invoke(action);
				 robot.setTurnRight((Double)res);
				 break;
			case "class com.hofbauer.robocode.simulateur.action.customaction.SetFireAction":
				 System.out.println("fire ");
				 m = action.getClass().getMethod("getPowerDouble");
				 res = m.invoke(action);
				 robot.setFire((double)res);
				 System.out.println("power : " +(double)res);
				 break;
				
				
			}

		}
	}

}
