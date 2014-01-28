package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class SecondDemonstrationController extends AbstractVisualizationController {
	private int state;
	
	public SecondDemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		this.state = 0;
		this.view = new SecondDemonstrationView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				state--;
				switch (state) {
				case 0:
					getView().setExplanation("<html><div width=\"1200\">Now we want to encrypt 'ANNA'. First of all we add the position of evey character, as you can see in the bottom, in the alphabet under each character.</div></html>");
					getView().setKeyVisible(false);
					getView().setEncryptedCharsVisible(false);
					getView().setCalculatorVisible(false);
					break;
				case 1:
					getView().setExplanation("<html><div width=\"1200\">This is the key for the encryption. Now we go to the next step and encrypt the first character.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(false);
					break;
				case 2:
					getView().setExplanation("<html><div width=\"1200\">The position of 'A' in the alphabet is 1. The position of 'O' is 14. Now we calculate 1 + 14 and get 15.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(true);
					getView().setHighlighted(0);
					getView().setHighlighted(13);
					break;
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				state++;
				switch (state) {
				case 1:
					getView().setExplanation("<html><div width=\"1200\">This is the key for the encryption. Now we go to the next step and encrypt the first character.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(false);
					break;
				case 2:
					getView().setExplanation("<html><div width=\"1200\">The position of 'A' in the alphabet is 1. The position of 'O' is 14. Now we calculate 1 + 14 and get 15.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(true);
					getView().setHighlighted(0);
					getView().setHighlighted(13);
					break;
				case 3:
					getView().setExplanation("<html><div width=\"1200\">The number 15 represents 'P' in the alphabet. So the first encrypted character is 'P'. Lets go to the next one.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(true);
					getView().setUnHighlighted(0);
					getView().setUnHighlighted(13);
					getView().setHighlighted(15);
					getView().setTextField(0, "P");
				}
				
				//VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				//containerController.presentNextVisualizationController();
			}
		});
	}

	@Override
	public SecondDemonstrationView getView() {
		return (SecondDemonstrationView) this.view;
	}
}
