/**
 * This interface ICollection is used for the GameObjectCollectio class because it has the ability to add a new object into the game object
 * collection list and can obtain an iterator over the collection.
 * 
 * @author Kenny Nguyen
 * @version A2 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a2;

public interface ICollection {

	/**
	 * This method adds a new object into a list
	 * 
	 * @param object declared as an object (Gameobject)
	 */
	public void add(Object object);
    /**
     * This method obtains the iterator over the collection 
     * 
     * @return new Iterator
     */
	public IIterator getIterator();
	
}
