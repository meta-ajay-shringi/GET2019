
/*
 * This class is used to various operations on Strings like
 * reverse, compare two string and find largest string. 
 */
public class OperationsOnStrings {

	/*
	 * This method is used to compare to string.
	 * @param firstString first string to be compare.
	 * @param secondString second string to be compare.
	 * @return int this return 0 if string equal.
	 */
	public int compareTwoString(String firstString, String secondString) {
		
		if(firstString == null || secondString == null) {
		    throw new AssertionError(" string is null ");
		}
	
		for (int index = 0; index < firstString.length(); index++) {
			
			if (firstString.charAt(index) - secondString.charAt(index) != 0) {
				return firstString.charAt(index) - secondString.charAt(index);
			}
		}

		return 0;
	}

	/*
	 * This method used to return reverse of any string.
	 * @param reverseToBeString this is string which going to reverse.
	 * @return String This return reverse of any string.
	 */
	public String reverseString(String reverseToBeString) {

        if(reverseToBeString == null ) {
		    throw new AssertionError(" string is null ");
		}
		
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
	public String changedString(String changedToBeString) {
		
		 if(changedToBeString == null ) {
		    throw new AssertionError(" string is null ");
		}
		
		String newString = "";

		for (int index = 0; index < changedToBeString.length(); index++) {
			
			if (changedToBeString.charAt(index) >= 'A' && changedToBeString.charAt(index) <= 'Z') {
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
	public String findLargestString(String newString) {
	     if(newString == null ) {
		    throw new AssertionError(" string is null ");
		}
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
}