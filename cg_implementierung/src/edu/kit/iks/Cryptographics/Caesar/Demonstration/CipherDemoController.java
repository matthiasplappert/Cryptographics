package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
		this.view = new CipherDemoView();
		this.animationStep = 1;

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
		this.getView()
				.getExplanations()
				.setText(
						"<html><body> "
								+ "In the middle of the screen you see the german alphabet(red). When it comes to encrypting <br>"
								+ "or decrypting readable text it is very helpful to have an alphabet at hand. The numbers <br>"
								+ "below the letters make it possible to 'calculate' with letters. For expample if you want <br>"
								+ "to add A + B you look for the numbers of those letters and add them. Here you have A = 1, <br>"
								+ "B = 2, so the result would be 1 + 2 = 3. Then you look to the alphabet and see that C has <br>"
								+ "the number 3. The result of adding A + B would be C!");
		this.getView().getAlphabet()
				.setBorder(BorderFactory.createLineBorder(Color.red));
		this.getView().validate();
	}

	/**
	 * Describe how each character is encrypted.
	 */
	private void step2() {
		this.animationStep++;
		this.getView()
				.getExplanations()
				.setText(
						"<html><body>"
								+ "The boxes above the alphabet (green) contain a small sequence of letters to encrypt and finally <br>"
								+ "the encrypted letters. The upper boxes are the input and the lower one the output. In the next <br>"
								+ "step we will start to encrypt the given word.");
		this.getView().getAlphabet().setBorder(null);
		this.getView().getInOutPanel()
				.setBorder(BorderFactory.createLineBorder(Color.green));
		this.getView().validate();
	}

	/**
	 * Describe the general Caesar cipher. (The key can vary from 0-25.)
	 */
	private void step3() {
		this.animationStep++;
		this.getView().getInOutPanel().setBorder(null);
		this.getView()
				.getExplanations()
				.setText(
						"<html><body>"
								+ "The main idea caesar used was to substitute each letter with the one that is 3 positions next to him.<br>"
								+ "Lets see at out input. The first letter is 'A'. If caesar wanted to encrypt this letter he looked 3 <br>"
								+ "positions next to it and found 'C'. Alternatively and also more elegant is just to look for the number <br>"
								+ "of the letter A and add to it 3 and see what letter correspond to this number. Here we would have A = 0 <br>"
								+ "and 0 + 3 = 3, this is the letter 'C'. Let's see what our example looks like when we encrypt it. Click proceed");
		this.getView().validate();

	}

	/**
	 * Describe that decryption is the same way as encryption.
	 */
	private void step4() {
      this.animationStep++;
      String firstLetter = this.getView().getUserInput()[0].getText();
    //  this.getView().getExplanations().setText("The first letter is "+firstLetter+""
      
	}

	/**
	 * 
	 */
	private void encryptExample() {

	}

	@Override
	public String getHelp() {
		return "Not sure if much Help needed here.";
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
