package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

/**
 * Simple interface to simulate high-order functions,
 * which java doesn't have
 * 
 * @author kai
 *
 */
public interface NextStepCallback {
	
	/** our high-order function or callback */
	public void callback();

}
