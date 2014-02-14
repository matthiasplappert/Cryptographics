package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Vigenere.VigenereVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;

/**
 * Controller class of the first phase
 * @author Aydin Tekin
 */
public class FirstDemonstrationController extends AbstractVisualizationController {

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(FirstDemonstrationController.class);
	
	/** 
	 * Checks if vigenere text is read 
	 */
	private boolean vigenereRead = false;
	
	/**
	 * Instance of the visualisation info
	 */
	private VigenereVisualizationInfo vsInfo;
	
	/**
	 * Constructor of the controller
	 * @param visualizationInfo
	 */
	public FirstDemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.vsInfo = (VigenereVisualizationInfo)visualizationInfo;
	}
	
	/**
	 * returns the help string
	 * @return help string
	 */
	@Override
	public String getHelp() {
		return i18n.tr("There is nothing to help, just read the text");
	}
	
	/**
	 * loads the view and registers the actionlistener's.
	 */
	@Override
	public void loadView() {
		this.vigenereRead = false;
		this.view = new FirstDemonstrationView(vsInfo);
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vigenereRead) {
					vigenereRead = false;
					getView().getModuloText().setVisible(false);
					getView().getClock().setVisible(false);
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!vigenereRead) {
					getView().getModuloText().setVisible(true);
					getView().getClock().setVisible(true);
					vigenereRead = true;
				} else {
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
				}
			}
		});
		
		this.view.validate();
	}
	
	/**
	 * unloads the view
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	/**
	 * returns the view
	 * @return view of current step
	 */
	@Override
	public FirstDemonstrationView getView() {
		return (FirstDemonstrationView) this.view;
	}
	
}
