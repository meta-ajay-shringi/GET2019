package question2;

/**
 * This Interface have operations for Queue
 */
interface Queue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	boolean isFull();
	int frontElement();
	int rearElement();
	int queueSize();
	void displayQueue();

}

