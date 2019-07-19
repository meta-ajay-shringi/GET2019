import static org.junit.Assert.*;

import org.junit.Test;


public class SearchTest {

	
	Search searchTest = new Search();
	@Test
	public void linearSearchTest() {
		int inputArray[] = {1,5,3,8,9,0};
		assertEquals(5,searchTest.linearSearch(inputArray,0));
		int inputArray1[] = {1,5,3,8,9,0};
		assertEquals(4,searchTest.linearSearch(inputArray1,9));
		
	}
	
	
	@Test(expected = AssertionError.class)
	public void linearSearch_exceptionExpected() { // assertion error in case array is empty.

		int inputArray1[] = {};
		 searchTest.linearSearch(inputArray1,4);
	}
	
	@Test
	public void binarySearchTest() {
		int inputArray[] = {3,5,8,10,64,70,90,100,210};
		assertEquals(-1,searchTest.binarySearch(inputArray,1));
		int inputArray1[] = {3,5,8,10,64,70,90,100,210};
		assertEquals(2,searchTest.binarySearch(inputArray1,8));
		
	}
	
	@Test(expected = AssertionError.class)
	public void binarySearch_exceptionExpected() { // assertion error in case array is empty.

		int inputArray1[] = {};
		 searchTest.binarySearch(inputArray1,4);
	}


}   
