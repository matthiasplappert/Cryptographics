package edu.kit.iks.Cryptographics.Caesar.Demonstration;

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
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
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
	private static final long serialVersionUID = 1L;

	/**
	 * The alphabet.
	 */
	private AlphabetStripView alphabet;

	private ImageView caesarFrustrated;

	private ImageView caesarHappy;

	/**
	 * XML-root element for cipherdemoView elements.
	 */
	private Element cipherDemoResource;

	/**
	 * Explanation textfield.
	 */
	private JLabel explanations;

	private JPanel inOutPanel;

	private KeyboardView keyboard;

	private JPanel navigationPanel;

	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;

	/**
	 * Input from the user for encryption.
	 */
	private JLabel[] userInput;

	/**
	 * Output from user interaction.
	 */
	private JTextField[] userOutput;

	private static I18n i18n = Configuration.getInstance().getI18n(CipherDemoView.class);
	
	/**
	 * Constructor.
	 */
	public CipherDemoView() {
		super();
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.cipherDemoResource = vsInfo.getResources().getChild("CipherDemo");

		// set the layout to GridBagLayout.
		GridBagLayout introLayout = new GridBagLayout();
		this.setLayout(introLayout);

		// setup the back and next Buttons.
		this.setupNavigation();

		// TODO: need a generator to generate random strings dynamically.
		// setup the fields for the demonstratoin of the encryption.
		char[] chars = { 'C', 'A', 'E', 'S', 'A', 'R' };
		this.setupInOutElements(chars);

		// setup the aligment of the button proceed.
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed = new JButton("Proceed!");
		this.proceed.setPreferredSize(new Dimension(250, 50));
		// this.proceed.setFont(new Font("Arial", 2, 25));
		proceedConst.anchor = GridBagConstraints.PAGE_END;
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

		// setup the explanation label.
		this.explanations = new JLabel(
				"<html><body>"
					+ i18n.tr("Imagine now you are the mighty caesar!! Of course your first idea is to substitute each <br>"
							+ "letter from your name with some other from the alphabet. But which one?"));
		// this.explanations.setFont(new Font("Arial", 2, 20));
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
	 * Creates the keyboard and shows it in the main container.
	 */
	public void createKeyboard(JTextField input) {
		this.keyboard = new KeyboardView(input, KeyboardView.CHAR_MODE);
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
	 * @return the caesarFrustrated
	 */
	public ImageView getCaesarFrustrated() {
		return this.caesarFrustrated;
	}

	/**
	 * @return the caesarHappy
	 */
	public ImageView getCaesarHappy() {
		return this.caesarHappy;
	}

	/**
	 * @return the cipherDemoResource
	 */
	public Element getCipherDemoResource() {
		return this.cipherDemoResource;
	}

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return this.explanations;
	}

	/**
	 * @return the inOutPanel
	 */
	public JPanel getInOutPanel() {
		return this.inOutPanel;
	}

	/**
	 * @return the inputPanel
	 */
	public JPanel getInputPanel() {
		return this.inOutPanel;
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
	 * @param caesarFrustrated
	 *            the caesarFrustrated to set
	 */
	public void setCaesarFrustrated(ImageView caesarFrustrated) {
		this.caesarFrustrated = caesarFrustrated;
	}

	/**
	 * @param caesarHappy
	 *            the caesarHappy to set
	 */
	public void setCaesarHappy(ImageView caesarHappy) {
		this.caesarHappy = caesarHappy;
	}

	/**
	 * @param cipherDemoResource
	 *            the cipherDemoResource to set
	 */
	public void setCipherDemoResource(Element cipherDemoResource) {
		this.cipherDemoResource = cipherDemoResource;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @param inOutPanel
	 *            the inOutPanel to set
	 */
	public void setInOutPanel(JPanel inOutPanel) {
		this.inOutPanel = inOutPanel;
	}

	/**
	 * @param inputPanel
	 *            the inputPanel to set
	 */
	public void setInputPanel(JPanel inputPanel) {
		this.inOutPanel = inputPanel;
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

	private void setupInOutElements(char[] inputChars) {

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

		for (int i = 0; i < inputChars.length; i++) {
			// fields where the input will be encrypted
			this.userInput[i] = new JLabel("" + inputChars[i]);
			this.userInput[i].setBorder(null);
			// this.userInput[i].setFont(new Font("Arial", 2, 25));
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
			this.inOutPanel.add(this.userInput[i], inputConst);

			// fields where the encrypted input is put in.
			this.userOutput[i] = new JTextField();
			this.userOutput[i].setEditable(false);
			// this.userOutput[i].setFont(new Font("Arial", 2, 25));
			this.userOutput[i].setName("" + inputChars[i]);
			this.userOutput[i].setPreferredSize(new Dimension(25, 25));
			this.userOutput[i].setOpaque(true);
			this.userOutput[i].setBorder(BorderFactory
					.createLineBorder(Color.darkGray));
			// needed later when checking if the
			// encrypted char of the plain letter
			// was valid!
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
		this.setBackButton(new JButton("Back to Introduction!"));
		this.getBackButton().setPreferredSize(new Dimension(300, 50));
		// this.getBackButton().setFont(new Font("Arial", 2, 25));
		/*
		 * GridBagConstraints backConst = new GridBagConstraints(); backConst.weightx = 1.0;
		 * backConst.weighty = 0.1; backConst.gridx = 0; backConst.gridy = 0; backConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton("Go to Experiment!"));
		this.getNextButton().setPreferredSize(new Dimension(300, 50));
		// this.getNextButton().setFont(new Font("Arial", 2, 25));

		/*
		 * GridBagConstraints nextConst = new GridBagConstraints(); nextConst.weightx = 1.0;
		 * nextConst.weighty = 0.1; nextConst.gridx = 10; nextConst.gridy = 1; nextConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

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

}
