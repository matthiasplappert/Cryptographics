package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorMix extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4056277049609956169L;
	
	/* our two circles */
	private Ellipse2DwithColor ellip1, ellip2;
	
	/* the mix of colors of ellip1 and ellip2 */
	private Color mixedColor;
	
	/* coordinates of the circles */
	private int x1, y1, x2, y2;
	
	/* diameter of the circles */
	private int diameter;

	/* true if we should mix the colors */
	private boolean mixcolors;

	private boolean repeat;
	
	private Timer timer;

	private int middle;
	
	public ColorMix(Color color1, Color color2, int diameter) {
		this.diameter = diameter;
		this.x1 = 50;
		this.y1 = 50;
		this.x2 = 300;
		this.y2 = 50;
		this.middle = (x1+x2)/2;
		this.ellip1 = new Ellipse2DwithColor(x1, y1, diameter, diameter, color1);
		this.ellip2 = new Ellipse2DwithColor(x2, y2, diameter, diameter, color2);
	}
	
	public void mixColors(boolean mix, boolean repeat) {
		this.mixcolors = mix;
		this.repeat = repeat;
		if(mixcolors) {
			if(repeat) {
				this.timer = new Timer(50, new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(x1 < middle) {
							x1 += 3;
						} else {
							x1 = 50;
						}
						if(x2 > middle) {
							x2 -= 3;
						} else {
							x2 = 300;
						}
						repaint();
					}
				});
				timer.start();
			} else {
				this.timer = new Timer(50, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
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
		
		ellip1.setFrame(x1, y1, diameter, diameter);
		g2.setPaint(ellip1.getColor());
		g2.fill(ellip1);
		
		ellip2.setFrame(x2, y2, diameter, diameter);
		g2.setPaint(ellip2.getColor());
		g2.fill(ellip2);
		
		Area area1 = new Area(ellip1);
		Area area2 = new Area(ellip2);
		area1.intersect(area2);
		mixColors(ellip1.getColor(), ellip2.getColor());
		g2.setPaint(mixedColor);
		g2.fill(area1);
	}

	private void mixColors(Color color, Color color2) {
		int r1 = color.getRed();
		int r2 = color2.getRed();
		int g1 = color.getGreen();
		int g2 = color2.getGreen();
		int b1 = color.getBlue();
		int b2 = color2.getBlue();
		this.mixedColor= new Color((r1+r2)/2, (g1+g2)/2, (b1+b2)/2);
	}

}