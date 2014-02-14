package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import edu.kit.iks.Cryptographics.DiffieHellman.Model;
import junit.framework.TestCase;

public class ModelTest extends TestCase  {
	private Model model;
	
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}
	
	@Test
	public void testMixAlicePrivateAndPublic() {
		Color publicColor = Color.RED;
		Color privateColor = Color.BLUE;
		this.model.setPublicColor(publicColor);
		this.model.setAlicePrivateColor(privateColor);
		this.model.mixAlicePrivateAndPublic();
		
		Color expected = new Color(127, 0, 127);
		Color actual = this.model.getAliceMixedColor();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMixBobPrivateAndPublic() {
		Color publicColor = Color.YELLOW;
		Color privateColor = Color.PINK;
		this.model.setPublicColor(publicColor);
		this.model.setBobPrivateColor(privateColor);
		this.model.mixBobPrivateAndPublic();
		
		Color expected = new Color(255, 215, 87);
		Color actual = this.model.getBobMixedColor();
		assertEquals(expected, actual);
	}
}
