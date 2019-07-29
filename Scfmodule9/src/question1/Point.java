package question1;

/*
 * This class creates point for shapes.
 */
public class Point {
	final static double XMAX = 100.00;
	final static double YMAX = 100.00;

	double x, y;

	/*
	 * This is constructor of point.
	 * @param x, This is x coordinate of shape.
	 * @param y, This is y coordinate of shape.
	 */
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
