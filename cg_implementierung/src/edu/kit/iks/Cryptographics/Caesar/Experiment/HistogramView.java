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
	private JTextField[] cipher;

	/**
	 * Explanations of the animations.
	 */
	private JLabel explanations;

	/**
	 * Key that is being incremented and decremented.
	 */
	private JLabel key;
	private int keyValue;

	/**
	 * Label that will contain a histogram image that will be explained to the user.
	 */
	private CharacterFrequencyDiagramView histogram;

	/**
	 * Constructor.
	 */
	public HistogramView() {
		// load the resources from the xml, that can be accessed over the
		// visualizationInfo
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		Element histResource = vsInfo.getResources().getChild("Histogram");

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
        this.keyValue = 0;
		// setup the navigation.
		setupNavigation();

		// set the alignment of the Explanations.
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		explanationConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
		explanationConstraint.weightx = 1.0;
		explanationConstraint.weighty = 1.0;
		explanationConstraint.gridx = 0;
		explanationConstraint.gridy = 1;
		explanationConstraint.gridwidth = 5;
		this.setExplanations(new JLabel(
				"<html><body> Explanations for the histograms experiment!"));
		this.add(this.explanations, explanationConstraint);

		// setup the Panel for buttons for incrementing/decrementing the key.
		this.keyControl = new JPanel(new GridLayout(1, 1));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.anchor = GridBagConstraints.PAGE_END;
		keyConst.weightx = 0.5;
		keyConst.weighty = 0.5;
		keyConst.gridx = 0;
		keyConst.gridy = 0;
		keyConst.gridwidth = 5;
		this.add(this.keyControl, keyConst);
		//key
		this.key = new JLabel("0");
		this.keyControl.add(this.key);
		// increment.
		this.increment = new JButton("+1");
		this.keyControl.add(this.increment);
		// decrement.
		this.decrement = new JButton("-1");
		this.keyControl.add(this.decrement);
		// layout the buttons.
		this.keyControl.validate();

		// TODO:Histogram UI-Element not implemented yet!
		// this.histogram = new CharacterFrequencyDiagramView({1,2,3,4,5});

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
		/*
		 * GridBagConstraints backConst = new GridBagConstraints(); backConst.weightx = 1.0;
		 * backConst.weighty = 0.1; backConst.gridx = 0; backConst.gridy = 0; backConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getBackButton(), BorderLayout.WEST);

		// set up the aligment of the button Next;
		this.setNextButton(new JButton(
				"Skip the histograms(Visualization Done)!"));

		/*
		 * GridBagConstraints nextConst = new GridBagConstraints(); nextConst.weightx = 1.0;
		 * nextConst.weighty = 0.1; nextConst.gridx = 10; nextConst.gridy = 1; nextConst.gridwidth =
		 * 3;
		 */
		this.navigationPanel.add(this.getNextButton(), BorderLayout.EAST);

	}

	/**
	 * @return the histogram
	 */
	public CharacterFrequencyDiagramView getHistogram() {
		return histogram;
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
	public JTextField[] getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(JTextField[] cipher) {
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
	 * @param histogram
	 *            the histogram to set
	 */
	public void setHistogram(CharacterFrequencyDiagramView histogram) {
		this.histogram = histogram;
	}

	/**
	 * @return the keyValue
	 */
	public int getKeyValue() {
		return keyValue;
	}

	/**
	 * @param keyValue the keyValue to set
	 */
	public void setKeyValue(int keyValue) {
		this.keyValue = keyValue;
	}
}
