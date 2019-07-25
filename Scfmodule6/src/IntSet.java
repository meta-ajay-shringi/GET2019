import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * This is immutable class which perform some operation like isMember, isSubset,
 *  complement and union of array.
 */
public final class IntSet {

	final int[] setArray;

	// constructor to initialize polynomial with input array.
	public IntSet(int[] setArray) {

		if (setArray == null) {
			throw new AssertionError("Array is null");
		}
		
		if (setArray.length == 0) {
			throw new AssertionError("Array is empty");
		}

		for (int index = 0; index < setArray.length; index++) {
			
			if (setArray[index] > 1000 || setArray[index] < 0) {
				throw new AssertionError(" Value should be in range from 0 to 1000 ");
			}
		}
		this.setArray = setArray;

	}

	/*
	 * This method is used to check x is a member of this class or not.
	 * @param x This is element to be check.
	 * @return This return true if it's member of class else return fasle.
	 */
	public boolean isMember(int x) {
		boolean isMemberval = false;
		for (int index = 0; index < setArray.length; index++) {

			if (setArray[index] == x) {
				isMemberval = true;
				break;
			}
		}

		return isMemberval;
	}

	/*
	 * This method is used to find size of setArray.
	 * @return This return size of setArray.
	 */
	public int size() {

		return setArray.length;
	}

	/*
	 * This method is used to check s is subset of given array or not.
	 * @param s This is s to be chack subset.
	 * @return This return true if subset else return false.
	 */
	public boolean isSubSet(IntSet s) {
		int count = 0;
		
		for (int index = 0; index < s.size(); index++) {

			if (isMember(s.setArray[index])) {
				count++;
			}
		}

		if (count == s.size()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * This method is used to get complement of set array, hear complement means
	 * value which not in setArray.
	 * @return return array which contain complement value.
	 */
	public int[] getComplement() {

		ArrayList<Integer> complement = new ArrayList<>();

		for (int index = 0; index <= 1000; index++) {

			if (!isMember(index)) {
				complement.add(index);
			}
		}

		int complementArray[] = new int[complement.size()];
		
		for (int index = 0; index < complement.size(); index++) {
			complementArray[index] = complement.get(index);
		}

		return complementArray;
	}

	/*
	 * This method is used to take union of s1 and s2.
	 * @param s1 This is s1 which contain numbers.
	 * @param s2 This is s2 which contain numbers.
	 * @return This return union of s1 and s2.
	 */
	public static IntSet union(IntSet s1, IntSet s2) {

		Set<Integer> unionOfIntSet = new HashSet<Integer>();

		for (int index = 0; index < s1.size(); index++) {
			unionOfIntSet.add(s1.setArray[index]);
		}

		for (int index = 0; index < s2.size(); index++) {
			unionOfIntSet.add(s2.setArray[index]);
		}

		int unionArray[] = new int[unionOfIntSet.size()];

		int index = 0;

		Iterator iterator = unionOfIntSet.iterator();

		while (iterator.hasNext()) {
			int element = (int) iterator.next();
			unionArray[index] = element;
			index++;
		}

		return new IntSet(unionArray);
	}

}
