package com.hofbauer.robocode.simulateur.proxy;

import robocode.MessageEvent;



public class Message  {
	private MessageEvent m;
	public Message(MessageEvent m)
	{
		this.m=m;
	}
	public String getSender(){
		return m.getSender();
	}
	public String getMessage(){
		return (String)m.getMessage();
	}

}
