package com.hofbauer.robocode.simulateur.Listener;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;



public class RobotToGuiListener extends Thread implements SCXMLListener {

    HashMap<TransitionTarget, HashSet<Transition>> activeTransitions = new HashMap<TransitionTarget, HashSet<Transition>>();
    private LinkedBlockingQueue<String> events = new LinkedBlockingQueue<String>();
    private Socket socket;
    private PrintWriter out;
    private InputStream in;
    private String server;
    private int port;

    public RobotToGuiListener(String server, int port) {
        super();
        this.server = server;
        this.port = port;
        reconnect();
        activeTransitions.clear();
        events.clear();
        
        start();
    }

    public void run() {
        while (true) {
            if (!events.isEmpty() && checkConnection()) {
                try {
                	
                    String event = events.take();
                    System.out.println(event);
                    out.println(event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean reconnect() {
        try {
            socket = new Socket(server, port);
            socket.setSoTimeout(5000);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = socket.getInputStream();
            return true;
        } catch (Exception e) {
            socket = null;
            out = null;
            in = null;
            return false;
        }
    }

    private boolean connected() {
        try {
            return !((socket == null) || (in.read() < 0));
        } catch (IOException e) {
            return false;
        }
    }

    private boolean checkConnection() {
        return connected() || reconnect();
    }

    

    private void sendActiveTransition(TransitionTarget from, TransitionTarget to, Transition tr) throws InterruptedException {
        events.put("3 " + from.getId() + " -> " + to.getId());
    }



	@Override
	public void onEntry(EnterableState state) {
		
        try {
			events.put("1 " + state.getId());
	        HashSet<Transition> set = activeTransitions.get(state);
	        
	        if (set != null) {
	            for (Transition tr : set) {
	            
	                System.out.println(tr.getParent().getId());
	            	events.put("2 " + tr.getParent().getId() + " -> " + state.getId());

	            }
	        }


		} catch (InterruptedException e) {

			e.printStackTrace();
		}


	}

	@Override
	public void onExit(EnterableState state) {
        try {
			events.put("0 " + state.getId());
	        HashSet<Transition> set = activeTransitions.get(state);
	        
	        if (set != null) {
	            for (Transition tr : set) {
	            
	                System.out.println(tr.getParent().getId());
	            	events.put("2 " + tr.getParent().getId() + " -> " + state.getId());

	            }}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

 
	}

	@Override
	public void onTransition(TransitionTarget from, TransitionTarget to,
			Transition tr, String arg3) {
        //Action a = (Action) tr.getActions().get(0);
		
        assert (from.equals(tr.getParent()));
        assert (tr.getTargets().contains(to) || tr.getTargets().isEmpty());
        try {
            sendActiveTransition(from, to, tr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!activeTransitions.containsKey(to)) {
            HashSet<Transition> set = new HashSet<Transition>();
            set.add(tr);
            activeTransitions.put(to, set);
        } else {
            HashSet<Transition> set = activeTransitions.get(to);
            set.add(tr);
        }

		
	}
}
