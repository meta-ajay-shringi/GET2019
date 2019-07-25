import static org.junit.Assert.*;

import org.junit.Test;

public class MarkSheetTest {

	@Test
	public void averageOfGradesTest() {

		int[] inputArray1 = { 10,20,30,40,50 };
		assertEquals((int) 30, (int)MarkSheet.averageOfGrades(5,inputArray1));
		int inputArray2[] = { 10,10,10,10 };
		assertEquals(10, (int)MarkSheet.averageOfGrades(4,inputArray2));
	}
	
	@Test
	public void maximumGradeTest() {

		int[] inputArray1 = { 10,20,30,40,50 };
		assertEquals(50, MarkSheet.maximumGrade(5,inputArray1));
		int inputArray2[] = { 10,10,10,10 };
		assertEquals(10, MarkSheet.maximumGrade(4,inputArray2));
	}
	
	@Test
	public void minimumGradeTest() {

		int[] inputArray1 = { 10,20,30,40,50 };
		assertEquals(10, MarkSheet.minimumGrade(5,inputArray1));
		int inputArray2[] = { 10,10,10,10 };
		assertEquals(10, MarkSheet.minimumGrade(4,inputArray2));
	}
	
	@Test
	public void percentageOfPassedStudentTest() {

		int[] inputArray1 = { 10,20,30,40,50 };
		assertEquals(40,(int) MarkSheet.percentageOfPassedStudent(5,inputArray1));
		int inputArray2[] = { 10,10,10,50 };
		assertEquals(25, (int)MarkSheet.percentageOfPassedStudent(4,inputArray2));
	}
}