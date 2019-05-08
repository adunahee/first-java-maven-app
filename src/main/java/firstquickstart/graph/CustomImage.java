package firstquickstart.graph;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;

public class CustomImage {
    int x;
    int y;
    BufferedImage image = null;

    public CustomImage(int startX, int startY, String imageLocation) {
        x = startX;
        y = startY;
        try {
            image = ImageIO.read(getClass().getResource(imageLocation));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void draw(Graphics surface){
        surface.drawImage(image, x, y, null);
    }
}
