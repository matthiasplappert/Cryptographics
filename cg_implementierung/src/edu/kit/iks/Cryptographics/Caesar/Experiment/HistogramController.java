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

	/*
	 * (non-Javadoc)
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
					getView().setupBruteForce(
							getModel().getRandomCipher(secret));
					genListenerBruteForce();

				} else if (getStep() == 1) {
					// Build the new experiment.
					setStep(2);
					getView().remove(getView().getKeyControl());
					getView().setKeyControl(null);
					getView().remove(getView().getExplanations());

					String plainText = getModel().getRandomText();
					String cipher = getModel().enc(3, plainText);
					getView().setSecretKey(3);
					getView().setHistogramCipher(cipher);
					getView().setupHistogram(plainText,
							getModel().formatString(cipher));
					generateHistogramInputListener();

					// // destroy yourself. Not needed anymore.
					// getView().remove(getView().getProceed());
					// getView().setProceed(null);
					// getView().validate();

				} else {
					// Build the new experiment.
					setStep(getStep() + 1);
					getView().unloadHistogram();

					int key = getModel().generateKey();
					String plainText = getModel().getRandomText();
					String cipher = getModel().enc(key, plainText);
					getView().setSecretKey(key);
					getView().setHistogramCipher(cipher);
					getView().setupHistogram(plainText,
							getModel().formatString(cipher));
					generateHistogramInputListener();

					getView().revalidate();
					// // destroy yourself. Not needed anymore.
					// getView().remove(getView().getProceed());
					// getView().setProceed(null);
					// getView().validate();
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
		this.getView().getIncrement().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
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
						// GridBagConstraints proceedConst = new GridBagConstraints();
						// proceedConst.anchor = GridBagConstraints.PAGE_END;
						// proceedConst.gridx = 2;
						// proceedConst.gridy = 3;
						// proceedConst.gridwidth = 3;
						getView().setupProceed();
						genProceedListener();

					} else {
						// TODO:
					}
				} else {
					// TODO:
				}
			}
		});
		this.getView().getDecrement().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent e) {
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
							getView().getKeyInput().setEditable(false);
							getView()
									.getKeyInput()
									.setBorder(
											BorderFactory
													.createLineBorder(Color.green));
							getView()
									.getExplanations()
									.setText(
											"<html><body>"
													+ "Congratulations you found the right key!!! See how easy it is with histograms?<br>"
													+ "If you want to try one more click proceed. Else you can to next to further information<br>"
													+ "There you can learn more about caesar's cipher.");
							getView().setupProceed();
							genProceedListener();
							getView().remove(getView().getKeyboard());
							getView().setKeyboard(null);
						} else {
							getView().getKeyInput().setBorder(
									BorderFactory.createLineBorder(Color.red));
						}

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
