/**
 * This interface IDrawable is used for the GameObject class that is responsible to drawing all the shapes of each game object. 
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public interface IDrawable {
	
	/**
	 * This method will draw a specific shape depending on the game object. It will draw the specific game object's current shape and size
	 * 
	 * @param g defined as a Graphics Object which belongs to MapView
	 * @param pCmpRelPrnt defined as a Point Object which is component location (MapView's origin location located at upper left corner) 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt);

}
