package edu.kit.iks.CryptographicsLib;

public class Logger {
	private static boolean debugMode = false;
	
	public static boolean debugModeActive() {
		return Logger.debugMode;
	}
	
	public static void setDebugMode() {
		Logger.debugMode = true;
	}
	
	public static void log(String classID, String method, String logEntry) {
		if (Logger.debugMode) {
			System.out.println("[LOG]: " + classID + "::" + method + "() - " + logEntry);
		}
	}
}
