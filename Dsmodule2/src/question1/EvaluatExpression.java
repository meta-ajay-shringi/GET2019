package question1;

import java.util.HashMap;

/**
 * This class is used to evaluate given expression.
 */
public class EvaluatExpression {

	static HashMap<String, Integer> map = new HashMap<>();
	static {

		map.put("{", -9);
		map.put("[", -8);
		map.put("(", -8);
		map.put("!", 7);
		map.put("*", 6);
		map.put("/", 6);
		map.put("+", 5);
		map.put("-", 5);
		map.put(">", 4);
		map.put(">=", 4);
		map.put("<", 4);
		map.put("<=", 4);
		map.put("&&", 3);
		map.put("||", 2);
	}

	/**
	 * This method is used to convert infix expression to postfix.
	 * @param expression, This expression going to convert.
	 * @return, This return postfix expression.
	 */
	public String infixToPostfix(String expression) {

		String infix[] = expression.split(" ");
		String postfix = "";

		Stack stack = new Stack();

		for (int index = 0; index < infix.length; index++) {

			if ("(".equals(infix[index]) || "[".equals(infix[index]) || "{".equals(infix[index])) {
				stack.push(infix[index]);
			} else if (map.containsKey(infix[index])) {

				while (map.get(stack.top.data) > map.get(infix[index])) {
					postfix += stack.top.data + " ";
					stack.pop();
				}
				stack.push(infix[index]);
				
			} else if (")".equals(infix[index])) {
				while (!"(".equals(stack.top.data)) {
					postfix += stack.top.data + " ";
					stack.pop();
				}
				stack.pop();
			} else if ("]".equals(infix[index])) {
				
				while (!"[".equals(stack.top.data)) {
					postfix += stack.top.data + " ";
					stack.pop();
				}
				stack.pop();
			} else if ("}".equals(infix[index])) {
				
				while (!"{".equals(stack.top.data)) {
					postfix += stack.top.data + " ";
					stack.pop();
				}
				stack.pop();
			} else
				postfix += infix[index] + " ";
		}

		while (!stack.empty()) {
			postfix += stack.top.data;
			stack.pop();
		}
		
		return postfix;
	}

	/**
	 * This method is used to evaluate expression.
	 * @param operand1 , This going to be evaluate.
	 * @param operand2 , This going to be evaluate.
	 * @param operator , This operator use for evaluate.
	 * @return, This return evaluate integer.
	 */
	int evaluate(int operand1, int operand2, String operator) {

		switch (operator) {

		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;

		case "*":
			return operand1 * operand2;

		case "/":
			return operand1 / operand2;

		case ">":
			return (operand1 > operand2) ? 1 : 0;

		case "<":
			return (operand1 < operand2) ? 1 : 0;

		case ">=":
			return (operand1 >= operand2) ? 1 : 0;

		case "<=":
			return (operand1 <= operand2) ? 1 : 0;

		}
		return 0;

	}

	/**
	 * This method is used to evaluate postfix expression.
	 * @param expression , this going to be evaluate.
	 * @return, this return integer value of expression.
	 */
	public String evaluatePostfix(String expression) {

		String postfix = infixToPostfix(expression);
		Stack operands = new Stack();
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int index = 0; index < splittedString.length; index++) {
			
			if (map.containsKey(splittedString[index])) {
				operand1 = Integer.parseInt(operands.top.data);
				operands.pop();
				operand2 = Integer.parseInt(operands.top.data);
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1, splittedString[index]))));
			} else {

				operands.push(splittedString[index]);
			}
		}
		return operands.top.data;
	}

	/**
	 * This method is used to evaluate postfix expression.
	 * @param expression, this going to be evaluate.
	 * @return, this return boolean value of expression.
	 */
	public boolean evaluatePostfixForLogical(String expression) {

		String postfix = infixToPostfix(expression);
		Stack operands = new Stack();
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int index = 0; index < splittedString.length; index++) {
			
			if (map.containsKey(splittedString[index])) {
				operand1 = Integer.parseInt(operands.top.data);
				operands.pop();
				operand2 = Integer.parseInt(operands.top.data);
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,splittedString[index]))));
			} else {

				operands.push(splittedString[index]);
			}
		}
		return ("1".equals(operands.top.data)) ? true : false;
	}

}
