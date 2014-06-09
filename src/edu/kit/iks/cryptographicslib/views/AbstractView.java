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
package edu.kit.iks.cryptographicslib.views;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author Christian Dreher <uaeef@student.kit.edu>
 *
 */
public abstract class AbstractView extends JPanel {

	/**
	 * Serial version UID
	 */
	protected static final long serialVersionUID = -8541837612624248511L;

	private class Variable {
		public String key;
		public String value;
	}
	
	protected ArrayList<Variable> variables = new ArrayList<>();
	
	public AbstractView(List<SimpleEntry<String, String>> variables) {
		if (variables != null) {
			for (SimpleEntry<String, String> variable : variables) {
				this.setVariable(variable.getKey(), variable.getValue());
			}
		}
	}
	
	public void setVariable(String key, String value) {
		Variable variable = this.getVariable(key);
		
		if (variable == null) {
			variable = new Variable();
			variable.key = key;
			
			this.variables.add(variable);
		}
		
		variable.value = value;
	}
	
	private Variable getVariable(String key) {
		for (Variable var : this.variables) {
			if (var.key.equals(key)) {
				return var;
			}
		}
		
		return null;
	}
	
	protected String getVariableValue(String key) {
		Variable variable = this.getVariable(key);
		
		if (variable == null) {
			throw new RuntimeException("Variable with name \"" + key + "\" does not exist.");
		}
		
		return variable.value;
	}
}
