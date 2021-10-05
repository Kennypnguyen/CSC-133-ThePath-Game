/**
 * This abstract class FixedObject extends the GameObject class and it's methods. All fixed objects have a fixed location that 
 * are not allowed to change it's location once they are created.
 * 
 * This class now implements ISelectable interface where these methods support the ability to interactively select the selectable objects.
 * The methods include the setter method setSelected which marks a selectable object as selected. Getter method that returns if object was 
 * selected or not. Also the method contains determines if the pointer is in a selectable object.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public abstract class FixedObject extends GameObject implements ISelectable {
	
	private boolean isSelected;
	
	/**
	 * Constructor class that creates a fixed object. it uses the super keyword that refers to parent class (GameObject class) to set the X
	 * and Y value of the fixed object's location.
	 * 
	 * @param xLocation declared as a float ranging from 0.0 to 1000.0
	 * @param yLocation declared as a float ranging from 0.0 to 1000.0
	 */
	public FixedObject(float xLocation, float yLocation, GameWorld gw) {
		// Used super keyword to refer to the parent class to set the X and Y value of the location
		super(gw);
		super.setXLocation(xLocation);
		super.setYLocation(yLocation);
	}
	
	/**
	 * Setter method that makes sure the X location of the fixed object does not change
	 
	public void setXLocation(float xLocation) {
	}
	*/
	/** 
	 * Setter method that makes sure the Y location of the fixed object does not change
	 
	public void setYLocation(float yLocation) {
	}
	*/
	
	/**
	 * This setter method marks a selectable object as selected or not.
	 * 
	 * @param yesNo declared as a boolean depending if a selectable object is selected (true) or not (false)
	 */
	public void setSelected(boolean yesNo) {
		isSelected = yesNo;
	}

	/**
	 * This getter method returns the boolean isSelected which means if the selectable object is selected or not.
	 * True means it is selected and false means it is not selected.
	 * 
	 * @return isSelected declared as a boolean which return true or false depending if selectable object is selected or not
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * This method determines if the pointer is in a selectable object
	 *
	 * @param pPtrRelPrnt declared as a Point which is the position relative to the parent origin
	 * @param pCmpRelPrnt declared as a Point which is the component position relative to the parent origin
	 * @return true or false declared as a boolean value depending if the pointer object is in the selectable object
	 */
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int pointX = pPtrRelPrnt.getX();
		int pointY = pPtrRelPrnt.getY();
		int xLoc = (int)(pCmpRelPrnt.getX() + this.getXLocation());
		int yLoc = (int)(pCmpRelPrnt.getY() + this.getYLocation());
		if((pointX >= xLoc) && (pointX <= xLoc + this.getSize()) && (pointY >= yLoc) && (pointY <= yLoc + this.getSize())) {
			return true;
		}
		else {
			return false;
		}
	}
}
