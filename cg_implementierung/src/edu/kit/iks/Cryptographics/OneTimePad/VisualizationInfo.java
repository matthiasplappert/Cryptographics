package edu.kit.iks.Cryptographics.OneTimePad;

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
		return "onetime-pad";
	}

	@Override
	public String getName() {
		return i18n.tr("One-Time Pad");
	}

	@Override
	public String getDescription() {
		return i18n.tr("Find out how you can encrypt something in such a way that it is impossible for someone else to crack it!");
	}

	@Override
	public float getTimelineOffset() {
		return 0.7f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.NOT_INTERACTIVE;
	}

	@Override
	public int getYear() {
		return 1882;
	}

	@Override
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/One-time_pad");
	}

	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();

		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}
}
