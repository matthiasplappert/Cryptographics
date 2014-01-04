package edu.kit.iks.Cryptographics.Caesar;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.Caesar.Demonstration.CIntroductionController;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.CCipherDemoController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CHistrogramController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CDecryptingController;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CEncryptingController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.InformationController;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;

/**
 * @author Wasilij Beskorovajnov.
 *
 */
public class VisualizationInfo extends AbstractVisualizationInfo {
	
	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
	 */
	public String getId() {
		return "caesar";
	}
	
	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
	 */
	public String getName() {
		return "Caesar";
	}
	
	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
	 */
	public String getDescription() {
		return "Get to know how Ceasar fooled his enemys that " +
				"intercepted his orders and see one of the oldest " +
				"attempts to make confidential material unreadable " +
				"for undesireable readers";
	}

	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset()
	 */
	public float getTimelineOffset() {
		return 0.0f;
	}

	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
	 */
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	public int getYear() {
		//when getYear() negative then it's the year B.C.
		//The year is an estimation!!!
		return -70;
	}
	
	/* 
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses()
	 */
	public List<Class> getControllerClasses() {
		List<Class> controllerClasses = new ArrayList<Class>();
		
		controllerClasses.add(CIntroductionController.class);
		controllerClasses.add(CCipherDemoController.class);
		controllerClasses.add(CEncryptingController.class);
		controllerClasses.add(CDecryptingController.class);
		controllerClasses.add(CHistrogramController.class);
		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent()
	 */
	@Override
	public String getQRCodeContent() {
		// TODO Auto-generated method stub
		return null;
	}
}