package edu.kit.iks.Cryptographics;

import java.io.File;
import java.io.IOException;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import edu.kit.iks.CryptographicsLib.Logger;

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
	
	private int idleTimeout = 5 * 60 * 1000;
	
	private int resetTimeout = 60 * 1000;
	
	private boolean debugModeEnabled = false;
	
	private boolean fullscreenModeEnabled = true;
	
	private boolean lookAndFeelEnabled = true;
	
	private boolean mouseCursorEnabled = false;
	
	private String languageCode = "en_US";
	
	/**
	 * Marked as private to enforce singleton pattern.
	 */
	private Configuration(String path) {
		try {
			// Load document.
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(new File(path));

			// Get root element.
			Element element = document.getRootElement();
			for (Element child : element.getChildren()) {
				String value = child.getValue();
				String name = child.getName();
				switch (name) {
					case "idleTimeout":
						this.idleTimeout = Integer.parseInt(value);
						break;
						
					case "resetTimeout":
						this.resetTimeout = Integer.parseInt(value);
						break;
						
					case "debugModeEnabled":
						this.debugModeEnabled = Boolean.parseBoolean(value);
						break;
						
					case "fullscreenModeEnabled":
						this.fullscreenModeEnabled = Boolean.parseBoolean(value);
						break;
						
					case "lookAndFeelEnabled":
						this.lookAndFeelEnabled = Boolean.parseBoolean(value);
						break;
						
					case "mouseCursorEnabled":
						this.mouseCursorEnabled = Boolean.parseBoolean(value);
						break;
						
					case "languageCode":
						this.languageCode = value;
						break;
						
					default:
						Logger.d("Configuration", "Configuration", "Unknown configuration element " + child.getName() + ". Skipping.");
						break;
				}
			}
		} catch (JDOMException | IOException e) {
			// Could not read configuration. Use default values.
			Logger.e(e);
		}
	}
	
	/**
	 * Returns a shared instance (singleton pattern)
	 * @return the shared instance
	 */
	static public Configuration getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new Configuration("config.xml");
		}
		return sharedInstance;
	}
	
	/**
	 * Returns the time in milliseconds after that a user is considered idle.
	 * @return the timeout in milliseconds
	 */
	public int getIdleTimeout() {
		return this.idleTimeout;
	}
	
	/**
	 * Returns the time in milliseconds for the program reset after a user is
	 * detected as idle.
	 * @return the timeout in milliseconds
	 */
	public int getResetTimeout() {
		return this.resetTimeout;
	}
	
	/**
	 * Returns true if the debug mode should be used.
	 * @return true if the debug mode is enabled 
	 */
	public boolean isDebugModeEnabled() {
		return this.debugModeEnabled;
	}
	
	/**
	 * Returns true if the mouse cursor should be visible. This setting
	 * will always return false if debug mode is disabled.
	 * 
	 * @return true if the mouse cursor should be visible
	 */
	public boolean isMouseCursorEnabled() {
		if (this.isDebugModeEnabled()) {
			return this.mouseCursorEnabled;
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
			return this.lookAndFeelEnabled;
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
			return this.fullscreenModeEnabled;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns the ISO 639-1 language code used for localization.
	 * @return the ISO 639-1 language code
	 */
	public String getLanguageCode() {
		return this.languageCode;
	}
}
