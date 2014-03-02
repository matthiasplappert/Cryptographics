package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

/**
 * This class is the controller of the view CFirstView.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class IntroductionController extends AbstractVisualizationController {

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			IntroductionController.class);

	/**
	 * Variable holding track of the current step user has proceeded in the animation. if it is 0,
	 * then it is the last step.
	 */
	private int introductionStep;

	/**
	 * Caesar root element from the xml file.
	 */
	private Element caesarResources;

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public IntroductionController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

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

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public IntroductionView getView() {
		return (IntroductionView) this.view;
	}

	@Override
	public void loadView() {
		this.introductionStep = 1;
		this.view = new IntroductionView();

		this.setResourceImage("CaesarIdea");

		this.getView().getNextButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) IntroductionController.this
						.getParentController();
				containerController.presentNextVisualizationController();
			}
		});

		this.getView().getProceed().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
				IntroductionController.this
						.proceedIntroduction(IntroductionController.this
								.getAnimationStep());
			}
		});

	}

	// ----------------------------------------------------------//
	// --------------------private methods-----------------------//

	private void proceedIntroduction(int step) {
		switch (step) {
		case 1:
			this.step1();
			break;
		case 2:
			this.step2();
			break;
		case 3:
			this.step3();
			break;
		case 4:
			this.step4();
			break;
		default:
			Logger.d("IntroductionController", "proceedIntroduction",
					"Invalid introduction step!");
		}
	}

	private void setResourceImage(String resourceID) {
		String path = "";
		try {
			path = IntroductionController.this.getCaesarResources()
					.getChild("Introduction").getChild(resourceID)
					.getAttributeValue("path");
		} catch (NullPointerException nullException) {
			//Element not found.
			System.out.println("[NullPointerException] Ressource not found.");
			nullException.printStackTrace();
		}
		
		GridBagConstraints imgConstraint = new GridBagConstraints();
		imgConstraint.gridx = 1;
		imgConstraint.gridy = 0;
		ImageView imageToSet = new ImageView(path);
		this.getView().getAnimationContainer().add(imageToSet, imgConstraint);
	}

	private void step1() {
		this.introductionStep++;
		this.getView().getAnimationContainer().removeAll();
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("Unfortunately his courier has taken the way through the forest, where Kryptolix chased<br>"
												+ "the wild boars."));
        
		this.setResourceImage("Courier");

		this.getView().validate();
		this.getView().getAnimationContainer().repaint();

	}

	private void step2() {
		this.introductionStep++;
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("When Kryptolix noticed the unsuspecting and whistling roman courier, he punched him via the air-line<br>"
												+ "back to Rome. And saw him losing a scroll."));

		

	}

	private void step3() {
		this.introductionStep++;
		this.getView().getAnimationContainer().removeAll();

		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("When reading the scroll the courier lost, Kryptolix identified Caesar's plans of<br>"
												+ "conquering Gallia and Kryptolix and his awesome friends could defeat Caesar again!"));

		this.setResourceImage("FlyingCourier");
		
		 this.getView().validate();
		 this.getView().repaint();
	}

	private void step4() {
		this.getView().getAnimationContainer().removeAll();
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("Caesar was raging. But while he was toturing some Gauls suddenly a hellacious and an foolproof idea<br>"
												+ "crossed his mind. In his next message he will encrypt his name! Hue Hue Hue. Help him."));

		this.setResourceImage("CaesarAngry");
		this.getView().remove(this.getView().getProceed());
		this.getView().setProceed(null);
		this.getView().repaint();
		this.getView().validate();

	}

	// ----------------------------------------------------------//
	// ---------------------Getter/Setter-------------------------//
	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return this.introductionStep;
	}

	@Override
	public String getHelp() {
		String help = IntroductionController.i18n
				.tr("If you want to hear the awesome legend about Caesar "
						+ "and Kryptolix press the button below the text. Else try the next button!");

		return help;
	}

	@Override
	public void unloadView() {
		this.view = null;
	}

	/**
	 * @return the caesarResources
	 */
	public Element getCaesarResources() {
		return caesarResources;
	}

	/**
	 * @param caesarResources
	 *            the caesarResources to set
	 */
	public void setCaesarResources(Element caesarResources) {
		this.caesarResources = caesarResources;
	}

	// @Override
	// public CaesarVisualizationInfo getVisualizationInfo() {
	// return (CaesarVisualizationInfo) this.getVisualizationInfo();
	// }

}
