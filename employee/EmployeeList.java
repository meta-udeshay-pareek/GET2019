package employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	
	//List of Employees
	List<Employee> listOfEmployees = new ArrayList<Employee>();
	
	
	/**
	 * adding employee in list
	 * @param emp
	 * */
	public void add(Employee emp) {
		listOfEmployees.add(emp);
	}
	
	
	/**
	 * @param index
	 * @return Employee at given index
	 * */
	public Employee get(int index) {
		return listOfEmployees.get(index);
	}

	
	/**

	 * @return ListOfEmployees
	 * */
	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	
	/**
	 * @return ListOfEmployees In string Format so that user can ue it for printing purpose
	 * */
	public String getListOfEmployeesInStringForm() {
		return listOfEmployees.toString();
	}
}
