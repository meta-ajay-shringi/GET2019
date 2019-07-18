import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void testCountClumps_exceptionExpected() { // assertion error in case array is empty.

		int inputArray1[] = {};
		assertEquals(2, ArrOperation.countClumps(inputArray1));
	}

	@Test
	public void testCountClumps() {

		int[] inputArray1 = { 1, 1, 2, 1, 1 };
		assertEquals(2, ArrOperation.countClumps(inputArray1));
		int inputArray2[] = { 1, 2, 2, 3, 4, 4 };
		assertEquals(2, ArrOperation.countClumps(inputArray2));
	}

	@Test
	public void TestlengthOfMirror_exceptionExpected() { // assertion error in case array is empty.

		int[] inputArray = {};
		assertEquals(4, ArrOperation.lengthOfMirror(inputArray));

	}

	@Test
	public void TestlengthOfMirror() {
		int[] inputArray = { 7, 7, 7, 7, 6, 7 };
		assertEquals(4, ArrOperation.lengthOfMirror(inputArray));

	}

	@Test
	public void testSplitArray_exceptionExpected() { // assertion error in case array is empty.

		int inputArray[] = {};
		assertEquals(-1, ArrOperation.splitArray(inputArray));
	}

	@Test
	public void testSplitArray() {
		int inputArray[] = { 2, 1, 1, 2, 1 };
		assertEquals(-1, ArrOperation.splitArray(inputArray));

		int inputArray1[] = { 10, 10 };
		assertEquals(1, ArrOperation.splitArray(inputArray1));

		int inputArray2[] = { 1, 1, 1, 2, 1 };
		assertEquals(3, ArrOperation.splitArray(inputArray2));

		int inputArray3[] = { 3, 2, 4, 3, 4, 3, 3, 1, 1 };
		assertEquals(4, ArrOperation.splitArray(inputArray3));

	}

	@Test
	public void testFixXY_exceptionExpected() { // assertion error in case array is empty.
		int[] input = {};
		int outputExpected[] = { 9, 1, 4 };
		int outputActual[] = ArrOperation.fixXY(input, 4, 5);
		assertArrayEquals(outputExpected, outputActual);

	}

	@Test
	public void testFixXY_exceptionExpected1() { // assertion error in case number of X and Y not equal.
		int[] input1 = { 5, 5, 5, 4, 9, 4, 1 };
		int outputExpected1[] = { 9, 1, 5, 4, 5, 4, 5 };
		int outputActual1[] = ArrOperation.fixXY(input1, 4, 5);
		assertArrayEquals(outputExpected1, outputActual1);
	}

	@Test
	public void testFixXY_exceptionExpected2() { // assertion error in case two adjacents X.
		int[] input2 = { 5, 4, 4, 3, 5, 1 };
		int outputExpected2[] = { 5, 4, 4, 3, 1, 5 };
		int outputActual2[] = ArrOperation.fixXY(input2, 4, 5);
		assertArrayEquals(outputExpected2, outputActual2);
	}

	@Test
	public void testFixXY_exceptionExpected3() { // assertion error in case X occurs at the last index of array.
		int[] input3 = { 4, 5, 5, 4 };
		int outputExpected3[] = { 4, 5, 5, 4 };
		int outputActual3[] = ArrOperation.fixXY(input3, 4, 5);
		assertArrayEquals(outputExpected3, outputActual3);
	}

	@Test
	public void testFixXY() {
		int[] input = { 5, 1, 4, 9, 4, 5 };
		int outputExpected[] = { 9, 1, 4, 5, 4, 5 };
		int outputActual[] = ArrOperation.fixXY(input, 4, 5);
		assertArrayEquals(outputExpected, outputActual);
	}

}
