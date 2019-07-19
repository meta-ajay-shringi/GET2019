/*
 * This class used to find least common multiple and highest 
 * common factor of two number.
 */
public class MathOperation {

	/*
	 * This method is used to find least common multiple of two number.
	 * @param firstNumber This is first number.
	 * @param secondNumber This is second number.
	 * @return This return least common multiple of first number and second number.
	 */
   public int lcm(int firstNumber, int secondNumber)
   {
	
	   return lcmCalc(firstNumber, secondNumber, 1);
    }
	
	
	/*
	 * This method is used to find least common multiple of two number.
	 * @param firstNumber This is first number.
	 * @param secondNumber This is second number.
	 * @param commonMultiple This is common multiple of both number.
	 * @return This return least common multiple of first number and second number.
	 */
	public int lcmCalc(int firstNumber, int secondNumber,int commonMultiple) {
		
		if ((commonMultiple % firstNumber == 0) && (commonMultiple % secondNumber == 0)) {
			return commonMultiple;
		}
		else {
		        return lcmCalc(firstNumber, secondNumber,commonMultiple+1);
	         	
	    }
	}
	/*
	 * This method is used to find highest common factor of two number.
	 * @param firstNumber This is first number.
	 * @param secondNumber This is second number.
	 * @return This return highest common factor of first number and second number.
	 */

	public int hcf(int firstNumber, int secondNumber) {
		if (secondNumber == 0)
			return firstNumber;
		else
			return hcf(secondNumber, firstNumber % secondNumber);

	}

}
