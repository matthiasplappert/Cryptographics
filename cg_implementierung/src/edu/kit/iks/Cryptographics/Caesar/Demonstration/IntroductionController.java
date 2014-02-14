package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
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
     * 
     */
	private Element introResource;

	/**
	 * @param visualizationInfo
	 */
	public IntroductionController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
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
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.introResource = vsInfo.getResources().getChild("Introduction");
		this.view = new IntroductionView();

		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
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
			System.out.println("Invalid introduction step!!!! Check why!");
		}
	}
	
	private void step1() {
		this.introductionStep++;
//		this.getView().getAnimationContainer()
//				.remove(this.getView().getCaesarIdeaImg());
//		this.getView().setCaesarIdeaImg(null);
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("Unfortunately his courier has taken the way through the forest, where Kryptolix chased<br>"
												+ "the wild boars."));


//		// set the alignment of the masterPlan image.
//		GridBagConstraints courierConstraint = new GridBagConstraints();
//		courierConstraint.weightx = 1.0;
//		courierConstraint.weighty = 0.1;
//		courierConstraint.gridx = 0;
//		courierConstraint.gridy = 0;
//		courierConstraint.gridwidth = 1;
//
//		// take the image from the xml-resource.
//		this.getView().setCourier(
//				new ImageView(this.introResource.getChild("Courier")
//						.getAttributeValue("path")));
//		this.getView().getAnimationContainer()
//				.add(this.getView().getCourier(), courierConstraint);
//
//		this.getView().getAnimationContainer().repaint();

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

//		// set the alignment of boar.
//		GridBagConstraints boarConst = new GridBagConstraints();
//		boarConst.gridx = 4;
//		boarConst.gridy = 0;
//		this.getView().getAnimationContainer()
//				.add(this.getView().getBoar(), boarConst);
//
//		// set the alignment of obelix image.
//		GridBagConstraints obelixConstraint = new GridBagConstraints();
//		obelixConstraint.gridx = 3;
//		obelixConstraint.gridy = 0;
//
//		// take the image from the xml-resource.
//		this.getView().setKryptolix(
//				new ImageView(this.introResource.getChild("Obelix")
//						.getAttributeValue("path")));
//		this.getView().getAnimationContainer()
//				.add(this.getView().getKryptolix(), obelixConstraint);

	}

	private void step3() {
		this.introductionStep++;
//		this.getView().getAnimationContainer()
//				.remove(this.getView().getCourier());
//		this.getView().setCourier(null);
//		this.getView().getAnimationContainer().remove(this.getView().getBoar());

		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("When reading the scroll the courier lost, Kryptolix identified Caesar's plans of<br>"
												+ "conquering Gallia and Kryptolix and his awesome friends could defeat Caesar again!"));

//		GridBagConstraints orderConstraints = new GridBagConstraints();
//		orderConstraints.gridx = 5;
//		orderConstraints.gridy = 0;
//		this.getView().setOrders(
//				new ImageView(this.introResource.getChild("Orders")
//						.getAttributeValue("path")));
//		this.getView().getAnimationContainer()
//				.add(this.getView().getOrders(), orderConstraints);
//
//		this.getView().validate();
	}

	private void step4() {
//		this.getView().getAnimationContainer()
//				.remove(this.getView().getKryptolix());
//		this.getView().getAnimationContainer()
//				.remove(this.getView().getOrders());
//		this.getView().setKryptolix(null);
//		this.getView().setOrders(null);

		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("Caesar was raging. But while he was toturing some Gauls suddenly a hellacious and an foolproof idea<br>"
												+ "crossed his mind. In his next message he will encrypt his name! Hue Hue Hue. Help him."));

		GridBagLayout introLayout = (GridBagLayout) this.getView().getLayout();
		this.getView().getNextButton()
				.setText(IntroductionController.i18n.tr("To caesar's idea"));
		GridBagConstraints finishConstraint = new GridBagConstraints();
		finishConstraint.gridx = 1;
		finishConstraint.gridy = 2;
		introLayout.setConstraints(this.getView().getNextButton(),
				finishConstraint);
		this.getView().remove(this.getView().getProceed());
		this.getView().setProceed(null);

		this.getView().validate();

	}

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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
		this.introResource = null;
	}

}
