package com.hofbauer.robocode.simulateur.Listener;

import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;

import com.hofbauer.robocode.simulateur.MyAbstractStateMachine;

/**
 * Permet d'appliquer une methode lorsqu on rentre dans un état 
 * (n'est pas utiliser dans le projet)
 */
public class EntryListener implements SCXMLListener {
	MyAbstractStateMachine stateMachine;

	public EntryListener(MyAbstractStateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	/**
	 * {@inheritDoc}
	 */
	public void onEntry(final EnterableState entered) {
		stateMachine.invoke(entered.getId());
	}

	/**
	 * No-op.
	 * 
	 * @param from
	 *            The &quot;source&quot; transition target.
	 * @param to
	 *            The &quot;destination&quot; transition target.
	 * @param transition
	 *            The transition being followed.
	 * @param event
	 *            The event triggering the transition
	 */
	public void onTransition(final TransitionTarget from,
			final TransitionTarget to, final Transition transition,
			final String event) {
		// nothing to do
	}

	/**
	 * No-op.
	 * 
	 * @param exited
	 *            The state being exited.
	 */
	public void onExit(final EnterableState exited) {
		// nothing to do
	}

}
