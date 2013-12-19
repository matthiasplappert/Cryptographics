package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import edu.kit.iks.Cryptographics.Caesar.AbstractView;

public class CaesarProblemDemoView extends AbstractView {

	private static final long serialVersionUID = 1L;

	// Labels that will contain img for animation.
	private JLabel caesar;
	private JLabel cipher;
	private JLabel interceptor;

	public CaesarProblemDemoView() {
		
	}
	/**
	 * @param l
	 */
	public void addBackBtnListener(ActionListener l) {
		this.backBtn.addActionListener(l);
	}
	
	/**
	 * @param l
	 */
	public void addNextBtnListener(ActionListener l) {
		this.nextBtn.addActionListener(l);
	}
}
