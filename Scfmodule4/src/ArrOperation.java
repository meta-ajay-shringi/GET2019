import java.util.ArrayList;

/*
 * This class is used to do some array oprations like
 * find maximum length of mirror, fix X and Y, 
 * count clumps and split array.
 */
public class ArrOperation {

	/*
	 * this method is used to return the size of the largest mirror section
	 * found in the input array.
	 * @param arrayOfNumber This is array of numbers.
	 * @return This return the size of the largest mirror section.
	 */
	public static int lengthOfMirror(int[] arrayOfNumber) {
		int length_mirror = 0;
		int count = 0;

		if (arrayOfNumber.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method lengthOfMirror");
		}
		
		for (int index1 = 0; index1 < arrayOfNumber.length; index1++) {
			int index = index1;
			count = 0;
			
			for (int index2 = arrayOfNumber.length - 1; index2 >= index1; index2--) {
				
				if (arrayOfNumber[index] == arrayOfNumber[index2]) {
					count++;
					index++;
				} else if (count > length_mirror) {
					length_mirror = count;
					count = 0;
					index = index1;
				} else {
					count = 0;
					index = index1;
				}
				if (count > length_mirror)
					length_mirror = count;
			}

		}

		return length_mirror;
	}

	/*
	 * This method is used to count clumps, Clump in an array is a series of 2
	 * or more adjacent elements of the same value
	 * @param arrayOfNumbers This is array of numbers.
	 * @return This return number of clumps in array.
	 */

	public static int countClumps(int arrayOfNumbers[]) {
		int count = 0;
		int clumps = 0;

		if (arrayOfNumbers.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method countClumps");
		}
		
		for (int index = 0; index < arrayOfNumbers.length - 1; index++) {
			
			if (arrayOfNumbers[index] == arrayOfNumbers[index + 1]) {
				count++;
			} else if (count > 0) {
				clumps++;
				count = 0;
			}
		}

		if (count > 0) {
			clumps++;
		}

		return clumps;
	}

	/*
	 * this method is used to rearranged X and Y so that every X is immediately
	 * followed by a Y.
	 * @param arrayOfNumber This is array of numbers.
	 * @param X This is value of X.
	 * @param Y This is value of Y.
	 * @return int This return array of rearranged X and Y.
	 */
	public static int[] fixXY(int arrayOfNumber[], int X, int Y) {

		ArrayList<Integer> indexOfY = new ArrayList<Integer>();
		ArrayList<Integer> indexOfX = new ArrayList<Integer>();

		if (arrayOfNumber.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method fixXY");
		}

		for (int index = 0; index < arrayOfNumber.length; index++) {
			if (arrayOfNumber[index] == Y) {
				indexOfY.add(index);
			}
			if (arrayOfNumber[index] == X) {
				indexOfX.add(index);
			}

		}

		if (indexOfY.size() != indexOfX.size()) {
			throw new AssertionError(" Number of X and Y not equal,assertion error in method fixXY");
		} else {

			for (int index = 0; index < indexOfX.size() - 1; index++) {
				if (indexOfX.get(index) - indexOfX.get(index + 1) == -1) {
					throw new AssertionError("two adjacents X values are there,assertion error in method fixXY");
				}
			}

		}

		for (int index = 0; index < indexOfX.size(); index++) {
			
			if (indexOfX.get(index) == arrayOfNumber.length - 1) {
				throw new AssertionError(" X occurs at the last index of array,assertion error in method fixXY");
			}
		}

		int yIndex = 0;
		int temp = 0; // For swap Y
		for (int index = 0; index < arrayOfNumber.length - 1; index++) {
			if (arrayOfNumber[index] == X) {
				temp = arrayOfNumber[index + 1];
				arrayOfNumber[index + 1] = arrayOfNumber[indexOfY.get(yIndex)];
				arrayOfNumber[indexOfY.get(yIndex)] = temp;
				yIndex++;
			}

		}

		return arrayOfNumber;
	}

	/*
	 * This method is used to split the input array so that the sum of the
	 * numbers on one side is equal to the sum of the numbers on the other side.
	 * @param arrayOfNumber This is array of numbers.
	 * @return int This return index where we can split.
	 */
	public static int splitArray(int arrayOfNumber[]) {
		int totalSum = 0;
		
		if (arrayOfNumber.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method splitArray");
		}

		for (int index = 0; index < arrayOfNumber.length; index++) {
			totalSum = totalSum + arrayOfNumber[index];
		}

		if (totalSum % 2 != 0) {
			return -1;
		} else {
			totalSum = totalSum / 2;
			
			for (int index = 0; index < arrayOfNumber.length; index++) {
				totalSum = totalSum - arrayOfNumber[index];
				if (totalSum == 0)
					return index + 1;

			}
		}
		return -1;
	}

}
