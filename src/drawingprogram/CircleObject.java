package drawingprogram;
import java.awt.Color;
/**
 *
 * @author Andrew
 */
public class CircleObject {

    
    private double x;
    private double y;
    private int radius;
    private Color color;
    public CircleObject () {
        
    }
    public CircleObject(double x, double y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
