/**
 * This class FoodStation extends FixedObject and it's methods. This class creates the object FoodStation that is a fixed objects that it's location is randomly 
 * created within the boundaries of the game. Like the Flag object, it's size and color does not change once it is created. An additional attribute a 
 * FoodStation has is capacity declared as an int. Capacity is used to determine how much "food" is in a food station. When a food station is created, 
 * it's capacity is proportional  to  the  size  of  the  food  station. Food stations are used when the user's ant is running low on food. Once it 
 * collides with the food station, the ant's food level is increased and then the capacity of the food station is set to 0. Once it the capacity is 
 * set to 0, the food station fades away and a new food station is created at a random location.
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends FixedObject {
	
	//Declared variables that are additional attributes for a FoodStation
	private int capacity;
	
	/**
	 * This constructor method creates a FoodStation object. The color is set to a defaulted integer value so that it can not change once 
	 * it is created. The capacity is set to same value of size because it must be proportional to the food station's size. It uses parameter size that 
	 * is randomly generated using the Random class ranging from 10-50. It also uses the parameters float xLocation and yLocation which is also randomly 
	 * created ranging from 0.0 to 1000.0 using the Random class. Uses the super keyword to use the parent class to set the X and Y value of the location
	 * 
	 * @param xLocation declared as a float, used for the x value of the location of the object (randomly generated)
	 * @param yLocation declared as a float, used for the y value of the location of the object (randomly generated)
	 * @param size declared as a int. This is also used to determine the capacity (randomly generated)
	 */
	public FoodStation(float xLocation, float yLocation, int size) {
		//Super method from FixedObject to set the xLocation and yLocation
		super(xLocation, yLocation);
		this.setColor(ColorUtil.GREEN);
		this.setSize(size);
		this.setCapacity(size);
	}
	
	/**
	 * Setter method that sets the capacity of a food station. Must be proportional to the size of a food station.
	 * 
	 * @param capacity declared as an int (proportional to size)
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Getter method that returns the capacity of a food station 
	 * 
	 * @return capacity declared as an int
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * This String toString method overrides the parent's toString method. This toString methods includes additional description of a FoodStation object that
	 * includes size and capacity.
	 * 
	 * @return description of a FoodStation object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDesc1 = " size=" + this.getSize() + " capacity=" + getCapacity();
		String myDesc2 = "FoodStation:";
		return myDesc2 + parentDesc + myDesc1;
	}
	
}

