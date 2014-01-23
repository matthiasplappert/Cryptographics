package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * Performs animations for demonstrating Caesar's idea.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoView extends VisualizationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6762667303208572310L;

	/**
	 * Explanation textfield.
	 */
	private JLabel explanations;

	private JPanel inOutPanel;

	private JPanel navigationPanel;

	/**
	 * Input from the user for encryption.
	 */
	private JTextField[] userInput;

	/**
	 * Output from user interaction.
	 */
	private JTextField[] userOutput;

	/**
	 * The alphabet.
	 */
	private AlphabetStripView alphabet;

	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;

	/**
	 * Constructor.
	 */
	public CipherDemoView() {
		super();
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		Element cipherDemoResource = vsInfo.getResources().getChild(
				"CipherDemo");

		// set the layout to GridBagLayout.
		GridBagLayout introLayout = new GridBagLayout();
		this.setLayout(introLayout);

		// set up a container for the navigation Buttons (Next and Back).
		this.navigationPanel = new JPanel(new BorderLayout());
		GridBagConstraints navConst = new GridBagConstraints();
		navConst.anchor = GridBagConstraints.NORTH;
		navConst.weightx = 1.0;
		navConst.weighty = 0.1;
		navConst.gridx = 0;
		navConst.gridy = 0;
		navConst.gridwidth = 13;
		navConst.gridheight = 1;
		navConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.navigationPanel, navConst);

		// TODO: dont instantiate the buttons in the upper class.
		// First need to remove the buttons because they are added in the upper
		// class.
		this.remove(this.getBackButton());
		this.remove(this.getNextButton());

		// set up the alignment of the button back;
		this.setBackButton(new JButton("Back to Introduction!"));
		/*
		 * GridBagConstraints backConst = new GridBagConstraints();
		 * backConst.weightx = 1.0; backConst.weighty = 0.1; backConst.gridx =
		 * 0; backConst.gridy = 0; backConst.gridwidth = 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton("Try it yourself!"));
		/*
		 * GridBagConstraints nextConst = new GridBagConstraints();
		 * nextConst.weightx = 1.0; nextConst.weighty = 0.1; nextConst.gridx =
		 * 10; nextConst.gridy = 1; nextConst.gridwidth = 3;
		 */
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

		// set up the Input and output fields. Because this is a demonstration
		// the fields
		// are filled by the programm and are not editable by the user.
		this.userInput = new JTextField[4];
		this.userOutput = new JTextField[4];
		this.inOutPanel = new JPanel(new GridBagLayout());
		GridBagConstraints panelConst = new GridBagConstraints();
		panelConst.anchor = GridBagConstraints.PAGE_START;
		panelConst.weightx = 0.5;
		panelConst.weighty = 0.5;
		panelConst.gridx = 1;
		panelConst.gridy = 1;
		panelConst.gridwidth = 4;
		panelConst.gridheight = 2;
		// panelConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(inOutPanel, panelConst);
		for (int i = 0; i < 4; i++) {
			// fields where the generated input that will be encrypted is
			// presented.
			this.userInput[i] = new JTextField("A");
			this.userInput[i].setEditable(false);
			GridBagConstraints inputConst = new GridBagConstraints();
			inputConst.gridx = i;
			inputConst.gridy = 0;
			// inputConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userInput[i], inputConst);

			// fields where the encrypted input is put in.
			this.userOutput[i] = new JTextField("X");
			this.userOutput[i].setEditable(false);
			GridBagConstraints outConst = new GridBagConstraints();
			outConst.gridx = i;
			outConst.gridy = 1;
			// outConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userOutput[i], outConst);
		}

		// setup the aligment of the button proceed.
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed = new JButton("Proceed!");
		proceedConst.gridx = 2;
		proceedConst.gridy = 3;
		proceedConst.gridwidth = 3;
		this.add(this.proceed, proceedConst);

		// setup the alphabet.
		this.alphabet = new AlphabetStripView();
		GridBagConstraints alphConst = new GridBagConstraints();
		alphConst.anchor = GridBagConstraints.CENTER;
		alphConst.gridx = 1;
		alphConst.gridy = 1;
		alphConst.gridwidth = 26;
		alphConst.gridheight = 2;
		alphConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.alphabet, alphConst);

		this.explanations = new JLabel(
				"<html><body>"
						+ "Now let's see how caesar encrypted his messages, so noone could cross his plans.<br>"
						+ "Click the button 'Proceed!' to proceed the explanation.");
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = GridBagConstraints.LAST_LINE_START;
		expConst.weightx = 0.5;
		expConst.weighty = 0.1;
		expConst.gridx = 0;
		expConst.gridy = 0;
		expConst.gridwidth = 4;
		this.add(this.explanations, expConst);

		this.validate();
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
	}

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return explanations;
	}

	/**
	 * @return the userInput
	 */
	public JTextField[] getUserInput() {
		return userInput;
	}

	/**
	 * @return the userOutput
	 */
	public JTextField[] getUserOutput() {
		return userOutput;
	}

	/**
	 * @return the alphabet
	 */
	public AlphabetStripView getAlphabet() {
		return alphabet;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @param userInput
	 *            the userInput to set
	 */
	public void setUserInput(JTextField[] userInput) {
		this.userInput = userInput;
	}

	/**
	 * @param userOutput
	 *            the userOutput to set
	 */
	public void setUserOutput(JTextField[] userOutput) {
		this.userOutput = userOutput;
	}

	/**
	 * @param alphabet
	 *            the alphabet to set
	 */
	public void setAlphabet(AlphabetStripView alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	/**
	 * @return the inputPanel
	 */
	public JPanel getInputPanel() {
		return inOutPanel;
	}

	/**
	 * @param inputPanel
	 *            the inputPanel to set
	 */
	public void setInputPanel(JPanel inputPanel) {
		this.inOutPanel = inputPanel;
	}

	/**
	 * @return the inOutPanel
	 */
	public JPanel getInOutPanel() {
		return inOutPanel;
	}

	/**
	 * @param inOutPanel the inOutPanel to set
	 */
	public void setInOutPanel(JPanel inOutPanel) {
		this.inOutPanel = inOutPanel;
	}

}
