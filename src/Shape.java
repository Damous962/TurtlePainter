import java.awt.*;

public abstract class Shape {
    protected Turtle turtle;
    protected Point location;
    protected Color color;
    protected int borderWidth;

    public Shape(Turtle turtle, Point location, Color color, int borderWidth) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.borderWidth = borderWidth;
    }

    public abstract void paint();
}