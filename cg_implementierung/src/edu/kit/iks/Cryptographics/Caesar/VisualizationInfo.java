package edu.kit.iks.Cryptographics.Caesar;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.VisualizationDifficulty;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.DemonstrationController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.ExperimentController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;

public class VisualizationInfo extends AbstractVisualizationInfo {
	
	public String getId() {
		return "caesar";
	}
	
	public String getName() {
		return "Caesar";
	}
	
	public String getDescription() {
		return "Get to know how Ceasar fooled his enemys that " +
				"intercepted his orders and see one of the oldest " +
				"attempts to make confidential material unreadable " +
				"for undesireable readers";
	}

	public float getTimelineOffset() {
		return 0.0f;
	}

	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	public int getYear() {
		//when getYear() returns negative value it's the year B.C.
		//The year is an estimation!!!
		return -70;
	}
	
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses =
			new ArrayList<Class>();
		
		controllerClasses.add(DemonstrationController.class);
		controllerClasses.add(ExperimentController.class);
		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}
}