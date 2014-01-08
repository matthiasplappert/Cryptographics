package edu.kit.iks.Cryptographics.Caesar.Experiment;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.UICharacterFrequencyDiagram;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This view represents the last view of the experiment phase. The elements
 * contained here allow the user to break a given caesar cipher and have the
 * purpose to show him the disadvantages of the caesar cipher, in particular how
 * easy it is to break it. In additional user gets an animation presented that
 * describe what histogramms are and how they could help him solving his task to
 * break the cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class HistogramView extends VisualizationView{

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
	 * Labels that contain a encrypted characters for demonstration purpose.
	 */
	private JLabel[] cipher;

	/**
	 * Explanations of the animations.
	 */
	private JLabel explanations;

	/**
	 * Key that is being incremented and decremented.
	 */
	private JLabel key;

	/**
	 * Label that will contain a histogram image that will be explained to the
	 * user.
	 */
	private UICharacterFrequencyDiagram histogram;

	/**
	 * @return the histogram
	 */
	public UICharacterFrequencyDiagram getHistogram() {
		return histogram;
	}

	/**
	 * Constructor.
	 */
	public HistogramView() {

	}

	/**
	 * Explanations and animations are shown that explain histograms.
	 */
	public void startAnimations() {
		step1();
		// stop.
		step2();
		// stop.
		step3();
		// stop.
		step4();
		// done.
	}

	/**
	 * Explain why the Caesar cipher is not appropriate nowadays.
	 */
	private void step1() {

	}

	/**
	 * Explain what histograms are.
	 */
	private void step2() {

	}

	/**
	 * Explain how they are used and how to read from them.
	 */
	private void step3() {

	}

	/**
	 * Explain how to decrypt big text that was ciphered with Caesar without a
	 * key.
	 */
	private void step4() {

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
	public JLabel[] getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(JLabel[] cipher) {
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
}
