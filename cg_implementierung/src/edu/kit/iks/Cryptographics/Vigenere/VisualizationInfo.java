package edu.kit.iks.Cryptographics.Vigenere;

import edu.kit.iks.CryptograhicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptograhicsLib.AbstractVisualizationInfo;
import edu.kit.iks.Cryptographics.VisualizationDifficulty;

class VisualizationInfo extends AbstractVisualizationInfo {
	public String getId() {
		return "diffiehellman";
	}
	
	public String getName() {
		return "Diffie-Hellman";
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
