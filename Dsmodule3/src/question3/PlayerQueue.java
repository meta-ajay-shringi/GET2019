package question3;
/**
 * This class is for priority Queue Operations.
 */
public class  PlayerQueue  implements PriorityQueue{
	
	private final int front = 1 ;
	private int rear ;
	private int noOfBowler ;
	private Player[] queueArray;
	
	/**
	 * constructor for playerQueue
	 * @param capacity is max items in queue
	 */
	public PlayerQueue( int capacity){
		this.rear = 0;
		this.noOfBowler = capacity;
		this.queueArray = new Player[capacity + 1];
		this.queueArray[0] = new Player("", Integer.MAX_VALUE);
	}

	@Override
	public void enQueue(Player data) {
		if( rear == noOfBowler) {
			assert (rear == noOfBowler) : "Bowler Limit is Full";
			return;
		}else{
			queueArray[++rear] = data;
			int dataIndex = rear;
			while(dataIndex / 2 != 0) {
				if( queueArray[dataIndex / 2].balls < queueArray[dataIndex].balls) {
					Player tempPlayer;
					tempPlayer = queueArray[dataIndex / 2];
					queueArray[dataIndex / 2] = queueArray[dataIndex];
					queueArray[dataIndex] = tempPlayer;
					dataIndex = dataIndex / 2;
				}else{
					break;
				}
			}
		}
	}

	@Override
	public Player deQueue() {
		Player popped = null;
		if(isEmpty()){
			return popped;
		}else{
			popped = queueArray[front];
			queueArray[1] =  queueArray[rear--];
			int index = 1;
			
			while( (2 * index <= rear) && (queueArray[index * 2].balls > queueArray[index].balls || queueArray[index * 2 + 1].balls > queueArray[index].balls)) {	
				if( queueArray[ index * 2].balls > queueArray[ index * 2 + 1].balls) {
					Player temp = queueArray[ index * 2 ];
					queueArray[ index * 2 ] = queueArray[ index ];
					queueArray[index] = temp;
					
					index = index * 2;
				}else{
					Player temp = queueArray[ index * 2 + 1 ];
					queueArray[ index * 2 + 1 ] = queueArray[ index ];
					queueArray[index] = temp;
					index = index * 2 + 1;
				}
			}
		}
		playerRoutine(popped);
		return popped;
	}

	@Override
	public boolean isEmpty() {
		return (rear == 0);
	}
	
	@Override
	public int queueSize() {
		return rear;
	}
	
	private void playerRoutine(Player poppedPlayer){
		poppedPlayer.balls--;
		if(poppedPlayer.balls != 0 ){
			enQueue(poppedPlayer);
		}
	}
}
