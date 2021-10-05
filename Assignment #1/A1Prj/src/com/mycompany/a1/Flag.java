/**
 * This class Flag extends the fixedObject class and it's method. This class creates the object flag that is fixed object that can not change it's location 
 * once it is created. All flags will have the same color and same size which can also not change once it is created. Each flag has additional attribute 
 * called sequenceNumber in which each flag has different sequence number ranging from 1-9. Flags are used as a checkpoint for users to clear. 
 * The user must clear each flag going in numeric number going by their sequence number.
 *
 * 
 * @author Kenny Nguyen
 * @version A1 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */
package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class Flag extends FixedObject {
	
	//Declare variables that are attributes for a Flag
	private int sequenceNumber = 1;
	
	/**
	 * This constructor method creates a Flag object. The size and color is already defaulted into a fixed integer value so this means it cannot change
	 * once it is created. It uses parameters passed from the user float xLocation and yLocation to create the Point location for the flag object. To
	 * do this, it uses the super method from it's parent class to set the location. Then it uses another parameter sequenceNumber to determine what unique
	 * number will the created flag have.
	 * 
	 * @param xLocation declared as a float, used for the x value of the location of the object
	 * @param yLocation declared as a float, used for the y value of the location of the object
	 * @param sequenceNumber declared as an int, used to determine which number is the flag
	 */
	public Flag(float xLocation, float yLocation, int sequenceNumber) {
		//Super method from FixedObject to set the xLocation and yLocation
		super(xLocation, yLocation);
		this.setColor(ColorUtil.BLUE);
		this.setSize(10);
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * This getter method returns the sequence number of the flag object
	 * @return sequenceNumber declared as an int
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * This setter method sets the color for the flag object. However this method will be blank so that the color of the flag will never change.
	 */
	public void setColor(int color) {
	}
	
	/**
	 * This String toString method overrides the parent's toString method. This toString methods includes additional description of a Flag object that
	 * includes size and sequence number.
	 * 
	 * @return description of a Flag object
	 */
	public String toString() {
		String parentDesc = super.toString();
		String mydesc1 = " size=" + this.getSize() + " seqNum=" + getSequenceNumber();
		String mydesc2 = "Flag: ";
		return mydesc2 + parentDesc + mydesc1;
	}
	
}