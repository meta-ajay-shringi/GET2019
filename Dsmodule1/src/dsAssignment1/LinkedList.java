package dsAssignment1;

/**
 * This class implementation of a linked list with method for create and detect
 * loop.
 */
public class LinkedList {

	public Node head = null;

	/**
	 * This method is used to insert data in linked list.
	 * @param data, data to be insert.
	 */
	public void insert(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} 
		else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		return;
	}

	/**
	 * This method is used to calculate size of linked list.
	 * @return, this return size of linked list.
	 */
	public int size() {
		
		int count = 0;
		Node current = head;
		
		while (current != null) {
			count++;
			current = current.next;
		}
		
		return count;
	}

	/**
	 * This method is used to get value at index.
	 * @param index, where we want value.
	 * @return, This return data at index.
	 */
	public int get(int index) {
		
		assert (index > 0 && index < this.size()) : " index should be in range ";
		Node current = head;
		int count = 0;
		
		while (count < index) {
			current = current.next;
			count++;
		}
		
		return current.data;
	}

	/**
	 * This method is used to rotate list in clockwise direction.
	 * @param leftIndex, starting index where we begin rotation.
	 * @param rightIndex, ending index where we end rotation.
	 * @param numberOfRotation, number of rotation.
	 * @return, This return linked list after performing rotation.
	 */
	public LinkedList rotateList(int leftIndex, int rightIndex, int numberOfRotation) {

		assert (leftIndex > 0 && rightIndex > 0 && rightIndex < this.size()) : " position should be in range ";
		assert (numberOfRotation > 0) : " number of rotation should be grater then 0 ";

		numberOfRotation = numberOfRotation % (rightIndex - leftIndex + 1);
		if (numberOfRotation == 0)
			return this;

		Node leftPrevNode = null;
		Node leftNode = null;
		Node linkedNode = null;
		Node rightPrevNode = null;
		Node rightNode = null;
		Node lastNode = null;
		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			if (count == leftIndex - 1)
				leftPrevNode = current;
			if (count == leftIndex)
				leftNode = current;
			if (count == leftIndex + numberOfRotation - 1)
				linkedNode = current;
			if (count == leftIndex + numberOfRotation)
				rightPrevNode = current;
			if (count == rightIndex)
				rightNode = current;
			if (count == rightIndex + 1)
				lastNode = current;

			current = current.next;
		}

		if (leftPrevNode == null)
			head = rightPrevNode;
		else
			leftPrevNode.next = rightPrevNode;

		rightNode.next = leftNode;
		linkedNode.next = lastNode;

		return this;
	}

	/**
	 * This method is used to create loop in linked list.
	 * @param position , loop from end to position.
	 * @return, This return linked list after creating loop.
	 */
	public LinkedList createLoop(int position) {

		assert (position > 0 && position < this.size()) : " position should be in range ";

		Node current = head;
		int count = 0;
		Node loopNode = null;
		
		while (current.next != null) {
			count++;
			if (count == position)
				loopNode = current;

			current = current.next;
		}

		current.next = loopNode;
		return this;
	}

	/**
	 * This method is used to detect loop in linked list.
	 * @return, This return true if loop present else false.
	 */
	public boolean detectLoop() {

		Node fastNode = head;
		Node slowNode = head;

		while (slowNode != null && fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;

			if (fastNode == slowNode)
				return true;
		}
		
		return false;
	}

}
