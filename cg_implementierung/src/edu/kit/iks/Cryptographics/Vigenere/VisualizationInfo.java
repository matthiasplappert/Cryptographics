package edu.kit.iks.Cryptographics.Vigenere;

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

	public float getTimelineOffset() {
		return 0.0f;
	}

	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	public int getYear() {
		return 0;
	}
	
	public Class<AbstractVisualizationController> getControllerClass() {
		return null;
	}
}
