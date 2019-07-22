import static org.junit.Assert.*;

import org.junit.Test;


public class OperationsOnStringsTest {

	
      OperationsOnStrings	operationOnString = new OperationsOnStrings();


     @Test(expected = AssertionError.class)
     public void compareTwoStringTest_exceptionExpected() {
		assertEquals(-3,operationOnString.compareTwoString("","ajdy"));
    }	
		
	@Test
	public void compareTwoStringTest() {
		assertEquals(-3,operationOnString.compareTwoString("ajay","ajdy"));
		assertEquals(3,operationOnString.compareTwoString("ajdy","ajay"));
		assertEquals(0,operationOnString.compareTwoString("ajay","ajay"));
	}
	
   @Test(expected = AssertionError.class)
     public void reverseStringTest_exceptionExpected() {
		assertEquals("a",operationOnString.reverseString(""));
    }	
    
    
	@Test
	public void reverseStringTest() {
		assertEquals("yaja",operationOnString.reverseString("ajay"));
		assertEquals("gnirtS",operationOnString.reverseString("String"));
		assertEquals("FCS",operationOnString.reverseString("SCF"));
	}
	
	@Test(expected = AssertionError.class)
     public void changedString_exceptionExpected() {
		assertEquals("a",operationOnString.changedString(""));
    }
    
    @Test
	public void changedStringTest() {
		assertEquals("mOdULE",operationOnString.changedString("MoDule"));
		assertEquals("sTRING",operationOnString.changedString("String"));
		assertEquals("scf",operationOnString.changedString("SCF"));
	}
	
		@Test(expected = AssertionError.class)
     public void findLargestString_exceptionExpected() {
		assertEquals("a",operationOnString.findLargestString(""));
    }
    
    @Test
	public void findLargestStringTest() {
		assertEquals("shringi",operationOnString.findLargestString("My name is ajay shringi"));
		assertEquals("session",operationOnString.findLargestString("scf session"));
	}
    
	
}	
	