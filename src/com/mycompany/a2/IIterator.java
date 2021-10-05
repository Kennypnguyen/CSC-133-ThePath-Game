/**
 * This interface IIteartor is also used in the GameObjectCollection class and has methods that will help check the game object collection if there are more elements and will help return the next
 * element in the game object collection.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

public interface IIterator {
	
	/**
	 * This methods checks whether there are more elements to be processed in the collection
	 * 
	 * @return true or false depending if there are more elements in the collection
	 */
	public boolean hasNext();
	/**
	 * This method returns the next elements processed from the collection
	 * 
	 * @return returns the next element in the collection
	 */
	public Object getNext();
}
