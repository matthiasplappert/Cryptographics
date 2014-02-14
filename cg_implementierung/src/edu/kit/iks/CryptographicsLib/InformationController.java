package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	
	private String additionalInformationHtml;
	
	/**
	 * Constructor initializing a new instance of {InformationController}
	 * with given {visualizationInfo}
	 * 
	 * @param visualizationInfo Object of {VisualizationInfo} containing the data to
	 *		instantiate related controllers from
	 */
	public InformationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		
		// Load the HTML.
		String path = visualizationInfo.getAdditionalInformationPath();
		InputStream inputStream = visualizationInfo.getClass().getResourceAsStream(path);
		if (inputStream == null) {
			Logger.d("InformationController", "InformationController", "could not read " + path);
		}
		this.additionalInformationHtml = InformationController.getStringFromInputStream(inputStream);
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		Image qrCode = this.getVisualizationInfo().getQrCode();
		this.view = new InformationView(this.additionalInformationHtml, qrCode);
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
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		return "Here you can learn more about " + this.getVisualizationInfo().getName() + ". You can also scan the QR code at the bottom of the page to take additional information home. Once you're done, just click the exit button.";
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public InformationView getView() {
		return this.view;
	}
	
	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}
}
