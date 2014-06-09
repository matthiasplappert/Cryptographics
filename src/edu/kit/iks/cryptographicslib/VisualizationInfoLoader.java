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

package edu.kit.iks.cryptographicslib;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iks.cryptographics.DiffieHellman.DHVisualizationInfo;
import edu.kit.iks.cryptographics.Vigenere.VigenereVisualizationInfo;
import edu.kit.iks.cryptographics.caesar.CaesarVisualizationInfo;

/**
 * This class is a registry where all {VisualisationInfo}-objects are 
 * accessible through the static {loadAllVisualizationInfo()}-method.
 * Objects of this class cannot be instantiated
 * 
 * @author Christian Dreher
 */
public class VisualizationInfoLoader {
	
	/**
	 * Private constructor to prevent this class from being instantiated
	 */
	private VisualizationInfoLoader() {
		
	}
	
	/**
	 * Returns a list of all {VisualizationInfo}-objects 
	 * 
	 * @return A list of all {VisualizationInfo}-objects 
	 */
	static public List<AbstractVisualizationInfo> loadAllVisualizationInfos() {
		List<AbstractVisualizationInfo> visualizationInfos = new ArrayList<AbstractVisualizationInfo>();
		visualizationInfos.add(new CaesarVisualizationInfo());
		visualizationInfos.add(new DHVisualizationInfo());
		visualizationInfos.add(new VigenereVisualizationInfo());
		visualizationInfos.add(new edu.kit.iks.cryptographics.OneTimePad.VisualizationInfo());
		visualizationInfos.add(new edu.kit.iks.cryptographics.AES.VisualizationInfo());
		visualizationInfos.add(new edu.kit.iks.cryptographics.SHA2.VisualizationInfo());
		
		// Example Package
		//visualizationInfos.add(new edu.kit.iks.Cryptographics.Example.VisualizationInfo());
		return visualizationInfos;
	}
}
