package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;
import java.util.List;

/**
 * Abstract visualization information
 * 
 * @author Christian Dreher
 */
abstract public class AbstractVisualizationInfo {
	
	/**
	 * Gets the ID of the procedure
	 * 
	 * @return ID of the procedure
	 */
	abstract public String getId();

	/**
	 * Gets the name of the procedure
	 * 
	 * @return Name of the procedure
	 */
	abstract public String getName();

	/**
	 * Gets the description of a procedure
	 * 
	 * @return Description of a procedure
	 */
	abstract public String getDescription();

	/**
	 * Offset on the timeline indicating the position on the timeline 
	 * from left. The offset must be in the interval (0,1).
	 * An offset equal to 0 or 1 will lead to undefined behaviour!
	 * 
	 * @return Position on the timeline in the interval (0,1)
	 */
	abstract public float getTimelineOffset();

	/**
	 * Gets the difficulty of the procedure
	 * 
	 * @return Difficulty of the procedure
	 */
	abstract public VisualizationDifficulty getDifficulty();

	/**
	 * Gets the year the procedure was invented
	 * 
	 * @return Year the procedure was invented
	 */
	abstract public int getYear();
	
	/**
	 * Gets the plain text of what the QR is encoding
	 * 
	 * @return Plain text of what the QR is encoding
	 */
	abstract public String getQRCodeContent();
	
	/**
	 * Gets a list of all controller classes belonging to the visualization
	 * 
	 * @todo fix warning here 
	 * ("Class is a raw type. References to generic type Class<T> should be parameterized")
	 * @return List of all controller classes belonging to the visualization
	 */
	@SuppressWarnings("rawtypes")
	abstract public List<Class> getControllerClasses();

	/**
	 * Gets the additional information as file URL to display HTML
	 * 
	 * @return Additional information as file URL to display HTML
	 */
	public URL getAdditionalInformationFileURL() {
		return null;
	}

	/**
	 * Gets the QR code as image 
	 * 
	 * @return QR code as image 
	 */
	public Image getQrCode() {
		return null;
	}
	
	/**
	 * Gets the human-readable and localized difficulty
	 * 
	 * @return The difficulty string
	 */
	public String getHumanReadableDifficulty() {
		switch (this.getDifficulty()) {
			case EASY: return "Easy";
			case MEDIUM: return "Medium";
			case HARD: return "Hard";
			default: return null;
		}
	}
}
