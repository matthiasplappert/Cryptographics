package edu.kit.iks.CryptograhicsLib;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractCipherContext {
	private CipherStepable nextStep;
	
	private List<CipherStepable> previousSteps;
	
	private String message;
	
	private String key;
	
	private StringBuilder cipherBuilder;
	
	abstract public CipherStepable getInitialStep();
	
	public AbstractCipherContext(String message, String key) {
		this.message = message;
		this.key = key;
		this.previousSteps = new ArrayList<CipherStepable>();
		
		this.nextStep = getInitialStep();
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public StringBuilder getCipherBuilder() {
		return this.cipherBuilder;
	}
	
	public String getCipher() {
		return this.cipherBuilder.toString();
	}
	
	public void setNextStep(CipherStepable step) {
		// TODO: add current nextStep to previousSteps if != NULL
		this.nextStep = step;
	}
	
	public void performStep() {
		this.nextStep.perform(this);
	}
	
	public void undoStep() {
		// TODO: Get previousStep, pop it from list, and call undo
		CipherStepable previousStep = null;
		previousStep.undo(this);
	}
	
	public boolean canPerformStep() {
		return (this.nextStep != null);
	}
	
	public boolean canUndoStep() {
		return (this.previousSteps.size() > 0);
	}
}
