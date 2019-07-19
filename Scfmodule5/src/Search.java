/*
 * This class used to search element using binary search and linear search.
 */
public class Search {

	/*
	 * This class used to search element using linear search.
	 * @param inputArray This is array of Numbers.
	 * @param numberToBeSearch This number search by this algorithm.
	 * @return int This return index of searching element.
	 */

	public int linearSearch(int inputArray[], int numberToBeSearch) {
		if(inputArray.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method linearSearch");
		}	
		return linearSearchElement(inputArray, numberToBeSearch, 0);
	}

	/*
	 * This class used to search element using linear search. its called by
	 * linear search method.
	 * @param inputArray This is array of Numbers.
	 * @param numberToBeSearch This number search by this algorithm.
	 * @return int This return index of searching element.
	 */
	public int linearSearchElement(int inputArray[], int numberToBeSearch, int index) {
		if (inputArray[index] == numberToBeSearch) {
			return index;
			
		} else if (index == inputArray.length - 1) {// When number not in array return -1
			return -1;
			
		} else {
			return linearSearchElement(inputArray, numberToBeSearch, index + 1);
		}
	}

	/*
	 * This method is used to search element using binary search.
	 * @param sortedArray This is sorted array of number.(Assuming array is
	 * sorted).
	 * @param numberToBeSearch This number search by this algorithm.
	 * @return int This return index of searching element.
	 */
	public int binarySearch(int sortedArray[], int numberToBeSearch) {
		if(sortedArray.length == 0) {
			throw new AssertionError(" Array is empty, assertion error in method BinarySearch");
		}	
		
		int startIndex = 0;
		int endIndex = sortedArray.length-1;

		return binarySearchElement(sortedArray, numberToBeSearch, startIndex, endIndex);
	}

	/*
	 * This method is used to search element using binary search It's called by
	 * binary search method.
	 * @param sortedArray This is sorted array of number.(Assuming array is
	 * sorted).
	 * @param numberToBeSearch This number search by this algorithm.
	 * @param startIndex This is start index of sorted array.
	 * @param endIndex This is end index of sorted array.
	 * @return int This return index of searching element.
	 */
	public int binarySearchElement(int sortedArray[], int numberToBeSearch, int startIndex, int endIndex) {
		
		if( startIndex <= endIndex) {
		   int mid = (startIndex + endIndex) / 2;

		   if (sortedArray[mid] == numberToBeSearch) {
			   return mid;
		   }
		   else if (sortedArray[mid] > numberToBeSearch) {
			    return binarySearchElement(sortedArray, numberToBeSearch, startIndex, mid - 1);
		   }
		   else  {
			   return binarySearchElement(sortedArray, numberToBeSearch, mid + 1, endIndex);
		   }
		}
		return -1;
   }
	
	
}
