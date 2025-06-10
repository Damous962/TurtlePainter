import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Turtle {
    private BufferedImage canvas;
    private Graphics2D g2d;
    private JFrame frame;
    private int x, y;
    private double angle = 0;

    public Turtle(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        frame = new JFrame("Turtle Painter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(new JLabel(new ImageIcon(canvas)));
        frame.setVisible(true);

        x = width / 2;
        y = height / 2;
    }

    public void goTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void forward(int distance) {
        int newX = x + (int)(distance * Math.cos(Math.toRadians(angle)));
        int newY = y + (int)(distance * Math.sin(Math.toRadians(angle)));
        g2d.drawLine(x, y, newX, newY);
        update();
        x = newX;
        y = newY;
    }

    public void turnRight(int degrees) {
        angle += degrees;
    }

    public void setPenWidth(int width) {
        g2d.setStroke(new BasicStroke(width));
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    public void penUp() {
        // Optional in future if you implement it
    }

    public void penDown() {
        // Optional in future if you implement it
    }

    public void drawCircle(int radius) {
        g2d.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        update();
    }

    public void saveImage(String fileName) {
        try {
            ImageIO.write(canvas, "png", new File(fileName));
            System.out.println("Saved image as: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update() {
        frame.repaint();
        frame.getContentPane().repaint();
    }
}
