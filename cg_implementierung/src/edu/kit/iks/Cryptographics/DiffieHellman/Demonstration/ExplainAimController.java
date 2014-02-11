package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ExplainAimController extends AbstractVisualizationController {
	
	private ExplainAimView view;
	
	public ExplainAimController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return view.getHelp();
	}

	@Override
	public void loadView() {
		this.view = new ExplainAimView();
		// TODO use mouselistener instead of actionlistener
		this.getView().getNextButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		
		this.getView().getBackButton().setVisible(false);

	}
	
	@Override
	public void unloadView() {
		this.getView().getColorChannel().stopTimer();
		this.view = null;
	}
	
	@Override
	public ExplainAimView getView() {
		return (ExplainAimView) this.view;
		
	}


}
