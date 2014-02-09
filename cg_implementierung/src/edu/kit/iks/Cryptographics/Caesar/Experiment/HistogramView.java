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

	private JLabel announcement;
	private JLabel cipher;

	private CharacterFrequencyDiagramView cipherHistogram;

	private JPanel cipherPlaintextContainer;

	private JLabel cipherText;

	private JButton decrement;

	private JPanel explanationPanel;

	/**
	 * Explanations of the animations.
	 */
	private JLabel explanations;

	private String[] histogramCipher;

	/**
	 * Label that will contain a histogram image that will be explained to the user.
	 */
	private JPanel histogramContainer;
	private Element histResource;

	/**
	 * Buttons for iterating the key.
	 */
	private JButton increment;

	/**
	 * Key that is being incremented and decremented.
	 */
	private JLabel key;

	private KeyboardView keyboard;

	/**
	 * Container for the inc/dec Buttons.
	 */
	private JPanel keyControl;

	private JTextField keyInput;

	private int keyValue;

	/**
	 * Container for the next/back buttons.
	 */
	private JPanel navigationPanel;
	private JLabel plainText;

	private CharacterFrequencyDiagramView plainTextHistogram;
	private JButton proceed;

	private int secretKey;

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
		viewConst.fill = GridBagConstraints.BOTH;
		layout.setConstraints(this, viewConst);

		// setup the navigation.
		this.setupNavigation();

		String explanation = "<html><body> Great. Up to now you learned how to encrypt or decrypt given letter sequences with a given key.<br>"
				+ "The question is now, how do you decrypt without a key?!<br>"
				+ "<br>"
				+ "It is also called 'breaking' the cipher if you try to decrypt without a given key parameter. The following <br>"
				+ "experiments will teach you how to break caesar's cipher. There are always 2 Options when it comes to this.<br>"
				+ "<br>"
				+ "1. The First one is the method called 'Brute Force', it means that you just try simply to decrypt with each possible<br>"
				+ "key. This one you will see in the next step.<br>"
				+ "<br>"
				+ "2. The Second one is to use cryptology techniques.";

		this.setupExplanationPanel();
		this.setupExplanations(explanation);
		this.setupProceed();
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
	 * @return the announcement
	 */
	public JLabel getAnnouncement() {
		return this.announcement;
	}

	/**
	 * @return the cipher
	 */
	public JLabel getCipher() {
		return this.cipher;
	}

	/**
	 * @return the cipherHistogram
	 */
	public CharacterFrequencyDiagramView getCipherHistogram() {
		return this.cipherHistogram;
	}

	/**
	 * @return the cipherPlaintextContainer
	 */
	public JPanel getCipherPlaintextContainer() {
		return this.cipherPlaintextContainer;
	}

	/**
	 * @return the cipherText
	 */
	public JLabel getCipherText() {
		return this.cipherText;
	}

	/**
	 * @return the decrement
	 */
	public JButton getDecrement() {
		return this.decrement;
	}

	/**
	 * @return the explanationPanel
	 */
	public JPanel getExplanationPanel() {
		return this.explanationPanel;
	}

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return this.explanations;
	}

	/**
	 * @return the histogramCipher
	 */
	public String[] getHistogramCipher() {
		return this.histogramCipher;
	}

	/**
	 * @return the histogramContainer
	 */
	public JPanel getHistogramContainer() {
		return this.histogramContainer;
	}

	/**
	 * @return the histResource
	 */
	public Element getHistResource() {
		return this.histResource;
	}

	/**
	 * @return the increment
	 */
	public JButton getIncrement() {
		return this.increment;
	}

	/**
	 * @return the key
	 */
	public JLabel getKey() {
		return this.key;
	}

	/**
	 * @return the keyboard
	 */
	public KeyboardView getKeyboard() {
		return this.keyboard;
	}

	/**
	 * @return the keyControl
	 */
	public JPanel getKeyControl() {
		return this.keyControl;
	}

	/**
	 * @return the keyInput
	 */
	public JTextField getKeyInput() {
		return this.keyInput;
	}

	/**
	 * @return the keyValue
	 */
	public int getKeyValue() {
		return this.keyValue;
	}

	/**
	 * @return the navigationPanel
	 */
	public JPanel getNavigationPanel() {
		return this.navigationPanel;
	}

	/**
	 * @return the plain
	 */
	public JLabel getPlainText() {
		return this.plainText;
	}

	/**
	 * @return the plainTextHistogram
	 */
	public CharacterFrequencyDiagramView getPlainTextHistogram() {
		return this.plainTextHistogram;
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return this.proceed;
	}

	/**
	 * @return the secretKey
	 */
	public int getSecretKey() {
		return this.secretKey;
	}

	/**
	 * @param announcement
	 *            the announcement to set
	 */
	public void setAnnouncement(JLabel announcement) {
		this.announcement = announcement;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(JLabel cipher) {
		this.cipher = cipher;
	}

	/**
	 * @param cipherHistogram
	 *            the cipherHistogram to set
	 */
	public void setCipherHistogram(CharacterFrequencyDiagramView cipherHistogram) {
		this.cipherHistogram = cipherHistogram;
	}

	/**
	 * @param cipherPlaintextContainer
	 *            the cipherPlaintextContainer to set
	 */
	public void setCipherPlaintextContainer(JPanel cipherPlaintextContainer) {
		this.cipherPlaintextContainer = cipherPlaintextContainer;
	}

	/**
	 * @param cipherText
	 *            the cipherText to set
	 */
	public void setCipherText(JLabel cipherText) {
		this.cipherText = cipherText;
	}

	/**
	 * @param label
	 * @param c
	 */
	public void setContent(JLabel label, char c) {

	}

	/**
	 * @param decrement
	 *            the decrement to set
	 */
	public void setDecrement(JButton decrement) {
		this.decrement = decrement;
	}

	/**
	 * @param explanationPanel
	 *            the explanationPanel to set
	 */
	public void setExplanationPanel(JPanel explanationPanel) {
		this.explanationPanel = explanationPanel;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @param histogramCipher
	 *            the histogramCipher to set
	 */
	public void setHistogramCipher(String[] histogramCipher) {
		this.histogramCipher = histogramCipher;
	}

	/**
	 * @param histogramContainer
	 *            the histogramContainer to set
	 */
	public void setHistogramContainer(JPanel histogramContainer) {
		this.histogramContainer = histogramContainer;
	}

	/**
	 * @param histResource
	 *            the histResource to set
	 */
	public void setHistResource(Element histResource) {
		this.histResource = histResource;
	}

	/**
	 * @param increment
	 *            the increment to set
	 */
	public void setIncrement(JButton increment) {
		this.increment = increment;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(JLabel key) {
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
	 * @param keyControl
	 *            the keyControl to set
	 */
	public void setKeyControl(JPanel keyControl) {
		this.keyControl = keyControl;
	}

	/**
	 * @param keyInput
	 *            the keyInput to set
	 */
	public void setKeyInput(JTextField keyInput) {
		this.keyInput = keyInput;
	}

	/**
	 * @param keyValue
	 *            the keyValue to set
	 */
	public void setKeyValue(int keyValue) {
		this.keyValue = keyValue;
	}

	/**
	 * @param navigationPanel
	 *            the navigationPanel to set
	 */
	public void setNavigationPanel(JPanel navigationPanel) {
		this.navigationPanel = navigationPanel;
	}

	/**
	 * @param plain
	 *            the plain to set
	 */
	public void setPlainText(JLabel plaintext) {
		this.plainText = plaintext;
	}

	/**
	 * @param plainTextHistogram
	 *            the plainTextHistogram to set
	 */
	public void setPlainTextHistogram(
			CharacterFrequencyDiagramView plainTextHistogram) {
		this.plainTextHistogram = plainTextHistogram;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	/**
	 * @param secretKey
	 *            the secretKey to set
	 */
	public void setSecretKey(int secretKey) {
		this.secretKey = secretKey;
	}

	public void setupBruteForce() {
		this.explanationPanel.remove(this.proceed);
		this.proceed = null;
		this.keyValue = 1;

		this.announcement = new JLabel();
		this.announcement.setPreferredSize(new Dimension(600, 100));
		GridBagConstraints annConst = new GridBagConstraints();
		annConst.gridx = 0;
		annConst.gridy = 0;
		annConst.gridwidth = 4;
		// annConst.fill = GridBagConstraints.HORIZONTAL;
		this.keyControl.add(this.announcement, annConst);

		// layout the buttons.
		this.repaint();
		this.validate();
	}

	public void setupCipherHistogram(String cipher) {
		JLabel cipherHistogramHint = new JLabel(
				"<html><body>&darr;Histogram of the cipher.&darr;");
		GridBagConstraints hintConst = new GridBagConstraints();
		hintConst.gridx = 2;
		hintConst.gridy = 2;
		hintConst.insets = new Insets(0, 50, 5, 50);
		hintConst.fill = GridBagConstraints.HORIZONTAL;
		this.histogramContainer.add(cipherHistogramHint, hintConst);

		this.cipherHistogram = new CharacterFrequencyDiagramView(cipher, 600,
				100);
		GridBagConstraints cipherHistConst = new GridBagConstraints();
		cipherHistConst.gridx = 2;
		cipherHistConst.gridy = 3;
		cipherHistConst.insets = new Insets(5, 50, 5, 50);
		cipherHistConst.fill = GridBagConstraints.BOTH;
		this.histogramContainer.add(this.cipherHistogram, cipherHistConst);

		this.cipherText = new JLabel(cipher);
		GridBagConstraints cipherConst = new GridBagConstraints();
		cipherConst.gridx = 2;
		cipherConst.gridy = 4;
		cipherConst.insets = new Insets(5, 50, 5, 50);
		cipherConst.fill = GridBagConstraints.BOTH;
		this.histogramContainer.add(this.cipherText, cipherConst);

		this.validate();
		this.repaint();
	}

	public void setupCipherPlainLabels(String cipher) {
		this.cipher = new JLabel(cipher);
		// this.secretKey = 5;
		this.cipher.setPreferredSize(new Dimension(100, 50));
		// this.cipher.setFont(new Font("Arial", 2, 25));
		GridBagConstraints cipherConst = new GridBagConstraints();
		cipherConst.gridx = 0;
		cipherConst.gridy = 1;
		cipherConst.insets = new Insets(5, 5, 5, 5);
		this.keyControl.add(this.cipher, cipherConst);
		this.plainText = new JLabel("");
		this.plainText.setPreferredSize(new Dimension(100, 50));
		// this.plain.setFont(new Font("Arial", 2, 25));
		GridBagConstraints plainConst = new GridBagConstraints();
		plainConst.gridx = 0;
		plainConst.gridy = 2;
		plainConst.insets = new Insets(5, 5, 5, 5);
		this.keyControl.add(this.plainText, plainConst);
	}

	public void setupExplanationPanel() {
		this.explanationPanel = new JPanel(new GridBagLayout());
		// set the alignment of the Container for the explanations and the button Proceed.
		GridBagConstraints explanationPanelConstraint = new GridBagConstraints();
		explanationPanelConstraint.anchor = GridBagConstraints.PAGE_START;
		explanationPanelConstraint.weightx = 1.0;
		explanationPanelConstraint.weighty = 0.1;
		explanationPanelConstraint.gridx = 0;
		explanationPanelConstraint.gridy = 0;
		explanationPanelConstraint.gridwidth = 6;
		explanationPanelConstraint.gridheight = 6;
		explanationPanelConstraint.insets = new Insets(50, 0, 0, 0);
		explanationPanelConstraint.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.explanationPanel, explanationPanelConstraint);
	}

	public void setupExplanations(String explanations) {

		this.setExplanations(new JLabel(explanations));
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		explanationConstraint.gridx = 1;
		explanationConstraint.gridy = 0;
		explanationConstraint.gridwidth = 5;
		explanationConstraint.gridheight = 5;
		explanationConstraint.insets = new Insets(10, 0, 10, 0);
		explanationConstraint.fill = GridBagConstraints.HORIZONTAL;
		this.explanationPanel.add(this.explanations, explanationConstraint);

		this.explanationPanel.validate();
		this.validate();
	}

	public void setupHistogramContainer() {
		this.histogramContainer = new JPanel(new GridBagLayout());
		GridBagConstraints containerConst = new GridBagConstraints();
		containerConst.anchor = GridBagConstraints.PAGE_END;
		containerConst.weightx = 1.0;
		containerConst.weighty = 1.0;
		containerConst.gridx = 0;
		containerConst.gridy = 1;
		containerConst.gridheight = 6;
		containerConst.gridwidth = 3;
		containerConst.fill = GridBagConstraints.BOTH;
		this.add(this.histogramContainer, containerConst);
	}

	public void setupIncrementDecrement() {
		// key
		this.key = new JLabel("1");
		this.key.setPreferredSize(new Dimension(100, 50));
		// this.key.setFont(new Font("Arial", 2, 25));
		GridBagConstraints keyLabelConst = new GridBagConstraints();
		keyLabelConst.gridx = 3;
		keyLabelConst.gridy = 1;
		keyLabelConst.insets = new Insets(5, 5, 50, 5);
		// keyLabelConst.fill = GridBagConstraints.HORIZONTAL;
		this.keyControl.add(this.key, keyLabelConst);
		// increment.
		this.increment = new JButton("+1");
		this.increment.setPreferredSize(new Dimension(100, 50));
		// this.increment.setFont(new Font("Arial", 2, 25));
		GridBagConstraints incConst = new GridBagConstraints();
		incConst.gridx = 4;
		incConst.gridy = 1;
		incConst.insets = new Insets(5, 5, 50, 5);
		this.keyControl.add(this.increment, incConst);
		// decrement.
		this.decrement = new JButton("-1");
		this.decrement.setPreferredSize(new Dimension(100, 50));
		// this.decrement.setFont(new Font("Arial", 2, 25));
		GridBagConstraints decConst = new GridBagConstraints();
		decConst.gridx = 4;
		decConst.gridy = 2;
		decConst.insets = new Insets(5, 5, 50, 5);
		this.keyControl.add(this.decrement, decConst);
	}

	public void setupKeyControlPanel() {
		// setup the Panel for buttons for incrementing/decrementing the key.
		this.keyControl = new JPanel(new GridBagLayout());
		// this.keyControl.setBorder(BorderFactory.createLineBorder(Color.green));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.anchor = GridBagConstraints.CENTER;
		keyConst.weightx = 0.5;
		keyConst.weighty = 0.5;
		keyConst.gridx = 1;
		keyConst.gridy = 0;
		keyConst.gridwidth = 3;
		keyConst.gridheight = 4;
		keyConst.insets = new Insets(300, 0, 0, 0);
		// keyConst.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.keyControl, keyConst);
	}

	public void setupKeyInput() {
		JLabel keyCaption = new JLabel(
				"<html><body>Type your key in this&darr; box and click 'Enter'.");
		GridBagConstraints capConst = new GridBagConstraints();
		capConst.gridx = 0;
		capConst.gridy = 0;
		capConst.gridwidth = 3;
		capConst.insets = new Insets(0, 475, 0, 100);
		capConst.fill = GridBagConstraints.HORIZONTAL;
		this.histogramContainer.add(keyCaption, capConst);

		this.keyInput = new JTextField();
		this.keyInput.setMinimumSize(new Dimension(50, 50));
		this.keyInput.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 0;
		keyConst.gridy = 1;
		keyConst.gridwidth = 3;
		keyConst.gridheight = 2;
		keyConst.insets = new Insets(5, 50, 5, 50);
		// keyConst.fill = GridBagConstraints.BOTH;
		this.histogramContainer.add(this.keyInput, keyConst);
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
		this.getBackButton().setMaximumSize(new Dimension(300, 50));
		// this.getBackButton().setFont(new Font("Arial", 2, 25));
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton(
				"Skip the histograms(Visualization Done)!"));
		this.getNextButton().setPreferredSize(new Dimension(300, 50));
		this.getNextButton().setMinimumSize(new Dimension(300, 50));
		// this.getNextButton().setFont(new Font("Arial", 2, 25));
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

	}

	public void setupPlainHistogram(String text) {

		JLabel cipherHistogramHint = new JLabel("<html><body>"
				+ "&darr;Histogram of the explanation.&darr;");
		GridBagConstraints hintConst = new GridBagConstraints();
		hintConst.gridx = 0;
		hintConst.gridy = 2;
		hintConst.insets = new Insets(0, 50, 5, 50);
		hintConst.fill = GridBagConstraints.HORIZONTAL;
		this.histogramContainer.add(cipherHistogramHint, hintConst);

		this.plainTextHistogram = new CharacterFrequencyDiagramView(text, 600,
				100);
		GridBagConstraints plainTextHistConst = new GridBagConstraints();
		plainTextHistConst.gridx = 0;
		plainTextHistConst.gridy = 3;
		plainTextHistConst.insets = new Insets(5, 50, 5, 50);
		plainTextHistConst.fill = GridBagConstraints.BOTH;
		this.histogramContainer
				.add(this.plainTextHistogram, plainTextHistConst);

		this.plainText = new JLabel();
		GridBagConstraints plainConst = new GridBagConstraints();
		plainConst.gridx = 0;
		plainConst.gridy = 4;
		plainConst.insets = new Insets(5, 50, 5, 50);
		plainConst.fill = GridBagConstraints.BOTH;
		this.histogramContainer.add(this.plainText, plainConst);

		this.validate();
		this.repaint();
	}

	public void setupProceed() {
		// setup the proceed button.
		this.proceed = new JButton("Proceed");
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed.setPreferredSize(new Dimension(250, 50));
		this.proceed.setMinimumSize(new Dimension(100, 50));
		proceedConst.gridx = 3;
		proceedConst.gridy = 6;
		proceedConst.gridwidth = 6;
		proceedConst.insets = new Insets(0, 0, 10, 0);
		this.explanationPanel.add(this.proceed, proceedConst);

		this.explanationPanel.validate();
	}

	public void unloadCipherHistogram() {
		this.histogramContainer.remove(this.cipherHistogram);
		this.cipherHistogram = null;
		this.histogramContainer.remove(this.cipherText);
		this.cipherText = null;
		this.revalidate();
	}

	public void unloadExplanationPanel() {
		this.explanationPanel.remove(this.proceed);
		this.explanationPanel.remove(this.explanations);
		this.proceed = null;
		this.explanations = null;
		this.remove(this.explanationPanel);
		this.explanationPanel = null;
		this.validate();
		this.repaint();
	}

	public void unloadKeyInput() {
		this.histogramContainer.remove(this.keyInput);
		this.keyInput = null;
		this.validate();
	}

	public void unloadProceed() {
		this.explanationPanel.remove(this.proceed);
		this.proceed = null;
	}
}
