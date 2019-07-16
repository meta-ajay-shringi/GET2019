import java.util.Scanner;

/*
 * This class is used to various operations on Strings like
 * reverse, compare two string and find largest string. 
 */
public class OperationsOnStrings {

	/*
	 * This method is used to compare to string.
	 * @param firstString first string to be compare.
	 * @param secondString second string to be compare.
	 * @return int this return 1 if string equal and return 0 if not equal.
	 */
	public static int compareTwoString(String firstString, String secondString) {
		if (firstString.length() != secondString.length()) {
			return 0;
		}

		for (int index = 0; index < firstString.length(); index++) {
			if (firstString.charAt(index) != secondString.charAt(index)) {
				return 0;
			}
		}

		return 1;
	}

	/*
	 * This method used to return reverse of any string.
	 * @param reverseToBeString this is string which going to reverse.
	 * @return String This return reverse of any string.
	 */
	public static String reverseString(String reverseToBeString) {

		String reverse = "";

		for (int index = reverseToBeString.length() - 1; index >= 0; index--) {
			reverse += reverseToBeString.charAt(index);
		}
		return reverse;

	}

	/*
	 * This method is used to replace lowercase characters with uppercase and
	 * vice-versa.
	 * @param changedToBeString This is string as parameter.
	 * @return String This return lowercase characters with uppercase and
	 * vice-versa.
	 */
	public static String changedString(String changedToBeString) {
		String newString = "";

		for (int index = 0; index < changedToBeString.length(); index++) {
			if (changedToBeString.charAt(index) >= 'A'
					&& changedToBeString.charAt(index) <= 'Z') {
				newString += (char) (changedToBeString.charAt(index) + 32);
			} else {
				newString += (char) (changedToBeString.charAt(index) - 32);
			}
		}

		return newString;
	}

	/*
	 * This method is used to return largest word of a string.
	 * @param newString this is string in which find largest string.
	 * @return String This return largest word of a string.
	 */
	public static String findLargestString(String newString) {
		String largestString = "";
		String word = "";

		for (int index = 0; index < newString.length(); index++) {
			if (newString.charAt(index) == ' ') {
				if (largestString.length() <= word.length()) {
					largestString = word;
				}
				word = "";
				continue;
			}
			word += newString.charAt(index);
		}

		if (largestString.length() <= word.length()) {
			largestString = word;
		}

		return largestString;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a string");
		String firstString = in.nextLine();
		System.out.println("Please enter a string");
		String secondString = in.nextLine();
		int checkEqual;

		checkEqual = compareTwoString(firstString, secondString);
		System.out.println("String " + firstString + "equal to string " + secondString + " is " + checkEqual);

		System.out.println("Please enter a string");

		String reverseToBeString = in.nextLine();
		String newString;

		newString = reverseString(reverseToBeString);

		System.out.println("Reverse of string " + reverseToBeString + " is " + newString);

		System.out.println("Please enter a string");
		String setString = in.nextLine();
		System.out.println("Chenged in string " + setString + " is " + changedString(setString));

		System.out.println("Please enter a string");
		String checkLargest = in.nextLine();
		System.out.println("Largest string of string " + checkLargest + " is " + findLargestString(checkLargest));
		in.close();
	}

}
