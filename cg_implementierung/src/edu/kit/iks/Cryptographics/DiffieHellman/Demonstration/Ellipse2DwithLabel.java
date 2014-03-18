package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;

public class Ellipse2DwithLabel extends Ellipse2DwithColor {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	
	
	public Ellipse2DwithLabel(double x, double y, double w, double h,
			Color color, String label) {
		super(x, y, w, h, color);
		this.label = label;
	}


	public String getLabel() {
		return label;
	}
	
	
}
