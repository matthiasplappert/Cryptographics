package edu.kit.iks.CryptographicsLib;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
		final JFXPanel fxPanel = new JFXPanel();
		GridBagConstraints fxConstraints = new GridBagConstraints();
        fxConstraints.gridx = 0;
        fxConstraints.gridy = 0;
        fxConstraints.weightx = 1.0;
        fxConstraints.weighty = 0.9;
        fxConstraints.fill = GridBagConstraints.BOTH;
        this.add(fxPanel, fxConstraints);
        
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    /* Creates a WebView and fires up google.com */
    private void initFX(final JFXPanel fxPanel) {
    	// TODO properly size and configure
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webView = new WebView();
        group.getChildren().add(webView);
        webView.setMinSize(800, 600);
        webView.setMaxSize(800, 600);

        // Obtain the webEngine to navigate.
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com/");
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
