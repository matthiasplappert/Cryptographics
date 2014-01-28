package edu.kit.iks.CryptographicsLib;

import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

/**
 * View of the information page
 * 
 * @author Christian Dreher
 */
public class InformationView extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8593552609491347799L;

	/**
	 * QR code for further information
	 */
	private Image qrCode;
	
	/**
	 * File path to the local HTML file with further information
	 */
	private URL path;
	
	/**
	 * Constructor initializing a new instance of {InformationView}
	 * with given {path} and {qrCode}
	 * 
	 * @param path File path to the local HTML file with further information
	 * @param qrCode QR code for further information
	 */
	public InformationView(URL path, Image qrCode) {
		this.qrCode = qrCode;
		this.path = path;
		
		ImageView view = new ImageView(qrCode);
		this.add(view);
	}
	
	/**
	 * Gets the file path to the local HTML file with further information
	 * 
	 * @return File path to the local HTML file with further information
	 */
	public URL getPath() {
		return this.path;
	}
	
	/**
	 * Gets the QR code for further information
	 * 
	 * @return QR code for further information
	 */
	public Image getQrCode() {
		return this.qrCode;
	}
}
