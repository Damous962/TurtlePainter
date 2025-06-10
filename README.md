# 🐢 TurtlePainter - Java Drawing App

This is a simple console-based Java drawing application where users can draw shapes like squares, circles, and triangles using a virtual turtle on a canvas.

---

## 📌 Features

- Create a drawing canvas of any size
- Add shapes to the canvas:
  - ✅ Square
  - ✅ Circle
  - ✅ Triangle
- Customize:
  - Shape location (x, y)
  - Border color and width
  - Shape size (side length, radius, etc.)
- Save your drawing as an image (`.png`)

---

## 🛠️ How to Use

1. Run the program.
2. Enter your desired canvas size.
3. Use the menu:
   ```
   1) Add Shape
   2) Save Image
   0) Exit
   ```
4. Shapes will be drawn live in the window!
5. When finished, save your image and exit.

---

## 🧱 Technologies Used

- Java
- Swing (`JFrame`, `Graphics2D`)
- OOP Principles: Abstraction, Inheritance, Interfaces
- Custom `Turtle` class to simulate pen movement

---

## 🖼️ Screenshots

### ✅ Home Menu
> _Prompt to add shapes or save image_

### ✅ Shape Input
> _Example: Entering location, size, and color of a circle_

---

## 💡 Interesting Code Snippet

```java
public void drawCircle(int x, int y, int radius, Color color, int width) {
    Graphics2D g = canvas.createGraphics();
    g.setColor(color);
    g.setStroke(new BasicStroke(width));
    g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    repaint();
}
```

This method uses `Graphics2D` to simulate the turtle drawing a circle at any point, with any color and line thickness. It demonstrates how drawing logic is abstracted into a reusable TurtleCanvas.
