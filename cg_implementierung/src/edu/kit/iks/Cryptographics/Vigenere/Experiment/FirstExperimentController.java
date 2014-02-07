package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class FirstExperimentController extends AbstractVisualizationController {

	private int state;
	
	public FirstExperimentController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return null;
	}
	
	public boolean testInput(int index) {
		if (index > 4)
			return true;
		
		JTextField tempPlainText = this.getView().getTextFieldPlain(index);
		JTextField tempPlainDecrypted = this.getView().getTextFieldDecrypted(index);
		String tempKey = this.getView().getKey();
		
		if (tempPlainText.getText().isEmpty() || tempPlainDecrypted.getText().isEmpty())
			return false;
		
		char realInput = VigenereModel.dec(tempKey.charAt(index), tempPlainText.getText().charAt(0));
		
		if (tempPlainDecrypted.getText().charAt(0) == realInput) 
			return true;
		else
			return false;
	}

	@Override
	public void loadView() {
		this.state = 0;
		this.view = new FirstExperimentView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (testInput(state)) {
					state++;
					switch (state) {
					case 1:
						getView().setExplanation("<html><div width=\"1200\">Very nice, now the second character!</div></html>");
						getView().setTextField(0, "S");
						getView().setTextFieldDisabled(0);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(22);
						getView().getAlphabet().highlight(1);
						break;
					case 2:
						getView().setExplanation("<html><div width=\"1200\">Second strike! Three left...</div></html>");
						getView().setTextField(1, "U");
						getView().setTextFieldDisabled(1);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(18);
						getView().getAlphabet().highlight(2);
						break;
					case 3:
						getView().setExplanation("<html><div width=\"1200\">Not much left, 2 to go...</div></html>");
						getView().setTextField(2, "P");
						getView().setTextFieldDisabled(2);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(7);
						getView().getAlphabet().highlight(3);
						break;
					case 4:
						getView().setExplanation("<html><div width=\"1200\">Almost done, last character...</div></html>");
						getView().setTextField(3, "E");
						getView().setTextFieldDisabled(3);
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(22);
						getView().getAlphabet().highlight(4);
						break;
					case 5:
						getView().setExplanation("<html><div width=\"1200\">Nicely done!</div></html>");
						getView().setTextField(4, "R");
						getView().setTextFieldDisabled(4);
						getView().getAlphabet().unHighlightAll();
						break;	
					case 6:
						VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
						containerController.presentNextVisualizationController();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Input, please try again!", "Error!", JOptionPane.OK_OPTION);
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
	public FirstExperimentView getView() {
		return (FirstExperimentView)this.view;
	}
}
