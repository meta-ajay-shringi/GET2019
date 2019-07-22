/*
 * This class is used to do various operation
 * in polynomial.
 */
public final class Poly {

	int[][] polynomial;

	// constructor to initialize polynomial with input array.
	Poly(int[][] input) {
		
		if (input == null)
			throw new AssertionError("input can't be null");
		
		if (input.length == 0)
			throw new AssertionError("input can't be empty");
		polynomial = input;
	}

	// constructor to declare size of polynomial 2D array.
	Poly(int size) {
		polynomial = new int[size][2];
	}

	/*
	 * This method is used to evaluate the value of polynomial at a value.
	 * @param value is the constant put in variable.
	 * @return result of evaluation.
	 */
	int evaluate(float value) {
		int result = 0;
		
		for (int index = 0; index < polynomial.length; index++) {
			result += polynomial[index][0] * Math.pow(value, polynomial[index][1]);
		}
		
		return result;
	}

	/*
	 * This method is used to compute the degree of a polynomial.
	 * @return the {int} degree of the polynomial.
	 */
	int degree() {
		int degree = 0;
		
		for (int index = 0; index < polynomial.length; index++) {
			
			if (degree < polynomial[index][1])
				degree = polynomial[index][1];
		}
		return degree;
	}

	/*
	 * This method is used to get coefficient of existing power in polynomial.
	 * @param power is the input whose coefficient to be found.
	 * @return {int} coefficient of x^power.
	 */
	private int getCofficient(int power) {
		
		for (int index = 0; index < polynomial.length; index++) {
			
			if (polynomial[index][1] == power) {
				return polynomial[index][0];
			}
		}
		return 0;
	}

	/*
	 * This method is used to add two polynomial.
	 * @param polynomial1 is the first polynomial.
	 * @param polynomial2 is the second polynomial.
	 * @return {Poly} the addition polynomial.
	 */
	static Poly addPoly(Poly polynomial1, Poly polynomial2) {
		
		int degree = Math.max(polynomial1.degree(), polynomial2.degree());
		Poly addition = new Poly(degree + 1);
		int cofficient = 0;
		
		for (int index = 0; index <= degree; index++) {

			if (polynomial1.getCofficient(index) != 0 || polynomial2.getCofficient(index) != 0) {
				cofficient = polynomial1.getCofficient(index) + polynomial2.getCofficient(index);
				addition.polynomial[index][0] = cofficient;
				addition.polynomial[index][1] = index;
			}
		}
		return addition;
	}

	/*
	 * This method is used to check if 2D array contains the given power
	 * @param givenArray is the polynomial to be checked
	 * @param power is the power of variable to be checked
	 * @return index where the power of variable & its coefficient exists or -1 if doesn't exist
	 */
	private static int returnIndex(int[][] givenArray, int power) {
		int indexOfPower = -1;
		
		for (int index = 0; index < givenArray.length; index++) {
			
			if (givenArray[index][1] == power) {
				indexOfPower = index;
			}
		}
		return indexOfPower;
	}

	/*
	 * This method is used to multiply two polynomial
	 * @param polynomial1 is the first polynomial
	 * @param polynomial2 is the second polynomial
	 * @return {Poly} multiplication polynomial
	 */

	static Poly multiplyPoly(Poly polynomial1, Poly polynomial2) {

		int degree = polynomial1.degree() + polynomial2.degree();
		Poly multi = new Poly(degree + 1);
		
		int indexOfPower = 0;
		int cofficient = 0, power = 0, increment = 0;
		
		for (int index1 = 0; index1 < polynomial1.polynomial.length; index1++) {
			
			for (int index2 = 0; index2 < polynomial2.polynomial.length; index2++) {
				
				cofficient = polynomial1.polynomial[index1][0] * polynomial2.polynomial[index2][0];
				power = polynomial1.polynomial[index1][1] + polynomial2.polynomial[index2][1];

				indexOfPower = returnIndex(multi.polynomial, power);
				
				if (indexOfPower != -1) {
					multi.polynomial[indexOfPower][0] += cofficient;
				} else if (cofficient != 0) {
					multi.polynomial[increment][0] = cofficient;
					multi.polynomial[increment][1] = power;
					increment++;
				}
			}
		}
		return multi;
	}
}