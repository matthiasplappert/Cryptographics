package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Vigenere.VigenereVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.ImageView;

public class FirstDemonstrationController extends AbstractVisualizationController {

	/* Checks if vigenere text is read */
	private boolean vigenereRead = false;
	private VigenereVisualizationInfo vsInfo;
	
	
	public FirstDemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.vsInfo = (VigenereVisualizationInfo)visualizationInfo;
	}

	@Override
	public String getHelp() {
		return null;
	}

	@Override
	public void loadView() {
		this.vigenereRead = false;
		this.view = new FirstDemonstrationView(vsInfo);
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vigenereRead) {
					vigenereRead = false;
					getView().getModuloText().setVisible(false);
					getView().getClock().setVisible(false);
				}
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!vigenereRead) {
					getView().getModuloText().setVisible(true);
					getView().getClock().setVisible(true);
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
