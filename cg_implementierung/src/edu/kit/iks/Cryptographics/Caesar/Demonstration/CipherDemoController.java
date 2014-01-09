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
 * Controller for the last step of demonstration phase. Controls the needed
 * elements from CaesarUpperView, !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoController extends AbstractVisualizationController {

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	private CipherDemoView view;

	/**
	 * @param visualizationInfo
	 */
	public CipherDemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public void loadView() {
		this.view = new CipherDemoView();
		this.view.getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
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
                 proceedAnimation();
			}
		});

		this.view.validate();
	}

	/**
	 * Needed for dispatching the clickEvent from the button to activate the
	 * animation of the view.
	 */
	public void proceedAnimation() {
		this.view.animationStart();
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
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
}
