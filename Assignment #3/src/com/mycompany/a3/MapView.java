/**
 * This MapView class is an observer of the GameWorld class. The MapView will produce a new output of the data it is observing which is the game world 
 * objects. In this assignment, MapView will output a text output on the console showing all the game objects that exist in the game world like 
 * Assignment 1.
 * 
 * This method will now also display the game graphically in the middle container of the game screen using paint(). Also has pointerPressed() which determines if a pointer
 * is in a selectable object.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorld model;
	
	/**
	 * This method will create the red border for the MapView Container for now.
	 * 
	 * @param myModel declared as an Observable 
	 */
	public MapView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		// Create red line border
		this.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.rgb(255, 0 , 0)));
		this.getAllStyles().setBgColor(0xffffff);
	}
	/** 
	 * Call this method in GameWorld (Observable) that outputs the game object info 
	 * to the console. It also calls repaint() on itself which will override paint()
	 * 
	 * @param o
	 * @param arg
	 */
	public void update(Observable o, Object arg) {
		this.repaint();
		model.map();
	}
	
	/**
	 * This method iterates through the game objects invoking draw() on each game object.
	 * 
	 * @param g declared as Graphic object
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		GameObjectCollection list = model.getGameObjectCollection();
		IIterator itr = list.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = (GameObject) itr.getNext();
			if(tempObject instanceof IDrawable) {
				((IDrawable) tempObject).draw(g, pCmpRelPrnt);
			}
		}
	}
	
	/**
	 * This method determines if the pointer is inside the selectable game object. If the selectable game object contains a pointer, mark it 
	 * as selected. Then it repaints the container.
	 * 
	 * @param x declared as an int
	 * @param y declared as an int
	 */
	 public void pointerPressed(int x, int y) {
		 // Make pointer location relative to parent's origin
		 x = x - getParent().getAbsoluteX();
		 y = y - getParent().getAbsoluteY();
		 Point pPtrRelPrnt = new Point(x, y);
		 Point pCmpRelPrnt = new Point(getX(), getY());
		 if(model.getPaused()) {
			 model.clickSelectedObject(pPtrRelPrnt, pCmpRelPrnt);
		 }
	 }
	 
	 /**
	  * This getter method returns the MapView's height
	  * 
	  * @return getHeight(); declared as an int which uses a built in method to return the MapView's height
	  */
	 public int getMapHeight() {
		 return getHeight();
	 }
	 
	 /**
	  * This getter method returns the MapView's width
	  * 
	  * @return getWidth declared as an int which uses a built in method to return the MapView's width
	  */
	 public int getMapWidth() {
		 return getWidth();
	 }

}
