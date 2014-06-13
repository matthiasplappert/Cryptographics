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
package edu.kit.iks.cryptographics.caesar.controller;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.cryptographics.caesar.views.intro.IntroView;
import edu.kit.iks.cryptographics.caesar.views.intro.partials.CaesarsConquerPlan;
import edu.kit.iks.cryptographics.caesar.views.intro.partials.CaesarsPlanCrossed;
import edu.kit.iks.cryptographics.caesar.views.intro.partials.CourierCarryingPlan;
import edu.kit.iks.cryptographics.caesar.views.intro.partials.CourierCaughtByKryptolix;
import edu.kit.iks.cryptographics.caesar.views.intro.partials.KryptolixReadingPlan;
import edu.kit.iks.cryptographicslib.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.Configuration;
import edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class IntroController extends AbstractSteppableVisualizationController {

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
		// Navigation labels
		public static String nextButtonLabel = IntroController.i18n.tr("Skip introduction");
		public static String stepButtonLabel = IntroController.i18n.tr("Tell me more");
		
		// Help
		public static String help = IntroController.i18n.tr("If you want to hear the story "
				+ "of how Caesar came up with encrypting, click \'Tell me more\', otherwise "
				+ "click \'Skip Introduction\'");

		// Story texts
		public static String caesarsConquerPlan = IntroController.i18n.tr("One fine day, at about 70 B.C., Caesar was "
				+ "puzzling on an extremely brilliant plan to finally conquer Gallia and was about to "
				+ "send it to his generals.");
		public static String courierCarryingPlan = IntroController.i18n.tr("Unfortunately his courier took the "
				+ "way through the forest, where Kryptolix chased some wild boars.");
		public static String courierCaughtByKryptolix = IntroController.i18n.tr("When Kryptolix noticed the "
				+ "unsuspecting and whistling roman courier, he punched him back to Rome as the crow flies. "
				+ "But the courier had lost his invaluable scroll!");
		public static String kryptolixReadingPlan = IntroController.i18n.tr("When reading the scroll the courier "
				+ "lost, Kryptolix identified it as Caesar\'s plan to conquer Gallia. Because of this, "
				+ "Kryptolix and his friends were able to defeat Caesar once more!");
		public static String caesarsPlanCrossed = IntroController.i18n.tr("Caesar was raging! While he was "
				+ "torturing some minions, suddenly an hellacious and foolproof idea crossed his mind. "
				+ "In his next message he would encrypt his name! Hue Hue Hue. Help him!");
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

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController#loadView(edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController.RunningOrderHelper)
	 */
	@Override
	public void loadView(RunningOrderHelper roh) {
		// Set variables for view
		VariableHelper vh = new VariableHelper();
		
		vh.add("nextButtonLabel", IntroController.Strings.nextButtonLabel);
		vh.add("stepButtonLabel", IntroController.Strings.stepButtonLabel);
		
		// Create view
		this.view = new IntroView(vh.toList());
		
		// Use default button behavior
		this.useDefaultNextButtonBehavior();
		this.useDefaultStepButtonBehavior();
		
		// Define running order
		this.defineRunningOrder(roh);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	private void defineRunningOrder(RunningOrderHelper roh) {
		roh.enqueue(this.prepareCaesarsConquerPlan());
		roh.enqueue(this.prepareCourierCarryingPlan());
		roh.enqueue(this.prepareCourierCaughtByKryptolix());
		roh.enqueue(this.prepareKryptolixReadingPlan());
		roh.enqueue(this.prepareCaesarsPlanCrossed());
	}
	
	private CaesarsConquerPlan prepareCaesarsConquerPlan() {
		VariableHelper vh = new VariableHelper();
		vh.add("caesarsConquerPlan", IntroController.Strings.caesarsConquerPlan);
		
		return new CaesarsConquerPlan(vh.toList());
	}
	
	private CourierCarryingPlan prepareCourierCarryingPlan() {
		VariableHelper vh = new VariableHelper();
		vh.add("courierCarryingPlan", IntroController.Strings.courierCarryingPlan);
		
		return new CourierCarryingPlan(vh.toList());
	}
	
	private CourierCaughtByKryptolix prepareCourierCaughtByKryptolix() {
		VariableHelper vh = new VariableHelper();
		vh.add("courierCaughtByKryptolix", IntroController.Strings.courierCaughtByKryptolix);
		
		return new CourierCaughtByKryptolix(vh.toList());
	}
	
	private KryptolixReadingPlan prepareKryptolixReadingPlan() {
		VariableHelper vh = new VariableHelper();
		vh.add("kryptolixReadingPlan", IntroController.Strings.kryptolixReadingPlan);
		
		return new KryptolixReadingPlan(vh.toList());
	}
	
	private CaesarsPlanCrossed prepareCaesarsPlanCrossed() {
		VariableHelper vh = new VariableHelper();
		vh.add("caesarsPlanCrossed", IntroController.Strings.caesarsPlanCrossed);
		
		return new CaesarsPlanCrossed(vh.toList());
	}

}
