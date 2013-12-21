package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import javax.swing.JButton;
import javax.swing.JLabel;
import edu.kit.iks.Cryptographics.Caesar.AbstractView;

/**
 * This is the first view the user gets presented when he requested the
 * visualization of Caesar's cipher. Here the user gets to know what Problems
 * Caesar faced when his enemys could intercept and read his orders. The JLabels
 * will contain images that will represent cesar for example. Meanwhile user
 * gets explanations shown that explain what what the animation means and does.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CFirstView extends AbstractView {

	private static final long serialVersionUID = 1L;

	/**
	 * Labels that will contain img for animation.
	 */
	private JLabel caesar;
	private JLabel cipher;
	private JLabel interceptor;

	public CFirstView() {

	}

	/**
	 * @return backBtn
	 */
	public JButton getBackBtn() {
		return backBtn;
	}

	/**
	 * @return nextBtn
	 */
	public JButton getNextBtn() {
		return nextBtn;
	}

	/**
	 * @return the caesar
	 */
	public JLabel getCaesar() {
		return caesar;
	}

	/**
	 * @param caesar
	 *            the caesar to set
	 */
	public void setCaesar(JLabel caesar) {
		this.caesar = caesar;
	}

	/**
	 * @return the cipher
	 */
	public JLabel getCipher() {
		return cipher;
	}

	/**
	 * @param cipher
	 *            the cipher to set
	 */
	public void setCipher(JLabel cipher) {
		this.cipher = cipher;
	}

	/**
	 * @return the interceptor
	 */
	public JLabel getInterceptor() {
		return interceptor;
	}

	/**
	 * @param interceptor
	 *            the interceptor to set
	 */
	public void setInterceptor(JLabel interceptor) {
		this.interceptor = interceptor;
	}
}
