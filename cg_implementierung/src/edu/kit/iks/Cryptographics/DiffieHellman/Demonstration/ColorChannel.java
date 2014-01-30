package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorChannel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4073013433018353584L;
	
	/* the coordinates of the circles
	 * 460, 155, 600, 155
	 */
	private int x1, y1, x2, y2;
	private int leftEnd, rightEnd, middle;
	private int yPosition, height;
	private final int originalx1, originaly1, originalx2, originaly2;
	
	/* the color to send */
	private Color color = Color.BLUE;
	
	public Color getColor() {
		return color;
	}

	/* let the user of this class
	 * choose the color to send
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/* diameter of the ellipses2d circles */
	private int diameter = 50;
	
	/* while sending these values will be true */
	private boolean sendAlice, sendBob;
	
	/* when true, all received colors will still
	 * be drawn next to the receivers, so that we
	 * know which person  got which color */
	private boolean keepColor;
	
	/* use timer for firing events so that values will be
	 * changed when sending colors
	 */
	private Timer timer;
	
	public ColorChannel(int leftEnd, int rightEnd, int yPosition, int height) {
		this.yPosition = yPosition;
		this.height = height;
		this.leftEnd = leftEnd;
		this.rightEnd = rightEnd;
		this.originalx1 = leftEnd;
		this.originaly1 = yPosition;
		this.middle = (leftEnd+rightEnd)/2;
		this.originalx2 = this.middle;
		this.originaly2 = yPosition;
		this.x1 = originalx1;
		this.y1 = originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO remove hardcoded colors and do it dynamically
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(color);
		
		//450, 800, 180, 60
		drawChannel(g2, this.leftEnd, this.rightEnd, this.yPosition, this.height);
		if (sendAlice) {
			Ellipse2D.Double ellip = new Ellipse2D.Double(x1, y1, diameter, diameter);
			g2.fill(ellip);
			if(x1 < this.middle) {
				Ellipse2D.Double ellip2 = new Ellipse2D.Double(x2, y2, diameter, diameter);
				g2.fill(ellip2);
			}
		} else if (sendBob) {
			Ellipse2D.Double ellip = new Ellipse2D.Double(x1, y1, diameter, diameter);
			g2.fill(ellip);
			if(x1 > this.middle) {
				Ellipse2D.Double ellip2 = new Ellipse2D.Double(x2, y2, diameter, diameter);
				g2.fill(ellip2);
			}
			
		}
		
	}

	private void drawChannel(Graphics2D g2, int x1, int x2, int x3, int x4) {
		g2.drawLine(x1, x3, x2, x3);
		g2.drawLine((x1+x2)/2, x4, (x1+x2)/2, x3);
		g2.drawString("Alice", x1-50, x3);
		g2.drawString("Bob", x2+10, x3);
		g2.drawString("Eve", (x1+x2)/2 - 15, x4-10);
	}
	
	// TODO refactor sendToBob and sendToAlice into one method
	public void sendToBob(final NextStepCallback cb) {
		if(sendAlice) {
			/* don't want to send colors
			 * if others are being send
			 */
			return;
		}
		this.sendBob = true;
		//TODO remove hardcoded values
		this.x1 = this.originalx1;
		this.x2 = this.originalx2;
		this.y2 = this.originaly2;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO remove hardcoded values
				if(x1 < rightEnd) {
					x1 += 3;
					if (x1 > middle && y2 > height) {
						y2 -= 3;
					} else if (y2 < height && x1 > rightEnd) {
						sendBob = false;
						timer.stop();
						if(cb != null) {
							cb.callback();
						}
						if(keepColor) {
							
						}
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	public void sendToAlice(final NextStepCallback cb) {
		if(sendBob) {
			/* don't want to send if there
			 * is already colors to be sent
			 */
			return;
		}
		this.sendAlice = true;
		this.x1 = this.rightEnd;
		this.x2 = this.middle;
		this.y2 = this.yPosition;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(x1 > leftEnd) {
					x1 -= 3;
					if (x1 < middle && y2 > height) {
						y2 -= 3;
					} else if (y2 < height && x1 < leftEnd) {
						sendAlice = false;
						timer.stop();
						if(cb != null) {
							cb.callback();
						}
						if(keepColor) {
							
						}
					}
				}
				repaint();
			}
		});
		timer.start();
	}

}
