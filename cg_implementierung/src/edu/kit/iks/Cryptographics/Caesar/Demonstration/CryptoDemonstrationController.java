package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoModel;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.KeyboardView;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

/**
 * Controller for the last step of demonstration phase. Controls the needed elements from
 * {@link CryptoDemonstrationView}
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoDemonstrationController extends
		AbstractVisualizationController {

	/**
	 * localization.
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			CryptoDemonstrationController.class);

	/**
	 * Identicates the step of the demonstration.
	 */
	private int demonstrationStep;

	/**
	 * Indicates how much fields left to edit.
	 */
	private int editableFields;

	/**
	 * The model of this controller.
	 */
	private CryptoModel model;

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public CryptoDemonstrationController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public void loadView() {
		this.view = new CryptoDemonstrationView();
		this.model = CryptoModel.getInstance();
		// set the initial first step.
		this.demonstrationStep = 1;

		// generate ActionListener for the navigationButtons.
		this.generateNavigationListener();

		// generate ActionListener for the forwarding button proceed.
		this.generateProceedListener();

		for (int i = 1; i < this.getView().getUserOutput().length; i++) {
			// Needed for delegating to the inner type ActionListener, when the actionEvent from the
			// Button "ENTER" on the Keyboard is fired.
			final JTextField userOutput = this.getView().getUserOutput()[i];
			// FocusListener for the textfields.
			this.generateUserOutputFocusListener(i, userOutput);
			// actionListener for the textfields.
			this.generateUserOutputActionListener(i, userOutput);
		}

		this.getView().validate();
	}

	/**
	 * Gets the view
	 * 
	 * @return The view of this controller
	 */
	@Override
	public CryptoDemonstrationView getView() {
		return (CryptoDemonstrationView) this.view;
	}

	// ---------------------------------------------------------//
	// -----------------private methods-------------------------//

	/**
	 * Function for performing the needed demonstration. After each step the demonstration stops and
	 * continues when user wishes.
	 * 
	 * @param step
	 *            {@link demonstrationStep}
	 */
	private void demonstrate(int step) {
		switch (step) {
		case 1:
			this.step1();
			break;
		case 2:
			this.step2();
			break;
		case 3:
			this.step3();
			break;
		default:
           
		}

	}
	
	private void generateUserOutputActionListener(int i,
			final JTextField userOutput) {
		this.getView().getUserOutput()[i]
				.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (userOutput.isEditable()) {
							// standart key for the caesar cipher. +3 when encrypting. -3 when
							// decrypting.
							if (CryptoDemonstrationController.this.getModel()
									.enc(3, userOutput.getName())
									.equals(userOutput.getText())) {

								// user encrypted the given char successful.
								CryptoDemonstrationController.this
										.presentSuccessfullCharEncrypt(userOutput);

								if (CryptoDemonstrationController.this
										.getEditableFields() == 0
										&& CryptoDemonstrationController.this
												.getAnimationStep() == 4) {

									// User encrypted all characters valid.
									CryptoDemonstrationController.this
											.getView()
											.getExplanations()
											.setText(
													CryptoDemonstrationController.this
															.wrapHtml(CryptoDemonstrationController.i18n
																	.tr("Great work oh mighty Caesar. May your enemies shutter over your intelligence.")));
									// remove all unnecessary elements.
									//TODO: make removeAlphabet protected in the upper class of the view.
									CryptoDemonstrationController.this
											.getView().removeAlphabet();
									CryptoDemonstrationController.this
											.presentFinish();
									CryptoDemonstrationController.this
											.getView().removeKeyboard();

								} else if (CryptoDemonstrationController.this
										.getEditableFields() == 0
										&& CryptoDemonstrationController.this
												.getAnimationStep() == 3) {

									// User has to encrypt the last 3 fields.
									CryptoDemonstrationController.this
											.prepareNextToLastStep(userOutput);
									CryptoDemonstrationController.this
											.getView()
											.getExplanations()
											.setText(
													CryptoDemonstrationController.this
															.wrapHtml(CryptoDemonstrationController.i18n
																	.tr("Very nice! Lets encrypt the rest of this childish challenge.")));
								} else {
									// User encrypted correctly the given char.
									CryptoDemonstrationController.this
											.getView()
											.getExplanations()
											.setText(
													CryptoDemonstrationController.this
															.getModel()
															.genRandomGrats()
															+ " "
															+ CryptoDemonstrationController.i18n
																	.trn("Only {0} left.",
																			"Only {0} left.",
																			CryptoDemonstrationController.this
																					.getEditableFields(),
																			CryptoDemonstrationController.this
																					.getEditableFields()));
									// The next textfield to the right requests now the focus.
									CryptoDemonstrationController.this
											.getView().getUserOutput()[CryptoDemonstrationController.this
											.getView().getUserOutput().length
											- CryptoDemonstrationController.this
													.getEditableFields()]
											.requestFocus();
								}
							} else {
								// User didn't encrypt correctly.
								userOutput.setBorder(BorderFactory
										.createLineBorder(Color.red));
								userOutput.setText("");
								CryptoDemonstrationController.this
										.getView()
										.getExplanations()
										.setText(
												CryptoDemonstrationController.this
														.getModel()
														.genRandomBlamings());
								userOutput.requestFocus();
							}
						}
					}
				});
	}

	private void generateUserOutputFocusListener(int i,
			final JTextField userOutput) {
		this.getView().getUserOutput()[i].addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				JTextField output = (JTextField) e.getSource();
				// resets the highlighting.
				CryptoDemonstrationController.this.resetStateOfIOFields();

				if (CryptoDemonstrationController.this.getView().getKeyboard() != null) {
					// remove the keyboard.
					CryptoDemonstrationController.this.getView()
							.removeKeyboard();
				}
				if (output.isEditable()) {
					// highlights the character in the alphabet.
					CryptoDemonstrationController.this
							.highlightInputField(userOutput);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Nothing to do here.
			}
		});
	}

	private void generateProceedListener() {
		this.getView().getProceed().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
				CryptoDemonstrationController.this
						.demonstrate(CryptoDemonstrationController.this
								.getAnimationStep());
			}
		});

	}

	private void generateNavigationListener() {
		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) CryptoDemonstrationController.this
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
				VisualizationContainerController containerController = (VisualizationContainerController) CryptoDemonstrationController.this
						.getParentController();
				containerController.presentNextVisualizationController();
			}
		});
	}

	private void prepareNextToLastStep(JTextField userOutput) {
		this.getView().requestFocus();
		this.getView().removeKeyboard();
		this.getView().getProceed().setVisible(true);
		this.getView()
				.getAlphabet()
				.unHighlight(
						userOutput.getName().charAt(0)
								- this.getModel().ASCII_UC_A);
	}

	private void presentSuccessfullCharEncrypt(JTextField userOutput) {
		userOutput.setBorder(BorderFactory.createLineBorder(Color.green));
		this.setEditableFields(this.getEditableFields() - 1);
		userOutput.setEditable(false);
	}

	private void presentFinish() {
		this.getView().getNavigationPanel()
				.remove(this.getView().getNextButton());
		GridBagConstraints nextConst = new GridBagConstraints();
		nextConst.anchor = GridBagConstraints.CENTER;
		nextConst.weightx = 1.0;
		nextConst.weighty = 0.1;
		nextConst.gridx = 1;
		nextConst.gridy = 1;
		nextConst.gridwidth = 26;
		nextConst.gridheight = 2;
		this.getView().add(this.getView().getNextButton(), nextConst);

		this.getView().requestFocus();
	}

	private void highlightInputField(JTextField output) {
		int charToEncryptAscii = output.getName().charAt(0);
		AlphabetStripView viewAlphabet = this.getView().getAlphabet();
		viewAlphabet.highlight(charToEncryptAscii - this.getModel().ASCII_UC_A);

		output.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
		this.getView().createKeyboard(output, KeyboardView.CHAR_MODE);
	}

	private void resetStateOfIOFields() {
		for (JTextField outputIterator : this.getView().getUserOutput()) {

			if (outputIterator.getText() != null
					&& CryptoDemonstrationController.this.getView()
							.getAlphabet() != null) {
				int charToEncryptAscii = outputIterator.getName().charAt(0);
				AlphabetStripView viewAlphabet = CryptoDemonstrationController.this
						.getView().getAlphabet();
				viewAlphabet
						.unHighlight(charToEncryptAscii
								- CryptoDemonstrationController.this.getModel().ASCII_UC_A);
				if (outputIterator.isEditable()) {
					outputIterator.setBorder(BorderFactory
							.createLineBorder(Color.darkGray));
				}
			}
		}
	}

	/**
	 * Explain the elements on the screen. Only explanations are shown.
	 */
	private void step1() {
		this.demonstrationStep++;
		this.getView()
				.getExplanations()
				.setText(
						this.wrapHtml(CryptoDemonstrationController.i18n
								.tr("Because of your inferior intelligence you look at the first letter of your name: C.<br>"
										+ "Then you look at the 3rd letter after C and take F. Great!! Now you encrypted the <br>"
										+ "first letter of your name.")));
		this.getView().getUserInput()[0].setBorder(BorderFactory
				.createLineBorder(Color.green));
		this.getView().getUserOutput()[0].setBorder(BorderFactory
				.createLineBorder(Color.green));
		this.getView().getUserOutput()[0].setText("F");
		this.getView().validate();
	}

	/**
	 * Describe how each character is encrypted.
	 */
	private void step2() {
		this.demonstrationStep++;
		this.editableFields = 1;
		this.getView().getProceed().setVisible(false);
		this.getView().getUserInput()[0].setBorder(null);
		this.getView().getUserOutput()[0].setBorder(null);
		this.getView()
				.getExplanations()
				.setText(
						this.wrapHtml(CryptoDemonstrationController.i18n
								.tr("As you saw in the first step you need to add to your letter position in the alphabet 3<br>"
										+ "and then you get the position of the needed letter. For example C has the position 2 <br>"
										+ "if you add 2+3 you get 5, which corresponds to the letter F. Now encrypt the next letter.<br>"
										+ "To acomplish this click on the white area and type the needed letter.")));
		this.getView().getUserInput()[1].setBorder(BorderFactory
				.createLineBorder(Color.green));
		this.getView().getUserOutput()[1].setEditable(true);
		this.getView().validate();
	}

	/**
	 * Describe the general Caesar cipher. (The key can vary from 0-25.)
	 */
	private void step3() {
		this.demonstrationStep++;
		this.editableFields = (this.getView().getUserInput().length - 2);
		this.getView().remove(this.getView().getProceed());
		this.getView().setProceed(null);
		this.getView().getUserInput()[1].setBorder(null);
		this.getView().getUserOutput()[1].setBorder(null);
		for (int i = 2; i < this.getView().getUserInput().length; i++) {
			this.getView().getUserOutput()[i].setEditable(true);
		}
		this.getView()
				.getExplanations()
				.setText(
						this.wrapHtml(CryptoDemonstrationController.i18n
								.tr("Oh mighty Caesar. No one will ever be able to destroy you! Because of that fact lets end <br>"
										+ "this childish games and finish the rest of the fields fast. Then we can send the courier again<br>"
										+ "but this time your enemies will have no idea who wrote it and you will conquer the world.")));
		this.getView().validate();

	}

	// -------------------------------------------------------//
	// -------------------Getter/Setter-----------------------//

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return this.demonstrationStep;
	}

	/**
	 * @return the editableFields
	 */
	public int getEditableFields() {
		return this.editableFields;
	}

	@Override
	public String getHelp() {
		String help = CryptoDemonstrationController.i18n
				.tr("Not sure if much help needed here.");

		return help;
	}

	/**
	 * @return the model
	 */
	public CryptoModel getModel() {
		return this.model;
	}

	/**
	 * @param animationStep
	 *            the animationStep to set
	 */
	public void setAnimationStep(int animationStep) {
		this.demonstrationStep = animationStep;
	}

	/**
	 * @param editableFields
	 *            the editableFields to set
	 */
	public void setEditableFields(int editableFields) {
		this.editableFields = editableFields;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(CryptoModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}

	private String wrapHtml(String text) {
		return "<html><body>" + text + "</body></html>";
	}
}
