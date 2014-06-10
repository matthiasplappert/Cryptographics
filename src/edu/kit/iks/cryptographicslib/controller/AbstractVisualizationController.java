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

package edu.kit.iks.cryptographicslib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.cryptographics.main.controller.VisualizationContainerController;
import edu.kit.iks.cryptographicslib.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.views.AbstractVisualizationView;

/**
 * Abstract visualization controller specialized for
 * the needs of a procedure to visualize its contents
 * 
 * @author Christian Dreher
 */
public abstract class AbstractVisualizationController extends AbstractController {

	/**
	 * Helper class to easier form key value pairs for view variables
	 * 
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 */
	protected class VariableHelper {
		private List<SimpleEntry<String, String>> variables = new ArrayList<>();
		
		public VariableHelper() {
			
		}
		
		public void add(String key, String value) {
			this.variables.add(new SimpleEntry<>(key, value));
		}
		
		public List<SimpleEntry<String, String>> toList() {
			return this.variables;
		}
	}
	
	/**
	 * {VisualizationInfo}-object holding all metadata of the procedure
	 */
	private AbstractVisualizationInfo visualizationInfo;
	
	/**
	 * Constructor initializing a new instance of AbstractVisualizationController 
	 * with given {visualizationInfo}
	 * 
	 * @param visualizationInfo {VisualizationInfo}-object holding 
	 * 		metadata of the procedure
	 */
	public AbstractVisualizationController(AbstractVisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
	}
	
	/**
	 * Gets the {VisualizationInfo}-object of the visualization
	 * 
	 * @return{VisualizationInfo}-object holding metadata of the procedure
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return this.visualizationInfo;
	}
	
	/**
	 * Gets the currently relevant help text
	 * 
	 * @return help text
	 */
	abstract public String getHelp();
	
	/**
	 * Uses all default button behaviors
	 */
	protected void useDefaultButtonBehaviors() {
		this.useDefaultNextButtonBehavior();
		this.useDefaultNextButtonBehavior();
	}
	
	/**
	 * Pressing the 'Next' button will load the next controller
	 * as defined in the VisualizationInfo
	 */
	protected void useDefaultNextButtonBehavior() {
		if (this.view == null) {
			throw new RuntimeException("View is undefined. Can't prepare ActionListener without defined view.");
		}
		
		ActionListener nextListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController 
						= (VisualizationContainerController) AbstractVisualizationController.this
						.getParentController();
				
				containerController.presentNextVisualizationController();
			}
		};
		
		((AbstractVisualizationView) this.view).setNextButtonActionListener(nextListener);
	}
	
	/**
	 * Pressing the 'Back' button will load the previous controller
	 * as defined in the VisualizationInfo
	 */
	protected void useDefaultBackButtonBehavior() {
		if (this.view == null) {
			throw new RuntimeException("View is undefined. Can't prepare ActionListener without defined view.");
		}
		
		ActionListener backListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController
						= (VisualizationContainerController) AbstractVisualizationController.this
						.getParentController();
				
				containerController.presentPreviousVisualizationController();
			}
		};
		
		((AbstractVisualizationView) this.view).setBackButtonActionListener(backListener);
	}
}
