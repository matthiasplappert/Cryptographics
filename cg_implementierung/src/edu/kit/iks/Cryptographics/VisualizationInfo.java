package edu.kit.iks.Cryptographics;

import java.awt.Image;
import java.net.URL;

abstract public class VisualizationInfo {
	protected String id;
	
	protected String name;
	
	protected String description;
	
	protected float timelineOffset;
	
	protected VisualizationDifficulty difficulty;
	
	protected int year;
	
	protected URL additionalInformationFileURL;
	
	protected Image qrCode;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public float getTimelineOffset() {
		return timelineOffset;
	}

	public VisualizationDifficulty getDifficulty() {
		return difficulty;
	}

	public int getYear() {
		return year;
	}

	public URL getAdditionalInformationFileURL() {
		return additionalInformationFileURL;
	}

	public Image getQrCode() {
		return qrCode;
	}
}
