package edu.kit.iks.Cryptographics;

import java.util.List;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * This class is a registry where all {VisualisationInfo}-objects are 
 * accessible through the static {loadAllVisualizationInfo()}-method.
 * Objects of this class cannot be instantiated
 * 
 * @author Christian Dreher
 */
public class VisualizationInfoLoader {
	
	/**
	 * Private constructor to prevent this class from being instantiated
	 */
	private VisualizationInfoLoader() {
		
	}
	
	/**
	 * Returns a list of all {VisualizationInfo}-objects 
	 * 
	 * @return A list of all {VisualizationInfo}-objects 
	 */
	static public List<AbstractVisualizationInfo> loadAllVisualizationInfos() {
		return null;
	}
}
