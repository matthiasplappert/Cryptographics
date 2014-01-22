package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdom2.Element;

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
	private ImageView masterPlan;
	private ImageView courier;
	private ImageView orders;
	private ImageView cipher;
	private ImageView obelix;

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
	 * Constructor of this View.
	 */
	public IntroductionView() {
		super();
		// load the resources from the xml, that can be accessed over the
		// visualizationInfo
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		Element introResource = vsInfo.getResources().getChild("Introduction");

		// no need of BackButton. Button for returning to start screen already
		// the "Exit" button.
		this.getBackButton().setVisible(false);
		this.getNextButton().setText(
				"Forget the story, i want to know how the cipher works!");

		this.introLayout = new GridBagLayout();
		GridBagConstraints nextConstraint = new GridBagConstraints();
		this.setLayout(introLayout);

		// set the alignment of NextButton.
		nextConstraint.anchor = GridBagConstraints.FIRST_LINE_END;
		nextConstraint.weightx = 1.0;
		nextConstraint.weighty = 1.0;
		nextConstraint.gridx = 0;
		nextConstraint.gridy = 1;
		introLayout.setConstraints(this.getNextButton(), nextConstraint);

		// set the alignment of the proceed Button, that is needed to proceed in
		// animation.
		GridBagConstraints proceedConstraint = new GridBagConstraints();
		proceedConstraint.anchor = GridBagConstraints.CENTER;
		proceedConstraint.weightx = 1.0;
		proceedConstraint.weighty = 1.0;
		proceedConstraint.gridx = 0;
		proceedConstraint.gridy = 0;
		this.setProceed(new JButton("How does the legend go on?"));
		this.add(this.proceed, proceedConstraint);

		// set the alignment of the masterPlan image.
		GridBagConstraints planConstraint = new GridBagConstraints();
		planConstraint.anchor = GridBagConstraints.LINE_START;
		planConstraint.weightx = 1.0;
		planConstraint.weighty = 1.0;
		planConstraint.gridx = 0;
		planConstraint.gridy = 0;

		// take the image from the xml-resource.
		this.setMasterPlan(new ImageView(introResource.getChild("masterPlan")
				.getAttributeValue("path")));
		this.add(this.masterPlan, planConstraint);

		// set the alignment of the Explanations.
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		explanationConstraint.anchor = GridBagConstraints.PAGE_START;
		explanationConstraint.weightx = 1.0;
		explanationConstraint.weighty = 1.0;
		explanationConstraint.gridx = 0;
		explanationConstraint.gridy = 0;
		this.setExplanation(new JLabel(
				"<html><body>Eines Tages, etwa 70 v.Chr , tüftelte Caesar einen ultra-mega-großen-master-plan <br>"
						+ " aus um Gallien endlich zu erobern. Und schickte diesen an seine Armee in Gallien. <br>"));
		this.add(this.explanation, explanationConstraint);

		// layout the component of the Panel.
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
		getCaesarImg().setBounds(x, y, getPreferredSize().width,
				getPreferredSize().height);
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
	 * @param jTextField
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
	public ImageView getObelix() {
		return obelix;
	}

	/**
	 * @param interceptor
	 *            the interceptor to set
	 */
	public void setObelix(ImageView interceptor) {
		this.obelix = interceptor;
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

	/**
	 * @return the masterPlan
	 */
	public ImageView getMasterPlan() {
		return masterPlan;
	}

	/**
	 * @param masterPlan
	 *            the masterPlan to set
	 */
	public void setMasterPlan(ImageView masterPlan) {
		this.masterPlan = masterPlan;
	}

}
