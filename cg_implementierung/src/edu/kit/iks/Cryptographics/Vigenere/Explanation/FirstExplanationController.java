package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;

/**
 * Controller class of the first phase
 * @author Aydin Tekin
 */
public class FirstExplanationController extends AbstractVisualizationController {
	/**
	 * current state
	 */
	private int state;
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(FirstExplanationController.class);
	
	/**
	 * Constructor of the controller
	 * @param visualizationInfo
	 */
	public FirstExplanationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	/**
	 * returns the view
	 * @return view of current step
	 */
	@Override
	public FirstExplanationView getView() {
		return (FirstExplanationView)this.view;
	}
	
	/**
	 * loads the view and registers action listeners
	 */
	@Override
	public void loadView() {
		this.state = 0;
		this.view = new FirstExplanationView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state--;
				switch (state) {
				case -1:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentPreviousVisualizationController();
				case 0:
					getView().setExplanation("<html><div width=\"1200\">"
							+ i18n.tr("Vigenere fixed a few weaknesses of Caesar, but still "
							+ "	has flaws. If the key is shorter then the text to encrypt, "
				       		+ "Vigenère simply concatinates it with itself until the key is "
				       		+ "long enough. This again makes it weak against key-length-guessing. "
				       		+ "As soon as we guess the key-length, we can use a histogramm "
				       		+ "(explained in caesar) to make a static analysis. So lets crack "
				       		+ "this this chiffre by guessing the key-length (we will use the "
				       		+ "kasiski test for it)")
				       		+ ":<br><br>"
				       		+ FirstExplanationView.vigenereEncrypted
				       		+ "</div></html>");
					getView().visibleSecondState(false);
					getView().visibleFirstState(true);
					break;
				}
			}
		});
		this.getView().getKeyLengthButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				getView().setKeyLength("<html><div width=\"1200\">"
						+ i18n.tr("Length of key: 2")
						+ "</div></html>");
				getView().getNextButton().setVisible(true);
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				state++;
				switch (state) {
				case 1:
					getView().setExplanation("<html><div width=\"1200\">"
							+ i18n.tr("Since we know that the key-length is 2, "
							+ "every second character will be encrypted with the first "
							+ "character of the key. To "
							+ "guess which is the first character of the key we need the "
							+ "histrogramm of every "
							+ "second character in the chiffre")
							+ ":</div></html>");
					getView().visibleSecondState(true);
					getView().visibleFirstState(false);
					break;
				case 2:
					VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
					containerController.presentNextVisualizationController();
				}
			}
		});
	}

	/**
	 * unloads the view
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	/**
	 * returns the help string
	 * @return help string
	 */
	@Override
	public String getHelp() {
		return i18n.tr("Just read the instructions!");
	}
}
