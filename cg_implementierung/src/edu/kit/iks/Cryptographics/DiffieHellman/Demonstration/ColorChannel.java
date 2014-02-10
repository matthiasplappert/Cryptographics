package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.kit.iks.Cryptographics.DiffieHellman.Model;
import edu.kit.iks.CryptographicsLib.Logger;

/*
 * This is the Communication Channel for
 * the Diffie Hellman Analogy.
 * In this JPanel we exchange colors and compute
 * a shared secret similar like in real DH 
 */

public class ColorChannel extends JPanel {

	private static final long serialVersionUID = 4073013433018353584L;

	/*
	 * remembers the colors of alice,bob,eve
	 */
	private Model model;
	
	private ColorMix cm1, cm2;
	
	private JPanel container;
	
	/* the coordinates of the circles */
	private int x1, y1, x2, y2;
	
	/* the x coordinates for the communications lines */
	private int leftEnd, rightEnd, middle;
	
	/* the y coordinates for the communications lines 
	 * middleCircle and rightCircle are basically
	 * the same like middle and rightEnd but corrected
	 * by the size of the circles */
	private int lowerEnd, upperEnd, middleCircle, rightCircle;
	
	/* 
	 * the original coordinate values, not sure
	 * if we need this
	 */
	private int originalx1, originaly1, originalx2, originaly2;
	
	/* kept colors are drawn to the screen*/
	private ArrayList<Ellipse2DwithColor> keptColors;
	
	/* those are used for sending over the channel */
	private Ellipse2DwithColor ellip, ellip2;
	
	/* the circles that are displayed next to alice, bob and eve,
	 * need to know how many each one has */
	private int[] numOfCircles;
	
	/* the color to send next */
	private Color colorNextToSend = Color.BLACK;
	
	/* the color of the channel, that means the lines */
	private Color channelColor = Color.BLACK;
	
	/* is this the firstCall of the sendMethod,
	 * first means the first timer event
	 */
	private boolean firstTimerEventAlice, firstTimerEventBob;

	/* repeat the sending of the color
	 * if true
	 */
	private boolean repeatPeriodically;



	/* diameter of the ellipses2d circles */
	private int circleSize = 50;
	
	/* while sending these values will be true */
	private boolean sendAlice, sendBob;
	
	/* when true, all received colors will still
	 * be drawn next to the receivers, so that we
	 * know which person  got which color */
	private boolean keepCircles;
	
	/*
	 */
	private Timer timer;

	/*
	 * Constructor takes the size of JPanel, and
	 * the size of the circles. From there
	 * it computes the position for the communication
	 * channel
	 */
	public ColorChannel(Dimension d, int circleSize) {
		container = new JPanel();
		container.setSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/4));
		container.setPreferredSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/4));
		//TODO add conditional flag to use color mixers or not
		this.cm1 = new ColorMix(circleSize, new Dimension((int)d.getWidth()/2, (int)d.getHeight()/4));
		this.cm2 = new ColorMix(circleSize, new Dimension((int)d.getWidth()/2, (int)d.getHeight()/4));
		this.setLayout(new BorderLayout());
		container.add(cm1);
		container.add(cm2);
		this.add(container, BorderLayout.SOUTH);
		this.model = new Model();
		this.setSize(d);
		this.setPreferredSize(d);
		this.circleSize = circleSize;
		this.leftEnd = (int) (0.25*this.getWidth());
		this.rightEnd = (int) (0.75*this.getWidth());
		this.lowerEnd = (int) (0.75*this.getHeight());
		this.upperEnd = (int) (0.25*this.getHeight());
		this.rightCircle = rightEnd-circleSize;
		this.originalx1 = leftEnd;
		this.originaly1 = lowerEnd-circleSize/2;
		this.middle = (leftEnd+rightEnd)/2;
		this.middleCircle = this.middle-circleSize/2;
		this.originalx2 = this.middle-circleSize/2;
		this.originaly2 = lowerEnd-circleSize/2;
		this.x1 = originalx1;
		this.y1 = originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
		this.firstTimerEventAlice = true;
		this.firstTimerEventBob = true;
		this.numOfCircles = new int[3];
		this.keptColors = new ArrayList<>();
		ellip = new Ellipse2DwithColor(x1, y1, circleSize, circleSize);
		ellip2 = new Ellipse2DwithColor(x2, y2, circleSize, circleSize);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO remove hardcoded colors and do it dynamically
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(channelColor);
		
		drawChannel(g2, this.leftEnd, this.rightEnd, this.lowerEnd, this.upperEnd);
		for(Ellipse2DwithColor circle : keptColors) {
			g2.setPaint(circle.getColor());
			g2.fill(circle);
		}
		if (sendAlice) {
			
			ellip.setFrame(x1, y1, circleSize, circleSize);
			g2.setPaint(ellip.getColor());
			g2.fill(ellip);
			if(x1 < this.middleCircle) {
				ellip2.setFrame(x2, y2, circleSize, circleSize);
				g2.setPaint(ellip2.getColor());
				g2.fill(ellip2);
			}
		} else if (sendBob) {
			ellip.setFrame(x1, y1, circleSize, circleSize);
			g2.setPaint(ellip.getColor());
			g2.fill(ellip);
			if(x1 > this.middleCircle) {
				ellip2.setFrame(x2, y2, circleSize, circleSize);
				g2.setPaint(ellip2.getColor());
				g2.fill(ellip2);
			}
			
		}
		
	}

	/* 
	 * draw the communication channels, that means the lines that
	 * represents those
	 */
	private void drawChannel(Graphics2D g2, int x1, int x2, int x3, int x4) {
		g2.drawLine(x1, x3, x2, x3);
		g2.drawLine((x1+x2)/2, x4, (x1+x2)/2, x3);
		g2.drawString("Alice", x1-50, x3);
		g2.drawString("Bob", x2+10, x3);
		g2.drawString("Eve", (x1+x2)/2 - 15, x4-10);
	}
	
	// TODO refactor sendToBob and sendToAlice into one method
	// TODO enhance so that eve gets the keept color immediately after it arrived,
	// instead of waiting for arrival of the message to bob/alice 
	public void sendToBob(final NextStepCallback cb, final boolean keepFirst) {
		if(sendAlice) {
			/* don't want to send colors
			 * if others are being send
			 */
			return;
		}
		this.sendBob = true;
		this.ellip.setColor(this.colorNextToSend);
		this.ellip2.setColor(this.colorNextToSend);
		//TODO remove hardcoded values
		this.x1 = this.leftEnd;
		this.x2 = this.middleCircle;
		this.y2 = this.originaly2;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO remove hardcoded values
				Logger.d(this.getClass().getName(),"sendToBob" , "timer event");
				if(firstTimerEventBob && !repeatPeriodically && keepFirst) {
					chooseColorToKeep(colorNextToSend, 0);
					firstTimerEventBob = false;
				}
				if(x1 < rightCircle) {
					x1 += 3;
					if (x1 > middleCircle && y2 > upperEnd) {
						y2 -= 3;
					}
				} else {
					sendBob = false;
					firstTimerEventBob = true;
					timer.stop();
					if(keepCircles && !repeatPeriodically) {
						for(int i=1; i < 3; i++) {
							chooseColorToKeep(colorNextToSend, i);
						}
					}
					if(cb != null) {
						cb.callback();
					} else if (repeatPeriodically) {
						Logger.d(this.getClass().getName(), "", "repeat now");
						// set to orignal values, to start all over
						sendBob = true;
						x1 = leftEnd;
						x2 = middleCircle;
						y2 = originaly2;
						timer.restart();
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	public void sendToAlice(final NextStepCallback cb, final boolean keepFirst) {
		if(sendBob) {
			/* don't want to send if there
			 * is already colors to be sent
			 */
			return;
		}
		this.sendAlice = true;
		this.ellip.setColor(this.colorNextToSend);
		this.ellip2.setColor(this.colorNextToSend);
		this.x1 = this.rightCircle;
		this.x2 = this.middleCircle;
		//TODO refactor
		this.y2 = this.originaly2;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Logger.d(this.getClass().getName(),"sendToAlice" , "timer event");
				if(firstTimerEventAlice && !repeatPeriodically && keepFirst) {
					chooseColorToKeep(colorNextToSend, 1);
					firstTimerEventAlice = false;
				}
				if(x1 > leftEnd) {
					x1 -= 3;
					if (x1 < middleCircle && y2 > upperEnd) {
						y2 -= 3;
					}
				} else {
					sendAlice = false;
					firstTimerEventAlice = true;
					timer.stop();
					if(keepCircles) {
						chooseColorToKeep(colorNextToSend, 0);
						chooseColorToKeep(colorNextToSend, 2);
					}
					if(cb != null) {
						cb.callback();
					} else if (repeatPeriodically) {
						Logger.d(this.getClass().getName(), "", "repeat now");
						// set to orignal values, to start all over
						sendAlice = true;
						x1 = rightCircle;
						x2 = middleCircle;
						y2 = originaly2;
						timer.restart();
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	/*
	 * compute the horizontal position of the next circle to add
	 * to alice/bob/eve
	 */
	private int computeXCoordinate(int numOfKeptColors, int who) {
		switch(who) {
		case 0:
			//alice
			return leftEnd-numOfKeptColors*circleSize;
		case 1:
			//bob
			return rightCircle+numOfKeptColors*circleSize;
		case 2:
			//eve
			return middleCircle+(numOfKeptColors+1)*circleSize;
		}
		//error
		return -1;
	}
	
	/*
	 * copmute the vertical position of the next circle to add
	 * to alice/bob/eve
	 */
	private int computeYCoordinate(int numOfKeptColors, int who) {
		switch(who) {
		case 0:
		case 1:
			//alice
			//bob
			return lowerEnd+circleSize/2;
		case 2:
			//eve
			return upperEnd-circleSize/2;
		}
		//error
		return -1;
	}
	
	/*
	 * add a circle to alice/bob/eve
	 */
	public void chooseColorToKeep(Color color, int who) {
		this.keptColors.add(new Ellipse2DwithColor(computeXCoordinate(numOfCircles[who], who), computeYCoordinate(numOfCircles[who], who), circleSize, circleSize, color));
		this.numOfCircles[who]++;
		repaint();
	}

	public Timer getTimer() {
		return this.timer;
	}
	
	/*
	 * we need to stop the timer, since garbage collector won't do that
	 * for us
	 */
	public void stopTimer() {
		if(timer != null) {
			timer.stop();
		}
	}

	/*
	 * basically does the same like in the constructor
	 * might remove this therefore
	 */
	public void loadView() {
		this.leftEnd = (int) (0.25*this.getWidth());
		this.rightEnd = (int) (0.75*this.getWidth());
		this.lowerEnd = (int) (0.75*this.getHeight());
		this.upperEnd = (int) (0.25*this.getHeight());
		this.rightCircle = rightEnd-circleSize;
		this.originalx1 = leftEnd;
		this.originaly1 = lowerEnd-circleSize/2;
		this.middle = (leftEnd+rightEnd)/2;
		this.middleCircle = this.middle-circleSize/2;
		this.originalx2 = this.middle-circleSize/2;
		this.originaly2 = lowerEnd-circleSize/2;
		this.x1 = originalx1;
		this.y1 = originaly1;
		this.x2 = originalx2;
		this.y2 = originaly2;
		ellip.setFrame(x1, y1, circleSize, circleSize);
		ellip2.setFrame(x2, y2, circleSize, circleSize);
	}
	

	
	public void choosePublicColor(Color color) {
		this.model.setPublicColor(color);
	}
	
	public void chooseAlicePrivateColor(Color color) {
		this.model.setAlicePrivateColor(color);
		this.chooseColorToKeep(color, 0);
	}
	
	public void chooseBobPrivateColor(Color color) {
		this.model.setBobPrivateColor(color);
		this.chooseColorToKeep(color, 1);
	}
	
	public void mixAlicePrivatePublic() {
		this.model.mixAlicePrivateAndPublic();
	}
	
	public void mixBobPrivatePublic() {
		this.model.mixBobPrivateAndPublic();
	}
	
	public void sendPublicColor(NextStepCallback cb) {
		this.setColorNextToSend(this.model.getPublicColor());
		this.sendToBob(cb, true);
	}
	
	public void sendAliceMixedColorToBob(NextStepCallback cb) {
		this.model.mixAlicePrivateAndPublic();
		this.setColorNextToSend(this.model.getAliceMixedColor());
		this.sendToBob(cb, true);
	}
	
	public void sendBobMixedColorToAlice(NextStepCallback cb) {
		this.model.mixBobPrivateAndPublic();
		this.setColorNextToSend(this.model.getBobMixedColor());
		this.sendToAlice(cb, true);
	}
	
	public void mixAliceFinalSecret(NextStepCallback cb) {
		assert(model.getBobMixedColor() != null);
		assert(model.getAlicePrivateColor() != null);
		this.cm1.setComputeFinalMix(true);
		this.cm1.setEllipColor(0, model.getBobMixedColor());
		this.cm1.setEllipColor(1, model.getAlicePrivateColor());
		this.cm1.mixColors(true, false, cb);
	}
	
	public void mixBobFinalSecret(NextStepCallback cb) {
		assert(model.getAliceMixedColor() != null);
		assert(model.getBobPrivateColor() != null);
		this.cm2.setComputeFinalMix(true);
		this.cm2.setEllipColor(0, model.getAliceMixedColor());
		this.cm2.setEllipColor(1, model.getBobPrivateColor());
		this.cm2.mixColors(true, false, cb);
	}
	
	public boolean isRepeat() {
		return repeatPeriodically;
	}

	public void setRepeat(boolean repeat) {
		this.repeatPeriodically = repeat;
	}
	
	public Color getColor() {
		return colorNextToSend;
	}

	/* let the user of this class
	 * choose the color to send
	 */
	public void setColorNextToSend(Color color) {
		this.colorNextToSend = color;
	}
	
	public boolean isKeepColor() {
		return keepCircles;
	}

	public void setKeepColor(boolean keepColor) {
		this.keepCircles = keepColor;
	}

	public Color getPublicColor() {
		return this.model.getPublicColor();
	}

	public Color getAlicePrivateColor() {
		return this.model.getAlicePrivateColor();
	}
	
	public Color getAliceMixedColor() {
		return this.model.getAliceMixedColor();
	}
	
	public Color getBobPrivateColor() {
		return this.model.getBobPrivateColor();
	}
	
}
