/**
 * 
 */
package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.kit.iks.Cryptographics.Caesar.CGeneralController;
import edu.kit.iks.Cryptographics.Caesar.VisualizationInfo;

/**
 * Controller for the first step of the demonstration phase. When user has to
 * put input and encrypt it. Controls the needed elements from CaesarUpperView,
 * !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CEncryptingController extends CGeneralController {

	public CEncryptingController(VisualizationInfo visualizationInfo) {
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
