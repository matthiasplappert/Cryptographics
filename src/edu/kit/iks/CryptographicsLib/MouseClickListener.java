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

package edu.kit.iks.CryptographicsLib;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is a utility class that makes dealing with MouseListeners that are simply
 * used for clicks easier.
 * MouseClickListener is deprecated, since it uses the low level MouseListener. Use
 * ActionListener instead.
 * 
 * @author Matthias Plappert
 */
@Deprecated
abstract public class MouseClickListener implements MouseListener {
	/**
	 * This method will be executed when the mouse is clicked.
	 * @param event the MouseEvent
	 */
	@Deprecated
	abstract public void clicked(MouseEvent event);

	@Deprecated
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Unused
	}

	@Deprecated
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Unused
	}

	@Deprecated
	@Override
	public void mouseExited(MouseEvent arg0) {
		// Unused
	}

	@Deprecated
	@Override
	public void mousePressed(MouseEvent arg0) {
		// Unused
	}

	@Deprecated
	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.clicked(arg0);
	}
}
