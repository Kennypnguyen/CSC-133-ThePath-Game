/**
 * This class Sound is used to play the sounds when the user has collided with certain game objects. It first constructs the media file
 * that is going to be the collision sound using constructor method. If the method cannot construct a media file, the user is prompted with
 * an error. There is a method called play that plays the media from the time zero. 
 * 
 * 
 * @author Kenny Nguyen
 * @version A3 Project
 * - CSC 133-03
 * - Professor Pinar Muyan-Ozcelik
 */

package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {

	// Declare Media object to play sound
	private Media m;
	
	/**
	 * This constructor method a Media object of a specified file, then plays the Media (Sound of a collision). If it can't, it produces an error letting the 
	 * user know that it cannot play sound.
	 * 
	 * @param fileName declared as a String which is name of the file that will play the sound
	 */
	public Sound(String fileName) {
		try {
			InputStream inputStream = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			m = MediaManager.createMedia(inputStream, "audio/wav");
		}
		// If the sound file is not there, then error occurs
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot play sound.");
		}
	}
	
	/**
	 * This method plays the sound from the time zero.
	 * 
	 */
	public void play() {
		// Start playing the sound from the time zero
		m.setTime(0);
		m.play();
	}
}
