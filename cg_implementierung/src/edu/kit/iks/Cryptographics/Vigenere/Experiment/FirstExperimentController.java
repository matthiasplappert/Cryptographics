package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoController;
import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.KeyboardView;

public class FirstExperimentController extends AbstractVisualizationController {

	private int state;
	
	public FirstExperimentController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		String returnString = "";
		switch (this.state) {
		case 0:
			returnString = "'T' = 20 and 'A' = 1, so just substract 1 from 20 and you have the answer!";
			break;
		case 1:
			returnString = "'W' = 23 and 'B' = 2, so just substract 1 from 20 and you have the answer!";
			break;
		case 2:
			returnString = "'S' = 19 and 'C' = 3, so just substract 1 from 20 and you have the answer!";
			break;
		case 3:
			returnString = "'I' = 9 and 'D' = 4, so just substract 1 from 20 and you have the answer!";
			break;
		case 4:
			returnString = "'W' = 23 and 'E' = 5, so just substract 1 from 20 and you have the answer!";
			break;
		default:
			return null;
		}
		return returnString;
	}
	
	public boolean testInput(int index) {
		if (index > 4)
			return true;
		
		JLabel tempPlainText = this.getView().getTextFieldPlain(index);
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
		
		JTextField[] fields = getView().getTextFields();
		for (int i = 0; i < fields.length; i++) {
			final JTextField userOutput = fields[i];

			userOutput
					.addFocusListener(new FocusListener() {
						@Override
						public void focusGained(FocusEvent e) {
							userOutput.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
							getView().hideError();
							if (getView().getKeyboard() != null) {
								getView().remove(getView().getKeyboard());
								getView().setKeyboard(null);
								getView().validate();
								getView().repaint();
							}
							if (userOutput.isEditable()) {
								getView().createKeyboard(userOutput, KeyboardView.CHAR_MODE);
							}
						}
						@Override
						public void focusLost(FocusEvent e) {
							
						}
					});
		}
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (getView().getKeyboard() != null) {
					getView().remove(getView().getKeyboard());
					getView().setKeyboard(null);
					getView().validate();
					getView().repaint();
				}
				if (testInput(state)) {
					getView().hideError();
					state++;
					switch (state) {
					case 1:
						getView().setExplanation("<html><div width=\"1200\">Very nice, now the second character!</div></html>");
						getView().setTextField(0, "S");
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(22);
						getView().getAlphabet().highlight(1);
						getView().unHighlightTextBorder(0);
						getView().highlightTextBorder(1);
						break;
					case 2:
						getView().setExplanation("<html><div width=\"1200\">Second strike! Three left...</div></html>");
						getView().setTextField(1, "U");
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(18);
						getView().getAlphabet().highlight(2);
						getView().unHighlightTextBorder(1);
						getView().highlightTextBorder(2);
						break;
					case 3:
						getView().setExplanation("<html><div width=\"1200\">Not much left, 2 to go...</div></html>");
						getView().setTextField(2, "P");
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(7);
						getView().getAlphabet().highlight(3);
						getView().unHighlightTextBorder(2);
						getView().highlightTextBorder(3);
						break;
					case 4:
						getView().setExplanation("<html><div width=\"1200\">Almost done, last character...</div></html>");
						getView().setTextField(3, "E");
						getView().getAlphabet().unHighlightAll();
						getView().getAlphabet().highlight(22);
						getView().getAlphabet().highlight(4);
						getView().unHighlightTextBorder(3);
						getView().highlightTextBorder(4);
						break;
					case 5:
						getView().setExplanation("<html><div width=\"1200\">Nicely done!</div></html>");
						getView().setTextField(4, "R");
						getView().getAlphabet().unHighlightAll();
						getView().unHighlightTextBorder(4);
						break;	
					case 6:
						VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
						containerController.presentNextVisualizationController();
					}
				} else {
					getView().showError(state);
					
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
