package edu.kit.iks.Cryptographics.Example;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class VisualizationInfo extends AbstractVisualizationInfo {

	@Override
	public String getId() {
		return "example";
	}

	@Override
	public String getName() {
		return "Example";
	}

	@Override
	public String getDescription() {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
	}

	@Override
	public float getTimelineOffset() {
		return 0.99f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.HARD;
	}

	@Override
	public int getYear() {
		return 2014;
	}

	@Override
	public String getQRCodeContent() {
		return "Test";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		
		controllerClasses.add(FirstController.class);
		controllerClasses.add(SecondController.class);
		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}
}
