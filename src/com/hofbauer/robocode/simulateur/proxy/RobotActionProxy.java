package com.hofbauer.robocode.simulateur.proxy;

import com.hofbauer.robocode.robots.RobotSimWithAction;
import com.hofbauer.robocode.simulateur.toolsaction.ActionTools;

import robocode.AdvancedRobot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;
public class RobotActionProxy {
	private RobotSimWithAction robot;
	public RobotActionProxy(RobotSimWithAction robot)
	{
		this.robot=robot;
	
	}
	public void ahead(double distance)
	{
		robot.setAhead(distance);
	}
	public void back(double distance)
	{
		robot.setBack(distance);
		
	}
	public void turnLeft(double degrees)
	{
		robot.setTurnLeft(degrees);
	}
	public void turnRight(double degrees)
	{
		robot.setTurnRight(degrees);
	}
	public void direction(Double directionVoulue)
	{
		directionVoulue= directionVoulue%360;
		if(directionVoulue<0)
		{
			directionVoulue=360-directionVoulue;
		}
		robot.setTurnRight(ActionTools.directionG(robot.getHeading(),directionVoulue));

	}


	public void scheduleOnKeyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case VK_UP:
		case VK_W:
			// Arrow up key: move direction = forward (infinitely)
			robot.setAhead(Double.POSITIVE_INFINITY);
			break;

		case VK_DOWN:
		case VK_S:
			// Arrow down key: move direction = backward (infinitely)
			robot.setBack(Double.POSITIVE_INFINITY);
			break;

		case VK_RIGHT:
		case VK_D:
			// Arrow right key: turn direction = right
			robot.setTurnRight(10);
			break;

		case VK_LEFT:
		case VK_A:
			// Arrow left key: turn direction = left
			robot.setTurnLeft(10);
			
			break;
		case VK_SPACE:
			robot.fire(3);
			break;
		}
	}
	public void scheduleOnKeyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case VK_UP:
		case VK_W:
		case VK_DOWN:
		case VK_S:
			// Arrow up and down keys: move direction = stand still
			robot.setAhead(0);

			
			break;

		case VK_RIGHT:
		case VK_D:
		case VK_LEFT:
		case VK_A:
			// Arrow right and left keys: turn direction = stop turning
			robot.setTurnLeft(0);
			break;
		}
	}
	
	public void setMaxTurnRate(double maxTurnRate)
	{
		this.robot.setMaxTurnRate(maxTurnRate);
		
	}
	public void setMaxVelocity(double maxVelocity)
	{
		this.robot.setMaxVelocity(maxVelocity);
	}

	//team 
	public void broadcastMessage(String message)
	{
		try {
			robot.broadcastMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage(String name,
            String message){
		 System.out.println("Receice");
		try {
			robot.sendMessage(name, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print(String s )
	{
		System.out.println(s);
	}

}
