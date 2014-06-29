package com.hofbauer.robocode.simulateur.action;

import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;


	
    /**
     * A SCXMLListener that is only concerned about &quot;onentry&quot;
     * notifications.
     */
    public class EntryListener implements SCXMLListener {
    	MyAbstractStateMachine2 stateMachine;
    	public EntryListener(MyAbstractStateMachine2 stateMachine)
    	{
    		this.stateMachine=stateMachine;
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
         * @param from The &quot;source&quot; transition target.
         * @param to The &quot;destination&quot; transition target.
         * @param transition The transition being followed.
         * @param event The event triggering the transition
         */
        public void onTransition(final TransitionTarget from,
                final TransitionTarget to, final Transition transition, final String event) {
            // nothing to do
        }

        /**
         * No-op.
         *
         * @param exited The state being exited.
         */
        public void onExit(final EnterableState exited) {
            // nothing to do
        }

    }


