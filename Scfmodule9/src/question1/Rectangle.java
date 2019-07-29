package question1;

import java.util.Date;

/*
 * This class is used to do various operation on rectangle like
 * get area, perimeter ,origin and pointEnclosed.
 */
public class Rectangle implements Shape {
	
	double length, width;
	Date date;
	Point originPoint;
	Point maxRectanglePoint;

	public Rectangle(double length, double width, Date date, Point originPoint) {
		this.length = length;
		this.width = width;
		this.date = date;
		this.originPoint = originPoint;
		this.maxRectanglePoint = getMaxRectanglePoint();
	}

	/*
	 * This method is used to calculate area.
	 * @return This method return area.
	 */
	public double getArea() {
		return (length * width);
	}

	/*
	 * This method is used to calculate perimeter. return This return perimeter.
	 */
	public double getPerimeter() {
		return (2 * (length + width));
	}

	/*
	 * This method is used to gate date.
	 * @return This return date.
	 */
	public Date getTimeStamp() {
		return date;
	}

	/*
	 * This method is used to calculate origin point.
	 * @return This return origin point.
	 */
	public Point getOrigin() {
		return originPoint;
	}

	/*
	 * This method is used to check that given point is inside in shape or not.
	 * @param givenPoint, This is point to be check.
	 * @return This return true is point inside else return false.
	 */
	public boolean isPointEnclosed(Point givenPoint) {
		
		if (givenPoint.x > originPoint.x && givenPoint.x < maxRectanglePoint.x && givenPoint.y > originPoint.y && givenPoint.y < maxRectanglePoint.y) {
			return true;
		}
		return false;
	}

	/*
	 * This method is used to get shape type.
	 * @return This return the type of shape.
	 */
	public String getShapeType() {
		return "RECTANGLE";
	}

	/*
	 * This method is used to calculate distance between (0,0) to shape origin
	 * point.
	 * @return, This return distance between (0,0) to shape origin point.
	 */
	public double getOriginDistance() {

		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
	}

	/*
	 * This method is used to get maximum point in rectangle.
	 * @return diagonally opposite points of rectangle.
	 */
	private Point getMaxRectanglePoint() {
		return new Point(originPoint.x + width, originPoint.y + length);
	}

}
