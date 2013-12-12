package edu.kit.iks.CryptograhicsLib;

public interface CipherStepable {
	 public void perform(AbstractCipherContext context);
	 
	 public void undo(AbstractCipherContext context);
}
