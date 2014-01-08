package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

public class InformationView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8593552609491347799L;

	private Image qrCode;
	
	private URL path;
	
	public InformationView(URL path, Image qrCode) {
		this.qrCode = qrCode;
		this.path = path;
	}
	
	public URL getPath() {
		return this.path;
	}
	
	public Image getQrCode() {
		return this.qrCode;
	}
}
