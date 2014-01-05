package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.Color;

public class Model {
	private Color alicePublicColor;
	
	private Color alicePrivateColor;
	
	private Color aliceMixedColor;
	
	private Color sharedColor;
	
	private Color bobPublicColor;
	
	private Color bobPrivateColor;
	
	private Color bobMixedColor;

	public Color getAlicePublicColor() {
		return alicePublicColor;
	}

	public void setAlicePublicColor(Color alicePublicColor) {
		this.alicePublicColor = alicePublicColor;
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

	public Color getBobPublicColor() {
		return bobPublicColor;
	}

	public void setBobPublicColor(Color bobPublicColor) {
		this.bobPublicColor = bobPublicColor;
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
		
	}
	
	public void mixBobPrivateAndPublic() {
		
	}
	
	public void mixShared() {
		
	}
}
