package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
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
 * {@link CryptoExperimentView}
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoExperimentController extends AbstractVisualizationController {

	/**
	 * localization.
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			CryptoExperimentController.class);

	/**
	 * Indicates what phase of the experiment currently is.
	 */
	private boolean decryptionPhase = false;

	/**
	 * When 0 user has finished the experiment successfully.
	 */
	private int editableFields;

	/**
	 * Model of this controller.
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
	
	@Override
	public String getHelp() {
		return CryptoExperimentController.i18n
				.tr("If you only see the textfield then put your string in it. Else you've already "
						+ "done it and now you need to encrypt/decrypt the given String.");
	}

	@Override
	public void loadView() {
		this.view = new CryptoExperimentView();
		this.model = CryptoModel.getInstance();
		// set the initial value.
		this.editableFields = 2;

		// Create all needed ActionListener.
		this.generateGeneratorButtonActionListener();

		// generate listener for the textfield of the key.
		this.generateKeyInputFocusListener();
		this.generateKeyInputActionListener();

		// generate listener for the literal input textfield.
		this.generateLiteralInputFocusListener();
		this.generateLiteralInputActionListener();

		// Listener for Back/next buttons.
		this.generateNavigationListener();

	}

	// ------------------------------------------------------------------//
	// --------------------private methods-------------------------------//
	/**
	 * Function for generating ActionListener for the needed input fields, after the user typed a
	 * string to encrypt.
	 * 
	 * @param inputChars
	 */
	private void generateIOListener(char[] inputChars) {
		// Generate Listener for the userOutput JTextfield
		for (int i = 0; i < inputChars.length; i++) {

			// Needed for delegating to the inner type ActionListener, when the actionEvent from the
			// Button "ENTER" on the KEayboard is fired.
			final JTextField userOutput = this.getView().getUserOutput()[i];

			this.generateUserOutputFocusListener(i);
			this.generateUserOutputActionListener(i, userOutput);
		}
	}

	private void generateUserOutputActionListener(int i,
			final JTextField userOutput) {
		this.getView().getUserOutput()[i]
				.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (userOutput.isEditable()) {
							int key = 0;
							try {
								key = Integer
										.parseInt(CryptoExperimentController.this
												.getView().getKeyInput()
												.getText());
							} catch (NumberFormatException e1) {
								Logger.e(e1);
							}
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

							if ((encryptedOrDecryptedcipher).equals(userOutput
									.getText())) {

								// user encrypted/decrypted correctly.
								if ((CryptoExperimentController.this
										.getEditableFields() - 1) != 0) {

									// still some editabe fields left.
									CryptoExperimentController.this
											.notifyUserValidAction(userOutput);
								} else {
									// User encrypted all characters valid.
									CryptoExperimentController.this
											.notifyUserFinishedExperiment(userOutput);
								}
							} else {
								// User encrypted invalid! Need another try.
								CryptoExperimentController.this
										.notifyUserInvalidAction(userOutput);
							}

						}
					}

				});
	}

	private void notifyUserInvalidAction(JTextField userOutput) {
		userOutput.setBorder(BorderFactory.createLineBorder(Color.red));
		this.getView().getExplanations()
				.setText(this.getModel().genRandomBlamings());
	}

	private void notifyUserFinishedExperiment(JTextField userOutput) {
		userOutput.setBorder(BorderFactory.createLineBorder(Color.green));
		this.getView().requestFocus();
		userOutput.setEditable(false);
		this.getView()
				.getAlphabet()
				.unHighlight(
						userOutput.getName().charAt(0)
								- this.getModel().ASCII_UC_A);
		this.getView()
				.getExplanations()
				.setText(
						this.wrapHtml(CryptoExperimentController.i18n
								.tr("All done right!")
								+ " "
								+ this.getModel().genRandomGrats()
								+ " "
								+ CryptoExperimentController.i18n
										.tr("Next step is to decrypt a given message!! When you accomplish it, then even the NSA and Kryptochef together<br>"
												+ "are superior to your power. Now lets move on. Click the button in the right top corner.")));
		this.getView().removeKeyboard();
	}

	private void notifyUserValidAction(JTextField userOutput) {
		userOutput.setBorder(BorderFactory.createLineBorder(Color.green));
		userOutput.setEditable(false);
		this.setEditableFields(this.getEditableFields() - 1);
		this.getView()
				.getExplanations()
				.setText(
						this.getModel().genRandomGrats()
								+ " "
								+ CryptoExperimentController.i18n.trn(
										"You have {0} left!",
										"You have {0} left!",
										this.getEditableFields(),
										this.getEditableFields()));
		this.getView().getUserOutput()[CryptoExperimentController.this
				.getView().getUserOutput().length - this.getEditableFields()]
				.requestFocus();
	}

	private void generateUserOutputFocusListener(int i) {
		this.getView().getUserOutput()[i].addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				JTextField output = (JTextField) e.getSource();

				CryptoExperimentController.this.resetUnfocusedTextfield();

				if (CryptoExperimentController.this.getView().getKeyboard() != null) {
					CryptoExperimentController.this.getView().removeKeyboard();
				}
				if (output.isEditable()) {
					// highlights the character in the alphabet.
					CryptoExperimentController.this.highlightUserFocus(output);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.

			}
		});
	}

	private void highlightUserFocus(JTextField output) {
		int charToEncryptAscii = output.getName().charAt(0);
		AlphabetStripView viewAlphabet = CryptoExperimentController.this
				.getView().getAlphabet();
		viewAlphabet.highlight(charToEncryptAscii
				- CryptoExperimentController.this.getModel().ASCII_UC_A);

		output.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
		CryptoExperimentController.this.getView().createKeyboard(output,
				KeyboardView.CHAR_MODE);
	}

	private void resetUnfocusedTextfield() {
		for (JTextField outputIterator : this.getView().getUserOutput()) {

			if (outputIterator.getText() != null
					&& this.getView().getAlphabet() != null) {
				int charToEncryptAscii = outputIterator.getName().charAt(0);
				AlphabetStripView viewAlphabet = this.getView().getAlphabet();
				viewAlphabet.unHighlight(charToEncryptAscii
						- this.getModel().ASCII_UC_A);
				if (outputIterator.isEditable()) {
					outputIterator.setBorder(BorderFactory
							.createLineBorder(Color.darkGray));
				}
			}
		}
	}

	private void generateNavigationListener() {
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

					// start Decryption!
					if (CryptoExperimentController.this.getView().getKeyboard() != null) {
						CryptoExperimentController.this.getView()
								.removeKeyboard();
					}
					CryptoExperimentController.this.decryptionPhase = true;
					char[] cipher = CryptoExperimentController.this
							.getModel()
							.enc(key,
									CryptoExperimentController.this.getModel()
											.genRandomPlainSequence())
							.toString().toCharArray();

					CryptoExperimentController.this.prepareExperimentPhase(key,
							cipher);

					// set the explanations.
					CryptoExperimentController.this
							.getView()
							.getExplanations()
							.setText(
									CryptoExperimentController.this
											.wrapHtml(CryptoExperimentController.i18n
													.tr("In the steps before you learned how to encrypt a given message.<br>"
															+ "But what does it help you to encrypt messages when noone can decrypt them?<br>"
															+ "Now we are going to help us by ourselves. Lets think logically. When we shift<br>"
															+ "a letter to 3 positions forwards, then we can get back to it when we shift the given<br>"
															+ "cipher 3 positions back! The important fact is also that we can shift up to 25 positions back<br>"
															+ "as we can shift 25 positions forward. Lets try this one. Remember: The key you added <br>"
															+ "while encrypting, now needs to be substracted!")));
					CryptoExperimentController.this
							.getView()
							.getNextButton()
							.setText(
									CryptoExperimentController.i18n
											.tr("Go to histograms"));

				} else {
					// load the previous state.
					VisualizationContainerController containerController = (VisualizationContainerController) CryptoExperimentController.this
							.getParentController();
					containerController.presentNextVisualizationController();
				}
			}

		});
	}

	private void generateLiteralInputActionListener() {
		this.getView().getLiteralInput()
				.addActionListener(new ActionListener() {

					/*
					 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
					 * ActionEvent)
					 */
					@Override
					public void actionPerformed(ActionEvent e) {
						if (CryptoExperimentController.this.getView()
								.getLiteralInput().isEditable()) {

							// input possible.
							String explanationContent = CryptoExperimentController.this
									.getView().getExplanations().getText();
							String input = CryptoExperimentController.this
									.getView().getLiteralInput().getText();

							if (CryptoExperimentController.this.getModel()
									.isInputValid(input)) {
								// input is valid.
								if ((CryptoExperimentController.this
										.getEditableFields() - 1) != 0) {
									// for proceeding key input is needed.
									CryptoExperimentController.this
											.notifyUserValidLiteralInput(explanationContent);

								} else {
									// it was the last needed input.
									int key = 0;
									try {
										key = Integer
												.parseInt(CryptoExperimentController.this
														.getView()
														.getKeyInput()
														.getText());
									} catch (NumberFormatException e1) {
										e1.printStackTrace();
									}

									// refactor the input into an character array.
									char[] inputChars = new char[input.length()];
									input.getChars(0, input.length(),
											inputChars, 0);
									CryptoExperimentController.this.getView()
											.getKeyInput().setBorder(null);
									CryptoExperimentController.this.getView()
											.removeKeyboard();
									CryptoExperimentController.this
											.prepareExperimentPhase(key,
													inputChars);

								}
							} else {
								CryptoExperimentController.this
										.getView()
										.getExplanations()
										.setText(
												CryptoExperimentController.i18n
														.tr("Your input is invalid. Please try another one!"));
							}

						}
					}
				});
	}

	private void notifyUserValidLiteralInput(String explanationContent) {
		this.getView()
				.getExplanations()
				.setText(
						explanationContent
								+ "<br>"
								+ CryptoExperimentController.i18n
										.tr("This input is ok. Now only the key is left."));
		this.getView().getLiteralInput()
				.setBorder(BorderFactory.createLineBorder(Color.green));
		this.getView().getLiteralInput().setEditable(false);
		this.setEditableFields((this.getEditableFields() - 1));
		this.getView().getKeyInput().requestFocus();
	}

	private void generateGeneratorButtonActionListener() {
		this.getView().getGenerator()
				.addMouseListener(new MouseClickListener() {
					@Override
					public void clicked(MouseEvent e) {
						if (CryptoExperimentController.this.getView()
								.getNumpad() != null) {
							CryptoExperimentController.this.getView()
									.removeNumpad();
						}

						// make some preparations.
						char[] generatedCharacters = CryptoExperimentController.this
								.getModel().genRandomPlainSequence()
								.toCharArray();
						int key = CryptoExperimentController.this.getModel()
								.generateKey();
						CryptoExperimentController.this.prepareExperimentPhase(
								key, generatedCharacters);
					}
				});
	}

	private void generateLiteralInputFocusListener() {
		this.getView().getLiteralInput().addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (CryptoExperimentController.this.getView().getKeyInput()
						.getBorder() != null
						&& CryptoExperimentController.this.getView()
								.getKeyInput().isEditable()) {
					CryptoExperimentController.this.getView().getKeyInput()
							.setBorder(null);

				}

				if (CryptoExperimentController.this.getView().getKeyboard() != null) {
					CryptoExperimentController.this.getView().removeKeyboard();
				} else if (CryptoExperimentController.this.getView()
						.getNumpad() != null) {
					CryptoExperimentController.this.getView().removeNumpad();
				}

				if (CryptoExperimentController.this.getView().getLiteralInput()
						.isEditable()) {
					CryptoExperimentController.this
							.getView()
							.getLiteralInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoExperimentController.this.getView().createKeyboard(
							CryptoExperimentController.this.getView()
									.getLiteralInput(),
							KeyboardView.STRING_MODE);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}
		});
	}

	private void generateKeyInputActionListener() {
		this.getView().getKeyInput().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (CryptoExperimentController.this.getView().getKeyInput()
						.isEditable()) {
					// input still possible.
					String explanationContent = CryptoExperimentController.this
							.getView().getExplanations().getText();
					if (CryptoExperimentController.this.getView().getKeyInput()
							.getText().length() > 0) {
						int key = 0;
						try {
							key = Integer
									.parseInt(CryptoExperimentController.this
											.getView().getKeyInput().getText());
						} catch (NumberFormatException e1) {
							Logger.e(e1);
						}

						if (CryptoExperimentController.this.getModel()
								.isKeyValid(key)) {
							// User typed a valid key.
							if ((CryptoExperimentController.this
									.getEditableFields() - 1) != 0) {
								// Only literal input needed. Notify the user.
								CryptoExperimentController.this
										.notifyOfValidKey(explanationContent);
							} else {
								CryptoExperimentController.this.getView()
										.removeNumpad();
								// The key was the last needed input. Start Experiment with the
								// input values.
								String input = CryptoExperimentController.this
										.getView().getLiteralInput().getText();
								char[] inputChars = new char[input.length()];
								input.getChars(0, input.length(), inputChars, 0);
								CryptoExperimentController.this
										.prepareExperimentPhase(key, inputChars);
							}
						} else {
							CryptoExperimentController.this
									.getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ CryptoExperimentController.i18n
															.tr("This key is not valid. Please put a number between 1 and 25.<br>"
																	+ "For demonstration purposes the keys between -1 and -25 are not necessary<br>"
																	+ "therefore not possible, but could be used in general as keys too. And 0 as key has no<br>"
																	+ " sense, if you dont understand why, then go back to Introduction."));
							CryptoExperimentController.this
									.getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.red));
						}
					} else {
						CryptoExperimentController.this
								.getView()
								.getExplanations()
								.setText(
										explanationContent
												+ "<br>"
												+ CryptoExperimentController.i18n
														.tr("The key field is empty!"));
						CryptoExperimentController.this
								.getView()
								.getKeyInput()
								.setBorder(
										BorderFactory
												.createLineBorder(Color.red));
					}
				}
			}
		});
	}

	private void prepareExperimentPhase(int key, char[] input) {

		this.setEditableFields(input.length);

		// load the view!
		this.getView().setupExperimentCore(input, key);

		// Generate Listener for the userOutput JTextfield
		this.generateIOListener(input);
	}

	private void notifyOfValidKey(String explanationContent) {
		this.getView()
				.getExplanations()
				.setText(
						explanationContent
								+ "<br>"
								+ CryptoExperimentController.i18n
										.tr("This key is ok. Now put your name into the bigger box to the left."));
		this.getView().getKeyInput()
				.setBorder(BorderFactory.createLineBorder(Color.green));
		this.getView().getKeyInput().setEditable(false);
		this.setEditableFields((this.getEditableFields() - 1));
		this.getView().getLiteralInput().requestFocus();
	}

	private void generateKeyInputFocusListener() {
		this.getView().getKeyInput().addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				if (CryptoExperimentController.this.getView().getLiteralInput()
						.getBorder() != null
						&& CryptoExperimentController.this.getView()
								.getLiteralInput().isEditable()) {
					CryptoExperimentController.this.getView().getLiteralInput()
							.setBorder(null);

				}

				if (CryptoExperimentController.this.getView().getKeyboard() != null) {
					CryptoExperimentController.this.getView().removeKeyboard();
				} else if (CryptoExperimentController.this.getView()
						.getNumpad() != null) {
					CryptoExperimentController.this.getView().removeNumpad();
				}

				if (CryptoExperimentController.this.getView().getKeyInput()
						.isEditable()) {
					CryptoExperimentController.this
							.getView()
							.getKeyInput()
							.setBorder(
									BorderFactory.createLineBorder(Color.blue,
											5));
					CryptoExperimentController.this.getView().createNumpad(
							CryptoExperimentController.this.getView()
									.getKeyInput());
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}
		});
	}

	/**
	 * @return the editableFields
	 */
	public int getEditableFields() {
		return this.editableFields;
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
		this.getView().remove(this.getView().userCharacterIOContainer());
		this.getView().setInOutPanel(null);

	}

	@Override
	public void unloadView() {

	}

	private String wrapHtml(String text) {
		return "<html><body>" + text + "</body></html>";
	}
}
