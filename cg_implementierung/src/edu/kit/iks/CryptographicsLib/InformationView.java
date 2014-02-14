package edu.kit.iks.CryptographicsLib;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	private String html;
	
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
	 * Loads the web view.
	 */
	private void loadWebView() {
		// Constraints.
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1.0;
		constraints.weighty = 0.9;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.fill = GridBagConstraints.BOTH;
		
		// Editor pane used as a web view.
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setContentType("text/html");
		editorPane.setBackground(Color.BLUE);
		try {
			editorPane.setText(this.getHtml());
		} catch(Exception e) {
			Logger.e(e);
		}
		editorPane.setCaretPosition(0); // scrolls to the top
		
		// Scroll pane that contains the editor pane.
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.validate();
        this.add(scrollPane, constraints);
    }
	
	/**
	 * Returns the HTML contents of the additional informations.
	 * 
	 * @return the HTML contents
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
}
