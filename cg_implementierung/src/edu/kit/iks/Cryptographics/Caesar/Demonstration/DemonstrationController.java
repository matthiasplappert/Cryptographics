package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import edu.kit.iks.Cryptographics.Caesar.VisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

public class DemonstrationController extends AbstractVisualizationController {
	private VisualizationInfo _visualizationInfo;
	
	public DemonstrationController(VisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	this.view.addListener(new ActionListener() {
		meinHandle();
	});
	
	meinHandler();
	
	addListener(ActionListener a) {
		this.bttn.addActionListner(a)
	}
	
	
}
