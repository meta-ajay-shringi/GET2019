import java.util.Scanner;

/*
 * This class is used to calculate average of grade, maximum grade,
 * minimum grade and percentage of passing student.
 */
public class MarkSheet {

	/*
	 * This method is used to calculate average of all grades.
	 * @param numberOfStudent this is number of student in class.
	 * @param gradesOfStudent This is array of grades of n number of student.
	 * @return double This return average of all grades.
	 */
	public static double averageOfGrades(int numberOfStudent,
			int gradesOfStudent[]) {
		double average = 0;
		for (int index = 0; index < numberOfStudent; index++) {
			average = average + gradesOfStudent[index];
		}

		average = average / numberOfStudent;

		average = Math.round((average * 100) / 100);

		return average;
	}

	/*
	 * This method is used to calculate maximum of all grades.
	 * @param numberOfStudent this is number of student in class.
	 * @param gradesOfStudent This is array of grades of n number of student.
	 * @return int This return maximum of all grades.
	 */
	public static int maximumGrade(int numberOfStudent, int gradesOfStudent[]) {
		int maximum = 0;

		for (int index = 0; index < numberOfStudent; index++) {
			if (gradesOfStudent[index] > maximum) {
				maximum = gradesOfStudent[index];
			}
		}
		return maximum;
	}

	/*
	 * This method is used to calculate minimum of all grades.
	 * @param numberOfStudent this is number of student in class.
	 * @param gradesOfStudent This is array of grades of n number of student.
	 * @return int This return minimum of all grades.
	 */
	public static int minimumGrade(int numberOfStudent, int gradesOfStudent[]) {
		int minimum = 101;

		for (int index = 0; index < numberOfStudent; index++) {
			if (gradesOfStudent[index] < minimum) {
				minimum = gradesOfStudent[index];
			}
		}
		return minimum;
	}

	/*
	 * This method is used to calculate percentage of students passed.(Assume
	 * grade >= 40 as Pass)
	 * @param numberOfStudent this is number of student in class.
	 * @param gradesOfStudent This is array of grades of n number of student.
	 * @return double This Return percentage of students passed.
	 */
	public static double percentageOfPassedStudent(int numberOfStudent,
			int gradesOfStudent[]) {
		double percentage;
		double numberOfPassedStudent = 0;

		for (int index = 0; index < numberOfStudent; index++) {
			if (gradesOfStudent[index] >= 40) {
				numberOfPassedStudent++;
			}
		}

		percentage = (numberOfPassedStudent / numberOfStudent) * 100;

		percentage = Math.round((percentage * 100) / 100);
		return percentage;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter number of student in class ");
		int numberOfStudent = in.nextInt();
		System.out.println("please enter grades of student ");

		int[] gradesOfStudent = new int[100];

		int grade;

		for (int index = 0; index < numberOfStudent; index++) {
			System.out.println("Gread of student " + index + " is ");
			grade = in.nextInt();
			gradesOfStudent[index] = grade;
		}

		System.out.println("Average of grade is " + averageOfGrades(numberOfStudent, gradesOfStudent));
		System.out.println("maximum grade = " + maximumGrade(numberOfStudent, gradesOfStudent));
		System.out.println("minimum grade = " + minimumGrade(numberOfStudent, gradesOfStudent));
		System.out.println("percentage Of Passed Student = " + percentageOfPassedStudent(numberOfStudent, gradesOfStudent));
		in.close();
	}

}
