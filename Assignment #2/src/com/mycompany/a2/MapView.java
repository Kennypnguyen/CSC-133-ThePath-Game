/**
 * This MapView class is an observer of the GameWorld class. The MapView will produce a new output of the data it is observing which is the game world 
 * objects. In this assignment, MapView will output a text output on the console showing all the game objects that exist in the game world like 
 * Assignment 1.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
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
		model.addObserver(this);
		// Create red line border
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255, 0 , 0)));
	}

	/** 
	 * Call this method in GameWorld (Observable) that outputs the game object info 
	 * to the console.
	 * 
	 * @param o
	 * @param arg
	 */
	public void update(Observable o, Object arg) {
		{
			model.map();
		}
	}
}
