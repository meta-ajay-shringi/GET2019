

/**
 * This class is used to create Stack.
 */
public class LinkedListStack<T> implements Stack<T> {

	public Node top;

	/**
	 * This method is used to push data in stack.
	 * @param data , data to be push.
	 */
	public void push(T data) {

		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;

	}

	/**
	 * This method is used to remove data from stack.
	 */
	public T pop() {

		if (top == null) {
			System.out.println("stack is empty");
			return null;
		}

		Node current = top;
		top = top.next;
		current.next = null;
		
		return (T) current.data;
	}

	/**
	 * Check stack is empty or not.
	 * @return if empty then true else false.
	 */
	public boolean isEmpty() {
		
		return (top == null);
	}



}
