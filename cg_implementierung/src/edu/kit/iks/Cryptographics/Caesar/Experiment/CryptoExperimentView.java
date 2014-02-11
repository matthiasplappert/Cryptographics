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
import edu.kit.iks.Cryptographics.Caesar.Demonstration.CryptoDemonstrationView;

/**
 * @author wasilij
 * 
 */
public class CryptoExperimentView extends CryptoView {

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
		this.cryptoResource = vsInfo.getResources().getChild("Encrypt");
		
		// setup the input/output elements for further steps.
		this.setupUserIO();

		// build the user interface.
		this.userCharacterIOContainer.validate();

		// setup the explanations.
		String explanation = "<html><body> "
				+ i18n.tr("Ok. Previously you saw that you can encrypt a message with the traditional Caesar cipher<br>"
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
		this.input = new JTextField();
		this.input.setPreferredSize(new Dimension(250, 50));
		GridBagConstraints inputConst = new GridBagConstraints();
		inputConst.gridx = 0;
		inputConst.gridy = 1;
		inputConst.insets = new Insets(0, 0, 0, 50);
		this.userCharacterIOContainer.add(this.input, inputConst);
		this.input.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption of the input field.
		JLabel inputCaption = new JLabel(i18n.tr("Put your name in here!"));
		GridBagConstraints capConst = new GridBagConstraints();
		capConst.gridx = 0;
		capConst.gridy = 0;
		capConst.insets = new Insets(0, 0, 0, 50);
		this.userCharacterIOContainer.add(inputCaption, capConst);
	}

	private void setupUserNumericalInput() {
		this.key = new JTextField();
		this.key.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints keyConst = new GridBagConstraints();
		keyConst.gridx = 2;
		keyConst.gridy = 1;
		this.userCharacterIOContainer.add(this.key, keyConst);
		this.key.setBorder(BorderFactory.createLineBorder(Color.black));

		// add the caption for the input field.
		JLabel keyCaption = new JLabel("Key");
		GridBagConstraints keyCapConst = new GridBagConstraints();
		keyCapConst.gridx = 2;
		keyCapConst.gridy = 0;
		this.userCharacterIOContainer.add(keyCaption, keyCapConst);
	}

	private void setupIOGenerator() {
		this.generator = new JButton(i18n.tr("Generate letters!"));
		this.generator.setPreferredSize(new Dimension(300, 50));
		GridBagConstraints genConst = new GridBagConstraints();
		genConst.weightx = 1.0;
		genConst.gridx = 0;
		genConst.gridy = 2;
		genConst.gridwidth = 3;
		this.userCharacterIOContainer.add(this.generator, genConst);
	}

}
