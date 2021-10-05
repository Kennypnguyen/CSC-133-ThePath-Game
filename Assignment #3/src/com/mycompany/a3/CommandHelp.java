/**
 * This sub class CommandHelp using the Command Design Pattern and extends the CN1 built in class. This method will create the command 
 * to display the help information about the game. When the user clicks the Help button, this method will be invoked by displaying
 * information about the commands/controls of the game that user can use.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.*;

public class CommandHelp extends Command {
	
	// Declare GameWorld variable
	private GameWorld gw;
	
	/**
	 * This method is a constructor method for the Help Command
	 * 
	 * @param gw declared as a GameWorld that points to
	 */
	public CommandHelp(GameWorld gw) {	
		super("Help");
		this.gw = gw;
	}
	
	/**
	 * This method creates the action that will display the help information for the user to read. The help information includes the controls/commands of 
	 * the game
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		// Create a dialog box that will display the help information
		Dialog helpBox = new Dialog("Help", new TableLayout(8, 2));
		helpBox.add(new Label("Controls"));
		helpBox.add(new Label("Command"));
		// Label what commands/controls are in the game
		helpBox.add(new Label("Press a"));
		helpBox.add(new Label("To accelerate"));
		helpBox.add(new Label("Press b"));
		helpBox.add(new Label("To brake"));
		helpBox.add(new Label("Press r"));
		helpBox.add(new Label("To make a right turn"));
		helpBox.add(new Label("Press l"));
		helpBox.add(new Label("To make a left turn"));
		
		// Ok command that the user will click after reading the about information
		Command okCommand = new Command("Ok");
		// Shows the dialog of the help information
		Command c = Dialog.show("", helpBox, okCommand);
		// If the user hits the Ok command it will return to the game
		if(c == okCommand) {
			return;
		}		
	}
	
}
