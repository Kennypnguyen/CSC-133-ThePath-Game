/**
 * This class BGSound is used to play the looping background sound of the game unless paused. It first constructs the media file
 * that is going to be the looping background sound using the constructor method. If the method cannot construct a media file, the user is prompted with
 * an error. There is also pause and play methods for when the user wants to pause the background sound or play the background sound where it was left off. 
 * This method also implements Runnable which allows for a run method. The run method is called automatically when the media is done playing.
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

public class BGSound implements Runnable {
	
	// Declare Media object to play sound
	private Media m;
	
	/**
	 * This constructor method a Media object of a specified file, then plays the Media (Background Sound). If it can't, it produces an error letting the 
	 * user know that it cannot play sound.
	 *
	 * @param fileName declared as a String which is name of the file that will play the sound
	 */
	public BGSound(String fileName) {
		try {
			InputStream inputStream = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			// Attach runnable to run when the media is done playing as last parameter
			m = MediaManager.createMedia(inputStream, "audio/wav", this);
		}
		// If the sound file is not there, then error occurs
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot play sound.");
		}
	}
	
	/**
	 * This method pauses the background sound.
	 * 
	 */
	public void pause() {
		m.pause();
	}
	/**
	 * This method plays the background sound where it was left off.
	 * 
	 */
	public void play() {
		m.play();
	}
	/**
	 * This method is entered when the media is finished playing because it is a looping background sound.
	 * 
	 */
	public void run() {
		// Start playing the sound from the time zero
		m.setTime(0);
		m.play();
	}

}
