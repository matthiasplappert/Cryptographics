package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Document;

import edu.kit.iks.CryptographicsLib.ImageView;
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
	 * Containerpanel for the animations.
	 */
	private JPanel animationContainer;

	Document resources;

	/**
	 * Labels that will contain img for animation.
	 */
	private ImageView caesar;
	private ImageView orders;
	private ImageView cipher;
	private ImageView interceptor;

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
		this.animationContainer = new JPanel();
		this.add(new JLabel("CAESAR INTRODUCTION"));
		this.explanation = new JLabel("Explanations");
		this.add(explanation);
		this.proceed = new JButton("Proceed");
		this.add(proceed);
		this.validate();
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
	public void step1() {
	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	public void step2() {

	}

	/**
	 * Enemy reads his orders and Caesar's big plan is crossed.
	 */
	public void step3() {

	}

	/**
	 * Caesar is very sad.
	 */
	public void step4() {

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
	public ImageView getCaesar() {
		return caesar;
	}

	/**
	 * @param caesar
	 *            the caesar to set
	 */
	public void setCaesar(ImageView caesar) {
		this.caesar = caesar;
	}

	/**
	 * @return the cipher
	 */
	public ImageView getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(ImageView cipher) {
		this.cipher = cipher;
	}

	/**
	 * @return the interceptor
	 */
	public ImageView getInterceptor() {
		return interceptor;
	}

	/**
	 * @param interceptor
	 *            the interceptor to set
	 */
	public void setInterceptor(ImageView interceptor) {
		this.interceptor = interceptor;
	}
}
