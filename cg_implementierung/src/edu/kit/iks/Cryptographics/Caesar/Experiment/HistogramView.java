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

	/**
	 * Container for the inc/dec Buttons.
	 */
	private JPanel keyControl;

	/**
	 * Container for the next/back buttons.
	 */
	private JPanel navigationPanel;

	/**
	 * TODO: Because the cipher will be a smaller plain text it is benefitial to put it in one
	 * bigger JTextField than in many smaller ones. Labels that contain an encrypted characters for
	 * demonstration purpose.
	 */
	private JLabel cipher;

	private JLabel plain;

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
		proceedConst.gridx = 2;
		proceedConst.gridy = 3;
		proceedConst.gridwidth = 3;
		this.add(this.proceed, proceedConst);
		this.validate();
	}

	public void setupHistogram(String text, String cipher) {
		this.remove(this.keyControl);
		this.keyControl = null;
		this.remove(this.proceed);
		this.remove(this.explanations);

		this.histogramContainer = new JPanel(new GridBagLayout());
		// this.histogramContainer.setPreferredSize(new Dimension(600, 300));
		GridBagConstraints containerConst = new GridBagConstraints();
		containerConst.anchor = GridBagConstraints.LINE_END;
		containerConst.weightx = 0.5;
		containerConst.weighty = 0.5;
		containerConst.gridx = 0;
		containerConst.gridy = 1;
		containerConst.gridheight = 10;
		containerConst.gridwidth = 10;
		this.add(histogramContainer, containerConst);

		JLabel cipherText = new JLabel(
				"<html><body>WKLV EDU GLDJUDP KDV D YHUWLFDO EHDP<br>"
						+ " IRU HDFK FKDUDFWHU ALWK WKH EHDP IRU WKH PRVW XVHG<br>"
						+ " FKDUDFWHU EHLQJ DW PDALPXP KHLJKW RI WKH GLDJUDPK HDFK<br>"
						+ "RWKHU EHDP KDV D FRUUHVSRQGLQJ IUDFWLRQ RI WKLV KHLJKW <br>"
						+ "WKH HTXLYDOHQW FKDUDFWHUV DUH GLVSODBHG EHQHDWK HDFK EHDP<br>"
						+ " WKH QXPEHU RI RFFXUUHQFHV RI HDFK FKDUDFWHU LV GLVSODBHG<br>"
						+ " ALWKLQ RU DERYH HDFK EHDP");
		GridBagConstraints textConst = new GridBagConstraints();
		textConst.gridx = 0;
		textConst.gridy = 0;
		this.histogramContainer.add(cipherText, textConst);

		this.keyInput = new JTextField("Key");
		this.keyInput.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 0;
		keyConst.gridy = 1;
		this.histogramContainer.add(this.keyInput, keyConst);

		CharacterFrequencyDiagramView histogramCipher = new CharacterFrequencyDiagramView(
				cipher, 600, 100);
		GridBagConstraints histCipherConst = new GridBagConstraints();
		// histCipherConst.weightx = 0;
		// histCipherConst.weighty = 1.0;
		histCipherConst.gridx = 1;
		histCipherConst.gridy = 1;
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
		histPlainConst.gridx = 1;
		histPlainConst.gridy = 0;
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
				.setText("<html><body> Here you see some diagrams. The one diagram at the top <br>"
						+ "is a diagram of a normal english text. Maybe with some grammatical errors<br>"
						+ " and ähh 'falsche Zeichensetzung' but nvm. It doesn't matter actually. ");
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
		this.plain = new JLabel("");
		this.plain.setPreferredSize(new Dimension(100, 50));
		// this.plain.setFont(new Font("Arial", 2, 25));
		GridBagConstraints plainConst = new GridBagConstraints();
		plainConst.gridx = 0;
		plainConst.gridy = 2;
		this.keyControl.add(this.plain, plainConst);

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
	public JLabel getPlain() {
		return plain;
	}

	/**
	 * @param plain
	 *            the plain to set
	 */
	public void setPlain(JLabel plain) {
		this.plain = plain;
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
	 * @param keyInput the keyInput to set
	 */
	public void setKeyInput(JTextField keyInput) {
		this.keyInput = keyInput;
	}
}
