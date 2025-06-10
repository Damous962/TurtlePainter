import java.awt.*;

public class Triangle extends Shape {
    private int size;

    public Triangle(Turtle turtle, Point location, Color color, int borderWidth, int size) {
        super(turtle, location, color, borderWidth);
        this.size = size;
    }

    @Override
    public void paint() {
        turtle.setPenWidth(borderWidth);
        turtle.setColor(color);
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.penDown();

        for (int i = 0; i < 3; i++) {
            turtle.forward(size);
            turtle.turnRight(120);
        }
    }
}
