package question1;

/**
 * This class is used to create Stack.
 */
public class Stack {

	public Node top;

	/**
	 * This method is used to push data in stack.
	 * @param data , data to be push.
	 */
	public void push(String data) {

		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;

	}

	/**
	 * This method is used to remove data from stack.
	 */
	public void pop() {

		if (top == null) {
			System.out.println("stack is empty");
			return;
		}

		Node current = top;
		top = top.next;
		current.next = null;
	}

	/**
	 * Check stack is empty or not.
	 * @return if empty then true else false.
	 */
	public boolean empty() {
		boolean flag = false;
		if (top == null)
			flag = true;
		else
			flag = false;
		return flag;
	}

}
