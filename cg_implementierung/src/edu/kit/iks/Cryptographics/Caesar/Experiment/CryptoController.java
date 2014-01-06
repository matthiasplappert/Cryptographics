package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.kit.iks.Cryptographics.Caesar.AbstractController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;

/**
 * Controller for the first and second step of the experiment phase. When user has to
 * put input and encrypt it and in the second step to decrypt a given cipher. Controls the needed elements from CaesarUpperView,
 * !!see CGeneralView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoController extends AbstractController {

	/** Constructor.
	 * @param visualizationInfo
	 */
	public CryptoController(CaesarVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.view.getInput().addActionListener(new ActionListener() {

			/*
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// TODO: Too dirty, searching for a smarter solution..
		/**
		 * Initializes the action listener of the Labels that represent the
		 * alpabet. So the user can interact with them.
		 */
		for (int i = 0; i < 26; i++) {
			this.view.getAlphabet()[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
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

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
		}
	}

}
