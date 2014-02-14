package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * The controller for DemoOneWayView,
 * which demonstrates one-way functions
 * 
 * @author kai
 *
 */

public class DemoOneWayController extends AbstractVisualizationController {
	
	/** the corresponding view */
	private DemoOneWayView view;
	
	public DemoOneWayController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return view.getHelp();
	}

	@Override
	public void loadView() {
		view = new DemoOneWayView();
		this.getView().getNextButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		
		this.getView().getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentPreviousVisualizationController();
			}
		});

	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		// TODO stop all timers!
		this.view = null;
	}
	
	@Override
	public DemoOneWayView getView() {
		return (DemoOneWayView) this.view;
	}

}
