package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
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
	 * Container for the animations.
	 */
	private JPanel animationContainer;

	/**
	 * Labels that will contain img for animation.
	 */
	private ImageView caesarImg;
	private ImageView courier;
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

	/**
	 * 
	 */
	public IntroductionView() {
		super();
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		Element introResource = vsInfo.getResources().getChild("Introduction");
		this.animationContainer = new JPanel();
		this.getBackButton().setVisible(false);
		this.getNextButton().setText("Go to Caesar's idea!");
		this.setBackground(Color.BLUE);

		GridBagLayout introLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(introLayout);

		c.anchor = c.FIRST_LINE_START;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		introLayout.setConstraints(this.getNextButton(), c);

		c.anchor = c.PAGE_START;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.setProceed(new JButton("Forward the animation!"));
		this.add(this.proceed, c);

		this.setExplanation(new JLabel());
		this.add(this.explanation);

		c.anchor = c.LINE_START;
		c.weightx = 0;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.setCaesarImg(new ImageView(introResource.getChild("caesarImage")
				.getAttributeValue("path")));
		this.add(this.caesarImg, c);
		c.anchor = c.PAGE_END;
		c.weightx = 0.5;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		introLayout.setConstraints(this.explanation, c);
		this.explanation
				.setText("Caesar makes up a big plan and sends his orders by his messenger.");
		
		this.validate();

	}

	/**
	 * 
	 */
	public void firstAnimation() {

	}

	/**
	 * 
	 */
	public void secondAnimation() {

	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
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
	 * @param animationContainer
	 *            the animationContainer to set
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
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(ImageView orders) {
		this.orders = orders;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

	/**
	 * @return the courier
	 */
	public ImageView getCourier() {
		return courier;
	}

	/**
	 * @param courier
	 *            the courier to set
	 */
	public void setCourier(ImageView courier) {
		this.courier = courier;
	}

}
