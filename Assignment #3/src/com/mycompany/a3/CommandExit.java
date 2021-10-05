/**
 * This sub class commandExit using the Command Design Pattern and extends the CN1 built in class. This method will create the command 
 * that will ask if the user wants to exit the game depending if the user clicks yes or no. When the user clicks the Exit button on the side menu,  
 * this method will be invoked by using the exit() method from GameWorld
 * information.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 * 
 */

package com.mycompany.a3;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.*;
import com.mycompany.a3.GameWorld;

public class CommandExit extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw; 
	
	/**
	 * This method is constructor method for the Exit Command 
	 * 
	 * @param gw declared as GameWorld that points to and effects
	 */
	public CommandExit(GameWorld gw) {
		super("Exit");
		this.gw = gw;
	}
	
	/**
	 * This method creates action that will ask the user if they want to exit game and will act accordingly based on if the user clicks on yes or no. It 
	 * uses the exit() method from GameWorld 
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		// Create commands for yes and no
		Command yes = new Command("Yes");
		Command no = new Command("No");
		Label label = new Label("");
		// Dialog box displaying if user wants to exit the option commands yes and no
		Command c = Dialog.show("Do you want to exit the game?", label, yes, no);
		// If user clicks on yes, game will exit suing exit() from GameWorld
		if(c == yes) {
			gw.exit(2);
		}
		// If user clicks on no, then user will return to the game
		else if(c == no) {
			return;
		}
	}
}
