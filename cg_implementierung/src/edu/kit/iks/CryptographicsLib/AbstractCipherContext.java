package edu.kit.iks.CryptographicsLib;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractCipherContext {
	private CipherStepable _nextStep;
	
	private List<CipherStepable> _previousSteps;
	
	private String _message;
	
	private String _key;
	
	private StringBuilder _cipherBuilder;
	
	abstract public CipherStepable getInitialStep();
	
	public AbstractCipherContext(String message, String key) {
		this._message = message;
		this._key = key;
		this._previousSteps = new ArrayList<CipherStepable>();
		
		this._nextStep = getInitialStep();
	}
	
	public String getMessage() {
		return this._message;
	}
	
	public String getKey() {
		return this._key;
	}
	
	public StringBuilder getCipherBuilder() {
		return this._cipherBuilder;
	}
	
	public String getCipher() {
		return this._cipherBuilder.toString();
	}
	
	public void setNextStep(CipherStepable step) {
		// TODO: add current nextStep to previousSteps if != NULL
		this._nextStep = step;
	}
	
	public void performStep() {
		this._nextStep.perform(this);
	}
	
	public void undoStep() {
		// TODO: Get previousStep, pop it from list, and call undo
		CipherStepable previousStep = null;
		previousStep.undo(this);
	}
	
	public boolean canPerformStep() {
		return (this._nextStep != null);
	}
	
	public boolean canUndoStep() {
		return (this._previousSteps.size() > 0);
	}
}
