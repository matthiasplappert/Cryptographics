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

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.ResourceUtil;
import edu.kit.iks.CryptographicsLib.views.VisualizationView;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class IntroView extends VisualizationView {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -2526016347621838350L;
	
	private static I18n i18n = Configuration.getInstance().getI18n(IntroView.class);

	public IntroView() {
		this.setNextButton(i18n.tr("Skip Introduction"));
		this.setStepButton(i18n.tr("Tell me more"));
		
		this.addPartialView(ResourceUtil.getImageViewFromResourceId("caesar", "CaesarIdea"));
		
		//this.addText("One fine day, ca 70 B.C., Caesar was puzzling on an extremely intelligent plan " 
		//		+ "to finally conquer Gallia and was about to send it to his generals.");
		
		this.validate();
	}
}
