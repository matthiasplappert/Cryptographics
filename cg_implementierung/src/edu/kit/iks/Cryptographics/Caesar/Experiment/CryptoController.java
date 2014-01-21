package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * Controller for the first and second step of the experiment phase. When user
 * has to put input and encrypt it and in the second step to decrypt a given
 * cipher. Controls the needed elements from CaesarUpperView, !!see CGeneralView
 * for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoController extends AbstractVisualizationController {

	/**
	 * The according View.
	 */
	private CryptoView view;

	/**
	 * Model that is needed for computations.
	 */
	private CryptoModel model;

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public CryptoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

	}

	@Override
	public void loadView() {
		this.view = new CryptoView();
		this.model = new CryptoModel();
		this.view.getInput().addActionListener(new ActionListener() {

			/*
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Delegate Input for further checks to the model.
			}
		});
		this.view.getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
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

	}

	/**
	 * Method for delegating user's input to the model for the needed
	 * computations and checks.
	 * 
	 * @param input
	 */
	public void delegateAndHandleInput(String input) {
		if (this.model.handleInput(input))
			proceed();
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
	public JPanel getView() {
		return this.view;
	}

	/**
	 * @return the model
	 */
	public CryptoModel getModel() {
		return model;
	}

	/**
	 * Method called when the input was correct.
	 */
	private void proceed() {

	}

}
