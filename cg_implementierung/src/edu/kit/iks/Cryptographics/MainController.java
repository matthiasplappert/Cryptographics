package edu.kit.iks.Cryptographics;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthLookAndFeel;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.PopoverView;

/**
 * An instance of this class is the main controller, delegating all performed
 * tasks to its subcontrollers like StartController (teaser) or controllers
 * visualizing a cryptographic procedure
 * 
 * @author Christian Dreher
 */
public class MainController extends AbstractController {

	/**
	 * A sandbox for subcontrollers to inflate their contents
	 */
	private JFrame frame;

	/**
	 * An instance of the start controller, showing a teaser to draw attention
	 */
	private StartController startController;

	/**
	 * An instance of a container controller, visualizing a cryptographic
	 * procedure inside
	 */
	private VisualizationContainerController visualizationContainerController;

	/**
	 * Just loads the frame. This controller is specially since it does not load a view.
	 */
	@Override
	public void loadView() {
		this.loadLookAndFeel();
		this.loadFrame();
		this.disableCursor();
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.frame = null;
	}

	/**
	 * Starts the visualization of StartController
	 */
	public void presentStartAction() {
		if (this.visualizationContainerController != null) {
			if (this.visualizationContainerController.getHelpPopoverView() != null) {
				this.visualizationContainerController.dismissHelpPopover();
			}
			this.frame.getContentPane().remove(this.visualizationContainerController.getView());
			this.visualizationContainerController.unloadView();
			this.removeChildController(this.visualizationContainerController);
		}
		
		this.startController = new StartController();
		this.startController.loadView();
		this.addChildController(this.startController);
		this.frame.getContentPane().add(this.startController.getView(), BorderLayout.CENTER);

		// Important to call validate, as some elements may
		// be invisible otherwise
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
		this.frame.validate();
	}

	/**
	 * Starts the visualization of a procedure with given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Metadata of the cryptographic procedure to instantiate the
	 *            controller from
	 */
	public void presentVisualizationAction(
			AbstractVisualizationInfo visualizationInfo) {
		// TODO: figure out if we need to unload the view/controller
		if (this.startController != null) {
			this.frame.getContentPane().remove(this.startController.getView());
			this.startController.unloadView();
			this.removeChildController(this.startController);
		}

		// load VisualizationContainerController
		this.visualizationContainerController = new VisualizationContainerController(
				visualizationInfo);
		// load view
		this.visualizationContainerController.loadView();
		this.addChildController(this.visualizationContainerController);
		this.frame.getContentPane().add(this.visualizationContainerController.getView(), BorderLayout.CENTER);
		this.visualizationContainerController.setCurrentVisualizationControllerIndex(0);
		
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
		this.frame.revalidate();
	}
	
	/**
	 * Loads the JFrame
	 */
	private void loadFrame() {
		this.frame = new JFrame("Cryptographics");
		
		if (Logger.isDebugModeActive()) {
			this.frame.setSize(1366, 768); // Basic size for debugging
			Logger.d("MainController", "loadFrame", "Fullscreen mode disabled due to debugging.");
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.frame.setUndecorated(true);
			this.frame.setAlwaysOnTop(true);
		}
		
		this.frame.setVisible(true);
		
		// Extract the glassPane. We use this for displaying popovers.
		JPanel popoverContainerView = (JPanel)this.frame.getGlassPane();
		PopoverView.setContainerView(popoverContainerView);
	}
	
	/**
	 * Loads the custom look and feel.
	 */
	private void loadLookAndFeel() {
		if (!Logger.isDebugModeActive()) {
			SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();
			
			try {
				InputStream is = this.getClass().getResourceAsStream("/theme/manifest.xml");
				
				lookAndFeel.load(is, this.getClass());
			} catch (ParseException e) {
				Logger.e(e);
			}
			
			try {
				UIManager.setLookAndFeel(lookAndFeel);
			} catch (UnsupportedLookAndFeelException e) {
				Logger.e(e);
			}
		} else {
			Logger.d("MainController", "loadLookAndFeel", "Look and feel disabled due to debugging.");
		}
	}
	
	/**
	 * Disables the cursor
	 */
	private void disableCursor() {
		if (!Logger.isDebugModeActive()) {
			Cursor nullCursor = null;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension dimension = toolkit.getBestCursorSize(1, 1);
			
			if ((dimension.width | dimension.height) != 0) {
				nullCursor = toolkit.createCustomCursor(new BufferedImage(dimension.width,
						dimension.height,
						BufferedImage.TYPE_INT_ARGB),
						new Point(0, 0),
						"nullCursor");
			}
			
			this.frame.setCursor(nullCursor);
		} else {
			Logger.d("MainController", "disableCursor", "Curser is visible due to debugging.");
		}
	}
}
