
/**
 * This class is used to create a node of linkedlist.
 * @param <T>
 */
public class Node<T> {
	
	T data;
	Node<T> next;
	
	/**
	 * Constructor to initialize the data members of the class.
	 * @param data, put data in linkedlist node.
	 */
	Node(T data) {
		this.data = data;
		this.next = null;
	}

}