package edu.kit.iks.CryptographicsLib;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;

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
	private String url;
	
	/**
	 * Constructor initializing a new instance of {InformationView}
	 * with given {path} and {qrCode}
	 * 
	 * @param path File path to the local HTML file with further information
	 * @param qrCode QR code for further information
	 */
	public InformationView(String url, Image qrCode) {
		this.qrCode = qrCode;
		this.url = url;
		
		this.setLayout(new GridBagLayout());
		
		// Load the web view.
		this.loadWebView();
		
		// Load the image view.
		GridBagConstraints imageConstraints = new GridBagConstraints();
		imageConstraints.gridx = 0;
		imageConstraints.gridy = 1;
		imageConstraints.weightx = 1.0;
		imageConstraints.weighty = 0.1;
		ImageView view = new ImageView(qrCode);
		this.add(view, imageConstraints);
		
		this.validate();
	}
	
	private void loadWebView() {
	    final JEditorPane editorPane = new JEditorPane();
	    editorPane.setEditable(false);

	    // Use HTML.
	    editorPane.setEditorKitForContentType("text/html", new HTMLEditorKit());
	    try {
	    	editorPane.setPage(this.url);
	    } catch(Exception e) {
	    	// TODO handle
	    	e.printStackTrace();
	    }
	    JScrollPane scrollPane = new JScrollPane(editorPane); 

	    // Add the scroll pane.
	    GridBagConstraints scrollConstraints = new GridBagConstraints();
	    scrollConstraints.gridx = 0;
	    scrollConstraints.gridy = 0;
	    scrollConstraints.weighty = 0.9;
	    scrollConstraints.weightx = 1.0;
	    scrollConstraints.fill = GridBagConstraints.BOTH;
	    this.add(scrollPane, scrollConstraints);
	}
	
	/**
	 * Gets the file path to the local HTML file with further information
	 * 
	 * @return File path to the local HTML file with further information
	 */
	public String getUrl() {
		return this.url;
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
