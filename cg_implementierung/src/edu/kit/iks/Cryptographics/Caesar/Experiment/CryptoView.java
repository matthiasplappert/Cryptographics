package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The alphabet.
	 */
	private AlphabetStripView alphabet;

	private Element cryptoResource;

	// private JButton introduction;
	/**
	 * Explanation textfield.
	 */
	private JLabel explanations;

	private JButton generator;
	private JPanel inOutPanel;

	/**
	 * Textfield for user input. Used in experiment.
	 */
	private JTextField input;
	private JLabel inputCaption;

	private JTextField key;

	private KeyboardView keyboard;

	private JLabel keyCaption;

	private JPanel navigationPanel;

	private JButton proceed;

	/**
	 * Input from the user for encryption.
	 */
	private JLabel[] userInput;

	/**
	 * Output from user interaction.
	 */
	private JTextField[] userOutput;

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

		// setups the next and back buttons.
		this.setupNavigation();

		// setup the input/output elements for further steps.
		this.setupInOut();

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
		// this.explanations.setFont(new Font("Arial", 2, 20));
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = GridBagConstraints.PAGE_START;
		expConst.weightx = 0.5;
		expConst.weighty = 1.0;
		expConst.gridx = 0;
		expConst.gridy = 1;
		expConst.gridwidth = 2;
		expConst.gridheight = 1;
		this.add(this.explanations, expConst);

		// build the user interface.
		this.inOutPanel.validate();

		// build elements.
		this.validate();
	}

	/**
	 * Creates the keyboard and shows it in the main container.
	 */
	public void createKeyboard(JTextField input, final int flag) {
		this.keyboard = new KeyboardView(input, flag);
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
	 * @return the alphabet
	 */
	public AlphabetStripView getAlphabet() {
		return this.alphabet;
	}

	/**
	 * @return the cryptoResource
	 */
	public Element getCryptoResource() {
		return this.cryptoResource;
	}

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return this.explanations;
	}

	/**
	 * @return the generator
	 */
	public JButton getGenerator() {
		return this.generator;
	}

	/**
	 * @return the inOutPanel
	 */
	public JPanel getInOutPanel() {
		return this.inOutPanel;
	}

	/**
	 * @return input
	 */
	public JTextField getInput() {
		return this.input;
	}

	/**
	 * @return the key
	 */
	public JTextField getKey() {
		return this.key;
	}

	/**
	 * @return the keyboard
	 */
	public KeyboardView getKeyboard() {
		return this.keyboard;
	}

	/**
	 * @return the navigationPanel
	 */
	public JPanel getNavigationPanel() {
		return this.navigationPanel;
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return this.proceed;
	}

	/**
	 * @return the userInput
	 */
	public JLabel[] getUserInput() {
		return this.userInput;
	}

	/**
	 * @return the userOutput
	 */
	public JTextField[] getUserOutput() {
		return this.userOutput;
	}

	/**
	 * @param alphabet
	 *            the alphabet to set
	 */
	public void setAlphabet(AlphabetStripView alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * @param cryptoResource
	 *            the cryptoResource to set
	 */
	public void setCryptoResource(Element cryptoResource) {
		this.cryptoResource = cryptoResource;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @param generator
	 *            the generator to set
	 */
	public void setGenerator(JButton generator) {
		this.generator = generator;
	}

	/**
	 * @param inOutPanel
	 *            the inOutPanel to set
	 */
	public void setInOutPanel(JPanel inOutPanel) {
		this.inOutPanel = inOutPanel;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(JTextField input) {
		this.input = input;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(JTextField key) {
		this.key = key;
	}

	/**
	 * @param keyboard
	 *            the keyboard to set
	 */
	public void setKeyboard(KeyboardView keyboard) {
		this.keyboard = keyboard;
	}

	/**
	 * @param navigationPanel
	 *            the navigationPanel to set
	 */
	public void setNavigationPanel(JPanel navigationPanel) {
		this.navigationPanel = navigationPanel;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	private void setupInOut() {
		// set the Container for the user interface.
		this.inOutPanel = new JPanel(new GridBagLayout());
		// this.input.setAlignmentY(JTextField.TOP_ALIGNMENT);
		GridBagConstraints inConst = new GridBagConstraints();
		inConst.anchor = GridBagConstraints.CENTER;
		inConst.weightx = 0.5;
		inConst.weighty = 1.0;
		inConst.gridx = 0;
		inConst.gridy = 2;
		inConst.gridheight = 6;
		inConst.gridwidth = 3;
		this.add(this.inOutPanel, inConst);

		// add the input field.
		this.input = new JTextField();
		this.input.setPreferredSize(new Dimension(250, 50));
		// this.input.setFont(new Font("Arial", 2, 25));
		GridBagConstraints inputConst = new GridBagConstraints();
		// inputConst.anchor = GridBagConstraints.FIRST_LINE_START;
		// inputConst.weightx = 1.0;
		// inputConst.weighty = 0.1;
		inputConst.gridx = 0;
		inputConst.gridy = 1;
		inputConst.insets = new Insets(0, 0, 0, 50);
		this.inOutPanel.add(this.input, inputConst);
		this.input.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption of the input field.
		this.inputCaption = new JLabel("Put your name in here!");
		GridBagConstraints capConst = new GridBagConstraints();
		// inputConst.anchor = GridBagConstraints.FIRST_LINE_START;
		// inputConst.weightx = 1.0;
		// inputConst.weighty = 0.1;
		capConst.gridx = 0;
		capConst.gridy = 0;
		capConst.insets = new Insets(0, 0, 0, 50);
		this.inOutPanel.add(this.inputCaption, capConst);

		// add the key-input field.
		this.key = new JTextField();
		this.key.setPreferredSize(new Dimension(50, 50));
		// this.key.setFont(new Font("Arial", 2, 20));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 2;
		keyConst.gridy = 1;
		this.inOutPanel.add(this.key, keyConst);
		this.key.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption for the input field.
		this.keyCaption = new JLabel("Key");
		GridBagConstraints keyCapConst = new GridBagConstraints();
		// inputConst.anchor = GridBagConstraints.FIRST_LINE_START;
		// inputConst.weightx = 1.0;
		// inputConst.weighty = 0.1;
		keyCapConst.gridx = 2;
		keyCapConst.gridy = 0;
		// keyCapConst.fill = GridBagConstraints.HORIZONTAL;
		this.inOutPanel.add(this.keyCaption, keyCapConst);

		// add the button for generating input if the user is too lazy.
		this.generator = new JButton("Generate letters!");
		this.generator.setPreferredSize(new Dimension(300, 50));
		// this.generator.setFont(new Font("Arial", 2, 25));
		GridBagConstraints genConst = new GridBagConstraints();
		genConst.weightx = 1.0;
		genConst.gridx = 0;
		genConst.gridy = 2;
		genConst.gridwidth = 3;
		// genConst.fill = GridBagConstraints.BOTH;
		// this.generator.setVerticalAlignment(JButton.BOTTOM);
		this.inOutPanel.add(this.generator, genConst);
	}

	public void setupInOutElements(char[] inputChars, int key) {

		// set up the Input and output fields. Because this is a demonstration
		// the fields
		// are filled by the programm and are not editable by the user.
		this.userInput = new JLabel[inputChars.length];
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
		this.add(this.inOutPanel, panelConst);

		for (int i = 0; i <= inputChars.length; i++) {
			// called only in the last iteration, when all Elements are already created.
			if (i == inputChars.length) {
				GridBagConstraints keyConst = new GridBagConstraints();
				this.key.setText("" + key);
				this.key.setPreferredSize(new Dimension(25, 25));
				// this.key.setFont(new Font("Arial", 2, 25));
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
			this.userInput[i] = new JLabel();
			this.userInput[i].setText("" + inputChars[i]);
			this.userInput[i].setBorder(null);
			this.userInput[i].setPreferredSize(new Dimension(25, 25));
			GridBagConstraints inputConst = new GridBagConstraints();
			inputConst.insets = new Insets(25, 25, 25, 25);
			inputConst.gridx = i;
			inputConst.gridy = 0;
			inputConst.ipadx = 20;
			inputConst.ipady = 20;
			this.inOutPanel.add(this.userInput[i], inputConst);

			// fields where the encrypted input is put in.
			this.userOutput[i] = new JTextField();
			this.userOutput[i].setName("" + inputChars[i]);
			this.userOutput[i].setPreferredSize(new Dimension(25, 25));
			this.userOutput[i].setOpaque(true);
			this.userOutput[i].setBorder(BorderFactory
					.createLineBorder(Color.darkGray));
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
			this.inOutPanel.add(this.userOutput[i], outConst);
			this.inOutPanel.validate();
		}
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
		this.setBackButton(new JButton("Back to demonstration"));
		this.getBackButton().setPreferredSize(new Dimension(350, 50));
		// this.getBackButton().setFont(new Font("Arial", 2, 25));
		/*
		 * GridBagConstraints backConst = new GridBagConstraints(); backConst.weightx = 1.0;
		 * backConst.weighty = 0.1; backConst.gridx = 0; backConst.gridy = 0; backConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton("Go to decryption"));
		this.getNextButton().setPreferredSize(new Dimension(300, 50));
		// this.getNextButton().setFont(new Font("Arial", 2, 25));
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
	 * @param userInput
	 *            the userInput to set
	 */
	public void setUserInput(JLabel[] userInput) {
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
		this.setupInOutElements(inputChars, key);

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
		this.explanations = new JLabel(
				"<html><body>"
						+ "Now it is up to you. Test your skills. Remember the key is "
						+ key
						+ ".<br>"
						+ "You need to add the key to the position of the letter your want to shift to get<br>"
						+ "the needed cipher. If you get a bigger number then 25 you need to subtract 25 from it. <br>"
						+ "For example: You want to encrypt x with the key 3. When you add 3 to X you get 23 + 3 = 26. <br>"
						+ "26 is obvious bigger then 25. Then you subtract 26 - 25 = 1. This is your cipher. <br>"
						+ "It is also called modulo calculation. for example 26 mod 25 = 1. But this is a little more complex<br>"
						+ "Therefore not important here. You will see more in the vigenere Visualization.");
		// this.explanations.setFont(new Font("Arial", 2, 20));
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

}
