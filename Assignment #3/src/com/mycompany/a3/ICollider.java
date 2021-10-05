/**
 * This interface ICollider is used for the GameObject to handle collision detection/response. It will perform the appropriate collision response. 
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

public interface ICollider {

	/**
	 * This method checks to see if two objects have collided. Returns true if two objects have collided. Returns false if two objects have not collided.
	 * 
	 * @param otherObject declared as an GameObject which is the other game object that has or has not collided with the current game object.
	 */
	public boolean collidesWith(GameObject otherObject);
	
	/**
	 * This method handles the appropriate collision response depending on the two game objects. Each game objects have their own collision responses.
	 * 
	 * @param otherObject declared as an GameObject which is the other game object that has collided with the current game object.
	 */
	public void handleCollision(GameObject otherObject);
}
