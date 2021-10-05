/**
 * This class Ant extends MovableObject and it's methods as well as implements ISteerable interface. This class creates the Ant object that the user
 * controls. It implements the ISteerable interface because the ant can "steer" it's heading. It changes its heading so it can move in the direction 
 * the user wants it to. The size and color are defaulted into a integer value, but only the color can be changed when it has collided with a spider
 * (Color gets lighter). The speed is set to an initial value that can be increased or reduced by the user. The additional attributes of an Ant include 
 * maximumSpeed defined as an int in which an ant's upper limit of it's speed. foodLevel defined as an int shows how hungry the ant is. Over time,
 *  the foodLevel of the ant goes down. If  the foodLevel is 0, then the ant's speed is 0 and cannot move. foodConsumptionRate declared as an int is 
 *  used to decrease the food level of the ant over time. healthLevel declared as an int is the health of the ant which is set to 10. 
 * If a spider collides with an ant, it decreases the healthLevel by one and the healthLevel also determines the maximumSpeed the ant can go to. 
 * Another attribute of an ant is lastFlagReached declared as an int in which checks to see what is the last flag the ant has cleared. 
 * The final attribute of an Ant is boolean isDead which tells the user if the ant is dead or not. If it is set to true, then the ant is "dead".
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Ant extends MovableObject implements ISteerable {

	//Declare variables that are additional attributes for an Ant object
	private int maximumSpeed = 50;
	private int foodLevel = 20;
	private int foodConsumptionRate = 2;
	private int healthLevel = 10;
	private int lastFlagReached = 1;
	private boolean isDead = false;
	
	/**
	 * This constructor method creates the Ant object. The color is set to a defaulted integer value and can only be changed when it has been collided 
	 * with a spider (Color gets lighter). The parameters float xLocation and yLocation are passed to set X values and Y values
	 * that creates the Point location for the Ant object. The size is also set to a default integer value that cannot change. The speed is set to an 
	 * initial value that can be changed if the user wants to increase or decrease the speed. It uses the super keyword to use their parent's 
	 * method to set the speed. Finally, it uses the super keyword to use the parent class's method to set the ant's initial heading to 0.
	 * 
	 * @param xLocation declared as a float, used for the x value of the location of the object (Defined at 0 by the user)
	 * @param yLocation declared as a float, used for the x value of the location of the object (Defined at 0 by the user
	 */
	public Ant(float xLocation, float yLocation) {
		//Super method from MovableObject to set the ant's heading to 0
		super(0);
		this.setXLocation(xLocation);
		this.setYLocation(yLocation);
		this.setSize(40);
		super.setSpeed(0);
		this.setColor(ColorUtil.YELLOW);
		this.setIsDead(false);
	}
	
	/**
	 * This method is from the interface ISteerable. This method allows the ant's heading to updated when the user wants to change the ant's 
	 * heading. It adds the parameter headingChange to the current heading which comes up with the new heading for the ant
	 * 
	 * @param headingChange declared as an int
	 */
	public void steerHeading(int headingChange) {
		this.setHeading(this.getHeading() + headingChange);
		//If the new heading less than 0, then set the current heading to 359 then minus the headingChange because can't have negative heading
		//Used for if the user is turning left at 0 heading (Complete 360 turn)
		if(this.getHeading() < 0) {
			this.setHeading(359 + headingChange);
		}
		//If new heading is greater than or equal to 359, then set the current heading to 0 and add the remaining headChange because cannot have heading over 359.
		//This is used when user is turning right (Complete 360 turn)
		else if(this.getHeading() > 359) {
			this.setHeading(0);
			this.setHeading(this.getHeading() + headingChange);
		}
	}
	
	/**
	 * This setter method sets the ant's speed. First it checks if the user is trying to go over the ant's maximum speed. If it does, the user is prompted
	 * with a message stating it cannot go over the maximum speed. If not then the method will set the ant's new speed. Uses super keyword to use
	 * parent's method to set the speed.
	 * 
	 * @param speed declared as an int
	 */
	public void setAntSpeed(int speed) {
		if (speed <= this.maximumSpeed) {
			super.setSpeed(speed);
		}
		else {
			System.out.println("This speed is over the maximum speed. Does not work.");
		}
		// If ant's speed below zero
		if (this.getSpeed() < 0) {
			super.setSpeed(0);
		}
	}
	
	/**
	 * Setter method that sets the maximumSpeed of the ant. Can be changed when it collides with a spider
	 * 
	 * @param maximumSpeed declared as an int
	 */
	public void setMaximumSpeed(int maximumSpeed) { 
		this.maximumSpeed = maximumSpeed;
	}
	
	/**
	 * Setter method that sets the foodLevel of the ant. Changes over time 
	 *  
	 * @param foodLevel declared as an int
	 */
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	/**
	 * Setter method that sets the foodConsumptionRate of the ant
	 * 
	 * @param foodConsumptionRate declared as an int
	 */
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}
	
	/**
	 * Setter method that sets the healthLevel of the ant. Changes when it collides with a spider
	 * 
	 * @param healthLevel declared as an int
	 */
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	
	/**
	 * Setter method that sets the lastFlagReached that ant has reached so far
	 * 
	 * @param lastFlagReached declared as an int
	 */
	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}
	
	/** 
	 * Setter method that sets the boolean isDead true or false. This sets if the ant is dead or not
	 * 
	 * @param isDead declared as a boolean
	 */
	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	/**
	 * Getter method that returns the maximumSpeed of the ant 
	 *  
	 * @return maximumSpeed declared as an int
	 */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	
	/**
	 * Getter method that returns the foodLevel of the ant
	 * 
	 * @return foodLevel declared as an int
	 */
	public int getFoodLevel() {
		return foodLevel;
	}
	
	/**
	 * Getter method that returns the foodConsumptionRate of the ant
	 * 
	 * @return foodConsumptionRate declared as an int
 	 */
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	
	/**
	 * Getter method that returns the healthLevel of the ant
	 * 
	 * @return healthLevel declared as an int
	 */
	public int getHealthLevel() {
		return healthLevel;
	}
	
	/**
	 * Getter method that returns the lastFlagReached of an ant. Used to check which is the last flag the ant has reached so far
	 * 
	 * @return lastFlagReached declared as an int
	 */
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	
	/**
	 * Getter method that returns the boolean variable isDead. This is used to check if the ant is dead of not
	 * 
	 * @return isDead declared as a boolean. Used to check if the ant is dead or not 
	 */
	public boolean getIsDead() {
		return isDead;
	}
	
	/**
	 * This method is used to check the health levels and food levels of the ant. If the health level or food levels is 0, it cannot move.
	 * Since it can not move, the variable isDead is set true to make the ant object "dead".
	 */
	public void checkHealthLevel() {
		if (this.getHealthLevel() <= 0) {
			this.isDead = true;
		}
		if (this.getFoodLevel() <= 0) {
			this.setSpeed(0);
			this.isDead = true;
		}
	}
	
	/**
	 * This method is used to update the ant's maximumSpeed when it has collided with a spider. This method is used to help 
	 * the method collisionSpider(). It uses an equation to help calculate the new max speed and then uses the setMaximumSpeed() to 
	 * set the value.
	 */
	public void updateAntMaxSpeed() {
		// Equation to calculate the new maximumSpeed
		double newMaxSpeed = (this.getMaximumSpeed() * (this.getHealthLevel() * 0.1));
		// Forces the double newSpeed to become an int
		this.setMaximumSpeed((int) newMaxSpeed);
		this.checkHealthLevel();
	}
	
	/**
	 * This method is used when the game clock is ticked. When the game clock is ticked, this method is called to reduce the food level of the ant
	 * by the foodConsumptionRate. If the food level is at 0, the ant's speed level is set 0 by the game rules 
	 */
	public void reduceFoodLevel() {
		foodLevel = foodLevel - foodConsumptionRate;
		if(foodLevel == 0) {
			this.setAntSpeed(0);
		}
	}
	
	/**
	 * This method is used when the ant has collided with Spider object. When called, it will reduce the ant's health level by one and also fade the color
	 * of the ant (make it lighter). Finally, it will update the maximumSpeed that ant can go to (Example if ant's health level is 5 then it can only
	 * go to 50% of the max speed). It calls updateAntMaxSpeed() method to update the max speed.
	 */
	public void collisionSpider() {
		this.healthLevel = healthLevel - 1;
		this.setColor(ColorUtil.rgb(255 - (20 * (10 - this.getHealthLevel())), 0, 0));
		this.updateAntMaxSpeed();
		// If the ant's previous speed is greater than new max speed, update it
		if(this.getSpeed() > this.getMaximumSpeed()) {
			this.setSpeed(this.getMaximumSpeed());
		}
	}
	
	/**
	 * This method antReset() resets the ant's heading, speeding, lastflagReached, X and Y values of it's location, healthLevel, foodLevel, and color
	 * back to its original state as if it just started the game again.
	 */
	public void antReset() {
		this.setHeading(0);
		this.setSpeed(0);
		this.setMaximumSpeed(50);
		this.setLastFlagReached(1);
		this.setXLocation(100);
		this.setYLocation(100);
		this.setHealthLevel(10);
		this.setFoodLevel(20);
		this.setIsDead(false);
		this.setColor(ColorUtil.YELLOW);
	}
	
	/**
	 * This String toString method overrides the parent's toString method. This toString methods includes additional description of a Ant object that
	 * includes maxSpeed and foodConsumption.
	 * 
	 * @return description of a FoodStation object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDesc1 = "\n     maxSpeed=" + getMaximumSpeed() + " foodConsumptionRate=" + getFoodConsumptionRate();
		String myDesc2 = "Ant: ";
		return myDesc2 + parentDesc + myDesc1;
	}

}
