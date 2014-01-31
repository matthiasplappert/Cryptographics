package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

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
		this.model = new CryptoModel();
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

	private void genProceedListener() {
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
				if (getStep() == 0) {
					int secret = getModel().generateKey();
					getView().setSecretKey(secret);
					getView().setupBruteForce(
							getModel().getRandomCipher(secret));
					genListenerBF();

				} else {
					String plainText = getModel().getRandomText();
					String cipher = getModel().enc(3, plainText);
					getView().setSecretKey(3);
					getView().setHistogramCipher(cipher);
					getView().setupHistogram(plainText,
							getModel().formatString(cipher));
					generateHistogramInputListener();
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
	public void genListenerBF() {
		this.getView().getIncrement().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int key = getView().getKeyValue() + 1;
				if (key < 27) {

					getView().setKeyValue(key);
					getView().getKey().setText("" + key);
					getView().getPlainText().setText(
							(getModel().dec(key, getView().getCipher()
									.getText())));

					if (key == getView().getSecretKey()) {
						getView()
								.getExplanations()
								.setText(
										"<html><body> Congratulations you found the secret key and are now able<br>"
												+ "to read the secret message. The Key was "
												+ key);

						setStep(1);
						// getView().setupProceed();
						GridBagConstraints proceedConst = new GridBagConstraints();
						// proceedConst.anchor = GridBagConstraints.PAGE_END;
						// proceedConst.gridx = 2;
						// proceedConst.gridy = 3;
						// proceedConst.gridwidth = 3;
						getView().add(getView().getProceed(), proceedConst);
						getView().validate();

					} else {
						// TODO:
					}
				} else {
					// TODO:
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.getView().getDecrement().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO: need the valid bahviour.
				int key = getView().getKeyValue() - 1;
				if (key > 0) {
					getView().setKeyValue(key);
					getView().getKey().setText("" + key);
					getView().getPlainText().setText(
							(getModel().dec(key, getView().getCipher()
									.getText())));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

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
						String decryptedCipher = getModel().dec(key,
								getView().getHistogramCipher());
						decryptedCipher = getModel().formatString(
								decryptedCipher);
						getView().getPlainText().setText(decryptedCipher);

						if (key == getView().getSecretKey()) {
							getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
						} else {
							getView().getKeyInput().setBorder(
									BorderFactory.createLineBorder(Color.red));
						}

						getView().validate();
						getView().repaint();
						getView().requestFocus();
					} else {
						getView().getKeyInput().setBorder(
								BorderFactory.createLineBorder(Color.red));
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
