package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.ImageView;

/**
 * This class is the controller of the view CFirstView.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class IntroductionController extends AbstractVisualizationController {

	/**
	 * Variable holding track of the current step user has proceeded in the
	 * animation. if it is 0, then it is the last step.
	 */
	private int AnimationStep;

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	private IntroductionView view;

	/**
     * 
     */
	private Element caesarResource;

	/**
	 * @param visualizationInfo
	 */
	public IntroductionController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public JComponent getView() {
		return this.view;
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {

		return "Just click proceed till it works and see the magic.";
	}

	@Override
	public void loadView() {
		CaesarVisualizationInfo vsInfo = (CaesarVisualizationInfo) this
				.getVisualizationInfo();
		this.caesarResource = vsInfo.getResources();
		this.view = new IntroductionView();
		this.AnimationStep = 1;

		this.view.setProceed(new JButton("proceed"));
		this.view.add(this.view.getProceed());
		this.view.setExplanation(new JLabel("explanations"));
		this.view.add(this.view.getExplanation());

		this.view.getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentNextVisualizationController();
			}
		});

		this.view.getProceed().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				animationProceed(getAnimationStep());

			}
		});

		this.view.validate();
	}

	/**
	 * Needed for dispatching the clickEvent from the button to activate the
	 * animation of the view.
	 */
	public void animationProceed(int step) {

		this.animationStart(step);
	}

	/**
	 * Method for
	 * 
	 * @param c
	 */
	private void animationStart(int step) {
		switch (step) {
		case 1:
			step1();
			break;
		case 2:
			step2();
			break;
		case 3:
			step3();
			break;
		case 4:
			animationDone();
		}
	}

	/**
	 * Caesar makes up a big plan and sends his orders by his messenger.
	 */
	private void step1() {
		this.AnimationStep++;

		this.view.setCaesarImg(new ImageView(getCaesarResource().getChild(
				"caesarImage").getAttributeValue("path")));
		this.view.add(this.view.getCaesarImg());
		this.view
				.getExplanation()
				.setText(
						"Caesar makes up a big plan and sends his orders by his messenger.");

		this.view.validate();

		this.view.firstAnimation();

	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	private void step2() {
		this.AnimationStep++;

		this.view.setInterceptor(new ImageView(getCaesarResource().getChild(
				"interceptorImage").getAttributeValue("path")));
		this.view.add(this.view.getInterceptor());
		this.view.getExplanation().setText("Caesar's orders gets intercepted.");
		this.view.validate();

		this.view.secondAnimation();
	}

	/**
	 * Enemy reads his orders and Caesar's big plan is crossed.
	 */
	private void step3() {
		this.AnimationStep++;
		this.view.getExplanation().setText("PLAN CROSSED");
		this.view.validate();
	}

	/**
	 * 
	 */
	private void animationDone() {
		this.view.remove(this.view.getCaesarImg());
		this.view.setCaesarImg(null);
		this.view.remove(this.view.getInterceptor());
		this.view.setInterceptor(null);
		this.view.remove(this.view.getExplanation());
		this.view.setExplanation(null);
		this.view.remove(this.view.getProceed());
		this.view.setProceed(null);
		this.view.add(new JLabel("Animation is done and Caesar is very sad"));
		this.view.revalidate();
	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return AnimationStep;
	}

	/**
	 * @param animationStep
	 *            the animationStep to set
	 */
	public void setAnimationStep(int animationStep) {
		AnimationStep = animationStep;
	}

	/**
	 * @return the caesarResource
	 */
	public Element getCaesarResource() {
		return caesarResource;
	}

}