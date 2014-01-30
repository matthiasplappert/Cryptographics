package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Ellipse2DwithColor extends Ellipse2D.Double {
	
	private Color color;
	
	public Ellipse2DwithColor(double x, double y, double w, double h, Color color) {
		super(x, y, w, h);
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

}
