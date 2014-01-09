package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.PopoverView;

/**
 * Objects of this class represent the popover when
 * the user clicks on the help button
 * 
 * @author Christian Dreher
 */
public class HelpPopoverView extends PopoverView {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8140547473696504022L;

	/**
	 * Text to be displayed
	 */
	private String helpText;
	
	/**
	 * Label to actually display the text on the UI
	 */
	private JLabel helpTextLabel;
	
	/**
	 * Constructor of the help popover.
	 * 
	 * @param helpText the help text
	 */
	public HelpPopoverView(String helpText) {
		super();
		
		this.helpText = helpText;		
		this.helpTextLabel = new JLabel(helpText);
		this.getContentView().add(this.helpTextLabel);
	}
	
	/**
	 * Returns the help text.
	 * 
	 * @return the help text
	 */
	public String getHelpText() {
		return helpText;
	}
	
	/**
	 * Returns the help text label.
	 * @return the help text label
	 */
	public JLabel getHelpTextLabel() {
		return helpTextLabel;
	}
}
