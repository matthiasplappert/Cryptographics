package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.Color;

public class Model {
	
	private Color publicColor;
	
	private Color alicePrivateColor;
	
	private Color aliceMixedColor;
	
	private Color sharedColor;
	
	private Color bobPrivateColor;
	
	private Color bobMixedColor;
	
	public Model() {
		
	}
	
	public Color getPublicColor() {
		return publicColor;
	}

	public void setPublicColor(Color publicColor) {
		this.publicColor = publicColor;
	}

	public Color getAlicePrivateColor() {
		return alicePrivateColor;
	}

	public void setAlicePrivateColor(Color alicePrivateColor) {
		this.alicePrivateColor = alicePrivateColor;
	}
	
	public Color getAliceMixedColor() {
		return aliceMixedColor;
	}

	public Color getSharedColor() {
		return sharedColor;
	}

	public void setSharedColor(Color sharedColor) {
		this.sharedColor = sharedColor;
	}

	public Color getBobPrivateColor() {
		return bobPrivateColor;
	}

	public void setBobPrivateColor(Color bobPrivateColor) {
		this.bobPrivateColor = bobPrivateColor;
	}

	public Color getBobMixedColor() {
		return bobMixedColor;
	}
	
	public void mixAlicePrivateAndPublic() {
		this.aliceMixedColor = computeMixedColor(this.alicePrivateColor, this.publicColor);
	}
	
	public void mixBobPrivateAndPublic() {
		this.bobMixedColor = computeMixedColor(this.bobPrivateColor, publicColor);
	}
	
	private Color computeMixedColor(Color color, Color color2) {
		int r1 = color.getRed();
		int r2 = color2.getRed();
		int g1 = color.getGreen();
		int g2 = color2.getGreen();
		int b1 = color.getBlue();
		int b2 = color2.getBlue();
		return new Color((r1+r2)/2, (g1+g2)/2, (b1+b2)/2);
	}
}
