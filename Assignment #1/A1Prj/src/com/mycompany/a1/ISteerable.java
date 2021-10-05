/**
 * This interface ISteerable is used for Ant class because it has the ability to change their direction of movement (heading).
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;

public interface ISteerable {
	
	/**
	 * This method allows the class using this interface to be able to use this method to update their heading.
	 * 
	 * @param headingChange declared as an int
	 */
	public void steerHeading(int headingChange);

}
