package edu.kit.iks.Cryptographics.Caesar;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.Cryptographics.Caesar.Demonstration.CFirstState;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.CSecondState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CFifthState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CFourthState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CThirdState;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
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
		List<Class> controllerClasses =
			new ArrayList<Class>();
		
		controllerClasses.add(CFirstState.class);
		controllerClasses.add(CSecondState.class);
		controllerClasses.add(CThirdState.class);
		controllerClasses.add(CFourthState.class);
		controllerClasses.add(CFifthState.class);
		
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