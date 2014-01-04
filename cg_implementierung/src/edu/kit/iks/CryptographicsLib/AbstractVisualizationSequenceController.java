package edu.kit.iks.CryptographicsLib;

import java.awt.event.ActionEvent;
import java.util.Stack;

abstract public class AbstractVisualizationSequenceController extends AbstractVisualizationController {
	private Stack<AbstractStepController> stepHistory;
	
	abstract public AbstractStepController getInitialStep();
	
	public AbstractVisualizationSequenceController() {
		super();
		
		// Load and verify initial step.
		AbstractStepController initialStep = this.getInitialStep();
		if (initialStep == null) {
			// TODO: raise exception!
		}
		
		// Set initial step.
		this.stepHistory.push(initialStep);
		this.setChildController(initialStep);
	}
	
	public boolean hasNextStep() {
		AbstractStepController currentStep = this.stepHistory.lastElement();
		return currentStep.hasNextStep();
	}
	
	public boolean hasPreviousStep() {
		return (this.stepHistory.size() > 1);
	}
	
	public void nextStep() {
		if (!this.hasNextStep()) {
			// TODO: raise exception!
		}
		
		// Push next step to history.
		AbstractStepController nextStep = this.stepHistory.lastElement().getNextStep();
		this.stepHistory.push(nextStep);
		this.setChildController(nextStep);
	}
	
	public void previousStep() {
		if (!this.hasPreviousStep()) {
			// TODO: raise exception!
		}
		
		// Remove current step and set previous step as child.
		this.stepHistory.pop();
		AbstractStepController previousStep = this.stepHistory.lastElement();
		this.setChildController(previousStep);
	}
	
	public void nextStepActionListener(ActionEvent event) {
		if (this.hasNextStep()) {
			this.nextStep();
		}
	}
	
	public void previousStepActionListener(ActionEvent event) {
		if (this.hasPreviousStep()) {
			this.previousStep();
		}
	}
}
