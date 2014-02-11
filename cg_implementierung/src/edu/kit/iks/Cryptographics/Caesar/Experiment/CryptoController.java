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
public class CryptoController extends AbstractVisualizationController {

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
	public CryptoController(AbstractVisualizationInfo visualizationInfo) {
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
							JTextField[] userOutput = CryptoController.this
									.getView().getUserOutput();

							for (JTextField outputIterator : userOutput) {

								if (outputIterator.getBorder() != null
										&& CryptoController.this.getView()
												.getAlphabet() != null) {
									int charToEncryptAscii = outputIterator
											.getName().charAt(0);
									AlphabetStripView viewAlphabet = CryptoController.this
											.getView().getAlphabet();
									viewAlphabet.unHighlight(charToEncryptAscii
											- CryptoController.this.getModel().ASCII_UC_A);
									if (outputIterator.isEditable()) {
										outputIterator.setBorder(null);
									}
								} else {

								}
							}

							if (CryptoController.this.getView().getKeyboard() != null) {
								CryptoController.this.getView().remove(
										CryptoController.this.getView()
												.getKeyboard());
								CryptoController.this.getView().setKeyboard(
										null);
								CryptoController.this.getView().validate();
								CryptoController.this.getView().repaint();
							}
							if (output.isEditable()) {
								// highlights the character in the alphabet.
								int charToEncryptAscii = output.getName()
										.charAt(0);
								AlphabetStripView viewAlphabet = CryptoController.this
										.getView().getAlphabet();
								viewAlphabet.highlight(charToEncryptAscii
										- CryptoController.this.getModel().ASCII_UC_A);

								output.setBorder(BorderFactory
										.createLineBorder(Color.blue, 5));
								CryptoController.this.getView().createKeyboard(
										output, KeyboardView.CHAR_MODE);
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
											.parseInt(CryptoController.this
													.getView().getKey()
													.getText());

									// If the phase is decrypting use dec, else the phase is
									// encrypting, therefore use enc.
									String encryptedOrDecryptedcipher = "";
									if (CryptoController.this.decryptionPhase) {
										encryptedOrDecryptedcipher = CryptoController.this
												.getModel().dec(key,
														userOutput.getName());
									} else {
										encryptedOrDecryptedcipher = CryptoController.this
												.getModel().enc(key,
														userOutput.getName());
									}

									if ((encryptedOrDecryptedcipher)
											.equals(userOutput.getText())) {

										if ((CryptoController.this
												.getEditableFields() - 1) != 0) {

											// user encrypted the given char successful.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											userOutput.setEditable(false);
											CryptoController.this
													.setEditableFields(CryptoController.this
															.getEditableFields() - 1);
											CryptoController.this
													.getView()
													.getExplanations()
													.setText(
													// getView()
													// .getExplanations()
													// .getText()
													// + "<br> "
													// + "<br>"
															CryptoController.this
																	.getModel()
																	.genRandomGrats()
																	+ "You have "
																	+ CryptoController.this
																			.getEditableFields()
																	+ " left!");
											CryptoController.this.getView()
													.getUserOutput()[CryptoController.this
													.getView().getUserOutput().length
													- CryptoController.this
															.getEditableFields()]
													.requestFocus();
										} else {
											// User encrypted all characters valid.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											CryptoController.this.getView()
													.requestFocus();
											userOutput.setEditable(false);
											CryptoController.this
													.getView()
													.getAlphabet()
													.unHighlight(
															userOutput
																	.getName()
																	.charAt(0)
																	- CryptoController.this
																			.getModel().ASCII_UC_A);
											CryptoController.this
													.getView()
													.getExplanations()
													.setText(
															"<html><body>All done right! "
																	+ CryptoController.this
																			.getModel()
																			.genRandomGrats()
																	+ " Next step is to decrypt a given message!! When you accomplish it, then even the NSA and Kryptochef together<br>"
																	+ "are superior to your power. Now lets move on. Click the button in the right top corner.");
											CryptoController.this
													.getView()
													.remove(CryptoController.this
															.getView()
															.getKeyboard());
											CryptoController.this.getView()
													.setKeyboard(null);
											CryptoController.this.getView()
													.validate();
											CryptoController.this.getView()
													.repaint();

										}
									} else {
										// User encrypted invalid! Need another try.
										userOutput.setBorder(BorderFactory
												.createLineBorder(Color.red));
										CryptoController.this
												.getView()
												.getExplanations()
												.setText(
														CryptoController.this
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
	public CryptoView getView() {
		return (CryptoView) this.view;
	}

	/**
	 * @return the decryptionPhase
	 */
	public boolean isDecryptionPhase() {
		return this.decryptionPhase;
	}

	@Override
	public void loadView() {
		this.view = new CryptoView();
		this.model = CryptoModel.getInstance();
		this.editableFields = 2;

		// Create all needed ActionListener.
		this.getView().getGenerator()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						char[] string = CryptoController.this.getModel()
								.genRandomPlainSequence().toCharArray();
						int key = CryptoController.this.getModel()
								.generateKey();
						CryptoController.this.setEditableFields(string.length);

						CryptoController.this.getView().start(string, key);

						CryptoController.this.generateListener(string);
					}
				});
		this.getView().getKey().addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (CryptoController.this.getView().getInput().getBorder() != null
						&& CryptoController.this.getView().getInput()
								.isEditable()) {
					CryptoController.this.getView().getInput().setBorder(null);

				}

				if (CryptoController.this.getView().getKeyboard() != null) {
					CryptoController.this.getView().remove(
							CryptoController.this.getView().getKeyboard());
					CryptoController.this.getView().setKeyboard(null);
					CryptoController.this.getView().validate();
					CryptoController.this.getView().repaint();
				} else if (CryptoController.this.getView().getNumpad() != null) {
					CryptoController.this.getView().remove(
							CryptoController.this.getView().getNumpad());
					CryptoController.this.getView().setNumpad(null);
					CryptoController.this.getView().validate();
					CryptoController.this.getView().repaint();
				}

				if (CryptoController.this.getView().getKey().isEditable()) {
					CryptoController.this
							.getView()
							.getKey()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoController.this.getView().createNumpad(
							CryptoController.this.getView().getKey());
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
				if (CryptoController.this.getView().getKey().isEditable()) {
					try {
						String explanationContent = CryptoController.this
								.getView().getExplanations().getText();
						int key = Integer.parseInt(CryptoController.this
								.getView().getKey().getText());

						if (CryptoController.this.getModel().isKeyValid(key)) {
							if ((CryptoController.this.getEditableFields() - 1) != 0) {
								CryptoController.this
										.getView()
										.getExplanations()
										.setText(
												explanationContent
														+ "<br>"
														+ "<br>This key is ok. Now put your name into the bigger box to the left.");
								CryptoController.this
										.getView()
										.getKey()
										.setBorder(
												BorderFactory
														.createLineBorder(Color.green));
								CryptoController.this.getView().getKey()
										.setEditable(false);
								CryptoController.this
										.setEditableFields((CryptoController.this
												.getEditableFields() - 1));
								CryptoController.this.getView().getInput()
										.requestFocus();
							} else {
								try {
									String input = CryptoController.this
											.getView().getInput().getText();
									char[] inputChars = new char[input.length()];
									input.getChars(0, input.length(),
											inputChars, 0);
									CryptoController.this
											.setEditableFields(inputChars.length);
									CryptoController.this.getView().getKey()
											.setBorder(null);

									// load the view!
									CryptoController.this.getView().start(
											inputChars, key);

									// Generate Listener for the userOutput JTextfield
									CryptoController.this
											.generateListener(inputChars);
								} catch (NumberFormatException e1) {
									Logger.e(e1);
								}
							}
						} else {
							CryptoController.this
									.getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This key is not valid. Please put a number between 1 and 25.<br>"
													+ "For demonstration purposes the keys between -1 and -25 are not necessary<br>"
													+ "therefore not possible, but could be used in general as keys too. And 0 as key has no<br>"
													+ " sense, if you dont understand why, then go back to Introduction.");
							CryptoController.this
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

				if (CryptoController.this.getView().getKey().getBorder() != null
						&& CryptoController.this.getView().getKey()
								.isEditable()) {
					CryptoController.this.getView().getKey().setBorder(null);

				}

				if (CryptoController.this.getView().getKeyboard() != null) {
					CryptoController.this.getView().remove(
							CryptoController.this.getView().getKeyboard());
					CryptoController.this.getView().setKeyboard(null);
					CryptoController.this.getView().validate();
					CryptoController.this.getView().repaint();
				} else if (CryptoController.this.getView().getNumpad() != null) {
					CryptoController.this.getView().remove(
							CryptoController.this.getView().getNumpad());
					CryptoController.this.getView().setNumpad(null);
					CryptoController.this.getView().validate();
					CryptoController.this.getView().repaint();
				}


				if (CryptoController.this.getView().getInput().isEditable()) {
					CryptoController.this
							.getView()
							.getInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoController.this.getView().createKeyboard(
							CryptoController.this.getView().getInput(),
							KeyboardView.STRING_MODE);
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
				if (CryptoController.this.getView().getInput().isEditable()) {
					String explanationContent = CryptoController.this.getView()
							.getExplanations().getText();
					String input = CryptoController.this.getView().getInput()
							.getText();

					if (CryptoController.this.getModel().isInputValid(input)) {
						if ((CryptoController.this.getEditableFields() - 1) != 0) {
							CryptoController.this
									.getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This input is ok. Now only the key is left.");
							CryptoController.this
									.getView()
									.getInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							CryptoController.this.getView().getInput()
									.setEditable(false);
							CryptoController.this
									.setEditableFields((CryptoController.this
											.getEditableFields() - 1));
							CryptoController.this.getView().getKey()
									.requestFocus();

						} else {

							// refactor the input into an character array.
							try {
								int key = Integer
										.parseInt(CryptoController.this
												.getView().getKey().getText());
								char[] inputChars = new char[input.length()];
								input = input.toUpperCase();
								input.getChars(0, input.length(), inputChars, 0);
								CryptoController.this
										.setEditableFields(inputChars.length);
								CryptoController.this.getView().getKey()
										.setBorder(null);

								// load the view!
								CryptoController.this.getView().start(
										inputChars, key);

								// Generate Listener for the userOutput JTextfield
								CryptoController.this
										.generateListener(inputChars);
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
						}
					} else {
						CryptoController.this
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
				if (CryptoController.this.decryptionPhase) {
					CryptoController.this.decryptionPhase = false;
				}
				// load next state.
				VisualizationContainerController containerController = (VisualizationContainerController) CryptoController.this
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
				if (!CryptoController.this.decryptionPhase) {
					int key = CryptoController.this.getModel().generateKey();

					// unloadInOut();
					// start Decryption!
					CryptoController.this.decryptionPhase = true;
					char[] cipher = CryptoController.this
							.getModel()
							.enc(key,
									CryptoController.this.getModel()
											.genRandomPlainSequence())
							.toString().toCharArray();

					CryptoController.this.setEditableFields(cipher.length);
					CryptoController.this.getView().start(cipher, key);

					// generate ActionListener.
					CryptoController.this.generateListener(cipher);

					// set the explanations.
					CryptoController.this
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
					CryptoController.this.getView().getNextButton()
							.setText("Go to histograms!");

				} else {
					// load the previous state.
					VisualizationContainerController containerController = (VisualizationContainerController) CryptoController.this
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
