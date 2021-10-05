/**
 * This class Game extends the built in form class. The Game constructor then creates an instance of GameWorld and calls the init() method from GameWorld
 * to set the game up to the initial state. To start the game, Game calls the method play() that accepts keyboard inputs from the user in which the input correlates to 
 * appropriate methods in gameWorld that changes the game state.
 * 
 * This class now creates an observer for the map and game/ant state. As well as create commands that the user can interact with in the game 
 * in the form of button or keybinding. This class also has the form divided five areas. One for the score information, three for the commands (buttons), and 
 * the other for the map (not included in this assignment). The regions of the form is divided into west, east, south, north, and center containers
 * in which each container will contain one of the five areas.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

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
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import java.lang.String;
import com.codename1.ui.events.ActionEvent;



public class Game extends Form {
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
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
		Command accelerateCommand = new CommandAccelerate(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command rightCommand = new CommandRight(gw);
		Command leftCommand = new CommandLeft(gw);
		Command flagCollisionCommand = new CommandFlagCollision(gw);
		Command foodStationCollisionCommand = new CommandFoodStationCollision(gw);
		Command spiderCollisionCommand = new CommandSpiderCollision(gw);
		Command tickCommand = new CommandTick(gw);
		Command exitCommand = new CommandExit(gw);
		
		// add to Key Listener which execute on key binding
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('f', foodStationCollisionCommand);
		addKeyListener('g', spiderCollisionCommand);
		addKeyListener('t', tickCommand);
		
		// Create buttons for user to click on 
		
		// Accelerate button
		Button accelerateButton = new Button("Accelerate");
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		// Changing style of button
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginTop(100);
		accelerateButton.getAllStyles().setMarginBottom(0);
		accelerateButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		accelerateButton.getAllStyles().setPadding(BOTTOM, 5);
		accelerateButton.getAllStyles().setPadding(TOP, 5);
		
		// Turn left button
		Button leftButton = new Button("Left");
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);
		// Changing style of button
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setMarginBottom(10);
		leftButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		leftButton.getAllStyles().setPadding(BOTTOM, 5);
		leftButton.getAllStyles().setPadding(TOP, 5);
		
		// Brake Button 
		Button brakeButton = new Button("Brake");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		// Changing style of button
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);
		brakeButton.getAllStyles().setMarginTop(100);
		brakeButton.getAllStyles().setMarginBottom(0);
		brakeButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		brakeButton.getAllStyles().setPadding(BOTTOM, 5);
		brakeButton.getAllStyles().setPadding(TOP, 5);
		
		// Turn right button
		Button rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		// Changing style of button
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);
		rightButton.getAllStyles().setMarginBottom(10);
		rightButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		rightButton.getAllStyles().setPadding(BOTTOM, 5);
		rightButton.getAllStyles().setPadding(TOP, 5);
		
		// Collide with flag button
		Button flagButton = new Button("Collide with Flag");
		flagButton.setCommand(flagCollisionCommand);
		southContainer.addComponent(flagButton);
		// Changing style of button
		flagButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		flagButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		flagButton.getAllStyles().setBgTransparency(255);
		flagButton.getAllStyles().setMarginRight(0);
		flagButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		flagButton.getAllStyles().setPadding(BOTTOM, 5);
		flagButton.getAllStyles().setPadding(TOP, 5);
		
		// Collide with spider button 
		Button spiderButton = new Button("Collide with Spider");
		spiderButton.setCommand(spiderCollisionCommand);
		southContainer.addComponent(spiderButton);
		// Changing style of button
		spiderButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		spiderButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		spiderButton.getAllStyles().setBgTransparency(255);
		spiderButton.getAllStyles().setMarginRight(0);
		spiderButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		spiderButton.getAllStyles().setPadding(BOTTOM, 5);
		spiderButton.getAllStyles().setPadding(TOP, 5);
		
		// Collide with food station button
		Button foodStationButton = new Button("Collide with Food Station");
		foodStationButton.setCommand(foodStationCollisionCommand);
		southContainer.addComponent(foodStationButton);
		// Changing style of button
		foodStationButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		foodStationButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		foodStationButton.getAllStyles().setBgTransparency(255);
		foodStationButton.getAllStyles().setMarginRight(0);
		foodStationButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		foodStationButton.getAllStyles().setPadding(BOTTOM, 5);
		foodStationButton.getAllStyles().setPadding(TOP, 5);
		
		// Tick button
		Button tickButton = new Button("Tick");
		tickButton.setCommand(tickCommand);
		southContainer.addComponent(tickButton);
		// Changing style of button
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);
		tickButton.getAllStyles().setMarginRight(0);
		tickButton.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		tickButton.getAllStyles().setPadding(BOTTOM, 5);
		tickButton.getAllStyles().setPadding(TOP, 5);
		
		// Add accelerate command to side menu
		toolbar.addCommandToSideMenu(accelerateCommand);
		// Add sound check box to the side menu
		Command soundCommand = new CommandSound(gw);
		CheckBox soundCheck = new CheckBox();
		toolbar.addComponentToSideMenu(soundCheck);
		soundCheck.setCommand(soundCommand);
		
		//Add about button in side menu
		Command aboutCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutCommand);
		
		// Add help button to right bar
		Command helpButton = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpButton);

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
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		System.out.println(gw.getMapHeight() + "." + gw.getMapWidth());
		// Initialize GameWorld
		gw.init();
	}
		
}
