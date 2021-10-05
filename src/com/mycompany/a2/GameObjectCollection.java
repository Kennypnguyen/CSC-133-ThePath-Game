/**
 * This class GameObjectCollection holds all the game objects in the GameWorld. It uses an ArrayList to hold the game objects implements the interface 
 * ICollection to store game objects in the list. It also implements the interface IIterator to go through each game object in the list by using getNext()
 * and keeps going until there is no more game objects in the array list by using hasNext() to check it.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection {

	// Declare Game object list to store game objects
	private ArrayList <GameObject> list = new ArrayList<GameObject>();
	
	/**
	 * This is the Iterator class that implements the interface IIterator.
	 * 
	 * @author Kenny Nguyen
	 *
	 */
	public class Iterator implements IIterator {
		
		// Declare the index for the list.
		private int index;
		
		/**
		 * This will set the index to -1
		 * 
		 */
		public Iterator() {
			index = -1;
		}
		
		/**
		 * This method was provided in the class DesignPatterns Notes. Checks to see if the list has more elements
		 * 
		 * @return true or false whether if there are more elements in the list
		 */
		public boolean hasNext() {
			// Check if the list is equal or less than 0. If so, it will return false.
			if (list.size() <= 0) {
				return false;
			}
			if(index == list.size() - 1) {
				return false;
			}
			return true;
		}
		/**
		 * This method was provided in the class DesignPatterns Notes. Increases the index of the list and returns the next element in the list
		 * 
		 * @return the next element in the list
		 */
		public Object getNext() {
			index ++;
			return list.get(index);
		}
			
	}
	/**
	 * Method that was provided by the the interface ICollection and adds a game object into the list.
	 * 
	 */
	public void add(Object object) {
		list.add((GameObject) object);
		
	}
	
	/**
	 * Method that was provided by the interface ICollection and obtains the iterator over the collection.
	 * 
	 * @return new Iterator
	 */
	public IIterator getIterator() {

		return new Iterator();
	}

}
