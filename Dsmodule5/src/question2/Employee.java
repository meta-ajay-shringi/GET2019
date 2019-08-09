package question2;
/**
 * Class for representing Employee node
 */
public class Employee {

	int employeeAge;
	String employeeName;
	double employeeSalary;
	Employee next;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param data
	 */
	public Employee(String employeeName,int employeeAge ,double employeeSalary)
	{
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.next = null;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Employee getNext() {
		return next;
	}
	
	public double getEmployeeSalaray() {
		return employeeSalary;
	}
	
}
