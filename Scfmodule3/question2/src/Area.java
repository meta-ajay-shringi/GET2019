import java.util.Scanner;

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
	public static double triangleArea(double width, double height) {
		double area = 0.5 * width * height;
		return area;
	}

	/*
	 * This method is used to calculate area of rectangle.
	 * @param width width of rectangle.
	 * @param height height of rectangle.
	 * @return double this return area of rectangle.
	 */
	public static double rectangleArea(double width, double height) {
		double area = width * height;
		return area;
	}

	/*
	 * This method is used to calculate area of square.
	 * @param width width of rectangle.
	 * @return double this return area of rectangle.
	 */
	public static double squareArea(double width) {
		double area = width * width;
		return area;
	}

	/*
	 * This method is used to area of circle.
	 * @param radius this is radius of circle.
	 * @return double this return area of circle.
	 */
	public static double circleArea(double radius) {
		double area = 3.14 * radius * radius;
		return area;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while (true) {
			System.out
					.println("Available option \n 1.triangle area \n 2.Rectangle area \n 3.Square area \n 4.Circle area \n 5.exit");
			System.out.println("Please enter your choice");
			int choice;

			try {        // If choice is not Integer value then exception.
				choice = in.nextInt();
			} catch (Exception e) {
				System.out.println("Wrong Input");
				break;
			}

			switch (choice) {
			case 1:
				double width;
				double height;
				System.out.println("please enter width of triangle ");
				width = in.nextInt();
				System.out.println("Please enter height of triangle ");
				height = in.nextInt();
				double areaOfTriangle = triangleArea(width, height);
				System.out.println("Area of triangle is  " + areaOfTriangle);
				break;

			case 2:
				System.out.println("please enter width of rectangle ");
				width = in.nextInt();
				System.out.println("Please enter height of rectangle ");
				height = in.nextInt();
				double areaOfrectangle = rectangleArea(width, height);
				System.out.println("Area of rectangle is  " + areaOfrectangle);
				break;

			case 3:
				System.out.println("please enter width of square ");
				width = in.nextInt();
				double areaOfSquare = squareArea(width);
				System.out.println("Area of square is  " + areaOfSquare);
				break;

			case 4:
				double radius;
				System.out.println("please enter radius of circle ");
				radius = in.nextInt();
				double areaOfCircle = circleArea(radius);
				System.out.println("Area of circle is " + areaOfCircle);
				break;

			case 5:
				System.out.println("Exit");
				in.close();
				System.exit(0);
				break;

			default:
				System.out.println("Please enter valid option");
				break;

			}

		}

	}

}
