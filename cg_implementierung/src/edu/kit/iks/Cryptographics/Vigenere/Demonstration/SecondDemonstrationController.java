package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;

public class SecondDemonstrationController extends AbstractVisualizationController {
	private int state;
	
	public SecondDemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return null;
	}

	@Override
	public void loadView() {
		this.state = 0;
		this.view = new SecondDemonstrationView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state--;
				Logger.d("SecondDemonstrationController", "loadView()", "State: " + state);
				switch (state) {
				case -1:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentPreviousVisualizationController();
					break;
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
					getView().getAlphabet().unHighlightAll();
					getView().setCalculator(1,15);
					getView().setTextField(0, "");
					getView().getAlphabet().highlight(0);
					getView().getAlphabet().highlight(13);
					break;
				case 3:
					getView().setExplanation("<html><div width=\"1200\">The number 16 represents 'P' in the alphabet. So the first encrypted character is 'P'. Lets go to the next one.</div></html>");
					getView().setCalculator(1,15);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(15);
					getView().setTextField(0, "P");
					getView().setTextField(1, "");
					break;
				case 4:
					getView().setExplanation("<html><div width=\"1200\">Now get to the next character. Its a 'N', which represents the number 14. The second character of they key is 'K', which is the 11. 14+11 = 25 -> 'Y'!</div></html>");
					getView().setCalculator(14,11);
					getView().getAlphabet().unHighlightAll();;
					getView().getAlphabet().highlight(24);
					getView().setTextField(1, "Y");
					getView().setTextField(2, "");
					break;
				case 5:
					getView().setExplanation("<html><div width=\"1200\">Now we continue...</div></html>");
					getView().setCalculator(14,1);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(14);
					getView().setTextField(2, "O");
					getView().setTextField(3, "");
					break;
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
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
					getView().setExplanation("<html><div width=\"1200\">The position of 'A' in the alphabet is 1. The position of 'O' is 15. Now we calculate 1 + 15 and get 16.</div></html>");
					getView().setKeyVisible(true);
					getView().setEncryptedCharsVisible(true);
					getView().setCalculatorVisible(true);
					getView().setCalculator(1,15);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(0);
					getView().getAlphabet().highlight(14);
					break;
				case 3:
					getView().setExplanation("<html><div width=\"1200\">The number 16 represents 'P' in the alphabet. So the first encrypted character is 'P'. Lets go to the next one.</div></html>");
					getView().getAlphabet().unHighlightAll();
					getView().setTextField(0, "P");
					getView().getAlphabet().highlight(15);
					break;
				case 4:
					getView().setExplanation("<html><div width=\"1200\">Now get to the next character. Its a 'N', which represents the number 14. The second character of they key is 'K', which is the 11. 14+11 = 25 -> 'Y'!</div></html>");
					getView().setCalculator(14,11);
					getView().getAlphabet().unHighlightAll();;
					getView().getAlphabet().highlight(24);
					getView().setTextField(1, "Y");
					break;
				case 5:
					getView().setExplanation("<html><div width=\"1200\">Now we continue...</div></html>");
					getView().setCalculator(14,1);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(14);
					getView().setTextField(2, "O");
					break;
				case 6:
					getView().setExplanation("<html><div width=\"1200\">E = 5 and Y = 25. 25 + 5 = 30, but our alphabet doesnt have 28 characters. So we now use the modulo: 28 modulo 26 = 2.</div></html>");
					getView().setCalculator(5,25);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(3);
					getView().setTextField(3, "D");
					break;
				case 7:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
					break;
				}
			}
		});
	}

	@Override
	public SecondDemonstrationView getView() {
		return (SecondDemonstrationView) this.view;
	}
}
