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

package edu.kit.iks.Cryptographics.Caesar2;

import java.util.ArrayList;
import java.util.List;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Caesar2.Demo.DemoController;
import edu.kit.iks.Cryptographics.Caesar2.Intro.IntroController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.VisualizationDifficulty;
import edu.kit.iks.CryptographicsLib.controller.InformationController;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CaesarVisualizationInfo extends AbstractVisualizationInfo {

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(
			CaesarVisualizationInfo.class);

	/**
	 * Constructor for the visualizationInfo.
	 */
	public CaesarVisualizationInfo() {
	
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses ()
	 */
	@Override
	public List<Class<?>> getControllerClasses() {
		List<Class<?>> controllerClasses = new ArrayList<>();

		controllerClasses.add(IntroController.class);
		controllerClasses.add(DemoController.class);
		controllerClasses.add(InformationController.class);

		return controllerClasses;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		String description = CaesarVisualizationInfo.i18n
				.tr("Get to know how Caesar fooled his enemys that "
						+ "intercepted his orders and see one of the oldest "
						+ "attempts to make confidential material unreadable "
						+ "for undesireable readers.");

		return description;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
	 */
	@Override
	public VisualizationDifficulty getDifficulty() {
		return VisualizationDifficulty.EASY;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
	 */
	@Override
	public String getId() {
		return "caesar";
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
	 */
	@Override
	public String getName() {
		return CaesarVisualizationInfo.i18n.tr("Caesar");
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent ()
	 */
	@Override
	public String getQRCodeContent() {
		return i18n.tr("http://en.wikipedia.org/wiki/Caesar_cipher");
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset ()
	 */
	@Override
	public float getTimelineOffset() {
		return 0.05f;
	}

	/*
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
	 */
	@Override
	public int getYear() {
		// when getYear() negative then it's the year B.C.
		// The year is an estimation!!!
		return -70;
	}

}