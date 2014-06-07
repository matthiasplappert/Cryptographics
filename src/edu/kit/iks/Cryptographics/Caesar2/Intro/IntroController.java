/**
 * Copyright (c) 2014 Christian Dreher <uaeef@student.kit.edu>
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
package edu.kit.iks.Cryptographics.Caesar2.Intro;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.controller.AbstractVisualizationController;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class IntroController extends AbstractVisualizationController {

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(IntroController.class);
	
	/**
	 * Strings to be displayed
	 * 
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 */
	private static class Strings {
		public static String help = IntroController.i18n.tr("If you want to hear the story, "
				+ "click 'Proceed', otherwise skip it by clicking the "
				+ "'Skip Introduction' button.");
	}
	
	/**
	 * @param visualizationInfo
	 */
	public IntroController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		return IntroController.Strings.help;
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		this.view = new IntroView();
		this.prepareNextActionListener();
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
}
