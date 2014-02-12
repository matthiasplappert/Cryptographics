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

/**
 * The VisualizationInfo for Diffie-Hellman Key-Exchange Analogy
 * @author kai
 *
 */
public class DHVisualizationInfo extends AbstractVisualizationInfo {
	
	/**
	 * Our description of the procedure
	 */
	private String description = "The infamous Diffie-Hellman Key-Exchange " +
			"explained with a color-mixing analogy. Establish a shared secret, " +
			"without an Eavesdropper getting the secret too";
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
	 */
	@Override
	public String getId() {
		return "diffiehellman";
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
	 */
	@Override
	public String getName() {
		return "Diffie-Hellman";
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset()
	 */
	@Override
	public float getTimelineOffset() {
		return 0.66f;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
	 */
	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	@Override
	public int getYear() {
		return 1976;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses()
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent()
	 */
	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
