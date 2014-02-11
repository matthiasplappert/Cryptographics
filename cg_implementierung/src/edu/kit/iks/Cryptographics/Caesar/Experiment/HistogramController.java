package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

/**
 * Controller for the last step of the histogram experiment phase. User can try to break the caesar
 * cipher. CFifthView is being controlled here.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class HistogramController extends AbstractVisualizationController {

	/**
	 * localization.
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			HistogramController.class);

	/**
	 * The model of this Controller.
	 */
	private CryptoModel model;

	/**
	 * Integer value that shows what step the visualization has proceed.
	 */
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
	public void loadView() {
		this.view = new HistogramView();
		this.model = CryptoModel.getInstance();
		this.step = 0;

		this.genProceedListener();

		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) HistogramController.this
						.getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) HistogramController.this
						.getParentController();
				containerController.presentNextVisualizationController();
			}
		});
	}

	public void generateHistogramInputListener() {
		this.getView().getKeyInput().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				if (HistogramController.this.getView().getNumpad() == null) {
					HistogramController.this.getView().createNumpad(
							HistogramController.this.getView().getKeyInput());
				}

				if (HistogramController.this.getView().getKeyInput()
						.isEditable()) {
					HistogramController.this
							.getView()
							.getKeyInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// Nothing to do here.
			}

		});

		// Not really much input checking necessary because the keyboard has only numerical values.
		this.getView().getKeyInput().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (HistogramController.this.getView().getKeyInput().getText()
						.length() > 0) {
					int key = 0;
					try {
						key = Integer.parseInt(HistogramController.this
								.getView().getKeyInput().getText());
					} catch (NumberFormatException e1) {
						Logger.e(e1);
					}
					if (HistogramController.this.getModel().isKeyValid(key)) {
						String decryptedCipher = HistogramController.this
								.getModel().dec(
										key,
										HistogramController.this.getView()
												.getHistogramCipher());
						HistogramController.this.getView().getPlainText()
								.setText(decryptedCipher);

						if (key == HistogramController.this.getView()
								.getSecretKey()) {
							HistogramController.this
									.getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							String explanations = "<html><body>"
									+ HistogramController.this.getModel()
											.genRandomGrats()
									+ i18n.tr( "You found the right key!!! See how easy it is with histograms?<br>"
									+ "If you want to try one more click proceed. Else you can go next to further information<br>"
									+ "There you can learn more about caesar's cipher.");
							HistogramController.this.getView()
									.getExplanations().setText(explanations);
							HistogramController.this.getView().getProceed()
									.setVisible(true);
							HistogramController.this.getView().requestFocus();
							HistogramController.this.getView().remove(
									HistogramController.this.getView()
											.getNumpad());
							HistogramController.this.getView().setNumpad(null);
							HistogramController.this.getView().validate();
							HistogramController.this.getView().repaint();

						} else {
							String explanations = "<html><body>"
									+ HistogramController.this.getModel()
											.genRandomBlamings()
									+ i18n.tr(" The key was wrong.");
							HistogramController.this.getView()
									.getExplanations().setText(explanations);
							HistogramController.this
									.getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.red));
						}

					} else {
						String explanations = "<html><body>"
								+ HistogramController.this.getModel()
										.genRandomBlamings()
								+ i18n.tr(" This key is invalid. Please type a number between 1 and 26. If you dont understand why,<br>"
								+ "then go to the stages before and learn how the cipher works.");
						HistogramController.this.getView().getExplanations()
								.setText(explanations);
						HistogramController.this
								.getView()
								.getKeyInput()
								.setBorder(
										BorderFactory
												.createLineBorder(Color.red));
					}
				} else {
					String explanations = "<html><body>"
							+ HistogramController.this.getModel()
									.genRandomBlamings()
							+ i18n.tr(" The keyfield was empty!");
					HistogramController.this.getView().getExplanations()
							.setText(explanations);
					HistogramController.this
							.getView()
							.getKeyInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.red));
				}
			}
		});
	}

	/**
	 * Generates the action listener for the brute force stage.
	 */
	public void generateBruteForceListener() {
		this.getView().getIncrement()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						int nextBFKey = 0;
						try {
							nextBFKey = Integer
									.parseInt(HistogramController.this
											.getView().getBruteForceKey()
											.getText()) + 1;
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						}
						if (getModel().isKeyValid(nextBFKey)) {

							HistogramController.this.getView()
									.getBruteForceKey().setText("" + nextBFKey);
							HistogramController.this
									.getView()
									.getPlainText()
									.setText(
											(HistogramController.this
													.getModel()
													.dec(nextBFKey,
															HistogramController.this
																	.getView()
																	.getCipherBruteForce()
																	.getText())));
							// if the button is not visible, then it means that the key wasnt
							// found
							// yet.
							if (!HistogramController.this.getView()
									.getProceed().isVisible()) {
								// compare the keys.
								if (nextBFKey == HistogramController.this
										.getView().getSecretKey()) {
									HistogramController.this
											.getView()
											.getKeyControl()
											.setBorder(
													BorderFactory
															.createLineBorder(
																	Color.green,
																	5));
									HistogramController.this
											.getView()
											.getAnnouncement()
											.setText(
													"<html><body>"
															+ HistogramController.this
																	.getModel()
																	.genRandomGrats()
															+ i18n.tr(" You found the secret key and are now able<br>"
															+ "to read the secret message. The Key was ")
															+ nextBFKey);
									HistogramController.this.setStep(1);
									HistogramController.this.getView()
											.getProceed().setVisible(true);
									HistogramController.this.getView()
											.revalidate();

								} else {
									HistogramController.this
											.getView()
											.getAnnouncement()
											.setText(
													HistogramController.this
															.getModel()
															.genRandomBlamings());
									HistogramController.this
											.getView()
											.getKeyControl()
											.setBorder(
													BorderFactory
															.createLineBorder(
																	Color.orange,
																	5));
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
						int previousBFKey = 0;
						try {
							previousBFKey = Integer
									.parseInt(HistogramController.this
											.getView().getBruteForceKey()
											.getText()) + 1;
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						}
						if (getModel().isKeyValid(previousBFKey)) {
							HistogramController.this.getView()
									.getBruteForceKey()
									.setText("" + previousBFKey);
							HistogramController.this
									.getView()
									.getPlainText()
									.setText(
											(HistogramController.this
													.getModel()
													.dec(previousBFKey,
															HistogramController.this
																	.getView()
																	.getCipherBruteForce()
																	.getText())));
						} else {

						}
					}
				});
	}

	private void genProceedListener() {
		this.getView().getProceed().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
				if (HistogramController.this.getStep() == 0) {
					HistogramController.this.getView().getProceed()
							.setVisible(false);
					int secret = HistogramController.this.getModel()
							.generateKey();

					HistogramController.this.getView().setupBruteForceCore(
							secret,
							HistogramController.this.getModel()
									.genRandomCipher(secret));
					HistogramController.this.generateBruteForceListener();
					HistogramController.this
							.getView()
							.getKeyControl()
							.setBorder(
									BorderFactory.createLineBorder(
											Color.orange, 5));

				} else if (HistogramController.this.getStep() == 1) {
					// unload the old explanations.
					HistogramController.this.getView()
							.unloadExplanationAndForwardingPanel();
					HistogramController.this.getView().remove(
							HistogramController.this.getView().getKeyControl());
					HistogramController.this.getView().setKeyControl(null);

					String explanation = "<html><body>"
							+ i18n.tr("The diagram you see here shows the frequency of each letter<br>"
									+ "in the text you are reading at the moment. It is called a<br>"
									+ "Histogram. If you would count all E's in this explanation<br>"
									+ "you would get the number you see in the diagram on the column<br>"
									+ "above the letter E. Now the program will encrypt this explanation<br>"
									+ "with an unknown key in a most awesome way and we will see the <br>"
									+ "histogram of the cipher. Click Proceed and see the magic!");

					HistogramController.this.getView()
							.setupExplanationAndForwarding(explanation);

					// Build the new experiment.
					HistogramController.this.setStep(2);
					HistogramController.this.genProceedListener();
					HistogramController.this.getView()
							.setupHistogramContainer();
					HistogramController.this.getView().setupPlainHistogram(
							explanation);

					HistogramController.this.getView().revalidate();
					HistogramController.this.getView().repaint();
				} else if (HistogramController.this.getStep() == 2) {
					HistogramController.this.getView().getProceed()
							.setVisible(false);
					HistogramController.this.setStep(3);
					String htmlText = HistogramController.this.getView()
							.getExplanations().getText();
					String htmlCipher = HistogramController.this.getModel()
							.enc(3, htmlText);

					HistogramController.this
							.getView()
							.getExplanations()
							.setText(
									"<html><body>"
											+ i18n.tr("Comrade, as i told you in a chapter before this technique belongs to the science of cryptology<br>"
													+ "And is a little more complicated than the technique before. Just read carefully.<br>"
													+ "<br>"
													+ "If you remember not so long ago, when you looked at the histogram of the last explanation<br>"
													+ "the letter 'E' was the most frequent one. When you look at the histogram of the cipher you<br>"
													+ "you can see that now 'H' is the most frequent one. If we think a little further it is logical<br>"
													+ "to assume that when the program encrypted, the letter 'E' on position 5 in the alphabet was shifted<br>"
													+ "3 positions forward to the position 8 and is now the letter 'H'! Now we can assume that the key<br>"
													+ "was 'H' - 'E' = 8 - 5 = 3 . And now we are able to decrypt the cipher. Type the key 3 in the inputfield<br>"
													+ "and let the program decrypt the whole text with this key!"));

					HistogramController.this.getView().setupCipherHistogram(
							htmlCipher);
					HistogramController.this.getView().setHistogramCipher(
							htmlCipher);
					HistogramController.this.getView().setSecretKey(3);
					HistogramController.this.getView().setupKeyInput();
					HistogramController.this.generateHistogramInputListener();
					HistogramController.this.getView().validate();
					HistogramController.this.getView().repaint();

				} else {
					// Build the new experiment.
					HistogramController.this.setStep(HistogramController.this
							.getStep() + 1);
					HistogramController.this.getView().unloadCipherHistogram();
					HistogramController.this.getView().unloadKeyInput();
					HistogramController.this.getView().getPlainText()
							.setText("");
					HistogramController.this.getView().requestFocus();
					HistogramController.this.getView().getExplanations()
							.setText(i18n.tr("Ok lets try another one!"));

					String plainText = HistogramController.this.getModel()
							.genRandomText();
					int key = HistogramController.this.getModel().generateKey();
					String cipher = HistogramController.this.getModel().enc(
							key, plainText);

					HistogramController.this.getView().setupCipherHistogram(
							cipher);
					HistogramController.this.getView().setupKeyInput();
					HistogramController.this.generateHistogramInputListener();
					HistogramController.this.getView().setHistogramCipher(
							cipher);
					HistogramController.this.getView().setSecretKey(key);
					HistogramController.this.getView().getProceed()
							.setVisible(false);
					if (HistogramController.this.getView().getNumpad() != null) {
						HistogramController.this.getView().remove(
								HistogramController.this.getView().getNumpad());
						HistogramController.this.getView().setNumpad(null);
					}
					HistogramController.this.getView().validate();
					HistogramController.this.getView().repaint();
				}

			}
		});
	}

	@Override
	public String getHelp() {
		return i18n.tr("Under Constrcution");
	}

	/**
	 * @return the model
	 */
	public CryptoModel getModel() {
		return this.model;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return this.step;
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
	 * @param model
	 *            the model to set
	 */
	public void setModel(CryptoModel model) {
		this.model = model;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
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

}
