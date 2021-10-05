/**
 * This abstract class FixedObject extends the GameObject class and it's methods. All fixed objects have a fixed location that 
 * are not allowed to change it's location once they are created.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a2;

public abstract class FixedObject extends GameObject {
	
	/**
	 * Constructor class that creates a fixed object. it uses the super keyword that refers to parent class (GameObject class) to set the X
	 * and Y value of the fixed object's location.
	 * 
	 * @param xLocation declared as a float ranging from 0.0 to 1000.0
	 * @param yLocation declared as a float ranging from 0.0 to 1000.0
	 */
	public FixedObject(float xLocation, float yLocation) {
		// Used super keyword to refer to the parent class to set the X and Y value of the location
		super.setXLocation(xLocation);
		super.setYLocation(yLocation);
	}
	
	/**
	 * Setter method that makes sure the X location of the fixed object does not change
	 */
	public void setXLocation(float xLocation) {
	}
	
	/** 
	 * Setter method that makes sure the Y location of the fixed object does not change
	 */
	public void setYLocation(float yLocation) {
	}
}
