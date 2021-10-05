/**
 * This abstract MovableObject extends the GameObject class and it's methods. All movable objects have the additional attributes heading and speed.
 * Also, all movable objects are told to move by updating their heading, in which heading refers to a compass angle in degrees.
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;

public abstract class MovableObject extends GameObject {
	
	//Declared variables that are attributes of a movable object.
	private int heading;
	private int speed;
	
	/**
	 * Constructor class that creates a movable object that has the attribute heading set.
	 * 
	 * @param heading declared as an int
	 */
	public MovableObject(int heading) {
		this.heading = heading;
	}

	/**
	 * Method that "moves" the movable object. It moves the moves movable object by calculations that involve it's heading and speed.
	 * Using this calculation, it updates the X and Y value of their location. This method uses the Math class to help convert to radians. 
	 */
	public void move() {
		//Equation to create a new X and Y value once the movable object moves
		double deltaX = (Math.cos(Math.toRadians(90 - this.getHeading())) * this.getSpeed());
		double deltaY = (Math.sin(Math.toRadians(90 - this.getHeading())) * this.getSpeed());
		// Make sure the X and Y values are a float
		this.setXLocation(this.getXLocation() + (float)deltaX);
		this.setYLocation(this.getYLocation() + (float)deltaY);
	}
	
	/**
	 * Setter method that sets the movable object's heading ranging from 0 to 359.
	 * 
	 * @param heading declared as an int ranging from 0 to 359
	 */
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Getter method that returns the movable object's heading ranging from 0 to 359.
	 *  
	 * @return heading declared as an int
	 */
	public int getHeading() {
		return heading;
	}
	
	/**
	 * Getter method that returns the movable object's speed.
	 * 
	 * @return speed declared as an int
	 */
	public int getSpeed() {
		return speed;
	}
	
	/** 
	 * Method that overrides the parent's toString method. This method includes additional description of a movable object that includes heading, speed,
	 * and size.
	 * 
	 * @return description of a movable object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " heading=" + getHeading() + " speed=" + getSpeed() + " size=" + this.getSize(); ;
		return parentDesc + myDesc;
	}
}
