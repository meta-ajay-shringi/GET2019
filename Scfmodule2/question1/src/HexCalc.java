import java.util.Scanner;

/*
 * This class used calculate addition, subtration, multiplication 
 * and division of two hexadecimal number and also check
 * hexadecimal number are == , >,< or no.t 
 */
public class HexCalc {

	/*
	 * This methord is used to convert hexadecimal number to decimal number 
	 * @param hexadecimalNumber This is hexadecimal number, input as string.
	 */
	public static int hexadecimalToDecimal(String hexadecimalNumber) {

		int base = 1;
		int decimalNumber = 0;

		for (int index = hexadecimalNumber.length() - 1; index >= 0; index--) {
			if (hexadecimalNumber.charAt(index) >= '0'
					&& hexadecimalNumber.charAt(index) <= '9') {
				decimalNumber += (hexadecimalNumber.charAt(index) - 48) * base;
				base = base * 16;
			}

			if (hexadecimalNumber.charAt(index) >= 'A'
					&& hexadecimalNumber.charAt(index) <= 'F') {
				decimalNumber += (hexadecimalNumber.charAt(index) - 55) * base;
				base = base * 16;
			}
		}

		return decimalNumber;
	}

	/*
	 * This method used to convert decimal number to hexadecimal number.
	 * @param decimalNumber This is decimal number, input as integer.
	 */
	public static String decimalToHexadecimal(int decimalNumber) {
		String hexadecimalNumber = "";

		if (decimalNumber == 0) {
			return "0";
		}

		int temp = 0;

		if (decimalNumber < 0) {
			temp++;
			decimalNumber = decimalNumber * -1;
		}

		while (decimalNumber != 0) {
			int reminder = 0;
			reminder = decimalNumber % 16;

			if (reminder < 10) {
				hexadecimalNumber += (char) (reminder + 48);

			} else {
				hexadecimalNumber += (char) (reminder + 55);
			}
			decimalNumber = decimalNumber / 16;
		}

		StringBuffer hexadecimalNum = new StringBuffer();
		hexadecimalNum.append(hexadecimalNumber);
		if (temp > 0) {
			hexadecimalNum.append("-");
		}
		return hexadecimalNum.reverse().toString();
	}

	/*
	 * This method is used to add two hexadecimal number.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return String This return sum of hexnumber1 and hexNumber2 in
	 * hexadecimal form.
	 */
	public static String addHexadecimalNumber(String hexNumber1,
			String hexNumber2) {
		int decimalNumber1 = hexadecimalToDecimal(hexNumber1);
		int decimalNumber2 = hexadecimalToDecimal(hexNumber2);

		int addDecimal = decimalNumber1 + decimalNumber2;

		String addHexadecimal = decimalToHexadecimal(addDecimal);
		return addHexadecimal;

	}

	/*
	 * This method is used to subtract two hexadecimal number.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return String This return subtraction of hexnumber1 and hexNumber2 in
	 * hexadecimal form.
	 */
	public static String subtractHexadecimalNumber(String hexNumber1,
			String hexNumber2) {
		int decimalNumber1 = hexadecimalToDecimal(hexNumber1);
		int decimalNumber2 = hexadecimalToDecimal(hexNumber2);

		int subtractDecimal = decimalNumber1 - decimalNumber2;

		String subtractHexadecimal = decimalToHexadecimal(subtractDecimal);
		return subtractHexadecimal;

	}

	/*
	 * This method is used to divide two hexadecimal number.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return String This return division of hexnumber1 and hexNumber2 in
	 * hexadecimal form.
	 */
	public static String divideHexadecimalNumber(String hexNumber1,
			String hexNumber2) {
		int decimalNumber1 = hexadecimalToDecimal(hexNumber1);
		int decimalNumber2 = hexadecimalToDecimal(hexNumber2);

		int Decimal = decimalNumber1 / decimalNumber2;

		String Hexadecimal = decimalToHexadecimal(Decimal);
		return Hexadecimal;

	}

	/*
	 * This method is used to multiply two hexadecimal number.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return String This return multiplication of hexnumber1 and hexNumber2 in
	 * hexadecimal form.
	 */
	public static String multiplyHexadecimalNumber(String hexNumber1,
			String hexNumber2) {
		int decimalNumber1 = hexadecimalToDecimal(hexNumber1);
		int decimalNumber2 = hexadecimalToDecimal(hexNumber2);

		int Decimal = decimalNumber1 * decimalNumber2;

		String Hexadecimal = decimalToHexadecimal(Decimal);
		return Hexadecimal;

	}

	/*
	 * This method is used to check both hexadecimal number are equal or not.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return boolean This return true if both are equal.
	 */
	public static boolean equal(String hexNumber1, String hexNumber2) {
		if (hexNumber1.length() != hexNumber2.length()) {
			return false;
		}

		for (int index = 0; index < hexNumber1.length(); index++) {

			if (hexNumber1.charAt(index) != hexNumber2.charAt(index)) {
				return false;
			}
		}

		return true;

	}

	/*
	 * This method is used to check first hexadecimal number greater or not.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return boolean This return true if first number is greater then second.
	 */
	public static boolean firstGreater(String hexNumber1, String hexNumber2) {
		for (int index = 0; index < hexNumber1.length(); index++) {
			if (hexNumber1.charAt(index) < hexNumber2.charAt(index)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * This method is used to check second hexadecimal number greater or not.
	 * @param hexNumber1 This is first hexadecimal number.
	 * @param hexNumber2 This is second hexadecimal number.
	 * @return boolean This return true if second number is greater then first.
	 */
	public static boolean secondGreater(String hexNumber1, String hexNumber2) {
		for (int index = 0; index < hexNumber2.length(); index++) {
			if (hexNumber1.charAt(index) > hexNumber2.charAt(index)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter hexadecimal Number");
		String hexadecimalNumber = in.nextLine();
		System.out.println("decimal number of hexadecimal number " + hexadecimalNumber + " is " + hexadecimalToDecimal(hexadecimalNumber));

		System.out.println("Please enter decimal Number");
		int decimalNumber = in.nextInt();
		in.nextLine();
		System.out.println("hexadecimal number of decimal number " + decimalNumber + " is " + decimalToHexadecimal(decimalNumber));

		System.out.println("Please enter first hexadecimal number");
		String firstHexadecimalNumber = in.nextLine();

		System.out.println("Please enter second hexadecimal number");
		String secondHexadecimalNumber = in.nextLine();

		System.out.println("Addition of number " + firstHexadecimalNumber + " to " + secondHexadecimalNumber + " is " + addHexadecimalNumber(firstHexadecimalNumber,secondHexadecimalNumber));
		System.out.println("Subtration of number " + firstHexadecimalNumber + " to " + secondHexadecimalNumber + " is " + subtractHexadecimalNumber(firstHexadecimalNumber,secondHexadecimalNumber));
		System.out.println("Multiplication of number " + firstHexadecimalNumber + " to " + secondHexadecimalNumber + " is " + multiplyHexadecimalNumber(firstHexadecimalNumber,secondHexadecimalNumber));
		System.out.println("Division of number " + firstHexadecimalNumber + " to " + secondHexadecimalNumber + " is " + divideHexadecimalNumber(firstHexadecimalNumber,secondHexadecimalNumber));

		System.out.println(firstHexadecimalNumber + " is equal to "	+ secondHexadecimalNumber + " is " + equal(firstHexadecimalNumber, secondHexadecimalNumber));
		System.out.println(firstHexadecimalNumber + " is greater then "+ secondHexadecimalNumber	+ " is " + firstGreater(firstHexadecimalNumber,secondHexadecimalNumber));
		System.out.println(secondHexadecimalNumber + " is greater then " + firstHexadecimalNumber + " is " + secondGreater(firstHexadecimalNumber,secondHexadecimalNumber));
		in.close();
	}

}