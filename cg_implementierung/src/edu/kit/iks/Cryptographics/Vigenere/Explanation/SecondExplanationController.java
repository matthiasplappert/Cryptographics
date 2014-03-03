package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.KeyboardView;

public class SecondExplanationController extends AbstractVisualizationController {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(SecondExplanationController.class);
	
	/**
	 * current state
	 */
	private int state;
	
	/**
	 * Constructor of the controller
	 * @param visualizationInfo
	 */
	public SecondExplanationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	/**
	 * returns the view
	 * @return view of current step
	 */
	@Override
	public SecondExplanationView getView() {
		return (SecondExplanationView)this.view;
	}
	
	/**
	 * loads the view and registers action listeners
	 */
	@Override
	public void loadView() {
		this.state = 0;
		this.view = new SecondExplanationView();
		final JTextField userOutput = getView().getAnswerField();
		userOutput.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				getView().answerRight();
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
		userOutput
		.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (getView().getKeyboard() != null) {
						getView().remove(getView().getKeyboard());
						getView().setKeyboard(null);
						getView().validate();
						getView().repaint();
					}
					state++;
					switch (state) {
					case 1:
						if ((!getView().getAnswer().isEmpty()) && (getView().getAnswer().charAt(0) == 'J')) {
							getView().setExplanation("<html><div width=\"1200\">"
									+ i18n.tr("Very nice! We found the key 'NJ', now we can decrypt "
									+ "the message:")
									+ "<br><br>"
									+ FirstExplanationView.vigenereText
									+ "</div></html>");
							getView().visibleFirstState(false);
							getView().answerRight();
						} else {
							getView().answerFalse();
							state--;
						}
						break;
					}
				}
		});
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state--;
				switch (state) {
				case -1:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentPreviousVisualizationController();
					break;
				case 0:
					getView().setExplanation("<html><div width=\"1200\">"
							+ i18n.tr("Now its your turn! You have to find the second character "
							+ "of the key. I was kind enough to give you a diagramm of every "
							+ "second character encrypted with the second part of the key."
							+ "You know what to do:")
							+ "</div></html>");
					getView().visibleFirstState(true);
					break;
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (getView().getKeyboard() != null) {
					getView().remove(getView().getKeyboard());
					getView().setKeyboard(null);
					getView().validate();
					getView().repaint();
				}
				state++;
				switch (state) {
				case 1:
					if ((!getView().getAnswer().isEmpty()) && (getView().getAnswer().charAt(0) == 'J')) {
						getView().setExplanation("<html><div width=\"1200\">"
								+ i18n.tr("Very nice! We found the key 'NJ', now we can decrypt "
								+ "the message:")
								+ "<br><br>"
								+ FirstExplanationView.vigenereText
								+ "</div></html>");
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
		this.getView().getSkipButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentNextVisualizationController();
			}
		});
	}

	/**
	 * unloads the view
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	/**
	 * returns the help string
	 * @return help string
	 */
	@Override
	public String getHelp() {
		return i18n.tr("Check the peaks in the histogramm and compare them to the other histogramm, do you see any similarities?");
	}
}
