package question3;

/**
 * Interface of a priority queue
 */
interface PriorityQueue{
	
	void enQueue(Player data);
	Player deQueue();
	boolean isEmpty();
	int queueSize();

}