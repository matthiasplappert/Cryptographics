package edu.kit.iks.CryptographicsLib;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is a utility class that makes dealing with MouseListeners that are simply
 * used for clicks easier.
 * 
 * @author Matthias Plappert
 */
abstract public class MouseClickListener implements MouseListener {
	/**
	 * This method will be executed when the mouse is clicked.
	 * @param event the MouseEvent
	 */
	abstract public void clicked(MouseEvent event);

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Unused
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Unused
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Unused
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Unused
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.clicked(arg0);
	}
}
