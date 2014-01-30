package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorChannel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4073013433018353584L;
	
	/* the coordinates of the circles */
	private int x1, y1, x2, y2;
	/* the x coordinates for the communications lines */
	private int leftEnd, rightEnd, middle;
	private int yPosition, height, middleCircle, rightCircle;
	private final int originalx1, originaly1, originalx2, originaly2;
	/* kept colors */
	private Ellipse2DwithColor[][] keptColors;
	private Ellipse2DwithColor ellip, ellip2;
	private int numOfKeptColors;
	
	/* the color to send */
	private Color color = Color.BLACK;
	private Color channelColor = Color.BLACK;

	/* repeat the sending of the color
	 * if true
	 */
	private boolean repeat;
	
	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

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
	
	public boolean isKeepColor() {
		return keepColor;
	}

	public void setKeepColor(boolean keepColor) {
		this.keepColor = keepColor;
	}

	/* use timer for firing events so that values will be
	 * changed when sending colors
	 */
	private Timer timer;
	
	public ColorChannel(int leftEnd, int rightEnd, int yPosition, int height) {
		this.keptColors = new Ellipse2DwithColor[3][3];
		this.numOfKeptColors = 0;
		this.yPosition = yPosition;
		this.height = height;
		this.leftEnd = leftEnd;
		this.rightEnd = rightEnd;
		this.rightCircle = rightEnd-diameter;
		this.originalx1 = leftEnd;
		this.originaly1 = yPosition-diameter/2;
		this.middle = (leftEnd+rightEnd)/2;
		this.middleCircle = this.middle-diameter/2;
		this.originalx2 = this.middle-diameter/2;
		this.originaly2 = yPosition-diameter/2;
		this.x1 = originalx1;
		this.y1 = originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
		ellip = new Ellipse2DwithColor(x1, y1, diameter, diameter);
		ellip2 = new Ellipse2DwithColor(x1, y1, diameter, diameter);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO remove hardcoded colors and do it dynamically
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(channelColor);
		
		//450, 800, 180, 60
		drawChannel(g2, this.leftEnd, this.rightEnd, this.yPosition, this.height);
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				if(keptColors[i][j] == null) {
					break;
				}
				g2.setPaint(keptColors[i][j].getColor());
				g2.fill(keptColors[i][j]);
			}
		}
		if (sendAlice) {
			
			ellip.setFrame(x1, y1, diameter, diameter);
			g2.setPaint(ellip.getColor());
			g2.fill(ellip);
			if(x1 < this.middleCircle) {
				ellip2.setFrame(x2, y2, diameter, diameter);
				g2.setPaint(ellip2.getColor());
				g2.fill(ellip2);
			}
		} else if (sendBob) {
			ellip.setFrame(x1, y1, diameter, diameter);
			g2.setPaint(ellip.getColor());
			g2.fill(ellip);
			if(x1 > this.middleCircle) {
				ellip2.setFrame(x2, y2, diameter, diameter);
				g2.setPaint(ellip2.getColor());
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
		this.ellip.setColor(this.color);
		this.ellip2.setColor(this.color);
		//TODO remove hardcoded values
		this.x1 = this.leftEnd;
		this.x2 = this.middleCircle;
		this.y2 = this.originaly2;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO remove hardcoded values
				if(x1 < rightCircle) {
					x1 += 3;
					if (x1 > middleCircle && y2 > height) {
						y2 -= 3;
					} else if (y2 < height && x1 > rightCircle) {
						sendBob = false;
						timer.stop();
						if(keepColor && !repeat) {
							numOfKeptColors++;
							for(int i=0; i < 3; i++) {
								keptColors[numOfKeptColors][i] = new Ellipse2DwithColor(computeXCoordinate(numOfKeptColors, i), computeYCoordinate(numOfKeptColors, i), diameter, diameter, color);
							}
						}
						if(cb != null) {
							cb.callback();
						} else if (repeat) {
							// set to orignal values, to start all over
							sendBob = true;
							x1 = leftEnd;
							x2 = middleCircle;
							y2 = originaly2;
							timer.start();
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
		this.ellip.setColor(this.color);
		this.ellip2.setColor(this.color);
		this.x1 = this.rightCircle;
		this.x2 = this.middleCircle;
		//TODO refactor
		this.y2 = this.originaly2;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(x1 > leftEnd) {
					x1 -= 3;
					if (x1 < middleCircle && y2 > height) {
						y2 -= 3;
					} else if (y2 < height && x1 < leftEnd) {
						sendAlice = false;
						timer.stop();
						if(keepColor) {
							numOfKeptColors++;
							for(int i=0; i < 3; i++) {
								keptColors[numOfKeptColors][i] = new Ellipse2DwithColor(computeXCoordinate(numOfKeptColors, i), computeYCoordinate(numOfKeptColors, i), diameter, diameter, color);
							}
						}
						if(cb != null) {
							cb.callback();
						} else if (repeat) {
							// set to orignal values, to start all over
							sendAlice = true;
							x1 = rightCircle;
							x2 = middleCircle;
							y2 = originaly2;
							timer.start();
						}
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	private int computeXCoordinate(int numOfKeptColors, int i) {
		switch(i) {
		case 0:
			//alice
			return leftEnd-numOfKeptColors*diameter;
		case 1:
			//bob
			return rightCircle+numOfKeptColors*diameter;
		case 2:
			//eve
			return middleCircle+numOfKeptColors*diameter;
		}
		//error
		return -1;
	}
	
	private int computeYCoordinate(int numOfKeptColors, int i) {
		switch(i) {
		case 0:
		case 1:
			//alice
			//bob
			return yPosition+diameter/2;
		case 2:
			//eve
			return height-diameter/2;
		}
		//error
		return -1;
	}
	
	public void choosePrivateColor() {
		
	}

}
