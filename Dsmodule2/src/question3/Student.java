package question3;

/**
 *  This class is used to deffine student name and program.
 */
public class Student {
	
	String name;
	String program1;
	String program2;
	String program3;
	String program4;
	String program5;
	
	/**
	 * This is student class constructor.
	 * @param name, name of student.
	 * @param program1, 1th choice of student.
	 * @param program2, 2nd choice of student.
	 * @param program3, 3rd choice of student.
	 * @param program4, 4th choice of student.
	 * @param program5, 5th choice of student.
	 */
	Student(String name,String program1,String program2,String program3,String program4,String program5) {
		
		this.name = name;
		this.program1 = program1;
		this.program2 = program2;
		this.program3 = program3;
		this.program4 = program4;
		this.program5 = program5;
	}

}
