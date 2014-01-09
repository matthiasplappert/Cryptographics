package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;

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
	 * 
	 */
	private static final long serialVersionUID = -7214639660774564585L;

	/**
	 * Labels that will contain img for animation.
	 */
	private Image caesar;
	private Image cipher;
	private Image interceptor;

	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;

	/**
	 * JLabel that holds text which is needed for explaining what now happens,
	 * will happen or happened.
	 */
	private JLabel explanation;

	public IntroductionView() {
		super();
		this.add(new JLabel("CAESAR INTRODUCTION"));
		this.explanation = new JLabel("Explanations");
		this.add(explanation);
		this.proceed = new JButton("Proceed");
		this.add(proceed);
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
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
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
	 * @return the explanation
	 */
	public JLabel getExplanation() {
		return explanation;
	}

	/**
	 * @param explanation
	 *            the explanation to set
	 */
	public void setExplanation(JLabel explanation) {
		this.explanation = explanation;
	}

	/**
	 * @return the caesar
	 */
	public Image getCaesar() {
		return caesar;
	}

	/**
	 * @param caesar
	 *            the caesar to set
	 */
	public void setCaesar(Image caesar) {
		this.caesar = caesar;
	}

	/**
	 * @return the cipher
	 */
	public Image getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(Image cipher) {
		this.cipher = cipher;
	}

	/**
	 * @return the interceptor
	 */
	public Image getInterceptor() {
		return interceptor;
	}

	/**
	 * @param interceptor
	 *            the interceptor to set
	 */
	public void setInterceptor(Image interceptor) {
		this.interceptor = interceptor;
	}
}
