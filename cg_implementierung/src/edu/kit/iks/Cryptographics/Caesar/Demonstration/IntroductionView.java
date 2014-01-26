package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Dimension;
import java.awt.Font;
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
	private ImageView caesarIdeaImg;
	private ImageView backgroundImg;
	private ImageView courier;
	private int xCoordCourier;
	private ImageView caesarEvil;
	
	private ImageView boar;
	private ImageView obelix;
	private ImageView orders;


	// needed only for animations.
	private Timer timer;
	private int y;

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

		this.introLayout = new GridBagLayout();
		GridBagConstraints nextConstraint = new GridBagConstraints();
		this.setLayout(introLayout);

		// set the container for the animations.
		this.animationContainer = new JPanel(new GridBagLayout());
		GridBagConstraints animationConstraints = new GridBagConstraints();
		animationConstraints.gridx = 0;
		animationConstraints.gridy = 0;
		animationConstraints.gridwidth = 10;
		animationConstraints.fill = GridBagConstraints.BOTH;
		this.add(animationContainer, animationConstraints);

		// no need of BackButton. Button for returning to start screen already
		// the "Exit" button.
		this.getBackButton().setVisible(false);
		this.getNextButton().setText("Skip the introduction!");
		this.getNextButton().setPreferredSize(new Dimension(350, 50));
		this.getNextButton().setFont(new Font("Arial", 2, 25));

		// set the alignment of NextButton.
		nextConstraint.anchor = GridBagConstraints.NORTHEAST;
		nextConstraint.weightx = 1.0;
		nextConstraint.weighty = 0.1;
		nextConstraint.gridx = 1;
		nextConstraint.gridy = 0;
		introLayout.setConstraints(this.getNextButton(), nextConstraint);

		// set the alignment of the proceed Button, that is needed to proceed in
		// animation.
		GridBagConstraints proceedConstraint = new GridBagConstraints();
		// proceedConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
		proceedConstraint.weightx = 1.0;
		proceedConstraint.weighty = 0.1;
		proceedConstraint.gridx = 1;
		proceedConstraint.gridy = 2;
		proceedConstraint.gridwidth = 3;
		this.setProceed(new JButton("Tell me more."));
		this.proceed.setPreferredSize(new Dimension(250, 50));
		this.proceed.setFont(new Font("Arial", 2, 25));
		this.add(this.proceed, proceedConstraint);

		// set the alignment of the masterPlan image.
		GridBagConstraints planConstraint = new GridBagConstraints();
		// planConstraint.anchor = GridBagConstraints.WEST;
		// planConstraint.weightx = 1.0;
		// planConstraint.weighty = 0.1;
		planConstraint.gridx = 1;
		planConstraint.gridy = 0;

		// take the image from the xml-resource.
		this.setCaesarIdeaImg(new ImageView(introResource.getChild("CaesarIdea")
				.getAttributeValue("path")));
		this.animationContainer.add(this.caesarIdeaImg, planConstraint);

		// set the alignment of the Explanations.
		GridBagConstraints explanationConstraint = new GridBagConstraints();
		// explanationConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
		// explanationConstraint.weightx = 1.0;
		// explanationConstraint.weighty = 1.0;
		explanationConstraint.gridx = 1;
		explanationConstraint.gridy = 1;
		explanationConstraint.gridwidth = 5;
		this.setExplanation(new JLabel(
				"<html><body>Eines Tages, etwa 70 v.Chr , tüftelte Caesar einen ultra-mega-großen-master-plan <br>"
						+ " aus um Gallien endlich zu erobern. Und schickte diesen an seine Armee in Gallien. <br>"));
		this.explanation.setFont(new Font("Arial", 2, 20));
		this.add(this.explanation, explanationConstraint);

		// layout the component of the Panel.
		this.validate();

	}

	// Animations stubs.

	public void firstAnimation() {
		this.timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getCourier().getX() < (getAnimationContainer().getWidth() - 200)) {
					animate();
				} else {
					getTimer().stop();
				}
			}
		});
		xCoordCourier = getCourier().getX();
		this.timer.start();
	}

	public void animate() {
		xCoordCourier += 10;
		int y = getCourier().getY();
		getCourier().setBounds(xCoordCourier, y, getPreferredSize().width,
				getPreferredSize().height);
		getCourier().validate();
		this.repaint();
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
	 * @return the introLayout
	 */
	public GridBagLayout getIntroLayout() {
		return introLayout;
	}

	/**
	 * @return the masterPlan
	 */
	public ImageView getCaesarIdeaImg() {
		return caesarIdeaImg;
	}

	/**
	 * @param caesarIdaImg
	 *            the masterPlan to set
	 */
	public void setCaesarIdeaImg(ImageView caesarIdaImg) {
		this.caesarIdeaImg = caesarIdaImg;
	}

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * @return the background
	 */
	public ImageView getBackgroundImg() {
		return backgroundImg;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackgroundImg(ImageView background) {
		this.backgroundImg = background;
	}

	/**
	 * @return the xCoord
	 */
	public int getxCoordCourier() {
		return xCoordCourier;
	}

	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoordCourier(int xCoord) {
		this.xCoordCourier = xCoord;
	}

	/**
	 * @return the boar
	 */
	public ImageView getBoar() {
		return boar;
	}

	/**
	 * @param boar the boar to set
	 */
	public void setBoar(ImageView boar) {
		this.boar = boar;
	}

	/**
	 * @return the caesarEvil
	 */
	public ImageView getCaesarEvil() {
		return caesarEvil;
	}

	/**
	 * @param caesarEvil the caesarEvil to set
	 */
	public void setCaesarEvil(ImageView caesarEvil) {
		this.caesarEvil = caesarEvil;
	}

}
