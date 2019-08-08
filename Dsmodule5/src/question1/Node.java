package question1;


/**
 *  This class is used to create a node of bst.
 */
public class Node {
	
	public KeyValuePair data;
	Node leftNode;
	Node rightNode;
	
	/**
	 * Constructor of Node.
	 * @param data, data to be insert.
	 */
	Node(KeyValuePair data) {
		this.data = data;	
	}

}
