package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;


public class InformationController extends AbstractVisualizationController {
	public void loadView() {
		URL path = this.getVisualizationInfo().getAdditionalInformationFileURL();
		Image qrCode = this.getVisualizationInfo().getQrCode(); 
		this.view = new InformationView(path, qrCode);
	}
}
