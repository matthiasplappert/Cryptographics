package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CryptoView;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

/**
 * Controller for the first and second step of the experiment phase. When user has to put input and
 * encrypt it and in the second step to decrypt a given cipher. Controls the needed elements from
 * CaesarUpperView, !!see CGeneralView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoExperimentController extends AbstractVisualizationController {

	private boolean decryptionPhase = false;

	/**
	 * Needed
	 */
	private int editableFields;

	/**
	 * Model that is needed for computations.
	 */
	private CryptoModel model;

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public CryptoExperimentController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

	}

	/**
	 * Method for delegating user's input to the model for the needed computations and checks.
	 * 
	 * @param input
	 */
	public void delegateAndHandleInput(String input) {
		if (this.model.isInputValid(input)) {
			this.proceed();
		}
	}

	/**
	 * Function for generating ActionListener for the needed input fields, after the user typed a
	 * string to encrypt.
	 * 
	 * @param inputChars
	 */
	public void generateListener(char[] inputChars) {
		// Generate Listener for the userOutput JTextfield
		for (int i = 0; i < inputChars.length; i++) {

			// Needed for delegating to the inner type ActionListener, when the actionEvent from the
			// Button "ENTER" on the KEayboard is fired.
			final JTextField userOutput = this.getView().getUserOutput()[i];

			this.getView().getUserOutput()[i]
					.addFocusListener(new FocusListener() {
						@Override
						public void focusGained(FocusEvent e) {

							JTextField output = (JTextField) e.getSource();
							JTextField[] userOutput = CryptoExperimentController.this
									.getView().getUserOutput();

							for (JTextField outputIterator : userOutput) {

								if (outputIterator.getText() != null
										&& CryptoExperimentController.this
												.getView().getAlphabet() != null) {
									int charToEncryptAscii = outputIterator
											.getName().charAt(0);
									AlphabetStripView viewAlphabet = CryptoExperimentController.this
											.getView().getAlphabet();
									viewAlphabet.unHighlight(charToEncryptAscii
											- CryptoExperimentController.this
													.getModel().ASCII_UC_A);
									if (outputIterator.isEditable()) {
										outputIterator.setBorder(BorderFactory
												.createLineBorder(Color.darkGray));
									}
								} else {

								}
							}

							if (CryptoExperimentController.this.getView()
									.getKeyboard() != null) {
								CryptoExperimentController.this.getView()
										.remove(CryptoExperimentController.this
												.getView().getKeyboard());
								CryptoExperimentController.this.getView()
										.setKeyboard(null);
								CryptoExperimentController.this.getView()
										.validate();
								CryptoExperimentController.this.getView()
										.repaint();
							}
							if (output.isEditable()) {
								// highlights the character in the alphabet.
								int charToEncryptAscii = output.getName()
										.charAt(0);
								AlphabetStripView viewAlphabet = CryptoExperimentController.this
										.getView().getAlphabet();
								viewAlphabet.highlight(charToEncryptAscii
										- CryptoExperimentController.this
												.getModel().ASCII_UC_A);

								output.setBorder(BorderFactory
										.createLineBorder(Color.blue, 5));
								CryptoExperimentController.this.getView()
										.createKeyboard(output,
												KeyboardView.CHAR_MODE);
							}

						}

						@Override
						public void focusLost(FocusEvent e) {
							// Nothing to do here.

						}
					});
			this.getView().getUserOutput()[i]
					.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (userOutput.isEditable()) {
								try {
									int key = Integer
											.parseInt(CryptoExperimentController.this
													.getView().getKey()
													.getText());

									// If the phase is decrypting use dec, else the phase is
									// encrypting, therefore use enc.
									String encryptedOrDecryptedcipher = "";
									if (CryptoExperimentController.this.decryptionPhase) {
										encryptedOrDecryptedcipher = CryptoExperimentController.this
												.getModel().dec(key,
														userOutput.getName());
									} else {
										encryptedOrDecryptedcipher = CryptoExperimentController.this
												.getModel().enc(key,
														userOutput.getName());
									}

									if ((encryptedOrDecryptedcipher)
											.equals(userOutput.getText())) {

										if ((CryptoExperimentController.this
												.getEditableFields() - 1) != 0) {

											// user encrypted the given char successful.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											userOutput.setEditable(false);
											CryptoExperimentController.this
													.setEditableFields(CryptoExperimentController.this
															.getEditableFields() - 1);
											CryptoExperimentController.this
													.getView()
													.getExplanations()
													.setText(
															CryptoExperimentController.this
																	.getModel()
																	.genRandomGrats()
																	+ "You have "
																	+ CryptoExperimentController.this
																			.getEditableFields()
																	+ " left!");
											CryptoExperimentController.this
													.getView().getUserOutput()[CryptoExperimentController.this
													.getView().getUserOutput().length
													- CryptoExperimentController.this
															.getEditableFields()]
													.requestFocus();
										} else {
											// User encrypted all characters valid.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											CryptoExperimentController.this
													.getView().requestFocus();
											userOutput.setEditable(false);
											CryptoExperimentController.this
													.getView()
													.getAlphabet()
													.unHighlight(
															userOutput
																	.getName()
																	.charAt(0)
																	- CryptoExperimentController.this
																			.getModel().ASCII_UC_A);
											CryptoExperimentController.this
													.getView()
													.getExplanations()
													.setText(
															"<html><body>All done right! "
																	+ CryptoExperimentController.this
																			.getModel()
																			.genRandomGrats()
																	+ " Next step is to decrypt a given message!! When you accomplish it, then even the NSA and Kryptochef together<br>"
																	+ "are superior to your power. Now lets move on. Click the button in the right top corner.");
											CryptoExperimentController.this
													.getView()
													.remove(CryptoExperimentController.this
															.getView()
															.getKeyboard());
											CryptoExperimentController.this
													.getView()
													.setKeyboard(null);
											CryptoExperimentController.this
													.getView().validate();
											CryptoExperimentController.this
													.getView().repaint();

										}
									} else {
										// User encrypted invalid! Need another try.
										userOutput.setBorder(BorderFactory
												.createLineBorder(Color.red));
										CryptoExperimentController.this
												.getView()
												.getExplanations()
												.setText(
														CryptoExperimentController.this
																.getModel()
																.genRandomBlamings());
									}
								} catch (NumberFormatException e1) {
									Logger.e(e1);
								}

							}
						}

					});
		}
	}

	/**
	 * @return the editableFields
	 */
	public int getEditableFields() {
		return this.editableFields;
	}

	@Override
	public String getHelp() {
		return "If you only see the textfield then put your string in it. Else you've already "
				+ "done it and now you need to encrypt/decrypt the given String.";
	}

	/**
	 * @return the model
	 */
	public CryptoModel getModel() {
		return this.model;
	}

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public CryptoExperimentView getView() {
		return (CryptoExperimentView) this.view;
	}

	/**
	 * @return the decryptionPhase
	 */
	public boolean isDecryptionPhase() {
		return this.decryptionPhase;
	}

	@Override
	public void loadView() {
		this.view = new CryptoExperimentView();
		this.model = CryptoModel.getInstance();
		this.editableFields = 2;

		// Create all needed ActionListener.
		this.getView().getGenerator()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						char[] string = CryptoExperimentController.this
								.getModel().genRandomPlainSequence()
								.toCharArray();
						int key = CryptoExperimentController.this.getModel()
								.generateKey();
						CryptoExperimentController.this
								.setEditableFields(string.length);

						CryptoExperimentController.this.getView()
								.setupCoreExperimentElements(
										string,
										key,
										CryptoExperimentController.this
												.getView().EXPERIMENT_MODE);

						CryptoExperimentController.this
								.generateListener(string);
					}
				});
		this.getView().getKey().addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (CryptoExperimentController.this.getView().getInput()
						.getBorder() != null
						&& CryptoExperimentController.this.getView().getInput()
								.isEditable()) {
					CryptoExperimentController.this.getView().getInput()
							.setBorder(null);

				}

				if (CryptoExperimentController.this.getView().getKeyboard() != null) {
					CryptoExperimentController.this.getView().remove(
							CryptoExperimentController.this.getView()
									.getKeyboard());
					CryptoExperimentController.this.getView().setKeyboard(null);
					CryptoExperimentController.this.getView().validate();
					CryptoExperimentController.this.getView().repaint();
				} else if (CryptoExperimentController.this.getView()
						.getNumpad() != null) {
					CryptoExperimentController.this.getView().remove(
							CryptoExperimentController.this.getView()
									.getNumpad());
					CryptoExperimentController.this.getView().setNumpad(null);
					CryptoExperimentController.this.getView().validate();
					CryptoExperimentController.this.getView().repaint();
				}

				if (CryptoExperimentController.this.getView().getKey()
						.isEditable()) {
					CryptoExperimentController.this
							.getView()
							.getKey()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoExperimentController.this.getView().createNumpad(
							CryptoExperimentController.this.getView().getKey());
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}
		});
		this.getView().getKey().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (CryptoExperimentController.this.getView().getKey()
						.isEditable()) {
					try {
						String explanationContent = CryptoExperimentController.this
								.getView().getExplanations().getText();
						int key = Integer
								.parseInt(CryptoExperimentController.this
										.getView().getKey().getText());

						if (CryptoExperimentController.this.getModel()
								.isKeyValid(key)) {
							if ((CryptoExperimentController.this
									.getEditableFields() - 1) != 0) {
								CryptoExperimentController.this
										.getView()
										.getExplanations()
										.setText(
												explanationContent
														+ "<br>"
														+ "<br>This key is ok. Now put your name into the bigger box to the left.");
								CryptoExperimentController.this
										.getView()
										.getKey()
										.setBorder(
												BorderFactory
														.createLineBorder(Color.green));
								CryptoExperimentController.this.getView()
										.getKey().setEditable(false);
								CryptoExperimentController.this
										.setEditableFields((CryptoExperimentController.this
												.getEditableFields() - 1));
								CryptoExperimentController.this.getView()
										.getInput().requestFocus();
							} else {
								try {
									String input = CryptoExperimentController.this
											.getView().getInput().getText();
									char[] inputChars = new char[input.length()];
									input.getChars(0, input.length(),
											inputChars, 0);
									CryptoExperimentController.this
											.setEditableFields(inputChars.length);
									CryptoExperimentController.this.getView()
											.getKey().setBorder(null);

									// load the view!
									CryptoExperimentController.this
											.getView()
											.setupCoreExperimentElements(
													inputChars,
													key,
													CryptoExperimentController.this
															.getView().EXPERIMENT_MODE);

									// Generate Listener for the userOutput JTextfield
									CryptoExperimentController.this
											.generateListener(inputChars);
								} catch (NumberFormatException e1) {
									Logger.e(e1);
								}
							}
						} else {
							CryptoExperimentController.this
									.getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This key is not valid. Please put a number between 1 and 25.<br>"
													+ "For demonstration purposes the keys between -1 and -25 are not necessary<br>"
													+ "therefore not possible, but could be used in general as keys too. And 0 as key has no<br>"
													+ " sense, if you dont understand why, then go back to Introduction.");
							CryptoExperimentController.this
									.getView()
									.getKey()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.red));
						}
					} catch (NumberFormatException e1) {
						Logger.e(e1);
					}

				}
			}
		});
		this.getView().getInput().addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (CryptoExperimentController.this.getView().getKey()
						.getBorder() != null
						&& CryptoExperimentController.this.getView().getKey()
								.isEditable()) {
					CryptoExperimentController.this.getView().getKey()
							.setBorder(null);

				}

				if (CryptoExperimentController.this.getView().getKeyboard() != null) {
					CryptoExperimentController.this.getView().remove(
							CryptoExperimentController.this.getView()
									.getKeyboard());
					CryptoExperimentController.this.getView().setKeyboard(null);
					CryptoExperimentController.this.getView().validate();
					CryptoExperimentController.this.getView().repaint();
				} else if (CryptoExperimentController.this.getView()
						.getNumpad() != null) {
					CryptoExperimentController.this.getView().remove(
							CryptoExperimentController.this.getView()
									.getNumpad());
					CryptoExperimentController.this.getView().setNumpad(null);
					CryptoExperimentController.this.getView().validate();
					CryptoExperimentController.this.getView().repaint();
				}

				if (CryptoExperimentController.this.getView().getInput()
						.isEditable()) {
					CryptoExperimentController.this
							.getView()
							.getInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoExperimentController.this.getView().createKeyboard(
							CryptoExperimentController.this.getView()
									.getInput(), KeyboardView.STRING_MODE);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}
		});
		this.getView().getInput().addActionListener(new ActionListener() {

			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event. ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CryptoExperimentController.this.getView().getInput()
						.isEditable()) {
					String explanationContent = CryptoExperimentController.this
							.getView().getExplanations().getText();
					String input = CryptoExperimentController.this.getView()
							.getInput().getText();

					if (CryptoExperimentController.this.getModel()
							.isInputValid(input)) {
						if ((CryptoExperimentController.this
								.getEditableFields() - 1) != 0) {
							CryptoExperimentController.this
									.getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This input is ok. Now only the key is left.");
							CryptoExperimentController.this
									.getView()
									.getInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							CryptoExperimentController.this.getView()
									.getInput().setEditable(false);
							CryptoExperimentController.this
									.setEditableFields((CryptoExperimentController.this
											.getEditableFields() - 1));
							CryptoExperimentController.this.getView().getKey()
									.requestFocus();

						} else {

							// refactor the input into an character array.
							try {
								int key = Integer
										.parseInt(CryptoExperimentController.this
												.getView().getKey().getText());
								char[] inputChars = new char[input.length()];
								input = input.toUpperCase();
								input.getChars(0, input.length(), inputChars, 0);
								CryptoExperimentController.this
										.setEditableFields(inputChars.length);
								CryptoExperimentController.this.getView()
										.getKey().setBorder(null);

								// load the view!
								CryptoExperimentController.this
										.getView()
										.setupCoreExperimentElements(
												inputChars,
												key,
												CryptoExperimentController.this
														.getView().EXPERIMENT_MODE);

								// Generate Listener for the userOutput JTextfield
								CryptoExperimentController.this
										.generateListener(inputChars);
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
						}
					} else {
						CryptoExperimentController.this
								.getView()
								.getExplanations()
								.setText(
										"Your input is invalid. Please try another one!");
					}

				}
			}
		});
		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				// When switching back from demonstration to
				// experiment in the encryption phase, the variable will remain set to true when not
				// reset.
				if (CryptoExperimentController.this.decryptionPhase) {
					CryptoExperimentController.this.decryptionPhase = false;
				}
				// load next state.
				VisualizationContainerController containerController = (VisualizationContainerController) CryptoExperimentController.this
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
				if (!CryptoExperimentController.this.decryptionPhase) {
					int key = CryptoExperimentController.this.getModel()
							.generateKey();

					// unloadInOut();
					// start Decryption!
					CryptoExperimentController.this.decryptionPhase = true;
					char[] cipher = CryptoExperimentController.this
							.getModel()
							.enc(key,
									CryptoExperimentController.this.getModel()
											.genRandomPlainSequence())
							.toString().toCharArray();

					CryptoExperimentController.this
							.setEditableFields(cipher.length);
					CryptoExperimentController.this
							.getView()
							.setupCoreExperimentElements(
									cipher,
									key,
									CryptoExperimentController.this.getView().EXPERIMENT_MODE);

					// generate ActionListener.
					CryptoExperimentController.this.generateListener(cipher);

					// set the explanations.
					CryptoExperimentController.this
							.getView()
							.getExplanations()
							.setText(
									"<html><body>In the steps before you learned how to encrypt a given message.<br>"
											+ "But what does it help you to encrypt messages when noone can decrypt them?<br>"
											+ "Now we are going to help us by ourselves. Lets think logically. When we shift<br>"
											+ "a letter to 3 positions forwards, then we can get back to it when we shift the given<br>"
											+ "cipher 3 positions back! The important fact is also that we can shift up to 25 positions back<br>"
											+ "as we can shift 25 positions forward. Lets try this one. Remember: The key you added <br>"
											+ "while encrypting, now needs to be substracted!");
					CryptoExperimentController.this.getView().getNextButton()
							.setText("Go to histograms!");

				} else {
					// load the previous state.
					VisualizationContainerController containerController = (VisualizationContainerController) CryptoExperimentController.this
							.getParentController();
					containerController.presentNextVisualizationController();
				}
			}

		});

	}

	/**
	 * Method called when the input was correct.
	 */
	private void proceed() {

	}

	/**
	 * @param editableFields
	 *            the editableFields to set
	 */
	public void setEditableFields(int editableFields) {
		this.editableFields = editableFields;
	}

	/**
	 * 
	 */
	public void unloadInOut() {
		this.getView().remove(this.getView().getInOutPanel());
		this.getView().setInOutPanel(null);

	}

	@Override
	public void unloadView() {

	}

}
