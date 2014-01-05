package edu.kit.iks.CryptographicsLib;

public interface CipherStepable {
	 public void perform(AbstractCipherContext context);
	 
	 public void undo(AbstractCipherContext context);
}
