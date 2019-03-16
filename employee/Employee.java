package employee;

import java.util.Comparator;

public class Employee implements Comparable<Employee>
{
	
	private int empId;//id of employee
	private String empName;//name of the employee
	private String empAddress;//address of the employee
	
	/**
	 * Constructor
	 * @param empId
	 * @param empName
	 * @param empAddress
	 * */
	public Employee(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	/**
	 * @return empId
	 * */
	public int getEmpId() {
		return empId;
	}
	
	/**
	 * @return empName
	 * */
	public String getEmpName() {
		return empName;
	}
	

	/**
	 * @return empAddress
	 * */
	public String getEmpAddress() {
		return empAddress;
	}
	
	/**
	 * @param empId
	 * */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @param empName
	 * */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @param empAddress
	 * */
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
  

	/**
	 * Comparator based on empLoyee Id
	 * */
	public static final Comparator<Employee> IdComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee e1, Employee e2) {
            return  e1.getEmpId()-e2.getEmpId(); // This will work because age is positive integer
        }
      
    };
  
    /**
	 * Comparator based on empLoyee Name
	 * */
    public static final Comparator<Employee> NameComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee e1, Employee o2) {
        	String empName1 = e1.getEmpName().toUpperCase();
			String empName2 = o2.getEmpName().toUpperCase();
			return empName1.compareTo(empName2);
        }
      
    };

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
    
	
}
