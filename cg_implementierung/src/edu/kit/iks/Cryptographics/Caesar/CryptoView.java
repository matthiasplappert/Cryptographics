package edu.kit.iks.Cryptographics.Caesar;

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

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.NumpadView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This view appears when user finished the introdcution. It is used in the last step of the
 * demonstration phase, in the first and second step of the experiment phase. Because of the small
 * differences between the views of those steps the view is packed in only one Class.
 * 
 * The differences are: <br>
 * 1. When in last step of demonstration phase the the JTextField for the input<br>
 * from the user is disabled. UserOutput is disabled first and is visible only later on. <br>
 * And UserInput contains generated String from the program and no real user input.<br>
 * <br>
 * 2. When in first step of the experiment phase, input is enabled for user input.<br>
 * <br>
 * This view provides elements that allow the user to encrypt his input and decrypt the generated
 * cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoView extends VisualizationView {

	// Constants:
	/**
	 * 
	 */
	public final static int DEMONSTRATION_MODE = 1;

	/**
	 * 
	 */
	public final static int EXPERIMENT_MODE = 2;

	// General parameters:
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * localization.
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			CryptoView.class);

	// GUI container for other GUI elements:
	/**
	 * Container for the textfields where user can perform IO.
	 */
	protected JPanel userCharacterIOContainer;

	/**
	 * Container for the next/back buttons.
	 */
	protected JPanel navigationPanel;

	// GUI for feedback from the user:
	/**
	 * Buttons that generates on demand a random plain text and integer caesar key.
	 */
	protected JButton generator;

	/**
	 * Textfield for user literal input.
	 */
	protected JTextField literalInput;

	/**
	 * Textfield for user numerical input.
	 */
	protected JTextField keyInput;

	/**
	 * Keyboard with literals for literal input.
	 */
	protected KeyboardView keyboard;

	/**
	 * Keyboard with numeral values for numerical input.
	 */
	protected NumpadView numpad;

	/**
	 * Button for forwarding the steps of this phase.
	 */
	protected JButton proceed;

	/**
	 * Output from user interaction.
	 */
	protected JTextField[] userOutput;

	// GUI for feedback to the user:

	/**
	 * Images for supporting users action.
	 */
	protected ImageView caesarFrustrated;
	protected ImageView caesarHappy;

	/**
	 * Explanation textfield.
	 */
	protected JLabel explanations;

	/**
	 * The alphabet.
	 */
	protected AlphabetStripView alphabet;

	/**
	 * Input from the user for encryption.
	 */
	protected JLabel[] userInput;

	/**
	 * Constructor.
	 */
	public CryptoView(final int MODE) {

		// setup the layout.
		this.setupViewLayout();

		// setups the next and back buttons.
		this.setupNavigation(MODE);

		// build elements.
		this.validate();
	}

	// ----------------------------------------------------------------------------//
	// -------------------------public methods------------------------------------//

	/**
	 * removes the alphabet.
	 */
	public void removeAlphabet() {
		this.remove(this.alphabet);
		this.alphabet = null;
		this.validate();
		this.repaint();
	}

	/**
	 * Removes the keyboard from the view.
	 */
	public void removeKeyboard() {
		this.remove(this.keyboard);
		this.keyboard = null;
		this.validate();
		this.repaint();
	}

	/**
	 * Removes the numpad from the view.
	 */
	public void removeNumpad() {
		this.remove(this.numpad);
		this.numpad = null;
		this.validate();
		this.repaint();
	}

	/**
	 * Creates the keyboard and shows it in the main container. /**
	 * 
	 * @param input
	 *            the textfield referred to the Keyboard.
	 * @param flag
	 *            the mode the Keyboard should be created in.
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
	 * Creates the keyboard with numerical values and presents it.
	 * 
	 * @param input
	 *            the textfield referred to the numpad.
	 */
	public void createNumpad(JTextField input) {
		this.numpad = new NumpadView(input, NumpadView.NUMBER_MODE);
		GridBagConstraints numpadConst = new GridBagConstraints();
		numpadConst.anchor = GridBagConstraints.LINE_END;
		numpadConst.weightx = 1.0;
		numpadConst.weighty = 0.5;
		numpadConst.gridx = 0;
		numpadConst.gridy = 3;
		numpadConst.gridwidth = 4;
		numpadConst.gridheight = 5;
		numpadConst.insets = new Insets(0, 10, 0, 200);
		this.add(this.numpad, numpadConst);
		this.validate();
	}

	/**
	 * Creates all needed elements for the encryption/decryption phase.
	 * 
	 * @param inputChars
	 * @param key
	 */
	public void setupInOutElements(char[] inputChars, int key, final int mode) {

		this.userInput = new JLabel[inputChars.length];
		this.userOutput = new JTextField[inputChars.length];

		// setup the container for the IO fields.
		this.setupUserCharacterIOContainer(inputChars.length * 4);

		for (int i = 0; i <= inputChars.length; i++) {
			// called only in the last iteration, when all Elements are already created.
			if (i == inputChars.length) {
				// sets the key into a Label with gridX = i(to the right from the IO-textfields.)
				this.setupKeyDisplay(i, key);
				break;
			}
			// setup the labels that present the input to decrypt/encrypt.
			this.setupUserInput(i, inputChars[i]);

			// setup the textfields for the IO.
			this.setupUserOutput(i, inputChars[i], mode);
		}
		this.userCharacterIOContainer.validate();
	}

	/**
	 * Called when the user done the needed input in a valid way.
	 * 
	 * @param inputChars
	 * @param key
	 */
	public void setupCoreExperimentElements(char[] inputChars, int key,
			final int MODE) {
		// User input will be now filled into the boxes. This field is not
		// needed anymore.
		this.removeUserIOContainer();
		this.removeExplanations();

		// setup IO.
		this.setupInOutElements(inputChars, key, MODE);

		// setup the alphabet.
		this.setupAlphabet();

		// setup the explanations.
		String explanations = "<html><body>"
				+ i18n.tr("Now it is up to you. Test your skills. Remember the key is")
				+ " "
				+ key
				+ ".<br>"
				+ i18n.tr("You need to add the key to the position of the letter your want to shift to get<br>"
						+ "the needed cipher. If you get a bigger number then 25 you need to subtract 25 from it. <br>"
						+ "For example: You want to encrypt X with the key 3. When you add 3 to X you get 23 + 3 = 26. <br>"
						+ "26 is obvious bigger then 25. Then you subtract 26 - 25 = 1. This is your cipher. <br>"
						+ "It is also called modulo calculation. For example 26 mod 25 = 1. But this is a little more complex<br>"
						+ "and therefore not important here. You will see more in the Vigenère visualization.");
		this.setupExplanations(explanations,
				GridBagConstraints.LAST_LINE_START, 0, 0, 4);

		// build the new view.
		this.validate();
		this.repaint();
	}

	// ------------------------------------------------------------------------------------//
	// ----------------------private methods------------------------------------------------//

	private void removeExplanations() {
		this.remove(this.explanations);
		this.explanations = null;
	}

	private void removeUserIOContainer() {
		this.remove(this.userCharacterIOContainer);
		this.userCharacterIOContainer = null;
	}

	protected void setupExplanations(String explanations, final int flag,
			int yGrid, int xGrid, int widthGrid) {
		// setup the explanations.
		this.explanations = new JLabel(explanations);
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = flag;
		expConst.weightx = 0.5;
		expConst.weighty = 0.1;
		expConst.gridx = xGrid;
		expConst.gridy = yGrid;
		expConst.gridwidth = widthGrid;
		this.add(this.explanations, expConst);

	}

	private void setupViewLayout() {
		// set the layout to GridBagLayout.
		GridBagLayout introLayout = new GridBagLayout();
		this.setLayout(introLayout);
		GridBagConstraints viewConst = new GridBagConstraints();
		viewConst.weightx = 1.0;
		viewConst.weighty = 1.0;
		viewConst.gridwidth = 3;
		viewConst.gridheight = 4;
		introLayout.setConstraints(this, viewConst);
	}

	private void setupUserCharacterIOContainer(int widthGrid) {
		this.userCharacterIOContainer = new JPanel(new GridBagLayout());
		GridBagConstraints panelConst = new GridBagConstraints();
		panelConst.anchor = GridBagConstraints.PAGE_START;
		panelConst.weightx = 0.5;
		panelConst.weighty = 0.5;
		panelConst.gridx = 1;
		panelConst.gridy = 1;
		panelConst.gridwidth = widthGrid;
		panelConst.gridheight = 2;
		this.add(this.userCharacterIOContainer, panelConst);
	}

	private void setupKeyDisplay(int xGrid, int key) {
		this.keyInput = new JTextField();
		GridBagConstraints keyConst = new GridBagConstraints();
		this.keyInput.setText("" + key);
		this.keyInput.setPreferredSize(new Dimension(25, 25));
		this.keyInput.setEditable(false);
		keyConst.insets = new Insets(25, 25, 25, 25);
		keyConst.gridx = xGrid;
		keyConst.gridy = 0;
		keyConst.ipadx = 20;
		keyConst.ipady = 20;
		this.userCharacterIOContainer.add(this.keyInput, keyConst);
	}

	private void setupUserInput(int i, char content) {
		// fields where the input will be encrypted
		this.userInput[i] = new JLabel();
		this.userInput[i].setText("" + content);
		this.userInput[i].setBorder(null);
		this.userInput[i].setPreferredSize(new Dimension(25, 25));
		GridBagConstraints inputConst = new GridBagConstraints();
		inputConst.insets = new Insets(25, 25, 25, 25);
		inputConst.gridx = i;
		inputConst.gridy = 0;
		inputConst.ipadx = 20;
		inputConst.ipady = 20;
		this.userCharacterIOContainer.add(this.userInput[i], inputConst);

	}

	private void setupUserOutput(int i, char correspondingInputContent,
			final int MODE) {
		// fields where the encrypted input is put in.
		this.userOutput[i] = new JTextField();
		this.userOutput[i].setName("" + correspondingInputContent);
		this.userOutput[i].setPreferredSize(new Dimension(25, 25));
		this.userOutput[i].setOpaque(true);
		this.userOutput[i].setBorder(BorderFactory
				.createLineBorder(Color.darkGray));
		if (MODE == CryptoView.DEMONSTRATION_MODE) {
			this.userOutput[i].setEditable(false);
		}
		GridBagConstraints outConst = new GridBagConstraints();
		outConst.gridx = i;
		outConst.gridy = 1;
		outConst.ipadx = 20;
		outConst.ipady = 20;
		outConst.insets = new Insets(25, 25, 25, 25);
		this.userCharacterIOContainer.add(this.userOutput[i], outConst);
	}

	private void setupNavigation(final int MODE) {

		// set up a container for the navigation Buttons (Next and Back).
		this.setupNavigationContainer();

		// TODO: dont instantiate the buttons in the upper class.
		// First need to remove the buttons because they are added in the upper
		// class.
		this.remove(this.getBackButton());
		this.remove(this.getNextButton());

		// set up the alignment of the button back;
		if (MODE == CryptoView.EXPERIMENT_MODE) {
			this.setBackButton(new JButton(i18n.tr("Back to demonstration")));
		} else {
			this.setBackButton(new JButton(i18n.tr("Back to Introduction")));
		}
		this.getBackButton().setPreferredSize(new Dimension(350, 50));
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		if (MODE == CryptoView.EXPERIMENT_MODE) {
			this.setNextButton(new JButton(i18n.tr("Go to decryption")));
		} else {
			this.setNextButton(new JButton(i18n.tr("Go to experiment")));
		}
		this.getNextButton().setPreferredSize(new Dimension(300, 50));
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

	}

	private void setupNavigationContainer() {
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
	}

	protected void setupAlphabet() {
		this.alphabet = new AlphabetStripView();
		GridBagConstraints alphConst = new GridBagConstraints();
		alphConst.anchor = GridBagConstraints.CENTER;
		alphConst.gridx = 1;
		alphConst.gridy = 1;
		alphConst.gridwidth = 26;
		alphConst.gridheight = 2;
		alphConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.alphabet, alphConst);
	}

	// ----------------------------------------------------------Getter/Setter--------------------------------------------------//
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
	 * @return the alphabet
	 */
	public AlphabetStripView getAlphabet() {
		return this.alphabet;
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
	public JPanel userCharacterIOContainer() {
		return this.userCharacterIOContainer;
	}

	/**
	 * @return input
	 */
	public JTextField getLiteralInput() {
		return this.literalInput;
	}

	/**
	 * @return the key
	 */
	public JTextField getKeyInput() {
		return this.keyInput;
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
	 * @return the numpad
	 */
	public NumpadView getNumpad() {
		return this.numpad;
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
		this.userCharacterIOContainer = inOutPanel;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(JTextField input) {
		this.literalInput = input;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(JTextField key) {
		this.keyInput = key;
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
	 * @param numpad
	 *            the numpad to set
	 */
	public void setNumpad(NumpadView numpad) {
		this.numpad = numpad;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	/**
	 * @return the userCharacterIOContainer
	 */
	public JPanel getUserCharacterIOContainer() {
		return userCharacterIOContainer;
	}

	/**
	 * @param userCharacterIOContainer
	 *            the userCharacterIOContainer to set
	 */
	public void setUserCharacterIOContainer(JPanel userCharacterIOContainer) {
		this.userCharacterIOContainer = userCharacterIOContainer;
	}

	/**
	 * @return the caesarFrustrated
	 */
	public ImageView getCaesarFrustrated() {
		return caesarFrustrated;
	}

	/**
	 * @param caesarFrustrated
	 *            the caesarFrustrated to set
	 */
	public void setCaesarFrustrated(ImageView caesarFrustrated) {
		this.caesarFrustrated = caesarFrustrated;
	}

	/**
	 * @return the caesarHappy
	 */
	public ImageView getCaesarHappy() {
		return caesarHappy;
	}

	/**
	 * @param caesarHappy
	 *            the caesarHappy to set
	 */
	public void setCaesarHappy(ImageView caesarHappy) {
		this.caesarHappy = caesarHappy;
	}
}
