package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;

public class HelpPopoverView extends PopoverView {

	private static final long serialVersionUID = 1L;
	
	private String helpText;
	
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
