package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class DemoOneWayController extends AbstractVisualizationController {
	
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
		// TODO Auto-generated method stub
		view = new DemoOneWayView();
		this.getView().getNextButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		
		this.getView().getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
