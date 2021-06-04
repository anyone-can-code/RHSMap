package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JRadioButton;

public class FloorRadioButton  extends JRadioButton {

    private BufferedImage onIcon;
    private BufferedImage offIcon;

    public FloorRadioButton(int floor) {
        /*
        * floor should be 1, 2, or 3
        */

        try {
        	offIcon = ImageIO.read(getClass().getResourceAsStream("src/resources/" + floor + "-light.png"));
            onIcon = ImageIO.read(getClass().getResourceAsStream("src/resources/" + floor + "-dark.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        int size = Math.min(getWidth(), getHeight());

        if (isSelected()) g.drawImage(onIcon, 0, 0, size, size, this);
        else g.drawImage(offIcon, 0, 0, size, size, this);
    }
}
