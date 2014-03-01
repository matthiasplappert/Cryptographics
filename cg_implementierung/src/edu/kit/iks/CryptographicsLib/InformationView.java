package edu.kit.iks.CryptographicsLib;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * View of the information page
 * 
 * @author Matthias Plappert
 */
public class InformationView extends JPanel implements MouseListener {
	
	/**
	 * Possible scroll directions.
	 */
	private enum ScrollDirection {
	    NONE, UP, DOWN 
	};
	
	/**
	 * The delay between scroll events when a scroll button is pressed.
	 */
	private static final int scrollDelay = 50; 
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8593552609491347799L;

	/**
	 * QR code for further information
	 */
	private Image qrCode;
	
	/**
	 * The HTML used to display the additional information in a web view.
	 */
	private String html;
	
	/**
	 * The content of the QR code.
	 */
	private String qrCodeContent;
	
	/**
	 * The QR code view.
	 */
	private ImageView qrCodeView;
	
	/**
	 * Displays the contents of the QR code. 
	 */
	private JLabel qrCodeLabel;
	
	/**
	 * The scrollable container of the web view.
	 */
	private JScrollPane webViewContainer;
	
	/**
	 * The web view.
	 */
	private JEditorPane webView;
	
	/**
	 * Scrolls the web view up.
	 */
	private JButton scrollUpButton;
	
	/**
	 * Scrolls the web view down.
	 */
	private JButton scrollDownButton;
	
	/**
	 * The current scroll direction.
	 */
	private ScrollDirection scrollDirection = ScrollDirection.NONE;
	
	/**
	 * This timer is used to periodically scroll up or down depending on the
	 * current value of scroll direction. This is used when pressing the up or
	 * down button.
	 */
	private Timer scrollTimer;
	
	/**
	 * Constructor initializing a new instance of {InformationView}
	 * with given {HTML} and {qrCode}
	 * 
	 * @param html The HTML used to display the additional informations
	 * @param qrCode QR code for further information
	 * @param url The content of the QR code
	 */
	public InformationView(String html, Image qrCode, String qrCodeContent) {
		this.qrCode = qrCode;
		this.html = html;
		this.qrCodeContent = qrCodeContent;
		
		// Initialize view.
		this.setLayout(new BorderLayout());
		this.loadWebViewComponents();
		this.loadScrollButtons();
		this.loadQRCodeViewComponents();
		this.validate();
	}
	
	/**
	 * Loads the web view and related components.
	 */
	private void loadWebViewComponents() {
		JPanel layoutContainer = new JPanel(new BorderLayout());
		
		this.loadWebView();
        layoutContainer.add(this.webViewContainer, BorderLayout.CENTER);
        
        this.loadScrollButtons();
        JPanel buttonLayoutContainer = new JPanel(new BorderLayout());
        buttonLayoutContainer.add(this.scrollUpButton, BorderLayout.NORTH);
        buttonLayoutContainer.add(this.scrollDownButton, BorderLayout.SOUTH);
        layoutContainer.add(buttonLayoutContainer, BorderLayout.EAST);
        
        // Valdiate and add.
        layoutContainer.validate();
        this.add(layoutContainer, BorderLayout.CENTER);
    }
	
	private void loadWebView() {
		// Editor pane used as a web view.
		this.webView = new JEditorPane();
		this.webView.setEditable(false);
		this.webView.setContentType("text/html");
		try {
			this.webView.setText(this.getHtml());
		} catch(Exception e) {
			Logger.e(e);
		}
		this.webView.setCaretPosition(0); // scrolls to the top
		
		// Scroll pane that contains the editor pane.
		this.webViewContainer = new JScrollPane(this.webView);
		this.webViewContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.webViewContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		this.webViewContainer.validate();
	}
	
	/**
	 * Loads the scroll up and scroll down buttons for scrolling the web view.
	 * This is necessary because the scroll bar is very clumsy to control on
	 * a touch screen device.
	 */
	private void loadScrollButtons() {
		// Scroll up button.
		this.scrollUpButton = new JButton(" ↑ ");
		this.scrollUpButton.setName("up");
		this.scrollUpButton.addMouseListener(this);
		
		// Scroll down button.
		this.scrollDownButton = new JButton(" ↓ ");
		this.scrollDownButton.setName("down");
		this.scrollDownButton.addMouseListener(this);
	}
	
	/**
	 * Loads the QR code view and related components.
	 */
	private void loadQRCodeViewComponents() {
		// We use a container to horizontally center the QR code.
		JPanel container = new JPanel(new GridBagLayout());
		
		GridBagConstraints imageConstraints = new GridBagConstraints();
		imageConstraints.anchor = GridBagConstraints.ABOVE_BASELINE;
		this.qrCodeView = new ImageView(this.qrCode);
		container.add(this.qrCodeView, imageConstraints);
		
		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.anchor = GridBagConstraints.ABOVE_BASELINE;
		this.qrCodeLabel = new JLabel(this.qrCodeContent);
		container.add(this.qrCodeLabel, labelConstraints);
		
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
	
	/**
	 * The QR code content.
	 * 
	 * @return QR code content
	 */
	public String getQrCodeContent() {
		return this.qrCodeContent;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.scrollDirection = this.getScrollDirectionFromMouseEvent(e);
		this.scroll(this.scrollDirection);
		if (this.scrollTimer != null) {
			this.stopScrollTimer();
		}
		this.startScrollTimer();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.scrollTimer != null) {
			this.stopScrollTimer();
		}
		this.scrollDirection = ScrollDirection.NONE;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Unused
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Unused
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Unused
	}
	
	/**
	 * Converts the given mouse event into the correct scroll direction.
	 * 
	 * @param e The MouseEvent that causes the scroll.
	 * @return The scroll direction for that event or {ScrollDirection.NONE} if
	 * the event cannot be properly mapped.
	 */
	private ScrollDirection getScrollDirectionFromMouseEvent(MouseEvent e) {
		// For some weird reason, we can't directly compare the source to
		// scrollUpButton or scrollDownButton. We therefore us the name as a
		// workaround.
		Component source = (Component)e.getSource();
		String name = source.getName();
		
		if (name == null) {
			return ScrollDirection.NONE;
		} else if (this.scrollUpButton.getName().equals(name)) {
			return ScrollDirection.UP;
		} else if (this.scrollDownButton.getName().equals(name)) {
			return ScrollDirection.DOWN;
		} else {
			return ScrollDirection.NONE;
		}
	}
	
	/**
	 * Starts the scroll timer. We use this timer to scroll multiple times
	 */
	private void startScrollTimer() {
		this.scrollTimer = new Timer(InformationView.scrollDelay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scroll(scrollDirection);
			}
		});
		this.scrollTimer.start();
	}
	
	/**
	 * Stops the scroll timer.
	 */
	private void stopScrollTimer() {
		this.scrollTimer.stop();
		this.scrollTimer = null;
	}
	
	/**
	 * Scrolls the web view in the given direction.
	 * @param direction the scroll direction
	 */
	private void scroll(ScrollDirection direction) {
		JScrollBar vertical = this.webViewContainer.getVerticalScrollBar();
		switch (direction) {
			case UP:
				vertical.setValue(vertical.getValue() - vertical.getBlockIncrement());
				break;
				
			case DOWN:
				vertical.setValue(vertical.getValue() + vertical.getBlockIncrement());
				break;
				
			default:
				// Do nothing.
				break;
		}
	}
}
