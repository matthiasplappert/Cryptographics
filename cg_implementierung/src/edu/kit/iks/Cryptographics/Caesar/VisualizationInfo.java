package edu.kit.iks.Cryptographics.Caesar;

import edu.kit.iks.CryptograhicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptograhicsLib.AbstractVisualizationInfo;
import edu.kit.iks.Cryptographics.VisualizationDifficulty;

class VisualizationInfo extends AbstractVisualizationInfo {
	public String getId() {
		return "caesar";
	}
	
	public String getName() {
		return "Caesar";
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
