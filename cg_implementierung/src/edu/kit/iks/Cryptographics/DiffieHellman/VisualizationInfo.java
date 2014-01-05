package edu.kit.iks.Cryptographics.DiffieHellman;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class VisualizationInfo extends AbstractVisualizationInfo {
	@Override
	public String getId() {
		return "diffiehellman";
	}
	
	@Override
	public String getName() {
		return "Diffie-Hellman";
	}
	
	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public float getTimelineOffset() {
		return 0.0f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	@Override
	public int getYear() {
		return 1976;
	}
	
	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		
		controllerClasses.add(DemonstrationController.class);
		controllerClasses.add(ExperimentController.class);
		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}

	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
