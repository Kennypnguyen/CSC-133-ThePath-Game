/**
 * This sub class commandAbout using the Command Design Pattern and extends the CN1 built in class. This method will create the command 
 * to display the about information about the game. When the user clicks the About button, this method will be invoked by displaying the about
 * information.
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
import com.codename1.ui.*;
import com.codename1.ui.table.TableLayout;

public class CommandAbout extends Command {

	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is constructor method for the About Command 
	 * 
	 * @param gw declared as GameWorld that points to
	 */
	public CommandAbout(GameWorld gw) {
		super("About");
		this.gw = gw;
	}
	
	/**
	 * This method creates action that will display the about information
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		// Display about info in a dialog box
		Dialog aboutBox = new Dialog("About", new TableLayout(4,1));
		// Ok command that the user will click after reading the about information
		Command okCommand = new Command ("Ok");
		
		// Labels information about my name, class, and version of the game
		aboutBox.add(new Label("Kenny Nguyen"));
		aboutBox.add(new Label("CSC 133-03"));
		aboutBox.add(new Label("ThePath Game Version #2"));
		
		// Shows the dialog of the about information
		Command c = Dialog.show("", aboutBox, okCommand);
		// If the ok command is clicked, return
		if (c == okCommand) {
			return;
		}
	}
}
