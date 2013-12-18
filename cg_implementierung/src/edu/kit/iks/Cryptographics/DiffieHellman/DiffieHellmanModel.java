package edu.kit.iks.Cryptographics.DiffieHellman;

public class DiffieHellmanModel {
	private int alicePublicColor;
	
	private int alicePrivateColor;
	
	private int aliceMixedColor;
	
	private int sharedColor;
	
	private int bobPublicColor;
	
	private int bobPrivateColor;
	
	private int bobMixedColor;

	public int getAlicePublicColor() {
		return alicePublicColor;
	}

	public void setAlicePublicColor(int alicePublicColor) {
		this.alicePublicColor = alicePublicColor;
	}

	public int getAlicePrivateColor() {
		return alicePrivateColor;
	}

	public void setAlicePrivateColor(int alicePrivateColor) {
		this.alicePrivateColor = alicePrivateColor;
	}

	public int getSharedColor() {
		return sharedColor;
	}

	public void setSharedColor(int sharedColor) {
		this.sharedColor = sharedColor;
	}

	public int getBobPublicColor() {
		return bobPublicColor;
	}

	public void setBobPublicColor(int bobPublicColor) {
		this.bobPublicColor = bobPublicColor;
	}

	public int getBobPrivateColor() {
		return bobPrivateColor;
	}

	public void setBobPrivateColor(int bobPrivateColor) {
		this.bobPrivateColor = bobPrivateColor;
	}

	public int getBobMixedColor() {
		return bobMixedColor;
	}

	public void setBobMixedColor(int bobMixedColor) {
		this.bobMixedColor = bobMixedColor;
	}
	
	public void mixAlicePrivateAndPublic() {
		
	}
	
	public void mixBobPrivateAndPublic() {
		
	}
	
	public void mixShared() {
		
	}
}
