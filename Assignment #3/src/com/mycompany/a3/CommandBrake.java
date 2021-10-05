/**
 * This sub class CommandBrake is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the b key or brake button, then this method performs the action by calling brake method from GameWorld class.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class CommandBrake extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is the constructor method for the Brake Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandBrake(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling brake() method from GameWorld class.
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.brake();
	}
	
}
