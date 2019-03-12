package employee;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class EmployeeTest 
{
	
	
	@Test
    public void testEmployeeSorting() throws Exception{
        Employee e1 = new Employee(1, "A", "chomu");
        Employee e2 = new Employee(2, "AB", "jaipur");
        Employee e3 = new Employee(4, "B", "pratap nagar");
        Employee e4 = new Employee(3, "CD", "seetapura");
        Employee e5 = new Employee(5, "AAA", "git");
      
        EmployeeList employees = new EmployeeList();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        System.out.println("Unsorted List : " + employees.getListOfEmployeesInStringForm());
      
        Collections.sort(employees.getListOfEmployees());      //Sorting by natural order
        assertEquals(e1, employees.get(0));
        assertEquals(e5, employees.get(4));
      
        Collections.sort(employees.getListOfEmployees(), Employee.NameComparator);
        assertEquals(e1, employees.get(0));
        assertEquals(e4, employees.get(4));
        System.out.println("sorted List : " + employees.getListOfEmployeesInStringForm());
      
        Collections.sort(employees.getListOfEmployees(), Employee.IdComparator);
     
        assertEquals(e1, employees.get(0));
        assertEquals(e5, employees.get(4));
      
        
    }
	
	@Test(expected = Exception.class)
	public void testEmployeeCollection() throws Exception {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		
		assertTrue(employeeCollection.add(new Employee(1,"Amit", "Surat")));
		
		//will throw exception as we are inserting duplicate id now
		assertFalse(employeeCollection.add(new Employee(1,"Amit", "Surat")));
	}


}