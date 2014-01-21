package edu.kit.iks.CryptographicsLib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	 * The width of the arrow.
	 */
	final private static int ARROW_WIDTH = 40;
	
	/**
	 * The height of the arrow.
	 */
	final private static int ARROW_HEIGHT = 20;
	
	/**
	 * The inner inset of the popover.
	 */
	final private static int INSET = 20;
	
	/**
	 * The corner radius of the popover.
	 */
	final private static int CORNER_RADIUS = 20;
	
	/**
	 * The arrow location of the popover.
	 */
	private ArrowLocation arrowLocation = ArrowLocation.TOP;
	
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
	
	private Point anchorPoint;
	
	/**
	 * The shared container view
	 */
	static private JPanel containerView;
	
	/**
	 * Constructor initializing a new instance of {PopoverView}
	 */
	public PopoverView() {
		super(new GridBagLayout());
		
		this.setOpaque(false);
		this.setMaximumSize(new Dimension(500, 500));
		
		// Create close button.
		GridBagConstraints closeConstraints = new GridBagConstraints();
		closeConstraints.gridx = 0;
		closeConstraints.gridy = 0;
		this.closeButton = new JButton("Close");
		this.add(this.closeButton, closeConstraints);
		
		// Create content view.
		GridBagConstraints contentConstraints = new GridBagConstraints();
		contentConstraints.gridx = 0;
		contentConstraints.gridy = 1;
		contentConstraints.gridwidth = 3;
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
		containerView.setLayout(null);
		containerView.setVisible(true);
	}
	
	/**
	 * Presents a popover in the container
	 * 
	 * @param originComponent the origin of the popover is where the arrow of the popover should point to
	 */
	public void present(JComponent anchorComponent) {
		this.validate();
		
		// Calculate the anchorPoint. The origin is in the center of the component.
		double x = anchorComponent.getLocation().getX();
		x += anchorComponent.getSize().getWidth() / 2;
		double y = anchorComponent.getLocation().getY();
		y += anchorComponent.getSize().getHeight() / 2;
		this.anchorPoint = new Point((int)x, (int)y);
		
		// Position in container view.
		PopoverView.containerView.add(this);
		PopoverView.containerView.validate();
		
		this.prepareForPresentation();
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
		// Create the basic rounded shape.
		Area shape = null;
		switch (this.arrowLocation) {
			case TOP:
				shape = new Area(new RoundRectangle2D.Double(0.0, ARROW_HEIGHT, this.getSize().getWidth(), this.getSize().getHeight() - ARROW_HEIGHT, CORNER_RADIUS, CORNER_RADIUS));
				break;
				
			case RIGHT:
				shape = new Area(new RoundRectangle2D.Double(0.0, 0.0, this.getSize().getWidth() - ARROW_HEIGHT, this.getSize().getHeight(), CORNER_RADIUS, CORNER_RADIUS));
				break;
				
			case BOTTOM:
				shape = new Area(new RoundRectangle2D.Double(0.0, 0.0, this.getSize().getWidth(), this.getSize().getHeight() - ARROW_HEIGHT, CORNER_RADIUS, CORNER_RADIUS));
				break;
				
			case LEFT:
				shape = new Area(new RoundRectangle2D.Double(ARROW_HEIGHT, 0.0, this.getSize().getWidth() - ARROW_HEIGHT, this.getSize().getHeight(), CORNER_RADIUS, CORNER_RADIUS));
				break;
		}
		
		// Create the arrow path.
	    GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
	    switch (this.arrowLocation) {
			case TOP:
				path.moveTo(this.getSize().getWidth() / 2 - ARROW_WIDTH / 2, ARROW_HEIGHT);
				path.lineTo(this.getSize().getWidth() / 2, 0);
			    path.lineTo(this.getSize().getWidth() / 2 + ARROW_WIDTH / 2, ARROW_HEIGHT);
			    break;
				
			case RIGHT:
				path.moveTo(this.getSize().getWidth() - ARROW_HEIGHT, this.getSize().getHeight() / 2 - ARROW_WIDTH / 2);
				path.lineTo(this.getSize().getWidth(), this.getSize().getHeight() / 2);
			    path.lineTo(this.getSize().getWidth() - ARROW_HEIGHT, this.getSize().getHeight() / 2 + ARROW_WIDTH / 2);
			    break;
				
			case BOTTOM:
				path.moveTo(this.getSize().getWidth() / 2 - ARROW_WIDTH / 2, this.getSize().getHeight() - ARROW_HEIGHT);
				path.lineTo(this.getSize().getWidth() / 2, this.getSize().getHeight());
			    path.lineTo(this.getSize().getWidth() / 2 + ARROW_WIDTH / 2, this.getSize().getHeight() - ARROW_HEIGHT);
			    break;
				
			case LEFT:
				path.moveTo(ARROW_HEIGHT, this.getSize().getHeight() / 2 - ARROW_WIDTH / 2);
				path.lineTo(0, this.getSize().getHeight() / 2);
			    path.lineTo(ARROW_HEIGHT, this.getSize().getHeight() / 2 + ARROW_WIDTH / 2);
			    break;
	    }
	    path.closePath();
	    shape.add(new Area(path));

	    return shape;
	}
	
	/**
	 * Prepares a popover for presentation by calculation its bounds and the proper
	 * arrow location. 
	 */
	private void prepareForPresentation() {
		Dimension containerSize = PopoverView.containerView.getSize();
		Point center = new Point((int)(containerSize.getWidth() / 2), (int)(containerSize.getHeight() / 2));
		double offsetY = center.getY() - this.anchorPoint.getY();
		
		// Figure out arrow location. LEFT and RIGHT is currently not supported.
		if (offsetY < 0.0) {
			this.arrowLocation = ArrowLocation.BOTTOM;
		} else {
			this.arrowLocation = ArrowLocation.TOP;
		}
		
		this.updateBorder();
		this.updateBounds();
		this.repaint();
	}
	
	private void updateBorder() {
		Border border;
		switch (this.arrowLocation) {
			case TOP: border = BorderFactory.createEmptyBorder(INSET + ARROW_HEIGHT, INSET, INSET, INSET); break;
			case BOTTOM: border = BorderFactory.createEmptyBorder(INSET, INSET, INSET + ARROW_HEIGHT, INSET); break;
			case LEFT: border = BorderFactory.createEmptyBorder(INSET, INSET + ARROW_HEIGHT, INSET, INSET); break;
			case RIGHT: border = BorderFactory.createEmptyBorder(INSET, INSET, INSET, INSET + ARROW_HEIGHT); break;
			default: border = BorderFactory.createEmptyBorder(0, 0, 0, 0); break;
		}
		
		this.setBorder(border);
	}
	
	private void updateBounds() {
		Dimension size = this.getPreferredSize();
		Point location;
		switch (this.arrowLocation) {
			case TOP:
				location = new Point((int)(this.anchorPoint.getX() - size.getWidth() / 2), (int)this.anchorPoint.getY());
				break;
				
			case BOTTOM:
				location = new Point((int)(this.anchorPoint.getX() - size.getWidth() / 2), (int)(this.anchorPoint.getY() - size.getHeight()));
				break;
				
			case LEFT:
			case RIGHT:
			default:
				location = new Point(0, 0);
				break;
		}
		
		this.setSize(size);
		this.setLocation(location);
	}
}
