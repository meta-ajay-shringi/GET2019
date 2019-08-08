package question2;
/**
 * This class represents a node in a linked list.
 */
public class Node {

	double employeeSalary;
	int employeeAge;
	String employeeName;
	Node next;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param data
	 */
	public Node(double employeeSalary, int employeeAge ,String employeeName)
	{
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.next = null;
	}

	public double getEmployeeSalaray() {
		return employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Node getNext() {
		return next;
	}
	
	
}
