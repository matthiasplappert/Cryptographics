package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;
import javax.swing.Timer;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class ExplainAimView extends VisualizationView {
	
	private JLabel aimExplain;
	private int x1, y1, x2, y2;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 5986978581223106407L;

	public ExplainAimView() {
		super();
		this.setLayout(new GridBagLayout());
		this.aimExplain = new JLabel();
		this.aimExplain.setText("<html><div style=\"width:200px\">Our aim is to exchange a secret on a public channel, " +
				"without Eve getting the secret too. Therefore we can't simply send the secret, as shown" +
				"in the figure above as Eve would get the secret too. Thus we need" +
				"to exchange the secret in a different way</div></html>");
		this.add(aimExplain);
		this.x1 = 460;
		this.y1 = 155;
		this.x2 = 600;
		this.y2 = 155;
		Timer timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(x1 < 750) {
					x1 += 3;
					if (x1 > 600 && y2 > 63) {
						y2 -= 3;
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO remove hardcoded colors and do it dynamically
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawChannel(g2);
		Ellipse2D.Double ellip = new Ellipse2D.Double(x1, y1, 50, 50);
		g2.setPaint(Color.BLUE);
		g2.fill(ellip);
		if(x1 > 600) {
			Ellipse2D.Double ellip2 = new Ellipse2D.Double(x2, y2, 50, 50);
			g2.fill(ellip2);
		}
		
	}

	private void drawChannel(Graphics2D g2) {
		g2.drawLine(450, 180, 800, 180);
		g2.drawLine(625, 60, 625, 180);
		g2.drawString("Alice", 400, 180);
		g2.drawString("Bob", 810, 180);
		g2.drawString("Eve", 610, 50);
	}

}
