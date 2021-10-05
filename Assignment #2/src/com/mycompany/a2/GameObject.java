/**
 * This abstract GameObject class that will be used for both abstract kinds of game objects: fixed objects and movable objects. 
 * All game objects have the attributes: size, color, and location that uses X and Y values (X,Y) ranging from 0.0 to 1000.0.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	
	//Declared variables that are attributes of a game object.
	private int size = 0;
	private int color = 0;
	private Point location;
	
	/**
	 * Constructor method that creates the game object. Must set float values xLocation and yLocation that will help create the Point location of 
	 * the game object.
	 * 
	 */
	public GameObject() {
		float xLocation = 0;
		float yLocation = 0;
		this.location = new Point(xLocation, yLocation);		
	}
	
	/**
	 * Setter method that sets the game object's size.
	 * 
	 * @param size declared as an int
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Setter method that sets the game object's color using ColorUtil class to generate colors
	 * 
	 * @param color declared as an int using static rgb() method of CN1 built-in ColorUtil  class  to  generate  colors
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Setter method that sets the X value of the game object's location.
	 * 
	 * @param xLocation declared as a float ranging from 0.0 to 1000.0
	 */
	public void setXLocation(float xLocation) {
		location.setX(xLocation);
	}

	/**
	 * Setter method that sets the Y value of the game object's location.
	 * 
	 * @param yLocation declared as a float ranging from 0.0 to 1000.0
	 */
	public void setYLocation(float yLocation) {
		location.setY(yLocation);
	}
	/**
	 * Setter method that sets the Point location of a game object using the float x and y values.
	 * @param xLocation declared as a float ranging from 0.0 to 1000.0
	 * @param yLocation declared as a float ranging from 0.0 to 1000.0
	 */
	public void setLocation(float xLocation, float yLocation ) {
		this.location = new Point(xLocation, yLocation);
	}
	
	/**
	 * Getter method that returns the GameObject's size.
	 * 
	 * @return size declared as an int
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Getter method that returns the GameObject's color using ColorUtil class to generate color.
	 * 
	 * @return color declared as an int using static rgb() method of CN1 built-in ColorUtil  class  to  generate  colors
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * Getter method that returns the GameObject's X value of the their location.
	 * 
	 * @return xLocation declared as a float
	 */
	public float getXLocation() {
		return location.getX();
	}
	
	/**
	 * Getter method that returns the GameObject's Y value of their location.
	 * 
	 * @return yLocation declared as a float
	 */
	public float getYLocation() {
		return location.getY();
	}
	
	/**
	 * This method returns the description of a GameObject
	 * 
	 * @return string containing the GameObject's description
	 */
	public String toString() {
		String string = "loc=" + Math.round(this.getXLocation() * 10.0) / 10.0 + "," + Math.round(this.getYLocation() * 10.0) / 10.0 + 
				" color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		return string;
	}

}
