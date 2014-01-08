package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;

/**
 * Controller for each procedure displaying further
 * information
 * 
 * @author Christian Dreher
 */
public class InformationController extends AbstractVisualizationController {
	
	/**
	 * View of the controller
	 */
	private InformationView view;
	
	/**
	 * Constructor initializing a new instance of {InformationController}
	 * with given {visualizationInfo}
	 * 
	 * @param visualizationInfo Object of {VisualizationInfo} containing the data to
	 *		instantiate related controllers from
	 */
	public InformationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		URL path = this.getVisualizationInfo().getAdditionalInformationFileURL();
		Image qrCode = this.getVisualizationInfo().getQrCode();
		
		this.view = new InformationView(path, qrCode);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		// TODO: implement me!
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public InformationView getView() {
		return this.view;
	}
}
