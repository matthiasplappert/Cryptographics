package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;

/**
 * Controller for the last step of demonstration phase. Controls the needed
 * elements from CaesarUpperView, !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoController extends AbstractVisualizationController {

	private int animationStep;
	
	
	/**
     * 
     */
	private Element cipherDemoResource;
	
	/**
	 * @param visualizationInfo
	 */
	public CipherDemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public void loadView() {
		CaesarVisualizationInfo vsInfo = (CaesarVisualizationInfo) this
				.getVisualizationInfo();
		this.cipherDemoResource = vsInfo.getResources().getChild("CipherDemo");
		GridBagLayout introLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.view = new CipherDemoView();
		this.getView().setLayout(introLayout);
        this.animationStep = 1;

		c.gridx = 0;
		c.gridy = 2;
		introLayout.setConstraints(this.getView().getBackButton(), c);
		c.gridx = 2;
		c.gridy = 2;
		introLayout.setConstraints(this.getView().getNextButton(), c);
		this.getView().setProceed(new JButton("proceed"));
		this.getView().add(this.getView().getProceed());
		
		this.getView().setExplanations(new JLabel("Demonstration of the cipher"));
		this.getView().add(this.getView().getExplanations());

		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
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
				animationStart(getAnimationStep());
			}
		});

		this.getView().validate();
	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return animationStep;
	}

	/**
	 * Function for performing the needed animations. After each step the
	 * animation stops and continues when user wishes.
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
			animationDone();
		}

	}

	/**
	 * Explain the elements on the screen. Only explanations are shown.
	 */
	private void step1() {
		this.animationStep++;
		this.getView().setUserInput(new JLabel(cipherDemoResource.getChild("input").getAttributeValue("content")));
		this.getView().add(this.getView().getUserInput());
		
		this.getView().setAlphabet(new AlphabetStripView());
		this.getView().add(this.getView().getAlphabet());
		
		this.getView().getExplanations().setText("Lets encrypt the given string " + this.getView().getUserInput().getText());
		
		this.getView().validate();
	}

	/**
	 * Describe how each character is encrypted.
	 */
	private void step2() {

	}

	/**
	 * Describe the general Caesar cipher. (The key can vary from 0-25.)
	 */
	private void step3() {

	}

	/**
	 * Describe that decryption is the same way as encryption.
	 */
	private void step4() {

	}

	/**
	 * 
	 */
	private void animationDone() {

	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public CipherDemoView getView() {
		return (CipherDemoView) this.view;
	}
}
