package com.hofbauer.robocode.simulateur.toolsaction;

import robocode.AdvancedRobot;
/**
 * outils utile pour les proxy
 *  
 * @author hofbauer
 *
 */
public class ActionTools {

	private AdvancedRobot robot;


	public ActionTools(AdvancedRobot robot) {
		this.robot = robot;
	}

	public  void direction(double directionVoulue) {
		robot.setTurnRight(directionG(robot.getHeading(),directionVoulue));
	}

	public void directionGun(double directionVoulue) {

		robot.setTurnGunRight(directionG(robot.getGunHeading(),directionVoulue));


	}
	
	public void directionGunPal(double directionVoulue,double palier) {
		System.out.println("gun direction palier :  "+direction(robot.getGunHeading(),directionVoulue, palier));
		robot.setTurnGunRight(direction(robot.getGunHeading(),directionVoulue, palier));
		
	}
	
	public static double directionG(double directionActuelle,double directionVoulue)
	{
		System.out.println(directionActuelle+"   "+directionVoulue);
		//pour la precision
	     if (directionVoulue > directionActuelle) {
			//pour deciser du plus court 
			if ((360 - directionVoulue + directionActuelle) < (directionVoulue - directionActuelle)) {
				return -(360 - directionVoulue + directionActuelle);
			} else {
				return (directionVoulue - directionActuelle);
			}
		} else if (directionVoulue <= directionActuelle) {
			if ((360 - directionActuelle + directionVoulue) < (directionActuelle - directionVoulue)) {
				return (360 - directionActuelle + directionVoulue);
			} else {
				return -(directionActuelle - directionVoulue);
			}
		}
		return directionActuelle;
		
	}
	
	public static double direction(double directionActuelle ,double directionVoulue,double palier)
	{
		//positif vers la droite
		/// negatif vers la gauche
	 

		//permet de ne pas tourner si trop précis 
		if (Math.abs(directionVoulue - directionActuelle) < 0.01) {
			return 0.;
		} else if (directionVoulue > directionActuelle) {
			if ((360 - directionVoulue + directionActuelle) < (directionVoulue - directionActuelle)) {
				
				//tjs positif
				//Left
				return -Math.min((360 - directionVoulue + directionActuelle),palier);
			} else {
				return Math.min((directionVoulue - directionActuelle),palier);
			}
		} else if (directionVoulue <= directionActuelle) {
			if ((360 - directionActuelle + directionVoulue) < (directionActuelle - directionVoulue)) {
				return Math.min((360 - directionActuelle + directionVoulue),palier);
			} else {
				return -Math.min((directionActuelle - directionVoulue),palier);
			}
		}
		
		return 0;
	}

	public void goTo(double nx, double ny) {
		double x = robot.getX();
		double y = robot.getY();
		double deltaX = nx - x;
		double deltaY = ny - y;

		double t = deltaY / deltaX;
		double arct = Math.abs(Math.atan(t));
		if (Math.abs(deltaX) < 2 && Math.abs(deltaY) < 2) {
			robot.doNothing();
		} else if (Math.abs(deltaX) < 1) {
			if (ny > y) {
				direction(0);
				robot.setAhead(deltaY);
			} else {
				direction(180);
				robot.setAhead(-deltaY);
			}

		} else if (Math.abs(deltaY) < 1) {
			if (nx > x) {
				direction(90);
				robot.setAhead(deltaX);
			} else {
				direction(270);
				robot.setAhead(-deltaX);
			}

		} else {
			if (deltaY > 0 && deltaX > 0) {
				direction((90 - Math.toDegrees(arct)));

			} else if (deltaY < 0 && deltaX > 0) {
				direction((90 + Math.toDegrees(arct)));

			} else if (deltaY < 0 && deltaX < 0) {
				direction((270 - Math.toDegrees(arct)));

			} else if (deltaY > 0 && deltaX < 0) {
				direction((270 + Math.toDegrees(arct)));

			}
			robot.setAhead(Math.sqrt(deltaY * deltaY + deltaX * deltaX));
		}

	}

	public static Boolean equalsPrec(double val1,double val2, float precision) {
		return Math.abs(val1-val2) < precision;
	}

	public Boolean e(Double val1,Double val2) {
		float precision =1;
		return equalsPrec(val1,val2, precision);
	}
}
