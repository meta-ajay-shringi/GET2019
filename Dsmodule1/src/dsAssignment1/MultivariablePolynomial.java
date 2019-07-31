package dsAssignment1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to represents a multivariable polynomial using nested lists.
 */
public class MultivariablePolynomial {

	List<Term> multivariablePolynomial = new ArrayList<>();

	public MultivariablePolynomial(List<Term> termList) {

		this.multivariablePolynomial = termList;
	}

	
	/**
	 * This method is used to calculate the degree of the multivariable polynomial.
	 * @return, degree of the multivariable polynomial.
	 */
	int calculatePolynomialDegree() {
		
		int highestDegree = 0;
		for (int index1 = 0; index1 < multivariablePolynomial.size(); index1++) {
			int degree = 0;
			
			for (int index2 = 0; index2 < multivariablePolynomial.get(index1).variableList.size(); index2++) {
				degree += multivariablePolynomial.get(index1).variableList.get(index2).getVariablePower();
			}
			
			if (degree > highestDegree) {
				highestDegree = degree;
			}
		}
		return highestDegree;
	}

	
	/**
	 * This method visualises the Multivariable polynomial into string.
	 * @return, Multivariable Polynomial.
	 */
	String visualiseMultivariablePolynomial() {
		
		String polynomialString = "";
		
		for (int index1 = 0; index1 < multivariablePolynomial.size(); index1++) {
			polynomialString = polynomialString + multivariablePolynomial.get(index1).termCoefficient;
			
			for (int index2 = 0; index2 < multivariablePolynomial.get(index1).variableList.size(); index2++) {
				polynomialString = polynomialString + "*" + multivariablePolynomial.get(index1).variableList.get( index2).getVaribleName() + "^" + multivariablePolynomial.get(index1).variableList.get(index2).getVariablePower();
			}
			
			if (index1 < multivariablePolynomial.size() - 1) {
				polynomialString += " + ";
			}
		}
		return polynomialString;
	}

}