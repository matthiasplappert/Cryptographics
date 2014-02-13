/**
 * 
 */
package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.Cryptographics.Caesar.CryptoView;
import edu.kit.iks.CryptographicsLib.NumpadView;

/**
 * @author wasilij
 * 
 */
public class CryptoExperimentView extends CryptoView {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -569214466948994301L;

	/**
	 * localization.
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			CryptoExperimentView.class);

	/**
	 * XML root element of the CryptoView resources.
	 */
	protected Element cryptoResource;

	/**
	 * 
	 */
	public CryptoExperimentView() {
		super();
		// load the resources.
		CaesarVisualizationInfo vsInfo = new CaesarVisualizationInfo();
		this.cryptoResource = vsInfo.getResources().getChild(
				CryptoExperimentView.i18n.tr("Encrypt"));
		
		//setup the caption of the next/back Buttons.
		this.getBackButton().setText(CryptoExperimentView.i18n
					.tr("Back to demonstration."));
		this.getNextButton().setText(CryptoExperimentView.i18n
					.tr("Go to Decryption."));

		// setup the input/output elements for further steps.
		this.setupUserIO();

		// build the user interface.
		this.userCharacterIOContainer.validate();

		// setup the explanations.
		String explanation = "<html><body> "
				+ CryptoExperimentView.i18n
						.tr("Ok. Previously you saw that you can encrypt a message with the traditional Caesar cipher<br>"
								+ "when you shift each letter 3 positions next in the alphabet. Lets think a little further.<br>"
								+ "When we can shift 3 positions to substitute A with D, then we can also shift 1,2,4,5,6,...,25 positions.<br>"
								+ "And substitute A with some other letter. The shift value is called the 'Key'. The Key in the examples before was 3.<br>"
								+ "The key is needed when you want to decrypt a cipher. Without the key it would costs much more effort<br>"
								+ " and in most cases uneligible. <br>"
								+ "Now you have 2 options:<br>"
								+ "<br>"
								+ "1. You put you own key and plaintext into the textfield.<br>"
								+ "<br>"
								+ "2.Or you just click generate and this awesome programm generates you everything you need with real real complex calculations.");
		this.setupExplanations(explanation, GridBagConstraints.PAGE_START, 1,
				0, 2);

		this.validate();
	}
	
	/**
	 * Called when the user done the needed input in a valid way.
	 * 
	 * @param inputChars
	 * @param key
	 */
	public void setupExperimentCore(char[] inputChars, int key) {
		// User input will be now filled into the boxes. This field is not
		// needed anymore.
		this.removeUserIOContainer();
		this.removeExplanations();

		// setup IO.
		this.setupInOutElements(inputChars, key);

		// setup the alphabet.
		this.setupAlphabet();

		// setup the explanations.
		String explanations = "<html><body>"
				+ CryptoExperimentView.i18n
						.tr("Now it is up to you. Test your skills. Remember the key is")
				+ " "
				+ key
				+ ".<br>"
				+ CryptoExperimentView.i18n
						.tr("You need to add the key to the position of the letter your want to shift to get<br>"
								+ "the needed cipher. If you get a bigger number then 25 you need to subtract 25 from it. <br>"
								+ "For example: You want to encrypt X with the key 3. When you add 3 to X you get 23 + 3 = 26. <br>"
								+ "26 is obvious bigger then 25. Then you subtract 26 - 25 = 1. This is your cipher. <br>"
								+ "It is also called modulo calculation. For example 26 mod 25 = 1. But this is a little more complex<br>"
								+ "and therefore not important here. You will see more in the Vigenère visualization.");
		this.setupExplanations(explanations,
				GridBagConstraints.LAST_LINE_START, 0, 0, 4);

		// build the new view.
		this.validate();
		this.repaint();
	}
	
	/**
	 * Creates the keyboard with numerical values and presents it.
	 * 
	 * @param input
	 *            the textfield referred to the numpad.
	 */
	public void createNumpad(JTextField input) {
		this.numpad = new NumpadView(input, NumpadView.NUMBER_MODE);
		GridBagConstraints numpadConst = new GridBagConstraints();
		numpadConst.anchor = GridBagConstraints.LINE_END;
		numpadConst.weightx = 1.0;
		numpadConst.weighty = 0.5;
		numpadConst.gridx = 0;
		numpadConst.gridy = 3;
		numpadConst.gridwidth = 4;
		numpadConst.gridheight = 5;
		numpadConst.insets = new Insets(0, 10, 0, 200);
		this.add(this.numpad, numpadConst);
		this.validate();
	}
	
	/**
	 * Removes the numpad from the view.
	 */
	public void removeNumpad() {
		this.remove(this.numpad);
		this.numpad = null;
		this.validate();
		this.repaint();
	}

	// ----------------------------------------------//
	// -------------------private methods-----------//

	private void setupUserIO() {
		// set the Container for the user interface.
		this.setupUserIOContainer();

		// add the input field.
		this.setupUserLiteralInput();

		// add the key-input field.
		this.setupUserNumericalInput();

		// add the button for generating input if the user is too lazy.
		this.setupIOGenerator();
	}

	private void setupUserIOContainer() {
		this.userCharacterIOContainer = new JPanel(new GridBagLayout());
		// this.input.setAlignmentY(JTextField.TOP_ALIGNMENT);
		GridBagConstraints inConst = new GridBagConstraints();
		inConst.anchor = GridBagConstraints.CENTER;
		inConst.weightx = 0.5;
		inConst.weighty = 1.0;
		inConst.gridx = 0;
		inConst.gridy = 2;
		inConst.gridheight = 6;
		inConst.gridwidth = 3;
		this.add(this.userCharacterIOContainer, inConst);
	}

	private void setupUserLiteralInput() {
		this.literalInput = new JTextField();
		this.literalInput.setPreferredSize(new Dimension(250, 50));
		GridBagConstraints inputConst = new GridBagConstraints();
		inputConst.gridx = 0;
		inputConst.gridy = 1;
		inputConst.insets = new Insets(0, 0, 0, 50);
		this.userCharacterIOContainer.add(this.literalInput, inputConst);
		this.literalInput
				.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption of the input field.
		JLabel inputCaption = new JLabel(
				CryptoExperimentView.i18n.tr("Put your name in here!"));
		GridBagConstraints capConst = new GridBagConstraints();
		capConst.gridx = 0;
		capConst.gridy = 0;
		capConst.insets = new Insets(0, 0, 0, 50);
		this.userCharacterIOContainer.add(inputCaption, capConst);
	}

	private void setupUserNumericalInput() {
		this.keyInput = new JTextField();
		this.keyInput.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 2;
		keyConst.gridy = 1;
		this.userCharacterIOContainer.add(this.keyInput, keyConst);
		this.keyInput.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption for the input field.
		JLabel keyCaption = new JLabel("Key");
		GridBagConstraints keyCapConst = new GridBagConstraints();
		keyCapConst.gridx = 2;
		keyCapConst.gridy = 0;
		this.userCharacterIOContainer.add(keyCaption, keyCapConst);
	}

	private void setupIOGenerator() {
		this.generator = new JButton(
				CryptoExperimentView.i18n.tr("Generate letters!"));
		this.generator.setPreferredSize(new Dimension(300, 50));
		GridBagConstraints genConst = new GridBagConstraints();
		genConst.weightx = 1.0;
		genConst.gridx = 0;
		genConst.gridy = 2;
		genConst.gridwidth = 3;
		this.userCharacterIOContainer.add(this.generator, genConst);
	}

}
