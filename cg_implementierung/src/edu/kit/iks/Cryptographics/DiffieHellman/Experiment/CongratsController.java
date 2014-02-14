package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * The controller for the congratsview
 * holds the congratsview
 * 
 * @author kai
 *
 */
public class CongratsController extends AbstractVisualizationController {
	
	/** the corresponding congratsview */
	private CongratsView view;
	
	/**
	 * simple constructor
	 * @param visualizationInfo dh info
	 */
	public CongratsController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		return view.getHelp();
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		view = new CongratsView();		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public CongratsView getView() {
		return (CongratsView) this.view;
	}
}
