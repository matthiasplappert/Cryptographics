package edu.kit.iks.Cryptographics.Vigenere;

import java.util.List;

import edu.kit.iks.Cryptographics.VisualizationDifficulty;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class VisualizationInfo extends AbstractVisualizationInfo {
	
	public String getId() {
		return "vigenere";
	}
	
	public String getName() {
		return "Vigenère";
	}

	public String getDescription() {
		return "";
	}
	
	public String getQRCodeContent() {
		return "";
	}

	public float getTimelineOffset() {
		return 0.5f;
	}

	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.MEDIUM;
	}
	
	
	/* gets the year of the cryptographic algorithm
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	public int getYear() {
		return 1600; //inaccurate
	}
	
	public List<Class> getControllerClasses() {
		return null;
	}
}
