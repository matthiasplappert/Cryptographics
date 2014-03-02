package edu.kit.iks.Cryptographics.SHA2;

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
		return "sha2";
	}

	@Override
	public String getName() {
		return i18n.tr("SHA-2");
	}

	@Override
	public String getDescription() {
		return i18n.tr("Learn about the cryptographic hash function SHA-2. A hash function allows you to transform your data in one direction only, making it impossible to reverse the process!");
	}

	@Override
	public float getTimelineOffset() {
		return 0.97f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.NOT_INTERACTIVE;
	}

	@Override
	public int getYear() {
		return 2001;
	}

	@Override
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/SHA_2");
	}

	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();

		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}
}