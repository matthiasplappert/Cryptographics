package edu.kit.iks.Cryptographics;

import javax.swing.JPanel;
import javax.swing.JFrame;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class MainController extends AbstractController {
	private JFrame frame;
	
	private StartController startController;
	
	private VisualizationContainerController visualizationContainerController;
	
	public MainController() {
		this.initFrame();
		this.startController = new StartController();
	}
	
	@Override
	public void loadView() {
		this._view = new JPanel();
		this.frame.add(this._view);
	}
	
	public void presentStartAction() {
		if (this.visualizationContainerController != null) {
			this.visualizationContainerController.unloadView();
		}
		
		this.startController.loadView();
		this._view.add("StartController View", this.startController.getView());
	}
	
	public void presentVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		this.startController.unloadView();
	}
	
	private void initFrame() {
		this.frame = new JFrame("Cryptographics");
		this.frame.setSize(1366, 768); // Basic size for testing. Needs to be fullscreen in the end
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void loadStartController() {
		
	}
	
	private void loadVisualizationContainerController() {
		
	}
}
