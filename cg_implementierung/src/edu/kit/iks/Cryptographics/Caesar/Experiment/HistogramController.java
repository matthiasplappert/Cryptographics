package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
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
					getView().setupBruteForce(getModel().getRandomCipher(secret));
					genListenerBF();
				} else {
					getView().setupHistogram();
				}

			}
		});
	}

	// /**
	// * Explanations and animations are shown that explain histograms.
	// */
	// public void startAnimations() {
	// step1();
	// // stop.
	// step2();
	// // stop.
	// step3();
	// // stop.
	// step4();
	// // done.
	// }
	//
	// /**
	// * Explain why the Caesar cipher is not appropriate nowadays.
	// */
	// private void step1() {
	//
	// }
	//
	// /**
	// * Explain what histograms are.
	// */
	// private void step2() {
	//
	// }
	//
	// /**
	// * Explain how they are used and how to read from them.
	// */
	// private void step3() {
	//
	// }
	//
	// /**
	// * Explain how to decrypt big text that was ciphered with Caesar without a key.
	// */
	// private void step4() {
	//
	// }

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
				getView().setKeyValue(key);
				getView().getKey().setText("" + key);
				getView().getPlain().setText(
						(getModel().enc(key, getView().getCipher().getText(),
								false)));
				if (key == getView().getSecretKey() && key < 27) {
					getView().getExplanations().setText(
							"<html><body> Congratulations you found the secret key and are now able<br>"
									+ "to read the secret message. The Key was "+ key);

					setStep(1);
					getView().setupProceed();
					genProceedListener();
				} else {

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
					getView().getPlain().setText(
							(getModel().enc(key, getView().getCipher()
									.getText(), false)));
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
