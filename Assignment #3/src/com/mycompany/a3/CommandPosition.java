/**
 * This sub class CommandPosition is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits position button, it will call togglePosition() method from GameWorld class.
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

public class CommandPosition extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	
	/**
	 * This method is a constructor method for PositionCommand
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandPosition (GameWorld gw) {
		super("Position");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling gw.togglePosition() method from GameWorld class.
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		if(gw.getPaused()) {
			gw.togglePosition();
		}
	}

}
