package question1;

import java.util.Date;

/*
* This class is used to do various operation on triangle like
* get area, perimeter ,origin and pointEnclosed.
*/
public class Triangle implements Shape
{
    double side1;
    double side2;
    double side3;
    double height;
    Date date;
    Point originPoint;
    
    public Triangle(double side1, double side2, double side3, double height, Date date, Point originPoint) {
    
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
        this.date = date;
        this.originPoint = originPoint;
    }
    
    /*
     * This method is used to calculate area.
     * @return This method return area.
     */
    public double getArea() {
        return ( (side1 * height) / 2);
    }
    
    /*
     * This method is used to calculate perimeter.
     * return This return perimeter.
     */
    public double getPerimeter() {
        return (side1 + side2 + side3);
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
     * This method is used to check that given point is 
     * inside in shape or not.
     * @param givenPoint, This is point to be check.
     * @return This return true is point inside else return false.
     */
	public boolean isPointEnclosed(Point givenPoint) {

	    boolean enclosed = false;
        double base = Math.sqrt(Math.pow(side3, 2) - Math.pow(height, 2));
        Point b = new Point(originPoint.x + side1, originPoint.y);
        Point c = new Point(originPoint.x + base, originPoint.y + height);
                
        if(Math.abs(getArea() - ((getAreaByVertices(givenPoint, originPoint, b)) + getAreaByVertices(givenPoint, b, c) + getAreaByVertices(givenPoint, originPoint, c))) <= 0.001)
            enclosed = true;        
        
        return enclosed;
        
	}

	/*
	 * This method is used to get shape type.
	 * @return This return the type of shape.
	 */
	public String getShapeType() {
		return "TRIANGLE";
	}
	
	/*
	 * This method is used to calculate distance between (0,0) to shape origin point.
	 * @return, This return distance between (0,0) to shape origin point.
	 */
	public double getOriginDistance() {		
		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
	}
	
	/* This method is used to calculate area if all coordinate of triangle is given.
	 * @param a is points of vertex A.
	 * @param b is points of vertex B.
	 * @param c is points of vertex C.
	 * @return area of triangle ABC with given points a, b, c.
	 */
	public double getAreaByVertices(Point a, Point b, Point c)
    {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    } 
}
