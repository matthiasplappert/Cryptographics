package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;
import javax.swing.Timer;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class ExplainKeyExchangeView extends VisualizationView {
	private JLabel keyExchangeExplain;
	
	private int x1, y1;
	private int x2, y2;
	private int x3, y3;
	private int x4, y4;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7529617215150828381L;
	
	public ExplainKeyExchangeView() {
		super();
		this.x1 = 20;
		this.y1 = 50;
		this.x2 = 200;
		this.y2 = 50;
		this.x3 = 400;
		this.y3 = 50;
		this.x4 = 580;
		this.y4 = 50;
		this.setLayout(new GridBagLayout());
		this.keyExchangeExplain = new JLabel();
		this.keyExchangeExplain.setText("<html><div style=\"width:200px;\">We use a simple analogy as the one-way function." +
				"Mixing colors is an easy process, determining which colors were" +
				"originally used is a difficult process, thus this acts like an one-way function</div></html>");
		this.add(keyExchangeExplain);
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(x1 < 110) {
					x1 += 3;
				} else {
					x1 = 20;
				}
				if(x2 > 110) {
					x2 -= 3;
				} else {
					x2 = 200;
				}
				if(x3 > 400) {
					x3 -= 3;
				} else {
					x3 = 490;
				}
				if(x4 < 580) {
					x4 += 3;
				} else {
					x4 = 490;
				}
				repaint();
			}});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO remove hardcoded colors and do it dynamically
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Ellipse2D.Double ellip = new Ellipse2D.Double(x1, y1, 100, 100);
		g2.setPaint(Color.YELLOW);
		g2.fill(ellip);

		Ellipse2D.Double ellip2 = new Ellipse2D.Double(x2, y2, 100, 100);
		g2.setPaint(Color.RED);
		g2.fill(ellip2);
		Area area1 = new Area(ellip);
		Area area2 = new Area(ellip2);
		area1.intersect(area2);
		g2.setPaint(Color.ORANGE);
		g2.fill(area1);
		
		Ellipse2D.Double ellip3 = new Ellipse2D.Double(x3, y3, 100, 100);
		g2.setPaint(Color.YELLOW);
		g2.fill(ellip3);

		Ellipse2D.Double ellip4 = new Ellipse2D.Double(x4, y4, 100, 100);
		g2.setPaint(Color.RED);
		g2.fill(ellip4);
		Area area3 = new Area(ellip3);
		Area area4 = new Area(ellip4);
		area3.intersect(area4);
		g2.setPaint(Color.ORANGE);
		g2.fill(area3);
		
		g2.setPaint(Color.BLACK);
		g2.drawString("easy", 100, 20);
		g2.drawString("hard", 600, 20);
		return;
	}
}
