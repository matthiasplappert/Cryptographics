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
	public int getIdleTimeout() {
		return 5 * 60 * 1000;
	}
	
	/**
	 * Returns the time in milliseconds for the program reset after a user is
	 * detected as idle.
	 * @return the timeout in milliseconds
	 */
	public int getResetTimeout() {
		return 60 * 1000;
	}
	
	/**
	 * Returns true if the debug mode should be used.
	 * @return true if the debug mode is enabled 
	 */
	public boolean isDebugModeEnabled() {
		return true;
	}
	
	/**
	 * Returns true if the mouse cursor should be visible. This setting
	 * will always return false if debug mode is disabled.
	 * 
	 * @return true if the mouse cursor should be visible
	 */
	public boolean isMouseCursorEnabled() {
		if (this.isDebugModeEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns true if the look and feel should be enabled. This setting
	 * will always return true if debug mode is disabled.
	 * 
	 * @return true if the look and feel should be enabled
	 */
	public boolean isLookAndFeelEnabled() {
		if (this.isDebugModeEnabled()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns true if the fullscreen mode should be enabled. This setting
	 * will always return true if debug mode is disabled.
	 * @return
	 */
	public boolean isFullscreenModeEnabled() {
		if (this.isDebugModeEnabled()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns the ISO 639-1 language code used for localization.
	 * @return the ISO 639-1 language code
	 */
	public String getLanguageCode() {
		return "de_DE";
	}
}
