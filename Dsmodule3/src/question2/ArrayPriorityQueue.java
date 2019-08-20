package question2;

/**
 * This class is for Priority Queue Operations.
 */
public class  ArrayPriorityQueue  implements PriorityQueue{

	private final int front = 1;
	private int rear;
	private int capacityOfQueue;
	private int[] queueArray;

	/**
	 * constructor for ArrayPriorityQueue
	 * @param capacity is max items in queue
	 */
	public ArrayPriorityQueue( int capacity){
		this.rear = 0;
		this.capacityOfQueue = capacity + 1;
		this.queueArray = new int[capacity + 1];
		this.queueArray[0] = Integer.MAX_VALUE;
	}
	
	/**
	 * This method used to insert an element
	 * @data data to be entered
	 */
	@Override
	public void enQueue(int data) {

		if( rear + 1 == capacityOfQueue){
			assert( rear + 1 == capacityOfQueue) : " Queue is full !! Can't Added";
			return;
		}else{
			queueArray[++rear] = data;
			int position = rear;
			
			while(position / 2 != 0) {
				if( queueArray[position / 2] < queueArray[position] ) {
					
					int tempValue = queueArray[position / 2];
					queueArray[position / 2] = queueArray[position];
					queueArray[position] = tempValue;
					position = position / 2;
				}else {
					break;
				}
			}
		}
	}
	
	/**
	 * This method used to delete and find out highest Priority Element from the Queue.
	 * @return return removed data
	 */
	@Override
	public int deQueue() {
		int poppedData = Integer.MIN_VALUE;
		if(isEmpty()){
			return poppedData;
		}else{
			poppedData = queueArray[front];
			queueArray[1] = queueArray[rear--];
			
			int index = 1;

			while( (2*index <= rear ) && (queueArray[index * 2] > queueArray[index] || queueArray[index * 2 + 1] > queueArray[index])) {
				
				// left child greater than right child
				if( queueArray[ index * 2] > queueArray[ index * 2 + 1]) {
					int tempValue = queueArray[ index * 2 ];
					queueArray[ index * 2 ] = queueArray[ index ];
					queueArray[index] = tempValue;
					index = index * 2;
				}
				else if( queueArray[ index * 2 + 1] >= queueArray[ index * 2 ]) {
					int temp = queueArray[ index * 2 + 1 ];
					queueArray[ index * 2 + 1 ] = queueArray[ index ];
					queueArray[index] = temp;
					index = index * 2 + 1;
				}
			}
		}
		return poppedData;
	}
	
	/**
	 * This method used to know that PriorityQueue is empty or not
	 * @return true if empty otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return (rear == 0);		
	}

	/**
	 * This method used to get Most Priority Value
	 * @return Most Priority Value
	 */
	@Override
	public int firstElement() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return queueArray[front];
	}
	
	/**
	 * This method used to get size of Queue
	 * @return Queue Size
	 */
	@Override
	public int queueSize() {
		return rear;
	}
	
	public String toString() {
		String printString = "{";
		for(int i=front;i<=rear;i++) {
			printString += queueArray[i] + " ,";
		}
		printString += "}";
		
		return printString;
	}
}
