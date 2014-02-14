package edu.kit.iks.Cryptographics.Vigenere;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.DiffieHellman.DHVisualizationInfo;
import edu.kit.iks.Cryptographics.Vigenere.Demonstration.*;
import edu.kit.iks.Cryptographics.Vigenere.Experiment.FirstExperimentController;
import edu.kit.iks.Cryptographics.Vigenere.Explanation.FirstExplanationController;
import edu.kit.iks.Cryptographics.Vigenere.Explanation.SecondExplanationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class VigenereVisualizationInfo extends AbstractVisualizationInfo {
	private Element vigenereResources;
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			DHVisualizationInfo.class);
	
	public VigenereVisualizationInfo() {
		SAXBuilder saxBuilder = new SAXBuilder();

		InputStream is = this.getClass().getResourceAsStream("/vigenere/VigenereResources.xml");

		try {
			// converted file to document object
			Document document = saxBuilder.build(is);

			// get root node from xml
			this.vigenereResources = document.getRootElement().getChild("vigenere");
		} catch (JDOMException | IOException e) {
			Logger.e(e);
		}
	}
	
	public String getId() {
		return "vigenere";
	}
	
	public String getName() {
		return i18n.tr("Vigenère");
	}

	public String getDescription() {
		return i18n.tr("Get to know how Vigenere fixed the weaknesses of Caesar to make a 'secure' cipher for many hundred years!");
	}
	
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/Caesar_cipher");
	}

	public float getTimelineOffset() {
		return 0.5f;
	}

	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.MEDIUM;
	}
	
	
	/* gets the year of the cryptographic algorithm
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	public int getYear() {
		return 1600; //inaccurate
	}
	
	@SuppressWarnings("rawtypes")
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		controllerClasses.add(FirstDemonstrationController.class);
		controllerClasses.add(SecondDemonstrationController.class);
		controllerClasses.add(ThirdDemonstrationController.class);
		controllerClasses.add(FirstExperimentController.class);
		controllerClasses.add(FirstExplanationController.class);
		controllerClasses.add(SecondExplanationController.class);
		controllerClasses.add(InformationController.class);
		return controllerClasses;
	}
	
	public Element getResources() {
		return vigenereResources;
	}
}
