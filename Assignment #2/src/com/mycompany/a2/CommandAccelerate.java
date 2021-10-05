/**
 * This sub class CommandAccelerate is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the a key or accelerate button, then this method performs the action by calling accelerate() method from GameWorld class.
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

public class CommandAccelerate extends Command {
	
	//Declare GameWorld variable
	private GameWorld gw;
	
/**
 * This method is the constructor method for the Accelerate Command
 * 
 * @param gw declared as GameWorld that points to and effects
 */
	public CommandAccelerate(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling accelerate() method from GameWorld class.
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		gw.accelerate();
	}

}
