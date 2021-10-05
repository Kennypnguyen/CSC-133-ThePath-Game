/**
 * This sub class CommandFoodStationCollision is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the f key or Collide with Food Station button, then this method performs the action by calling foodStationCollision() method 
 * from GameWorld class.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandFoodStationCollision extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is a contructor method for the FoodStationCollision Command
	 * 
	 * @param gw declared as a GameWOrld that points and effects
	 */
	public CommandFoodStationCollision(GameWorld gw) {
		super("Collide with Food Station");
		this.gw = gw;
	}
	
	/**
	 * his method performs the action by calling foodStationCollision() method from GameWorld class.
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.foodStationCollision();
	}

}
