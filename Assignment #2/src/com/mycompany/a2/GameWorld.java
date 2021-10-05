/**
 * This class GameWorld is where all of the game objects, ant, spider, flag, and food station, are created for this game. 
 * This also includes all the methods that can change the state of the game. This class contains the collection which aggregates the abstract type GameObject. 
 * 
 * This class now uses GameObjectCollection class to create list that will hold the collection of game objects. Any method that need to process
 * the game objects in the collection will use an iterator.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import java.util.Observable;

public class GameWorld extends Observable {
	
	// Declare variables that will be used for the game.
	private int lives = 3;
	private int clock = 0;
	Random rand = new Random();
	private int lastFlag = 4;
	private boolean soundChecked = false;
	// Declare GameObjectCollection list that will store the game objects 
	private GameObjectCollection list;
	private Ant ant = new Ant(100, 100);
	// Declare variables that are the dimensions of the game world
	private int mapHeight;
	private int mapWidth;
	
	public GameWorld() {
		list = new GameObjectCollection();
	}
		
	
	public void init() {
		//Call the methods that will create the game objects.
		addFlags();
		addAnt();
		addSpider();
		addSpider();
		addFoodStation();
		addFoodStation();
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * This method addFlags creates the four flag objects that will have set location. Their location will never change.
	 * It is then added into the list.
	 */
	public void addFlags() {
		list.add(new Flag(100, 100, 1));
		list.add(new Flag(300, 400, 2));
		list.add(new Flag(200, 500, 3));
		list.add(new Flag(400, 700, 4));
	}
	
	/**
	 * This method will add the one ant object into the list that the user will control.
	 */
	public void addAnt() {
		list.add(ant);
	}
	
	/**
	 * This method addFoodStation will add one food station with a random location and size into the list.
	 * It will get it's random location by calling randomX() to get the x point and randomY() to 
	 * get the y point. It will also call randomSize() to get it's size.
	 */
	public void addFoodStation() {
		list.add(new FoodStation(randomX(), randomY(), randomSize()));
	}
	
	/**
	 *  This method addSpider will add one spider with a random location, speed, size and heading into the list.
	 *  It will get its location, speed, size, and heading from the appropriate methods: randomX(), randomY(),
	 *  randomSpeed, randomSize(), and randomHeading().
	 */
	public void addSpider() {
		list.add(new Spider(randomX(), randomY(), randomSpeed(), randomSize(), randomHeading()));
	}
	
	/**
	 * This method generates a random X point from 0 to mapview's width using the class java.util.Random that will be used for the location of the spider and food station. 
	 * It will then return it's value
	 * 
	 * @return randomNum that will be used the for x-coordinate.
	 */
	public float randomX() {
		float randomNum = rand.nextInt((this.getMapWidth() - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method generates a random Y point from 0 to mapview's height using the class java.util.Random that will be used for the location of the spider and food station. 
	 * It will then return it's value
	 * 
	 * @return randomNum that will be used the for y-coordinate.
	 */
	
	public float randomY() {
		float randomNum = rand.nextInt((this.getMapHeight() - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method generates a random speed value from 5-10 using the class java.util.Random that will be used for speed of the spider. It will then return it's value
	 * 
	 * @return randomNum that will be used the speed of the spider.
	 */
	public int randomSpeed() {
		int randomNum = rand.nextInt((10 - 5) + 1) + 5;
		return randomNum;
	}
	
	/**
	 * This method generates a random size value from 10-50 using the class java.util.Random that will be used forthe size of spider and food station. 
	 * It will then return it's value
	 * 
	 * @return randomNum that will be used the size of the spider and food station.
	 */
	public int randomSize() {
		int randomNum = rand.nextInt((50 - 10) + 1) + 10;
		return randomNum;
	}
	
	/**
	 * This method generates a random speed value from 0-359 using the class java.util.Random that will be used for the heading of the spider. 
	 * It will then return it's value
	 * 
	 * @return randomNum that will be used the heading of the spider.
	 */
	public int randomHeading() {
		int randomNum = rand.nextInt((359 - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method accelerate is used when the user hits the 'a' keyboard key. Once this is called, it increases the speed of the ant by 3.
	 * Then lets the user know that it was increased successfully. This is done by calling methods from the Ant class that sets the ant's new 
	 * speed and the method that gets the ant's speed and then increases the ant's original speed by 3. Then it calls setChanged() which will call 
	 * the update() method in its observers. Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 */
	public void accelerate() {
		int increaseSpeed = 5;
		System.out.println("Updating ant's speed.");
		//Uses methods from Ant class to update the ant's speed.
		ant.setAntSpeed(ant.getSpeed() + increaseSpeed);
		if(ant.getSpeed() < ant.getMaximumSpeed()) {
			System.out.println("Ant's speed has been increased by 5.");
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method brake is used when the user hits the 'b' keyboard key. Once this is called, it reduces the speed of the ant by 3.
	 * Then lets the user know that it was reduced successfully. This is done by calling methods from the Ant class that sets the ant's new 
	 * speed and the method that gets the ant's speed and then subtracts the ant's original speed by 3. Then it calls setChanged() which will call 
	 * the update() method in its observers. Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 */
	public void brake() {
		int reduceSpeed = 5;
		// Uses methods from Ant class to update the ant's speed.
		ant.setAntSpeed(ant.getSpeed() - reduceSpeed);
		System.out.println("Ant's speed has been reduced by 5.");
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method left is used when the user hits the 'l' keyboard key. Once this is called , it changes the ant's heading by -5 so that 
	 * it could turn left or head west. Then it lets the user know that it turned left successfully. This methods calls another method the
	 * ant class that will update the heading of the ant. Then it calls setChanged() which will call the update() method in its observers. 
	 * Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 */
	public void left() {
		int turnLeft = -5;
		// Uses steerHeading method from Ant class to update the heading of the ant.
		ant.steerHeading(turnLeft);
		System.out.println("Ant has turned left successfully.");
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method right is used when the user hits the 'r' keyboard key. Once this is called , it changes the ant's heading by 5 so that 
	 * it could turn right or head east. Then it lets the user know that it turned right successfully. This methods calls another method 
	 * the ant class that will update the heading of the ant. Then it calls setChanged() which will call the update() method in its observers. 
	 * Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 */
	public void right() {
		int turnRight = 5;
		// steerHeading method from Ant class to change the heading of the ant.
		ant.steerHeading(turnRight);
		System.out.println("Ant has turned right successfully.");
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method spiderCollision is used the when the user hits the 'g' keyboard key. For now we are to pretend that the ant has collided with the spider. 
	 * This then calls the collisionSpider() method from the Ant class that will reduce the health level of the ant and change the color of the ant slightly 
	 * that will let the user know. Then it calls setChanged() which will call the update() method in its observers. Then it calls notifyObservers which is a 
	 * built in Observable class method that will produce a new output
	 */
	public void spiderCollision() {
		// Calls collisionSpider() from Ant class to reduce the health level of the ant and change the color of the ant.
		ant.collisionSpider();
		System.out.println("Ant has collided with a spider.");
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method foodStationCollision is used when the user hits the 'f' keyboard key. For now we are to pretend that the ant has collided with 
	 * the food station. This will increase the ant's food level. Uses an iterator to go the GameObjectCollection list to find a Food Station to collide with.
	 * Then it calls setChanged() which will call the update() method in its observers. 
	 * Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 */
	public void foodStationCollision() {
		// Pretends it collided with a food station.
		GameObject foodStation = null;
		IIterator itr = list.getIterator();
		while(itr.hasNext()) {
			GameObject f = (GameObject) itr.getNext();
			if (f instanceof FoodStation) {
				if(((FoodStation) f).getCapacity() != 0) {
					foodStation = f;
				}
			}
		}
		ant.setFoodLevel(ant.getFoodLevel() + ((FoodStation) foodStation).getCapacity());
		// After ant has received food, the food station's capacity is set to 0.
		((FoodStation) foodStation).setCapacity(0);
		// Then the food station's color is changed to light green as it fades.
		((FoodStation) foodStation).setColor(ColorUtil.rgb(0, 120, 0));
		// Adds a new food station with a random size and location.
		list.add(new FoodStation(randomX(),randomY(), randomSize()));
		System.out.println("Ant has collided with the food station successfully.");
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method is called when the user hits the key 'a number 1-9' from the keyboard. Each number 1-9 represents a flag that the ant has collided.
	 * The user must collide with the flags in numeric order. First it checks with the flag number x that the ant collided and the last flag that the ant
	 * has reached. If the flag number x is exactly one greater than the last flag reached then it will update the lastFlagReached(). If not, then the 
	 * user will be prompted to go in numeric order. Then it calls setChanged() which will call the update() method in its observers. Then it calls 
	 * notifyObservers which is a built in Observable class method that will produce a new output
	 * 
	 * @param flagNumber from 1-9 that the user inputs
	 */
	public void flagCollision(int flagNumber) {
		System.out.println("Colliding with flag " + flagNumber);
		// Check to see if flag number x is exactly one  greater than the flag.
		if(flagNumber - ant.getLastFlagReached() == 1) {
			// If so, then it will update the lastFlagReached.
			ant.setLastFlagReached(flagNumber);
			System.out.println("Collision with flag " + flagNumber + " has occurred sucessfully.");
		}
		//If not then the user will be prompted to go in numeric order.
		else {
			System.out.println("You must go in numeric order one by one.");
		}
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * This method lets the game world know that the game clock has ticked. A game clock tick will update the spider's heading, update all movable 
	 * object's heading and speed, reduce the ant's food level by it's food consumption rate. Also checks to see if the user's lives were 0. 
	 * If so, then the game will be over. If the user has reached all four flags, then the game will be over where the user wins. It uses the iterator to
	 * go through the GameObjectCollection list to find the spider and movable objects to update it's headings and move them.
	 * Then it calls setChanged() which will call the update() method in its observers. Then it calls notifyObservers which is a built in 
	 * Observable class method that will produce a new output
	 */
	public void clockTick() {
		//Increase game clock by 1.
		clock ++;
		//Update the spider's heading.
		IIterator itr = list.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = (GameObject) itr.getNext();
			if(tempObject instanceof Spider ) {
				((Spider) tempObject).randomHeading();
			}
			//Update all movable objects' speed and heading.
			if(tempObject instanceof MovableObject) {
				((MovableObject) tempObject).move();
			}
		}
		// If Spider is out of bounds, update heading and move the spider
		IIterator itr2 = list.getIterator();
		while(itr2.hasNext()) {
			GameObject tempObject2 = (GameObject) itr2.getNext();
			if(tempObject2 instanceof Spider) {
				while(((Spider) tempObject2).getXLocation() > this.getMapWidth() || ((Spider) tempObject2).getXLocation() < 0|| 
						((Spider) tempObject2).getYLocation() > this.getMapHeight() || ((Spider) tempObject2).getYLocation() < 0) {
				((Spider) tempObject2).randomHeading();
				((Spider) tempObject2).move();
				}
			}			
		}
		// If Ant goes out of bounds, update heading and move the ant
		IIterator itr3 = list.getIterator();
		while(itr3.hasNext()) {
			GameObject tempObject3 = (GameObject) itr3.getNext();
			if(tempObject3 instanceof Ant) {
				// If ant's moves left out of bounds (X location is less than 0)
				while(((Ant) tempObject3).getXLocation() < 0) {
					((Ant) tempObject3).setHeading(90);
					((Ant) tempObject3).move();
				}
				// If ant's moves right out of bounds (X location is more than map's width)
				while(((Ant) tempObject3).getXLocation() > this.getMapWidth()) {
					((Ant) tempObject3).setHeading(270);
					((Ant) tempObject3).move();
				}
				// If ant's moves down out of bounds (Y location is less than 0)
				while(((Ant) tempObject3).getYLocation() < 0) {
					((Ant) tempObject3).setHeading(0);
					((Ant) tempObject3).move();
				}
				// If ant's moves up out of bounds (Y location is more than map's height)
				while(((Ant) tempObject3).getYLocation() > this.getMapHeight()) {
					((Ant) tempObject3).setHeading(180);
					((Ant) tempObject3).move();
				}
			}
		}
		//Reduce the ant's food level with it's food consumption rate.
		ant.reduceFoodLevel();
		//If the ant is dead, the user loses the life.
		ant.checkHealthLevel();
		if(ant.getIsDead() == true) {
			lives = lives - 1;
			ant.antReset();
		}
		System.out.println("Clock has been ticked successfully");
		//If the user's lives were 0, then game is over, user loses.
		if(lives == 0) {
			System.out.println("Game over, you failed!");
			System.exit(0);
		}
		//If the user reaches the four flag, then they win.
		if(ant.getLastFlagReached() == lastFlag) {
				System.out.println("Game over, you win! Total time: " + this.clock);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method is called when the user enters 'd' from the keyboard. It then displays: number of lives left, current clock time, highest flag number that the ant has
	 * reached, ant's current food level, and ant's current health level.
	 */
	public void display() {
		System.out.println("Number of lives left: " + lives);
		System.out.println("Current clock value: " + clock);
		System.out.println("Highest flag number reached: " + ant.getLastFlagReached());
		System.out.println("Ant's current food level: " + ant.getFoodLevel());
		System.out.println("Ant's current health level: " + ant.getHealthLevel());
	}
	
	/**
	 * This method checks to see if the user has checked the sound box from the side menu. If the user clicks on it, this method will return 
	 * "ON" meaning the sound is on. If the user does not click on it, then the method will return "OFF" meaning sound is off.
	 * 
	 * @return String containing "ON" or "OFF" depending if user wants sound on or off
	 */
	public String isSound() {
		if(this.soundChecked) {
			return "ON";
		}
		else {
			return "OFF";
		}
	}
	
	/**
	 * This method will toggle the sound when the user clicks on it on or off. Then it calls setChanged() which will call 
	 * the update() method in its observers. Then it calls notifyObservers which is a built in Observable class method that will produce a new output
	 * 
	 */
	public void toggleSound() {
		this.soundChecked = !(this.soundChecked);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method is called when the user enters 'm' from the keyboard. It then output a "map" in text form. It then uses the toString methods from the GameObject class.
	 * It displays the description of all the objects in the game. Uses the iterator to go through the GameObjectCollection list to print out each game object
	 * in the list until there is none left.
	 */
	public void map() {
		System.out.println();
		IIterator itr = list.getIterator();
		while (itr.hasNext()) {
			GameObject tempObject = (GameObject) itr.getNext();
			System.out.println(tempObject.toString());
		}		
	}
	/**
	 * Getter method that will return thats the lives left of the user.
	 * 
	 * @return lives declared as an int 
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Getter method that will return the game clock value.
	 * 
	 * @return clock declared as an int
	 */
	public int getClock() {
		return clock;
	}
	
	/**
	 * Getter method that will return the ant's last flag that the user has reached so far. Uses iterator to go through the GameObjectCollection list
	 * and find the Ant object and then get their last flag reached.
	 * 
	 * @return lastFlagReached declared as an int
	 */
	public int getLastFlagReached() {
		return ant.getLastFlagReached();
	}
	
	/**
	 * Getter method that will return the health level of the ant. 
	 * 
	 * @return healthLevel declared as an int
	 */
	public int getHealthLevel() {
		return ant.getHealthLevel();
	}
	
	/**
	 * Getter method that will return the food level of the ant. 
	 *  
	 * @return foodLevel declared as an int
	 */
	public int getFoodLevel() {
		return ant.getFoodLevel();
	}
	
	/**
	 * Setter method that will set the height of the map of the game world.
	 * 
	 * @param height declared as an int
	 */
	public void setMapHeight(int height) {
		this.mapHeight = height;
	}
	
	/**
	 * Setter method that will set the width of the map of the game world.
	 * 
	 * @param width declared as an int 
	 */
	public void setMapWidth(int width) {
		this.mapWidth = width;
	}
	
	/**
	 * This getter method returns the map height. Used to check if the GameWorld's height was set to height of MapView.
	 * 
	 * @return mapHeight declared as an int 
	 */
	public int getMapHeight() {
		return mapHeight;
	}
	
	/**
	 * This getter method returns the map width. Used to check if the GameWorld's width was set to width of MapView.
	 * 
	 * @return mapWidth declared as an int
	 */
	public int getMapWidth() {
		return mapWidth;
	}
	
	/**
	 * Method that will exit the game
	 * 
	 */
	public void exit() {
		System.exit(0);
	}
	
}
