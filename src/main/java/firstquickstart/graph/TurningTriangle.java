package firstquickstart.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class TurningTriangle{
    int[] xValues;
    int[] yValues;
    Color color;
    int xDirection;
    int yDirection;
    Polygon triangle;

    public TurningTriangle(int[] startingXValues, int[] startingYValues, Color startColor){
        xValues = startingXValues;
        yValues = startingYValues;
        color = startColor;
        triangle = new Polygon(xValues, yValues, xValues.length);
    }

    public void draw(Graphics surface){
        surface.setColor(color);
        surface.fillPolygon(triangle);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawPolygon(triangle);
        
    }
}