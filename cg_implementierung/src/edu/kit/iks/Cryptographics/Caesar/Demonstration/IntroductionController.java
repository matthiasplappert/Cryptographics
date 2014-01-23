package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	 * Variable holding track of the current step user has proceeded in the
	 * animation. if it is 0, then it is the last step.
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
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
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
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
				animationProceed(getAnimationStep());

			}
		});

	}

	/**
	 * Needed for dispatching the clickEvent from the button to activate the
	 * animation of the view.
	 */
	public void animationProceed(int step) {
		this.animationStart(step);
	}

	/**
	 * Method for
	 * 
	 * @param c
	 */
	private void animationStart(int step) {
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
			animationDone();
		}
	}

	/**
	 * Caesar makes up a big plan and sends his orders by his messenger.
	 */
	private void step1() {
		this.animationStep++;
		this.getView().getAnimationContainer()
				.remove(this.getView().getMasterPlan());
		this.getView().setMasterPlan(null);
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Zu seinem Unglück reitete der Bote durch den Wald, wo Obelix seine Wildschweine jagte.<br>");

		this.getView().getAnimationContainer().setBackground(Color.GREEN);
		// set the alignment of the masterPlan image.
		GridBagConstraints courierConstraint = new GridBagConstraints();
		// courierConstraint.anchor = GridBagConstraints.PAGE_END;
		// courierConstraint.weightx = 0.1;
		courierConstraint.anchor = GridBagConstraints.WEST;
		courierConstraint.weightx = 1.0;
		courierConstraint.weighty = 0.1;
		courierConstraint.gridx = 0;
		courierConstraint.gridy = 0;
	    courierConstraint.fill = GridBagConstraints.HORIZONTAL;

		// take the image from the xml-resource.
		this.getView().setCourier(
				new ImageView(introResource.getChild("courierImage")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getCourier(), courierConstraint);

		this.getView().getAnimationContainer().repaint();
		this.getView().firstAnimation();

	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	private void step2() {
		this.animationStep++;
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Als Obelix den Boten sah beförderte er ihn via Luftlinie direkt nach Rom zurück! <br>");

		// set the alignment of the masterPlan image.
		GridBagConstraints obelixConstraint = new GridBagConstraints();
		// obelixConstraint.anchor = GridBagConstraints.PAGE_END;
		// obelixConstraint.weightx = 1.0;
		obelixConstraint.gridx = 3;
		obelixConstraint.gridy = 0;
		// obelixConstraint.fill = GridBagConstraints.VERTICAL;

		// take the image from the xml-resource.
		this.getView().setObelix(
				new ImageView(introResource.getChild("obelixImage")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer()
				.add(this.getView().getObelix(), obelixConstraint);

		// this.getView().secondAnimation();
	}

	/**
	 * Enemy reads his orders and Caesar's big plan is crossed.
	 */
	private void step3() {
		this.animationStep++;
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Beim Lesen der Schriftrolle, die der Bote dabei hatte, erkannte Obelix Caesar's Pläne für <br> "
								+ "den nächsten Angriff und die Gallier besiegten Caesar erneut. Caesar kochte vor Wut. <br>");

		this.getView().validate();
	}

	/**
	 * 
	 */
	private void animationDone() {
		this.getView()
				.getExplanation()
				.setText(
						"<html><body>Es ist zu beachten, dass dieser Text gewisse geschichtlichte Ungenauigkeiten auweist.<br>"
								+ "Obelix konnte zum Beispiel kein Römisch!");
		GridBagLayout introLayout = (GridBagLayout) this.getView().getLayout();
		this.getView().getNextButton().setText("To caesar's idea");
		GridBagConstraints finishConstraint = new GridBagConstraints();
		finishConstraint.gridx = 1;
		finishConstraint.gridy = 2;
		introLayout.setConstraints(this.getView().getNextButton(),
				finishConstraint);
		this.getView().remove(this.getView().getProceed());
		this.getView().setProceed(null);
	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return animationStep;
	}

}