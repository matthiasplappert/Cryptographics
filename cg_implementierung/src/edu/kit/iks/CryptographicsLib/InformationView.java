package edu.kit.iks.CryptographicsLib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

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
		
		// Initialize view.
		this.setLayout(new BorderLayout());
		this.loadWebView();
		this.loadQRCodeView();
		this.validate();
	}
	
	/**
	 * Loads the web view.
	 */
	private void loadWebView() {
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
        this.add(scrollPane, BorderLayout.CENTER);
    }
	
	/**
	 * Loads the QR code view.
	 */
	private void loadQRCodeView() {
		// We use a container to horizontally center the QR code.
		JPanel container = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.ABOVE_BASELINE;
		ImageView qrCodeView = new ImageView(qrCode);
		container.add(qrCodeView, constraints);
		this.add(container, BorderLayout.SOUTH);
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
