package com.hofbauer.robocode.simulateur.action;

import robocode.AdvancedRobot;

public class RobotActionTools {
	
	
	private AdvancedRobot robot;
	public RobotActionTools(AdvancedRobot robot)
	{
		this.robot=robot;
	}
	
    public void direction(double directionVoulue) {
        double directionActuelle = robot.getHeading();

        if (Math.abs(directionVoulue - directionActuelle) < 1) {

        } else if (directionVoulue > directionActuelle) {
            if ((360 - directionVoulue + directionActuelle) < (directionVoulue - directionActuelle)) {
                robot.setTurnLeft(360 - directionVoulue + directionActuelle);
            } else {
                robot.setTurnRight(directionVoulue - directionActuelle);
            }
        } else if (directionVoulue <= directionActuelle) {
            if ((360 - directionActuelle + directionVoulue) < (directionActuelle - directionVoulue)) {
                robot.setTurnRight(360 - directionActuelle + directionVoulue);
            } else {
                robot.setTurnLeft(directionActuelle - directionVoulue);
            }
        }
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

}
