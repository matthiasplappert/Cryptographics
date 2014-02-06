package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;

import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * This view/JPanel allows us to mix two Colors
 */

public class ColorMix extends JPanel {

	private static final long serialVersionUID = 4056277049609956169L;
	
	/* our two circles to mix */
	private Ellipse2DwithColor ellip1, ellip2;
	
	/* the mix of colors of ellip1 and ellip2 */
	private Color mixedColor;

	/* coordinates of the circles */
	private int x1, y1, x2, y2;
	
	/* diameter of the circles */
	private int diameter;

	/* true if we should mix the colors */
	private boolean mixcolors;

	/*
	 * It maybe that one timer is actually is enough
	 * originally used this as a fix for the timer bug
	 * though it wasn't the bug, so this is probably useless
	 * but need to test
	 */
	private Timer timer;
	
	/* the middle part where the two circles will meet */
	private int middle;

	/* the original coordinates, so that we can reset them later */
	private int originalx1, originaly1, originalx2, originaly2;
	
	public ColorMix(Color color1, Color color2, int circleSize, Dimension dimension) {
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.diameter = circleSize;
		this.originalx1 = circleSize;
		this.originaly1 = dimension.height-circleSize;
		this.originalx2 = dimension.width-circleSize;
		this.originaly2 = dimension.height-circleSize;
		this.x1 = originalx1;
		this.y1= originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
		this.middle = (x1+x2)/2;
		this.ellip1 = new Ellipse2DwithColor(x1, y1, circleSize, circleSize, color1);
		this.ellip2 = new Ellipse2DwithColor(x2, y2, circleSize, circleSize, color2);
	}
	
	public void mixColors(boolean mix, boolean repeat, final NextStepCallback cb) {
		this.mixcolors = mix;
		this.x1 = originalx1;
		this.y1 = originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
		if(mixcolors) {
			if(repeat) {
				this.timer = new Timer(50, new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(x1 < middle) {
							x1 += 3;
						} else {
							x1 = originalx1;
						}
						if(x2 > middle) {
							x2 -= 3;
						} else {
							x2 = originalx2;
						}
						repaint();
					}
				});
				timer.start();
			} else {
				this.timer = new Timer(50, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("timer in colormix ");
						if(x1 < middle) {
							x1 += 3;
						}
						if(x2 > middle) {
							x2 -= 3;
						}
						if(x2 <= middle && x1 >= middle) {
							timer.stop();
							if (cb != null) {
								System.out.println("called callback in colormix");
								cb.callback();	
							}
						}
						repaint();
					}
				});
				timer.start();
			}
		} else {
			timer.stop();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(mixcolors) {
			ellip1.setFrame(x1, y1, diameter, diameter);
			g2.setPaint(ellip1.getColor());
			g2.fill(ellip1);
			
			ellip2.setFrame(x2, y2, diameter, diameter);
			g2.setPaint(ellip2.getColor());
			g2.fill(ellip2);
			
			Area area1 = new Area(ellip1);
			Area area2 = new Area(ellip2);
			area1.intersect(area2);
			computeMixedColor(ellip1.getColor(), ellip2.getColor());
			g2.setPaint(mixedColor);
			g2.fill(area1);
		}
	}

	private void computeMixedColor(Color color, Color color2) {
		int r1 = color.getRed();
		int r2 = color2.getRed();
		int g1 = color.getGreen();
		int g2 = color2.getGreen();
		int b1 = color.getBlue();
		int b2 = color2.getBlue();
		this.mixedColor= new Color((r1+r2)/2, (g1+g2)/2, (b1+b2)/2);
	}

	public void setEllipColor(int which, Color color) {
		if(which == 1) {
			ellip1.setColor(color);
		} else if (which == 2) {
			ellip2.setColor(color);
		}
	}
	
	public Color getMixedColor() {
		return mixedColor;
	}
}