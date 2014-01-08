package edu.kit.iks.CryptographicsLib;

import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 */
public class UICharacterFrequencyDiagram extends JPanel{

	private int [] quantitiesOfCharacters;
	public UICharacterFrequencyDiagram(int[] quantities) {
		super();
		
		setQuantities(quantities);
		generateDiagram();
	}
	
	public void generateDiagram() {
		// TODO generate diagram	
	}
	
	public void draw() {
		// TODO draw diagram
	}

	public int [] getQuantities() {
		return quantitiesOfCharacters;
	}

	public void setQuantities(int [] quantitiesOfCharacters) {
		this.quantitiesOfCharacters = quantitiesOfCharacters;
	}
}
