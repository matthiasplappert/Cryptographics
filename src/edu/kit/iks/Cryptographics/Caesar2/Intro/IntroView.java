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

import edu.kit.iks.Cryptographics.Caesar2.CaesarVisualizationInfo;
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
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(IntroView.class);
	
	/**
	 * Strings for localization
	 * 
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 */
	private static class Strings {
		public static String skipIntro = IntroView.i18n.tr("Skip Introduction");
		public static String proceed = IntroView.i18n.tr("Tell me more");
		public static String caesarsConquerPlan = IntroView.i18n.tr("One fine day, at about 70 B.C., Caesar was "
				+ "puzzling on an extremely brilliant plan to finally conquer Gallia and was about to "
				+ "send it to his generals.");
		public static String courierCarryingPlan = IntroView.i18n.tr("Unfortunately his courier took the "
				+ "way through the forest, where Kryptolix chased some wild boars.");
		public static String courierCaughtByKryptolix = IntroView.i18n.tr("When Kryptolix noticed the "
				+ "unsuspecting and whistling roman courier, he punched him back to Rome as the crow flies. "
				+ "But the courier had lost his invaluable scroll!");
		public static String kryptolixReadingPlan = IntroView.i18n.tr("When reading the scroll the courier "
				+ "lost, Kryptolix identified it as Caesar's plan to conquer Gallia. Because of this, "
				+ "Kryptolix and his friends were able to defeat Caesar once more!");
		public static String caesarsPlanCrossed = IntroView.i18n.tr("Caesar was raging! While he was "
				+ "torturing some Gauls, suddenly an hellacious and foolproof idea crossed his mind. "
				+ "In his next message he would encrypt his name! Hue Hue Hue. Help him!");
	}
	
	/**
	 * Current step inside this view
	 */
	private int step = 0;
	
	/**
	 * Namespace of this view
	 */
	private String resourceNamespace;

	public IntroView() {
		this.setNextButton(IntroView.Strings.skipIntro);
		this.setStepButton(IntroView.Strings.proceed);
		
		this.resourceNamespace = (new CaesarVisualizationInfo()).getId();
	}
	
	/**
	 * Loads the next frame
	 * 
	 * @return true, of skipping frame was successful, false, if the last frame was already reached
	 */
	public boolean nextStep() {
		this.step++;
		this.clearContentContainer();
		
		switch (step) {
			case 1:
				this.courierCarryingPlan();
				break;
			case 2:
				this.courierCaughtByKryptolix();
				break;
			case 3:
				this.kryptolixReadingPlan();
				break;
			case 4:
				this.caesarsPlanCrossed();
				break;
			case 5:
				return false;
		}
		
		this.validate();
		return true;
	}
	
	public void caesarsConquerPlan() {
		this.addPartialView(ResourceUtil.getImageViewFromResourceId(this.resourceNamespace, "CaesarIdea"));
		
		this.addText(IntroView.Strings.caesarsConquerPlan);
	}
	
	public void courierCarryingPlan() {
		this.addPartialView(ResourceUtil.getImageViewFromResourceId(this.resourceNamespace, "Courier"));
		
		this.addText(IntroView.Strings.courierCarryingPlan);
	}
	
	public void courierCaughtByKryptolix() {
		this.addPartialView(ResourceUtil.getImageViewFromResourceId(this.resourceNamespace, "FlyingCourier"));
		
		this.addText(IntroView.Strings.courierCaughtByKryptolix);
	}
	
	public void kryptolixReadingPlan() {
		this.addPartialView(ResourceUtil.getImageViewFromResourceId(this.resourceNamespace, "Kryptolix"));
		
		this.addText(IntroView.Strings.kryptolixReadingPlan);
	}
	
	public void caesarsPlanCrossed() {
		this.addPartialView(ResourceUtil.getImageViewFromResourceId(this.resourceNamespace, "CaesarAngry"));
		
		this.addText(IntroView.Strings.caesarsPlanCrossed);
	}
}
