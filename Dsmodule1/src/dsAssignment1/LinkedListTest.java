package dsAssignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

/**
 * This is test class for rotateList and detect loop.
 */
public class LinkedListTest {

	@Test
	public void rotateListTest() {
		
		LinkedList linkedList = new LinkedList();
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		
		LinkedList expected = new LinkedList();
		expected.insert(2);
		expected.insert(5);
		expected.insert(6);
		expected.insert(3);
		expected.insert(4);
		expected.insert(7);
		
		linkedList.rotateList(2, 5, 2);
		
		for(int index = 0; index < linkedList.size() - 1; index++){
			assertEquals(expected.get(index), linkedList.get(index));
		}
	
	}
	
	
	/**
	 * negative test case when right index > linkedlist size.
	 */
	@Test(expected = AssertionError.class)
	public void rotateListTest_exception() {
		
		LinkedList linkedList = new LinkedList();
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		
		LinkedList expected = new LinkedList();
		expected.insert(2);
		expected.insert(5);
		expected.insert(6);
		expected.insert(3);
		expected.insert(4);
		expected.insert(7);
		
		linkedList.rotateList(2, 8, 2);
		
		for(int index = 0; index < linkedList.size() - 1; index++){
			
			assertEquals(expected.get(index), linkedList.get(index));
		}	
	}
	
	@Test
	public void detectLoopTest() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.createLoop(2);
		
		assertTrue(linkedList.detectLoop());
	}
	
	@Test
	public void detectLoopTest1() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		assertFalse(linkedList.detectLoop());
	}
	

}
