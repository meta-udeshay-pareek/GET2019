package employee;
import java.util.HashMap;


public class EmployeeCollection 
{
	//HashMap for stopping duplicasy of Id in Employee List
	HashMap<Integer, Employee> allEmployee = new HashMap<Integer, Employee>();
	
	
	/**
	 * @param employee
	 * @return true
	 * @throws Exception
	 * */
	public boolean add(Employee employee) throws Exception
	{
		if(allEmployee.containsKey(employee.getEmpId()))
			throw new Exception("Employee Already Exists");
		
		allEmployee.put(employee.getEmpId(), employee);
		
		return true;	
	}

	
}
