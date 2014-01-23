package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This view appears first when user finished understanding the animations from
 * the CFirstView. It is used in the last step of the demonstration phase, in
 * the first and second step of the experiment phase. Because of the small
 * differences between the views of those steps the view is packed in only one
 * Class.
 * 
 * The differences are: 1. When in last step of demonstration phase the
 * explanations JTextField is visible and contains needed explanations. Also the
 * JTextField for the input from the user is disabled. UserOutput is disabled
 * and invisible as well. Also the alphabet is not clickable. And UserInput
 * contains generated String from the program and no real user input.
 * 
 * 2. When in first step of the experiment phase input is enabled for user
 * input. And the explanation textfield is disabled throughout the whole
 * experiment phase. Alphabet becomes also clickable.
 * 
 * 3. UserOutput is only shown when needed.
 * 
 * This view provides elements that allow the user to encrypt his input and
 * decrypt the generated cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoView extends VisualizationView {
	// TODO: The View is almost the same as the one in the CryptoDemoView!!!
	// Need to refactor when possible!
	/**
	 * Dies Das ananas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Explanation textfield.
	 */
	private JLabel explanations;

	private JPanel inOutPanel;

	private JPanel navigationPanel;

	/**
	 * Textfield for user input. Used in experiment.
	 */
	private JTextField input;

	private JButton generator;

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
	 * Constructor.
	 */
	public CryptoView() {
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		Element cipherDemoResource = vsInfo.getResources().getChild(
				"Encrypt");

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
		this.setBackButton(new JButton("Back to Demonstration!"));
		/*
		 * GridBagConstraints backConst = new GridBagConstraints();
		 * backConst.weightx = 1.0; backConst.weighty = 0.1; backConst.gridx =
		 * 0; backConst.gridy = 0; backConst.gridwidth = 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton("Go to Decryption!"));
	
		/*
		 * GridBagConstraints nextConst = new GridBagConstraints();
		 * nextConst.weightx = 1.0; nextConst.weighty = 0.1; nextConst.gridx =
		 * 10; nextConst.gridy = 1; nextConst.gridwidth = 3;
		 */
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

		this.inOutPanel = new JPanel(new GridLayout(1, 2));
		this.input = new JTextField("Put your name in here and click enter! Or let the programm generate some letters!");

		GridBagConstraints inConst = new GridBagConstraints();
		inConst.anchor = GridBagConstraints.CENTER;
		inConst.weightx = 0.5;
		inConst.weighty = 0.5;
		inConst.gridx = 0;
		inConst.gridy = 0;
		this.add(this.inOutPanel, inConst);
		this.inOutPanel.add(this.input);

		// add the button for generating input if the user is too lazy.
		this.generator = new JButton("Generate a string!");
		this.inOutPanel.add(this.generator);
		this.inOutPanel.validate();

		// build elements.
		this.validate();
	}

	public void start(String inputString) {
		//refactor the input into an character array.
		char[] inputChars = new char[inputString.length()];
		
		inputString.getChars(0, inputString.length(), inputChars, 0);
		
		// User input will be now filled into the boxes. This field is not
		// needed anymore.
		this.remove(this.inOutPanel);
		this.inOutPanel = null;
		this.repaint();

		// set up the Input and output fields. Because this is a demonstration
		// the fields
		// are filled by the programm and are not editable by the user.
		this.userInput = new JTextField[inputString.length()];
		this.userOutput = new JTextField[inputString.length()];
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
		for (int i = 0; i < inputString.length(); i++) {
			// fields where the generated input that will be encrypted is
			// presented.
			this.userInput[i] = new JTextField(inputChars[i]);
			this.userInput[i].setEditable(false);
			GridBagConstraints inputConst = new GridBagConstraints();
			inputConst.gridx = i;
			inputConst.gridy = 0;
			// inputConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userInput[i], inputConst);

			// fields where the encrypted input is put in.
			this.userOutput[i] = new JTextField("X");
			GridBagConstraints outConst = new GridBagConstraints();
			outConst.gridx = i;
			outConst.gridy = 1;
			// outConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userOutput[i], outConst);
		}

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

		this.explanations = new JLabel("<html><body>" + "Your turn my friend!");
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
	 * Enlightens the needed JLabel.
	 */
	private void lightsOn(JLabel label) {
		// on/off
	}

	/**
	 * Sets the character c as the content of the JLabel label.
	 * 
	 * @param label
	 * @param c
	 */
	private void setContent(JLabel label, char c) {

	}

	/**
	 * Inserts the input from the user or the generated input from the program
	 * into the JLabel Array and displays it.
	 * 
	 * @param input
	 */
	public void insertInput(String input) {

	}

	/**
	 * @return input
	 */
	public JTextField getInput() {
		return input;
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
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return explanations;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @return the inOutPanel
	 */
	public JPanel getInOutPanel() {
		return inOutPanel;
	}

	/**
	 * @param inOutPanel
	 *            the inOutPanel to set
	 */
	public void setInOutPanel(JPanel inOutPanel) {
		this.inOutPanel = inOutPanel;
	}

	/**
	 * @return the navigationPanel
	 */
	public JPanel getNavigationPanel() {
		return navigationPanel;
	}

	/**
	 * @param navigationPanel
	 *            the navigationPanel to set
	 */
	public void setNavigationPanel(JPanel navigationPanel) {
		this.navigationPanel = navigationPanel;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(JTextField input) {
		this.input = input;
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

}
