package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * The controller that holds the yourturnview
 * 
 * @author kai
 *
 */
public class YourTurnController extends AbstractVisualizationController {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(YourTurnController.class);
	
	/** the corresponding view */
	private YourTurnView view;

	/** simple constructor */
	public YourTurnController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		return view.getHelp();
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		view = new YourTurnView();
		JButton next = this.getView().getNextButton();
		JButton back = this.getView().getBackButton();
		next.setText(i18n.tr("Start Experiment"));
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		back.setText(i18n.tr("Back to Demonstration"));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(0);
			}
		});
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public YourTurnView getView() {
		return (YourTurnView) this.view;
	}

}
