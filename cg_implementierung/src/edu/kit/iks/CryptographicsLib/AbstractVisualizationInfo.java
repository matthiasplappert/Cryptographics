package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;
import java.util.List;

import edu.kit.iks.Cryptographics.VisualizationDifficulty;

abstract public class AbstractVisualizationInfo {
	abstract public String getId();

	abstract public String getName();

	abstract public String getDescription();

	abstract public float getTimelineOffset();

	abstract public VisualizationDifficulty getDifficulty();

	abstract public int getYear();
	
	abstract public String getQRCodeContent();
	
	// TODO: fix warning here 
	// ("Class is a raw type. References to generic type Class<T> should be parameterized")
	abstract public List<Class> getControllerClasses();

	public URL getAdditionalInformationFileURL() {
		return null;
	}

	public Image getQrCode() {
		return null;
	}
}
