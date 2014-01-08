package edu.kit.iks.Cryptographics.Example;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.Caesar.Demonstration.CipherDemoController;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.IntroductionController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.HistrogramController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

public class VisualizationInfo extends AbstractVisualizationInfo {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "example";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Example";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Desc";
	}

	@Override
	public float getTimelineOffset() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	@Override
	public VisualizationDifficulty getDifficulty() {
		// TODO Auto-generated method stub
		return VisualizationDifficulty.EASY;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 2014;
	}

	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		
		controllerClasses.add(FirstController.class);
		controllerClasses.add(SecondController.class);
		
		return controllerClasses;
	}

}
