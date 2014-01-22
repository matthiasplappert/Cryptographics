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

		return "Just click proceed till it works and see the magic.";
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
		this.getView()
				.getExplanation()
				.setText(
						this.getView().getExplanation().getText()
								+ " Zu seinem Unglück reitete der Bote durch den Wald, wo Obelix seine Wildschweine jagte.<br>");

		// set the alignment of the masterPlan image.
		GridBagConstraints courierConstraint = new GridBagConstraints();
		//courierConstraint.anchor = GridBagConstraints.PAGE_END;
		//courierConstraint.weightx = 0.1;
		courierConstraint.gridx = 2;
		courierConstraint.gridy = 0;
		//courierConstraint.fill = GridBagConstraints.HORIZONTAL;

		// take the image from the xml-resource.
		this.getView().setCourier(
				new ImageView(introResource.getChild("courierImage")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer().add(this.getView().getCourier(), courierConstraint);

		// this.getView().firstAnimation();

	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	private void step2() {
		this.animationStep++;
		this.getView()
				.getExplanation()
				.setText(
						this.getView().getExplanation().getText()
								+ " Als Obelix den Boten sah beförderte er ihn via Luftlinie direkt nach Rom zurück! <br>");

		// set the alignment of the masterPlan image.
		GridBagConstraints obelixConstraint = new GridBagConstraints();
		//obelixConstraint.anchor = GridBagConstraints.PAGE_END;
		//obelixConstraint.weightx = 1.0;
		obelixConstraint.gridx = 3;
		obelixConstraint.gridy = 0;
		//obelixConstraint.fill = GridBagConstraints.VERTICAL;

		// take the image from the xml-resource.
		this.getView().setObelix(
				new ImageView(introResource.getChild("obelixImage")
						.getAttributeValue("path")));
		this.getView().getAnimationContainer().add(this.getView().getObelix(), obelixConstraint);

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
						this.getView().getExplanation().getText()
								+ " Beim Lesen der Schriftrolle, die der Bote dabei hatte, erkannte Obelix Caesar's Pläne für <br> "
								+ "den nächsten Angriff und die Gallier besiegten Caesar erneut. Caesar kochte vor Wut. <br>"
								+ "Es ist zu beachten, dass dieser Text gewisse geschichtlichte Ungenauigkeiten auweist.<br>"
								+ "Obelix konnte zum Beispiel kein Römisch!");

		this.getView().validate();
	}

	/**
	 * 
	 */
	private void animationDone() {

	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return animationStep;
	}

	/**
	 * @param animationStep
	 *            the animationStep to set
	 */
	public void setAnimationStep(int animationStep) {
		animationStep = animationStep;
	}

	/**
	 * @return the caesarResource
	 */
	public Element getCaesarResource() {
		return introResource;
	}

}