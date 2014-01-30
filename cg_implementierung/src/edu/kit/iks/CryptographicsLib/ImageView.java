package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class to display an image in the view
 * 
 * @author Christian Dreher
 */
public class ImageView extends JPanel{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6272421643783212805L;
	
	/**
	 * Image to be displayed
	 */
	private BufferedImage image;

	/**
	 * Constructor initializing a new instance of {ImageView}
	 * with given {img}
	 * 
	 * @param img Image to be displayed
	 */
    public ImageView(Image img) {
		if (img instanceof BufferedImage) {
	        this.image = (BufferedImage) img;
	    }
		
	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    this.image = bimage;
	    this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
    }
    
    /**
     * Constructor initializing a new instance of {ImageView}
     * with given {filePath}
     * 
     * @param filePath File path to the image to be displayed
     */
    public ImageView(String filePath) {
    	try {                
    		InputStream is = this.getClass().getResourceAsStream(filePath);
            image = ImageIO.read(is);
         } catch (IOException e) {
        	 e.printStackTrace();
         }
    	this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}
}
