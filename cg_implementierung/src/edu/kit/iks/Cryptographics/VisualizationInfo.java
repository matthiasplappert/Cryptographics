package edu.kit.iks.Cryptographics;

import java.awt.Image;
import java.net.URL;

abstract public class VisualizationInfo {
	protected String _id;
	
	protected String _name;
	
	protected String _description;
	
	protected float _timelineOffset;
	
	protected VisualizationDifficulty _difficulty;
	
	protected int _year;
	
	protected URL _additionalInformationFileURL;
	
	protected Image _qrCode;

	public String getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}

	public float getTimelineOffset() {
		return _timelineOffset;
	}

	public VisualizationDifficulty getDifficulty() {
		return _difficulty;
	}

	public int getYear() {
		return _year;
	}

	public URL getAdditionalInformationFileURL() {
		return _additionalInformationFileURL;
	}

	public Image getQrCode() {
		return _qrCode;
	}
}
