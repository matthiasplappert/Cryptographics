package edu.kit.iks.CryptographicsLib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * An instance of this class represents the view of a popover
 * 
 * @author Christian Dreher
 */
public class PopoverView extends JPanel {
	/**
	 * Defines the possible locations of a popover arrow. 
	 */
	private enum ArrowLocation {
	    TOP, RIGHT, BOTTOM, LEFT 
	};
	
	/**
	 * The arrow location of the popover.
	 */
	private ArrowLocation arrowLocation;
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5949014143695648861L;

	/**
	 * Button to close the popover
	 */
	private JButton closeButton;
	
	/**
	 * Content area of the popover
	 */
	private JPanel contentView;
	
	/**
	 * The shared container view
	 */
	static private JPanel containerView;
	
	/**
	 * Constructor initializing a new instance of {PopoverView}
	 */
	public PopoverView() {
		super(new GridBagLayout());
		
		// Create close button.
		GridBagConstraints closeConstraints = new GridBagConstraints();
		closeConstraints.gridx = 0;
		closeConstraints.gridy = 0;
		closeConstraints.insets = new Insets(20, 0, 0, 0);
		this.closeButton = new JButton("Close");
		this.add(this.closeButton, closeConstraints);
		
		// Create content view.
		GridBagConstraints contentConstraints = new GridBagConstraints();
		contentConstraints.gridx = 0;
		contentConstraints.gridy = 1;
		contentConstraints.gridwidth = 3;
		contentConstraints.insets = new Insets(0, 0, 20, 0);
		this.contentView = new JPanel();
		this.contentView.setOpaque(false);
		this.add(this.contentView, contentConstraints);
		
		this.validate();
	}
	
	/**
	 * Returns the CloseButton.
	 * 
	 * @return the closeButton button to return.
	 */
	public JButton getCloseButton() {
		return this.closeButton;
	}
	
	/**
	 * The content view contains the popover's content. This makes it easier to
	 * layout the popover and the content properly.
	 * 
	 * @return the content view.
	 */
	public JPanel getContentView() {
		return this.contentView;
	}
	
	/**
	 * Configures all popovers to use a given container view. The container view
	 * should be visible above all other components and should have maximum height
	 * and width. You cannot use popover views before configuring them without a container!
	 * 
	 * @param containerView the container view
	 */
	public static void setContainerView(JPanel containerView) {
		PopoverView.containerView = containerView;
		
		// Configure container.
		containerView.setVisible(true);
	}
	
	/**
	 * Presents a popover in the container
	 * 
	 * @param originComponent the origin of the popover is where the arrow of the popover should point to
	 */
	public void present(JComponent originComponent) {
		this.validate();
		
		Point origin = originComponent.getLocationOnScreen();
		
		// Update view.
		this.setLocation(this.getLocationFromOrigin(origin));
		this.arrowLocation = this.getArrowLocationFromOrigin(origin);
		this.repaint();
		
		// Position in container view.
		PopoverView.containerView.add(this);
		PopoverView.containerView.validate();
	}
	
	/**
	 * Removes a popover from the container
	 */
	public void dismiss() {
		PopoverView.containerView.remove(this);
		PopoverView.containerView.revalidate();
		PopoverView.containerView.repaint();
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        final Area shape = this.createShape();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.BLUE);
        g2d.fill(shape);
    }

	private Area createShape() {
		final double arrowHeight  = 20.0;
		final double arrowWidth   = 40.0;
		final double cornerRadius = 20.0;
		
		// Create the basic rounded shape.
		Area shape = new Area(new RoundRectangle2D.Double(0.0, arrowHeight, this.getSize().getWidth(), this.getSize().getHeight() - arrowHeight, cornerRadius, cornerRadius));
		
		// Draw the arrow.
	    GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
	    path.moveTo(this.getSize().getWidth() / 2 - arrowWidth / 2, arrowHeight);
	    path.lineTo(this.getSize().getWidth() / 2, 0);
	    path.lineTo(this.getSize().getWidth() / 2 + arrowWidth / 2, arrowHeight);
	    path.closePath();
	    shape.add(new Area (path));

	    return shape;
	}
	
	/**
	 * Translates the requested origin into the actual location of the popover 
	 * @param origin the preferred origin of the popover 
	 * @return the suggested location of the popover view
	 */
	private Point getLocationFromOrigin(Point origin) {
		return origin;
	}
	
	/**
	 * Calculates the optimal arrow location for the given origin.
	 * 
	 * @param origin the preferred origin of the popover
	 * @return the suggested arrow location of the popover view
	 */
	private ArrowLocation getArrowLocationFromOrigin(Point origin) {
		return ArrowLocation.TOP;
	}
}
