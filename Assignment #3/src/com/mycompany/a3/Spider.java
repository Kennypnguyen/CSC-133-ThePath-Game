/**
 * This class Spider extends MovableObject and it's methods. This class creates a Spider object that is a MovableObject that it's location is randomly 
 * created within the boundaries of the game. It's size is also randomly generated ranging from 10 - 50. As a movable object, it's speed was
 * also randomly generated ranging from 5-10 as well the heading ranging from 0 to 359. All spiders will the same color that will never change once 
 * it's created. Since a spider is a movable object and as the game ticks, the spider's location is updated using it's random heading using the move() method
 * from MovableObject.
 * 
 * This class now implements IDrawable and ICollider from GameObject Abstract class. This class has method draw from IDrawable that draws the ant object that is a unfilled isosceles triangle. 
 * This class inherits the ICollider methods from GameObject. This class inherits the collidesWith method from GameObject to check if the ant has collided with another game object. 
 * However, this class overrides the handleCollision() method.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Spider extends MovableObject {
	
	//This is created so that the Spider's heading is created.
	Random rand = new Random();
	private GameWorld gw;
	
	/**
	 * This constructor method creates a Spider object. The color is set to a defaulted integer value so that it can not change once 
	 * it is created.It uses parameter size that is randomly generated using the Random class ranging from 10-50 as well as speed ranging from 
	 * 5-10. Size, speed, and color is using the keyword super to use their parent's method to set the attributes. It also uses the parameters float 
	 * xLocation and yLocation which is also randomly created ranging from 0.0 to 1000.0 using the Random class. The parameter heading
	 * is also randomly generated from the Random class ranging from 0-359 as well as using super keyword to use parent's method set the heading. 
	 * 
	 * @param xLocation declared as a float, used for the x value of the location of the object (randomly generated)
	 * @param yLocation declared as a float, used for the y value of the location of the object (randomly generated)
	 * @param speed declared as an int (randomly generated)
	 * @param size declared as an int (randomly generated)
	 * @param heading declared as an int (randomly generated)
	 */
	public Spider(float xLocation, float yLocation, int speed, int size, int heading, GameWorld gw) {
		//uses the super method from MovableObject to set the heading 
		super(heading, gw);
		this.setXLocation(xLocation);
		this.setYLocation(yLocation);
		super.setSpeed(speed);
		super.setSize(size);
		super.setColor(ColorUtil.BLACK);
	}
	
	/**
	 * This method randomHeading() sets the heading of the Spider object using the random number generator from Random class
	 */
	public void randomHeading() {
		this.setHeading(rand.nextInt(359));
	}
	
	/**
	 * This setter method sets the size of Spider object. Empty method because it should not change once created.
	 */
	public void setSize(int size) {
	}
	
	/**
	 * This setter method sets the color of the Spider object. Empty method because it should not change once created.
	 */
	public void setColor(int color) {
	}
	
	/**
	 * This String toString method overrides the parent's toString method. This toString methods includes additional description of a Spider object that
	 * includes word "Spider: ".
	 * 
	 * @return description of a Spider object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "Spider: ";
		return myDesc + parentDesc;
	}
	
	/**
	 * This method draw is from the interface IDrawable. For this class, it draws the spider object that is an unfilled isosceles triangle. Uses arrays to 
	 * caculate the three points of the triangle to draw it.
	 * 
	 * @param g defined as a Graphics Object which belongs to MapView
	 * @param pCmpRelPrnt defined as a Point Object which is component location (MapView's origin location located at upper left corner)
	 */
	public void draw(Graphics g, Point pCmpRelPrnt) {
		  g.setColor(super.getColor());
		  // Declare arrays
		  int x[] = new int[3];
		  int y[] = new int[3];
		  
		  x[0] = (int) (pCmpRelPrnt.getX() + this.getXLocation());
		  x[1] = (int) (pCmpRelPrnt.getX() + this.getXLocation() + this.getSize());
		  x[2] = (int) (pCmpRelPrnt.getX() + this.getXLocation() + this.getSize() / 2);
		  
		  y[0] = (int) (pCmpRelPrnt.getY() + this.getYLocation());
		  y[1] = (int) (pCmpRelPrnt.getY() + this.getYLocation());
		  y[2] = (int) (pCmpRelPrnt.getY() + this.getYLocation() + this.getSize());
		  // If the flag is selected
		  g.drawPolygon(x, y, 3);
	}

	/**
	 * This method overrides the handleCollision method from GameObject class
	 * 
	 * @param otherObject declared as a GameObject which is the other game object that has collided with the current game object.
	 */
	public void handleCollision(GameObject otherObject) {

	}
}
