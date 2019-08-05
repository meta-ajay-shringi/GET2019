package question1;

/**
 * This is main class for perform operations.
 */
public class StackMain {

	public static void main(String[] args) {
		
		EvaluatExpression evaluatExpression = new EvaluatExpression();
		System.out.println(evaluatExpression.evaluatePostfixForLogical("( ( 4 + 5 ) > ( 8 * 2 ) + 1 )"));
		System.out.println(evaluatExpression.evaluatePostfix("( ( 4 + 5 ) + ( 8 * 2 ) + 1 )"));
		
	}

}
