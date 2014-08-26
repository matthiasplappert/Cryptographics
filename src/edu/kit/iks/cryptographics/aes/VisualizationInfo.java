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

package edu.kit.iks.cryptographics.aes;

import java.util.ArrayList;
import java.util.List;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.cryptographicslib.common.controller.InformationController;
import edu.kit.iks.cryptographicslib.framework.controller.AbstractVisualizationController;
import edu.kit.iks.cryptographicslib.framework.model.AbstractVisualizationInfo;
import edu.kit.iks.cryptographicslib.framework.model.VisualizationDifficulty;
import edu.kit.iks.cryptographicslib.util.Configuration;

/**
 * Visualization info for AES.
 * 
 * @author Christian Dreher
 */
public class VisualizationInfo extends AbstractVisualizationInfo {
    
    /**
     * Localization instance.
     */
    private static I18n i18n = Configuration.getInstance().getI18n(VisualizationInfo.class);
    
    /**
     * Timeline offset of the visualization.
     */
    private static final float TIMELINE_OFFSET = 0.91f;
    
    /**
     * Year in which the procedure was invented.
     */
    private static final int INVENTION_YEAR = 1998;
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getId()
     */
    @Override
    public final String getId() {
        return "aes";
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getName()
     */
    @Override
    public final String getName() {
        return i18n.tr("AES");
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDescription()
     */
    @Override
    public final String getDescription() {
        return i18n.tr("Learn about one of the most important modern ciphers, the Advanced Encryption Standard.");
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getTimelineOffset()
     */
    @Override
    public final float getTimelineOffset() {
        return VisualizationInfo.TIMELINE_OFFSET;
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getDifficulty()
     */
    @Override
    public final VisualizationDifficulty getDifficulty() {
        return VisualizationDifficulty.NOT_INTERACTIVE;
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getYear()
     */
    @Override
    public final int getYear() {
        return VisualizationInfo.INVENTION_YEAR;
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getQRCodeContent()
     */
    @Override
    public final String getQRCodeContent() {
        return i18n.tr("http://en.wikipedia.org/wiki/Advanced_Encryption_Standard");
    }
    
    /*
     * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo#getControllerClasses()
     */
    @Override
    public final List<Class<? extends AbstractVisualizationController>> getControllerClasses() {
        List<Class<? extends AbstractVisualizationController>> controllerClasses = new ArrayList<>();
        
        controllerClasses.add(InformationController.class);
        
        return controllerClasses;
    }
}
