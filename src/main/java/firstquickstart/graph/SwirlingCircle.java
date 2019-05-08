package firstquickstart.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SwirlingCircle {
    int x;
    int y;
    Color color;
    int yDirection = 0;
    int xDirection = 0;
    final int SIZE = 30;

    // constructor for new circle centered at x,y
    public SwirlingCircle(int startX, int startY, Color startColor) {
        x = startX;
        y = startY;
        color = startColor;
    }

    // draws the circe bounded by the specified rectangle, passed the surface shape
    // is to be drawn on as arg
    public void draw(Graphics surface) {
        surface.setColor(color);
        // x and y should be the upper left corner of rectangle filled with oval
        surface.fillOval(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
        // sets outline to black
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
        // reassigns values of movement direction based on what they were
        setMotionDirection(xDirection, yDirection);
        // assigns new values
        x += xDirection;
        y += yDirection;
    }

    private void setMotionDirection(int priorXdirection, int priorYdirection) {
        if ((priorXdirection == 0 && priorYdirection == 0) || (priorXdirection == 1 && priorYdirection == 1)) {
            xDirection = +1;
            yDirection = -1;
            return;
        } else if (priorXdirection == 1 && priorYdirection == -1) {
            xDirection = -1;
            return;
        } else if (priorXdirection == -1 && priorYdirection == -1) {
            yDirection = +1;
            return;
        } else if (priorXdirection == -1 && priorYdirection == 1) {
            xDirection = +1;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
}