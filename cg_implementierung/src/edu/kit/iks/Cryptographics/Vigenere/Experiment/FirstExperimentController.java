package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;

public class FirstExperimentController extends AbstractVisualizationController {

	private int state;
	
	public FirstExperimentController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return null;
	}

	@Override
	public void loadView() {
		this.state = 0;
		this.view = new FirstExperimentView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state--;
				Logger.d("FirstExperimentController", "backButton.addActionListener()", "State: " + state);
				switch (state) {
					case -1:
						VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
						containerController.presentPreviousVisualizationController();
						break;
					case 0:
						getView().setExplanation("<html><div width=\"1200\">Now we want to decrypt 'DMPL'. Insteading adding up, we use substraction to decrypt it! So lets go...</div></html>");
						getView().setCalculatorVisible(false);
						break;
					case 1:
						getView().setExplanation("<html><div width=\"1200\">'E' = 5 and 'K' = 11. 3 - 11 = -6. What now? Well its easy, just reverse the modulo... </div></html>");
						getView().setCalculatorVisible(true);
						getView().setCalculator(5,11);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(4);
						getView().getAlphabet().highlight(10);
						getView().setTextField(0, "");
						break;
					case 2:
						getView().setExplanation("<html><div width=\"1200\">Negative numbers mean you start from the 'z' and go 7 steps backwards. So we get 'T' = 20!</div></html>");
						getView().setCalculator(4,11);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(19);
						getView().setTextField(0, "T");
						getView().setTextField(1, "");
						break;
					case 3:
						getView().setExplanation("<html><div width=\"1200\">'N' = 14 and 'I' = 9. 14 - 9 = 5 -> 'E'</div></html>");
						getView().setCalculator(14,9);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(4);
						getView().setTextField(1, "E");
						getView().setTextField(2, "");
						break;
					case 4:
						getView().setExplanation("<html><div width=\"1200\">'Q' = 17 and 'S' = 19. 17 - 19 = -2 -> Go 2 Steps backwards from 'Z' -> 'X'</div></html>");
						getView().setCalculator(17,19);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(23);
						getView().setTextField(2, "X");
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
					getView().setExplanation("<html><div width=\"1200\">'E' = 5 and 'K' = 11. 3 - 11 = -6. What now? Well its easy, just reverse the modulo... </div></html>");
					getView().setCalculatorVisible(true);
					getView().setCalculator(5,11);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(4);
					getView().getAlphabet().highlight(10);
					break;
				case 2:
					getView().setExplanation("<html><div width=\"1200\">Negative numbers mean you start from the 'z' and go 7 steps backwards. So we get 'T' = 20!</div></html>");
					getView().setCalculator(5,11);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(19);
					getView().setTextField(0, "T");
					break;
				case 3:
					getView().setExplanation("<html><div width=\"1200\">'N' = 14 and 'I' = 9. 14 - 9 = 5 -> 'E'</div></html>");
					getView().setCalculator(14,9);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(4);
					getView().setTextField(1, "E");
					break;
				case 4:
					getView().setExplanation("<html><div width=\"1200\">'Q' = 17 and 'S' = 19. 17 - 19 = -2 -> Go 2 Steps backwards from 'Z' -> 'X'</div></html>");
					getView().setCalculator(17,19);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(23);
					getView().setTextField(2, "X");
					break;
				case 5:
					getView().setExplanation("<html><div width=\"1200\">'M' = 13 and 'S' = 19. 13 - 19 = -6 -> Go 6 Steps backwards from 'Z' -> 'T'</div></html>");
					getView().setCalculator(13,19);
					getView().getAlphabet().unHighlightAll();
					getView().getAlphabet().highlight(19);
					getView().setTextField(3, "T");
					break;	
				case 6:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
				}
				//
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	@Override
	public FirstExperimentView getView() {
		return (FirstExperimentView)this.view;
	}
}
