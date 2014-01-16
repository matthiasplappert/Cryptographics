package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

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

	/**
	 * Labels that will contain img for animation.
	 */
	private ImageView caesarImg;
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
	public ImageView getCaesarImg() {
		return this.caesarImg;
	}

	/**
	 * @param caesar
	 *            the caesar to set
	 */
	public void setCaesarImg(ImageView caesarImg) {
		this.caesarImg = caesarImg;
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

	/**
	 * @return the animationContainer
	 */
	public JPanel getAnimationContainer() {
		return animationContainer;
	}

	/**
	 * @param animationContainer the animationContainer to set
	 */
	public void setAnimationContainer(JPanel animationContainer) {
		this.animationContainer = animationContainer;
	}

	/**
	 * @return the orders
	 */
	public ImageView getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ImageView orders) {
		this.orders = orders;
	}

	/**
	 * @param proceed the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}
	
}
