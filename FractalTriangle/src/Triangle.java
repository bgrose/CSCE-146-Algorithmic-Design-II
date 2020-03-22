/*
 * Bradley Grose
 */

//imports
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JFrame;

public class Triangle extends Canvas {

	// Applet Size Varibale
	public static final int CANSIZE = 600;

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(CANSIZE, CANSIZE);
		Triangle tri = new Triangle();
		frame.add(tri); // Adds the Triangle
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void paint(Graphics g) {

		drawIt(g);
	}

	public void drawIt(Graphics g) {
		int height = (int) Math.round(CANSIZE * Math.sqrt(3) / 2);

		// Sets points for drawing
		Point p1 = new Point(0, height); // Bottom
		Point p2 = new Point(CANSIZE / 2, 0); // Point
		Point p3 = new Point(CANSIZE, height); // Bottom Right

		drawShape(6, g, p1, p2, p3); // 6 is for number of recursions
	}

	public static void drawShape(int num, Graphics g, Point p1, Point p2, Point p3) {
		if (num == 1) // Creates the first triangle using points
		{
			Polygon pol = new Polygon();
			pol.addPoint(p1.x, p1.y);
			pol.addPoint(p2.x, p2.y);
			pol.addPoint(p3.x, p3.y);
			g.fillPolygon(pol);
		} else {
			// Using Recursion finds the midpoint and adds the triangles to create pattern
			Point p4 = mid(p1, p2);
			Point p5 = mid(p2, p3);
			Point p6 = mid(p1, p3);

			// recursive for all the areas needed
			drawShape(num - 1, g, p1, p4, p6);
			drawShape(num - 1, g, p4, p2, p5);
			drawShape(num - 1, g, p6, p5, p3);
		}

	}

	public static Point mid(Point p0, Point p1) {
		return new Point((p0.x + p1.x) / 2, (p0.y + p1.y) / 2); // Finds x and y midpoints by adding and divide
	}

}
