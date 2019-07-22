
/*
 * This class is used to calculate Area of different shapes like
 *  triangle, rectangle , square and circle.
 */
public class Area {

	/*
	 * This method is used to calculate area of triangle.
	 * @param width width of triangle.
	 * @param height height of triangle.
	 * @return double this return area of triangle.
	 */
	public double triangleArea(double width, double height) {
	    if((width < 0) || (height < 0))
	    {
	            throw new AssertionError(" Area never be negative or 0 ");    
	    }
	    
		double area = 0.5 * width * height;
		return area;
	}

	/*
	 * This method is used to calculate area of rectangle.
	 * @param width width of rectangle.
	 * @param height height of rectangle.
	 * @return double this return area of rectangle.
	 */
	public double rectangleArea(double width, double height) {
	    if((width <= 0) || (height <= 0))
	    {
	            throw new AssertionError(" Area never be negative or 0 ");    
	    }
	    
		double area = width * height;
		return area;
	}

	/*
	 * This method is used to calculate area of square.
	 * @param width width of rectangle.
	 * @return double this return area of rectangle.
	 */
	public double squareArea(double width) {
	    if(width <= 0)
	    {
	            throw new AssertionError(" Area never be negative or 0 ");    
	    }
	    
		double area = width * width;
		return area;
	}

	/*
	 * This method is used to area of circle.
	 * @param radius this is radius of circle.
	 * @return double this return area of circle.
	 */
	public double circleArea(double radius) {
	    if(radius <= 0)
	    {
	            throw new AssertionError(" Area never be negative or 0 ");    
	    }
	    
		double area = 3.14 * radius * radius;
		return area;
	}

}