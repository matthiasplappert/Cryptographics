package edu.kit.iks.CryptograhicsLib;

import java.awt.Image;
import java.net.URL;

import edu.kit.iks.Cryptographics.VisualizationDifficulty;

abstract public class AbstractVisualizationInfo {
	abstract public String getId();

	abstract public String getName();

	abstract public String getDescription();

	abstract public float getTimelineOffset();

	abstract public VisualizationDifficulty getDifficulty();

	abstract public int getYear();
	
	abstract public Class<AbstractVisualizationController> getControllerClass();

	public URL getAdditionalInformationFileURL() {
		return null;
	}

	public Image getQrCode() {
		return null;
	}
}
