/**
 * 
 */
package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.kit.iks.Cryptographics.Caesar.CAbstractState;
import edu.kit.iks.Cryptographics.Caesar.VisualizationInfo;

/**
 * Controller for the second step of experiment phase. Here user only need to
 * decrypt a generated cipher. Therefore no need for user input. Controls the
 * needed elements from CaesarUpperView, !!see CaesarUpperView for more
 * details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CFourthState extends CAbstractState {

	public CFourthState(VisualizationInfo visualizationInfo) {
		super(visualizationInfo);
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
