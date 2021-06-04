package src;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ZoomButton extends JButton {

    private BufferedImage icon;
    
    public ZoomButton(boolean zoomsIn) {
        /*
        * zoomsIn should be true if a "+" is desired in the magnifying glass
        * and false if a "-" is desired
        */

        super();

        // load the correct icon
        try {
            if (zoomsIn) icon = ImageIO.read(getClass().getResourceAsStream("src/resources/search-zoom.png"));
            else icon = ImageIO.read(getClass().getResourceAsStream("src/resources/search-minus.png"));
        } catch (IOException e) {
            icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }

    }

    @Override
    public void paint(Graphics g) {
        int size = Math.min(getWidth(), getHeight());
        g.drawImage(icon, 0, 0, size, size, this);
    }
}
