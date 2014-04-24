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

package edu.kit.iks.CryptographicsLib;

import java.io.InputStream;
import java.util.regex.Pattern;

/**
 * Utility class to ease file access
 * 
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public class ResourceUtil {
	
	/**
	 * Gets a resource as input stream
	 * 
	 * @param name Name of the resource
	 * @return InputStream instance containing requested file
	 */
	public static InputStream getResourceAsInputStream(String name) {
		
		if (!Pattern.matches("/.*", name)) {
			name = "/" + name;
		}
		
		InputStream is = ResourceUtil.class.getResourceAsStream(name);
		
		return is;
	}
}
