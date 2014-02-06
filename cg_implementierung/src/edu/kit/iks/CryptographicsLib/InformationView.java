package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * View of the information page
 * 
 * @author Christian Dreher
 */
public class InformationView extends JPanel implements ComponentListener {
	
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
	private String html;
	
	/**
	 * The Swing FX panel. Only access from the Swing hread.
	 */
	private JFXPanel fxPanel;
	
	/**
	 * The fxPanel's size. Only access this property through the getter and
	 * setter to ensure synchronized access!
	 */
	private Dimension fxPanelSize;
	
	/**
	 * The JavaFX WebView. Only access this property from the JavaFX thread!
	 */
	private WebView webView;
	
	/**
	 * Constructor initializing a new instance of {InformationView}
	 * with given {HTML} and {qrCode}
	 * 
	 * @param html The HTML used to display the additional informations
	 * @param qrCode QR code for further information
	 */
	public InformationView(String html, Image qrCode) {
		this.qrCode = qrCode;
		this.html = html;
		
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
	
	/**
	 * Loads a FXPanel that can host JavaFX views. This is necessary
	 * because Swing does not provide a usable WebView.
	 */
	private void loadWebView() {
		this.fxPanel = new JFXPanel();
		this.fxPanel.addComponentListener(this);
		GridBagConstraints fxConstraints = new GridBagConstraints();
        fxConstraints.gridx = 0;
        fxConstraints.gridy = 0;
        fxConstraints.weightx = 1.0;
        fxConstraints.weighty = 0.9;
        fxConstraints.fill = GridBagConstraints.BOTH;
        this.add(this.fxPanel, fxConstraints);
    }

    /**
     * Loads the JavaFX WebView.
     * @param fxPanel the FXPanel
     */
    private void loadFXWebView(final JFXPanel fxPanel, Dimension size) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);
        
        // Create web view.
        this.webView = new WebView();
        group.getChildren().add(this.webView);
        
        // Load the HTML data.
        WebEngine webEngine = this.webView.getEngine();
        webEngine.loadContent(this.getHtml());
    }
	
	/**
	 * Gets the file path to the local HTML file with further information
	 * 
	 * @return File path to the local HTML file with further information
	 */
	public String getHtml() {
		return this.html;
	}
	
	/**
	 * Gets the QR code for further information
	 * 
	 * @return QR code for further information
	 */
	public Image getQrCode() {
		return this.qrCode;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// Set size.
		this.setFxPanelSize(this.fxPanel.getSize());
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Dimension size = getFxPanelSize();
				if (webView == null) {
					loadFXWebView(fxPanel, size);
				}
				webView.setMaxSize(size.getWidth(), size.getHeight());
		        webView.setPrefSize(size.getWidth(), size.getHeight());
			}
		});
	}
	
	/**
	 * Synchronizes the access to fxPanelSize since we use it on two threads.
	 * @param size the size
	 */
	private synchronized void setFxPanelSize(Dimension size) {
		this.fxPanelSize = size;
	}
	
	/**
	 * Synchronizes the access to fxPanelSize since we use it on two threads.
	 * @return the size
	 */
	private synchronized Dimension getFxPanelSize() {
		return this.fxPanelSize;
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// Unused
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// Unused
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// Unused
	}
}
