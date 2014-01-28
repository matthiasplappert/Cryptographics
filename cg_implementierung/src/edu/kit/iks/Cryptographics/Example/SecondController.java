package edu.kit.iks.Cryptographics.Example;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.VisualizationView;

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
		v.getBackButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentPreviousVisualizationController();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		v.getNextButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentNextVisualizationController();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		this.view = v;
		this.view.add(new JLabel("Second"));
		this.view.setBackground(Color.RED);
		this.view.validate();
	}

}
