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

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoModel;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

/**
 * Controller for the last step of demonstration phase. Controls the needed elements from
 * CaesarUpperView, !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoController extends AbstractVisualizationController {

	private int animationStep;

	private int editableFields;

	private CryptoModel model;
	
	private static I18n i18n = Configuration.getInstance().getI18n(CipherDemoController.class);

	/**
	 * Constructor.
	 * 
	 * @param visualizationInfo
	 */
	public CipherDemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/**
	 * Function for performing the needed animations. After each step the animation stops and
	 * continues when user wishes.
	 * 
	 * @param c
	 */
	public void animationStart(int step) {
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
		case 4:
			// animationDone();
		}

	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return this.animationStep;
	}

	/**
	 * @return the editableFields
	 */
	public int getEditableFields() {
		return this.editableFields;
	}

	@Override
	public String getHelp() {
		String help = i18n.tr("Not sure if much help needed here.");
		
		return help;
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
	public CipherDemoView getView() {
		return (CipherDemoView) this.view;
	}

	@Override
	public void loadView() {
		this.view = new CipherDemoView();
		this.model = CryptoModel.getInstance();
		this.animationStep = 1;

		for (int i = 1; i < this.getView().getUserOutput().length; i++) {
			// Needed for delegating to the inner type ActionListener, when the actionEvent from the
			// Button "ENTER" on the Keyboard is fired.
			final JTextField userOutput = this.getView().getUserOutput()[i];

			this.getView().getUserOutput()[i]
					.addFocusListener(new FocusListener() {
						@Override
						public void focusGained(FocusEvent e) {

							JTextField output = (JTextField) e.getSource();
							JTextField[] userOutput = CipherDemoController.this
									.getView().getUserOutput();

							for (JTextField outputIterator : userOutput) {

								if (outputIterator.getText() != null 
										&& CipherDemoController.this.getView()
												.getAlphabet() != null) {
									int charToEncryptAscii = outputIterator
											.getName().charAt(0);
									AlphabetStripView viewAlphabet = CipherDemoController.this
											.getView().getAlphabet();
									viewAlphabet.unHighlight(charToEncryptAscii
											- CipherDemoController.this
													.getModel().ASCII_UC_A);
									if (outputIterator.isEditable()) {
										outputIterator.setBorder(BorderFactory.createLineBorder(Color.darkGray));
									}
								}
							}

							if (CipherDemoController.this.getView()
									.getKeyboard() != null) {
								CipherDemoController.this.getView().remove(
										CipherDemoController.this.getView()
												.getKeyboard());
								CipherDemoController.this.getView()
										.setKeyboard(null);
								CipherDemoController.this.getView().validate();
								CipherDemoController.this.getView().repaint();
							}
							if (output.isEditable()) {

								// highlights the character in the alphabet.
								int charToEncryptAscii = output.getName()
										.charAt(0);
								AlphabetStripView viewAlphabet = CipherDemoController.this
										.getView().getAlphabet();
								viewAlphabet.highlight(charToEncryptAscii
										- CipherDemoController.this.getModel().ASCII_UC_A);

								output.setBorder(BorderFactory
										.createLineBorder(Color.blue, 5));
								CipherDemoController.this.getView()
										.createKeyboard(output);
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
								// standart key for the caesar cipher. +3 when encrypting. -3 when
								// decrypting.
								if (CipherDemoController.this.getModel()
										.enc(3, userOutput.getName())
										.equals(userOutput.getText())) {
									// user encrypted the given char successful.
									userOutput.setBorder(BorderFactory
											.createLineBorder(Color.green));
									CipherDemoController.this
											.setEditableFields(CipherDemoController.this
													.getEditableFields() - 1);
									userOutput.setEditable(false);
									if (CipherDemoController.this
											.getEditableFields() == 0
											&& CipherDemoController.this
													.getAnimationStep() == 4) {
										// User encrypted all characters valid.
										CipherDemoController.this
												.getView()
												.getExplanations()
												.setText(
														"<html><body>Great work oh mighty Caesar. May your enemies shutter over your intelligence.");
										CipherDemoController.this
												.getView()
												.remove(CipherDemoController.this
														.getView()
														.getAlphabet());
										CipherDemoController.this.getView()
												.setAlphabet(null);
										CipherDemoController.this
												.getView()
												.getNavigationPanel()
												.remove(CipherDemoController.this
														.getView()
														.getNextButton());
										GridBagConstraints nextConst = new GridBagConstraints();
										nextConst.anchor = GridBagConstraints.CENTER;
										nextConst.weightx = 1.0;
										nextConst.weighty = 0.1;
										nextConst.gridx = 1;
										nextConst.gridy = 1;
										nextConst.gridwidth = 26;
										nextConst.gridheight = 2;
										CipherDemoController.this.getView()
												.add(CipherDemoController.this
														.getView()
														.getNextButton(),
														nextConst);
										CipherDemoController.this.getView()
												.requestFocus();
										userOutput.setEditable(false);
										CipherDemoController.this
												.getView()
												.remove(CipherDemoController.this
														.getView()
														.getKeyboard());
										CipherDemoController.this.getView()
												.setKeyboard(null);
										CipherDemoController.this.getView()
												.validate();
										CipherDemoController.this.getView()
												.repaint();

									} else if (CipherDemoController.this
											.getEditableFields() == 0
											&& CipherDemoController.this
													.getAnimationStep() == 3) {
										// User has to encrypt the last 3 fields.
										CipherDemoController.this.getView()
												.requestFocus();
										userOutput.setEditable(false);
										CipherDemoController.this
												.getView()
												.remove(CipherDemoController.this
														.getView()
														.getKeyboard());
										CipherDemoController.this.getView()
												.setKeyboard(null);
										CipherDemoController.this.getView()
												.getProceed().setVisible(true);
										CipherDemoController.this
												.getView()
												.getAlphabet()
												.unHighlight(
														userOutput.getName()
																.charAt(0)
																- CipherDemoController.this
																		.getModel().ASCII_UC_A);
										CipherDemoController.this
												.getView()
												.getExplanations()
												.setText(
														"<html><body>Very nice! Lets encrypt the rest of this childish challenge.");
										CipherDemoController.this.getView()
												.validate();
										CipherDemoController.this.getView()
												.repaint();
									} else {
										// User encrypted correctly the given char.
										CipherDemoController.this.getView()
												.validate();
										CipherDemoController.this
												.getView()
												.getExplanations()
												.setText(
														CipherDemoController.this
																.getModel()
																.genRandomGrats()
																+ " Only "
																+ CipherDemoController.this
																		.getEditableFields()
																+ " left.");
										CipherDemoController.this.getView()
												.repaint();
										CipherDemoController.this.getView()
												.getUserOutput()[CipherDemoController.this
												.getView().getUserOutput().length
												- CipherDemoController.this
														.getEditableFields()]
												.requestFocus();
									}
								} else {
									// User didn't encrypt correctly.
									userOutput.setBorder(BorderFactory
											.createLineBorder(Color.red));
									userOutput.setText("");
									CipherDemoController.this
											.getView()
											.getExplanations()
											.setText(
													CipherDemoController.this
															.getModel()
															.genRandomBlamings());
									userOutput.requestFocus();
								}
							}
						}
					});
		}
		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt .event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController) CipherDemoController.this
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
				VisualizationContainerController containerController = (VisualizationContainerController) CipherDemoController.this
						.getParentController();
				containerController.presentNextVisualizationController();
			}
		});

		this.getView().getProceed().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
				CipherDemoController.this
						.animationStart(CipherDemoController.this
								.getAnimationStep());
			}
		});

		this.getView().validate();
	}

	// /**
	// * Describe that decryption is the same way as encryption.
	// */
	// private void step4() {
	// this.animationStep++;
	// String firstLetter = this.getView().getUserInput()[0].getText();
	// // this.getView().getExplanations().setText("The first letter is "+firstLetter+""
	//
	// }

	/**
	 * @param animationStep
	 *            the animationStep to set
	 */
	public void setAnimationStep(int animationStep) {
		this.animationStep = animationStep;
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

	/**
	 * Explain the elements on the screen. Only explanations are shown.
	 */
	private void step1() {
		this.animationStep++;
		this.getView()
				.getExplanations()
				.setText(
						"<html><body> " +
							i18n.tr("Because of your inferior intelligence you look at the first letter of your name: C.<br>"
									+ "Then you look at the 3rd letter after C and take F. Great!! Now you encrypted the <br>"
									+ "first letter of your name."));
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
		this.animationStep++;
		this.editableFields = 1;
		this.getView().getProceed().setVisible(false);
		this.getView().getUserInput()[0].setBorder(null);
		this.getView().getUserOutput()[0].setBorder(null);
		this.getView()
				.getExplanations()
				.setText(
						"<html><body>" + 
							i18n.tr("As you saw in the first step you need to add to your letter position in the alphabet 3<br>"
									+ "and then you get the position of the needed letter. For example C has the position 2 <br>"
									+ "if you add 2+3 you get 5, which corresponds to the letter F. Now encrypt the next letter.<br>"
									+ "To acomplish this click on the white area and type the needed letter."));
		this.getView().getUserInput()[1].setBorder(BorderFactory
				.createLineBorder(Color.green));
		this.getView().getUserOutput()[1].setEditable(true);
		this.getView().validate();
	}

	/**
	 * Describe the general Caesar cipher. (The key can vary from 0-25.)
	 */
	private void step3() {
		this.animationStep++;
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
						"<html><body>" +
							i18n.tr("Oh mighty Caesar. No one will ever be able to destroy you! Because of that fact lets end <br>"
									+ "this childish games and finish the rest of the fields fast. Then we can send the courier again<br>"
									+ "but this time your enemies will have no idea who wrote it and you will conquer the world."));
		this.getView().validate();

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
}
