/** This class Game extends the built in form class. The Game constructor then creates an instance of GameWorld and calls the init() method from GameWorld
 * to set the game up to the initial state. To start the game, Game calls the method play() that accepts keyboard inputs from the user in which the input correlates to 
 * appropriate methods in gameWorld that changes the game state.
 * 
 * This class now creates an observer for the map and game/ant state. As well as create commands that the user can interact with in the game 
 * in the form of button or keybinding. This class also has the form divided five areas. One for the score information, three for the commands (buttons), and 
 * the other for the map (not included in this assignment). The regions of the form is divided into west, east, south, north, and center containers
 * in which each container will contain one of the five areas.
 * 
 * For A3, the game has removed the spider, food station, flag collision commands/buttons/key bindings because those assumed collision. This game now detects collision so 
 * those commands/buttons/key bindings are not needed. This game still has the commands/buttons/key bindings accelerate, brake, right, and left. Now there are 
 * two new commands/buttons which are pause which will pause the game and position which can select a food station or flag and move it to a new location. The game
 * is now controlled by a timer that will drive the animations which will invoke the tick method in GameWorld. There are also methods that will control the sounds
 * for when the user collides with a spider, food station, or flag.
 *
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
*/

package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import java.lang.String;
import com.codename1.ui.events.ActionEvent;

public class Game extends Form implements Runnable {
	
	// Declare variables
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	// Declare commands
	private Command accelerateCommand;
	private Command brakeCommand;
	private Command rightCommand;
	private Command leftCommand;
	private Command exitCommand;
	private Command pauseCommand;
	private Command positionCommand;
	private Command aboutCommand;
	private Command helpCommand;
	private Command soundCommand;
	// Declare buttons
	private Button accelerateButton;
	private Button accelerateMenuButton;
	private Button brakeButton;
	private Button rightButton;
	private Button leftButton;
	private Button exitButton;
	private Button pauseButton;
	private Button positionButton;
	private Button helpButton;
	private CheckBox soundCheck;
	private UITimer timer;
	private final int tickRate = 20;
	
	public Game() {
		// Create "Observable" GameWorld
		gw = new GameWorld();
		// Create an "Observer" for the map
		mv = new MapView(gw);
		// Create an "Observer" for the game/ant state data
		sv = new ScoreView(gw);
		// Register the map observer
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		// Set up the title of the game
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("ThePath Game");
		
		// Creating West container
		Container westContainer = new Container();
		westContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		westContainer.setLayout(new BoxLayout(2));
		
		// Creating East container
		Container eastContainer = new Container();
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		eastContainer.setLayout(new BoxLayout(2));
		
		// Creating South container
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		
		// Creating the commands for the game
		accelerateCommand = new CommandAccelerate(gw);
		brakeCommand = new CommandBrake(gw);
		rightCommand = new CommandRight(gw);
		leftCommand = new CommandLeft(gw);
		positionCommand = new CommandPosition(gw);
		exitCommand = new CommandExit(gw);
		
		// add to Key Listener which execute on key binding
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('l', leftCommand);
		
		// Create buttons for user to click on 
		
		// Accelerate button
		accelerateButton = new Button("Accelerate");
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		// Changing style of button
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setMarginTop(100);
		accelerateButton.getAllStyles().setMarginBottom(0);
		accelerateButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		accelerateButton.getAllStyles().setPadding(BOTTOM, 5);
		accelerateButton.getAllStyles().setPadding(TOP, 5);
		
		//Accelerate Menu Button
		accelerateMenuButton = new Button("Accelerate");
		accelerateMenuButton.setCommand(accelerateCommand);
	
		// Turn left button
		leftButton = new Button("Left");
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);
		// Changing style of button
		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setMarginBottom(10);
		leftButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		leftButton.getAllStyles().setPadding(BOTTOM, 5);
		leftButton.getAllStyles().setPadding(TOP, 5);
		
		// Brake Button 
		brakeButton = new Button("Brake");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		// Changing style of button
		brakeButton.getAllStyles().setBgTransparency(255);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setMarginTop(100);
		brakeButton.getAllStyles().setMarginBottom(0);
		brakeButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		brakeButton.getAllStyles().setPadding(BOTTOM, 5);
		brakeButton.getAllStyles().setPadding(TOP, 5);
		
		// Turn right button
		rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		// Changing style of button
		rightButton.getAllStyles().setBgTransparency(255);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setMarginBottom(10);
		rightButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		rightButton.getAllStyles().setPadding(BOTTOM, 5);
		rightButton.getAllStyles().setPadding(TOP, 5);
		
		// Pause Button
		pauseButton = new Button("Pause");
		pauseCommand = new CommandPause(gw, this, pauseButton);
		pauseButton.setCommand(pauseCommand);
		southContainer.addComponent(pauseButton);
		// Changing style of button
		pauseButton.getAllStyles().setBgTransparency(255);
		pauseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setMarginRight(0);
		pauseButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		pauseButton.getAllStyles().setPadding(BOTTOM, 5);
		pauseButton.getAllStyles().setPadding(TOP, 5);
		
		// Position Button 
		positionButton = new Button("Position");
		positionButton.setCommand(positionCommand);
		southContainer.addComponent(positionButton);
		// Changing style of button
		positionButton.getAllStyles().setBgTransparency(255);
		positionButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setMarginRight(0);
		positionButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		positionButton.getAllStyles().setPadding(BOTTOM, 5);
		positionButton.getAllStyles().setPadding(TOP, 5);
		
		// Add accelerate command to side menu
		toolbar.addComponentToSideMenu(accelerateMenuButton);
		// Add sound check box to the side menu
		soundCommand = new CommandSound(gw);
		soundCheck = new CheckBox();
		toolbar.addComponentToSideMenu(soundCheck);
		soundCheck.setCommand(soundCommand);
		
		//Add about button in side menu
		aboutCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutCommand);
		
		// Add help button to right bar
		helpCommand = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpCommand);

		// Add exit button on side menu
		toolbar.addCommandToSideMenu(exitCommand);
		
		// Add containers
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		this.show();
		// Set the GameWorld's height and width to the height and width of MapView
		gw.setMapHeight(mv.getHeight() - mv.getX());
		gw.setMapWidth(mv.getWidth() - mv.getY());
		// Initialize GameWorld
		System.out.println(mv.getX() + "," + mv.getY());
		gw.init();		
		gw.createSounds();
		revalidate();
		timer = new UITimer(this);
		timer.schedule(tickRate, true, this);
	}
	
	/**
	 * This method is implemented by Runnable. This is called each timer tick. This method will call clockTick from GameWorld class that will update the game.
	 * 
	 */
	public void run() {
		gw.clockTick(tickRate);
		// If the user turns on sound
		if(gw.getSoundChecked()) {
			gw.turnOnSound();
		}
		// If the user turns off sound
		else if(!gw.getSoundChecked()) {
			gw.turnOffSound();
		}
			
	}
	
	/**
	 * This method will pause or unpause the game depending if the user has clicked on the pause button. If the user presses the pause button, then the timer will stop and all the commands/
	 * buttons/key bindings will be disabled besides the position command. If the game is unpaused, the timer will resume and all commands/buttons/key bindings will be enabled. Also the 
	 * background sound will be on if the game is paused or unpaused.
	 * 
	 */
	public void pressedPause() {
		// If game is paused 
		if(!gw.getPaused()) {
			// Stop the timer
			timer.cancel();
			//Remove key bindings
			removeKeyListener('a', accelerateCommand);
			removeKeyListener('b', brakeCommand);
			removeKeyListener('r', rightCommand);
			removeKeyListener('l', leftCommand);
			// Disable commands
			accelerateCommand.setEnabled(false);
			brakeCommand.setEnabled(false);
			rightCommand.setEnabled(false);
			leftCommand.setEnabled(false);
			positionCommand.setEnabled(true);
			aboutCommand.setEnabled(false);
			helpCommand.setEnabled(false);
			soundCommand.setEnabled(false);
			// Disable buttons
			accelerateButton.setEnabled(false);
			accelerateMenuButton.setEnabled(false);
			brakeButton.setEnabled(false);
			rightButton.setEnabled(false);
			leftButton.setEnabled(false);
			soundCheck.setEnabled(false);
			positionButton.setEnabled(true);
			// Change style of disabled button 
			accelerateButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
			leftButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
			brakeButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
			rightButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
			// Turn off background sound
			gw.turnOffSound();
			gw.setPause(!gw.getPaused());
		}
		else {
			// Resume timer
			timer.schedule(tickRate, true, this);
			// Add key bindings
			addKeyListener('a', accelerateCommand);
			addKeyListener('b', brakeCommand);
			addKeyListener('r', rightCommand);
			addKeyListener('l', leftCommand);
			// Enable commands
			accelerateCommand.setEnabled(true);
			brakeCommand.setEnabled(true);
			rightCommand.setEnabled(true);
			leftCommand.setEnabled(true);
			positionCommand.setEnabled(false);
			aboutCommand.setEnabled(true);
			helpCommand.setEnabled(true);
			soundCommand.setEnabled(true);
			// Enable buttons
			accelerateButton.setEnabled(true);
			accelerateMenuButton.setEnabled(true);
			brakeButton.setEnabled(true);
			rightButton.setEnabled(true);
			leftButton.setEnabled(true);
			soundCheck.setEnabled(true);
			positionButton.setEnabled(false);
			// Turn on background sound
			gw.turnOnSound();
			gw.setPause(!gw.getPaused());
		}
	}
	
}


	
	
	
	

