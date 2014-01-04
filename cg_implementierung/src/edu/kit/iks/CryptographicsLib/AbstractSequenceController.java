package edu.kit.iks.CryptographicsLib;

import java.awt.event.ActionEvent;
import java.util.Stack;

abstract public class AbstractSequenceController extends AbstractController {
	private Stack<Stepable> stepHistory;
	
	abstract public Stepable getInitialStep();
	
	public AbstractSequenceController() {
		super();
		
		// Load and verify initial step.
		Stepable initialStep = this.getInitialStep();
		if (initialStep == null) {
			// TODO: raise exception!
		}
		if (!(initialStep instanceof AbstractController)) {
			// TODO: raise exception!
		}
		
		// Set initial step.
		this.stepHistory.push(initialStep);
		this.setChildController((AbstractController)initialStep);
	}
	
	public boolean hasNextStep() {
		Stepable currentStep = this.stepHistory.lastElement();
		return currentStep.hasNextStep();
	}
	
	public boolean hasPreviousStep() {
		return (this.stepHistory.size() > 1);
	}
	
	public void nextStep() {
		if (!this.hasNextStep()) {
			// TODO: raise exception!
		}
		
		// Verify that next step is an AbstractController.
		Stepable nextStep = this.stepHistory.lastElement().getNextStep();
		if (!(nextStep instanceof AbstractController)) {
			// TODO: raise an exception!
		}
		
		// Push next step to history.
		this.stepHistory.push(nextStep);
		this.setChildController((AbstractController)nextStep);
	}
	
	public void previousStep() {
		if (!this.hasPreviousStep()) {
			// TODO: raise exception!
		}
		
		// Remove current step and set previous step as child.
		this.stepHistory.pop();
		Stepable previousStep = this.stepHistory.lastElement();
		this.setChildController((AbstractController)previousStep);
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
