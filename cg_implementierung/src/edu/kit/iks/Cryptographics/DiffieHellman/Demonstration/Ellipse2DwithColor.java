package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * wrapper for Ellipse2d so that it
 * holds also a color
 * @author kai
 *
 */

public class Ellipse2DwithColor extends Ellipse2D.Double {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676966439493063852L;
	private Color color;
	
	public Ellipse2DwithColor(double x, double y, double w, double h) {
		super(x, y, w, h);
		//default color
		this.color = Color.BLACK;
	}
	
	public Ellipse2DwithColor(double x, double y, double w, double h, Color color) {
		super(x, y, w, h);
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color2) {
		this.color = color2;
	}

}
