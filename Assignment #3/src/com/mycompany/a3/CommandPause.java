/**
 * This sub class CommandPause is using the Command Design Pattern and extends the CN1 built in Command class. 
 * When the user hits pause button this method performs the action depending on if the game is pause and unpaused, will call pressedPause() from Game class.
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Button;
import com.mycompany.a3.GameWorld;

public class CommandPause extends Command {
	
	// Declare variables
	private GameWorld gw;
	private Game game;
	private Button button;

	/**
	 * This constructor method for the Pause Command
	 * 
	 * @param gw declared as a GameWorld that points to and effects
	 * @param game declared as a Game that points to the current game 
	 * @param button declared as a Button that points to pauseButton from Game class
	 */
	public CommandPause(GameWorld gw, Game game, Button button) {
		super("Pause");
		this.gw = gw;
		this.game = game;
		this.button = button;
	}
	
	/**
	 * This method performed the action by calling pressedPause from the Game class. It used a GameWorld class getPaused() to see if the game is paused or not. If the game is
	 * paused, change the text of the pause button to "Play". If the game is unpaused, then it will change the button's text to "Pause". Regardless, it will call pressedPause().
	 * 
	 * @param e declared as an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		// If game is paused
		if (!gw.getPaused()) {
			game.pressedPause();
			button.setText("Play");
		}
		// If game is not paused
		else {
			game.pressedPause();
			button.setText("Pause");
		}
	}
	
}
