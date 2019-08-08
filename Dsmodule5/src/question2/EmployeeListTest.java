package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods of EmployeeList class.
 */
public class EmployeeListTest {
	
	@Test
	public void test1()
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNode(30000, 30, "A");
		employeeList.addNode(30000, 40, "B");
		employeeList.addNode(30000, 25, "C");
		employeeList.addNode(10000, 22, "D");
		
		employeeList.sortEmployeeList();
		
		assertEquals("C", employeeList.sortedLinkedListHead.getEmployeeName());
	}

	@Test
	public void test2()
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNode(20000, 30, "A");
		employeeList.addNode(30000, 40, "B");
		employeeList.addNode(30000, 25, "C");
		employeeList.addNode(10000, 22, "D");
		employeeList.addNode(30000, 20, "E");
		
		employeeList.sortEmployeeList();
		
		assertEquals("E", employeeList.sortedLinkedListHead.getEmployeeName());
	}
}
