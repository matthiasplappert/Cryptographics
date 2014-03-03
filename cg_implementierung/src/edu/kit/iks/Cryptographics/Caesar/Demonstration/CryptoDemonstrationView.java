package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Caesar.CryptoView;
import edu.kit.iks.CryptographicsLib.Configuration;

/**
 * Performs animations for demonstrating Caesar's idea.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoDemonstrationView extends CryptoView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static I18n i18n = Configuration.getInstance().getI18n(
			CryptoDemonstrationView.class);

	/**
	 * XML-root element for cipherdemoView elements.
	 */
	private Element cipherDemoResource;

	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;

	/**
	 * Constructor.
	 */
	public CryptoDemonstrationView() {
		super();

		// setup the caption of the next/back Buttons.
		this.getBackButton().setText(
				CryptoDemonstrationView.i18n.tr("Back to Introduction"));
		this.getNextButton().setText(
				CryptoDemonstrationView.i18n.tr("Go to Experiment."));

		// setup the fields for the demonstratoin of the encryption.
		String caesar = CryptoDemonstrationView.i18n.tr("CAESAR");
		char[] chars = caesar.toCharArray();

		// Setup the io textfields.
		this.setupInOutElements(chars, 3);

		// Make the Textfields uneditable for the first steps.
		for (JTextField output : this.userOutput) {
			output.setEditable(false);
		}

		// setup the forwarding button.
		this.setupProceed();

		// setup the alphabet.
		this.setupAlphabet();

		// setup the explanation label.
		String explanations = this.wrapHtml(CryptoDemonstrationView.i18n
						.tr("Imagine now you are the mighty caesar! Of course your first idea is to substitute each"
								+ " letter from your name with some other from the alphabet. But which one?"
								+ " Press proceed to move on."));
		this.setupExplanations(explanations,
				GridBagConstraints.LAST_LINE_START, 0, 0, 4);

		this.validate();
	}

	private void setupProceed() {
		// setup the aligment of the button proceed.
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed = new JButton(CryptoDemonstrationView.i18n.tr("Proceed!"));
		this.proceed.setPreferredSize(new Dimension(250, 50));
		proceedConst.anchor = GridBagConstraints.PAGE_END;
		proceedConst.gridx = 2;
		proceedConst.gridy = 3;
		proceedConst.gridwidth = 3;
		this.add(this.proceed, proceedConst);
	}
	
	private String wrapHtml(String text) {
		return "<html><body><div width=600px>" + text + "</div></body></html>";
	}
	
	//-----------------------------------------------------//
	//-------------------Getter/Setter---------------------//

	/**
	 * @return the cipherDemoResource
	 */
	public Element getCipherDemoResource() {
		return this.cipherDemoResource;
	}

	/**
	 * @param cipherDemoResource
	 *            the cipherDemoResource to set
	 */
	public void setCipherDemoResource(Element cipherDemoResource) {
		this.cipherDemoResource = cipherDemoResource;
	}

	/**
	 * @return the proceed
	 */
	@Override
	public JButton getProceed() {
		return this.proceed;
	}

	/**
	 * @param proceed
	 *            the proceed to set
	 */
	@Override
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}
	
	

}