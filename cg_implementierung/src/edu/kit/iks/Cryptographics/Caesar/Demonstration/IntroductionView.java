package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

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

	private GridBagLayout introLayout;

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

	int x;
	private int y;

	private Timer timer;

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

		this.introLayout = new GridBagLayout();
		GridBagConstraints nextConstraint = new GridBagConstraints();
		this.setLayout(introLayout);

		nextConstraint.anchor = nextConstraint.FIRST_LINE_START;
		nextConstraint.weightx = 0;
		nextConstraint.weighty = 0;
		nextConstraint.gridx = 0;
		nextConstraint.gridy = 0;
		introLayout.setConstraints(this.getNextButton(), nextConstraint);

		GridBagConstraints proceedConstraint = new GridBagConstraints();
		proceedConstraint.anchor = proceedConstraint.PAGE_START;
		proceedConstraint.weightx = 0.5;
		proceedConstraint.weighty = 0.5;
		proceedConstraint.gridx = 0;
		proceedConstraint.gridy = 0;
		this.setProceed(new JButton("Forward the animation!"));
		this.add(this.proceed, proceedConstraint);

		this.setExplanation(new JLabel());
		this.add(this.explanation);

		GridBagConstraints caesarImgConstraint = new GridBagConstraints();
		caesarImgConstraint.anchor = caesarImgConstraint.LINE_START;
		caesarImgConstraint.weightx = 0.1;
		caesarImgConstraint.weighty = 0.5;
		caesarImgConstraint.gridx = 0;
		caesarImgConstraint.gridy = 0;
		
		this.setCaesarImg(new ImageView(introResource.getChild("caesarImage")
				.getAttributeValue("path")));
		this.add(this.caesarImg, caesarImgConstraint);
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		
		explanationConstraint.anchor = explanationConstraint.PAGE_END;
		explanationConstraint.weightx = 0.5;
		explanationConstraint.weighty = 0;
		explanationConstraint.gridx = 0;
		explanationConstraint.gridy = 0;
		introLayout.setConstraints(this.explanation, explanationConstraint);
		this.explanation
				.setText("Caesar makes up a big plan and sends his orders by his messenger.");

		this.x = 0;
		this.y = 0;
		this.validate();

	}

	/**
	 * 
	 */
	public void firstAnimation() {
		this.timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getCaesarImg().getX() < 400) {
				animate();
				} else {
				getTimer().stop();
				}
			}
		});
		x = getCaesarImg().getX();
		this.timer.start();
	}

	public void animate() {
		x += 10;
		int y = getCaesarImg().getY();
		getCaesarImg().setBounds( x, y, getPreferredSize().width, getPreferredSize().height);
		getCaesarImg().validate();	
		this.repaint();
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

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @return the introLayout
	 */
	public GridBagLayout getIntroLayout() {
		return introLayout;
	}

}
