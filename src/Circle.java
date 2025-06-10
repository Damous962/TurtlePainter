import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int borderWidth, int radius) {
        super(turtle, location, color, borderWidth);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.setPenWidth(borderWidth);
        turtle.setColor(color);
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.penDown();
        turtle.drawCircle(radius);
    }
}
