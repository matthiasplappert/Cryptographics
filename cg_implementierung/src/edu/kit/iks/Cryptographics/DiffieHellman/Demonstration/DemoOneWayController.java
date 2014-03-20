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
	
	/**
	 * Simple constructor
	 * @param visualizationInfo dh visualization info
	 */
	public DemoOneWayController(AbstractVisualizationInfo visualizationInfo) {
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
		view = new DemoOneWayView();
		this.getView().getNextButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((DemoOneWayView) view).isNextText()) {
					((VisualizationContainerController) getParentController()).presentNextVisualizationController();
				} else {
					((DemoOneWayView) view).setNextText();
				}
			}
		});
		
		this.getView().getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentPreviousVisualizationController();
			}
		});
		
		this.getView().getSkipButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(2);
			}
		});
		
		this.getView().getReturnButton().addActionListener(new ActionListener() {
			
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
		this.getView().stopTimers();
		this.view = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public DemoOneWayView getView() {
		return (DemoOneWayView) this.view;
	}

}
