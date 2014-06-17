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

import edu.kit.iks.cryptographics.caesar.view.demo.DemoView;
import edu.kit.iks.cryptographics.caesar.view.demo.partial.CaesarsIdea;
import edu.kit.iks.cryptographics.caesar.view.demo.partial.TryEncryptCaesar;
import edu.kit.iks.cryptographicslib.framework.controller.AbstractSteppableVisualizationController;
import edu.kit.iks.cryptographicslib.framework.model.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.util.Configuration;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class DemoController extends AbstractSteppableVisualizationController {

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(DemoController.class);
	
	/**
	 * Localized strings used in this view
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 *
	 */
	private static class Strings {
		// Navigation labels and various
		private static String nextButtonLabel = DemoController.i18n.tr("Skip demonstration");
		private static String backButtonLabel = DemoController.i18n.tr("Back to introduction");
		private static String stepButtonLabel = DemoController.i18n.tr("Proceed");
		
		// Caesars Idea
		private static String caesarsIdea = DemoController.i18n.tr("Caesar\'s idea was to simply shift "
				+ "each letter in his name by three, so no undesired reader will know who sent "
				+ "the plan in the future. Press \'Proceed\' and see how it works.");
		private static String helpCaesarsIdea = DemoController.i18n.tr("Just click \'Proceed\' at the "
				+ "bottom to see how Caesars idea exactly works.");
		
		// Example encrypting "C" of Caesar
		private static String caesarName = DemoController.i18n.tr("CAESAR");
		private static String explanation = DemoController.i18n.tr("Let\'s start with the first letter, \'C\'. "
				+ "Below you can see an alphabet strip...");
	}
	
	/**
	 * Instance to manipulate directly on actions
	 */
	private TryEncryptCaesar tryEncryptCaesar;

	/**
	 * @param visualizationInfo
	 */
	public DemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.cryptographicslib.controller.AbstractVisualizationController#routeAction(java.lang.String)
	 */
	@Override
	public boolean routeAction(String callerId) {
		switch (callerId) {
			case "tryEncrypt":
				this.tryEncryptAction();
				break;
			case "encryptSecondLetter":
				this.encryptSecondLetterAction();
				break;
			default:
				return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController#loadView(edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController.RunningOrderHelper)
	 */
	@Override
	public void loadView(RunningOrderHelper roh) {
		VariableHelper vh = new VariableHelper();
		
		vh.add("nextButtonLabel", DemoController.Strings.nextButtonLabel);
		vh.add("backButtonLabel", DemoController.Strings.backButtonLabel);
		vh.add("stepButtonLabel", DemoController.Strings.stepButtonLabel);
		
		this.view = new DemoView(this, vh.toList());
		
		this.defineRunningOrder(roh);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
		this.tryEncryptCaesar = null;
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String helpAction() {
		return this.view().getHelp();
	}
	
	/**
	 * Default Action
	 * 
	 * Overridden, because the partial view will be reused for the
	 * next step, therefore the default behavior is undesired
	 * 
	 * @see edu.kit.iks.cryptographicslib.framework.controller.AbstractSteppableVisualizationController#indexAction()
	 */
	@Override
	protected void indexAction() {
		this.view().setStepButtonAction("tryEncrypt");
		super.indexAction();
	}
	
	/**
	 * Action to demonstrate the encryption of the first letter of Caesars name
	 */
	protected void tryEncryptAction() {
		this.view().setStepButtonAction("encryptSecondLetter");
		this.defaultStepAction();
	}
	
	/**
	 * Action to try encrypting the rest of Caesars name
	 */
	protected void encryptSecondLetterAction() {
		this.view().hideStepButton();
//		this.tryEncryptCaesar.setExplanationText("blablabla");
	}

	/**
	 * Partial view initialization: Prepares view which displays Caesars idea
	 * 
	 * @return Prepared view
	 */
	private CaesarsIdea prepareCaesarsIdea() {
		VariableHelper vh = new VariableHelper();
		
		vh.add("caesarsIdea", DemoController.Strings.caesarsIdea);
		vh.add("helpText", DemoController.Strings.helpCaesarsIdea);
		
		return new CaesarsIdea(vh.toList());
	}

	/**
	 * Partial view initialization: Prepares view which displays the demonstration
	 * 
	 * @return Prepared view
	 */
	private TryEncryptCaesar prepareTryEncryptCeasar() {
		VariableHelper vh = new VariableHelper();
		
		vh.add("explanation", DemoController.Strings.explanation);
		
		this.tryEncryptCaesar = new TryEncryptCaesar(vh.toList());
		
		return this.tryEncryptCaesar;
	}
	
	/**
	 * Helper to define the running order
	 * 
	 * @param roh Running order helper
	 */
	private void defineRunningOrder(RunningOrderHelper roh) {
		roh.enqueue(this.prepareCaesarsIdea());
		roh.enqueue(this.prepareTryEncryptCeasar());
	}
	
	/**
	 * Helper to cast the view
	 * 
	 * @return casted view
	 */
	private DemoView view() {
		return (DemoView) this.view;
	}
}
