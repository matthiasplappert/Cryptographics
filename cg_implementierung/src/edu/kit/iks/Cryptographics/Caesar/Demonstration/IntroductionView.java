package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * This is the first view the user gets presented when he requests the
 * visualization of Caesar's cipher. Here the user gets to know what problems
 * Caesar faced when his enemies could intercept and read his orders. The
 * JLabels will contain images that will represent Caesar for example. Meanwhile
 * user gets explanations shown that explain what what the animation means and
 * does.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class IntroductionView extends VisualizationView {

	/**
	 * Labels that will contain img for animation.
	 */
	private JLabel caesar;
	private JLabel cipher;
	private JLabel interceptor;

	public IntroductionView() {
		super();
		this.add(new JLabel("CAESAR INTRODUCTION"));
		this.validate();
	}

	/**
	 * @param c
	 */
	public void animationStart() {
		// perform first animation and show explanations.
		step1();
		// stop.
		// perform second animation and show explanations.
		step2();
		// stop.
		// ...
		step3();
		// stop.
		// perform last animation and show explanations.
		step4();
		// done.

	}

	/**
	 * Caesar makes up a big plan and sends his orders by his messenger.
	 */
	private void step1() {

	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	private void step2() {

	}

	/**
	 * Enemy reads his orders and Caesar's big plan is crossed.
	 */
	private void step3() {

	}

	/**
	 * Caesar is very sad.
	 */
	private void step4() {

	}

	/**
	 * @return the caesar
	 */
	public JLabel getCaesar() {
		return caesar;
	}

	/**
	 * @param caesar
	 *            the caesar to set
	 */
	public void setCaesar(JLabel caesar) {
		this.caesar = caesar;
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
	 * @return the interceptor
	 */
	public JLabel getInterceptor() {
		return interceptor;
	}

	/**
	 * @param interceptor
	 *            the interceptor to set
	 */
	public void setInterceptor(JLabel interceptor) {
		this.interceptor = interceptor;
	}
}
