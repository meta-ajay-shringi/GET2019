package question1;

import java.util.Date;

/*
 * This class is used to do various operation on circle like
 * get area, perimeter ,origin and pointEnclosed.
 */
public class Circle implements Shape {

	double radius;
	Date date;
	Point originPoint;
	Point center;

	public Circle(double radius, Date date, Point originPoint) {
		this.radius = radius;
		this.date = date;
		this.originPoint = originPoint;
		this.center = getCenterCoordinates();

	}

	/*
	 * This method is used to calculate area.
	 * @return This method return area.
	 */
	public double getArea() {
		return (Math.PI * radius * radius);
	}

	/*
	 * This method is used to calculate perimeter. return This return perimeter.
	 */
	public double getPerimeter() {
		return (2 * Math.PI * radius);
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

		boolean distanceCheck = false;

		if (getDistance(center, givenPoint) < radius) {
			distanceCheck = true;
		}

		return distanceCheck;
	}

	/*
	 * This method is used to gate date.
	 * @return This return date.
	 */
	public Date getTimeStamp() {
		return date;
	}

	/*
	 * This method is used to get shape type.
	 * @return This return the type of shape.
	 */
	public String getShapeType() {
		return "CIRCLE";
	}

	/*
	 * This method is used to calculate distance between (0,0) to shape origin
	 * point.
	 * @return, This return distance between (0,0) to shape origin point.
	 */
	public double getOriginDistance() {

		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0)
				+ (originPoint.y - 0) * (originPoint.y - 0));
	}

	/*
	 * This method is used to calculate distance between center to given point.
	 * @param center, center of circle.
	 * @param givenPoint
	 * @return distance between center and given point
	 */
	private double getDistance(Point center, Point givenPoint) {

		return Math.sqrt((center.x - givenPoint.x) * (center.x - givenPoint.x)
				+ (center.y - givenPoint.y) * (center.y - givenPoint.y));
	}

	/*
	 * This method is used to find center of circle.
	 * @return coordinates of center
	 */
	private Point getCenterCoordinates() {
		double xAxis, yAxis;
		double theta = Math.atan(originPoint.y / originPoint.x); 

		xAxis = radius * Math.sin(theta);
		yAxis = radius * Math.cos(theta);

		return new Point(originPoint.x + xAxis, originPoint.y + yAxis);
	}

}
