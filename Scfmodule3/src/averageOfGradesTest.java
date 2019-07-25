import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class averageOfGradesTest {

	private int[] inputArray;
	private int expectedResult;
	private int numberOfStudent;
	private MarkSheet markSheet;

	@Before
	public void initialize() {
		markSheet = new MarkSheet();
	}

	public averageOfGradesTest(int expectedResult,int numberOfStudent, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.numberOfStudent = numberOfStudent;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 30,5, new int[] { 10,20,30,40,50 } },
				{ 1,6,new int[] { 1, 1, 1, 1, 1,1 } },
				{ 10,4, new int[] { 10, 10, 10, 10 } } });
	}

	@Test
	public void averageOfGradesTest() {
		assertEquals(expectedResult,(int) markSheet.averageOfGrades(numberOfStudent,inputArray));
	}
}