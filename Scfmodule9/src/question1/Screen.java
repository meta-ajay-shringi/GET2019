package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import question1.Shape.ShapeType;

/*
 *  This class is used to add shape, remove all shape and 
 *  sort by perimeter, area, origin distance and timestamp.
 */
public class Screen {

	private List<Shape> shapesOnScreen = new ArrayList<Shape>();

	/*
	 * This method is used to adds shape on screen.
	 * @param shapeObject, Add this shape.
	 * @return true if shape is added else false.
	 */
	public boolean addShape(Shape shapeObject) {

		try {
			if (shapeObject == null) {
				throw new AssertionError(" Object is null ");
			}

			if (shapeObject.getOrigin().x < 0 || shapeObject.getOrigin().y < 0 || shapeObject.getOrigin().x > Point.XMAX || shapeObject.getOrigin().y > Point.YMAX) {
				throw new AssertionError("Origin Point not in screen.");
			}

			shapesOnScreen.add(shapeObject);

			return true;
			
		} catch (AssertionError error) {
			
			return false;
		}

	}

	/*
	 * This method is used to remove all occurrences of given shape type.
	 * @param type, This is the Shape Type.
	 * @return true if all shapes are deleted else false
	 */
	public boolean removeAllShapeOfType(ShapeType type) {
		if (type == null) {
			return false;
		}

		boolean flag = false;
		for (int index = 0; index < shapesOnScreen.size(); index++) {
			if (shapesOnScreen.get(index).getShapeType() == type.toString()) {
				shapesOnScreen.remove(index);
				index--;
				flag = true;
			}
		}

		return flag;
	}

	/*
	 * This method is used to removes shape object of given type.
	 * @param shapeObjectName.
	 * @return true if shape is deleted else false.
	 */
	public boolean deleteShape(Shape shapeObjectName) {

		boolean flag = false;
		if (shapesOnScreen.contains(shapeObjectName)) {
			shapesOnScreen.remove(shapeObjectName);
			flag = true;
		}

		return flag;

	}

	/*
	 * This method is used to sorts the list of objects in ascending order
	 * according to area.
	 * @return this return sortedList.
	 */
	public List<Shape> sortByArea() {

		if (shapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByArea = new ArrayList<Shape>(shapesOnScreen);

		Collections.sort(sortedListByArea, ShapeSort.sortByArea);

		return sortedListByArea;
	}

	/*
	 * This method is used to sorts the list of objects in ascending order
	 * according to perimeter.
	 * @return, This return sortedList
	 */
	public List<Shape> sortByPerimeter() {
		if (shapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByPerimeter = new ArrayList<Shape>(shapesOnScreen);

		Collections.sort(sortedListByPerimeter, ShapeSort.sortByPerimeter);

		return sortedListByPerimeter;
	}

	/*
	 * This method is used to sorts the list of objects in ascending order
	 * according to Origin Distance.
	 * @return This return sortedList.
	 */
	public List<Shape> sortByOriginDistance() {
		if (shapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByOriginDistance = new ArrayList<Shape>(shapesOnScreen);

		Collections.sort(sortedListByOriginDistance, ShapeSort.sortByOriginDistance);

		return sortedListByOriginDistance;
	}

	/*
	 * This method is used to sorts the list of objects in ascending order
	 * according to Origin Distance.
	 * 
	 * @return this return sortedList.
	 */
	public List<Shape> sortByTimestamp() {
		if (shapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		return shapesOnScreen;
	}

}
