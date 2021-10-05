/**
 * This interface ISelectable is used for all fixed game objects. This interface specifies the methods required to implement selection of a 
 * selectable object which are fixed objects. 
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public interface ISelectable {
	
	/**
	 * This setter method marks a selectable object as selected or not.
	 * 
	 * @param yesNo declared as a boolean depending if a selectable object is selected (true) or not (false)
	 */
	public void setSelected(boolean yesNo);
	
	/**
	 * This getter method returns the boolean isSelected which means if the selectable object is selected or not.
	 * True means it is selected and false means it is not selected.
	 * 
	 * @return isSelected declared as a boolean which return true or false depending if selectable object is selected or not
	 */
	public boolean isSelected();
	
	/**
	 * This method determines if the pointer is in a selectable object
	 *
	 * @param pPtrRelPrnt declared as a Point which is the position relative to the parent origin
	 * @param pCmpRelPrnt declared as a Point which is the component position relative to the parent origin
	 * @return true or false declared as a boolean value depending if the pointer object is in the selectable object
	 */
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	
	/**
	 * This method is able to draw the selectable objects in different depending on "isSelected" value
	 * 
	 * @param g defined as a Graphics Object which belongs to MapView
	 * @param pCmpRelPrnt defined as a Point Object which is component location (MapView's origin location located at upper left corner) 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt);

}
