package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import edu.kit.iks.Cryptographics.Caesar.CGeneralView;

/**
 * Performs animations for demonstrating Caesar's idea.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CCipherDemoView extends CGeneralView {

	/**
	 * Constructor.
	 */
	public CCipherDemoView() {
		super();
	}

	/**
	 * Function for performing the needed animations. After each step the
	 * animation stops and continues when user wishes.
	 * 
	 * @param c
	 */
	public void animationStart() {
		// perform first animation and show explanations.
		step1();
		// stop.
		// perform second animation and show explanations.
		step2();
		// stop.
		// ...
		step3();
		// stop.
		// perform last animation and show explanations.
		step4();
		// done.

	}

	/**
	 * 
	 */
	private void step1() {
		// Explain the elements on the screen.
		// Only explanations are shown.
	}

	/**
	 * 
	 */
	private void step2() {
		// Describe how each character is encrypted.
	}

	/**
	 * 
	 */
	private void step3() {
		// Describe the general Caesar cipher.
		// (The key can vary from 0-25.)
	}

	/**
	 * 
	 */
	private void step4() {
		// Describe that decryption is the same way as encryption.
	}

}
