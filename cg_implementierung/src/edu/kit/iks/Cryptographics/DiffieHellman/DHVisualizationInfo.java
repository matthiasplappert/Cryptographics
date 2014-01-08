package edu.kit.iks.Cryptographics.DiffieHellman;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoFifthController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoFirstController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoFourthController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoSecondController;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.DHDemoThirdController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.DHExperimentFirstController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.DHExperimentFourthController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.DHExperimentSecondController;
import edu.kit.iks.Cryptographics.DiffieHellman.Experiment.DHExperimentThirdController;
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
		
		controllerClasses.add(DHDemoFirstController.class);
		controllerClasses.add(DHDemoSecondController.class);
		controllerClasses.add(DHDemoThirdController.class);
		controllerClasses.add(DHDemoFourthController.class);
		controllerClasses.add(DHDemoFifthController.class);
		controllerClasses.add(DHExperimentFirstController.class);
		controllerClasses.add(DHExperimentSecondController.class);
		controllerClasses.add(DHExperimentThirdController.class);
		controllerClasses.add(DHExperimentFourthController.class);
		
		return controllerClasses;
	}

	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
