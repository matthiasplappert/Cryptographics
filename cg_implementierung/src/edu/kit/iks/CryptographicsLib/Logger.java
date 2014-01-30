package edu.kit.iks.CryptographicsLib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	
	/**
	 * Debug mode initially turned off (no debug outputs in console)
	 */
	private static boolean debugMode = false;
	
	/**
	 * Name of the log file 
	 */
	private static final String LOG_FILE_NAME = "statistics.csv";
	
	/**
	 * Check whether debug mode is activated or not
	 * 
	 * @return {true}, if debug mode is activated, {false} if not
	 */
	public static boolean debugModeActive() {
		return Logger.debugMode;
	}
	
	/**
	 * Sets the debug mode 
	 */
	public static void setDebugMode() {
		Logger.debugMode = true;
	}
	
	/**
	 * Writes a new entry line in the logfile in this format:
	 * {logEntry};{UNIX timestamp}
	 * 
	 * @param logEntry Action which should be logged
	 */
	public static void l(String logEntry) {
		Date date = new java.util.Date();
		long unixTimestamp = date.getTime();
		String unixTimeString = String.valueOf(unixTimestamp);
		
    	Logger.writeLogFileLine(logEntry, unixTimeString);
	}
	
	/**
	 * Writes a new debug output to the console
	 * 
	 * @param classID Class name of this debug output
	 * @param method Method name of this debug output
	 * @param debugText Debug text which should be printed
	 */
	public static void d(String classID, String method, String debugText) {
		if (Logger.debugMode) {
			
			System.out.println("[Debug]: " + classID + "::" + method + "() - " + debugText);
		}
	}
	
	/**
	 * Helper method to write a new line into the logfile. Creates a logfile, if
	 * it doesn't exist already
	 * 
	 * @param logEntry Log entry to be written
	 * @param formattedDate To string formatted timestamp to be written
	 */
	private static void writeLogFileLine(String logEntry, String formattedDate) {
		
    	try {
    		String logEntryLine = logEntry + ";" + formattedDate + "\n";
 
    		File file = new File(Logger.LOG_FILE_NAME);
 
    		// If file doesn't exists, then create it and append header
    		if(!file.exists()) {
    			file.createNewFile();
    			Logger.writeLogFileLine("Performed action", "Unix Timestamp (milliseconds)");
    		}
 
    		// true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(), true);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	    bufferWritter.write(logEntryLine);
    	    bufferWritter.close();
 
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
}
