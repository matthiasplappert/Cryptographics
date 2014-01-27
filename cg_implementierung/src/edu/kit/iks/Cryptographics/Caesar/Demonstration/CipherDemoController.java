package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Color;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoModel;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * Controller for the last step of demonstration phase. Controls the needed elements from
 * CaesarUpperView, !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoController extends AbstractVisualizationController {

	private int animationStep;

	private CryptoModel model;

	private int editableFields;

	/**
	 * @param visualizationInfo
	 */
	public CipherDemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public void loadView() {
		this.view = new CipherDemoView();
		this.model = new CryptoModel();
		this.animationStep = 1;

		for (int i = 1; i < this.getView().getUserOutput().length; i++) {
			this.getView().getUserOutput()[i]
					.addFocusListener(new FocusListener() {

						@Override
						public void focusLost(FocusEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void focusGained(FocusEvent e) {
							// TODO Auto-generated method stub

						}
					});
			this.getView().getUserOutput()[i]
					.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO: let the Model check for validity.
							JTextField userOutput = (JTextField) e.getSource();
							// standart key for the caesar cipher. +3 when encrypting. -3 when
							// decrypting.
							if (getModel().checkValidChar(3,
									userOutput.getName(), userOutput.getText(), true)) {
								// user encrypted the given char successful.
								userOutput.setBorder(BorderFactory
										.createLineBorder(Color.green));
								userOutput.setEditable(false);
								setEditableFields(getEditableFields() - 1);
								if (getEditableFields() == 0
										&& getAnimationStep() == 4) {
									// User encrypted all characters valid.
									getView()
											.getExplanations()
											.setText(
													"<html><body>Great work oh mighty Caesar. May your enemies shutter over your intelligence.");
									getView().remove(getView().getAlphabet());
									getView().setAlphabet(null);
									getView().getNavigationPanel().remove(
											getView().getNextButton());
									GridBagConstraints nextConst = new GridBagConstraints();
									nextConst.anchor = GridBagConstraints.CENTER;
									nextConst.weightx = 1.0;
									nextConst.weighty = 0.1;
									nextConst.gridx = 1;
									nextConst.gridy = 1;
									nextConst.gridwidth = 26;
									nextConst.gridheight = 2;
									// nextConst.fill = GridBagConstraints.HORIZONTAL;
									getView().add(getView().getNextButton(),
											nextConst);
									getView().validate();
								} else if (getEditableFields() == 0
										&& getAnimationStep() == 3) {
									getView().getProceed().setVisible(true);
									getView()
											.getExplanations()
											.setText(
													"<html><body>Great work oh mighty Caesar. May your enemies shutter over your intelligence. Click proceed.");
									getView().validate();
								} else {
									getView().getExplanations().setText(
											"Great you picked the right one.! Only "
													+ getEditableFields()
													+ " left");

								}
							} else {
								// TODO: user encrypted invalid! Need another try.
								userOutput.setBorder(BorderFactory
										.createLineBorder(Color.red));
								getView()
										.getExplanations()
										.setText(
												"You picked the wrong letter!! Try another one!");
							}
						}
					});
		}
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

		this.getView().getProceed().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				animationStart(getAnimationStep());
			}
		});

		this.getView().validate();
	}

	/**
	 * @return the animationStep
	 */
	public int getAnimationStep() {
		return animationStep;
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
			step1();
			break;
		case 2:
			step2();
			break;
		case 3:
			step3();
			break;
		case 4:
			// animationDone();
		}

	}

	/**
	 * Explain the elements on the screen. Only explanations are shown.
	 */
	private void step1() {
		this.animationStep++;
		this.getView()
				.getExplanations()
				.setText(
						"<html><body> "
								+ "Because of your inferior intelligence you look at the first letter of your name: C.<br>"
								+ "Then you look at the 3rd letter after C and take F. Great!! Now you encrypted the <br>"
								+ "first letter of your name.");
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
						"<html><body>"
								+ "As you saw in the first step you need to add to your letter position in the alphabet 3<br>"
								+ " and then you get the position of the needed letter. For example C has the position 2 <br>"
								+ "if you add 2+3 you get 5, which corresponds to the letter F. Now encrypt the next letter.<br>"
								+ "To acomplish this click on the white area and type the needed letter.");
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
						"<html><body>"
								+ "Oh mighty Caesar. No one will ever be able to destroy you! Because of that fact lets end <br>"
								+ "this childish games and finish the rest of the fields fast. Then we can send the courier again<br>"
								+ "but this time your enemies will have no idea who wrote it and you will conquer the world.");
		this.getView().validate();

	}

	/**
	 * Describe that decryption is the same way as encryption.
	 */
	private void step4() {
		this.animationStep++;
		String firstLetter = this.getView().getUserInput()[0].getText();
		// this.getView().getExplanations().setText("The first letter is "+firstLetter+""

	}

	/**
	 * 
	 */
	private void encryptExample() {

	}

	@Override
	public String getHelp() {
		return "Not sure if much Help needed here.";
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
	 * @param animationStep
	 *            the animationStep to set
	 */
	public void setAnimationStep(int animationStep) {
		this.animationStep = animationStep;
	}
}
