package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * Explain the aim of DH-KE
 * 
 * @author kai
 *
 */
public class ExplainAimView extends VisualizationView {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(ExplainAimView.class);
	
	/* holds the explanation */
	private JLabel aimExplain;

	/* demonstrate the problem of just sending the color */
	private ColorChannel cc;

	/* no help need here */
	private String help = i18n.tr("No help");
	
	/* the explanation string */
	private String explain = i18n.tr("Our aim is to exchange a secret on a public channel, " +
			"without Eve getting the secret too. Therefore we can't simply send the secret, as shown " +
			"in the figure above as Eve would get the secret too. Thus we need " +
			"to exchange the secret in a different way");
	
	private static final long serialVersionUID = 5986978581223106407L;

	/**
	 * Layout and build the subcomponents
	 */
	public ExplainAimView() {
		super();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getNextButton(), gbc);
		
		this.aimExplain = new JLabel();
		this.aimExplain.setText("<html><div style=\"width:200px\">" + explain + "</div></html>");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.add(aimExplain, gbc);
		
		this.cc = new ColorChannel(new Dimension(800, 200), 50);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(this.cc, gbc);
		this.cc.setColorNextToSend(Color.BLUE);
		this.cc.setKeepColor(false);
		this.cc.setRepeat(true);
		this.cc.sendToBob(null, false, "");
	}

	/**
	 * get the color channel
	 * @return the color channel
	 */
	public ColorChannel getColorChannel() {
		return this.cc;
	}

	/**
	 * explain string
	 * @return the explain string
	 */
	public String getHelp() {
		return help ;
	}
	


}
