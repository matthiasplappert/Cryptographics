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
import edu.kit.iks.cryptographicslib.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.Configuration;
import edu.kit.iks.cryptographicslib.controller.AbstractVisualizationController;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class DemoController extends AbstractVisualizationController {

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
		private static String noHelp = DemoController.i18n.tr("At this time, no help can be offered.");
		
		// Caesars Idea
		private static String caesarsIdea = DemoController.i18n.tr("Caesar's idea was to simply shift "
				+ "each letter in his name by three, so no undesired reader will know who sent "
				+ "the plan in the future. Press 'Proceed' and see how it works.");
		private static String helpCaesarsIdea = DemoController.i18n.tr("Just click 'Proceed' at the "
				+ "bottom to see how Caesars idea exactly works.");
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
		return this.view().getHelp();
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		this.view = new DemoView();
		
		this.prepareViewLayout();
		
		this.prepareNextActionListener();
		this.prepareBackActionListener();
		
		this.view().setStepButtonActionListener(this.prepareStepButtonActionListener());
	}

	/* (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.controller.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	private void prepareViewLayout() {
		this.view().setVariable("nextButtonLabel", DemoController.Strings.nextButtonLabel);
		this.view().setVariable("backButtonLabel", DemoController.Strings.backButtonLabel);
		this.view().setVariable("stepButtonLabel", DemoController.Strings.stepButtonLabel);
		
		this.view().prepareLayout();
	}
	
	private ActionListener prepareStepButtonActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	/**
	 * Casts the view for easier access
	 * 
	 * @return Casted view
	 */
	private DemoView view() {
		return (DemoView) this.view;
	}
}
