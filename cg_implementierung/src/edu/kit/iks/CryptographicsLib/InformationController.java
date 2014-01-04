package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;

public class InformationController extends AbstractVisualizationController {
	
	private InformationView view;
	
	public InformationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	@Override
	public void loadView() {
		URL path = this.getVisualizationInfo().getAdditionalInformationFileURL();
		Image qrCode = this.getVisualizationInfo().getQrCode();
		
		this.view = new InformationView(path, qrCode);
	}

	@Override
	public String getHelp() {
		// TODO: implement me!
		return null;
	}
	
	@Override
	public InformationView getView() {
		return this.view;
	}
}
