package edu.kit.iks.Cryptographics.Caesar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JAnimationPanel extends JPanel implements Animation {

	private final List<Scene> scenes = new LinkedList<Scene>();
	private final AtomicInteger index = new AtomicInteger(0);
	private final AtomicBoolean isRunning = new AtomicBoolean(false);

	/**
	 * Erzeugt ein neues JAnimationPanel-Objekt (doublebuffered).
	 */
	public JAnimationPanel() {
		super(true);
	}

	public void addScene(String filename, long time) {
		scenes.add(new Scene(filename, time));
	}

	public void start(final int repeatRate) {
		if (repeatRate < 0 || isRunning.get()) {
			return;
		}

		Thread t = new Thread("JAnimationPanel") {
			@Override
			public void run() {
				isRunning.set(true);
				if (Animation.ENDLESS_REPEAT_RATE == repeatRate) {
					while (true && isRunning.get()) {
						runAnimation();
					}
				} else {
					for (int i = 0; i < repeatRate && isRunning.get(); i++) {
						runAnimation();
					}
				}
				isRunning.set(false);
			}
		};
		t.setDaemon(true);
		t.start();
	}

	public void stop() {
		isRunning.set(false);
	}

	public void reset() {
		index.set(0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 
	        // holt sich die aktuelle Scene
	        Scene scene = scenes.get(index.get());
	 
	        // zeichnet das Bild der aktuellen Scene
	        try {
	            ((Graphics2D) g).drawImage(loadImage(scene.getFilename()), 0, 0, this);
	        } catch(IOException 	 e) {
	            e.printStackTrace();
	        }
	}
	
	 private Image loadImage(String filename) throws IOException {
	        return ImageIO.read(new File(filename));
	    }

	/**
     * 
     */
	private void runAnimation() {
		long timeActual = System.currentTimeMillis();
		long timePassed;

		while (isRunning.get()) {
			// Die vergangene Zeit seit dem letzten Durchlauf
			timePassed = System.currentTimeMillis() - timeActual;

			// Über die Variable index holen wir uns das aktuelle Scene-Objekt
			Scene scene = scenes.get(index.get());
			if (scene.getTime() <= timePassed) { // ist die Zeitspanne rum...
				// Wird der index hochgezählt, damit wir
				// das nächste Scene-Objekt holen können
				index.incrementAndGet();

				// Die vergangene Zeit seit dem letzten Bildwechsel und die
				// Startzeit werden ebenfalls wieder zurückgesetzt.
				timePassed = 0;
				timeActual = System.currentTimeMillis();
			}

			// Ist der index gleich der Anzahl der Scene-Objekten, so wird die
			// reset-Methode aufgerufen, um den index zurück zu setzen und
			// die runAnimation-Methode verlassen
			if (index.get() == scenes.size()) {
				reset();
				return;
			}

			// zeichnen des nächsten Scene-Objekts
			// invokeLater, weil eigentlich nur der Mainthread zeichnen darf
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					repaint();
				}
			});

			try {
				// Und holen uns das nächste Scene-Objekt
				scene = scenes.get(index.get());

				// Nun berechnen wir die Zeit, bis das nächste Scene-Objekt
				// angezeigt werden soll und legen den Thread so lange schlafen
				long waitTime = scene.getTime() - timePassed;
				if (waitTime > 0) {
					Thread.sleep(waitTime);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private final class Scene {
		private final String filename;
		private final long time;

		/**
		 * @param filename
		 * @param time
		 */
		public Scene(String filename, long time) {
			this.filename = filename;
			this.time = time;
		}

		/**
		 * @return the filename
		 */
		public String getFilename() {
			return filename;
		}

		/**
		 * @return the time
		 */
		public long getTime() {
			return time;
		}
	}

}
