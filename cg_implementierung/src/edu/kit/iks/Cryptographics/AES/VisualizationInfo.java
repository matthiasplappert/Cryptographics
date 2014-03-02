package edu.kit.iks.Cryptographics.AES;

import java.util.ArrayList;
import java.util.List;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class VisualizationInfo extends AbstractVisualizationInfo {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(VisualizationInfo.class);
	
	@Override
	public String getId() {
		return "aes";
	}

	@Override
	public String getName() {
		return i18n.tr("AES");
	}

	@Override
	public String getDescription() {
		return i18n.tr("Learn about one of the most important modern ciphers, the Advanced Encryption Standard!");
	}

	@Override
	public float getTimelineOffset() {
		return 0.93f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.NOT_INTERACTIVE;
	}

	@Override
	public int getYear() {
		return 1998;
	}

	@Override
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/Advanced_Encryption_Standard");
	}

	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();

		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}

}
