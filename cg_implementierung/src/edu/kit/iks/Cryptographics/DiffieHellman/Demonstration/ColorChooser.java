package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorChooser extends JPanel {
	
	private JButton next;
	
	private JButton prev;
	
	private DrawPanel dp;
	
	private int index;
	
	private Ellipse2DwithColor current;
	
	private Color[] toChooseFrom;
	
	public ColorChooser(Dimension d, Color color, Color[] colors) {
		this.toChooseFrom = colors;
		this.setLayout(new FlowLayout());
		this.next = new JButton("->");
		this.prev = new JButton("<-");
		this.current = new Ellipse2DwithColor(0, 0, d.getHeight(), d.getWidth(), color);
		this.dp = new DrawPanel(d);
		this.next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				index = (index + 1) % toChooseFrom.length;
				current.setColor(toChooseFrom[index]);
				repaint();
			}
		});
		this.prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				index = index > 0 ? (index - 1) % toChooseFrom.length : (toChooseFrom.length -1);
				current.setColor(toChooseFrom[index]);
				repaint();
			}
		});
		this.add(prev);
		this.add(dp);
		this.add(next);
		
//		this.setSize(d.width+next.getWidth()+prev.getWidth(), d.height);
//		this.setPreferredSize(new Dimension(d.width+next.getWidth()+prev.getWidth(), d.height));
		validate();
	}
	
	private class DrawPanel extends JPanel {
		
		private static final long serialVersionUID = -3771892570139056170L;

		public DrawPanel(Dimension d) {
			this.setSize(d);
			this.setPreferredSize(d);
		}
		
		
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setPaint(current.getColor());
			g2.fill(current);
		}
		
	}
	
	public Color getCurrentColor() {
		return this.current.getColor();
	}
	
	public void setToChooseFrom(Color[] colors) {
		this.index = 0;
		this.toChooseFrom = colors;
		this.current.setColor(colors[0]);
		repaint();
	}

	public Color[] getToChooseFrom() {
		return toChooseFrom;
	}

}
