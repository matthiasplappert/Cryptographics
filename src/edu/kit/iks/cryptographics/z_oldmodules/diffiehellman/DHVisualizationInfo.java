/**
 * Copyright (c) 2014 Matthias Jaenicke <matthias.jaenicke@student.kit.edu>,
 * Matthias Plappert <undkc@student.kit.edu>,
 * Julien Duman <uncyc@student.kit.edu>, 
 * Christian Dreher <uaeef@student.kit.edu>,
 * Wasilij Beskorovajnov <uajkm@student.kit.edu> and 
 * Aydin Tekin <aydin.tekin@student.kit.edu>
 * 
 * Released under the MIT license (refer to LICENSE.md)
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package edu.kit.iks.cryptographics.z_oldmodules.diffiehellman;

import java.util.ArrayList;
import java.util.List;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.cryptographics.z_oldmodules.diffiehellman.Demonstration.DHDemoController;
import edu.kit.iks.cryptographics.z_oldmodules.diffiehellman.Demonstration.DemoOneWayController;
import edu.kit.iks.cryptographics.z_oldmodules.diffiehellman.Demonstration.ExplainAimController;
import edu.kit.iks.cryptographics.z_oldmodules.diffiehellman.Experiment.DHExperimentController;
import edu.kit.iks.cryptographics.z_oldmodules.diffiehellman.Experiment.YourTurnController;
import edu.kit.iks.cryptographicslib.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.Configuration;
import edu.kit.iks.cryptographicslib.VisualizationDifficulty;
import edu.kit.iks.cryptographicslib.controller.InformationController;

/**
 * The VisualizationInfo for Diffie-Hellman Key-Exchange Analogy
 * @author kai
 *
 */
public class DHVisualizationInfo extends AbstractVisualizationInfo {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			DHVisualizationInfo.class);

	
	/**
	 * Our description of the procedure
	 */
	private String description = i18n.tr("The infamous Diffie-Hellman Key-Exchange " +
			"explained with a color-mixing analogy. Establish a shared secret, " +
			"without an eavesdropper also getting the secret.");
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
	 */
	@Override
	public String getId() {
		return "diffiehellman";
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
	 */
	@Override
	public String getName() {
		return i18n.tr("Diffie-Hellman");
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset()
	 */
	@Override
	public float getTimelineOffset() {
		return 0.86f;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
	 */
	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.HARD;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	@Override
	public int getYear() {
		return 1976;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses()
	 */
	@Override
	public List<Class<?>> getControllerClasses() {
		List<Class<?>> controllerClasses = new ArrayList<>();
		
		controllerClasses.add(ExplainAimController.class);
		controllerClasses.add(DemoOneWayController.class);
		controllerClasses.add(DHDemoController.class);
		controllerClasses.add(YourTurnController.class);
		controllerClasses.add(DHExperimentController.class);
//		controllerClasses.add(CongratsController.class);
		controllerClasses.add(InformationController.class);
		
		return controllerClasses;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent()
	 */
	@Override
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange");
	}
}
