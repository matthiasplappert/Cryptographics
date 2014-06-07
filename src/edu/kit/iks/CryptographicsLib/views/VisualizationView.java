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

package edu.kit.iks.CryptographicsLib.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * View for UI elements which all visualizations have in common
 * 
 * @author Christian Dreher
 */
public class VisualizationView extends JPanel {
	
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
	private class ContentContainer extends JPanel {
		
		/**
		 * Serial version UID
		 */
		private static final long serialVersionUID = 5790385901951487322L;
		
		public ArrayList<JComponent> elements = new ArrayList<>();
		private GridBagConstraints gbc = new GridBagConstraints();
		
		public ContentContainer() {
			super(new GridBagLayout());
			this.initGridBagConstraints();
		}
		
		public int addElement(JComponent element) {
			this.elements.add(this.gbc.gridy, element);
			this.add(element, this.gbc);
			
			return this.gbc.gridy++;
		}
		
		private void initGridBagConstraints() {
			this.gbc.gridx = 0;
			this.gbc.gridy = 0;
			this.gbc.gridwidth = 1;
			this.gbc.anchor = GridBagConstraints.CENTER;
			this.gbc.fill = GridBagConstraints.NONE;
		}
	}
	
	/**
	 * Instance of the navigation container
	 */
	private NavigationContainer navigationContainer;
	
	/**
	 * Instance of the content container
	 */
	private ContentContainer contentContainer;
	
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
	public VisualizationView() {
		super(new BorderLayout());
		
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
	public void setNextButton(String label) {
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
	public void setBackButton(String label) {
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
	public void setStepButton(String label) {
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
		}
	}
	
	/**
	 * Binds an ActionListener to the step button
	 * @param al The ActionListener to bind
	 */
	public void setStepButtonActionListener(ActionListener al) {
		this.stepButton.addActionListener(al);
	}
	
	/**
	 * Adds a text to the content area 
	 * 
	 * @param text Text to add to content
	 * @return ID to identify the object for modifying or removing it
	 */
	public int addText(String text) {
		JTextPane jtext = new JTextPane();
		jtext.setText(text);
		jtext.setEditable(false);
		jtext.setPreferredSize(new Dimension(800, 80));
		
		StyledDocument doc = jtext.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		return this.contentContainer.addElement(jtext);
	}
	
	/**
	 * Adds a partial view to the content
	 * 
	 * @param partialView Partial view to add
	 * @return ID to identify the object for modifying or removing it
	 */
	public int addPartialView(JComponent partialView) {
		return this.contentContainer.addElement(partialView);
	}
	
	/**
	 * Resets the content area by removing all JComponents
	 */
	public void clearContentContainer() {
		this.remove(this.contentContainer);
		this.contentContainer = new ContentContainer();
		this.add(this.contentContainer);
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
