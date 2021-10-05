/**
 * This class Flag extends the fixedObject class and it's method. This class creates the object flag that is fixed object that can not change it's location 
 * once it is created. All flags will have the same color and same size which can also not change once it is created. Each flag has additional attribute 
 * called sequenceNumber in which each flag has different sequence number ranging from 1-9. Flags are used as a checkpoint for users to clear. 
 * The user must clear each flag going in numeric number going by their sequence number.
 *
 * This class now implements IDrawable, ICollider, and ISelectable. This class has method draw from IDrawable that draws the flag object that is an 
 * unfilled or filled unfilled or filled blue isosceles triangle depending on if it is selected or not. Also the drawing will display the sequence number of the flag.
 * This class inherits the ICollider methods from GameObject. This class inherits the collidesWith method from GameObject to check if the ant has collided with another game object. 
 * However, this class overrides the handleCollision() method. This class also inherits the ISelected interface methods from FixObject class. this includes setSelected(), isSelected(),
 * and contains().
 * 
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Flag extends FixedObject {

	//Declare variables that are attributes for a Flag
	private int sequenceNumber = 1;
	private GameWorld gw;
	
	/**
	 * This constructor method creates a Flag object. The size and color is already defaulted into a fixed integer value so this means it cannot change
	 * once it is created. It uses parameters passed from the user float xLocation and yLocation to create the Point location for the flag object. To
	 * do this, it uses the super method from it's parent class to set the location. Then it uses another parameter sequenceNumber to determine what unique
	 * number will the created flag have.
	 * 
	 * @param xLocation declared as a float, used for the x value of the location of the object
	 * @param yLocation declared as a float, used for the y value of the location of the object
	 * @param sequenceNumber declared as an int, used to determine which number is the flag
	 */
	public Flag(float xLocation, float yLocation, int sequenceNumber, GameWorld gw) {
		//Super method from FixedObject to set the xLocation and yLocation
		super(xLocation, yLocation, gw);
		this.setSize(125);
		this.setColor(ColorUtil.rgb(173, 216, 230));
		this.sequenceNumber = sequenceNumber;
		this.gw = gw;
	}

	/**
	 * This getter method returns the sequence number of the flag object
	 * @return sequenceNumber declared as an int
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * This setter method sets the color for the flag object. However this method will be blank so that the color of the flag will never change.
	 */
	public void setColor(int color) {
	}
	
	/**
	 * This String toString method overrides the parent's toString method. This toString methods includes additional description of a Flag object that
	 * includes size and sequence number.
	 * 
	 * @return description of a Flag object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String mydesc1 = " size=" + this.getSize() + " seqNum=" + getSequenceNumber();
		String mydesc2 = "Flag: ";
		return mydesc2 + parentDesc + mydesc1;
	}
	
	/**
	 * This method draw is from the interface IDrawable. For this class, it draws the flag object that is a unfilled or filled blue isosceles triangle depending
	 * on if it is selected or not. Also the drawing will display the capacity of the food station.
	 * 
	 * @param g defined as a Graphics Object which belongs to MapView
	 * @param pCmpRelPrnt defined as a Point Object which is component location (MapView's origin location located at upper left corner)
	* 
	*/
	public void draw(Graphics g, Point pCmpRelPrnt) {
		  g.setColor(ColorUtil.rgb(173, 216, 230));
		  // Declare array
		  int x[] = new int[3];
		  int y[] = new int[3];
		  
		  x[0] = (int) (pCmpRelPrnt.getX() + this.getXLocation());
		  x[1] = (int) (pCmpRelPrnt.getX() + this.getXLocation() + this.getSize());
		  x[2] = (int) (pCmpRelPrnt.getX() + this.getXLocation() + this.getSize() / 2);
		  
		  y[0] = (int) (pCmpRelPrnt.getY() + this.getYLocation());
		  y[1] = (int) (pCmpRelPrnt.getY() + this.getYLocation());
		  y[2] = (int) (pCmpRelPrnt.getY() + this.getYLocation() + this.getSize());
		  // If the flag is selected
		  if (isSelected()) {
			  g.drawPolygon(x, y, 3);
		  }  
		  // If the flag is note selected
		  else {
			  g.fillPolygon(x, y, 3);
			  g.setColor(ColorUtil.BLACK);
			  g.drawString("" + this.sequenceNumber, (int) (pCmpRelPrnt.getX() + this.getXLocation() + this.getSize() / 2.5), (int) (pCmpRelPrnt.getY() + this.getYLocation() + this.getSize() / 2.8));
		  }
	}
	/**
	 * This method overrides the handleCollision method from GameObject class
	 * 
	 * @param otherObject declared as a GameObject which is the other game object that has collided with the current game object.
	 */
	public void handleCollision(GameObject otherObject) {
		
	}
	
}

