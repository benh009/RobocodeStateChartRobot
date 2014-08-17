package com.hofbauer.robocode.simulateur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.scxml2.model.ModelException;

import robocode.control.*;
import robocode.control.events.*;

/**
 * Cette classe permet de lancer un combat avec les robots spécifier dans l'appelle de methode
 * engine.getLocalRepository
 * @author hofbauer
 *
 */
public class BattleRunner {

    public static void main(String[] args) {

        // Disable log messages from Robocode
        //
        

        // Create the RobocodeEngine
        //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory  
    	

        RobocodeEngine engine = new RobocodeEngine(); // Run from C:/Robocode
        // Add our own battle listener to the RobocodeEngine 
        engine.addBattleListener(new BattleObserver());

        // Show the Robocode battle view
       engine.setVisible(true);

        
        

        // Setup the battle specification

        int numberOfRounds = 15;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
/**
        for (RobotSpecification r :engine.getLocalRepository())
        {
        	
        	System.out.println(r.getName());
        }**/
        engine.printRunningThreads();
        
        RobotSpecification[] selectedRobots = engine.getLocalRepository("sample.Corners,sample.Target,com.hofbauer.robocode.robots.RobotModele1*");

        //RobotSpecification[] selectedRobots = engine.getLocalRepository("sample.Target,sample.Walls,com.hofbauer.robocode.robots.RobotModele1*,com.hofbauer.robocode.robots.RobotModele2*");

        
        
        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
        
        
        // Run our specified battle and let it run till it is over
        engine.runBattle(battleSpec, true); // waits till the battle finishes
        
        // Cleanup our RobocodeEngine
        engine.close();

        // Make sure that the Java VM is shut down properly
        System.exit(0);
    }
}
//
// Our private battle listener for handling the battle event we are interested in.
//
class BattleObserver extends BattleAdaptor {

    // Called when the battle is completed successfully with battle results
    public void onBattleCompleted(BattleCompletedEvent e) {
        System.out.println("-- Battle has completed --");
        
        // Print out the sorted results with the robot names
        System.out.println("Battle results:");
        for (robocode.BattleResults result : e.getSortedResults()) {
            System.out.println("  " + result.getTeamLeaderName() + ": " + result.getScore());
        }
    }

    // Called when the game sends out an information message during the battle
    public void onBattleMessage(BattleMessageEvent e) {
        System.out.println("Msg> " + e.getMessage());
    }

    // Called when the game sends out an error message during the battle
    public void onBattleError(BattleErrorEvent e) {
        System.out.println("Err> " + e.getError());
    }
}