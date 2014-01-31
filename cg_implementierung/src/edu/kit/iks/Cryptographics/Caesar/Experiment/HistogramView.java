package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.CharacterFrequencyDiagramView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This view represents the last view of the experiment phase. The elements contained here allow the
 * user to break a given caesar cipher and have the purpose to show him the disadvantages of the
 * caesar cipher, in particular how easy it is to break it. In additional user gets an animation
 * presented that describe what histogramms are and how they could help him solving his task to
 * break the cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class HistogramView extends VisualizationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Buttons for iterating the key.
	 */
	private JButton increment;
	private JButton decrement;

	private JButton proceed;

	private JTextField keyInput;

	private KeyboardView keyboard;

	/**
	 * Container for the inc/dec Buttons.
	 */
	private JPanel keyControl;

	/**
	 * Container for the next/back buttons.
	 */
	private JPanel navigationPanel;

	private JLabel cipher;
	
	private JLabel cipherText;

	private JLabel plainText;

	/**
	 * Explanations of the animations.
	 */
	private JLabel explanations;

	private Element histResource;

	/**
	 * Key that is being incremented and decremented.
	 */
	private JLabel key;

	private int keyValue;

	private int secretKey;

	/**
	 * Label that will contain a histogram image that will be explained to the user.
	 */
	private JPanel histogramContainer;

	private String histogramCipher;

	/**
	 * Constructor.
	 */
	public HistogramView() {
		// load the resources from the xml, that can be accessed over the
		// visualizationInfo
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.histResource = vsInfo.getResources().getChild("Histogram");

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints viewConst = new GridBagConstraints();
		viewConst.weightx = 1.0;
		viewConst.weighty = 1.0;
		viewConst.gridheight = 6;
		viewConst.gridwidth = 6;
		layout.setConstraints(this, viewConst);

		// setup the navigation.
		setupNavigation();

		// set the alignment of the Explanations.
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		explanationConstraint.anchor = GridBagConstraints.PAGE_START;
		explanationConstraint.weightx = 1.0;
		explanationConstraint.weighty = 0.1;
		explanationConstraint.gridx = 0;
		explanationConstraint.gridy = 1;
		explanationConstraint.gridwidth = 3;
		explanationConstraint.gridheight = 1;
		this.setExplanations(new JLabel(
				"<html><body> Great. Up to now you learned how to encrypt or decrypt given letter sequences with a given key.<br>"
						+ "The question is now, how do you decrypt without a key?!<br>"
						+ "<br>"
						+ "It is also called 'breaking' the cipher if you try to decrypt without a given key parameter. The following <br>"
						+ "experiments will teach you how to break caesar's cipher.<br>"));
		// this.explanations.setFont(new Font("Arial", 2, 20));
		this.add(this.explanations, explanationConstraint);

		// setup the proceed button.
		setupProceed();

		this.validate();
	}

	public void setupProceed() {
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed = new JButton("Proceed!");

		this.proceed.setPreferredSize(new Dimension(250, 50));
		// this.proceed.setFont(new Font("Arial", 2, 25));
		proceedConst.anchor = GridBagConstraints.PAGE_END;
		proceedConst.weightx = 0.1;
		proceedConst.weighty = 0.5;
		proceedConst.gridx = 0;
		proceedConst.gridy = 0;
		proceedConst.gridwidth = 3;
		proceedConst.insets = new Insets(10, 10, 10, 10);
		this.add(this.proceed, proceedConst);
		this.validate();
	}

	/**
	 * Creates the keyboard and shows it in the main container.
	 */
	public void createKeyboard(JTextField input) {
		this.keyboard = new KeyboardView(input);
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

	public void unloadHistogram() {
		this.remove(this.histogramContainer);
		this.histogramContainer.remove(this.cipherText);
		this.histogramContainer.remove(this.keyInput);
		this.histogramContainer.remove(this.plainText);
		this.histogramContainer = null;
		this.cipherText = null;
		this.plainText = null;
		this.keyInput = null;
		this.revalidate();
	}
	
	public void setupHistogram(String text, String cipher) {
		this.remove(proceed);
		
		this.histogramContainer = new JPanel(new GridBagLayout());
		// this.histogramContainer.setPreferredSize(new Dimension(600, 300));
		GridBagConstraints containerConst = new GridBagConstraints();
		containerConst.anchor = GridBagConstraints.LINE_END;
		containerConst.weightx = 0.5;
		containerConst.weighty = 0.5;
		containerConst.gridx = 0;
		containerConst.gridy = 1;
		containerConst.gridheight = 10;
		containerConst.gridwidth = 20;
		this.add(histogramContainer, containerConst);

		this.cipherText = new JLabel(cipher);
		GridBagConstraints textConst = new GridBagConstraints();
		textConst.gridx = 1;
		textConst.gridy = 0;
		textConst.insets = new Insets(0, 5, 0, 5);
		this.histogramContainer.add(cipherText, textConst);
		
		this.plainText = new JLabel();
		GridBagConstraints plainConst = new GridBagConstraints();
		plainConst.gridx = 0;
		plainConst.gridy = 0;
		plainConst.insets = new Insets(0, 5, 0, 5);
		this.histogramContainer.add(plainText, plainConst);

		this.keyInput = new JTextField();
		this.keyInput.setPreferredSize(new Dimension(100, 50));
		this.keyInput.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 1;
		keyConst.gridy = 2;
		this.histogramContainer.add(this.keyInput, keyConst);

		JLabel keyCaption = new JLabel("Type your key here: ");
		GridBagConstraints capConst = new GridBagConstraints();
		capConst.gridx = 1;
		capConst.gridy = 1;
		this.histogramContainer.add(keyCaption, capConst);

		CharacterFrequencyDiagramView histogramCipher = new CharacterFrequencyDiagramView(
				cipher, 600, 100);
		GridBagConstraints histCipherConst = new GridBagConstraints();
		// histCipherConst.weightx = 0;
		// histCipherConst.weighty = 1.0;
		histCipherConst.gridx = 2;
		histCipherConst.gridy = 0;
		// histCipherConst.insets = new Insets(50, 0, 50, 0);
		// histCipherConst.gridheight = 1;
		// histCipherConst.gridwidth = 4;
		// histCipherConst.fill = GridBagConstraints.HORIZONTAL;
		this.histogramContainer.add(histogramCipher, histCipherConst);

		CharacterFrequencyDiagramView histogramPlain = new CharacterFrequencyDiagramView(
				text, 600, 100);
		GridBagConstraints histPlainConst = new GridBagConstraints();
		// histPlainConst.weightx = 0;
		// histPlainConst.weighty = 1.0;
		histPlainConst.gridx = 2;
		histPlainConst.gridy = 1;
		// histPlainConst.insets = new Insets(50, 0, 50, 0);
		// histPlainConst.gridheight = 1;
		// histPlainConst.gridwidth = 4;
		// histPlainConst.fill = GridBagConstraints.HORIZONTAL;
		this.histogramContainer.add(histogramPlain, histPlainConst);

		this.histogramContainer.validate();
		GridBagConstraints expConst = new GridBagConstraints();
		expConst.anchor = GridBagConstraints.LINE_START;
		expConst.weightx = 1.0;
		expConst.weighty = 0.1;
		expConst.gridx = 0;
		expConst.gridy = 0;
		expConst.gridwidth = 3;
		expConst.gridheight = 1;
		expConst.insets = new Insets(50, 0, 50, 0);
		this.explanations
				.setText("<html><body> Here you see some diagrams. These ones are called 'Histograms' <br>"
						+ "Above each letter you can see columns with a number above. The number says how many<br>"
						+ "times you can count the given letter in a given text!"
						+ "The one diagram at the bottom is a diagram of a normal english text. <br>"
						+ "Maybe with some grammatical errors and ähh 'falsche Zeichensetzung' but nvm. It doesn't matter actually. <br>"
						+ "As you can see the letters A and E have the biggest numbers. That is because they are the most<br>"
						+ "frequent in an english Text.The histogram above shows the histogram of the given cipher left of it.<br>"
						+ "If you compare this to the histogram above it you notice that now D and H are the most frequent<br>"
						+ "That means that the letters A and E could have been shifted to D and H. If we substract backwards.<br>"
						+ "D - A = 4 - 1 = 3. Here you have the key of the given cipher. Now type the key in the inputfield and click enter.<br>"
						+ "The programm will decrypt the cipher with the key you put in.");
		this.add(this.explanations, expConst);

		this.validate();
		this.repaint();
	}

	public void setupBruteForce(String cipher) {
		// GridBagLayout layout = (GridBagLayout) this.getLayout();
		// this.remove(this.explanations);
		this.remove(proceed);
		// this.proceed = null;

		// GridBagConstraints expConst = new GridBagConstraints();
		// // expConst.anchor = GridBagConstraints.FIRST_LINE_START;
		// expConst.gridx = 0;
		// expConst.gridy = 1;
		// this.add(this.explanations, expConst);

		this.keyValue = 1;

		// setup the Panel for buttons for incrementing/decrementing the key.
		this.keyControl = new JPanel(new GridBagLayout());
		// this.keyControl.setBorder(BorderFactory.createLineBorder(Color.green));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.anchor = GridBagConstraints.PAGE_START;
		keyConst.weightx = 0.5;
		keyConst.weighty = 0.5;
		keyConst.gridx = 1;
		keyConst.gridy = 2;
		keyConst.gridwidth = 5;
		keyConst.gridheight = 3;
		// keyConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.keyControl, keyConst);

		// key
		this.key = new JLabel("1");
		this.key.setPreferredSize(new Dimension(100, 50));
		// this.key.setFont(new Font("Arial", 2, 25));
		GridBagConstraints keyLabelConst = new GridBagConstraints();
		keyLabelConst.gridx = 2;
		keyLabelConst.gridy = 1;
		this.keyControl.add(this.key, keyLabelConst);
		// increment.
		this.increment = new JButton("+1");
		this.increment.setPreferredSize(new Dimension(100, 50));
		// this.increment.setFont(new Font("Arial", 2, 25));
		GridBagConstraints incConst = new GridBagConstraints();
		incConst.gridx = 3;
		incConst.gridy = 0;
		this.keyControl.add(this.increment, incConst);
		// decrement.
		this.decrement = new JButton("-1");
		this.decrement.setPreferredSize(new Dimension(100, 50));
		// this.decrement.setFont(new Font("Arial", 2, 25));
		GridBagConstraints decConst = new GridBagConstraints();
		decConst.gridx = 3;
		decConst.gridy = 2;
		this.keyControl.add(this.decrement, decConst);

		this.cipher = new JLabel(cipher);
		// this.secretKey = 5;
		this.cipher.setPreferredSize(new Dimension(100, 50));
		// this.cipher.setFont(new Font("Arial", 2, 25));
		GridBagConstraints cipherConst = new GridBagConstraints();
		cipherConst.gridx = 0;
		cipherConst.gridy = 0;
		this.keyControl.add(this.cipher, cipherConst);
		this.plainText = new JLabel("");
		this.plainText.setPreferredSize(new Dimension(100, 50));
		// this.plain.setFont(new Font("Arial", 2, 25));
		GridBagConstraints plainConst = new GridBagConstraints();
		plainConst.gridx = 0;
		plainConst.gridy = 2;
		this.keyControl.add(this.plainText, plainConst);

		// layout the buttons.
		this.repaint();
		this.validate();
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
		this.setBackButton(new JButton("Back to Experiment!"));
		this.getBackButton().setPreferredSize(new Dimension(300, 50));
		// this.getBackButton().setFont(new Font("Arial", 2, 25));
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton(
				"Skip the histograms(Visualization Done)!"));
		this.getNextButton().setPreferredSize(new Dimension(300, 50));
		// this.getNextButton().setFont(new Font("Arial", 2, 25));
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

	}

	/**
	 * @param label
	 * @param c
	 */
	public void setContent(JLabel label, char c) {

	}

	/**
	 * @return the cipher
	 */
	public JLabel getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(JLabel cipher) {
		this.cipher = cipher;
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
	 * @return the key
	 */
	public JLabel getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(JLabel key) {
		this.key = key;
	}

	/**
	 * @return the increment
	 */
	public JButton getIncrement() {
		return increment;
	}

	/**
	 * @return the decrement
	 */
	public JButton getDecrement() {
		return decrement;
	}

	/**
	 * @return the keyControl
	 */
	public JPanel getKeyControl() {
		return keyControl;
	}

	/**
	 * @param keyControl
	 *            the keyControl to set
	 */
	public void setKeyControl(JPanel keyControl) {
		this.keyControl = keyControl;
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
	 * @param increment
	 *            the increment to set
	 */
	public void setIncrement(JButton increment) {
		this.increment = increment;
	}

	/**
	 * @param decrement
	 *            the decrement to set
	 */
	public void setDecrement(JButton decrement) {
		this.decrement = decrement;
	}

	/**
	 * @return the keyValue
	 */
	public int getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue
	 *            the keyValue to set
	 */
	public void setKeyValue(int keyValue) {
		this.keyValue = keyValue;
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
	 * @return the histResource
	 */
	public Element getHistResource() {
		return histResource;
	}

	/**
	 * @param histResource
	 *            the histResource to set
	 */
	public void setHistResource(Element histResource) {
		this.histResource = histResource;
	}

	/**
	 * @return the plain
	 */
	public JLabel getPlainText() {
		return plainText;
	}

	/**
	 * @param plain
	 *            the plain to set
	 */
	public void setPlainText(JLabel plaintext) {
		this.plainText = plaintext;
	}

	/**
	 * @return the secretKey
	 */
	public int getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey
	 *            the secretKey to set
	 */
	public void setSecretKey(int secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * @return the histogramContainer
	 */
	public JPanel getHistogramContainer() {
		return histogramContainer;
	}

	/**
	 * @param histogramContainer
	 *            the histogramContainer to set
	 */
	public void setHistogramContainer(JPanel histogramContainer) {
		this.histogramContainer = histogramContainer;
	}

	/**
	 * @return the keyInput
	 */
	public JTextField getKeyInput() {
		return keyInput;
	}

	/**
	 * @param keyInput
	 *            the keyInput to set
	 */
	public void setKeyInput(JTextField keyInput) {
		this.keyInput = keyInput;
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
	 * @return the histogramCipher
	 */
	public String getHistogramCipher() {
		return histogramCipher;
	}

	/**
	 * @param histogramCipher
	 *            the histogramCipher to set
	 */
	public void setHistogramCipher(String histogramCipher) {
		this.histogramCipher = histogramCipher;
	}

	/**
	 * @return the cipherText
	 */
	public JLabel getCipherText() {
		return cipherText;
	}

	/**
	 * @param cipherText the cipherText to set
	 */
	public void setCipherText(JLabel cipherText) {
		this.cipherText = cipherText;
	}
}
