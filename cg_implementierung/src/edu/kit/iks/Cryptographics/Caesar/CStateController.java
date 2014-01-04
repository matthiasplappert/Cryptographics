package edu.kit.iks.Cryptographics.Caesar;

import java.util.HashMap;
import java.util.Map;

import edu.kit.iks.Cryptographics.Caesar.Demonstration.CFirstState;
import edu.kit.iks.Cryptographics.Caesar.Demonstration.CSecondState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CFifthState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CFourthState;
import edu.kit.iks.Cryptographics.Caesar.Experiment.CThirdState;

/**
 * Class that keeps track of the current states and controls the switching
 * between them.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CStateController {

	/**
	 * Key that keeps track of the current state. Is in- and decremented when
	 * switching to next/previous state. Zero means the visualization hasn't
	 * begun.
	 */
	protected int key = 0;

	/**
	 * @return
	 */
	public Map<Integer, Class> getControllerClasses() {
		Map<Integer, Class> controllerClasses = new HashMap<Integer, Class>();

		controllerClasses.put(1, CFirstState.class);
		controllerClasses.put(2, CSecondState.class);
		controllerClasses.put(3, CThirdState.class);
		controllerClasses.put(4, CFourthState.class);
		controllerClasses.put(5, CFifthState.class);

		return controllerClasses;
	}

	/**
	 * Switches to the next state.
	 */
	public Class nextState() {
		key++;
		return getControllerClasses().get(key);
	}

	/**
	 * Switches to the previous state.
	 */
	public Class previousState() {
		key--;
		return getControllerClasses().get(key);
	}

}
