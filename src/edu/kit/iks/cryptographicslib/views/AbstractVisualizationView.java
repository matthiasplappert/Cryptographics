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

package edu.kit.iks.cryptographicslib.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import edu.kit.iks.cryptographicslib.views.partials.AbstractPartialView;

/**
 * View for UI elements which all visualizations have in common
 * 
 * @author Christian Dreher
 */
public abstract class AbstractVisualizationView extends AbstractView {
	
	/**
	 * Serial Version UID 
	 */
	private static final long serialVersionUID = -988624050394454370L;
	
	/**
	 * JPanel wrapping the navigation buttons
	 * 
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 */
	private class NavigationContainer extends JPanel {
		
		/**
		 * Serial version UID
		 */
		private static final long serialVersionUID = 427370017328857575L;
		
		public JButton nextButton;
		public JButton backButton;
		private Dimension buttonSize = new Dimension(350, 50);
		
		public NavigationContainer() {
			super(new BorderLayout());
		}
		
		public void setNextButton(String label) {
			if (this.nextButton == null) {
				this.nextButton = new JButton();
				this.nextButton.setPreferredSize(this.buttonSize);
				this.add(this.nextButton, BorderLayout.EAST);
			}
			
			this.nextButton.setText(label);
		}
		
		public void setBackButton(String label) {
			if (this.backButton == null) {
				this.backButton = new JButton();
				this.backButton.setPreferredSize(this.buttonSize);
				this.add(this.backButton, BorderLayout.WEST);
			}
			
			this.backButton.setText(label);
		}
	}
	
	/**
	 * JPanel wrapping the content area
	 * 
	 * @author Christian Dreher <uaeef@student.kit.edu>
	 */
	private class ContentContainer extends AbstractPartialView {
		
		/**
		 * Serial version UID
		 */
		private static final long serialVersionUID = -6819473343449512917L;

		/**
		 * @param variables
		 */
		public ContentContainer() {
			super(null);
		}
		

		/* (non-Javadoc)
		 * @see edu.kit.iks.cryptographicslib.views.partials.AbstractPartialView#preparePartialView()
		 */
		@Override
		public void preparePartialView() {
			// Nothing to do, view will be populated at runtime
		}
	}
	
	/**
	 * Instance of the navigation container
	 */
	private NavigationContainer navigationContainer;
	
	/**
	 * Instance of the content container
	 */
	private AbstractPartialView contentContainer;
	
	/**
	 * Button for stepwise skipping inside one view
	 */
	private JButton stepButton;
	
	/**
	 * JPanel wrapping the step button
	 */
	private JPanel footerContainer;
	
	/**
	 * Constructor initializing a new instance of VisualizationView
	 */
	public AbstractVisualizationView(List<SimpleEntry<String, String>> variables) {
		super(variables);
		
		this.setLayout(new BorderLayout());
		
		this.setupNavigationContainer();
		this.setupContentContainer();
		this.setupFooterContainer();
	}
	
	/**
	 * If this method is called the first time, a 'Next' button with given label will
	 * be created. If the method is called another time, only the label of the already
	 * existing button will be updated, however, a possible bound ActionListener will
	 * remain untouched. If you wish to also change the ActionListener, call the 
	 * setNextButtonActionListener(...) method once more.
	 * 
	 * @param label Label of the button
	 */
	protected void setNextButton(String label) {
		this.navigationContainer.setNextButton(label);
	}
	
	/**
	 * If this method is called the first time, a 'Back' button with given label will
	 * be created. If the method is called another time, only the label of the already
	 * existing button will be updated, however, a possible bound ActionListener will
	 * remain untouched. If you wish to also change the ActionListener, call the 
	 * setBackButtonActionListener(...) method once more.
	 * 
	 * @param label Label of the button
	 */
	protected void setBackButton(String label) {
		this.navigationContainer.setBackButton(label);
	}
	
	/**
	 * If this method is called the first time, a 'Step' button with given label will
	 * be created. If the method is called another time, only the label of the already
	 * existing button will be updated, however, a possible bound ActionListener will
	 * remain untouched. If you wish to also change the ActionListener, call the 
	 * setStepButtonActionListener(...) method once more.
	 * 
	 * @param label Label of the button
	 */
	protected void setStepButton(String label) {
		if (this.stepButton == null) {
			this.stepButton = new JButton();
			
			Dimension buttonSize = new Dimension(350, 50);
			
			this.stepButton.setPreferredSize(buttonSize);
			
			this.footerContainer.add(this.stepButton);
		}
		
		this.stepButton.setText(label);
		this.revalidate();
	}
	
	/**
	 * Binds an ActionListener to the next button
	 * 
	 * @param al The ActionListener to bind
	 */
	public void setNextButtonActionListener(ActionListener al) {
		if (this.navigationContainer.nextButton != null) {
			this.navigationContainer.nextButton.addActionListener(al);
		} else {
			throw new RuntimeException("'Next' button action listener could not be set since the button is not "
					+ "initialized.");
		}
	}
	
	/**
	 * Binds an ActionListener to the back button
	 * 
	 * @param al The ActionListener to bind
	 */
	public void setBackButtonActionListener(ActionListener al) {
		if (this.navigationContainer.backButton != null) {
			this.navigationContainer.backButton.addActionListener(al);
		} else {
			throw new RuntimeException("'Back' button action listener could not be set since the button is not "
					+ "initialized.");
		}
	}
	
	/**
	 * Binds an ActionListener to the step button
	 * @param al The ActionListener to bind
	 */
	public void setStepButtonActionListener(ActionListener al) {
		if (this.stepButton != null) {
			this.stepButton.addActionListener(al);
		} else {
			throw new RuntimeException("'Step' button action listener could not be set since the button is not "
					+ "initialized.");
		}
	}
	
	/**
	 * Adds a text to the content area 
	 * 
	 * @param text Text to add to content
	 * @return ID to identify the object for modifying or removing it
	 */
	protected int addTextToContent(String text) {
		return this.contentContainer.addText(text);
	}
	
	/**
	 * Adds a partial view to the content
	 * 
	 * @param partialView Partial view to add
	 * @return ID to identify the object for modifying or removing it
	 */
	protected int addPartialViewToContent(JComponent partialView) {
		return this.contentContainer.addElement(partialView);
	}
	
	/**
	 * Sets the content to a new partial view
	 * 
	 * @param content Partial view to set
	 */
	public void setContent(AbstractPartialView content) {
		// Removes old content container from view
		this.remove(this.contentContainer);
		
		// Sets new content container
		this.contentContainer = content;
		
		// Prepares the partial view to display its contents
		this.contentContainer.preparePartialView();
		
		// Adds the new partial view to this view
		this.add(this.contentContainer);
		
		// Refresh
		this.refreshContent();
	}
	
	/**
	 * Adds an image as ImageView to the content by its resource ID
	 * 
	 * @param resourceId Resource ID defined in resources.xml
	 * @returnID to identify the object for modifying or removing it
	 */
	protected int addImageFromResourceToContent(String resourceId) {
		return this.contentContainer.addImageFromResource(resourceId);
	}
	
	/**
	 * Resets the content area by removing all JComponents
	 */
	protected void clearContent() {
		this.remove(this.contentContainer);
		this.contentContainer = new ContentContainer();
		this.add(this.contentContainer);
	}
	
	/**
	 * Refreshes the content area
	 */
	public void refreshContent() {
		this.validate();
	}
	
	/**
	 * Sets up the navigation container
	 */
	private void setupNavigationContainer() {
		this.navigationContainer = new NavigationContainer();
		
		this.add(this.navigationContainer, BorderLayout.NORTH);
	}
	
	/**
	 * Sets up the content container
	 */
	private void setupContentContainer() {
		this.contentContainer = new ContentContainer();
		
		this.add(this.contentContainer, BorderLayout.CENTER);
	}
	
	/**
	 * Sets up the footer container
	 */
	private void setupFooterContainer() {
		this.footerContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		this.add(this.footerContainer, BorderLayout.SOUTH);
	}
}
