/**
 * This sub class CommandTick is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the t key or tick button, then this method performs the action by calling clockTick() method from GameWorld class
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

public class CommandTick extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is the constructor method for the Tick Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandTick(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}

	/**
	 * This method performs the action by calling the clockTick() method from the GameWorld class
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.clockTick();
	}
}
