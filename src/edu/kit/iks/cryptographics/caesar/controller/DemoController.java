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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.cryptographics.caesar.views.demo.DemoView;
import edu.kit.iks.cryptographics.caesar.views.demo.partials.CaesarsIdea;
import edu.kit.iks.cryptographicslib.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.Configuration;
import edu.kit.iks.cryptographicslib.controller.AbstractSteppableVisualizationController;

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
		private static String noHelp = DemoController.i18n.tr("No help can be offered at the moment.");
		
		// Caesars Idea
		private static String caesarsIdea = DemoController.i18n.tr("Caesar\'s idea was to simply shift "
				+ "each letter in his name by three, so no undesired reader will know who sent "
				+ "the plan in the future. Press \'Proceed\' and see how it works.");
		private static String helpCaesarsIdea = DemoController.i18n.tr("Just click \'Proceed\' at the "
				+ "bottom to see how Caesars idea exactly works.");
	}
	
	private static class Steps {
		public final static int CAESARS_IDEA = 1;
	}
	
	/**
	 * @param visualizationInfo
	 */
	public DemoController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		String help;
		
		switch (this.getCurrentStep()) {
			case DemoController.Steps.CAESARS_IDEA:
				help = DemoController.Strings.helpCaesarsIdea;
				break;
			default:
				help = DemoController.Strings.noHelp;
				break;
		}
		
		return help;
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
		
		this.view = new DemoView(vh.toList());
		
		this.useDefaultNextButtonBehavior();
		this.useDefaultBackButtonBehavior();
		this.view().setStepButtonActionListener(this.getStepActionListener());
		
		this.defineRunningOrder(roh);
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}

	private DemoView view() {
		return (DemoView) this.view;
	}
	
	private ActionListener getStepActionListener() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		return al;
	}
	
	private void defineRunningOrder(RunningOrderHelper roh) {
		roh.enqueue(DemoController.Steps.CAESARS_IDEA, this.prepareCaesarsIdea());
	}
	
	private CaesarsIdea prepareCaesarsIdea() {
		VariableHelper vh = new VariableHelper();
		
		vh.add("caesarsIdea", DemoController.Strings.caesarsIdea);
		
		return new CaesarsIdea(vh.toList());
	}
}
