package edu.kit.iks.CryptographicsLib;

import java.util.Date;

public class Logger {
	private static boolean debugMode = false;
	
	public static boolean debugModeActive() {
		return Logger.debugMode;
	}
	
	public static void setDebugMode() {
		Logger.debugMode = true;
	}
	
	public static void l(String logEntry) {
		Date date = new java.util.Date();
		// TODO: log in file with timestamp (date+time)
	}
	
	public static void d(String classID, String method, String debugText) {
		if (Logger.debugMode) {
			
			System.out.println("[Debug]: " + classID + "::" + method + "() - " + debugText);
		}
	}
}
