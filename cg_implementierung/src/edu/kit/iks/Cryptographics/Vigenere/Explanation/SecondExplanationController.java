package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class SecondExplanationController extends AbstractVisualizationController {
	private int state;
	public SecondExplanationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	@Override
	public SecondExplanationView getView() {
		// TODO Auto-generated method stub
		return (SecondExplanationView)this.view;
	}
	
	@Override
	public void loadView() {
		this.state = 0;
		this.view = new SecondExplanationView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state--;
				switch (state) {
				case -1:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentPreviousVisualizationController();
					break;
				case 0:
					getView().setExplanation("<html><div width=\"1200\">Now its your turn! You have to find the second character of the key. I was kind enough to give you a diagramm of every second character encrypted with the second part of the key."
				+ "You know what to do: </div></html>");
					getView().visibleFirstState(true);
					break;
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state++;
				switch (state) {
				case 1:
					if ((!getView().getAnswer().isEmpty()) && (getView().getAnswer().charAt(0) == 'J')) {
						getView().setExplanation("<html><div width=\"1200\">Very nice! We found the key 'NJ', now we can decrypt the message:<br><br>" + FirstExplanationView.vigenereText + "</div></html>");
						getView().visibleFirstState(false);
						getView().answerRight();
					} else {
						getView().answerFalse();
						state--;
					}
					break;
				case 2:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
					break;
				}
				
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
	public String getHelp() {
		return "Check the peaks in the histogramm and compare them to the other histogramm, do you see any similarities?";
	}
}
