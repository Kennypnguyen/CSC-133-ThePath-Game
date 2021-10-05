/**
 * This class GameWorld is where all of the game objects, ant, spider, flag, and food station, are created for this game. 
 * This also includes all the methods that can change the state of the game. This class contains the collection which aggregates the abstract type GameObject. 
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	
	//Declare variables that will be used for the game.
	private int lives;
	private int clock;
	Random rand = new Random();
	private ArrayList<GameObject> list;
	Ant ant = new Ant(100, 100);
	private int lastFlag = 4;
	
	public void init() {
		// Initialize the values in lives and clock to their appropriate values.
		lives = 3;
		clock = 0;
		// Create an ArrayList called list that will hold the game objects.
		list = new ArrayList<GameObject>();
		//Call the methods that will create the game objects.
		addFlags();
		addAnt();
		addSpider();
		addSpider();
		addFoodStation();
		addFoodStation();
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
	 * This method generates a random X point from 0-1000 using the class java.util.Random that will be used for the location of the spider and food station. 
	 * It will then return it's value
	 * @return randomNum that will be used the for x-coordinate.
	 */
	public float randomX() {
		float randomNum = rand.nextInt((1000 - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method generates a random Y point from 0-1000 using the class java.util.Random that will be used for the location of the spider and food station. 
	 * It will then return it's value
	 * @return randomNum that will be used the for y-coordinate.
	 */
	
	public float randomY() {
		float randomNum = rand.nextInt((1000 - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method generates a random speed value from 5-10 using the class java.util.Random that will be used for speed of the spider. It will then return it's value
	 * @return randomNum that will be used the speed of the spider.
	 */
	public int randomSpeed() {
		int randomNum = rand.nextInt((10 - 5) + 1) + 5;
		return randomNum;
	}
	
	/**
	 * This method generates a random size value from 10-50 using the class java.util.Random that will be used forthe size of spider and food station. 
	 * It will then return it's value
	 * @return randomNum that will be used the size of the spider and food station.
	 */
	public int randomSize() {
		int randomNum = rand.nextInt((50 - 10) + 1) + 10;
		return randomNum;
	}
	
	/**
	 * This method generates a random speed value from 0-359 using the class java.util.Random that will be used for the heading of the spider. 
	 * It will then return it's value
	 * @return randomNum that will be used the heading of the spider.
	 */
	public int randomHeading() {
		int randomNum = rand.nextInt((359 - 0) + 1) + 0;
		return randomNum;
	}
	
	/**
	 * This method accelerate is used when the user hits the 'a' keyboard key. Once this is called, it increases the speed of the ant by 3.
	 * Then lets the user know that it was increased successfully. This is done by calling methods from the Ant class that sets the ant's new 
	 * speed and the method that gets the ant's speed and then increases the ant's original speed by 3.
	 */
	public void accelerate() {
		int increaseSpeed = 5;
		System.out.println("Updating ant's speed.");
		//Uses methods from Ant class to update the ant's speed.
		ant.setAntSpeed(ant.getSpeed() + increaseSpeed);
		if(ant.getSpeed() < ant.getMaximumSpeed()) {
			System.out.println("Ant's speed has been increased by 5.");
		}
	}
	
	/**
	 * This method brake is used when the user hits the 'b' keyboard key. Once this is called, it reduces the speed of the ant by 3.
	 * Then lets the user know that it was reduced successfully. This is done by calling methods from the Ant class that sets the ant's new 
	 * speed and the method that gets the ant's speed and then subtracts the ant's original speed by 3.
	 */
	public void brake() {
		int reduceSpeed = 5;
		// Uses methods from Ant class to update the ant's speed.
		ant.setAntSpeed(ant.getSpeed() - reduceSpeed);
		System.out.println("Ant's speed has been reduced by 5.");
	}
	
	/**
	 * This method left is used when the user hits the 'l' keyboard key. Once this is called , it changes the ant's heading by -5 so that it could turn left or head west.
	 * Then it lets the user know that it turned left successfully. This methods calls another method the ant class that will update the heading of the ant.
	 */
	public void left() {
		int turnLeft = -5;
		// Uses steerHeading method from Ant class to update the heading of the ant.
		ant.steerHeading(turnLeft);
		System.out.println("Ant has turned left successfully.");
	}
	
	/**
	 * This method right is used when the user hits the 'r' keyboard key. Once this is called , it changes the ant's heading by 5 so that it could turn right or head east.
	 * Then it lets the user know that it turned right successfully. This methods calls another method the ant class that will update the heading of the ant.
	 */
	public void right() {
		int turnRight = 5;
		// steerHeading method from Ant class to change the heading of the ant.
		ant.steerHeading(turnRight);
		System.out.println("Ant has turned right successfully.");
	}
	
	/**
	 * This method spiderCollision is used the when the user hits the 'g' keyboard key. For now we are to pretend that the ant has collided with the spider. This then calls
	 * the collisionSpider() method from the Ant class that will reduce the health level of the ant and change the color of the ant slightly that will let the user know.
	 */
	public void spiderCollision() {
		// Calls collisionSpider() from Ant class to reduce the health level of the ant and change the color of the ant.
		ant.collisionSpider();
		System.out.println("Ant has collided with a spider.");
	}
	
	/**
	 * This method foodStationCollision is used when the user hits the 'f' keyboard key. For now we are to pretend that the ant has collided with the food station. 
	 * This will increase the ant's food level
	 */
	public void foodStationCollision() {
		// Pretends it collided with a food station.
		GameObject foodStation = null;
		for(GameObject food : list) {
			if(food instanceof FoodStation) {
				if(((FoodStation) food).getCapacity() != 0) {
					foodStation = food;
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
	}
	
	/**
	 * This method is called when the user hits the key 'a number 1-9' from the keyboard. Each number 1-9 represents a flag that the ant has collided. The user must collide 
	 * with the flags in numeric order. First it checks with the flag number x that the ant collided and the last flag that the ant has reached. If the flag number x
	 * is exactly one greater than the last flag reached then it will update the lastFlagReached(). If not, then the user will be prompted to go in numeric order.
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
	}
	/**
	 * This method lets the game world know that the game clock has ticked. A game clock tick will update the spider's heading, update all movable object's heading and speed,
	 * reduce the ant's food level by it's food consumption rate. Also checks to see if the user's lives were 0. If so, then the game will be over. If the user has reached all
	 * four flags, then the game will be over where the user wins.
	 */
	public void clockTick() {
		//Increase game clock by 1.
		clock ++;
		//Update the spider's heading.
		for(GameObject game: list) {
			if(game instanceof Spider ) {
				((Spider) game).randomHeading();
			}
			//Update all movable objects' speed and heading.
			if(game instanceof MovableObject) {
				((MovableObject) game).move();
			}
		}
		//If spider is out of bounds
		for(GameObject game: list ) {
			if(game instanceof Spider) {
				while(((Spider) game).getXLocation() >= 1000 || ((Spider) game).getYLocation() >= 1000) {
					((Spider) game).randomHeading();
					((Spider) game).move();
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
		System.out.println("Clock has been ticked successfully.");
		//If the user's lives were 0, then game is over, user loses.
		if(lives == 0) {
			System.out.println("Game over, you failed!");
			System.exit(0);
		}
		//If the user reaches the four flag, then they win.
		if(ant.getLastFlagReached() == lastFlag) {
				System.out.println("Game over, you win! Total time: " + this.clock);
				System.exit(0);
		}
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
	 * This method is called when the user enters 'm' from the keyboard. It then output a "map" in text form. It then uses the toString methods from the GameObject class.
	 * It displays the description of all the objects in the game.
	 */
	public void map() {
		for(GameObject game : list) {
			System.out.println(game.toString());
		}
	}

}
