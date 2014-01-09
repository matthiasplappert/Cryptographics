package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * This class is the controller of the view CFirstView.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class IntroductionController extends AbstractVisualizationController {

	/**
	 * Variable holding track of the current step user has proceeded in the
	 * animation.
	 */
	private int step;

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
		this.view.getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
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
				animationProceed();

			}
		});

		this.view.validate();
	}

	/**
	 * Needed for dispatching the clickEvent from the button to activate the
	 * animation of the view.
	 */
	public void animationProceed() {
		this.view.animationStart();
	}

}