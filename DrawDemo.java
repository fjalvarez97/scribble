import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);  
        myCanvas.erase();
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a triangle on the screen
     * @param x The x-coordinate of the initial triangle position
     * @param y The y-coordinate of the initial triangle position
     */
    public void drawTriangle(int x,int y)
    {
        Pen pen = new Pen(x,y,myCanvas);
        pen.setColor(Color.GREEN);

        triangle(pen);
    }

    /**
     * Draw a pentagom on the screen.
     */
    public void drawPentagon()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.GREEN);

        pentagon(pen);
    }

    /**
     * Draw a polygon on the screen.
     */
    public void drawPolygon(int x)
    {
        Pen pen = new Pen(150, 200, myCanvas);
        pen.setColor(Color.GREEN);

        polygon(pen,x);
    }

    /**
     * Draw a spiral on the screen.
     */
    public void drawSpiral()
    {
        Pen pen = new Pen(150, 200, myCanvas);
        pen.setColor(Color.BLACK);

        spiral(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw a triangle
     */
    private void triangle(Pen pen)
    {
        int angl = -60;
        for (int i=0; i<3; i++) {
            pen.move(100);
            pen.turn(angl*2);
        }
    }

    /**
     * Draw a pentagon
     */
    private void pentagon(Pen pen)
    {
        int angl = 360/5;
        for (int i=0; i<5; i++) {
            pen.move(100);
            pen.turn(angl);
        }
    }

    /**
     * Draw a poligon with 
     * @param x sides
     */
    private void polygon(Pen pen,int x)
    {
        int angl = -360/x;
        for (int i=0; i<x; i++) {
            pen.move(80);
            pen.turn(angl);
        }
    }

    /**
     * Draw a spiral 
     */
    private void spiral(Pen pen)
    {
        int x = 200;
        for (int i=0; i<40; i++) {
            pen.move(x-5);
            x -= 5;
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
