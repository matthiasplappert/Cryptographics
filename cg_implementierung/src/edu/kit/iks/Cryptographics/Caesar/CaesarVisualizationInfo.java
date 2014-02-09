package edu.kit.iks.Cryptographics.Caesar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import edu.kit.iks.Cryptographics.Caesar.Demonstration.CipherDemoController;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.IntroductionController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.HistogramController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CaesarVisualizationInfo extends AbstractVisualizationInfo {

	/**
	 * Caesar root element from the xml file.
	 */
	private Element caesarResources;

	/**
	 * Constructor for the visualizationInfo.
	 */
	public CaesarVisualizationInfo() {
		SAXBuilder saxBuilder = new SAXBuilder();

		// obtain file object
		InputStream is = this.getClass().getResourceAsStream(
				"/caesar/CaesarResources.xml");

		try {
			// converted file to document object
			Document document = saxBuilder.build(is);

			// get root node from xml
			this.caesarResources = document.getRootElement();
		} catch (JDOMException | IOException e) {
			Logger.e(e);
		}
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses ()
	 */
	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();

		controllerClasses.add(IntroductionController.class);
		controllerClasses.add(CipherDemoController.class);
		controllerClasses.add(CryptoController.class);
		controllerClasses.add(HistogramController.class);
		controllerClasses.add(InformationController.class);

		return controllerClasses;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Get to know how Ceasar fooled his enemys that "
				+ "intercepted his orders and see one of the oldest "
				+ "attempts to make confidential material unreadable "
				+ "for undesireable readers";
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
	 */
	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
	 */
	@Override
	public String getId() {
		return "caesar";
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
	 */
	@Override
	public String getName() {
		return "Caesar";
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent ()
	 */
	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return "www.google.de";
	}

	/**
	 * @return the resources
	 */
	public Element getResources() {
		return this.caesarResources;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset ()
	 */
	@Override
	public float getTimelineOffset() {
		return 0.01f;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	@Override
	public int getYear() {
		// when getYear() negative then it's the year B.C.
		// The year is an estimation!!!
		return -70;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(Element caesarResources) {
		this.caesarResources = caesarResources;
	}

}