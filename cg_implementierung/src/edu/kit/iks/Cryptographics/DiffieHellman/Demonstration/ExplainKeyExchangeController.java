package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ExplainKeyExchangeController extends AbstractVisualizationController {
	
	private ExplainKeyExchangeView view;
	
	public ExplainKeyExchangeController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		view = new ExplainKeyExchangeView();
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
	public ExplainKeyExchangeView getView() {
		return (ExplainKeyExchangeView) this.view;
	}

}
