package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class YourTurnController extends AbstractVisualizationController {
	
	private YourTurnView view;

	public YourTurnController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new YourTurnView();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHelp() {
		return view.getHelp();
	}

	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		view = new YourTurnView();
		JButton next = this.getView().getNextButton();
		JButton back = this.getView().getBackButton();
		next.setText("Start Experiment");
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		back.setText("Back to Demonstration");
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
	
	@Override
	public YourTurnView getView() {
		return (YourTurnView) this.view;
	}

}
