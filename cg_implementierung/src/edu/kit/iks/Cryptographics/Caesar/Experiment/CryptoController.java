package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.MouseClickListener;
import edu.kit.iks.CryptographicsLib.Logger;

/**
 * Controller for the first and second step of the experiment phase. When user has to put input and
 * encrypt it and in the second step to decrypt a given cipher. Controls the needed elements from
 * CaesarUpperView, !!see CGeneralView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoController extends AbstractVisualizationController {

	/**
	 * Model that is needed for computations.
	 */
	private CryptoModel model;

	/**
	 * Needed
	 */
	private int editableFields;

	private boolean decryptionPhase = false;

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public CryptoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

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
						char[] string = getModel().getRandomPlainSequence()
								.toCharArray();
						int key = getModel().generateKey();
						setEditableFields(string.length);

						getView().start(string, key);

						generateListener(string);
					}
				});
		this.getView().getKey().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (getView().getInput().getBorder() != null
						&& getView().getInput().isEditable()) {
					getView().getInput().setBorder(null);

				}

				if (getView().getKeyboard() != null) {
					getView().remove(getView().getKeyboard());
					getView().setKeyboard(null);
					getView().validate();
					getView().repaint();
				}

				if (getView().getKey().isEditable()) {
					getView().getKey().setBorder(
							BorderFactory.createLineBorder(Color.blue, 5));
					getView().createKeyboard(getView().getKey(),
							KeyboardView.STRING_MODE);
				}
			}
		});
		this.getView().getKey().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getView().getKey().isEditable()) {
					try {
						// TODO: Need to take the explanation from other resources.
						String explanationContent = getView().getExplanations()
								.getText();
						int key = Integer
								.parseInt(getView().getKey().getText());

						if (getModel().isKeyValid(key)) {
							if ((getEditableFields() - 1) != 0) {
								getView()
										.getExplanations()
										.setText(
												explanationContent
														+ "<br>"
														+ "<br>This key is ok. Now put your name into the bigger box to the left.");
								getView().getKey().setBorder(
										BorderFactory
												.createLineBorder(Color.green));
								getView().getKey().setEditable(false);
								setEditableFields((getEditableFields() - 1));
								getView().getInput().requestFocus();
							} else {
								try {
									String input = getView().getInput()
											.getText();
									char[] inputChars = new char[input.length()];
									input.getChars(0, input.length(),
											inputChars, 0);
									setEditableFields(inputChars.length);
									getView().getKey().setBorder(null);

									// load the view!
									getView().start(inputChars, key);

									// Generate Listener for the userOutput JTextfield
									generateListener(inputChars);
								} catch (NumberFormatException e1) {
									Logger.e(e1);
								}
							}
						} else {
							getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This key is not valid. Please put a number between 1 and 25.<br>"
													+ "For demonstration purposes the keys between -1 and -25 are not necessary<br>"
													+ "therefore not possible, but could be used in general as keys too. And 0 as key has no<br>"
													+ " sense, if you dont understand why, then go back to Introduction.");
							getView().getKey().setBorder(
									BorderFactory.createLineBorder(Color.red));
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

				if (getView().getKey().getBorder() != null
						&& getView().getKey().isEditable()) {
					getView().getKey().setBorder(null);

				}

				if (getView().getKeyboard() != null) {
					getView().remove(getView().getKeyboard());
					getView().setKeyboard(null);
					getView().validate();
					getView().repaint();
				}

				if (getView().getInput().isEditable()) {
					getView().getInput().setBorder(
							BorderFactory.createLineBorder(Color.blue, 5));
					getView().createKeyboard(getView().getInput(),
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
				if (getView().getInput().isEditable()) {
					String explanationContent = getView().getExplanations()
							.getText();
					String input = getView().getInput().getText();

					if (getModel().isInputValid(input)) {
						if ((getEditableFields() - 1) != 0) {
							getView()
									.getExplanations()
									.setText(
											explanationContent
													+ "<br>"
													+ "<br>This input is ok. Now only the key is left.");
							getView()
									.getInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							getView().getInput().setEditable(false);
							setEditableFields((getEditableFields() - 1));
							getView().getKey().requestFocus();

						} else {

							// refactor the input into an character array.
							try {
								int key = Integer.parseInt(getView().getKey()
										.getText());
								char[] inputChars = new char[input.length()];
								input = input.toUpperCase();
								input.getChars(0, input.length(), inputChars, 0);
								setEditableFields(inputChars.length);
								getView().getKey().setBorder(null);

								// load the view!
								getView().start(inputChars, key);

								// Generate Listener for the userOutput JTextfield
								generateListener(inputChars);
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
						}
					} else {
						getView()
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
			public void actionPerformed(ActionEvent event) {
				// When switching back from demonstration to
				// experiment in the encryption phase, the variable will remain set to true when not
				// reset.
				if (decryptionPhase) {
					decryptionPhase = false;
				}
				// load next state.
				VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				if (!decryptionPhase) {
					int key = getModel().generateKey();

					// TODO: implement unloadView();
					// unloadInOut();
					// start Decryption!
					decryptionPhase = true;
					// TODO: generate a random cipher.
					char[] cipher = getModel()
							.enc(key, getModel().getRandomPlainSequence())
							.toString().toCharArray();

					setEditableFields(cipher.length);
					getView().start(cipher, key);

					// generate ActionListener.
					generateListener(cipher);

					// set the explanations.
					getView()
							.getExplanations()
							.setText(
									"<html><body>In the steps before you learned how to encrypt a given message.<br>"
											+ "But what does it help you to encrypt messages when noone can decrypt them?<br>"
											+ "Now we are going to help us by ourselves. Lets think logically. When we shift<br>"
											+ "a letter to 3 positions forwards, then we can get back to it when we shift the given<br>"
											+ "cipher 3 positions back! The important fact is also that we can shift up to 25 positions back<br>"
											+ "as we can shift 25 positions forward. Lets try this one. Remember: The key you added <br>"
											+ "while encrypting, now needs to be substracted!");
					getView().getNextButton().setText("Go to histograms!");

				} else {
					// load the previous state.
					VisualizationContainerController containerController = (VisualizationContainerController) getParentController();
					containerController.presentNextVisualizationController();
				}
			}

		});

	}

	/**
	 * 
	 */
	public void unloadInOut() {
		this.getView().remove(this.getView().getInOutPanel());
		this.getView().setInOutPanel(null);

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
			final JTextField userOutput = getView().getUserOutput()[i];

			getView().getUserOutput()[i].addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					// Nothing to do here.

				}

				@Override
				public void focusGained(FocusEvent e) {

					JTextField output = (JTextField) e.getSource();
					JTextField[] userOutput = getView().getUserOutput();

					for (JTextField outputIterator : userOutput) {

						if (outputIterator.getBorder() != null
								&& getView().getAlphabet() != null) {
							int charToEncryptAscii = (int) outputIterator
									.getName().charAt(0);
							AlphabetStripView viewAlphabet = getView()
									.getAlphabet();
							viewAlphabet.unHighlight(charToEncryptAscii
									- getModel().ASCII_UC_A);
							if (outputIterator.isEditable()) {
								outputIterator.setBorder(null);
							}
						} else {

						}
					}

					if (getView().getKeyboard() != null) {
						getView().remove(getView().getKeyboard());
						getView().setKeyboard(null);
						getView().validate();
						getView().repaint();
					}
					if (output.isEditable()) {
						// highlights the character in the alphabet.
						int charToEncryptAscii = (int) output.getName().charAt(
								0);
						AlphabetStripView viewAlphabet = getView()
								.getAlphabet();
						viewAlphabet.highlight(charToEncryptAscii
								- getModel().ASCII_UC_A);

						output.setBorder(BorderFactory.createLineBorder(
								Color.blue, 5));
						getView()
								.createKeyboard(output, KeyboardView.CHAR_MODE);
					}

				}
			});
			getView().getUserOutput()[i]
					.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (userOutput.isEditable()) {
								try {
									int key = Integer.parseInt(getView()
											.getKey().getText());
									
									// If the phase is decrypting use dec, else the phase is
									// encrypting, therefore use enc.
									String encryptedOrDecryptedcipher = "";
									if (decryptionPhase) {
										encryptedOrDecryptedcipher = getModel()
												.dec(key, userOutput.getName());
									} else {
										encryptedOrDecryptedcipher = getModel()
												.enc(key, userOutput.getName());
									}
									
									if ((encryptedOrDecryptedcipher)
											.equals(userOutput.getText())) {
									
										if ((getEditableFields() - 1) != 0) {
											
											// user encrypted the given char successful.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											userOutput.setEditable(false);
											setEditableFields(getEditableFields() - 1);
											getView()
													.getExplanations()
													.setText(
															getModel()
																	.genRandomGrats()
																	+ " You have "
																	+ getEditableFields()
																	+ " left!");
											getView().getUserOutput()[getView()
													.getUserOutput().length
													- getEditableFields()]
													.requestFocus();
										} else {
											// User encrypted all characters valid.
											userOutput.setBorder(BorderFactory
													.createLineBorder(Color.green));
											getView().requestFocus();
											userOutput.setEditable(false);
											getView()
													.getAlphabet()
													.unHighlight(
															userOutput
																	.getName()
																	.charAt(0)
																	- getModel().ASCII_UC_A);
											getView()
													.getExplanations()
													.setText(
															"<html><body>All done right!!!"
																	+ getModel()
																			.genRandomGrats()
																	+ " Now you are one step more to destroying the capitalism!<br>"
																	+ "Next step is to decrypt a given message!! When you accomplish it, then even the NSA and Kryptochef together<br>"
																	+ "are superior to your power!");
										}
									} else {
										// User encrypted invalid! Need another try.
										userOutput.setBorder(BorderFactory
												.createLineBorder(Color.red));
										getView().getExplanations().setText(
												getModel().genRandomBlamings());
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
	 * Method for delegating user's input to the model for the needed computations and checks.
	 * 
	 * @param input
	 */
	public void delegateAndHandleInput(String input) {
		if (this.model.isInputValid(input))
			proceed();
	}

	@Override
	public void unloadView() {

	}

	@Override
	public String getHelp() {
		return "If you only see the textfield then put your string in it. Else you've already "
				+ "done it and now you need to encrypt/decrypt the given String.";
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
	 * @return the model
	 */
	public CryptoModel getModel() {
		return model;
	}

	/**
	 * Method called when the input was correct.
	 */
	private void proceed() {

	}

	/**
	 * @return the editableFields
	 */
	public int getEditableFields() {
		return editableFields;
	}

	/**
	 * @param editableFields
	 *            the editableFields to set
	 */
	public void setEditableFields(int editableFields) {
		this.editableFields = editableFields;
	}

	/**
	 * @return the decryptionPhase
	 */
	public boolean isDecryptionPhase() {
		return decryptionPhase;
	}

}
