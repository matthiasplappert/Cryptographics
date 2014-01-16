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
	public IntroductionView getView() {
		return (IntroductionView) this.view;
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

		this.getView().setProceed(new JButton("proceed"));
		this.getView().add(this.getView().getProceed());
		this.getView().setExplanation(new JLabel("explanations"));
		this.getView().add(this.getView().getExplanation());

		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentNextVisualizationController();
			}
		});

		this.getView().getProceed().addMouseListener(new MouseListener() {

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

		this.getView().validate();
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

		this.getView().setCaesarImg(new ImageView(getCaesarResource().getChild(
				"caesarImage").getAttributeValue("path")));
		this.getView().add(this.getView().getCaesarImg());
		this.getView()
				.getExplanation()
				.setText(
						"Caesar makes up a big plan and sends his orders by his messenger.");

		this.getView().validate();

		this.getView().firstAnimation();

	}

	/**
	 * Caesar's orders gets intercepted.
	 */
	private void step2() {
		this.AnimationStep++;

		this.getView().setInterceptor(new ImageView(getCaesarResource().getChild(
				"interceptorImage").getAttributeValue("path")));
		this.getView().add(this.getView().getInterceptor());
		this.getView().getExplanation().setText("Caesar's orders gets intercepted.");
		this.getView().validate();

		this.getView().secondAnimation();
	}

	/**
	 * Enemy reads his orders and Caesar's big plan is crossed.
	 */
	private void step3() {
		this.AnimationStep++;
		this.getView().getExplanation().setText("PLAN CROSSED");
		this.getView().validate();
	}

	/**
	 * 
	 */
	private void animationDone() {
		this.getView().remove(this.getView().getCaesarImg());
		this.getView().setCaesarImg(null);
		this.getView().remove(this.getView().getInterceptor());
		this.getView().setInterceptor(null);
		this.getView().remove(this.getView().getExplanation());
		this.getView().setExplanation(null);
		this.getView().remove(this.getView().getProceed());
		this.getView().setProceed(null);
		this.getView().add(new JLabel("Animation is done and Caesar is very sad"));
		this.getView().revalidate();
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