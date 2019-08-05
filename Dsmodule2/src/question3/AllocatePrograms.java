package question3;

import java.util.ArrayList;

/**
 * This class is used to allocate program to student.
 */
public class AllocatePrograms {

	static ArrayList<StudentProgram> studentProgram = new ArrayList<>();

	/**
	 * This method is used to add programs of student in list.
	 */
	static public void addPrograms() {

		while (ExcelRead.studentList.size() > 0) {

			if (ExcelRead.programList.get(ExcelRead.studentList.peek().program1) > 0) {

				studentProgram.add(new StudentProgram(ExcelRead.studentList.peek().name, ExcelRead.studentList.peek().program1));
				ExcelRead.programList.put(ExcelRead.studentList.peek().program1,ExcelRead.programList.get(ExcelRead.studentList.peek().program1) - 1);
			}

			else if (ExcelRead.programList.get(ExcelRead.studentList.peek().program2) > 0) {
				studentProgram.add(new StudentProgram(ExcelRead.studentList.peek().name, ExcelRead.studentList.peek().program2));
				ExcelRead.programList.put(ExcelRead.studentList.peek().program2,ExcelRead.programList.get(ExcelRead.studentList.peek().program2) - 1);

			}

			else if (ExcelRead.programList.get(ExcelRead.studentList.peek().program3) > 0) {

				studentProgram.add(new StudentProgram(ExcelRead.studentList.peek().name, ExcelRead.studentList.peek().program3));
				ExcelRead.programList.put(ExcelRead.studentList.peek().program3,ExcelRead.programList.get(ExcelRead.studentList.peek().program3) - 1);

			}

			else if (ExcelRead.programList.get(ExcelRead.studentList.peek().program4) > 0) {

                studentProgram.add(new StudentProgram(ExcelRead.studentList.peek().name, ExcelRead.studentList.peek().program4));
				ExcelRead.programList.put(ExcelRead.studentList.peek().program4,ExcelRead.programList.get(ExcelRead.studentList.peek().program4) - 1);
			}

			else if (ExcelRead.programList.get(ExcelRead.studentList.peek().program5) > 0) {

				studentProgram.add(new StudentProgram(ExcelRead.studentList.peek().name, ExcelRead.studentList.peek().program5));
				ExcelRead.programList.put(ExcelRead.studentList.peek().program5,ExcelRead.programList.get(ExcelRead.studentList.peek().program5) - 1);

			}

			ExcelRead.studentList.remove();
		}

	}

}