/**
 * This class Game extends the built in form class. The Game constructor then creates an instance of GameWorld and calls the init() method from GameWorld
 * to set the game up to the initial state. To start the game, Game calls the method play() that accepts keyboard inputs from the user in which the input correlates to 
 * appropriate methods in gameWorld that changes the game state.
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 


public class Game extends Form {
	
	private GameWorld gw;
	private boolean toQuit = false;
	/**
	 *  This method Game creates the instance of GameWorld and then calls the init() method from GameWorld to set up the initial state of the game.
	 *  Then it calls play() to start up the game that accepts keyboard input. Keyboard inputs correlates to certain methods in GameWorld that can change
	 *  the game state.
	 */
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	/**
	 * This method play allows the user to interact with the game by inputting valid keyboard commands. Each valid keyboard input changes the game state.
	 * 
	 */
	private void play() {
		Label myLabel=new Label("Enter a Command:");    
		this.addComponent(myLabel);      
		final TextField myTextField=new TextField();    
		this.addComponent(myTextField);      
		this.show();
		
		myTextField.addActionListener(new ActionListener() {  
			
			public void actionPerformed(ActionEvent evt) { 
				String sCommand=myTextField.getText().toString();          
				myTextField.clear(); 
				// If user wants to quit
				if(toQuit == true) {
					switch(sCommand.charAt(0)) {
					//If 'y' is entered, game will end.
					case 'y':
						System.exit(0);
						break;
					//If 'n' is entered, game will continue.
					case 'n':
						System.out.println("Game will continue.");
						toQuit = false;
						break;
					}
					return;
				}
				if(sCommand.length() != 0) 
					switch (sCommand.charAt(0)) {
						// The rest of the game commands that can change the game state. Once the user hits the keyboard command,
						// it will call the appropriate method from GameWorld.
						case 'a':
							//If user wants to increase speed.
							gw.accelerate();
							break;
							//If user wants to reduce speed.
						case 'b':
							gw.brake();
							break;
							//If user collides with a flag 1-9
						case 'l':
							gw.left();
							break;
						case 'r':
							gw.right();
							break;
						case '1':
							gw.flagCollision(1);
							break;
						case '2':
							gw.flagCollision(2);
							break;
						case '3':
							gw.flagCollision(3);
							break;
						case '4':
							gw.flagCollision(4);
							break;
						case '5':
							gw.flagCollision(5);
							break;
						case '6':
							gw.flagCollision(6);
							break;
						case '7':
							gw.flagCollision(7);
							break;
						case '8':
							gw.flagCollision(8);
							break;
						case '9':
							gw.flagCollision(9);
							break;
							//If user collides with a food station
						case 'f':
							gw.foodStationCollision();
							break;
							//If user collides with a spider
						case 'g':
							gw.spiderCollision();
							break;
							//Game clock increases
						case 't':
							gw.clockTick();
							break;
							//Displays user the ant's info
						case 'd':
							gw.display();
							break;
							//Shows the user the map in text form
						case 'm':
							gw.map();
							break;
							//If user wants to exit the game
						case 'x':
							System.out.println("Do you want to quit the game? 'y' for yes or 'n' for no.");
							toQuit = true;
							break;
						default:
							System.out.println("Please enter a valid keyboard input.");
					}
			}
		
	}
);
}
}
