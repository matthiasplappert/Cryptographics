package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class DHDemoController extends AbstractVisualizationController {
	
	private DHDemoView view;
	
	public DHDemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return view.getHelp();
	}

	@Override
	public void loadView() {
		this.view = new DHDemoView();
		this.view.setRemember(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		
		this.getView().getNextButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(ActionListener al : getView().getNextButton().getActionListeners()) {
					getView().getNextButton().removeActionListener(al);
				}
				view.startDemo();
			}
		});
		
		this.getView().getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				((VisualizationContainerController) getParentController()).presentPreviousVisualizationController();
			}
		});
		
		this.getView().getSkip().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(4);
			}
		});
		
		this.getView().getSkipButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(3);
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
	
	@Override
	public DHDemoView getView() {
		return (DHDemoView) this.view;
	}
}
