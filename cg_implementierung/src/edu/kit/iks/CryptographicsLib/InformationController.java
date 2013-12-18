package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class InformationController extends AbstractVisualizationController {
	public InformationController(AbstractVisualizationInfo visualizationInfo, URL Path, Image QRCode) {
		super(visualizationInfo);	
		this._view = new InformationView(Path, QRCode);
	}
}
