/**
 * This ScoreView class is an observer of the GameWorld class. The ScoreView will produce a new output of the data it is observing which is the game world 
 * objects. In this case, ScoreView will output the current game/ant state information.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer {
	
	private GameWorld model;
	
	// Declaration of labels
	private Label clockLabel;
	private Label clockValue;
	private Label livesLabel;
	private Label livesValue;
	private Label lastFlagReachedLabel;
	private Label lastFlagReachedValue;
	private Label healthLevelLabel;
	private Label healthLevelValue;
	private Label foodLevelLabel;
	private Label foodLevelValue;
	private Label soundLabel;
	private Label soundValue;
	
	/**
	 * 
	 * 
	 * @param myModel declared as an Observable
	 */
	public ScoreView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		// Set the layout of the score view 
		this.setLayout(new FlowLayout(Component.CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.WHITE));
		
		// Add labels to GUI
		this.setUpLabels();
		this.add(clockLabel);
		this.add(clockValue);
		this.add(livesLabel);
		this.add(livesValue);
		this.add(lastFlagReachedLabel);
		this.add(lastFlagReachedValue);
		this.add(healthLevelLabel);
		this.add(healthLevelValue);
		this.add(foodLevelLabel);
		this.add(foodLevelValue);	
		this.add(soundLabel);
		this.add(soundValue);
		
	}
	
	/**
	 * 
	 * 
	 */
	public void setUpLabels() {
		// Labels for the north container. This will go under the game name.
		// Clock/Game time label
		clockLabel = new Label("Time: ");
		clockValue = new Label("" + model.getClock());
		clockLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		clockValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//Lives the user has left label
		livesLabel = new Label("Lives Left: ");
		livesValue = new Label("" + model.getLives());
		livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//Last flag reached ant has reached label
		lastFlagReachedLabel = new Label("Last Flag Reached: ");
		lastFlagReachedValue = new Label("" + model.getLastFlagReached());
		lastFlagReachedLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		lastFlagReachedValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		// Food level of the ant label
		foodLevelLabel = new Label("Food Level: ");
		foodLevelValue = new Label("" + model.getFoodLevel());
		foodLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		foodLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		// Health level of the ant label
		healthLevelLabel = new Label("Health Level: ");
		healthLevelValue = new Label("" + model.getHealthLevel());
		healthLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		healthLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		// Sound label
		soundLabel = new Label("Sound: ");
		soundValue = new Label("" + model.isSound());
		soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
	}
	
	/**
	 * This updateLabels method will update the clock, lives left, last flag reached, food level, health level , and sound check values as the game 
	 * goes on. This will use the revalidate() to tell the layout manager to reset based on the new value.
	 * 
	 */
	public void updateLabels() {
		clockValue.setText("" + model.getClock());
		clockValue.getParent().revalidate();
		livesValue.setText("" + model.getLives());
		livesValue.getParent().revalidate();
		lastFlagReachedValue.setText("" + model.getLastFlagReached());
		lastFlagReachedValue.getParent().revalidate();
		foodLevelValue.setText("" + model.getFoodLevel());
		foodLevelValue.getParent().revalidate();
		healthLevelValue.setText("" + model.getHealthLevel());
		healthLevelValue.getParent().revalidate();
		soundValue.setText("" + model.isSound());
		soundValue.getParent().revalidate();

	}
	/**
	 * Update method that updates the labels from the game/ant state data.
	 * 
	 * @param o declared as an Observable
	 * @param arg declared as an Object
	 */
	public void update (Observable o, Object arg) {
		this.updateLabels();
		
	}

}
