package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.Cryptographics.Caesar.CryptoView;

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
		super(CryptoView.DEMONSTRATION_MODE);
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.cipherDemoResource = vsInfo.getResources().getChild("CipherDemo");

		// setup the fields for the demonstratoin of the encryption.
		char[] chars = { 'C', 'A', 'E', 'S', 'A', 'R' };
		
		//Setup the io textfields.
		this.setupInOutElements(chars,3, CryptoView.DEMONSTRATION_MODE);

		//setup the forwarding button.
		this.setupProceed();

		// setup the alphabet.
		this.setupAlphabet();

		// setup the explanation label.
		String explanations = 
				"<html><body>"
						+ i18n.tr("Imagine now you are the mighty caesar!! Of course your first idea is to substitute each <br>"
								+ "letter from your name with some other from the alphabet. But which one?");
		this.setupExplanations(explanations, GridBagConstraints.LAST_LINE_START, 0, 0, 4);

		this.validate();
	}
	
	private void setupProceed() {
		// setup the aligment of the button proceed.
		GridBagConstraints proceedConst = new GridBagConstraints();
		this.proceed = new JButton(i18n.tr("Proceed!"));
		this.proceed.setPreferredSize(new Dimension(250, 50));
		// this.proceed.setFont(new Font("Arial", 2, 25));
		proceedConst.anchor = GridBagConstraints.PAGE_END;
		proceedConst.gridx = 2;
		proceedConst.gridy = 3;
		proceedConst.gridwidth = 3;
		this.add(this.proceed, proceedConst);
	}

	/**
	 * @return the cipherDemoResource
	 */
	public Element getCipherDemoResource() {
		return cipherDemoResource;
	}

	/**
	 * @param cipherDemoResource the cipherDemoResource to set
	 */
	public void setCipherDemoResource(Element cipherDemoResource) {
		this.cipherDemoResource = cipherDemoResource;
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
	}

	/**
	 * @param proceed the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

}