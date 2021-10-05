/**
 * This sub class CommandSound is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the sound button on or off, then this method performs the action by calling toggleSound() method from GameWorld class
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

public class CommandSound extends Command {

	//Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is the constructor method for the Sound Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandSound(GameWorld gw) {
		super("Sound");
		this.gw = gw;
	}

	/**
	 * This method performs the action by calling the toggleSound() method from the GameWorld class
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.toggleSound();
	}
}
