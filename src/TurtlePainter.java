import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TurtlePainter {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Shape> shapes = new ArrayList<>();
    private static Turtle turtle;

    public static void main(String[] args) {
        // Ask for canvas size
        System.out.print("Enter canvas width: ");
        int width = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter canvas height: ");
        int height = Integer.parseInt(scanner.nextLine());

        turtle = new Turtle(width, height);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Turtle Painter ---");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image");
            System.out.println("0) Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addShape();
                case "2" -> turtle.saveImage("my-painting.png");
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void addShape() {
        System.out.println("Choose shape:");
        System.out.println("1) Square\n2) Circle\n3) Triangle");
        String shapeType = scanner.nextLine();

        System.out.print("Border width: ");
        int border = Integer.parseInt(scanner.nextLine());

        System.out.print("Border color (e.g. red, blue): ");
        Color color = getColorFromName(scanner.nextLine());

        System.out.print("X coordinate: ");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.print("Y coordinate: ");
        int y = Integer.parseInt(scanner.nextLine());

        Shape shape = null;

        switch (shapeType) {
            case "1" -> {
                System.out.print("Size of square: ");
                int size = Integer.parseInt(scanner.nextLine());
                shape = new Square(turtle, new Point(x, y), color, border, size);
            }
            case "2" -> {
                System.out.print("Radius of circle: ");
                int radius = Integer.parseInt(scanner.nextLine());
                shape = new Circle(turtle, new Point(x, y), color, border, radius);
            }
            case "3" -> {
                System.out.print("Size of triangle: ");
                int size = Integer.parseInt(scanner.nextLine());
                shape = new Triangle(turtle, new Point(x, y), color, border, size);
            }
            default -> System.out.println("Invalid shape choice.");
        }

        if (shape != null) {
            shape.paint();
            shapes.add(shape);
            System.out.println("Shape painted!");
        }
    }

    private static Color getColorFromName(String name) {
        return switch (name.toLowerCase()) {
            case "red" -> Color.RED;
            case "blue" -> Color.BLUE;
            case "green" -> Color.GREEN;
            case "black" -> Color.BLACK;
            case "yellow" -> Color.YELLOW;
            default -> Color.GRAY;
        };
    }
}