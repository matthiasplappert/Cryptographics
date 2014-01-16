package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Vigenere.*;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class FirstDemonstrationController extends AbstractVisualizationController {

	/* Checks if vigenere text is read */
	private boolean vigenereRead = false;
	
	public FirstDemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		return null;
	}

	@Override
	public void loadView() {
		this.view = new FirstDemonstrationView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vigenereRead) {
					vigenereRead = false;
					getView().getModuloText().setVisible(false);
					// TODO Hide clock
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!vigenereRead) {
					getView().getModuloText().setVisible(true);
					// TODO show clock
					vigenereRead = true;
				} else {
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
				}
			}
		});
		this.view.validate();
	}
	
	@Override
	public FirstDemonstrationView getView() {
		return (FirstDemonstrationView) this.view;
	}
	
}
