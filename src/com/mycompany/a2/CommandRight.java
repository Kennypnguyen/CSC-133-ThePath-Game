/**
 * This sub class CommandRight is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the r key or right button, then this method performs the action by calling right() method from GameWorld class
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

public class CommandRight extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is the constructor for the Right Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects 
	 */
	public CommandRight(GameWorld gw) {
		super("Right");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling the right() method from the GameWorld class
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.right();
	}

}
