/**
 * This sub class CommandLeft is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the l key or left button, then this method performs the action by calling left() method from GameWorld class.
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

public class CommandLeft extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is a constructor method for Left Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandLeft(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling left() method from GameWorld class.
	 * 
	 * @parm e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.left();
	}

}
