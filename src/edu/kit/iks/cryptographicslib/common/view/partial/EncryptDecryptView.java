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

package edu.kit.iks.cryptographicslib.common.view.partial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.cryptographicslib.util.Configuration;

/**
 * @author Christian Dreher
 *
 */
public class EncryptDecryptView extends JPanel {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 3148421807176502231L;

	private static I18n i18n = Configuration.getInstance().getI18n(EncryptDecryptView.class);

	private String key = EncryptDecryptView.i18n.tr("Key");
	
	private static class COLORS_SUCCESS {
	    public final static Color FONT = new Color(0x31708f);
	    public final static Color BORDER = new Color(0xbce8f1);
	    public final static Color BACKGROUND = new Color(0xd9edf7);
	}
	
	private static class COLORS_ERROR {
        public final static Color FONT = new Color(0xa94442);
        public final static Color BORDER = new Color(0xebccd1);
        public final static Color BACKGROUND = new Color(0xf2dede);
	}
	
	private static class Layout {
		public static GridBagConstraints gbc;
		public static Dimension dimension = new Dimension(25, 25);
	}
	
	private JLabel[] labels;
	private JTextField[] inputs;
	
	/**
	 * Initializes a new instance of a view to encrypt or decrypt the given 
	 * string {text}.
	 * 
	 * @param text Text to encrypt or decrypt
	 * @param key Key used to encrypt or decrypt (Will be displayed in the end) 
	 */
	public EncryptDecryptView(String text, String key) {
		super(new GridBagLayout());
		
		this.labels = new JLabel[text.length() + 1];
		this.inputs = new JTextField[text.length()];
		
		this.initLayout();
		
		this.initLabels(text);
		this.initInputs(key);
	}
	
	public void enable(int index) {
		this.unhighlightAll();
		
		for (int i = 0; i < this.inputs.length; i++) {
			this.inputs[i].setEditable(false);
		}
		
		this.inputs[index].setEditable(true);
		this.inputs[index].setText("");
		this.inputs[index].requestFocus();
		
		this.highlightLabel(index);
	}
	
	public void highlightLabel(int index) {
		this.labels[index].setBorder(BorderFactory.createLineBorder(Color.GREEN));
		this.revalidate();
	}
	
	public void highlightInputSuccess(int index) {
	    this.inputs[index].setForeground(EncryptDecryptView.COLORS_SUCCESS.FONT);
	    this.inputs[index].setBorder(BorderFactory.createLineBorder(COLORS_SUCCESS.BORDER));
	    this.inputs[index].setBackground(EncryptDecryptView.COLORS_SUCCESS.BACKGROUND);
	    this.revalidate();
	}
	
	public void highlightInputError(int index) {
        this.inputs[index].setForeground(EncryptDecryptView.COLORS_ERROR.FONT);
        this.inputs[index].setBorder(BorderFactory.createLineBorder(COLORS_ERROR.BORDER));
        this.inputs[index].setBackground(EncryptDecryptView.COLORS_ERROR.BACKGROUND);
        this.revalidate();
    }
	
	public void highlightInputBorder(int index) {
		this.inputs[index].setBorder(BorderFactory.createLineBorder(Color.RED));
		this.revalidate();
	}
	
	public void unhighlightAll() {
		for (int i = 0; i < this.inputs.length; i++) {
			this.labels[i].setBorder(null);
		}
	}
	
	public JTextField getInput(int index) {
		return this.inputs[index];
	}
	
	private void initLayout() {
		EncryptDecryptView.Layout.gbc = new GridBagConstraints();
		
		EncryptDecryptView.Layout.gbc.ipadx = 20;
		EncryptDecryptView.Layout.gbc.ipady = 20;
		EncryptDecryptView.Layout.gbc.fill = GridBagConstraints.BOTH;
		EncryptDecryptView.Layout.gbc.insets = new Insets(5, 25, 25, 25);
	}
	
	private void initLabels(String text) {
		char[] textCharacters = text.toCharArray();
		int i;
		
		for (i = 0; i < textCharacters.length; i++) {
			Character currentChar = textCharacters[i];
			this.labels[i] = new JLabel(currentChar.toString(), JLabel.CENTER);
			
			// Styling
			this.labels[i].setPreferredSize(EncryptDecryptView.Layout.dimension);
			
			this.add(this.labels[i], this.labelLayout(i));
		}
		
		this.labels[i] = new JLabel(this.key, JLabel.CENTER);
		this.add(this.labels[i], this.labelLayout(i));
	}
	
	private void initInputs(String key) {
		int i;
		
		for (i = 0; i < this.inputs.length; i++) {
			this.inputs[i] = new JTextField();
			
			// Styling
			this.inputs[i].setEditable(false);
			this.inputs[i].setHorizontalAlignment(JTextField.CENTER);
			this.inputs[i].setPreferredSize(EncryptDecryptView.Layout.dimension);
			this.inputs[i].setBorder(BorderFactory.createLineBorder(Color.darkGray));
            this.inputs[i].setBackground(Color.WHITE);
            this.inputs[i].setOpaque(true);
			
			// Questionmark to indicate input possibility 
			this.inputs[i].setText("?");

			this.add(this.inputs[i], this.inputLayout(i));
		}
		
		// Label for the key
		this.add(new JLabel(key, JLabel.CENTER), this.inputLayout(i));
	}
	
	private GridBagConstraints labelLayout(int i) {
		return this.gbcFactory(i, 0);
	}
	
	private GridBagConstraints inputLayout(int i) {
		return this.gbcFactory(i, 1);
	}
	
	private GridBagConstraints gbcFactory(int x, int y) {
		EncryptDecryptView.Layout.gbc.gridx = x;
		EncryptDecryptView.Layout.gbc.gridy = y;
		
		return EncryptDecryptView.Layout.gbc;
	}
}
