/**
 * This sub class CommandFlagCollision is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits the Collide with Flag button, then this method performs the action by calling flagCollision() method from GameWorld class.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandFlagCollision extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is the constructor method for the FlagCollision Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 */
	public CommandFlagCollision(GameWorld gw) {
		super("Collide with Flag");
		this.gw = gw;
	}
	
	/**
	 * This method performs the action by calling flagCollision() method from GameWorld class. The user must first enter a flag number 1-4. This method checks
	 * to see if the user enters a valid number and a number 1-4. If not, then the user is prompted with a message that an error has occurred and it must 
	 * enter a flag number 1-4. When the user enters a valid flag number 1-4, then the flagCollision() method is called from GameWorld class.
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		Command enterCommand = new Command("Confirm");
		TextField emptyText = new TextField();
		// Dialog telling the user to enter a flag number 1-4.
		Command c = Dialog.show("Enter a Flag number between 1-4", emptyText, enterCommand);
		
		int seqNumber = 1;
		if(c == enterCommand) {
			//If the user does not enter a valid number, it will display an error message
			try {
				seqNumber = Integer.parseInt(emptyText.getText());
			} catch (Exception ex) {
				Dialog.show("Error", "Please enter a number between 1 and 4", "Ok", null);
			}
		}
		//If the user does not enter a number 1-4, it wil display an error message
		if(seqNumber > 4 || seqNumber < 1) {
			Dialog.show("Error", "Please enter a number between 1 and 4", "Ok", null);
			return;
		}
		gw.flagCollision(seqNumber);
	}

}
