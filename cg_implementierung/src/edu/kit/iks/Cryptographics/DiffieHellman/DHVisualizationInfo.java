package edu.kit.iks.Cryptographics.DiffieHellman;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ExplainAimController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.OnewayController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DemoOneWayController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.YourTurnController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.DHExperimentController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.CongratsController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class DHVisualizationInfo extends AbstractVisualizationInfo {
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
		return 0.66f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	@Override
	public int getYear() {
		return 1976;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		
		controllerClasses.add(ExplainAimController.class);
		controllerClasses.add(OnewayController.class);
		controllerClasses.add(DemoOneWayController.class);
		controllerClasses.add(DHDemoController.class);
		controllerClasses.add(YourTurnController.class);
		controllerClasses.add(DHExperimentController.class);
		controllerClasses.add(CongratsController.class);
		
		return controllerClasses;
	}

	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
