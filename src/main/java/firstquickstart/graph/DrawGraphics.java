package firstquickstart.graph;

import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
    BouncingBox box;
    SwirlingCircle circle;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.RED);
        circle = new SwirlingCircle(150, 150, Color.BLUE);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        box.draw(surface);
        circle.draw(surface);
    }
}