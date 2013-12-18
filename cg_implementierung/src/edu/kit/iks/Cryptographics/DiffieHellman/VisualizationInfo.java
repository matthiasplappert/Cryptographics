package edu.kit.iks.Cryptographics.DiffieHellman;

import java.util.List;

import edu.kit.iks.Cryptographics.VisualizationDifficulty;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class VisualizationInfo extends AbstractVisualizationInfo {
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
		return 1976;
	}
	
	public List<Class> getControllerClasses() {
		return null;
	}
}
