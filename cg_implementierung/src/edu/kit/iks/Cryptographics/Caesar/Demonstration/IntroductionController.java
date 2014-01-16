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

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		this.view = new IntroductionView();
		CaesarVisualizationInfo vsInfo = (CaesarVisualizationInfo) this.getVisualizationInfo();
		Element caesarResources = vsInfo.getResources();
		
		this.view.setProceed(new JButton("proceed"));
		this.view.add(this.view.getProceed());
		this.view.setExplanation(new JLabel("explanations"));
		this.view.add(this.view.getExplanation());
		this.view.setCaesarImg(new ImageView(caesarResources.getChild("caesarImage").getAttributeValue("name")));
		this.view.add(this.view.getCaesarImg());

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
			this.view.step1();
			break;
		case 2:
			this.view.step2();
			break;
		case 3:
			this.view.step3();
			break;
		case 4:
			this.view.step4();
			break;
		default:
			animationDone();
		}
	}

	/**
	 * @param step
	 */
	private void unloadAnimation(int step) {

	}

	/**
	 * 
	 */
	private void animationDone() {
		// TODO Auto-generated method stub

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


}