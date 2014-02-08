package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.MouseClickListener;
import edu.kit.iks.CryptographicsLib.Logger;

/**
 * Controller for the last step of the experiment phase. User can try to break the caesar cipher.
 * CFifthView is being controlled here.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class HistogramController extends AbstractVisualizationController {

	private CryptoModel model;

	private int step;

	/**
	 * Constructor
	 * 
	 * @param visualizationInfo
	 */
	public HistogramController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		this.view = new HistogramView();
		this.model = CryptoModel.getInstance();
		this.step = 0;

		genProceedListener();

		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentNextVisualizationController();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
		this.model = null;
	}

	private void genProceedListener() {
		this.getView().getProceed().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
				if (getStep() == 0) {
					int secret = getModel().generateKey();
					getView().setSecretKey(secret);
					getView().setupKeyControlPanel();
					getView().setupIncrementDecrement();
					getView().setupCipherPlainLabels(
							getModel().getRandomCipher(secret));
					getView().setupBruteForce();
					genListenerBruteForce();
					getView().getKeyControl().setBorder(
							BorderFactory.createLineBorder(Color.orange, 5));

				} else if (getStep() == 1) {
					// unload the old explanations.
					getView().unloadExplanationPanel();
					getView().remove(getView().getKeyControl());
					getView().setKeyControl(null);

					String explanation = "<html><body>"
							+ "The diagram you see here shows the frequency of each letter<br>"
							+ "in the text you are reading at the moment. It is called a<br>"
							+ "Histogram. If you would count all E's in this explanation<br>"
							+ "you would get the number you see in the diagram on the column<br>"
							+ "above the letter E. Let's assume that this explanation is a<br>"
							+ "normal english text and that in all english texts E is the<br>"
							+ "most frequent letter! Now the program will encrypt this explanation<br>"
							+ "with an unknown key in a most awesome way and we will see the <br>"
							+ "histogram of the cipher. Click Proceed and see the magic!";

					getView().setupExplanationPanel();
					getView().setupExplanations(explanation);
					getView().setupProceed();
					genProceedListener();

					// Build the new experiment.
					setStep(2);

					getView().setupHistogramContainer();
					getView().setupPlainHistogram(explanation);

					getView().revalidate();
					getView().repaint();
				} else if (getStep() == 2) {
					setStep(3);
					String[] htmlFreeText = getModel().removeHtmlBreaks(
							getView().getExplanations().getText());
					String[] cipher = getModel().enc(3, htmlFreeText);
					String htmlCipher = getModel().insertHtmlBreaks(cipher);

					getView()
							.getExplanations()
							.setText(
									"<html><body>"
											+ "If you remember not so long ago, when you looked at the histogram of a normal english text<br>"
											+ "the letter 'E' was the most frequent one. When you look at the histogram of the cipher youy<br>"
											+ "you can see that now 'H' is the most frequent one. If we think a little further it is logical<br>"
											+ "to assume that when the program encrypted the letter 'E' on position 5 in the alphabet was shifted<br>"
											+ "3 positions forward to the position 8 and is now the letter 'H'! Now we can assume that the key<br>"
											+ "was 'H' - 'E' = 8 - 5 = 3! And now we are able to decrypt the cipher. Type the key 3 in the inputfield<br>"
											+ "and let the program decrypt the whole text with this key!");

					getView().setupCipherHistogram(htmlCipher);
					getView().setHistogramCipher(cipher);
					getView().setSecretKey(3);
					getView().unloadProceed();
					getView().setupKeyInput();
					generateHistogramInputListener();
					getView().validate();
					getView().repaint();

				} else {
					// Build the new experiment.
					setStep(getStep() + 1);
					getView().unloadCipherHistogram();
					getView().unloadKeyInput();
					getView().getPlainText().setText("");
					getView().requestFocus();
					getView().getExplanations().setText(
							"Ok lets try another one!");

					String[] plainText = getModel().removeHtmlBreaks(
							getModel().getRandomText());
					int key = getModel().generateKey();
					String[] cipher = getModel().enc(key, plainText);

					getView().setupCipherHistogram(
							getModel().insertHtmlBreaks(cipher));
					getView().setupKeyInput();
					generateHistogramInputListener();
					getView().setHistogramCipher(cipher);
					getView().setSecretKey(key);
					getView().unloadProceed();
				}

			}
		});
	}

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public HistogramView getView() {
		return (HistogramView) this.view;
	}

	/**
	 * Generates the action listener for the brute force stage.
	 */
	public void genListenerBruteForce() {
		this.getView().getIncrement()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						int key = getView().getKeyValue() + 1;
						if (key < 27) {

							getView().setKeyValue(key);
							getView().getKey().setText("" + key);
							getView().getPlainText().setText(
									(getModel().dec(key, getView().getCipher()
											.getText())));
							// if the button is not visible, then it means that the key wasnt found
							// yet.
							if (getView().getProceed() == null) {
								// compare the keys.
								if (key == getView().getSecretKey()) {
									getView().getKeyControl().setBorder(
											BorderFactory.createLineBorder(
													Color.green, 5));
									getView()
											.getAnnouncement()
											.setText(
													"<html><body> Congratulations you found the secret key and are now able<br>"
															+ "to read the secret message. The Key was "
															+ key);
									setStep(1);
									getView().setupProceed();
									genProceedListener();
									getView().revalidate();

								} else {
									getView()
											.getAnnouncement()
											.setText(
													"Sorry, this one doesn't work! Try another one.");
									getView().getKeyControl().setBorder(
											BorderFactory.createLineBorder(
													Color.orange, 5));
								}
							} else {
								// Also nothing to do ;)
							}
						} else {
							// Nothing to do here ;)
						}
					}
				});
		this.getView().getDecrement()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						int key = getView().getKeyValue() - 1;
						if (key > 0) {
							getView().setKeyValue(key);
							getView().getKey().setText("" + key);
							getView().getPlainText().setText(
									(getModel().dec(key, getView().getCipher()
											.getText())));
						} else {

						}
					}
				});
	}

	public void generateHistogramInputListener() {
		this.getView().getKeyInput().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (getView().getKeyboard() != null) {
					getView().remove(getView().getKeyboard());
					getView().setKeyboard(null);
					getView().validate();
					getView().repaint();

					if (getView().getKeyInput().isEditable()) {
						getView().getKeyInput().setBorder(null);
					}
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (getView().getKeyInput().isEditable()) {
					getView().getKeyInput().setBorder(
							BorderFactory.createLineBorder(Color.blue, 5));
					getView().createKeyboard(getView().getKeyInput());
				}
			}

		});

		// Not really much input checking necessary because the keyboard has only numerical values.
		this.getView().getKeyInput().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int key = Integer.parseInt(getView().getKeyInput()
							.getText());
					if (getModel().isKeyValid(key)) {
						String[] decryptedCipherLines = getModel().dec(key,
								getView().getHistogramCipher());
						String decryptedCipherString = getModel()
								.insertHtmlBreaks(decryptedCipherLines);
						getView().getPlainText().setText(decryptedCipherString);

						if (key == getView().getSecretKey()) {
							getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							String explanations = "<html><body>"
									+ "Congratulations you found the right key!!! See how easy it is with histograms?<br>"
									+ "If you want to try one more click proceed. Else you can go next to further information<br>"
									+ "There you can learn more about caesar's cipher.";
							getView().getExplanations().setText(explanations);
							getView().setupProceed();
							genProceedListener();
							getView().requestFocus();
							getView().validate();

						} else {
							// TODO: warnings needed.
							getView().getKeyInput().setBorder(
									BorderFactory.createLineBorder(Color.red));
						}

					} else {
						getView().getKeyInput().setBorder(
								BorderFactory.createLineBorder(Color.red));
					}
				} catch (NumberFormatException e1) {
					Logger.e(e1);
				}

			}
		});
	}

	/**
	 * @return the model
	 */
	public CryptoModel getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(CryptoModel model) {
		this.model = model;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}

}
