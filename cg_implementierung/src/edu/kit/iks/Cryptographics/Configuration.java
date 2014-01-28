package edu.kit.iks.Cryptographics;

/**
 * This class allows to configure certain parameters of the application
 * at a central place.
 * 
 * @author Matthias Plappert
 *
 */
public class Configuration {
	/**
	 * Shared instance for singleton
	 */
	static private Configuration sharedInstance = null;
	
	/**
	 * Marked as private to enforce singleton pattern.
	 */
	private Configuration() {
		super();
	}
	
	/**
	 * Returns a shared instance (singleton pattern)
	 * @return the shared instance
	 */
	static public Configuration getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new Configuration();
		}
		return sharedInstance;
	}
	
	/**
	 * Returns the time in milliseconds after that a user is considered idle.
	 * @return the timeout in milliseconds
	 */
	public long getIdleTimeout() {
		return 5 * 60* 1000;
	}
	
	/**
	 * Returns the time in milliseconds for the program reset after a user is
	 * detected as idle.
	 * @return the timeout in milliseconds
	 */
	public long getResetTimeout() {
		return 60 * 1000;
	}
}
