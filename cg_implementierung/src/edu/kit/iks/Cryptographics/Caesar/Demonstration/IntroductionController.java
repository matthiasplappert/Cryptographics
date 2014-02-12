package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.ImageView;
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
	private int animationStep;

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
	 * TODO: Need a less dirty solution. Method for intern state handling.
	 * 
	 * @param c
	 */
	public void animationStart(int step) {
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
			System.out.println("Invalid animation step!!!! Check why!");
		}
	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return this.animationStep;
	}

	@Override
	public String getHelp() {
		String help = IntroductionController.i18n
				.tr("If you want to hear the awesome legend about Caesar "
						+ "and Kryptolix press the button below the text. Else try the next button!");

		return help;
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
		this.animationStep = 1;
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
						.animationStart(IntroductionController.this
								.getAnimationStep());
			}
		});

	}

	/*
	 * TODO: !!!!!!!!!!!!!!!!!!!!!!Fuer jemanden der sich um die Grafiken kuemmern
	 * will!!!!!!!!!!!!!!!!!:Also hier zur Ausnahme auf Deutsch, was auf der Animation passieren
	 * soll: step1. Caesar(laechelnd(am besten boeoeoeoeoese)) komikhaft dargestellt mit einer
	 * Gluehlampe auf dem Kopf.
	 * 
	 * step2.Ich brauche ein Bild von einem Maennchen, an dem man am besten auch erkennt, dass dies
	 * ein Bote ist. Auf dem Hintergrundbild sollte ein Wald zu sehen sein. Der Bote wird von links
	 * nach rechts bis zum Ende oder 3/4 des Bildschirms laufen. Es muss dabei klar sein, dass der
	 * Bote nach rechts sieht und hinter ihm nichts bemerken kann. (optional auf pfeifend, laechelnd
	 * laufen)
	 * 
	 * 3. Wenn der Bote hinten angekommen ist.(optional: Bildchen wo er sich ausruht). Taucht
	 * ungefaehr 1/4 auf der x-Achse des Bildschirms, ein Wildschwein auf. Und laeuft nach
	 * links.(Nicht nach rechts, wo der Bote ist.).
	 * 
	 * 4. Da wo das Wildschwein aufgetaucht ist, tauch hinterher Bild vom Obelix auf. Dieser
	 * allerdings dreht sich nach rechts und laeuft dem Boden entgegen. Es muss hier deutlich
	 * werden, dass der Bote daovon nichts mitbekommt.
	 * 
	 * 5. Obelix haut den Boden(Wie egal) und der Bote fliegt vertikal nach Oben und da wo der Bote
	 * war, erscheint eine Schriftrolle.
	 * 
	 * 6.Obelix lesend dargestellt.(Wie ist egal).
	 * 
	 * 7. Caesar mit teuflischem Grinsen.(optional auch mit reibenden Haenden.)
	 */
	private void step1() {
		this.animationStep++;
		this.getView().getAnimationContainer()
				.remove(this.getView().getCaesarIdeaImg());
		this.getView().setCaesarIdeaImg(null);
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("Unfortunately his courier has taken the way through the forest, where Kryptolix chased<br>"
												+ "the wild boars."));

		// this.getView().getAnimationContainer().setBackground(Color.GREEN);

		// set the alignment of the masterPlan image.
		GridBagConstraints courierConstraint = new GridBagConstraints();
		// courierConstraint.anchor = GridBagConstraints.WEST;
		courierConstraint.weightx = 1.0;
		courierConstraint.weighty = 0.1;
		courierConstraint.gridx = 0;
		courierConstraint.gridy = 0;
		courierConstraint.gridwidth = 1;
		// courierConstraint.fill = GridBagConstraints.HORIZONTAL;

		// take the image from the xml-resource.
		this.getView().setCourier(
				new ImageView(this.introResource.getChild("Courier")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getCourier(), courierConstraint);
		// setup the background.
		this.getView().setBackgroundImg(
				new ImageView(this.introResource.getChild("ForestBackground")
						.getAttributeValue("path")));

		this.getView().getAnimationContainer().repaint();
		this.getView().setxCoordCourier(this.getView().getCourier().getX());

	}

	private void step2() {
		this.animationStep++;
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("When Kryptolix noticed the unsuspecting and whistling roman courier, he punched him via the air-line<br>"
												+ "back to Rome. And saw him losing a scroll."));

		// set the alignment of boar.
		GridBagConstraints boarConst = new GridBagConstraints();
		boarConst.gridx = 4;
		boarConst.gridy = 0;
		this.getView().setBoar(
				new ImageView(this.introResource.getChild("Boar")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getBoar(), boarConst);

		// set the alignment of obelix image.
		GridBagConstraints obelixConstraint = new GridBagConstraints();
		// obelixConstraint.anchor = GridBagConstraints.PAGE_END;
		// obelixConstraint.weightx = 1.0;
		obelixConstraint.gridx = 3;
		obelixConstraint.gridy = 0;
		// obelixConstraint.fill = GridBagConstraints.VERTICAL;

		// take the image from the xml-resource.
		this.getView().setObelix(
				new ImageView(this.introResource.getChild("Obelix")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getObelix(), obelixConstraint);

		// TODO: Animationd doesn't work.
		// this.getView().secondAnimation();
	}

	private void step3() {
		this.animationStep++;
		this.getView().getAnimationContainer()
				.remove(this.getView().getCourier());
		this.getView().setCourier(null);
		this.getView().getAnimationContainer().remove(this.getView().getBoar());
		this.getView().setBoar(null);

		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ IntroductionController.i18n
										.tr("When reading the scroll the courier lost, Kryptolix identified Caesar's plans of<br>"
												+ "conquering Gallia and Kryptolix and his awesome friends could defeat Caesar again!"));

		GridBagConstraints orderConstraints = new GridBagConstraints();
		orderConstraints.gridx = 5;
		orderConstraints.gridy = 0;
		this.getView().setOrders(
				new ImageView(this.introResource.getChild("Orders")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getOrders(), orderConstraints);

		this.getView().validate();
	}

	private void step4() {
		this.animationStep++;
		this.getView().getAnimationContainer()
				.remove(this.getView().getObelix());
		this.getView().getAnimationContainer()
				.remove(this.getView().getOrders());
		this.getView().setObelix(null);
		this.getView().setOrders(null);

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
