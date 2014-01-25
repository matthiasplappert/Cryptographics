package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This view appears first when user finished understanding the animations from the CFirstView. It
 * is used in the last step of the demonstration phase, in the first and second step of the
 * experiment phase. Because of the small differences between the views of those steps the view is
 * packed in only one Class.
 * 
 * The differences are: 1. When in last step of demonstration phase the explanations JTextField is
 * visible and contains needed explanations. Also the JTextField for the input from the user is
 * disabled. UserOutput is disabled and invisible as well. Also the alphabet is not clickable. And
 * UserInput contains generated String from the program and no real user input.
 * 
 * 2. When in first step of the experiment phase input is enabled for user input. And the
 * explanation textfield is disabled throughout the whole experiment phase. Alphabet becomes also
 * clickable.
 * 
 * 3. UserOutput is only shown when needed.
 * 
 * This view provides elements that allow the user to encrypt his input and decrypt the generated
 * cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoView extends VisualizationView {
	// TODO: The View is almost the same as the one in the CryptoDemoView!!!
	// Need to refactor when possible!

	// private JButton introduction;
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

	private JTextField key;

	private JButton generator;

	private JButton proceed;

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

	private KeyboardView keyboard;

	private Element cryptoResource;

	/**
	 * Constructor.
	 */
	public CryptoView() {
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.cryptoResource = vsInfo.getResources().getChild("Encrypt");

		// set the layout to GridBagLayout.
		GridBagLayout introLayout = new GridBagLayout();
		this.setLayout(introLayout);
		GridBagConstraints viewConst = new GridBagConstraints();
		viewConst.weightx = 1.0;
		viewConst.weighty = 1.0;
		viewConst.gridwidth = 3;
		viewConst.gridheight = 4;
		introLayout.setConstraints(this, viewConst);
		this.keyboard = new KeyboardView();

		// setups the next and back buttons.
		setupNavigation();

		// setup the input/output elements for further steps.
		setupInOut();

		// setup the explanations.
		this.explanations = new JLabel(
				"<html><body> "
						+ "Ok. Previously you saw that you can encrypt a message with the traditional Caesar cipher<br>"
						+ "when you shift each letter 3 positions next in the alphabet. Lets think a little further.<br>"
						+ "When we can shift 3 positions to substitute A with D, then we can also shift 1,2,4,5,6,...,25 positions.<br>"
						+ "And substitute A with some other letter. The shif value is called the 'Key'. The Key in the examples before was 3.<br>"
						+ "The key is needed when you want to decrypt a cipher. Without the key it would costs much more effort<br>"
						+ " and in most cases uneligible. <br>"
						+ "Now you have 2 options:<br>"
						+ "<br>"
						+ "1. You put you own key and plaintext into the textfield.<br>"
						+ "<br>"
						+ "2.Or you just click generate and this awesome programm generates you everything you need with real real complex calculations.");
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = GridBagConstraints.PAGE_START;
		expConst.weightx = 0.5;
		expConst.weighty = 1.0;
		expConst.gridx = 0;
		expConst.gridy = 2;
		expConst.gridwidth = 2;
		this.add(this.explanations, expConst);

		// build the user interface.
		this.inOutPanel.validate();

		// build elements.
		this.validate();
	}

	private void setupInOut() {
		// set the Container for the user interface.
		this.inOutPanel = new JPanel(new GridBagLayout());
		// this.input.setAlignmentY(JTextField.TOP_ALIGNMENT);
		GridBagConstraints inConst = new GridBagConstraints();
		inConst.anchor = GridBagConstraints.CENTER;
		inConst.weightx = 0.5;
		inConst.weighty = 0.5;
		inConst.gridx = 0;
		inConst.gridy = 0;
		inConst.gridheight = 4;
		inConst.gridwidth = 3;
		this.add(this.inOutPanel, inConst);

		// add the input field.
		this.input = new JTextField("Put your name here.");
		this.input.setPreferredSize(new Dimension(150, 25));
		GridBagConstraints inputConst = new GridBagConstraints();
		// inputConst.anchor = GridBagConstraints.FIRST_LINE_START;
		// inputConst.weightx = 1.0;
		// inputConst.weighty = 0.1;
		inputConst.gridx = 0;
		inputConst.gridy = 0;
		inputConst.insets = new Insets(0, 0, 0, 50);
		this.inOutPanel.add(this.input, inputConst);
		// add the key-input field.
		this.key = new JTextField("Key");
		this.key.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 2;
		keyConst.gridy = 0;
		this.inOutPanel.add(this.key, keyConst);

		// add the button for generating input if the user is too lazy.
		this.generator = new JButton("Generate letters!");
		GridBagConstraints genConst = new GridBagConstraints();
		genConst.weightx = 1.0;
		genConst.gridx = 0;
		genConst.gridy = 1;
		genConst.gridwidth = 3;
		genConst.fill = GridBagConstraints.HORIZONTAL;
		// this.generator.setVerticalAlignment(JButton.BOTTOM);
		this.inOutPanel.add(this.generator, genConst);
	}

	private void setupNavigation() {
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
		 * GridBagConstraints backConst = new GridBagConstraints(); backConst.weightx = 1.0;
		 * backConst.weighty = 0.1; backConst.gridx = 0; backConst.gridy = 0; backConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton("Go to Decryption!"));

		/*
		 * GridBagConstraints nextConst = new GridBagConstraints(); nextConst.weightx = 1.0;
		 * nextConst.weighty = 0.1; nextConst.gridx = 10; nextConst.gridy = 1; nextConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

		// this.introduction = new JButton("Back to Introduction");
		// this.navigationPanel.add(this.introduction, BorderLayout.WEST);

	}

	/**
	 * Creates the keyboard and shows it in the main container.
	 */
	public void createKeyboard() {
		GridBagConstraints kbConst = new GridBagConstraints();
		kbConst.anchor = GridBagConstraints.PAGE_END;
		kbConst.weightx = 1.0;
		kbConst.weighty = 0.5;
		kbConst.gridx = 0;
		kbConst.gridy = 0;
		kbConst.gridwidth = 11;
		kbConst.gridheight = 3;
		this.add(this.keyboard, kbConst);
		this.validate();
	}

	/**
	 * Called when the user done the needed input in a valid way.
	 * 
	 * @param inputChars
	 */
	public void start(char[] inputChars, int key) {
		// User input will be now filled into the boxes. This field is not
		// needed anymore.
		this.remove(this.inOutPanel);
		this.inOutPanel = null;
		this.remove(this.explanations);
		this.explanations = null;
		this.repaint();

		// setupInOut()!
		setupInOutElements(inputChars, key);

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

		// setup the explanations.
		this.explanations = new JLabel("<html><body>"
				+ "Your turn comrade! Remember: You need to add to each <br>"
				+ "number that is assigned to a letter + 3 and see what <br>"
				+ "letter the result is. For Example A(0) + 3 = D(3).");
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = GridBagConstraints.LAST_LINE_START;
		expConst.weightx = 0.5;
		expConst.weighty = 0.1;
		expConst.gridx = 0;
		expConst.gridy = 0;
		expConst.gridwidth = 4;
		this.add(this.explanations, expConst);

		// build the new view.
		this.validate();
	}

	public void setupInOutElements(char[] inputChars, int key) {

		// set up the Input and output fields. Because this is a demonstration
		// the fields
		// are filled by the programm and are not editable by the user.
		this.userInput = new JTextField[inputChars.length];
		this.userOutput = new JTextField[inputChars.length];
		this.inOutPanel = new JPanel(new GridBagLayout());
		GridBagConstraints panelConst = new GridBagConstraints();
		panelConst.anchor = GridBagConstraints.PAGE_START;
		panelConst.weightx = 0.5;
		panelConst.weighty = 0.5;
		panelConst.gridx = 1;
		panelConst.gridy = 1;
		panelConst.gridwidth = inputChars.length * 4;
		panelConst.gridheight = 2;
		// panelConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(inOutPanel, panelConst);

		for (int i = 0; i <= inputChars.length; i++) {
			// called only in the last iteration, when all Elements are already created.
			if (i == inputChars.length) {
				GridBagConstraints keyConst = new GridBagConstraints();
				this.key.setText("" + key);
				this.key.setPreferredSize(new Dimension(25, 25));
				this.key.setFont(new Font("Arial", 2, 25));
				this.key.setEditable(false);
				keyConst.insets = new Insets(25, 25, 25, 25);
				keyConst.gridx = i;
				keyConst.gridy = 0;
				keyConst.ipadx = 20;
				keyConst.ipady = 20;
				this.inOutPanel.add(this.key, keyConst);
				break;
			}
			// fields where the input will be encrypted
			this.userInput[i] = new JTextField();
			this.userInput[i].setText("" + inputChars[i]);
			this.userInput[i].setBorder(null);
			this.userInput[i].setFont(new Font("Arial", 2, 25));
			this.userInput[i].setEditable(false);
			this.userInput[i].setPreferredSize(new Dimension(25, 25));
			GridBagConstraints inputConst = new GridBagConstraints();
			// inputConst.weightx = 0.5;
			// inputConst.weighty = 0.1;
			inputConst.insets = new Insets(25, 25, 25, 25);
			inputConst.gridx = i;
			inputConst.gridy = 0;
			inputConst.ipadx = 20;
			inputConst.ipady = 20;
			// inputConst.gridwidth = 4;
			// inputConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userInput[i], inputConst);

			// fields where the encrypted input is put in.
			this.userOutput[i] = new JTextField();
			this.userOutput[i].setFont(new Font("Arial", 2, 25));
			this.userOutput[i].setName("" + inputChars[i]);
			this.userOutput[i].setPreferredSize(new Dimension(25, 25));
			// TODO: Limit the userOutput JTextField to input size 1!

			// this.userOutput[i].setInputVerifier(new InputVerifier() {
			//
			// @Override
			// public boolean verify(JComponent input) {
			// JTextField output = (JTextField) input;
			// if (output.getText().length() == 1) {
			// return true;
			// }
			// return false;
			// }
			// });
			// needed later when checking if the
			// encrypted char of the plain letter
			// was valid!
			this.userOutput[i].setBorder(null);
			GridBagConstraints outConst = new GridBagConstraints();
			// outConst.weightx = 0.5;
			// outConst.weighty = 0.1;
			outConst.gridx = i;
			outConst.gridy = 1;
			outConst.ipadx = 20;
			outConst.ipady = 20;
			outConst.insets = new Insets(25, 25, 25, 25);
			// outConst.gridwidth = 4;
			// outConst.fill = GridBagConstraints.HORIZONTAL;
			this.inOutPanel.add(userOutput[i], outConst);
			this.inOutPanel.validate();
		}
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

	/**
	 * @return the generator
	 */
	public JButton getGenerator() {
		return generator;
	}

	/**
	 * @param generator
	 *            the generator to set
	 */
	public void setGenerator(JButton generator) {
		this.generator = generator;
	}

	/**
	 * @return the alphabet
	 */
	public AlphabetStripView getAlphabet() {
		return alphabet;
	}

	/**
	 * @return the keyboard
	 */
	public KeyboardView getKeyboard() {
		return keyboard;
	}

	/**
	 * @param keyboard
	 *            the keyboard to set
	 */
	public void setKeyboard(KeyboardView keyboard) {
		this.keyboard = keyboard;
	}

	/**
	 * @return the key
	 */
	public JTextField getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(JTextField key) {
		this.key = key;
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	/**
	 * @return the cryptoResource
	 */
	public Element getCryptoResource() {
		return cryptoResource;
	}

	/**
	 * @param cryptoResource
	 *            the cryptoResource to set
	 */
	public void setCryptoResource(Element cryptoResource) {
		this.cryptoResource = cryptoResource;
	}

}
