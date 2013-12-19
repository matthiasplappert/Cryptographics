package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CaesarController extends AbstractVisualizationController {
	/**
	 * Contains all relevant informations about the cipher Caesar.
	 */
	private CaesarVisualizationInfo visualizationInfo;
    
	/**
	 * Indicates whether input from the user is needed or not.
	 */
	private boolean inputStep;
	
	/**
	 * Contains all elements of the gui for the demonstration of caesar's idea.
	 */
	private CaesarView view;

	/**
	 * @param visualizationInfo
	 */
	public CaesarController(CaesarVisualizationInfo visualizationInfo) {
		super();
		this.visualizationInfo = visualizationInfo;
		this.view = new CaesarView();
		this.view.addBackBtnListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step back
			}
		});
		this.view.addNextBtnListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step forward.
			}
		});
		this.view.addInputPerformed(new ActionListener() {

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
		
		/**
		 * Initializes the action listener of the Labels that represent the
		 * alpabet. So the user can interact with them.
		 */
		for (int i = 0; i < 26; i++) {
			this.view.getAlphabet()[i].addClickListener(new MouseListener() {

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
