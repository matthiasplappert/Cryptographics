package edu.kit.iks.CryptographicsLib;

import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 * A diagram to display and compare the frequency of used characters.
 * 
 * This has a vertical beam for each character, with the beam for the most used character being at
 * maximum height of the diagram. Each other beam has a corresponding fraction of this height.
 * The equivalent characters are displayed beneath each beam.
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
