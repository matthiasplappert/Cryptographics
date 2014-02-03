package edu.kit.iks.Cryptographics.Example;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.VisualizationView;
import edu.kit.iks.CryptographicsLib.MouseClickListener;

public class SecondController extends AbstractVisualizationController {

	public SecondController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ullamcorper velit sit amet dictum fringilla. Proin convallis ipsum ante, sed lacinia lorem luctus in.";
	}

	@Override
	public void loadView() {
		VisualizationView v = new VisualizationView();
		v.getBackButton().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		v.getNextButton().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentNextVisualizationController();
			}
		});
		
		this.view = v;
		this.view.add(new JLabel("Second"));
		this.view.setBackground(Color.RED);
		this.view.validate();
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
}
