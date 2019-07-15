import java.util.Scanner;

/*
 * This class used to calculate turn around time, waiting time and completion time 
 * for each process and also calculate average waiting time and maximum waiting time of process.  
 */
public class JobScheduler {

	/*
	 * This method is used to calculate completion time of processes which is.
	 * Time taken for the execution to complete, starting from arrival time of
	 * first process.
	 * @param array this is of arrival time and burst time.
	 * @param numberOfPerson this is number of person in this processes.
	 * @return int This return completion time for each processes.
	 */
	public static int[] calcCompletionTime(int array[][], int numberOfPerson) {
		int[] completionTimeArray = new int[numberOfPerson];
		int[] startingTime = new int[numberOfPerson];

		startingTime[0] = array[0][0];
		completionTimeArray[0] = array[0][1];

		for (int indexOfArrivalTime = 1; indexOfArrivalTime < numberOfPerson; indexOfArrivalTime++) {
			for (int indexOfBurstTime = 0; indexOfBurstTime < 1; indexOfBurstTime++) {
				if (array[indexOfArrivalTime][indexOfBurstTime] > completionTimeArray[indexOfArrivalTime - 1]) {
					startingTime[indexOfArrivalTime] = array[indexOfArrivalTime][indexOfBurstTime];
				} else {
					startingTime[indexOfArrivalTime] = completionTimeArray[indexOfArrivalTime - 1];
				}

			}

			completionTimeArray[indexOfArrivalTime] = startingTime[indexOfArrivalTime]
					+ array[indexOfArrivalTime][1];
		}

		return completionTimeArray;
	}

	/*
	 * This method is used to calculate turn around time of processes which is
	 * Time taken to complete after arrival. In simple words, it is the
	 * difference between the Completion time and the Arrival time.
	 * @param array This is of arrival time and burst time.
	 * @param completionTime This is completion time of each processes
	 * @param numberOfPerson This is number of person in this processes.
	 * @return int This return completion time for each processes.
	 */
	public static int[] calcTurnAroundTime(int array[][], int completionTime[],
			int numberOfPerson) {
		int[] turnAroundTimeArray = new int[numberOfPerson];

		for (int index = 0; index < numberOfPerson; index++) {

			turnAroundTimeArray[index] = completionTime[index]
					- array[index][0];
		}

		return turnAroundTimeArray;
	}

	/*
	 * This method is used to calculate waiting time of process which is Total
	 * time the process has to wait before it's execution begins. It is the
	 * difference between the Turn Around time and the Burst time of the
	 * process.
	 * @param array This is of arrival time and burst time.
	 * @param turnAroundTime This is turn around time for each process.
	 * @param numberOfPerson This is number of person in this process.
	 * @return int This return waiting time for each process.
	 */
	public static int[] calcWaitingTime(int array[][], int turnAroundTime[],
			int numberOfPerson) {
		int[] waitingTimeArray = new int[numberOfPerson];

		for (int index = 0; index < numberOfPerson; index++) {

			waitingTimeArray[index] = turnAroundTime[index] - array[index][1];
		}

		return waitingTimeArray;
	}

	/*
	 * This method is used to calculate average waiting time of process.
	 * @waitingTime This is waiting time for each process.
	 * @numberOfPerson This is number of person in this process.
	 * @return int This return average waiting time of process.
	 */
	public static int calcAverageWaitingTime(int waitingTime[],
			int numberOfPerson) {
		int average = 0;

		for (int index = 0; index < numberOfPerson; index++) {
			average = average + waitingTime[index];
		}

		return (average / numberOfPerson);
	}

	/*
	 * This method is used to calculate maximum waiting time of process.
	 * @waitingTime This is waiting time for each process.
	 * @numberOfPerson This is number of person in this process.
	 * @return int This return maximum waiting time of process.
	 */
	public static int calcMaximumWaitingTime(int waitingTime[],
			int numberOfPerson) {
		int maximum = 0;

		for (int index = 0; index < numberOfPerson; index++) {
			if (waitingTime[index] > maximum) {
				maximum = waitingTime[index];
			}
		}

		return maximum;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[][] array = new int[100][100];
		int numberOfPerson;
		System.out.println("Please enter number of Person");
		numberOfPerson = in.nextInt();
		int time;

		for (int indexOfArrivalTime = 0; indexOfArrivalTime < numberOfPerson; indexOfArrivalTime++) {
			for (int indexOfBurstTime = 0; indexOfBurstTime < 2; indexOfBurstTime++) {
				time = in.nextInt();
				array[indexOfArrivalTime][indexOfBurstTime] = time;
			}
		}

		int[] completionTime = new int[numberOfPerson];
		int[] turnAroundTime = new int[numberOfPerson];
		int[] waitingTime = new int[numberOfPerson];

		completionTime = calcCompletionTime(array, numberOfPerson);
		turnAroundTime = calcTurnAroundTime(array, completionTime,numberOfPerson);
		waitingTime = calcWaitingTime(array, turnAroundTime, numberOfPerson);

		System.out.println("arrival time \t burst time \t completion time\t TurnAround time\t Waiting Time");

		for (int index = 0; index < numberOfPerson; index++) {
			System.out.println("  " + array[index][0] + "\t\t\t" + array[index][1] + "\t\t  " + completionTime[index] + "\t\t   " + turnAroundTime[index] + "\t\t\t" + waitingTime[index]);
		}

		int averageWaitingTime = calcAverageWaitingTime(waitingTime,numberOfPerson);
		System.out.println("Average waiting time of process is " + averageWaitingTime);

		int maximumWaitingTime = calcMaximumWaitingTime(waitingTime,numberOfPerson);
		System.out.println(" Maximum waiting time of process is " + maximumWaitingTime);
		in.close();
	}

}
