/**
 * This abstract GameObject class that will be used for both abstract kinds of game objects: fixed objects and movable objects. 
 * All game objects have the attributes: size, color, and location that uses X and Y values (X,Y) ranging from 0.0 to the map's height and width
 * 
 * This class now implements IDrawable and ICollider. However, the methods from IDrawable is going to implemented differently for each game object. This class 
 * has method collidesWith from ICollider thats checks to see if the ant has collided with other game objects. Also has handleCollision from ICollider that handles
 * the collision between the ant and another game object that depends on the objects.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject implements IDrawable, ICollider {
	
	//Declared variables that are attributes of a game object.
	private int size = 0;
	private int color = 0;
	private Point location;
	private GameWorld gw;
	
	/**
	 * Constructor method that creates the game object. Must set float values xLocation and yLocation that will help create the Point location of 
	 * the game object.
	 * 
	 */
	public GameObject(GameWorld gw)
	{
		this.gw = gw;
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
	 * Setter method that sets the X value of the game object's location. If X value is under 0, then it sets the X location to 0 and
	 * if the X location is greater than the map's width, then it is set in between the map because ant cannot be out of bounds.
	 * 
	 * @param xLocation declared as a float ranging from 0.0 to map's width
	 */
	public void setXLocation(float xLocation) {
			location.setX(xLocation);
	}

	/**
	 * Setter method that sets the Y value of the game object's location. If Y value is under 0, then it sets the Y location to 0 and
	 * if the Y location is greater than the map's height, then it is set in between the map because ant cannot be out of bounds.
	 * 
	 * 
	 * @param yLocation declared as a float ranging from 0.0 to map's height
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
	
	public GameWorld getGameWorld() {
		return gw;
	}
	
	public void setGW(GameWorld gw) {
		this.gw = gw;
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
	
	/**
	 * This method is from the interface ICollider and checks to see if the game object and another game object has collided. Uses calculations with their x locations, 
	 * y locations, and their sizes to see if they have collided with each other. returns true if they have collided or false if they have not collide based
	 * on the calculations
	 * 
	 * @param otherObject declared as an GameObject which is the other game object that has or has not collided with the current game object
	 * @return result either true or false depending on if the two objects have collided or not
	 */
	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		// Find centers
		int thisCenterX  = (int)(this.getXLocation() + (this.getSize() / 2));
		int thisCenterY = (int)(this.getYLocation() + (this.getSize() / 2));
		int otherCenterX = (int)(((GameObject) otherObject).getXLocation() + (((GameObject) otherObject).getSize() / 2));
		int otherCenterY = (int)(((GameObject) otherObject).getYLocation() + (((GameObject) otherObject).getSize() / 2));
		// Find distance between centers
		int distanceX = thisCenterX - otherCenterX;
		int distanceY = thisCenterY - otherCenterY;
		int distanceBetweenCenterSquare = (distanceX * distanceX + distanceY * distanceY);
		// Find circle's sum of radius
		int thisRadius = this.getSize() / 2;
		int otherRadius = ((GameObject) otherObject).getSize() / 2;
		int radiusSquare = (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		if(distanceBetweenCenterSquare <= radiusSquare) {
			// Two objects have collided
			result = true;
		}
		return result;
	}
	
	/**
	 * This method is from the interface ICollider and handles the collisions between two game objects. Will handle the collision according to what 
	 * the two game objects are.
	 * 
	 * @param otherObject declared as an GameObject which is the other game object that has collided with the current game object.
	 */
	public void handleCollision(GameObject otherObject) {	
		if(this instanceof Ant) {
			if(otherObject instanceof Spider) {
				gw.spiderCollision();
			}
			if(otherObject instanceof Flag) {
				gw.flagCollision((Flag) otherObject);
			}
			if(otherObject instanceof FoodStation) {
				gw.foodStationCollision((FoodStation) otherObject);
			}
		}
	}
	
}
