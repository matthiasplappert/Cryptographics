package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.ImageView;

/**
 * This class is the controller of the view CFirstView.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class IntroductionController extends AbstractVisualizationController {

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
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public IntroductionView getView() {
		return (IntroductionView) this.view;
	}

	@Override
	public String getHelp() {

		return "If you want to hear the awesome legend about caesar "
				+ "and obelix press the button below the text. Else try the next button!";
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
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentNextVisualizationController();
			}
		});

		this.getView().getProceed().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				animationStart(getAnimationStep());

			}
		});

	}

	/**
	 * TODO: Need a less dirty solution. Method for intern state handling.
	 * 
	 * @param c
	 */
	public void animationStart(int step) {
		switch (step) {
		case 1:
			step1();
			break;
		case 2:
			step2();
			break;
		case 3:
			step3();
			break;
		case 4:
			step4();
		}
	}

	/*
	 * TODO: !!!!!!!!!!!!!!!!!!!!!!Für jemanden der sich um die Grafiken kümmern
	 * will!!!!!!!!!!!!!!!!!:Also hier zur Ausnahme auf Deutsch, was auf der Animation passieren
	 * soll: step1. Caesar(lächelnd(am besten bööööse)) komikhaft dargestellt mit einer Glühlampe
	 * auf dem Kopf.
	 * 
	 * step2.Ich brauche ein Bild von einem Männchen, an dem man am besten auch erkennt, dass dies
	 * ein Bote ist. Auf dem Hintergrundbild sollte ein Wald zu sehen sein. Der Bote wird von links
	 * nach rechts bis zum Ende oder 3/4 des Bildschirms laufen. Es muss dabei klar sein, dass der
	 * Bote nach rechts sieht und hinter ihm nichts bemerken kann. (optional auf pfeifend, lächelnd
	 * laufen)
	 * 
	 * 3. Wenn der Bote hinten angekommen ist.(optional: Bildchen wo er sich ausruht). Taucht
	 * ungefähr 1/4 auf der x-Achse des Bildschirms, ein Wildschwein auf. Und läuft nach
	 * links.(Nicht nach rechts, wo der Bote ist.).
	 * 
	 * 4. Da wo das Wildschwein aufgetaucht ist, tauch hinterher Bild vom Obelix auf. Dieser
	 * allerdings dreht sich nach rechts und läuft dem Boden entgegen. Es muss hier deutlich werden,
	 * dass der Bote daovon nichts mitbekommt.
	 * 
	 * 5. Obelix haut den Boden(Wie egal) und der Bote fliegt vertikal nach Oben und da wo der Bote
	 * war, erscheint eine Schriftrolle.
	 * 
	 * 6.Obelix lesend dargestellt.(Wie ist egal).
	 * 
	 * 7. Caesar mit teuflischem Grinsen.(optional auch mit reibenden Händen.)
	 */
	private void step1() {
		this.animationStep++;
		this.getView().getAnimationContainer()
				.remove(this.getView().getCaesarIdeaImg());
		this.getView().setCaesarIdeaImg(null);
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Zu seinem Unglück ging der Bote durch den Wald, wo Obelix seine Wildschweine jagte.<br>");

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
				new ImageView(introResource.getChild("Courier")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getCourier(), courierConstraint);
		// setup the background.
		this.getView().setBackgroundImg(
				new ImageView(this.introResource.getChild("ForestBackground")
						.getAttributeValue("path")));
		// TODO: set the background of the animation panel to the background image!!!

		this.getView().getAnimationContainer().repaint();
		this.getView().setxCoordCourier(this.getView().getCourier().getX());
		// TODO: Animation doesn't work correctly.
		// this.getView().firstAnimation();

	}

	// TODO: Background have to stay the same thoughout till step
	private void step2() {
		this.animationStep++;
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Als Obelix den nichts ahnenden Boten entdeckte beförderte er ihn via Luftlinie direkt nach Rom zurück! <br>");

		// set the alignment of boar.
		GridBagConstraints boarConst = new GridBagConstraints();
		boarConst.gridx = 4;
		boarConst.gridy = 0;
		this.getView().setBoar(
				new ImageView(introResource.getChild("Boar").getAttributeValue(
						"path")));
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
				new ImageView(introResource.getChild("Obelix")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getObelix(), obelixConstraint);

		// TODO: Animationd doesn't work.
		// this.getView().secondAnimation();
	}

	// TODO: Obelix reads the orders.
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
						"<html><body>Beim Lesen der Schriftrolle, die der Bote dabei hatte, erkannte Obelix Caesar's Pläne für <br> "
								+ "den nächsten Angriff und die Gallier besiegten Caesar erneut. <br>");

		GridBagConstraints orderConstraints = new GridBagConstraints();
		orderConstraints.gridx = 5;
		orderConstraints.gridy = 0;
		this.getView().setOrders(
				new ImageView(introResource.getChild("Orders")
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
		// TODO: remove the background!

		this.getView()
				.getExplanation()
				.setText(
						"<html><body>"
								+ "Zur Beruhigung ließ Caesar erstmal ein paar arme Schweine auspeitschen und anschließend fiel<br>"
								+ "ihm ein idiotensicherer Plan ein: Bei seinem nächsten Brief wird er seinen Namen verschlüsseln.<br>"
								+ " Muhahaha! Helfe ihm dabei!!");
		
		GridBagLayout introLayout = (GridBagLayout) this.getView().getLayout();
		this.getView().getNextButton().setText("To caesar's idea");
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
		return animationStep;
	}

}